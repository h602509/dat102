package parFinneren;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public class Medlem {

    private String navn;
    private MengdeADT<Hobby> hobbyer;
    private int statusIndeks;
    
    
    public Medlem(String navn) {
    	this.navn = navn;
    	statusIndeks = -1;
    	hobbyer = new KjedetMengde<>();
    	
    }


	public String getNavn() {
		return navn;
	}


	public void setNavn(String navn) {
		this.navn = navn;
	}


	public MengdeADT<Hobby> getHobbyer() {
		return hobbyer;
	}

	public void leggTilHobby(Hobby...hobbies) {
		for(Hobby h : hobbies) hobbyer.leggTil(h);
	}
	
	public int getStatusIndeks() {
		return statusIndeks;
	}


	public void setStatusIndeks(int statusIndeks) {
		this.statusIndeks = statusIndeks;
	}
    
    public boolean passerTil (Medlem medlem2) {
    	return (this.getHobbyer().equals(medlem2.getHobbyer()));
    }
  
    @Override
    public String toString() {
    	return "Medlemnr: " + statusIndeks + ", navn: " + navn + ", hobbyer: " + "<" + hobbyer.toString() + ">";
    	
    }
    
}