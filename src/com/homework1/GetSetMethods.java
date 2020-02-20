package com.homework1;
public class GetSetMethods {
	private String wantValue = "";
	private int nearValue = 0;
	private String operators = "-*+";
	private String conString = "";
	
	public GetSetMethods(String wValue, int nValue) {
		// TODO Auto-generated constructor stub
		this.wantValue = wValue;
		this.nearValue = nValue;
	}

	public String getConString() {
		return conString;
	}

	public void setConString(String conString) {
		this.conString = conString;
	}

	public void setWantValue(String wantValue) {
		this.wantValue = wantValue;
	}

	public String getWantValue() {
		return wantValue;
	}

	public void setNearValue(int nearValue) {
		this.nearValue = nearValue;
	}

	public int getNearValue() {
		return nearValue;
	}

	public void setOperators(String operators) {
		this.operators = operators;
	}

	public String getOperators() {
		return operators;
	}
}
