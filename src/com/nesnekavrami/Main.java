package com.nesnekavrami;

public class Main {

	public static void main(String[] args) {
		// NesnePersonel.java için main
		// Sınıfa ait değişken bildirimi ile sınıf kopyası elde etme
		NesnePersonel nesnePersonel1 = new NesnePersonel();
		// Değişkenlere değer atama
		nesnePersonel1.setBilgi("Gürkay", "BAŞYİĞİT", 38);
		// Değişkenleri ekrana yazma
		// nesnePersonel sınıfına ait fonksiyon çağrılır
		nesnePersonel1.yazdirBilgi();
		
		// SinifOgretmen.java ve SinifOgrenci.java için main
		// Her sınıfa ait 3 farklı değişken bildirimi
		NesnePersonel nesnePersonel2 = new NesnePersonel();
		SinifOgretmen sinifOgretmen2 = new SinifOgretmen();
		SinifOgrenci sinifOgrenci2 = new SinifOgrenci();
		
		nesnePersonel2.setBilgi("Mehmet", "Sari", 42);
		sinifOgretmen2.setBilgi("Sidika", "AKTAŞ", 36, "Matematik", 10);
		sinifOgrenci2.setBilgi("Halim", "BAŞYİĞİT", 6, "Muhendislik", "Bilgisayar", 140501);
		
		nesnePersonel2.yazdirBilgi();
		sinifOgretmen2.yazdirBilgi();
		sinifOgrenci2.yazdirBilgi();
		
		// KapsullemePersonel main
		// KapsullemePersonel.java : Korunan sınıfı kullanan sınıf */
		KapsullemePersonel kapsullemePersonel1 = new KapsullemePersonel(); 
	    /* 27 değeri SetPrivBilgi() private fonksiyonunun çağırılması için kullanılır. */
		kapsullemePersonel1.setBilgi("Meltem", "CUMBUL", 27); 
	    String adsoyad = kapsullemePersonel1.getBilgi(); 
	    int yas = kapsullemePersonel1.getPrivBilgi(); 
	    System.out.println("Kapsulleme ad soyad :" + adsoyad);
	    System.out.println("Kapsulleme yas :" + yas);
	    
	    // Cok Bicimlilik polimorpihishm
	    /* personel sınıfına ait 3 farklı değişken bildirimi */
	    CokBicimlilikPersonel per01, per02, per03;

	    per01 = new CokBicimlilikPersonel("Ahmet", "Kara", 27);
	    per02 = new CokBicimlilikOgretmen("Nedim", "Sakin", 35, "Matematik", 13);
	    per03 = new CokBicimlilikOgrenci("Serdar", "Uzun", 16, "Sayısal", "11FEN-A", 408);

	    per01.yazdirBilgi(); /* personel sınıfı fonksiyonu çağrılır */
	    per02.yazdirBilgi(); /* ogretmen sınıfı fonksiyonu çağrılır */
	    per03.yazdirBilgi(); /* ogrenci sınıfı fonksiyonu çağrılır */
	    
	    // Soyut Sınıf tanımlama
	    /* ogretmen sınıfına ait değişken bildirimi */
	    SoyutOgretmen soyutOgretmen = new SoyutOgretmen("Nedim", "Sakin", 35, "Matematik", 13);

	    soyutOgretmen.yazdirBilgi(); /* personel sınıfı fonksiyonu çağrılır */
	}

}
