package com.optionalproject;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Process {
	LinkedList<Operator> olist = new LinkedList<Operator>();
	LinkedList<Object> elist = new LinkedList<Object>();
	boolean processShown;
	int numberOfParentheses = 0;

	Process(boolean processShown) {
		this.processShown = processShown;
		olist.add(new LeftParentheses());
		olist.add(new RightParentheses());
	}

	boolean addProcessType(Operator opr) {
		return olist.add(opr);
	}

	String operators() {
		String oplist = " ";
		Iterator<Operator> itr = olist.iterator();
		while (itr.hasNext()) {
			Operator opr = itr.next();
			oplist += opr.type();
		}
		return oplist;
	}

	Operator operatorFind(char op) {
		Iterator<Operator> itr = olist.iterator();
		while (itr.hasNext()) {
			Operator opr = itr.next();
			if (opr.type() == op)
				return opr;
		}
		return null;
	}

	int topPriority(int s, int e) {
		int priorityIndex = s;
		int topPriority = Operator.LOWEST;
		for (int i = s; i <= e; i++) {
			Object o = elist.get(i);
			if (o instanceof Operator) {
				Operator oo = (Operator) o;
				if (oo.priority() < topPriority) {
					topPriority = oo.priority();
					priorityIndex = i;
				}
			}
		}
		return priorityIndex;
	}

	void processDoOperation(int s, int e) throws Exception {
		while (s < e) {
			int index = topPriority(s, e);
			Object o1 = elist.get(index - 1);
			Object op = elist.get(index);
			Object o2 = elist.get(index + 1);
			if (o1 instanceof Double && op instanceof Operation && o2 instanceof Double) {
				Double co1 = (Double) o1;
				Operation cop = (Operation) op;
				Double co2 = (Double) o2;
				Double r = cop.doOperation(co1, co2);
				elist.set(index - 1, r);
				elist.remove(index);
				elist.remove(index);
				e -= 2;
			} else
				throw new Exception("Arithmetic expression is invalid!");
			if (processShown)
				System.out.println(toString());
		}
	}

	void simplify() throws Exception {
		if (elist.size() > 1) {
			if (numberOfParentheses > 0) {
				int indeks = 0;
				int leftParentheses = 0;
				int s = 0, e = elist.size() - 1;
				Iterator<Object> itr = elist.iterator();
				while (itr.hasNext()) {
					Object o = itr.next();
					if (o instanceof Operator) {
						Operator op = (Operator) o;
						if (leftParentheses < numberOfParentheses) {
							if (op.type() == Operator.LEFT_PARENTHESES) {
								leftParentheses++;
								if (leftParentheses == numberOfParentheses)
									s = indeks;
							}
						} else {
							if (op.type() == Operator.RIGHT_PARENTHESES) {
								e = indeks;
								break;
							}
						}
					}
					indeks++;
				}
				processDoOperation(s + 1, e - 1);
				elist.remove(s);
				elist.remove(s + 1);
				numberOfParentheses--;
			} else
				processDoOperation(0, elist.size() - 1);
		}
	}

	public String stringDoOperation(int s, int e) {
		String str = "";
		for (int i = s; i <= e; i++)
			str += elist.get(i) + " ";
		return str;
	}

	public String toString() {
		return stringDoOperation(0, elist.size() - 1);
	}

	double processResult(String str) throws Exception {
		elist.clear();
		int leftParentheses = 0;
		int rightParentheses = 0;
		StringTokenizer st = new StringTokenizer(str, operators(), true);
		while (st.hasMoreTokens()) {
			String opstr = st.nextToken();
			if (opstr.equals(" ") == false) {
				Operator opr = operatorFind(opstr.charAt(0));
				if (opr != null) {
					elist.add(opr);
					if (opr.type() == Operator.LEFT_PARENTHESES)
						leftParentheses++;
					if (opr.type() == Operator.RIGHT_PARENTHESES)
						rightParentheses++;
				} else {
					Double number = new Double(opstr);
					elist.add(number);
				}
			}
		}
		if (leftParentheses != rightParentheses)
			throw new Exception("Right and left brackets are not equal!");
		else
			numberOfParentheses = leftParentheses;
		while (elist.size() > 1) {
			if (processShown)
				System.out.println(toString());
			simplify();
		}
		Object v = elist.size() > 0 ? elist.get(0) : null;
		return (v != null && v instanceof Double) ? ((Double) v).doubleValue() : 0.0;
	}
}
