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

		boolean balanse = true;
		StabelADT<Character> tegnStabel = new KjedetStabel<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (erVenstreparentes(c)) {
				tegnStabel.push(c);
			}

			if (erHogreparentes(c) && !erPar(tegnStabel.pop(), c)) {
				balanse = false;
			}

		}
		return balanse;
	}

}
