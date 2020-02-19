package com.nesnekavrami;
/* SoyutOgretmen.java : Çocuk sınıf bildirimi */
public class SoyutOgretmen extends SoyutPersonel {
  public String brans;
  public int hizmet;

  /* Constructor metod */
  public SoyutOgretmen(String cadi, String csoyadi, int cyasi, String cbrans, int chizmet) {
    super.setBilgi(cadi, csoyadi, cyasi); 
    brans = cbrans;
    hizmet = chizmet;
  } 
    
  /* Üst sınıfta geçersiz hale getirilmiş metod */
  public void yazdirBilgi() {
    System.out.println("Okulumuz personeli: " + "Adı: " + adi + " Soyadı: " + soyadi + " Yaşı: " + yasi);
    System.out.println("Öğretmen: Branş: " + brans + " Hizmet yılı: " + hizmet);
  }  
}