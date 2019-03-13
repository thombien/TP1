package mainApp;

import java.util.ArrayList;

import outilsjava.OutilsConstantes;

public class Cantine implements OutilsConstantes{

	public Cantine() {
		
		String ligne;
		
		System.out.println("\nBienvenue chez Barette !");

		ArrayList<Client> listeClient = new ArrayList<>();
		
		ligne = outilsjava.OutilsLecture.lireChaine("");
		
		if (ligne.equals("Clients :")) {
			ligne = outilsjava.OutilsLecture.lireChaine("");
		}
		
		while (!ligne.equals("Plats :")) {
			
			try {
			Client ctemp = new Client(ligne);
			
			listeClient.add(ctemp);
			} catch (Exception e) {

			}
			
			ligne = outilsjava.OutilsLecture.lireChaine("");
		}
		
		if ( ligne.equals("Plats :")) {
			ligne = outilsjava.OutilsLecture.lireChaine("");
			

		}
		while (!ligne.equals("Commandes :")) {
			try {
			String[] ligneProduti = ligne.split(" ");
		


			for (Client c : listeClient) {
				Produit produit = new Produit(ligneProduti[0],Double.parseDouble(ligneProduti[1]));
				c.ajouterProduit(produit);
			}
			
			} catch (Exception e) {

			}
			
			ligne = outilsjava.OutilsLecture.lireChaine("");
			
		}

		
		ligne = outilsjava.OutilsLecture.lireChaine("");
		
		while (!ligne.equals("Fin")) {
			String[] ligneProduit = ligne.split(" ");
			
			for (Client c : listeClient) {
				if(c.getNom().equals(ligneProduit[0])) {
					for (Produit p : c.listeProduit) {
						if(p.getNom().equals(ligneProduit[1])) {
							p.setQte(Integer.parseInt(ligneProduit[2]));
						}
					}
				}
			}
			
			
			ligne = outilsjava.OutilsLecture.lireChaine("");
		}
		System.out.println("Factures:");
		
		for (Client c : listeClient) {
			c.calculerPrix();
		}
		
	}

	public static double[] calculTaxes(double d, double e, double f) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void calculTotal() {
		d
		
	}
}
