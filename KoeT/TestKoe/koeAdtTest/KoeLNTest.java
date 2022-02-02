package koeAdtTest;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.kjedet.KjedetKoe;

public class KoeLNTest {

	private KoeADT<Integer> koe;
	
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;
	
	@BeforeEach
	public void setup() {
		koe = new KjedetKoe<>();
	}
	
	@Test
	public final void nyKjedetKoeErTom() {
		assertTrue(koe.erTom());
		
		
	}
	
	@Test
	public final void innKoeEtElement() {
		
		koe.innKoe(e0);	
		assertEquals(koe.foerste(), e0);
		
	}
	
	@Test
	public final void kjedetKoeErIkkeTom() {
		
		koe.innKoe(e0);	
		assertFalse(koe.erTom());
	}
	
	@Test
	public final void innKoeFlereElement() {
		
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);
		koe.innKoe(e3);
		assertEquals(e0, koe.foerste());
	}
	
	@Test
	public final void testUtKoe() {
		
		koe.innKoe(e1);
		koe.innKoe(e2);
		koe.innKoe(e3);
		koe.innKoe(e4);
		
		assertEquals(e1, koe.utKoe());
		assertEquals(e2, koe.utKoe());
		assertEquals(e3, koe.utKoe());
		assertEquals(e4, koe.utKoe());
		assertTrue(koe.erTom());
		
	}
	
	@Test
	public final void testFoerste() {
		
		boolean foersteFeiler = false;
		
		koe.innKoe(e0);	
		assertEquals(koe.foerste(), e0);
		koe.utKoe();
		assertTrue(koe.erTom());
		
		try {
			koe.foerste();
		} catch (Exception e) {
			foersteFeiler = true;
			
		}
		
		assertTrue(foersteFeiler);
		
	}
	
}