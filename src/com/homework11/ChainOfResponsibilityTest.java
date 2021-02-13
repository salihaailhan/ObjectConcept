import java.util.*;
import java.util.regex.*;

public class HelloWorld{

<<<<<<< HEAD
=======
     public static void main(String []args){
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

>>>>>>> 0a298641ec27b5bd03622928830d30fd7cd23235
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
<<<<<<< HEAD

	}

	static void sampleExecution(TextProcessingHandler chain, String request, String text) {
=======
     }
     
    static void sampleExecution(TextProcessingHandler chain, String request, String text) {
>>>>>>> 0a298641ec27b5bd03622928830d30fd7cd23235
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
<<<<<<< HEAD

=======
	
	private String conclution;
	List<String> conclutionList = new ArrayList<>();
	
>>>>>>> 0a298641ec27b5bd03622928830d30fd7cd23235
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

<<<<<<< HEAD
			conclutionWords = capitalizedString.toString().trim();
=======
		if (request.getRequest() == "FilterSmallWords") {	

			System.out.println("Conc List : " + request.getText());
>>>>>>> 0a298641ec27b5bd03622928830d30fd7cd23235

		} else {

			nextInChain.calculate(request);

		}

	}
}

//student code for CapitalizeCase class
class CapitalizeCase extends TextProcessingHandler {

	private TextProcessingHandler nextInChain;
    private String capitalizeCase;
    
    StringBuilder capitalizedString = new StringBuilder();
    
	public void setNextChain(TextProcessingHandler nextChain) {

		nextInChain = nextChain;

	}

	public void calculate(Words request) {

		StringBuilder capitalizedString = new StringBuilder();
		if (request.getRequest() == "CapitalizeCase") {
            
            String str = request.getText();
            
            String[] splited = str.trim().split("\\s+");

<<<<<<< HEAD
			String str = request.getText();
=======
            for (String string : splited) {         
                String s1 = string.substring(0, 1).toUpperCase();
                String nameCapitalized = s1 + string.substring(1);

                capitalizedString.append(nameCapitalized);
                capitalizedString.append(" ");
            }
            System.out.println("CapitalizeCase  : " + capitalizedString.toString().trim());
>>>>>>> 0a298641ec27b5bd03622928830d30fd7cd23235

			String[] splited = str.trim().split("\\s+");

			for (String string : splited) {
				String s1 = string.substring(0, 1).toUpperCase();
				String nameCapitalized = s1 + string.substring(1);

<<<<<<< HEAD
				capitalizedString.append(nameCapitalized);
				capitalizedString.append(" ");
			}
=======
		}
		return "CapitalizeCase  : " + capitalizedString.toString().trim();
	}
}
>>>>>>> 0a298641ec27b5bd03622928830d30fd7cd23235

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
