package com.nesnekavrami;
/* SoyutPersonel.java : Soyut ana sınıf bildirimi (Bu sınıfın kopyası oluşturulamaz) */
public abstract class SoyutPersonel {
  /* Veri alanı bildirimleri */ 
  public String adi;   
  public String soyadi;
  public int yasi; 

  /* Soyut olmayan metod bildirimleri (Kod içerir) */
  public void setBilgi(String cadi, String csoyadi, int cyasi) {
    adi = cadi;
    soyadi = csoyadi;
    yasi = cyasi;
  } 
  
  /* Soyut metod bildirimleri (Kod içermez) */ 
  // public abstract void yazdirBilgi(void);
}