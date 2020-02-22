package com.homework1;
public class GetSetMethods {
	private String wantValue = "";
	private String conString = "";
	private double nearValue = 1000000;
	private String operators = "-*+";
	
	
	public GetSetMethods(String wValue, String cValue) {
		// TODO Auto-generated constructor stub
		this.wantValue = wValue;
		this.conString = cValue;
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

	public void setNearValue(double nearValue) {
		this.nearValue = nearValue;
	}

	public double getNearValue() {
		return nearValue;
	}

	public void setOperators(String operators) {
		this.operators = operators;
	}

	public String getOperators() {
		return operators;
	}
}
