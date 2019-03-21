package test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import mainApp.Cantine;
import mainApp.Client;
import mainApp.Produit;
import outilsjava.OutilsFichier;
import outilsjava.OutilsLecture;



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
		

		assertEquals(2.74,tabFacture[0],0);

		assertEquals(1.37,tabFacture[1],0);
		
		assertEquals(31.46,tabFacture[2],0);
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
	public void testTotalFonctionnel() {	
		
		for ( Client c : cantineTest.listeClient ) {
			  produit1 = new Produit("Poutine",10.50);
			  c.ajouterProduit(produit1);
		}

		for ( Client c : cantineTest.listeClient ) {
			  produit1 = new Produit("Frite",2.50);
			  c.ajouterProduit(produit1);
		}
		for ( Client c : cantineTest.listeClient ) {
		  produit1 = new Produit("Repas_Poulet", 15.00);
		  c.ajouterProduit(produit1);
		}
		cantineTest.listeClient.get(0).listeProduit.get(0).setQte(1);
		cantineTest.listeClient.get(1).listeProduit.get(0).setQte(1);
		cantineTest.listeClient.get(2).listeProduit.get(0).setQte(1);
		cantineTest.listeClient.get(0).listeProduit.get(1).setQte(2);
		cantineTest.listeClient.get(1).listeProduit.get(1).setQte(4);
		cantineTest.listeClient.get(2).listeProduit.get(1).setQte(6);
		cantineTest.listeClient.get(0).listeProduit.get(2).setQte(1);
		cantineTest.listeClient.get(1).listeProduit.get(2).setQte(2);
		cantineTest.listeClient.get(2).listeProduit.get(2).setQte(3);
		
		
		
		cantineTest.calculTotal();
		
		assertEquals(35.08, cantineTest.listeClient.get(0).totalAvecTaxes,0);
		assertEquals(58.08, cantineTest.listeClient.get(1).totalAvecTaxes,0);
		assertEquals(81.08, cantineTest.listeClient.get(2).totalAvecTaxes,0);
	}
	
	
	@Test
	public void testAjoutClient() {
		BufferedReader fic =
				new BufferedReader(new InputStreamReader(System.in));
		
		
		fic = OutilsFichier.ouvrirFicTexteLecture("testAjoutClient");
		
		OutilsLecture.fic = fic;
		OutilsLecture.type = 'F';
		
		
		cantineTest.ajouterClient();
		
		assertEquals("jean", cantineTest.listeClient.get(3).getNom());
		assertEquals("patate", cantineTest.listeClient.get(5).getNom());

	}
	
	@Test
	public void testAjoutPlatValide () {
		BufferedReader fic =
				new BufferedReader(new InputStreamReader(System.in));
		
		
		fic = OutilsFichier.ouvrirFicTexteLecture("testAjoutPlat");
		
		OutilsLecture.fic = fic;
		OutilsLecture.type = 'F';
		
		
		cantineTest.ajotouterPlats();
		
		assertEquals("Poutine", cantineTest.listeClient.get(0).listeProduit.get(0).getNom());
		
		assertEquals("Poutine", cantineTest.listeClient.get(2).listeProduit.get(0).getNom());
		assertEquals("Glasse", cantineTest.listeClient.get(2).listeProduit.get(2).getNom());
		assertEquals(20.50, cantineTest.listeClient.get(2).listeProduit.get(2).getPrix(),0);


	}
	
	
	@Test
	public void testAjoutCommande() {
		
		// création des plats pour le test 
		BufferedReader fic =
				new BufferedReader(new InputStreamReader(System.in));
		
		
		fic = OutilsFichier.ouvrirFicTexteLecture("testAjoutPlat");
		
		OutilsLecture.fic = fic;
		OutilsLecture.type = 'F';
		
		
		cantineTest.ajotouterPlats();
		
		
		// le test 
		fic =
				new BufferedReader(new InputStreamReader(System.in));
		
		
		fic = OutilsFichier.ouvrirFicTexteLecture("testAjoutCommande");
		
		OutilsLecture.fic = fic;
		OutilsLecture.type = 'F';
		
		
		cantineTest.ajouterCommandes();
		
		// terre = 2 pour Jean
		assertEquals(2, cantineTest.listeClient.get(0).listeProduit.get(1).getQte());
		
		// poutine = 6 pour joe
		assertEquals(6, cantineTest.listeClient.get(2).listeProduit.get(0).getQte());


	}
}
