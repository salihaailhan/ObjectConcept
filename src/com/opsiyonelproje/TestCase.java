package com.opsiyonelproje;

public class TestCase {
	public static void main(String[] args) throws Exception {
		IslemIsle ii = new IslemIsle(true);
		ii.islemTipiEkle(new Carpma());
		ii.islemTipiEkle(new Bolme());
		ii.islemTipiEkle(new Toplama());
		ii.islemTipiEkle(new Cikarma());
		String ifade = "((1.5 + 0.5) * (4 - (4 + 2 * 3) / 5.0) + 6) / 2.0";
		System.out.println();
		System.out.println(ifade + " = " + ii.sonuc(ifade));
	}

}
