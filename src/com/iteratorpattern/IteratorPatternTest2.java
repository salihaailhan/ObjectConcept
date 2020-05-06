package com.iteratorpattern;

public class IteratorPatternTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ColorCollection colorCollection = new ColorCollection();
        Iterator iter = colorCollection.createIterator();
        
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
	}

}

abstract class Iterator {
	abstract boolean hasNext();

	abstract Object next();
}

class ColorIterator extends Iterator {

	String[] colors;
	int position = 0;

	public ColorIterator(String[] colors) {
		this.colors = colors;
	}

	@Override
	public boolean hasNext() {
		if (position >= colors.length || colors[position] == null)
			return false;
		else
			return true;
	}

	@Override
	public String next() {
		String color = colors[position];
		position++;
		return color;
	}

}

abstract class IContainer {
    abstract Iterator createIterator();
}

class ColorCollection extends IContainer {
	 
    private String[] colors;
    
    public ColorCollection(){
        colors = new String[3];
        colors[0] = "Red";
        colors[1] = "Green";
        colors[2] = "Blue";
    }
    
    @Override
    public Iterator createIterator() {
        return new ColorIterator(colors);
    }
 
}