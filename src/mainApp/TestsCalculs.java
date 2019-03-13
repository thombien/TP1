package mainApp;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;



public class TestsCalculs {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}


	@Test 
	public void testCalculFactureTPS() {
		double[] tabFacture = Cantine.calculTaxes(0.10, 0.05, 50.00);
		assertEquals(5.00,tabFacture[0],0);
	}
	
	@Test
	public void testCalculFactureTVQ() {	
		double[] tabFacture = Cantine.calculTaxes(0.10, 0.05, 50.00);
		assertEquals(2.50,tabFacture[1],0);
	}
	
	@Test
	public void testCalculFactureMontant(){
		double[] tabFacture = Cantine.calculTaxes(0.10, 0.05, 50.00);
		assertEquals(50.00,tabFacture[2],0);
	}
	
	@Test 
	public void testCalculFactureMontantNull() {
		double[] tabFacture = Cantine.calculTaxes(0.10, 0.05, 0.00);
		assertEquals(0.00,tabFacture[2],0);
	}

	@Test 
	public void testCalculFactureMontant2() {
		double[] tabFacture = Cantine.calculTaxes(0.10, 0.05, 27.35);
		assertEquals(27.35,tabFacture[2],0);
	}
    @Test public void testCalculFactureTPS2() {
		double[] tabFacture = Cantine.calculTaxes(0.10, 0.05, 27.35);
		assertEquals(2.735,tabFacture[0],0);
    	
    }
    @Test public void testCalculFactureTVQ2() {
		double[] tabFacture = Cantine.calculTaxes(0.10, 0.05, 27.35);
		assertEquals(1.3675,tabFacture[1],0);
    	
    }
	@Test
	public void testTotal() {	
		Cantine.calculTotal();
	}
}
