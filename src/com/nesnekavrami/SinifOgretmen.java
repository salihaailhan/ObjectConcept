package com.nesnekavrami;
// Cocuk sınıf bildirimi
public class SinifOgretmen extends NesnePersonel {
	public String brans;
	public int hizmet;
	
	// Üst sınıfta geçersiz hale getirilmiş method
	public void setBilgi(String cadi, String csoyadi, int cyasi, String cbrans, int chizmet) {
		super.setBilgi(cadi, csoyadi, cyasi);
		brans = cbrans;
		hizmet = chizmet;
	}
	
	// Üst sınıfta geçersiz hale getirilmiş method
	public void yazdirBilgi() {
		super.yazdirBilgi();
		System.out.println("Öğretmenin branşı: " + brans);
		System.out.println("Öğretmenin hizmet yılı: " + hizmet);
	}
}