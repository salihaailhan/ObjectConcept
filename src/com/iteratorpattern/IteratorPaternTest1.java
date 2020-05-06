package com.iteratorpattern;
import java.util.*;
import java.util.stream.*;

// The iterator pattern provides a way to access the elements of an aggregate object
//    Simplifies the interface to the collection
//    Internal implementation (underlying representation) is to be hidden
//    Multiple ways of traversing the collection are possible    
//    Iteration logic is decoupled from the collections internal structure

public class IteratorPaternTest1 {

	public static void main(String[] args) {
		// with for-loop
		System.out.println("With for-loop:");
		Letters letters1 = new Letters('B', 'K');
		for (Character ch : letters1) {
			System.out.print(ch + " ");
		}
		System.out.println("\n");
		
		// with iterator
		System.out.println("With iterator:");
		Letters letters2 = new Letters('F', 'N');
		Iterator<Character> iter = letters2.iterator();  
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println("\n");
		
		// with stream support
		Letters letters3 = new Letters('A', 'K');
		List<Character> result = StreamSupport.stream(
					                Spliterators.spliteratorUnknownSize(letters3.iterator(), Spliterator.ORDERED), false)
					                .collect(Collectors.toList());	
		System.out.println("With streamSupport:");
		System.out.println("Collection size = " + result.size());
		result.forEach(x -> System.out.print(x + " "));		
	}

}


class Letters implements Iterable<Character> {
	private char currentLetter;
	final char lastLetter;
	
	Letters(char firstLetter, char lastLetter) {
		this.lastLetter = lastLetter;
		this.currentLetter = firstLetter;
	}

	@Override
	public Iterator<Character> iterator() {
		return new LetterIterator();
	}

	class LetterIterator implements Iterator<Character> {
		@Override
		public Character next() {
			Character letter = currentLetter;
			currentLetter++;
			return letter;
		}
	
		@Override
		public boolean hasNext() {
			return (currentLetter <= lastLetter);
		}
	}
}


// Videos
// https://www.youtube.com/watch?v=VKIzUuMdmag
// https://www.youtube.com/watch?v=hMQ-Sg_N3xo

// Iterator Pattern, Wiki
// https://en.wikipedia.org/wiki/Iterator_pattern

// Iterator Pattern
// https://www.topjavatutorial.com/design-pattern/iterator-pattern/
// https://howtodoinjava.com/design-patterns/behavioral/iterator-design-pattern/
// https://sourcemaking.com/design_patterns/iterator
// https://www.javaworld.com/article/2461744/java-language-iterating-over-collections-in-java-8.html

// Fruit iterator example
// https://sodocumentation.net/design-patterns/topic/7061/iterator-pattern

// Name iterator example
// https://www.tutorialspoint.com/design_pattern/iterator_pattern.htm

// Book iterator example
// https://blog.miyozinc.com/design-patterns/iterator-pattern/