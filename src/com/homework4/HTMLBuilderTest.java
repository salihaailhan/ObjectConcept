package com.homework4;

import java.io.*;

public class HTMLBuilderTest {

	public static void main(String[] args) throws Exception {

		new HtmlBuilder().italic().addText("CENG 431").lineBreak().unitalic(). 
			bold().addText("Design Pattern ").unbold().
			underline().addText("course is easy ;)").ununderline().paragraph().
			addHyperlink("https://www.coursera.org/learn/design-patterns",
					"MOOC Course link").lineBreak(). addImage("Java.png","Java").
			addOrderedList(new Object[] {"Java", "is", "number", 1, "language :)"}).
			addUnorderedList(new Object[] {"But", "I", "am", 100.0, "sure", "that",
					"C++", "is", "still", "widely", "used"}). addTable(new Object[][] {{1, 5,
					"aha"}, {true, 0, 9}, {null, 19L, "test"}, {'C', "++", 5.0}}). 
			build().exportToFile("builderTest.html");
		 
	}

}

class HtmlBuilder {
	/****************************************************************
	 * 14050162001 Gurkay BASYIGIT
	 * source : https://dzone.com/articles/design-patterns-the-builder-pattern
	 ****************************************************************/
	
	private final String BEGIN = "<HTML><BODY>";
	private String text = BEGIN;
	private final String END = "</BODY></HTML>";

	public HtmlBuilder exportToFile(String fileName) {
		
		FileWriter myWrite;
		
		try {
			myWrite = new FileWriter(fileName);
			myWrite.write(this.text);
			myWrite.close();
			System.out.println("File seccessfully wrote to the html file");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
						
		return this;
	}
	
	public HtmlBuilder build() {
		this.text += END;
		HtmlBuilder htmlBuilder = new HtmlBuilder();
		htmlBuilder.text = this.text;					
		return htmlBuilder;
	}
	
	public HtmlBuilder addTable(Object[][] list) {
		this.text += "<TABLE>";
		for(int i=0; i < list.length; i++) {
			this.text += "<TR>";
			for(int j=0; i < list[i].length; i++) {
				this.text += "<TD>" + list[i][j] + "</TD>";	
			}
			this.text += "</TR";
		}
		this.text += "</TABLE>";
		return this;
	}

	public HtmlBuilder addOrderedList(Object[] list) {
		this.text += "<OL>";
		for(int i=0; i < list.length; i++) {
			this.text += "<LI>" + list[i];
		}
		this.text += "</OL>";
		return this;
	}
	
	public HtmlBuilder addUnorderedList(Object[] list) {
		this.text += "<OL type=\"disc\">";
		for(int i=0; i < list.length; i++) {
			this.text += "<LI>" + list[i];
		}
		this.text += "</OL>";
		return this;
	}
	
	public HtmlBuilder addText(String str) {
		this.text += str;
		return this;
	}	
	
	public HtmlBuilder addHyperlink(String lnk, String str) {
		this.text += "<A HREF=\"" + lnk + "\">" + str + "</A>";
		return this;
	}
	
	public HtmlBuilder addImage(String src, String str) {
		this.text += "<IMG SRC=\"" + src + "\" ALT=\"" + str + "\">";
		return this;
	}	
	
	public HtmlBuilder paragraph() {
		this.text += "<P>";
		return this;
	}
	
	public HtmlBuilder underline() {
		this.text += "<U>";
		return this;
	}
	
	public HtmlBuilder ununderline() {
		this.text += "</U>";
		return this;
	}
	
	public HtmlBuilder italic() {
		this.text += "<I>";
		return this;
	}
	
	public HtmlBuilder unitalic() {
		this.text += "</I>";
		return this;
	}
	
	public HtmlBuilder bold() {
		this.text += "<B>";
		return this;
	}
	
	public HtmlBuilder unbold() {
		this.text += "</B>";
		return this;
	}
	
	public HtmlBuilder lineBreak() {
		this.text += "<BR>";
		return this;
	}
}
