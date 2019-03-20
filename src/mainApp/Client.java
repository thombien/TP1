package mainApp;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;

public class Client {
	private String nom;
	ArrayList<Produit> listeProduit;
	public double totalAvecTaxes;

	public Client() {

	}

	public Client(String nom) {
		this.nom = nom;
		listeProduit = new ArrayList<>();
	}

	public void ajouterProduit(Produit produit) {

		this.listeProduit.add(produit);
	}

	public double calculerPrixSansTaxe() {
		
		double total = 0;
		
		Produit[] produits = new Produit[listeProduit.size()];
		
		produits = listeProduit.toArray(produits);
		
		for(int i = 0; i < produits.length; i++) {
			
			total += produits[i].getPrix()*produits[i].getQte();
		}
		return total;
	}
	public String getNom(){
		
		return this.nom;
	}

}
