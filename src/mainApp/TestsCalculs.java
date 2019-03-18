package mainApp;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



public class TestsCalculs {
	
	 Cantine cantineTest;
	 Client client1;
	 Client client2;
	 Client client3;
	 Produit produit1;


	 
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}
	
	@Before
	public void setUp()throws Exception{
		
		cantineTest= new Cantine();
		client1 = new Client("Jean");
		cantineTest.listeClient.add(client1);
		client2 = new Client("Martin");
		cantineTest.listeClient.add(client2);
		client3 = new Client("Joe");
		cantineTest.listeClient.add(client3);
		
		for ( Client c : cantineTest.listeClient ) {
			  produit1 = new Produit("Poutine",10.5);
			  c.ajouterProduit(produit1);
		}

		for ( Client c : cantineTest.listeClient ) {
			  produit1 = new Produit("Frite",2.5);
			  c.ajouterProduit(produit1);
		}
		for ( Client c : cantineTest.listeClient ) {
		  produit1 = new Produit("Repas_Poulet", 15.75);
		  c.ajouterProduit(produit1);
		}
		cantineTest.listeClient.get(0).listeProduit.get(0).setQte(3);
		cantineTest.listeClient.get(1).listeProduit.get(1).setQte(2);
		cantineTest.listeClient.get(2).listeProduit.get(2).setQte(1);
		cantineTest.listeClient.get(0).listeProduit.get(1).setQte(1);
		cantineTest.listeClient.get(1).listeProduit.get(2).setQte(1);
		cantineTest.listeClient.get(2).listeProduit.get(0).setQte(3);
		cantineTest.listeClient.get(0).listeProduit.get(2).setQte(8);
		cantineTest.listeClient.get(1).listeProduit.get(0).setQte(7);
		cantineTest.listeClient.get(2).listeProduit.get(1).setQte(9);
	}


	@Test 
	public void testCalculFacture() {
		double[] tabFacture = cantineTest.calculTaxes(0.10, 0.05, 50.00);
		
		assertEquals(5.00,tabFacture[0],0);

		assertEquals(2.50,tabFacture[1],0);

		assertEquals(57.50,tabFacture[2],0);
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
		

		assertEquals(2.73,tabFacture[0],0);

		assertEquals(1.36,tabFacture[1],0);
		
		assertEquals(31.44,tabFacture[2],0);
    }
	
	@Test 
	public void testCalculFactureMontant3() {
		double[] tabFacture = cantineTest.calculTaxes(0.10, 0.05, 6666.00);
		
		assertEquals(666.60,tabFacture[0],0);

		assertEquals(333.30,tabFacture[1],0);
		
		assertEquals(7665.90,tabFacture[2],0);
    }
	
	@Test 
	public void testCalculFactureMontant4() {
		double[] tabFacture = cantineTest.calculTaxes(0.10, 0.05, 0.95);
		
		assertEquals(0.10,tabFacture[0],0);

		assertEquals(0.05,tabFacture[1],0);
		
		assertEquals(1.10,tabFacture[2],0);
    }
	
	@Test
	public void testTotal() {	
		cantineTest.calculTotal();
	}
}
