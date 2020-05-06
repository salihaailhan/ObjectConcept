package com.strategypattern;

import java.util.*;

public class StrategyPatternTest1 {

	public static void main(String[] args) {
		String covid19 = "Coronavirus disease 2019 (COVID-19) is an infectious disease caused by severe acute "
				+ "\nrespiratory syndrome coronavirus 2 (SARS-CoV-2). The disease was first identified in "
				+ "\nDecember 2019 in Wuhan, the capital of China's Hubei province, and has since spread "
				+ "\nglobally, resulting in the ongoing 2019-20 coronavirus pandemic. As of 1 May 2020, "
				+ "\nmore than 3.3 million cases have been reported across 187 countries and territories, "
				+ "\nresulting in more than 235,000 deaths. More than 1.03 million people have recovered.";

		System.out.println(covid19);
		System.out.println();

		// int wordLengthThreshold = 9;
		// WordFilterer wordFilterer = new WordLengthFilterer(wordLengthThreshold);
		TextFilterer textFilterer = new TextFilterer(new WordDigitFilterer());
		List<String> wordList = textFilterer.extractWords(covid19);

		for (String word : wordList) {
			System.out.println(word);
		}
	}

}

class TextFilterer {
	private final WordFilterer wordFilterer;

	TextFilterer(WordFilterer wordFilterer) {
		this.wordFilterer = wordFilterer;
	}

	List<String> extractWords(String text) {
		String[] words = text.split(" ", 0);

		List<String> wordList = new ArrayList<String>();
		for (String word : words) {
			if (wordFilterer.isAccepted(word)) {
				wordList.add(word);
			}
		}

		return wordList;
	}
}

// abstract Strategy class
abstract class WordFilterer {
	abstract boolean isAccepted(String word);
}

// concrete Strategies
class WordLengthFilterer extends WordFilterer {
	final int wordLengthThreshold;

	WordLengthFilterer(int wordLengthThreshold) {
		this.wordLengthThreshold = wordLengthThreshold;
	}

	@Override
	boolean isAccepted(String word) {
		return (word.length() >= wordLengthThreshold);
	}
}

class WordFirstCapitalFilterer extends WordFilterer {
	@Override
	boolean isAccepted(String word) {
		return (word.length() > 1 && word.charAt(0) == word.toUpperCase().charAt(0));
	}
}

class WordDigitFilterer extends WordFilterer {
	@Override
	boolean isAccepted(String word) {
		for (char ch = '0'; ch <= '9'; ch++) {
			if (word.contains("" + ch)) {
				return true;
			}
		}
		return false;
	}
}

// Videos
// https://www.youtube.com/watch?v=-NCgRD9-C6o
// https://www.youtube.com/watch?v=GNoqUfPH7LE

// Strategy Pattern Wiki
// https://en.wikipedia.org/wiki/Strategy_pattern

// Duck example
// https://itewbm.tistory.com/entry/Strategy-Pattern-Head-First-Design-Patterns
// https://www.oreilly.com/library/view/head-first-design/0596007124/ch01.html
// https://www.codiwan.com/posts/design-patterns/strategy-pattern/

// Booking strategy example
// https://www.opencodez.com/java/strategy-design-pattern.htm

// Payment example
// https://www.byteslounge.com/tutorials/java-strategy-pattern-example
// https://www.codingame.com/playgrounds/6521/strategy-design-pattern-java-8
// https://www.journaldev.com/1754/strategy-design-pattern-in-java-example-tutorial

// Discount example
// https://grzegorz2047.github.io/java%20patterns/2017/02/13/strategy-pattern
// https://www.baeldung.com/java-strategy-pattern

// Sorting example
// https://stacktips.com/tutorials/design-patterns/strategy-design-pattern-in-java
// https://www.javaskool.com/strategy-design-pattern/