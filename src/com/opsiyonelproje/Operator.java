package com.opsiyonelproje;

public interface Operator {
	static final int EN_DUSUK = 11;
	static final int DUSUK = 10;
	static final int ORTA = 5;
	static final int YUKSEK = 1;
	static final int PARANTEZ = 0;

	static final char SOL_PARANTEZ = '(';
	static final char SAG_PARANTEZ = ')';

	char tip();

	int oncelik();
}
