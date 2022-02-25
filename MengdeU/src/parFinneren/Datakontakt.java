package parFinneren;

import java.util.Iterator;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;


public class Datakontakt {

	private MengdeADT<Medlem> medlemstabell;
	private int antallMedlemer;
	
	public Datakontakt() {
		medlemstabell = new KjedetMengde<>();
		antallMedlemer = 0;
	}
	
	public int getAntallMedlemmer() {
		return antallMedlemer;	
	}
	
	
	public void leggTilMedlem(Medlem medlem) {
		getMedlemstabell().leggTil(medlem);
		antallMedlemer++;
	}
	
	
	public int finnMedlemsIndeks(String medlemsnavn) {
		
		if (antallMedlemer == 0) {
			return -1;
		}
		Iterator<Medlem> teller = getMedlemstabell().iterator();
		int indeks = antallMedlemer - 1;
		
		while (teller.hasNext()) {
			Medlem medlem = teller.next();

			if (medlem.getNavn().equals(medlemsnavn)) {
				return indeks;
			}
			indeks--; 
		}
		return -1;
	}
	
	public Medlem finnMedlem(String navn) {
		Iterator<Medlem> teller = getMedlemstabell().iterator();
		
		while (teller.hasNext()) {
			Medlem medlem = teller.next();
			
			if(medlem.getNavn().equals(navn)) {
				return medlem;
			}
		}
		return null;
	}
	
	
	public int finnPartnerFor(String navn) {
		
		Medlem medlem1 = finnMedlem(navn);
		Iterator<Medlem> teller = getMedlemstabell().iterator();
			
		while (teller.hasNext()) {
			Medlem medlem2 = teller.next();
			
			if(!medlem1.equals(medlem2) && medlem1.passerTil(medlem2)) {
				int m2mIndeks = finnMedlemsIndeks(medlem2.getNavn());
				
				medlem1.setStatusIndeks(m2mIndeks);
				medlem2.setStatusIndeks(finnMedlemsIndeks(medlem1.getNavn()));
				
				return m2mIndeks;
			}

		}
		return -1;
		
	}
	
	
	public Medlem getMedlemFromIndeks(int indeks) {
		
		Iterator<Medlem> teller = getMedlemstabell().iterator();
		int i = antallMedlemer - 1;
		
		while (teller.hasNext()) {
			Medlem medlem = teller.next();

			if (indeks == i) {
				return medlem;
			}
			i--; 
		}
		return null;
	}
	
	
	public void tilbakestillStatusIndex(String navn) {
		Medlem medlem1 = finnMedlem(navn);
		Medlem medlem2 = getMedlemFromIndeks(medlem1.getStatusIndeks());
		
		medlem1.setStatusIndeks(-1);
		medlem2.setStatusIndeks(-1);
		
	}

	public MengdeADT<Medlem> getMedlemstabell() {
		return medlemstabell;
	}

}
