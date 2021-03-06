package com.homework8;

import java.util.*;

public class TestClass {

	public static void main(String[] args) {
		// world
		World world = new World(new String[] 
			  { "#.#####################",
				"#...####.#............#",
				"#.#......#.########.###",
				"#.#.####.#........#...#",
				"#.#......#.##########.#",
				"#.####................#",
				"#....############...#.#",
				"#.####..###...#.#.###.#",
				"#.............#.#.#.#.#",
				"#.#############.###.#.#",
				"#...................#.#",
				"#####################.#"});
		
		System.out.println(world);

		Location entry = new Location(1, 0);
		Location exit = new Location(21, 11);
		int maximumMovementCount = 10000;
		
		System.out.println("Entry is " + entry);
		System.out.println("Exit is " + exit);
		System.out.println("Maximum allowed movement count to find the exit is " + maximumMovementCount);
		System.out.println();
		
		System.out.println("/************************ TEST ***********************/");

		Calculate calRandomMovement = new RandomMovement(world, entry, exit, maximumMovementCount);
		calRandomMovement.makeCalculate();
		
		Calculate calHeuristicMovement = new HeuristicMovement(world, entry, exit, maximumMovementCount);		
		calHeuristicMovement.makeCalculate();
		
		System.out.println("/************************ TEST ***********************/");
	}
}

abstract class Calculate {
	World world;
	Location entry;
	Location exit;
	int maximumMovementCount;
	int moveCount = -1;
	double explorationProbability = 0.2;
	
	public Calculate(World world, Location entry, Location exit, int maximumMovementCount) {
		this.world = world;
		this.entry = entry;
		this.exit = exit;
		this.maximumMovementCount = maximumMovementCount;		
	}
	
	void makeCalculate() {
		pairCalculate();
		pairMoveCount();
	}
	
	abstract void pairMoveCount();
	abstract void pairCalculate();
}

class RandomMovement extends Calculate {
	
	public RandomMovement(World world, Location entry, Location exit, int maximumMovementCount) {
		super(world, entry, exit, maximumMovementCount);
	}

	@Override
	void pairMoveCount() {
		if(moveCount >= 0) {
			System.out.println("Exit is founded with findPathWithRandomMovement strategy in " + moveCount + " movements.");	
		} else {
			System.out.println("Exit is not founded with findPathWithRandomMovement strategy");
		}		
	}

	@Override
	void pairCalculate() {
		Random rand = new Random(System.currentTimeMillis());
		Location position = new Location(entry);
		for (int k = 0; k < maximumMovementCount; k++) {
			if (position.equals(exit)) {
				this.moveCount = k;
				return;
			}
			Location[] neighbours = position.getNeighbours();

			// random with heuristic movement
			Location candidateLocation = neighbours[rand.nextInt(neighbours.length)];
			if (world.visitable(candidateLocation)) {
				position = candidateLocation;
			}
		}
	}
}

class HeuristicMovement extends Calculate {

	public HeuristicMovement(World world, Location entry, Location exit, int maximumMovementCount) {
		super(world, entry, exit, maximumMovementCount);
	}

	@Override
	void pairMoveCount() {
		if(moveCount >= 0) {
			System.out.println("Exit is founded with findPathWithRandomAndHeuristicMovement strategy in " + moveCount + " movements.");
		} else {
			System.out.println("Exit is not founded with findPathWithRandomAndHeuristicMovement strategy");
		}				
	}

	@Override
	void pairCalculate() {
		Random rand = new Random(System.currentTimeMillis());
		Location position = new Location(entry);
		for (int k = 0; k < maximumMovementCount; k++) {
			if (position.equals(exit)) {
				moveCount = k;
				return;
			}
			Location[] neighbours = position.getNeighbours();

			// random with heuristic movement
			if (rand.nextDouble() < explorationProbability) {
				Location candidateLocation = neighbours[rand.nextInt(neighbours.length)];
				if (world.visitable(candidateLocation)) {
					position = candidateLocation;
				}
			} else {
				int minimumDistance = Integer.MAX_VALUE;
				Location bestNeighbour = null;
				for (Location candidateLocation : neighbours) {
					if (world.visitable(candidateLocation)) {
						int distance = candidateLocation.distanceTo(exit);
						if (distance < minimumDistance) {
							minimumDistance = distance;
							bestNeighbour = candidateLocation;
						}
					}
				}

				if (bestNeighbour != null) {
					position = bestNeighbour;
				}
			}

		}
	}
}

class Location {
	final int x;
	final int y;

	static int[][] neighbourDirections = { { +1, 0 }, { 0, +1 }, { -1, 0 }, { 0, -1 } };

	Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	Location(Location location) {
		this.x = location.x;
		this.y = location.y;
	}

	int distanceTo(Location target) {
		return Math.abs(x - target.x) + Math.abs(y - target.y);
	}

	Location[] getNeighbours() {
		Location[] neighbours = new Location[neighbourDirections.length];
		for (int i = 0; i < neighbourDirections.length; i++) {
			neighbours[i] = new Location(x + neighbourDirections[i][0], y + neighbourDirections[i][1]);
		}

		return neighbours;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (obj == this) {
			return true;
		}

		if (obj instanceof Location) {
			Location locationObject = (Location) obj;
			return (x == locationObject.x && y == locationObject.y);
		} else
			return false;
	}

	@Override
	public String toString() {
		return "P(" + x + ", " + y + ")";
	}
}

class World {
	final String[] grid;

	World(String[] grid) {
		this.grid = grid;
	}

	boolean visitable(Location location) {
		if (location.y >= 0 && location.y < grid.length) {
			String row = grid[location.y];

			if (location.x >= 0 && location.x < row.length())
				return (row.charAt(location.x) == '.');
			else
				return false;
		} else
			return false;
	}

	@Override
	public String toString() {
		String gridWorld = "";
		for (String row : grid) {
			gridWorld += row + "\n";
		}
		return gridWorld;
	}
}

