package mainApp;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;



public class TestsCalculs {
	
	static Cantine cantineTest;
	static Client client1;
	static Client client2;
	static Client client3;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		cantineTest= new Cantine();
		client1 = new Client("Jean");
		cantineTest.listeClient.add(client1);
		client2 = new Client("Martin");
		cantineTest.listeClient.add(client2);
		client3 = new Client("Joe");
		cantineTest.listeClient.add(client3);
	}


	@Test 
	public void testCalculFacture() {
		double[] tabFacture = cantineTest.calculTaxes(0.10, 0.05, 50.00);
		
		assertEquals(5.00,tabFacture[0],0);

		assertEquals(2.50,tabFacture[1],0);

		assertEquals(50.00,tabFacture[2],0);
	}
	
	@Test 
	public void testCalculFactureMontantNull() {
		double[] tabFacture = cantineTest.calculTaxes(0.10, 0.05, 0.00);
		
		assertEquals(0.00,tabFacture[0],0);
		
		assertEquals(0.00,tabFacture[1],0);
		
		assertEquals(0.00,tabFacture[2],0);
	}

	@Test 
	public void testCalculFactureMontant2() {
		double[] tabFacture = cantineTest.calculTaxes(0.10, 0.05, 27.35);
		

		assertEquals(2.735,tabFacture[0],0);

		assertEquals(1.3675,tabFacture[1],0);
		
		assertEquals(27.35,tabFacture[2],0);
    }
	
	@Test 
	public void testCalculFactureMontant3() {
		double[] tabFacture = cantineTest.calculTaxes(0.10, 0.05, 6666.00);
		
		assertEquals(666.6,tabFacture[0],0);

		assertEquals(333.3,tabFacture[1],0);
		
		assertEquals(6666.00,tabFacture[2],0);
    }
	
	@Test 
	public void testCalculFactureMontant4() {
		double[] tabFacture = cantineTest.calculTaxes(0.10, 0.05, 0.0150);
		
		assertEquals(0.0015,tabFacture[0],0);

		assertEquals(0.00075,tabFacture[1],0);
		
		assertEquals(0.0150,tabFacture[2],0);
    }
	
	@Test
	public void testTotal() {	
		cantineTest.calculTotal();
	}
}
