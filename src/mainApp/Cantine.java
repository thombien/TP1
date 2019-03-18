package mainApp;

import java.util.ArrayList;
import java.util.Iterator;

import outilsjava.OutilsConstantes;

public class Cantine implements OutilsConstantes{

	String ligne;
	

	ArrayList<Client> listeClient;
	
	
	public Cantine() {
		listeClient = new ArrayList<>();
	}
	
	public Cantine(String main) {
		
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
	
	public boolean commandeValide( String nomClient,String nomProduit) {
		
		boolean commandeVal = false;
		
		for (Client client : listeClient) {
			
			if(nomClient == client.getNom()) {
				
				for (Produit produit : client.listeProduit) {
					if(nomProduit == produit.getNom()) {
						
						commandeVal = true;
					}
				}
			}
		}
		return commandeVal;
		
	}
	
	public boolean formatClientOk(String client) {
		
		boolean valide = true;
		if(client == "") {
			valide = false;

		}else {
			char[] nomTab =  client.toCharArray();
			
			for (char c : nomTab) {
				
				if(c == ' ') {
					valide = false;
				}else {
					if(Character.isDigit(c)) {
						valide = false;
					}
				}
			}
		}
		
		return valide;
	}
	
	public boolean formatPlatOk(String plat) {
		
		boolean valide = true;
		
		if(plat == "") {
			
			valide = false;
		}else {
			String[] tabPlat = plat.split(" "); 
			if(tabPlat.length != 2) {
				valide = false;
			}else {
				try {
				
				double prix= Double.parseDouble(tabPlat[1]);
				
				if(prix <= 0) {
					valide = false;
				}
				}catch (Exception ex){
					valide = false;
				}
			}
		}
		
		return valide;
	}
	public boolean formatCommandeOk(String commande) {
		
		boolean valide = true;
		
		if(commande == "") {
			valide = false;

		}else {
			String[] comTab =  commande.split(" ");
			
			if(comTab.length != 3) {
				valide = false;
			}else {
				
				try {
					int qte = Integer.parseInt(comTab[2]);
					if(qte <= 0 ) {
						valide = false;
					}
				}catch(Exception exc) {
					valide = false;
				}
			}
		}
		return valide;
	}
	private void genererFacture() {
		System.out.println("Factures:");
		
		for ( Client c : listeClient ) {
			c.calculerPrix();
		}
	}
}
