package testMengdeATD;

import no.hvl.dat102.mengde.adt.MengdeADT;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class MengdeADTTest {

	private MengdeADT<String> mengde1, mengde2;
	

	private String a = "1";
	private String b = "2";
	private String c = "3";
	private String d = "4";
	private String e = "5";

	protected abstract MengdeADT<String> reset();
	
	@BeforeEach
	public final void setup() {
		mengde1 = reset();
		mengde2 = reset();
	}
	
	@Test
	public final void testErTom() {
		
		assertTrue(mengde1.erTom());
		assertEquals(0, mengde1.antall());
		
	}
	
	@Test
	public final void testLeggTil() {
		
		mengde1.leggTil(a);
		assertEquals(1, mengde1.antall());
		assertTrue(mengde1.inneholder(a));
		
	}
	
	@Test
	public final void testUnionMedDuplicat() {
		
		mengde1.leggTil(a);
		mengde1.leggTil(b);
		mengde1.leggTil(c);
		mengde2.leggTil(c);
		mengde2.leggTil(d);
		
		assertEquals(mengde1.union(mengde2).antall(), 4);
		assertTrue(mengde1.union(mengde2).inneholder(a));
		assertTrue(mengde1.union(mengde2).inneholder(b));
		assertTrue(mengde1.union(mengde2).inneholder(c));
		assertTrue(mengde1.union(mengde2).inneholder(d));
		assertFalse(mengde1.union(mengde2).inneholder(e));
		
	}
	
	@Test
	public final void testSnitt() {
		
		mengde1.leggTil(a);
		mengde1.leggTil(b);
		mengde1.leggTil(c);
		mengde2.leggTil(c);
		mengde2.leggTil(d);
		
		assertEquals(1, mengde1.snitt(mengde2).antall());
		assertFalse(mengde1.snitt(mengde2).inneholder(a));
		assertFalse(mengde1.snitt(mengde2).inneholder(b));
		assertTrue(mengde1.snitt(mengde2).inneholder(c));
		assertFalse(mengde1.snitt(mengde2).inneholder(d));
		assertFalse(mengde1.snitt(mengde2).inneholder(e));
	}
	
	@Test
	public final void testDifferanse() {
		
		mengde1.leggTil(a);
		mengde1.leggTil(b);
		mengde1.leggTil(c);
		mengde2.leggTil(c);
		mengde2.leggTil(d);
		
		assertEquals(2, mengde1.differens(mengde2).antall());
		assertTrue(mengde1.differens(mengde2).inneholder(a));
		assertTrue(mengde1.differens(mengde2).inneholder(b));
		assertFalse(mengde1.differens(mengde2).inneholder(c));
		assertFalse(mengde1.differens(mengde2).inneholder(d));
		assertFalse(mengde1.differens(mengde2).inneholder(e));
		
	}
	
}
