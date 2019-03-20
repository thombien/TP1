package mainApp;

import java.util.ArrayList;

import outilsjava.OutilsConstantes;

public class Cantine implements OutilsConstantes{

	final double TVQ = 0.10;
	final double TPS = 0.05;
	
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
		String facture =  "Facture \n";

	}
	
	public double[] calculTaxes(double tvq, double tps, double montant) {
		
		double[] tableauTaxes = new double[3];
		tableauTaxes[0] = Math.round(tvq * montant*100)/100.00;
		tableauTaxes[1] = Math.round(tps * montant*100)/100.00;
		tableauTaxes[2] = Math.round((montant + tableauTaxes[0] + tableauTaxes[1])*100)/100.00;
		
		
		return tableauTaxes;
		
	}
	
	
	public void calculTotal() {
		
		double  total;
		double[] tableauMontants;
		for ( Client c : listeClient ) {
		
			total = c.calculerPrixSansTaxe();
			tableauMontants = calculTaxes(TVQ, TPS, total);
			c.totalAvecTaxes = tableauMontants[2];
			
		}

		
	}

}
