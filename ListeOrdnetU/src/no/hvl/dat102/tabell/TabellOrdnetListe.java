package no.hvl.dat102.tabell;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;

public class TabellOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {

	private static final int STDK = 100;
	private static final int IKKE_FUNNET = -1;
	private int bak;
	private T[] liste;

	public TabellOrdnetListe() {
		this(STDK);
	}

	public TabellOrdnetListe(int startKapasitet) {
		bak = 0;
		liste = (T[]) (new Comparable[startKapasitet]);
	}

	@Override
	public T fjernSiste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = liste[bak - 1];
		liste[bak - 1] = null;
		bak--;
		return resultat;
	}

	@Override
	public T fjernFoerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = liste[0];

		for (int i = 1; i < bak; i++) {
			liste[i - 1] = liste[i];
		}
		liste[bak-1] = null;
		bak--;
		return resultat;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		return liste[0];
	}

	@Override
	public T siste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		return liste[bak - 1];

	}

	@Override
	public boolean erTom() {
		return (bak == 0);
	}

	@Override
	public int antall() {
		return bak;
	}

	@Override
	public void leggTil(T element) {

		if (antall() == liste.length) {
			utvid();
		}

		if (erTom()) {
			liste[0] = element;
			bak++;

		} else {

			int plassering = 0;
			while (plassering < bak && liste[plassering].compareTo(element) < 0) {
				plassering++;
			}

			for (int i = bak - 1; i >= plassering; i--) {
				liste[i + 1] = liste[i];
			}
			liste[plassering] = element;
			bak++;
		}
	}

	@Override
	public boolean inneholder(T element) {
		return (finn(element) != IKKE_FUNNET);
	}

	@Override
	public T fjern(T element) {
		int plassering = finn(element);
		T resultat = liste[plassering];

		for (int i = plassering; i < bak; i++) {
			liste[i] = liste[i + 1];
		}
		liste[bak - 1] = null;
		bak--;
		return resultat;

	}

	private int finn(T el) {
		int i = 0, resultat = IKKE_FUNNET;

		while (resultat == IKKE_FUNNET && i < bak) {
			if (liste[i].compareTo(el) == 0) {
				resultat = i;

			}
			i++;

		}

		return resultat;
	}

	public String toString() {
		String resultat = "";

		for (int i = 0; i < bak; i++) {
			resultat = resultat + liste[i].toString() + "\n";
		}
		return resultat;
	}

	private void utvid() {
		T[] hjelpeTabell = (T[]) (new Comparable[liste.length * 2]);

		for (int i = 0; i < liste.length; i++) {
			hjelpeTabell[i] = liste[i];
		}

		liste = hjelpeTabell;
	}

}// class
