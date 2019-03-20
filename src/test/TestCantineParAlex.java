package test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import mainApp.Cantine;
import mainApp.Client;
import mainApp.Produit;
import outilsjava.OutilsFichier;
import outilsjava.OutilsLecture;

public class TestCantineParAlex {

	
	Cantine test;

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		test = new Cantine();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testformatClientValide() {
		
		String client = "Jean";
		assertEquals(true, test.formatClientOk(client));
		
		client = "Jean-Paul";
		assertEquals(true, test.formatClientOk(client));
		

	}
	
	@Test
	public void testformatClientInValide() {
		
		String client = "Jean Paul";
		assertEquals(false, test.formatClientOk(client));
		
		
		client = "Jean 1";
		assertEquals(false, test.formatClientOk(client));
		
		client = "Jean- 1 2";
		assertEquals(false, test.formatClientOk(client));
		
		client = "pier 1 2";
		assertEquals(false, test.formatClientOk(client));

		client = "";
		assertEquals(false, test.formatClientOk(client));
	}
	
	
	@Test
	public void testformatPlatValide() {
		
		String plat = "Frite 1";
		assertEquals(true, test.formatPlatOk(plat));
		
		plat = "JAMBON 56.65";
		assertEquals(true, test.formatPlatOk(plat));
		
		plat = "Poitrine-de-Dinde 57.45";
		assertEquals(true, test.formatPlatOk(plat));
		
		plat = "PizZA 2231";
		assertEquals(true, test.formatPlatOk(plat));
		
		
	}
	
	@Test
	public void testformatPlatInValide() {
		
		String plat = "Frite patate 2.56";
		assertEquals(false, test.formatPlatOk(plat));
		
		plat = "JAMBON 46,34";
		assertEquals(false, test.formatPlatOk(plat));
		
		plat = "Poitrine-de-Dinde";
		assertEquals(false, test.formatPlatOk(plat));
		
		
		plat = "Poitrine-de-Dinde 0";
		assertEquals(false, test.formatPlatOk(plat));
		
		plat = "Poitrine-de-Dinde -560";
		assertEquals(false, test.formatPlatOk(plat));
		
		plat = "2231";
		assertEquals(false, test.formatPlatOk(plat));
		
		plat = "";
		assertEquals(false, test.formatPlatOk(plat));
		
		
	}
	
	@Test
	public void testformatCommandeValide() {
		
		String commande = "Jean Patate 5";
		assertEquals(true, test.formatCommandeOk(commande));
		
		commande = "Jean-pierre pIZZa 5";
		assertEquals(true, test.formatCommandeOk(commande));
		
		commande = "Jean Poitrine-de-din_de 200";
		assertEquals(true, test.formatCommandeOk(commande));
		
		commande = "ROG_ER Pat-ate 1";
		assertEquals(true, test.formatCommandeOk(commande));
		
	}
	
	
	@Test
	public void testformatCommandeInValide() {
		
		String commande = "Jean_Patate 5";
		assertEquals(false, test.formatCommandeOk(commande));
		
		 commande = "Jean Patate 5,2";
		assertEquals(false, test.formatCommandeOk(commande));		
		
		 commande = "Jean Patate -5,2";
		assertEquals(false, test.formatCommandeOk(commande));
		
		commande = "Jean-pierre pIZZa -5";
		assertEquals(false, test.formatCommandeOk(commande));
		
		commande = "Jean-pierre 5 pizza";
		assertEquals(false, test.formatCommandeOk(commande));
		
		commande = "ROG_ER Pat te 1";
		assertEquals(false, test.formatCommandeOk(commande));
		
		commande = "4545";
		assertEquals(false, test.formatCommandeOk(commande));
		
		commande = "0";
		assertEquals(false, test.formatCommandeOk(commande));
		commande = "";
		assertEquals(false, test.formatCommandeOk(commande));
		
	}
	
	
	@Test
	public void testformatCommandeValide3() {
		test = new Cantine();
		
		Client ctemp = new Client("Paul");
		test.listeClient.add(ctemp);
		ctemp = new Client("Pierre");
		test.listeClient.add(ctemp);
		ctemp = new Client("Jean");
		test.listeClient.add(ctemp);
		ctemp = new Client("Simon");
		test.listeClient.add(ctemp);
		ctemp = new Client("Jean-pierre");
		test.listeClient.add(ctemp);
		
		
		for ( Client c : test.listeClient ) {
			Produit produit = new Produit("Patate", 5.5);
			c.ajouterProduit(produit);
		}
		
		assertEquals(true, test.commandeValide("Simon", "Patate"));
	}
	
	
	@Test
	public void testformatCommandeValide2() {
		Client ctemp = new Client("Paul");
		test.listeClient.add(ctemp);
		ctemp = new Client("Pierre");
		test.listeClient.add(ctemp);
		ctemp = new Client("Jean");
		test.listeClient.add(ctemp);
		ctemp = new Client("Simon");
		test.listeClient.add(ctemp);
		ctemp = new Client("Jean-pierre");
		test.listeClient.add(ctemp);
		

		assertEquals(false, test.commandeValide("Simon", "Patate"));
		
		
		test = new Cantine();
		
		ctemp = new Client("Paul");
		test.listeClient.add(ctemp);
		ctemp = new Client("Pierre");
		test.listeClient.add(ctemp);
		ctemp = new Client("Jean");
		test.listeClient.add(ctemp);
		ctemp = new Client("Jean-pierre");
		test.listeClient.add(ctemp);
		
		
		for ( Client c : test.listeClient ) {
			Produit produit = new Produit("Patate", 5.5);
			c.ajouterProduit(produit);
		}
		
		assertEquals(false, test.commandeValide("Simon", "Patate"));
		
	}
	
	
}
