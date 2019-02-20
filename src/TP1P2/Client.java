package TP1P2;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;

public class Client {
	private String nom;
	ArrayList<Produit> listeProduit;

	public Client() {

	}

	public Client(String nom) {
		this.nom = nom;
		listeProduit = new ArrayList<>();
	}

	public void ajouterProduit(Produit produit) {

		this.listeProduit.add(produit);
	}

	public void calculerPrix() {
		
		double total = 0;
		
		Produit[] produits = new Produit[listeProduit.size()];
		
		produits = listeProduit.toArray(produits);
		
		for(int i = 0; i < produits.length; i++) {
			
			total += produits[i].getPrix()*produits[i].getQte();
		}
		System.out.println(this.nom+" "+total+"$ ");
	}
	public String getNom(){
		
		return this.nom;
	}

}
