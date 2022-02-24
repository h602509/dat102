package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.ParentessjekkerADT;
import no.hvl.dat102.adt.StabelADT;

public class Parentessjekker implements ParentessjekkerADT {

	@Override
	public boolean erVenstreparentes(char p) {

		return p == '(' || p == '[' || p == '{';

	}

	@Override
	public boolean erHogreparentes(char p) {

		return p == ')' || p == ']' || p == '}';

	}

	@Override
	public boolean erParentes(char p) {

		return erHogreparentes(p) || erVenstreparentes(p);

	}

	@Override
	public boolean erPar(char venstre, char hogre) {

		if (!erVenstreparentes(venstre)) {
			return false;

		} else if ((venstre == '(' && hogre == ')') || (venstre == '[' && hogre == ']')
				|| (venstre == '{' && hogre == '}')) {
			return true;

		}

		return false;

	}

	@Override
	public boolean erBalansert(String s) {

		StabelADT<Character> tegnStabel = new KjedetStabel<>();
		int plasseringSistePush = 0;
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (erVenstreparentes(c)) {
				tegnStabel.push(c);
				plasseringSistePush = i;
			}
			if (erHogreparentes(c)) {
				if (tegnStabel.erTom()) {
					System.out.println("Stabel tom => " + c + " mangler partner.\nChar i plassering " + plasseringSistePush + "/" + i + " gir feil.");
					return false;
				
				} else if (!erPar(tegnStabel.pop(), c)) {
					
					if (i == s.length() - 1) {
						System.out.println("Tekst tom => " + c + " mangler partner.\nChar i plassering " + plasseringSistePush + "/" + i + " gir feil.");
						return false;
					} else {
						System.out.println("Parentesen => " + c + " mangler Partner.\nChar i plassering " + plasseringSistePush + "/" + i + " gir feil.");
						return false;
					}
					
				}
				
			}
		}
		if (!tegnStabel.erTom()) {
			System.out.println("Parentes => " + tegnStabel.pop() + " er igjen i stabel når tekst er slutt.");
			return false;
		}
		return true;
	}

}
