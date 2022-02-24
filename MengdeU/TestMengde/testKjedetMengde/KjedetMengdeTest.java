package testKjedetMengde;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;
import testMengdeATD.MengdeADTTest;

public class KjedetMengdeTest extends MengdeADTTest {

	   @Override
		protected MengdeADT<String> reset() {
		return new KjedetMengde<String>();
	}		
}
