package tp1QA;

import java.io.*;

public class CV {
	
	private String nom;
	private String prenom;
	private String formation;
	private int nbAnneesExp;
	private String competence;
	private String attentes;

	public static void main(String[] args) {
		System.out.println("Bienvenue chez Barette!\n");
		CV employeUn = new CV("Aoun", "Karl", "DES (Diplôme d'étude secondaire)", 2,
				"4 session technique informatique, technicien de point de vente 3 ans", "utilisation de Git");
		
		CV employeDeux = new CV("David", "Lavigueur", "DES (Diplôme d'étude secondaire)", 2,
				"4 session technique informatique", "Cours interactif et dynamique");
		employeUn.affiche();
		employeDeux.affiche();

	}

	public CV() {

	}

	public CV(String pnom, String pprenom, String pformation, int pnbAnneesExp, String pcompetence, String pattentes) {

		 nom = pnom;
		 prenom = pprenom;
		 formation = pformation;
		 nbAnneesExp = pnbAnneesExp;
		 competence = pcompetence;
		  attentes = pattentes;

	}

	public void affiche() {
		System.out.println("Nom : "+ nom);
		System.out.println("Prénom : " + prenom);
		System.out.println("formation : " + formation);
		System.out.println("années d'expériences : "+nbAnneesExp+" an(s)");
		System.out.println("compétences : "+competence);
		System.out.println("attentes : "+attentes);
		System.out.println("\n");
		
	}
}
