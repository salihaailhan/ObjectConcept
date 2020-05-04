package com.compositepattern;

import java.util.*;
import java.io.*;

public class CompositeHTML {
	public static void main(String[] args) throws IOException {
		// construct HTML document using Composite Pattern
		HtmlDocument doc = new HtmlDocument();

		HtmlNode node1 = new HtmlNode();
		node1.childs.add(new HtmlText("CENG 2010"));
		node1.childs.add(new HtmlLineBreak());
		doc.childs.add(new HtmlItalic(node1));

		doc.childs.add(new HtmlBold(new HtmlText("Object Oriented Programming ")));

		doc.childs.add(new HtmlUnderline(new HtmlText("is easy ;)")));
		doc.childs.add(new HtmlParagraph());

		doc.childs.add(new HtmlHyperlink("http://akademik.gidatarim.edu.tr/~fatihnar/courses.html", new HtmlText("Course link")));
		doc.childs.add(new HtmlLineBreak());

		doc.childs.add(new HtmlImage("Java.png", new HtmlText("Java")));

		doc.childs.add(new HtmlOrderedList(new Object[] { "Java", "is", "number", 1, "language :)" }));

		doc.childs.add(new HtmlUnorderedList(
				new Object[] { "But", "I", "am", 100.0, "sure", "that", "C++", "is", "still", "widely", "used" }));

		doc.childs.add(new HtmlTable(
				new Object[][] { { 1, 5, "aha" }, { true, 0, 9 }, { null, 19L, "test" }, { 'C', "++", 5.0 } }));

		// save HTML document constructed by Composite Pattern
		FileWriter writer = new FileWriter("test.html");
		writer.write(doc.create());
		writer.close();
	}
}

abstract class HtmlTag {
	public String start() {
		return "";
	}

	abstract public String body();

	public String end() {
		return "";
	}

	public String create() {
		return start() + body() + end();
	}
}

class HtmlNode extends HtmlTag {
	final List<HtmlTag> childs = new ArrayList<HtmlTag>();

	@Override
	public String body() {
		StringBuilder sb = new StringBuilder();

		for (HtmlTag tag : childs) {
			sb.append(tag.create());
		}

		return sb.toString();
	}
}

class HtmlDocument extends HtmlNode {

	@Override
	public String start() {
		return "<html>\n" + "<body>\n";
	}

	@Override
	public String end() {
		return "</html>\n" + "</body>\n";
	}

}

class HtmlText extends HtmlTag {
	private String text;

	HtmlText(String text) {
		this.text = text;
	}

	@Override
	public String body() {
		return text;
	}
}

class HtmlLineBreak extends HtmlTag {
	@Override
	public String body() {
		return "<br>";
	}
}

class HtmlParagraph extends HtmlTag {
	@Override
	public String body() {
		return "<p>";
	}
}

class HtmlFontStyle extends HtmlTag {
	final HtmlTag tag;

	HtmlFontStyle(HtmlTag tag) {
		this.tag = tag;
	}

	@Override
	public String body() {
		return tag.create();
	}
}

class HtmlBold extends HtmlFontStyle {
	HtmlBold(HtmlTag tag) {
		super(tag);
	}

	@Override
	public String start() {
		return "<b>";
	}

	@Override
	public String end() {
		return "</b>\n";
	}
}

class HtmlItalic extends HtmlFontStyle {
	HtmlItalic(HtmlTag tag) {
		super(tag);
	}

	@Override
	public String start() {
		return "<i>";
	}

	@Override
	public String end() {
		return "</i>\n";
	}
}

class HtmlUnderline extends HtmlFontStyle {
	HtmlUnderline(HtmlTag tag) {
		super(tag);
	}

	@Override
	public String start() {
		return "<u>";
	}

	@Override
	public String end() {
		return "</u>\n";
	}
}

class HtmlHyperlink extends HtmlTag {
	private String link;
	private HtmlTag caption;

	HtmlHyperlink(String link, HtmlTag caption) {
		this.link = link;
		this.caption = caption;
	}

	@Override
	public String body() {
		return "<a href=\"" + link + "\">" + caption.create() + "</a>\n";
	}

}

class HtmlImage extends HtmlTag {
	private String link;
	private HtmlTag caption;

	HtmlImage(String link, HtmlTag caption) {
		this.link = link;
		this.caption = caption;
	}

	@Override
	public String body() {
		return "<img src=\'" + link + "' alt='" + caption.create() + "'>\n";
	}

}

class HtmlList extends HtmlTag {
	protected List<Object> list;

	HtmlList(List<Object> list) {
		this.list = list;
	}

	HtmlList(Object[] arr) {
		list = Arrays.asList(arr);
	}

	@Override
	public String body() {
		StringBuilder sb = new StringBuilder();

		for (Object o : list) {
			sb.append("  <li>" + o.toString() + "</li>\n");
		}

		return sb.toString();
	}
}

class HtmlOrderedList extends HtmlList {
	HtmlOrderedList(List<Object> list) {
		super(list);
	}

	HtmlOrderedList(Object[] arr) {
		super(arr);
	}

	@Override
	public String create() {
		return "<ol>\n" + body() + "</ol>\n";
	}
}

class HtmlUnorderedList extends HtmlList {
	HtmlUnorderedList(List<Object> list) {
		super(list);
	}

	HtmlUnorderedList(Object[] arr) {
		super(arr);
	}

	@Override
	public String create() {
		return "<ul>\n" + body() + "</ul>\n";
	}
}

class HtmlTable extends HtmlTag {
	private Object[][] arr;

	HtmlTable(Object[][] arr) {
		this.arr = arr;
	}

	@Override
	public String body() {
		StringBuilder sb = new StringBuilder();

		sb.append("<table border=\\\"1\\\">\n");
		for (Object[] arrRow : arr) {
			sb.append("  <tr>");

			for (Object o : arrRow) {
				if (o != null)
					sb.append("<td>" + o.toString() + "</td>");
				else
					sb.append("<td> </td>");
			}

			sb.append("</tr>\n");
		}
		sb.append("</table>\n");

		return sb.toString();
	}

}
