package parFinneren;

public class Tekstgrensesnitt {
	// Hvis du vil lage meny, kan du også legge det inn i Tekstgrensesnitt // leser
	// opplysningene om et medlem fra tastatur
	public static Medlem lesMedlem() {

		// f.eks. bruke Scanner.
	}

	// Skriver ut hobbylisten for et medlem
	public static void skrivHobbyListe(Medlem medlem) { System.out.println("Alle
	      hobbyene "); System.out.println(medlem.getHobbyer().toString());
	}

	public static void skrivParListe(Datakontakt arkiv) {
		/*
		 * skriver ut på skjermen en oversikt over medlemmer som er koblet til hverandre
		 * i medlemstabellen til enhver tid. Et slikt par skal kun vises én gang på
		 * utskriftlisten. Metoden skriver også ut antall par som er funnet. Eksempel på
		 * utskrift: PARNAVN Erna og Jonas Eva og Adam ......................... Antall
		 * par funnet: 12
		 */
	}
}