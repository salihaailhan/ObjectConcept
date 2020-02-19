package com.nesnekavrami;
/* CokBicimlilikPersonel.java : Ana sınıf bildirimi */
public class CokBicimlilikPersonel {
	  public String adi;    /* Sınıf dışından erişilebilen public değişken  */
	  public String soyadi; /* Sınıf dışından erişilebilen public değişken  */
	  private int yasi;     /* Sadece sınıf içinden erişilebilen private değişken  */

	  /* Constructor metod */
	  public CokBicimlilikPersonel(String cadi, String csoyadi, int cyasi) {
	    adi = cadi;
	    soyadi = csoyadi;
	    yasi = cyasi;
	  } 

	  /* Sınıf dışından erişilebilen public metod */
	  public String getBilgi() {
	    return adi + " " + soyadi;
	  }
	 
	  /* Sınıf dışından erişilebilen public metod */
	  public int getPrivBilgi() {
	    return yasi;
	  }
	  
	  /* Sınıf dışından erişilebilen public metod */
	  public void yazdirBilgi() {
	    System.out.println("Okulumuz personeli: " + getBilgi() + " " + getPrivBilgi());
	  }  
}
