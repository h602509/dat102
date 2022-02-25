package parFinneren;

public class KlientParFinneren {

	public static void main(String[] args) {
		
		
		Hobby fiske = new Hobby("fiske");
		Hobby gaming = new Hobby("gaming");
		Hobby festing = new Hobby("festing");
		Hobby kort = new Hobby("kortspill");
		Hobby jakt = new Hobby("jakt");
		
		Medlem a = new Medlem("Tor");
		a.leggTilHobby(fiske, gaming, festing);
		System.out.println(a.toString());
		
		Medlem b = new Medlem("Grete");
		b.leggTilHobby(festing, kort);
		System.out.println(b.toString());
		
		Medlem c = new Medlem("Dr. Frank");
		c.leggTilHobby(kort, festing, festing);
		System.out.println(c.toString());
		
		Medlem d = new Medlem("Frode");
		d.leggTilHobby(fiske, gaming, jakt);
		
		Medlem e = new Medlem("Idun");
		e.leggTilHobby(fiske, gaming, jakt);
		
		Datakontakt medlemmer = new Datakontakt();
		medlemmer.leggTilMedlem(a);
		medlemmer.leggTilMedlem(b);
		medlemmer.leggTilMedlem(c);
		medlemmer.leggTilMedlem(d);
		medlemmer.leggTilMedlem(e);
		
		System.out.println(b.getStatusIndeks());
		System.out.println(b.getNavn());
		System.out.println(medlemmer.finnMedlemsIndeks("Grete"));
		System.out.println(medlemmer.finnPartnerFor("Grete"));
		System.out.println(medlemmer.finnPartnerFor("Idun"));
		
		System.out.println(a.toString());
		System.out.println(b.toString());
		System.out.println(c.toString());
		System.out.println(d.toString());
		System.out.println(e.toString());
		
		
		Tekstgrensesnitt.skrivParListe(medlemmer);
		medlemmer.tilbakestillStatusIndex("Grete");
		
		System.out.println(a.toString());
		System.out.println(b.toString());
		System.out.println(c.toString());
		System.out.println(d.toString());
		System.out.println(e.toString());
		
		Tekstgrensesnitt.skrivHobbyListe(a);
		Tekstgrensesnitt.skrivParListe(medlemmer);
		
		System.out.println(medlemmer.getAntallMedlemmer());
	
	}

}
