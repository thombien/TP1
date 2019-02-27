package mainApp;

import java.util.ArrayList;

import outilsjava.OutilsConstantes;

public class Cantine implements OutilsConstantes{

	String ligne;
	

	ArrayList<Client> listeClient;
	
	public Cantine() {
		
		listeClient = new ArrayList<>();
		
		System.out.println("\nBienvenue chez Barette !");
		
		ligne = outilsjava.OutilsLecture.lireChaine("");
		
		if ( ligne.equals("Clients :") ) {
			ajouterClient();
		}
		
		
		if ( ligne.equals("Plats :") ) {
			ajotouterPlats();
		}

		
		if( ligne.equals("Commandes :") ){
			ajouterCommandes();
		}
		

		System.out.println("Factures:");
		
		for ( Client c : listeClient ) {
			c.calculerPrix();
		}
	}
	
	private void ajouterClient() {
		ligne = outilsjava.OutilsLecture.lireChaine("");
		
		while ( !ligne.equals("Plats :") ) {
			
			try {
			Client ctemp = new Client(ligne);
			
			listeClient.add( ctemp );
			} catch (Exception e) {

			}
			
			ligne = outilsjava.OutilsLecture.lireChaine("");
		}
	}
	
	private void ajotouterPlats() {
		ligne = outilsjava.OutilsLecture.lireChaine("");
		
		while ( !ligne.equals("Commandes :") ) {
			try {
			String[] ligneProduti = ligne.split(" ");
		


			for ( Client c : listeClient ) {
				Produit produit = new Produit(ligneProduti[0],Double.parseDouble(ligneProduti[1]));
				c.ajouterProduit(produit);
			}
			
			} catch (Exception e) {

			}
			
			ligne = outilsjava.OutilsLecture.lireChaine("");
			
		}
	}
	
	private void ajouterCommandes() {
		ligne = outilsjava.OutilsLecture.lireChaine("");
		
		while ( !ligne.equals("Fin") ) {
			String[] ligneProduit = ligne.split(" ");
			
			for ( Client c : listeClient ) {
				if( c.getNom().equals(ligneProduit[0]) ) {
					for ( Produit p : c.listeProduit ) {
						if( p.getNom().equals(ligneProduit[1]) ) {
							p.setQte( Integer.parseInt(ligneProduit[2]) );
						}
					}
				}
			}
			
			
			ligne = outilsjava.OutilsLecture.lireChaine("");
		}
	}
	
	private void genererFacture() {
		System.out.println("Factures:");
		
		for ( Client c : listeClient ) {
			c.calculerPrix();
		}
	}
}
