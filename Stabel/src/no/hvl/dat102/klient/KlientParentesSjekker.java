package no.hvl.dat102.klient;

import no.hvl.dat102.adt.ParentessjekkerADT;
import no.hvl.dat102.kjedet.Parentessjekker;

public class KlientParentesSjekker {

	public static void main(String[] args) {
		
		ParentessjekkerADT objekt = new Parentessjekker();
		String s = "av(fdgg)(sgsg(sd(sdgsd)(sdgsg)sgd)sdg)dggsd";
		System.out.println(objekt.erBalansert(s));
		
	}

//	private boolean erBalansert(String s) {
//
//		
//		StabelADT<Character> tegnStabel = new KjedetStabel<>();
//
//		for (int i = 0; i < s.length(); i++) {
//			char c = s.charAt(i);
//			if (erVenstreparentes(c)) {
//				tegnStabel.push(c);
//			}
//
//			if (erHogreparentes(c) && tegnStabel.pop() == 0) {
//				System.out.println("Ingen flere parenteser å poppe");
//				return false;
//		
//			} else if (erHogreparentes(c) && !erPar(tegnStabel.pop(), c)) {
//				System.out.println("sist kontrollerte parentes er ikke par");
//				return false;
//			}
//			
//		}
//		return true;
//	}

//	public static boolean erPar(char venstre, char hogre) {
//
//		if (!erVenstreparentes(venstre)) {
//			return false;
//
//		} else if ((venstre == '(' && hogre == ')') || (venstre == '[' && hogre == ']')
//				|| (venstre == '{' && hogre == '}')) {
//			return true;
//
//		}
//
//		return false;
//
//	}
//
//	private static boolean erHogreparentes(char p) {
//		return p == ')' || p == ']' || p == '}';
//		
//	}
//
//	private static boolean erVenstreparentes(char p) {
//		return p == '(' || p == '[' || p == '{';
//		
//	}
}
