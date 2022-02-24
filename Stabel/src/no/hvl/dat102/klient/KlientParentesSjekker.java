package no.hvl.dat102.klient;

import no.hvl.dat102.adt.ParentessjekkerADT;
import no.hvl.dat102.kjedet.Parentessjekker;

public class KlientParentesSjekker {

	public static void main(String[] args) {
		
		ParentessjekkerADT objekt = new Parentessjekker();
		String s = "av(fdgg)(sgsg(sd(sdgsd)(sdgsg)sgd)(sdg)dggsd";
		System.out.println(objekt.erBalansert(s));
		
	}

}