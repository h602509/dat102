package parFinneren;

import no.hvl.dat102.mengde.adt.MengdeADT;

public class Medlem {

    private String navn;
    private MengdeADT<Hobby> hobbyer;
    private int statusIndeks;
    
    
    public Medlem(String navn, int statusIndeks, MengdeADT <Hobby> hobbyer) {
    	this.navn = navn;
    	this.statusIndeks = statusIndeks;
    	this.hobbyer = hobbyer;
    	
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


	public void setHobbyer(MengdeADT<Hobby> hobbyer) {
		this.hobbyer = hobbyer;
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
    
}