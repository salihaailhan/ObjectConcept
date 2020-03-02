package com.has.a.example;

public class IdentityCard {
	static private long identityCounter = 0;
	private long identityNo;

	IdentityCard() {
		identityCounter++;
		identityNo = identityCounter;
	}

	public long getIdentityNumber() {
		return identityNo;
	}
}
