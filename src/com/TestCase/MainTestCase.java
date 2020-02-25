package com.TestCase;

public class MainTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("*******************************************");
		System.out.println("// Variables");
		System.out.println("*******************************************");
		int myInt = 5;
		short myShort = 800;
		long myLong = 9000;
		double myDouble = 5.25;
		float myFloat = 3.5f;
		char myChar = 'A';
		boolean myBoolean = false;
		byte myByte = 12;
		String myString = "Gürkay başyiğit";
		int a = 2, b = a++ * 2, c = 0;

		System.out.println("*******************************************");
		System.out.println("// Combination 1");
		System.out.println("*******************************************");
		int arr1[] = { 1, 2, 3 };
		int r1 = 2;
		int n1 = arr1.length;
		Combination.printCombination(arr1, n1, r1);

		System.out.println("*******************************************");
		System.out.println("// Combination 2");
		System.out.println("*******************************************");
		int arr[] = { 1, 2, 3 };
		int r2 = 2;
		int n2 = arr.length;
		Combination.printCombi(arr, n2, r2);

		System.out.println("*******************************************");
		System.out.println("// Permutation 1");
		System.out.println("*******************************************");

		int arr2[] = { 1, 2, 3 };
		int len = arr2.length;
		int L = 2;

		Permutation.print(arr2, len, L); // function call

		System.out.println("*******************************************");
		System.out.println("// Permutation 2");
		System.out.println("*******************************************");

		String str = "ABC";
		int n3 = str.length();
		Permutation permutation = new Permutation();
		permutation.permute(str, 0, n3 - 1);

		myChar = 'A';
		myInt = myChar + 1;
		System.out.println(myChar);

		System.out.println("Variable a: " + a);
		System.out.println("Variable b: " + b);

		a = 2;
		b = ++a * 2;
		System.out.println("Variable d: " + a);
		System.out.println("Variable e: " + b);

		System.out.println("*******************************************");
		System.out.println("// Basamak sayisini bulma");
		System.out.println("*******************************************");
		int myNumber = 2444242;
		System.out.println("Sayi basamak sayisi: " + ((int) (Math.log(myNumber) / Math.log(10)) + 1));

		System.out.println("*******************************************");
		System.out.println("// Basamaklar");
		System.out.println("*******************************************");
		int n = 24376;
		System.out.println("n=24376 birler basamagi : " + n % 10);
		System.out.println("n=24376 onlar basamagi : " + n / 10 % 10);

		n = (n / 100 * 100) + (n % 10 * 10) + (n / 10 % 10);
		System.out.println("n=24376 birler ve onlar basamagi yer degistiriyor : " + n);

		System.out.println("*******************************************");
		System.out.println("// Types");
		System.out.println("*******************************************");

		myInt = 2;
		myDouble = 5.0;
		System.out.println("2 + 5.0 = " + (myInt + myDouble));
		System.out.println("2 + (int)5.0 = " + (myInt + (int) myDouble));

		System.out.println("*******************************************");
		System.out.println("// 12.71945 sayısının virgulden sonrasini bul");
		System.out.println("*******************************************");
		myDouble = 12.71945;
		System.out.println(myDouble - (int) myDouble);

		System.out.println("*******************************************");
		System.out.println("// cesitli tip islemler");
		System.out.println("*******************************************");
		myInt = 5;
		myDouble = 5.1;
		myByte = 2;
		System.out.println("byte 2 * 2 = " + (myByte * myByte));
		System.out.println("2 * 5.0 = " + (myInt * myDouble));
		System.out.println("myInt / myInt = " + (myInt / b));
		System.out.println("myInt / myDouble = " + (myInt / myDouble));
		System.out.println("myFloat = " + myFloat);
		System.out.println("myFloat * myDouble = " + (myFloat * myDouble));
		myByte = 1;
		myChar = 1;
		myShort = 1;
		myInt = 1;
		myInt = myChar + myByte;
		System.out.println("myShort = myByte * 2 => Type mismatch: cannot convert from int to short");
		System.out.println("myChar = myChar + myByte => Type mismatch: cannot convert from int to char");
		System.out.println("myShort = myShort + myInt => Type mismatch: cannot convert from int to short");
		System.out.println("myByte = (byte)myShort + myByte => Type mismatch: cannot convert from int to byte");
		System.out.println("myInt = myChar + myByte => myInt = " + (myInt));

		System.out.println("(int)(2.5 + 3) * 2.1 => " + ((int) (2.5 + 3) * 2.1));
		System.out.println("(10 + 2) / (1 – 3 / 2) => undefined by zero");
		System.out.println("(4 / 5) * (2.0 + 3) => " + ((4 / 5) * (2.0 + 3)));
		System.out.println("(1.0 / 2) * (5 / 3 + 1) => " + ((1.0 / 2) * (5 / 3 + 1)));
		System.out.println("(int)(1.0 / 2) * (5 / 3 + 1) => " + ((int) (1.0 / 2) * (5 / 3 + 1)));
		System.out.println("(int)2.0 / (2 + 1) => " + ((int) 2.0 / (2 + 1)));
		System.out.println("myInt = (int)8 / (3 + 1.0) => error because double conculution assing integer");

		myByte = 5;
		myShort = 300;
		myShort = (short) ((int) myByte * (int) myShort + 1);
		System.out.println("myShort => " + (myShort));

		int age = 38;
		double weight = 80.1;
		double tall = 1.72;
		boolean javaStudent = true;
		boolean youngJavaStudent = (javaStudent && age + (weight / (tall * tall) - 25) < 30);
		System.out.println("Genc Java ogrencisimi : " + youngJavaStudent);

		int sinav1 = 10;
		int sinav2 = 20;
		int sinav3 = 15;
		int sinav4 = 60;
		int sinav5 = 5;

		boolean derseKatilmismi = true;
		double sinavNotu = (sinav1 * 0.32 + sinav2 * 0.12 + sinav3 * 0.28 + sinav4 * 0.24 + sinav5 * 0.24)
				+ (derseKatilmismi ? 5.0 : 0.0);
		System.out.println("Sinav notu = " + sinavNotu);

		a = 2;
		b = 3;
		if (++a >= b || b-- % 2 == 0) {
			b = -b;
		}
		System.out.println("variable a = " + a);
		System.out.println("variable b = " + b);

		a = 2;
		b = 3;
		if (a++ >= b || b-- % 2 == 0) {
			b = -b;
		}
		System.out.println("variable a = " + a);
		System.out.println("variable b = " + b);

		a = 1;
		b = 2;
		c = 3;
		System.out.println("(++a * b > c++ ? b : c) => output: " + (++a * b > c++ ? b : c));

		a = 1;
		b = 2;
		c = 3;
		if (a < b | ++a == c)
			System.out.println("Variable a : " + a);
		a *= 2;
		System.out.println("a*=2 => output: " + a);
		System.out.println("*******************************************");
		System.out.println("// Basamak Adedini bulan");
		System.out.println("*******************************************");
		a = 175;
		b = 0;
		while (a > 0) {
			a /= 10;
			b++;
		}
		System.out.println("Basamak Adedi : " + b);
		System.out.println("*******************************************");
		System.out.println("// sayiyi tersten yazan");
		System.out.println("*******************************************");
		a = 53961;
		b = 0;
		while (a > 0) {
			b = b * 10 + a % 10;
			a /= 10;
		}
		System.out.println("53961 tersten : " + b);

		System.out.println("*******************************************");
		System.out.println("// Birbirinden farklı dijitlerden oluşmuş bir n sayının");
		System.out.println("// en büyük ve en küçük dijitler haricinde kalan dijitlerin");
		System.out.println("// toplamını ve aritmetiksel ortalamasını bulan program");
		System.out.println("// (3 + 7 + 8 + 2 + 1 + 6 – (1 + 8) ) / (6 – 2.0) = 18 / 4.0 = 4.5");
		System.out.println("*******************************************");
		n = 378216;
		int enKucuk = 10;
		int enBuyuk = -1;
		int toplam = 0;
		int adet = 0;
		while (n > 0) {
			int sayi = n % 10;
			toplam += sayi;
			adet++;
			if (sayi < enKucuk)
				enKucuk = sayi;
			if (sayi > enBuyuk)
				enBuyuk = sayi;
			n /= 10;
		}
		if (adet > 2) {
			int haricToplam = toplam - (enKucuk + enBuyuk);
			System.out.println("Toplam = " + haricToplam);
			System.out.println("Ortalama = " + haricToplam / (adet - 2.0));
		}

		System.out.println("*******************************************");
		System.out.println("// Bir n sayısının basamaklarını çözümleyen program");
		System.out.println("*******************************************");
		n = 42672;
		int k = 1;
		while (n > 0) {
			System.out.print(k * (n % 10) + (n > 10 ? " + " : ""));
			k *= 10;
			n /= 10;
		}

		System.out.println();

		System.out.println("*******************************************");
		System.out.println("// Dışarıdan girilen bir sayının dijitlerini yanyana iki");
		System.out.println("// aynı dijit gelmeyecek şekilde ekrana yazan bir program");
		System.out.println("// Örneğin 564033441 sayısı için sonuç 5640341 olmalıdır");
		System.out.println("*******************************************");
		int eski_k = -1;
		k = 0;
		myInt = 564033441;
		str = "";
		while (myInt > 0) {
			k = myInt % 10;
			if (k != eski_k) {
				str = k + str;
				eski_k = k;
			}
			myInt /= 10;
		}
		System.out.println(str);

	}

}
