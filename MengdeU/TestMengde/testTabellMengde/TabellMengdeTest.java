package testTabellMengde;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.tabell.TabellMengde;
import testMengdeATD.MengdeADTTest;

public class TabellMengdeTest extends MengdeADTTest {
	
	   @Override
		protected MengdeADT<String> reset() {
		return new TabellMengde<String>();
	}		
}