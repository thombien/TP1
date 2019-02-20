/**
 * Auteure : Soti
 * Fichier : OutilsMath.java
 * Package : outilsjava
 * Date    : Automne 2018
 * Cours   : Programmation avec Java
 */

// La classe OutilsMath fait partie du package outilsjava.

package outilsjava;

/**
 * La classe OutilsMath contient des fonctions math�matiques que l'on ne
 * trouvent pas dans la classe Math et qui peuvent �tre tr�s utiles dans les
 * programmes Java.
 */

public class OutilsMath {

	/**
	 * La m�thode publique statique factoriel() permet de calculer et de
	 * retourner le factoriel d'un nombre.
	 * 
	 * @param nb
	 *            Le nombre dont on d�sire le factoriel.
	 * @return Le factoriel du nombre re�u en param�tre.
	 */

	public static int factoriel( int nb ) {
		int produit = 1;

		for ( int i = 1; i <= nb; ++i ) {
			produit *= i;
		}

		return produit;
	}

	/**
	 * La m�thode publique statique hasard() permet de g�n�rer un nombre entier
	 * al�atoire entre un nombre minimum (>=0) et un nombre maximum inclus.
	 * 
	 * @param min
	 *            Le nombre minimum.
	 * @param max
	 *            Le nombre maximum
	 * 
	 * @return Le nombre entier al�atoire entre min (inclus) et max (inclus).
	 */

	public static int hasard( int min, int max ) {

		// Math.random() retourne un double entre 0 (inclus) et 1 (exclu).
		// Ici on veut un nombre entier entre min (inclus) et max (inclus).

		return (int) ( ( Math.random() * ( max - min + 1 ) ) + min );
	}
}