package com.iteratorpattern;

import java.util.Iterator;

public class Iterator2DTest {

	public static void main(String[] args) {
		String names[][] = {{"", "", ""},{""},{},{"",""}};

		Array2D arr2d = new Array2D(3, 4);
		arr2d.data[0][0] = "Object";
		arr2d.data[0][1] = "Oriented";
		arr2d.data[0][2] = "Programming";
		arr2d.data[1][0] = "is";
		arr2d.data[2][0] = "Just";
		arr2d.data[2][1] = "fun :)";
		
		for (Object o : arr2d) {
			System.out.println(o);
		}
	}

}

class Array2D implements Iterable {
	public final Object data[][];
	
	Array2D(int rowSize, int colSize) {
		data = new Object[rowSize][colSize];
	}

	@Override
	public Iterator iterator() {
		return new Array2DIterator();
	}
	
	private class Array2DIterator implements Iterator {
		private int index = 0;

		@Override
		public boolean hasNext() {
			return (data.length > 0 && index < data.length * data[0].length);
		}

		@Override
		public Object next() {
			if (hasNext()) {
				int row = index / data[0].length;
				int col = index % data[0].length;
						
				Object obj = data[row][col];
				index++;

				return obj;
			}			
			return null;
		}
		
	}
}