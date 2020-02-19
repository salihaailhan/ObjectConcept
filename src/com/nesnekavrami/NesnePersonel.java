package com.nesnekavrami;
// NesnePersonel.java : Ana sınıf bildirimi
public class NesnePersonel {
	public String adi;   // Sınıf dışından erişilebilir public değişken
	public String soyadi; // Sınıf dışından erişilebilen public değişken
	private int yasi;    // Sadece sınıf içinden erişilebilinen private değişken
	
	public void setBilgi(String cadi, String csoyadi, int cyasi) {
		adi = cadi;
		soyadi = csoyadi;
		yasi = cyasi;		
	}
	
	// Sınıf dışından erişilen public method
	public String getBilgi() {
		return adi + " " + soyadi;
	}
	
	// Sınıf dışından erişilen public method
	public int getPrivBilgi() {
		return yasi;
	}
	
	// Sınıf dışından erişilen public method
	public void yazdirBilgi() {
		System.out.println("Okulumuz personeli: " + getBilgi());
		System.out.println("Yaşı: " + getPrivBilgi());
	}
}
