package com.opsiyonelproje;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class IslemIsle {
	LinkedList<Operator> olist = new LinkedList<Operator>();
	LinkedList<Object> elist = new LinkedList<Object>();
	boolean islemleri_goster;
	int parantez_adet = 0;

	IslemIsle(boolean islemleri_goster) {
		this.islemleri_goster = islemleri_goster;
		olist.add(new SolParantez());
		olist.add(new SagParantez());
	}

	boolean islemTipiEkle(Operator opr) {
		return olist.add(opr);
	}

	String operatorler() {
		String oplist = " ";
		Iterator<Operator> itr = olist.iterator();
		while (itr.hasNext()) {
			Operator opr = itr.next();
			oplist += opr.tip();
		}
		return oplist;
	}

	Operator operatorBul(char op) {
		Iterator<Operator> itr = olist.iterator();
		while (itr.hasNext()) {
			Operator opr = itr.next();
			if (opr.tip() == op)
				return opr;
		}
		return null;
	}

	int enOcelikli(int s, int e) {
		int oncelik_indeks = s;
		int en_oncelik = Operator.EN_DUSUK;
		for (int i = s; i <= e; i++) {
			Object o = elist.get(i);
			if (o instanceof Operator) {
				Operator oo = (Operator) o;
				if (oo.oncelik() < en_oncelik) {
					en_oncelik = oo.oncelik();
					oncelik_indeks = i;
				}
			}
		}
		return oncelik_indeks;
	}

	void islemYap(int s, int e) throws Exception {
		while (s < e) {
			int indeks = enOcelikli(s, e);
			Object o1 = elist.get(indeks - 1);
			Object op = elist.get(indeks);
			Object o2 = elist.get(indeks + 1);
			if (o1 instanceof Double && op instanceof Islem && o2 instanceof Double) {
				Double co1 = (Double) o1;
				Islem cop = (Islem) op;
				Double co2 = (Double) o2;
				Double r = cop.yap(co1, co2);
				elist.set(indeks - 1, r);
				elist.remove(indeks);
				elist.remove(indeks);
				e -= 2;
			} else
				throw new Exception("Aritmetiksel ifade geçersiz!");
			if (islemleri_goster)
				System.out.println(toString());
		}
	}

	void sadelestir() throws Exception {
		if (elist.size() > 1) {
			if (parantez_adet > 0) {
				int indeks = 0;
				int sol_parantez = 0;
				int s = 0, e = elist.size() - 1;
				Iterator<Object> itr = elist.iterator();
				while (itr.hasNext()) {
					Object o = itr.next();
					if (o instanceof Operator) {
						Operator op = (Operator) o;
						if (sol_parantez < parantez_adet) {
							if (op.tip() == Operator.SOL_PARANTEZ) {
								sol_parantez++;
								if (sol_parantez == parantez_adet)
									s = indeks;
							}
						} else {
							if (op.tip() == Operator.SAG_PARANTEZ) {
								e = indeks;
								break;
							}
						}
					}
					indeks++;
				}
				islemYap(s + 1, e - 1);
				elist.remove(s);
				elist.remove(s + 1);
				parantez_adet--;
			} else
				islemYap(0, elist.size() - 1);
		}
	}

	public String stringYap(int s, int e) {
		String str = "";
		for (int i = s; i <= e; i++)
			str += elist.get(i) + " ";
		return str;
	}

	public String toString() {
		return stringYap(0, elist.size() - 1);
	}

	double sonuc(String str) throws Exception {
		elist.clear();
		int sol_parantez = 0;
		int sag_parantez = 0;
		StringTokenizer st = new StringTokenizer(str, operatorler(), true);
		while (st.hasMoreTokens()) {
			String opstr = st.nextToken();
			if (opstr.equals(" ") == false) {
				Operator opr = operatorBul(opstr.charAt(0));
				if (opr != null) {
					elist.add(opr);
					if (opr.tip() == Operator.SOL_PARANTEZ)
						sol_parantez++;
					if (opr.tip() == Operator.SAG_PARANTEZ)
						sag_parantez++;
				} else {
					Double sayi = new Double(opstr);
					elist.add(sayi);
				}
			}
		}
		if (sol_parantez != sag_parantez)
			throw new Exception("Sağ ve sol parantez sayıları eşit değil!");
		else
			parantez_adet = sol_parantez;
		while (elist.size() > 1) {
			if (islemleri_goster)
				System.out.println(toString());
			sadelestir();
		}
		Object v = elist.size() > 0 ? elist.get(0) : null;
		return (v != null && v instanceof Double) ? ((Double) v).doubleValue() : 0.0;
	}
}
