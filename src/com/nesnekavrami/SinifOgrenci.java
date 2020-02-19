package com.nesnekavrami;
// Cocuk sınıf bildirimi
public class SinifOgrenci extends NesnePersonel {
	public String bolum;
	public String sinif;
	public int okulNo;
	
	// Üst sınıfta geçersiz hale getirilmiş method
	public void setBilgi(String cadi, String csoyadi, int cyasi, String cbolum, String csinif, int cokulNo) {
		super.setBilgi(cadi, csoyadi, cyasi);
		bolum = cbolum;
		sinif = csinif;
		okulNo = cokulNo;
	}
	
	// Üst sınıfta geçersiz hale getirilmiş method
	public void yazdirBilgi() {
		super.yazdirBilgi();
		System.out.println("Öğrencinin bölümü: " + bolum);
		System.out.println("Öğrencinin sınıfı: " + sinif);
		System.out.println("Öğrencinin Okul No: " + okulNo);
	}
}