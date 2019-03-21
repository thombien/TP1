package mainApp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


import outilsjava.OutilsConstantes;

public class Cantine implements OutilsConstantes {

	final double TVQ = 0.10;
	final double TPS = 0.05;

	public String ligne;
	public String sortie = "";

	public ArrayList<Client> listeClient;
	public final String CMD = "user.dir";
	
	public Cantine() {
		listeClient = new ArrayList<>();
	}

	public Cantine(String main) {

		listeClient = new ArrayList<>();

		System.out.println("\nBienvenue chez Barette !");

		ligne = outilsjava.OutilsLecture.lireChaine("");

		if (ligne.equals("Clients :")) {
			ajouterClient();
		}

		if (ligne.equals("Plats :")) {
			ajotouterPlats();
		}

		if (ligne.equals("Commandes :")) {
			ajouterCommandes();
		}

		if(ligne.equals("Fin")) {
			genererFacture();
		}

	}

	public void ajouterClient() {
		ligne = outilsjava.OutilsLecture.lireChaine("");

		while (!ligne.equals("Plats :") || ligne == null ) {

			if (formatClientOk(ligne)) {

				try {
					Client ctemp = new Client(ligne);

					listeClient.add(ctemp);
				} catch (Exception e) {

				}
			}

			ligne = outilsjava.OutilsLecture.lireChaine("");
		}
	}

	public void ajotouterPlats() {
		ligne = outilsjava.OutilsLecture.lireChaine("");

		while (!ligne.equals("Commandes :") || ligne == null) {

			if (formatPlatOk(ligne)) {
				try {
					String[] ligneProduti = ligne.split(" ");

					for (Client c : listeClient) {
						Produit produit = new Produit(ligneProduti[0], Double.parseDouble(ligneProduti[1]));
						c.ajouterProduit(produit);
					}

				} catch (Exception e) {

				}

			}

			ligne = outilsjava.OutilsLecture.lireChaine("");

		}
	}

	public void ajouterCommandes() {
		ligne = outilsjava.OutilsLecture.lireChaine("");

		while (!ligne.equals("Fin") || ligne == null) {

			if (formatCommandeOk(ligne)) {
				String[] ligneProduit = ligne.split(" ");

				if(commandeValide(ligneProduit[0], ligneProduit[1])) {
				
				for (Client c : listeClient) {
					if (c.getNom().equals(ligneProduit[0])) {
						for (Produit p : c.listeProduit) {
							if (p.getNom().equals(ligneProduit[1])) {
								p.setQte(Integer.parseInt(ligneProduit[2]));
							}
						}
					}
				}
				
				}	
		
			}

			ligne = outilsjava.OutilsLecture.lireChaine("");
		}
	}

	public boolean commandeValide(String nomClient, String nomProduit) {

		boolean commandeVal = false;

		for (Client client : listeClient) {

			if (nomClient.equals(client.getNom())) {

				for (Produit produit : client.listeProduit) {
					if (nomProduit.equals(produit.getNom())) {

						commandeVal = true;
					}
				}
			}
		}
		return commandeVal;

	}

	public boolean formatClientOk(String client) {

		boolean valide = true;
		if (client == "") {
			valide = false;

		} else {
			char[] nomTab = client.toCharArray();

			for (char c : nomTab) {

				if (c == ' ') {
					valide = false;
					sortie += "Erreur " + client + " : format du client invalide\n";
				} else {
					if (Character.isDigit(c)) {
						valide = false;
						sortie += "Erreur " + client + " : format du client invalide\n";
					}
				}
			}
		}

		return valide;
	}

	public boolean formatPlatOk(String plat) {

		boolean valide = true;

		if (plat == "") {

			valide = false;

			sortie += "Erreur " + plat + " : format du plat invalide\n";
		} else {
			String[] tabPlat = plat.split(" ");
			if (tabPlat.length != 2) {
				valide = false;
				sortie += "Erreur " + plat + " : format du plat invalide\n";
			} else {
				try {

					double prix = Double.parseDouble(tabPlat[1]);

					if (prix <= 0) {
						valide = false;
						sortie += "Erreur " + plat + " : format du plat invalide\n";
					}
				} catch (Exception ex) {
					valide = false;
					sortie += "Erreur " + plat + " : format du plat invalide\n";
				}
			}
		}

		return valide;
	}

	public boolean formatCommandeOk(String commande) {

		boolean valide = true;

		if (commande == "") {
			valide = false;
			sortie += "Erreur " + commande + " : format de la commande invalide\n";

		} else {
			String[] comTab = commande.split(" ");

			if (comTab.length != 3) {
				valide = false;
				sortie += "Erreur " + commande + " : format de la commande invalide\n";
			} else {

				try {
					int qte = Integer.parseInt(comTab[2]);
					if (qte <= 0) {
						valide = false;
						sortie += "Erreur " + commande + " : format de la commande invalide\n";
					}
				} catch (Exception exc) {
					valide = false;
					sortie += "Erreur " + commande + " : format de la commande invalide\n";
				}
			}
		}
		return valide;
	}

	private void genererFacture() {

		calculTotal();
		
		sortie += "\nFacture  Prix";
		for (Client client : listeClient) {
			if(client.totalAvecTaxes != 0) {
			sortie += "\r\n" + client.getNom() + " : " + client.totalAvecTaxes;
			}
		}
		
		String startDir = System.getProperty(CMD);
		File f = new File(startDir + "/Facture-du-" + time() + ".txt");
		
		try (PrintWriter pw = new PrintWriter(new FileWriter(f))) {

				pw.write(sortie);
		} catch (IOException exc) {

		}
		System.out.println(sortie);

	}
	public String time() {
		return java.time.LocalDate.now() + "-" 
				+ java.time.LocalTime.now().getHour() + "-" + java.time.LocalTime.now().getMinute();
		
	}

	public double[] calculTaxes(double tvq, double tps, double montant) {

		double[] tableauTaxes = new double[3];
		tableauTaxes[0] = Math.round(tvq * montant * 100) / 100.00;
		tableauTaxes[1] = Math.round(tps * montant * 100) / 100.00;
		tableauTaxes[2] = Math.round((montant + tableauTaxes[0] + tableauTaxes[1]) * 100) / 100.00;

		return tableauTaxes;

	}

	public void calculTotal() {

		double total;
		double[] tableauMontants;
		for (Client c : listeClient) {

			total = c.calculerPrixSansTaxe();
			tableauMontants = calculTaxes(TVQ, TPS, total);
			c.totalAvecTaxes = tableauMontants[2];

		}

	}

}
