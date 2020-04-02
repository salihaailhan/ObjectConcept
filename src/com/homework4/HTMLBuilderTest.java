package com.homework4;

import java.io.*;
import java.util.*;

public class HTMLBuilderTest {

	public static void main(String[] args) throws Exception {

		new HtmlBuilder().italic().addText("CENG 431");
/*		.lineBreak().unitalic(). 
			bold().addText("Design Pattern ").unbold().
			underline().addText("course is easy ;)").ununderline().paragraph().
			addHyperlink("https://www.coursera.org/learn/design-patterns",
					"MOOC Course link").lineBreak(). addImage("Java.png","Java").
			addOrderedList(new Object[] {"Java", "is", "number", 1, "language :)"}).
			addUnorderedList(new Object[] {"But", "I", "am", 100.0, "sure", "that",
					"C++", "is", "still", "widely", "used"}). addTable(new Object[][] {{1, 5,
					"aha"}, {true, 0, 9}, {null, 19L, "test"}, {'C', "++", 5.0}}). 
			build().exportToFile("builderTest.html");*/
		 
	}

}

class HtmlBuilder {
	/****************************************************************
	 * 14050162001 Gurkay BASYIGIT
	 ****************************************************************/
	static Queue<String> queue = new LinkedList<String>();
	static private HtmlBuilder htmlBuilder = null;

	HtmlBuilder() {

		if (htmlBuilder == null) {

			synchronized (queue) {
				queue.add("");
			}
		}
		
	}
	
	public HtmlBuilder addText(String str) {
		synchronized (queue) {
			queue.add(str);
		}
		return htmlBuilder;
	}
	
	public String italic() {
		synchronized (queue) {
			queue.add("<I>");
		}
		return "";
	}


}
