package com.nesnekavrami;

/* KapsullemePersonel.java : Verilerin korunduğu sınıf bildirimi */
public class KapsullemePersonel {
  public String adi;    /* Sınıf dışından erişilebilen public değişken  */
  public String soyadi; /* Sınıf dışından erişilebilen public değişken  */
  private int yasi;     /* Sadece sınıf içinden erişilebilen private değişken  */

  /* Sınıf dışından erişilebilen public metod */
  public String getBilgi() {
    return adi + " " + soyadi;
  }
 
  /* Sınıf dışından erişilebilen public metod */
  public int getPrivBilgi() {
    return yasi;
  }

  /* Sınıf dışından erişilebilen public metod */
  public void setBilgi(String cadi, String csoyadi, int cyasi) {
    adi = cadi;
    soyadi = csoyadi;
    SetPrivBilgi(cyasi);
  } 

  /* Sadece sınıf içinden erişilebilen private metod */
  private void SetPrivBilgi(int yasi) {
    this.yasi =  yasi;
  }
}
