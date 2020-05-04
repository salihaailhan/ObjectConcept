package com.homework7;

import java.util.ArrayList;
import java.util.List;

public class CompositePatternFoodTest2 {

	public static void main(String[] args) {
	
		MainFood mainFood = new MainFood("Meneme", 170.25, 1);
		SoupFood soupFood = new SoupFood("Ezo Gelin", 100.00, 2);
		DessertFood dessertFood = new DessertFood("Baklava", 500.00, 3);
		
		mainFood.addSubordinate(new MainFood("İskender", 354.00, 4));
		soupFood.addSubordinate(new SoupFood("Mercimek", 35.35, 5));
		dessertFood.addSubordinate(new FoodMenu("Şekerpare", 400.00, 6));
		
		mainFood.sendMenuMessage("Main Food");
		soupFood.sendMenuMessage("Soup");
		dessertFood.sendMenuMessage("Desert");
	}

}

abstract class FoodClass {
	public final String foodName;
	public final double calorie;

	FoodClass(String fName, double cal) {
		this.foodName = fName;
		this.calorie = cal;
	}

	abstract void sendMenuMessage(String message);
}

class FoodMenu extends FoodClass {
	public final int mainMenuID;
	
	FoodMenu(String fName, double cal, int menuID) {
		super(fName, cal);
		this.mainMenuID = menuID;
	}

	@Override
	void sendMenuMessage(String message) {
		System.out.println(message + "\nFood Name : " + foodName + " Calorie: " + calorie);
		
	}	
}

class MainFood extends FoodMenu {
	private final List<FoodMenu> subordinates = new ArrayList<FoodMenu>();

	MainFood(String fName, double cal, int mainMenuID) {
		super(fName, cal, mainMenuID);
	}

	FoodMenu addSubordinate(FoodMenu subordinate) {
		subordinates.add(subordinate);
		return subordinate;
	}

	void removeSubordinated(int mainMenuID) {
		for (FoodMenu foodMenu : subordinates) {
			if (foodMenu.mainMenuID == mainMenuID) {
				subordinates.remove(foodMenu);
				return;
			}
		}
	}

	FoodMenu getSubordinate(int mainMenuID) {
		for (FoodMenu foodMenu : subordinates) {
			if (foodMenu.mainMenuID == mainMenuID) {
				return foodMenu;
			}
		}
		return null;
	}

	@Override
	void sendMenuMessage(String message) {
		System.out.println(message + "\nFood Name : " + foodName + " Calorie: " + calorie);

		for (FoodMenu foodMenu : subordinates) {
			foodMenu.sendMenuMessage(message);
		}
	}

}

class SoupFood extends FoodMenu {
	private final List<FoodMenu> subordinates = new ArrayList<FoodMenu>();

	SoupFood(String fName, double cal, int mainMenuID) {
		super(fName, cal, mainMenuID);
	}

	FoodMenu addSubordinate(FoodMenu subordinate) {
		subordinates.add(subordinate);
		return subordinate;
	}

	void removeSubordinated(int mainMenuID) {
		for (FoodMenu foodMenu : subordinates) {
			if (foodMenu.mainMenuID == mainMenuID) {
				subordinates.remove(foodMenu);
				return;
			}
		}
	}

	FoodMenu getSubordinate(int mainMenuID) {
		for (FoodMenu foodMenu : subordinates) {
			if (foodMenu.mainMenuID == mainMenuID) {
				return foodMenu;
			}
		}
		return null;
	}

	@Override
	void sendMenuMessage(String message) {
		System.out.println(message + "\nFood Name : " + foodName + " Calorie: " + calorie);

		for (FoodMenu foodMenu : subordinates) {
			foodMenu.sendMenuMessage(message);
		}
	}

}

class DessertFood extends FoodMenu {
	private final List<FoodMenu> subordinates = new ArrayList<FoodMenu>();

	DessertFood(String fName, double cal, int mainMenuID) {
		super(fName, cal, mainMenuID);
	}

	FoodMenu addSubordinate(FoodMenu subordinate) {
		subordinates.add(subordinate);
		return subordinate;
	}

	void removeSubordinated(int mainMenuID) {
		for (FoodMenu foodMenu : subordinates) {
			if (foodMenu.mainMenuID == mainMenuID) {
				subordinates.remove(foodMenu);
				return;
			}
		}
	}

	FoodMenu getSubordinate(int mainMenuID) {
		for (FoodMenu foodMenu : subordinates) {
			if (foodMenu.mainMenuID == mainMenuID) {
				return foodMenu;
			}
		}
		return null;
	}

	@Override
	void sendMenuMessage(String message) {
		System.out.println(message + "\nFood Name : " + foodName + " Calorie: " + calorie);

		for (FoodMenu foodMenu : subordinates) {
			foodMenu.sendMenuMessage(message);
		}
	}

}
