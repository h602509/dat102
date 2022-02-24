package no.hvl.dat102.klient;

import no.hvl.dat102.adt.ParentessjekkerADT;
import no.hvl.dat102.kjedet.Parentessjekker;

public class KlientParentesSjekker {

	public static void main(String[] args) {
		
		ParentessjekkerADT objekt = new Parentessjekker();
		String s = "(fngfg(fgnf{fgn}[fdthdfgndf]fgn)fgnffre g)   derhdsdhjs";
		System.out.println(objekt.erBalansert(s));
		
	}

}