package com.nesnekavrami;
// Çocuk sınıf bildirimi 
public class CokBicimlilikOgrenci extends CokBicimlilikPersonel {
	  public String bolum;
	  public String sinif;
	  public int okulno;

	  /* Constructor metod */
	  public CokBicimlilikOgrenci(String cadi, String csoyadi, int cyasi, String cbolum, String csinif, int cokulno) {
	    super(cadi, csoyadi, cyasi); 
	    bolum = cbolum;
	    sinif = csinif;
	    okulno = cokulno;
	  } 

	  public String getogrenciBilgi() {
	    return bolum + " " + sinif + " " + okulno;
	  }
	 
	  /* Üst sınıfta geçersiz hale getirilmiş metod */
	  public void yazdirBilgi() {
	    super.yazdirBilgi();
	    System.out.println("Öğrenci: Bölüm - Sınıf - No.: " + getogrenciBilgi());
	  }  
}
