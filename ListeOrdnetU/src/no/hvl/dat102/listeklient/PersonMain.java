package no.hvl.dat102.listeklient;

import java.util.Scanner;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.kjedet.KjedetOrdnetListe;
import no.hvl.dat102.tabell.TabellOrdnetListe;

public class PersonMain {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		String fornavn;
		String etternavn;
		int fodt;
		String svar = "J";
		Boolean leggInnPerson = true;

		OrdnetListeADT<Person> personListeKjedet = new KjedetOrdnetListe<>();
		OrdnetListeADT<Person> personListeTabell = new TabellOrdnetListe<>(10);

		while (leggInnPerson) {
			System.out.println("Hva er fornavnet?");
			fornavn = input.nextLine();

			System.out.println("Hva er etternavnet?");
			etternavn = input.nextLine();

			System.out.println("Når ble personen født?");
			
			fodt = Integer.parseInt(input.nextLine());

			Person p = new Person(fornavn, etternavn, fodt);
			personListeKjedet.leggTil(p);
			personListeTabell.leggTil(p);
			
			System.out.println("vil du legge inn flere personer? j/n?");
			svar = input.nextLine();
			
			while (!(svar.equals("N") || svar.equals("n") || svar.equals("J") || svar.equals("j"))) {
					System.out.println("vil du legge inn flere personer? j/n?");
					svar = input.nextLine();

			}
			
			if (svar.equals("N") || svar.equals("n")) {
				leggInnPerson = false;
			}

		}

		input.close();

		System.out.println("Kjedet implementasjon:");

		while (!personListeKjedet.erTom()) {
			System.out.println(personListeKjedet.fjernSiste());

		}

		System.out.println("Tabell implementasjon:");

		while (!personListeTabell.erTom()) {
			System.out.println(personListeTabell.fjernSiste());
		}
	}

}
