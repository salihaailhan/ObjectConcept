package com.homework11;

import java.util.*;
import java.util.regex.*;

public class ChainOfResponsibilityTest {

	public static void main(String[] args) {

//			Input text:
//			-----------
//			I want to increase my grade using makeup homeworks in the Design Patters course
//
//
//			Chain of Responsibility:
//			------------------------
//			FilterSmallWords --> CapitalizeCase --> ReverseWords
//
//
//			Chain of Responsibility sample executions:
//			------------------------------------------
//			CapitalizeCase    	->    I Want To Increase My Grade Using Makeup Homeworks In The Design Patters Course 
//			FilterSmallWords    ->    increase grade using makeup homeworks Design Patters course 
//			TranslateToTurkish	->    null
//			ReverseWords    	->    course Patters Design the in homeworks makeup using grade my increase to want I 

		String text = "I want to increase my grade using makeup homeworks in the Design Patters course";
		System.out.println("Input text:");
		System.out.println("-----------");
		System.out.println(text);
		System.out.println("\n");

//		TextProcessingHandler chain = new FilterSmallWords(5);
//		chain.setNextChain(new CapitalizeCase()).setNextChain(new ReverseWords());

		/*
		 * // below code does the same things with above one.your code should work with
		 * both approaches
		 */ 
		 	TextProcessingHandler chain = new FilterSmallWords(5);
		 	TextProcessingHandler chainSecond = new CapitalizeCase();
		 	TextProcessingHandler chainThird = new ReverseWords();
		 	TextProcessingHandler chainFour = new TranslateToTurkish();
		 	chain.setNextChain(chainSecond); 
		 	chainSecond.setNextChain(chainThird);
		 	chainThird.setNextChain(chainFour);
		 	
		 
		 	

		System.out.println("Chain of Responsibility:");
		System.out.println("------------------------");
		chain.showChain();
		System.out.println("\n");

		System.out.println("Chain of Responsibility sample executions:");
		System.out.println("------------------------------------------");
		sampleExecution(chain, "CapitalizeCase", text);
		sampleExecution(chain, "FilterSmallWords", text);
		sampleExecution(chain, "TranslateToTurkish", text);
		sampleExecution(chain, "ReverseWords", text);
			

	}

	static void sampleExecution(TextProcessingHandler chain, String request, String text) {
		System.out.println(request + "    ->    " + chain.handle(request, text));
	}

}

abstract class TextProcessingHandler {
	// student code ...

	String handle(String request, String text) {
		// student code ...
		Words req = new Words(request, text); 

		return calculate(req);
	}

	// student code for setNextChain method
	abstract void setNextChain(TextProcessingHandler nextChain);
	abstract String calculate(Words request);

	void showChain() {
		// student code ...
		System.out.println("FilterSmallWords --> CapitalizeCase --> ReverseWords");
	}

}

class Words {
	private String request;
	private String text;
	public Words(String request, String text) {
		this.request = request;
		this.text = text;
	}
	
	public String getRequest() {
		return request;
	}

	public String getText() {
		return text;
	}
}

abstract class WordFilterers extends TextProcessingHandler {

	List<String> extractWords(String text) {
		List<String> words = new ArrayList<>();

		Pattern pattern = Pattern.compile("[a-zA-Z]+");
		Matcher matcher = pattern.matcher(text);

		while (matcher.find()) {
			String word = matcher.group();
			words.add(word);
		}

		return words;
	}

}

// student code for FilterSmallWords class
class FilterSmallWords extends TextProcessingHandler {
	private TextProcessingHandler nextInChain;
	private int numberOfWords;
	
	private String conclution;
	List<String> conclutionList = new ArrayList<>();

	WordFilterers wordFilterers;
	
	public FilterSmallWords(int numberOfWords) {
		this.numberOfWords = numberOfWords;
	}

	public void setNextChain(TextProcessingHandler nextChain) {

		nextInChain = nextChain;
	}

	public String calculate(Words request) {

		if (request.getRequest() == "FilterSmallWords") {	
			
			System.out.println("Conc List : " + wordFilterers.extractWords("test"));

		} else {

			nextInChain.calculate(request);

		}
		return conclution;
	}
}

// student code for CapitalizeCase class
class CapitalizeCase extends TextProcessingHandler {
	private TextProcessingHandler nextInChain;

	public void setNextChain(TextProcessingHandler nextChain) {

		nextInChain = nextChain;

	}

	public String calculate(Words request) {

		if (request.getRequest() == "CapitalizeCase") {

			System.out.println("=> Request : " + request);

		} else {

			nextInChain.calculate(request);

		}
		return request.getText();
	}
}

// student code for ReverseWords class
class ReverseWords extends TextProcessingHandler {
	private TextProcessingHandler nextInChain;

	public void setNextChain(TextProcessingHandler nextChain) {

		nextInChain = nextChain;

	}

	public String calculate(Words request) {

		if (request.getRequest() == "ReverseWords") {

			System.out.println("=> Request : " + request);

		} else {

			nextInChain.calculate(request);

		}
		return request.getText();
	}
}

class TranslateToTurkish extends TextProcessingHandler {

	private TextProcessingHandler nextInChain;

	public void setNextChain(TextProcessingHandler nextChain) {

		nextInChain = nextChain;

	}

	public String calculate(Words request) {

		if (request.getRequest() == "TranslateToTurkish") {

			System.out.println("=> Request : " + request);

		} else {

			nextInChain.calculate(request);

		}
		return request.getText();
	}
}
