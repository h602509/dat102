package no.hvl.dat102.listeklient;

public class Person implements Comparable<Person> {

	private String fornavn;
	private String etternavn;
	private int foedselsaar;

	// Konstrukt�rer

	public Person() {
		this("", "", 0);

	}

	public Person(String fornavn, String etternavn, int foedselsaar) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.foedselsaar = foedselsaar;

	}

	public void setFoedselsaar(int foedselsaar) {
		this.foedselsaar = foedselsaar;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	int getFoedselsaar() {
		return foedselsaar;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public String getFornavn() {
		return fornavn;
	}

	public String toString() {
		return (foedselsaar + "\t" + etternavn + ", " + fornavn);
	}

	public int compareTo(Person denAndrePersonen) {
		int resultat = 0;

		if (getFoedselsaar() < denAndrePersonen.getFoedselsaar()) {
			resultat = -1;
			
		} else if (getFoedselsaar() > denAndrePersonen.getFoedselsaar()) {
			resultat = 1;

		} else {
			resultat = getEtternavn().compareTo(denAndrePersonen.getEtternavn());

			if (resultat == 0) {
				resultat = getFornavn().compareTo(denAndrePersonen.getFornavn());

			} else if (resultat < 0) {
				resultat = -1;

			} else if (resultat > 0) {
				resultat = 1;

			}

		}

		return resultat;
	}

}