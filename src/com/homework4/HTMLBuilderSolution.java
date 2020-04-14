package com.homework4;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class HTMLBuilderSolution {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new HtmlBuilderSol().italic().addText("CENG 431").lineBreak().unitalic().bold().addText("Design Pattern ").unbold()
				.underline().addText("course is easy ;)").ununderline().paragraph()
				.addHyperlink("https://www.coursera.org/learn/design-patterns", "MOOC Course link").lineBreak()
				.addImage("Java.png", "Java").addOrderedList(new Object[] { "Java", "is", "number", 1, "language :)" })
				.addUnorderedList(new Object[] { "But", "I", "am", 100.0, "sure", "that", "C++", "is", "still",
						"widely", "used" })
				.addTable(new Object[][] { { 1, 5, "aha" }, { true, 0, 9 }, { null, 19L, "test" }, { 'C', "++", 5.0 } })
				.build().exportToFile("builderTest.html");

		System.out.println("builderTest.html is generated.");
	}

}

class HtmlBuilderSol {
	
	private StringBuilder htmlData = new StringBuilder();

	// HtmlData can be inner-class or can be outside of the HtmlBuilderSol class
	class HtmlData {
		private StringBuilder htmlData;

		HtmlData(StringBuilder htmlData) {
			this.htmlData = htmlData;
		}

		void exportToFile(String fileName) throws Exception {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
			writer.write("<html>\r\n");
			writer.write("<body>\r\n");
			writer.write(htmlData.toString() + "\r\n");
			writer.write("</body>\r\n");
			writer.write("</html>\r\n");
			writer.close();
		}
	}

	HtmlBuilderSol addText(String text) {
		htmlData.append(text);

		return this;
	}

	HtmlBuilderSol lineBreak() {
		htmlData.append("<br>\r\n");

		return this;
	}

	HtmlBuilderSol paragraph() {
		htmlData.append("<p>\r\n");

		return this;
	}

	HtmlBuilderSol bold() {
		htmlData.append("<b>");

		return this;
	}

	HtmlBuilderSol unbold() {
		htmlData.append("</b>");

		return this;
	}

	HtmlBuilderSol italic() {
		htmlData.append("<i>");

		return this;
	}

	HtmlBuilderSol unitalic() {
		htmlData.append("</i>");

		return this;
	}

	HtmlBuilderSol underline() {
		htmlData.append("<u>");

		return this;
	}

	HtmlBuilderSol ununderline() {
		htmlData.append("</u>");

		return this;
	}

	HtmlBuilderSol addOrderedList(Object[] arr) {
		return addOrderedList(Arrays.asList(arr));
	}

	HtmlBuilderSol addOrderedList(List<Object> list) {
		htmlData.append("<ol>");
		for (Object o : list) {
			if (o != null)
				htmlData.append("<li>" + o.toString() + "</li>");
			else
				htmlData.append("<li> </li>");
		}
		htmlData.append("</ol>");

		return this;
	}

	HtmlBuilderSol addUnorderedList(Object[] arr) {
		return addUnorderedList(Arrays.asList(arr));
	}

	HtmlBuilderSol addUnorderedList(List<Object> list) {
		htmlData.append("<ul>");
		for (Object o : list) {
			if (o != null)
				htmlData.append("<li>" + o.toString() + "</li>");
			else
				htmlData.append("<li> </li>");
		}
		htmlData.append("</ul>");

		return this;
	}

	HtmlBuilderSol addTable(Object[][] arr) {
		htmlData.append("<table border=\\\"1\\\">");
		for (Object[] arrRow : arr) {
			htmlData.append("<tr>");

			for (Object o : arrRow) {
				if (o != null)
					htmlData.append("<td>" + o.toString() + "</td>");
				else
					htmlData.append("<td> </td>");
			}

			htmlData.append("</tr>");
		}

		htmlData.append("</table>");

		return this;
	}

	HtmlBuilderSol addHyperlink(String link, String caption) {
		htmlData.append("<a href=\"" + link + "\">" + caption + "</a>");

		return this;
	}

	HtmlBuilderSol addImage(String link, String caption) {
		htmlData.append("<img src=\'" + link + "' alt='" + caption + "'>");

		return this;
	}

	// builds the HtmlData
	HtmlData build() {
		return new HtmlData(htmlData);
	}

}