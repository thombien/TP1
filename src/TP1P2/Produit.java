package TP1P2;

public class Produit {
	private String nom;
	private double prix;
	private int qte;

	public Produit() {

	}

	public Produit(String nom, double prix) {
		this.nom = nom;
		this.prix = prix;
		this.qte = 0;
	}

	public String getNom() {
		return this.nom;
	}

	public double getPrix() {
		return this.prix;
	}

	public int getQte() {
		return this.qte;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}
}
