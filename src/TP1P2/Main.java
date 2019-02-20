package TP1P2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import outilsjava.OutilsFichier;
import outilsjava.OutilsLecture;

public class Main {

	public static void main(String[] args) throws IOException {
		boolean peutContinuer = true;

		String nomFicTest;
		// On assume une lecture des données du clavier.
		BufferedReader fic =
				new BufferedReader(new InputStreamReader(System.in));

		OutilsLecture.fic = fic;

		char type = 'F';

		if (type == OutilsLecture.LECTURE_FICHIER) {

			nomFicTest =
					OutilsFichier.lireNomFichier("\nEntrez le nom "
							+ "du fichier qui contient les jeux d'essai : ");

			fic = OutilsFichier.ouvrirFicTexteLecture(nomFicTest);

			if (fic == null) {
				peutContinuer = false;
			}
		}

		if (peutContinuer) {

			// Lire du clavier ou d'un fichier.
			OutilsLecture.fic = fic;
			OutilsLecture.type = type;

			/**
			 * Une instance de la classe PrincipalTp5 permet de gérer
			 * l'évaluation d'expressions arithmétiques et des sudokus.
			 */

			new PrincipalTP1P2();

		} else {
			System.out.println("\nImpossible de tester le programme.");
		}
	}
}
