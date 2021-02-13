package com.homework11;

import java.util.*;
import java.util.regex.*;

public class ChainOfResponsibilityTest {

	public static void main(String[] args) {

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
		chain.setNextChain(chainSecond);
		chainSecond.setNextChain(chainThird);

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
	public static String conclutionWords;

	String handle(String request, String text) {
		// student code ...
		Words req = new Words(request, text);

		calculate(req);

		return conclutionWords;
	}

	// student code for setNextChain method
	abstract void setNextChain(TextProcessingHandler nextChain);

	abstract void calculate(Words request);

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

	public FilterSmallWords(int numberOfWords) {
		this.numberOfWords = numberOfWords;
	}

	public void setNextChain(TextProcessingHandler nextChain) {

		nextInChain = nextChain;
	}

	public void calculate(Words request) {

		StringBuilder capitalizedString = new StringBuilder();

		if (request.getRequest() == "FilterSmallWords") {

			String str = request.getText();

			String[] splited = str.trim().split("\\s+");

			for (String string : splited) {
				String s1 = string.substring(0, 1).toUpperCase();
				String nameCapitalized = s1 + string.substring(1);
				if (nameCapitalized.length() >= numberOfWords) {
					capitalizedString.append(nameCapitalized);
					capitalizedString.append(" ");
				}
			}

			conclutionWords = capitalizedString.toString().trim();

		} else {

			nextInChain.calculate(request);

		}

	}
}

//student code for CapitalizeCase class
class CapitalizeCase extends TextProcessingHandler {

	private TextProcessingHandler nextInChain;

	public void setNextChain(TextProcessingHandler nextChain) {

		nextInChain = nextChain;

	}

	public void calculate(Words request) {

		StringBuilder capitalizedString = new StringBuilder();
		if (request.getRequest() == "CapitalizeCase") {

			String str = request.getText();

			String[] splited = str.trim().split("\\s+");

			for (String string : splited) {
				String s1 = string.substring(0, 1).toUpperCase();
				String nameCapitalized = s1 + string.substring(1);

				capitalizedString.append(nameCapitalized);
				capitalizedString.append(" ");
			}

			conclutionWords = capitalizedString.toString().trim();

		} else {

			nextInChain.calculate(request);

		}

	}
}

// student code for ReverseWords class
class ReverseWords extends TextProcessingHandler {

	private TextProcessingHandler nextInChain;

	public void setNextChain(TextProcessingHandler nextChain) {

		nextInChain = nextChain;

	}

	public void calculate(Words request) {

		if (request.getRequest() == "ReverseWords") {

			String s[] = request.getText().split(" ");
			String ans = "";
			for (int i = s.length - 1; i >= 0; i--) {
				ans += s[i] + " ";
			}

			conclutionWords = ans.substring(0, ans.length() - 1);

		} else {

			if (nextInChain != null) {

				nextInChain.calculate(request);

			} else {
				conclutionWords = "null";
			}

		}

	}
}
