package com.nesnekavrami;
// Çocuk sınıf bildirimi 
public class CokBicimlilikOgretmen extends CokBicimlilikPersonel {
	  public String brans;
	  public int hizmet;

	  /* Constructor metod */
	  public CokBicimlilikOgretmen(String cadi, String csoyadi, int cyasi, String cbrans, int chizmet) {
	    super(cadi, csoyadi, cyasi); 
	    brans = cbrans;
	    hizmet = chizmet;
	  } 

	  public String getogretmenBilgi() {
	    return brans + " " + hizmet;
	  }
	 
	  /* Üst sınıfta geçersiz hale getirilmiş metod */
	  public void yazdirBilgi() {
	    super.yazdirBilgi();
	    System.out.println("Öğretmen: Branş - Hizmet yılı: " + getogretmenBilgi());
	  }  
}
