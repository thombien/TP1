/**
 * Auteure : Soti
 * Fichier : OutilsAffichage.java
 * Package : outilsjava
 * Date    : Hiver 2018
 * Cours   : Programmation avec Java
 */

// La classe OutilsAffichage fait partie du package outilsjava.

package outilsjava;

// Package du syst�me.
import java.text.*;
import java.util.Locale;

/**
 * Classe qui contient certaines m�thodes utilitaires d'affichage. Cette classe
 * fait partie du package outilsjava.
 */

public class OutilsAffichage {

	/**
	 * On d�finit le constructeur private pour emp�cher la cr�ation d'instances
	 * de la classe OutilsAffichage.
	 */
	
	private OutilsAffichage() {
	}

	/**
	 * La m�thode publique afficherChoisirMenu() permet d'afficher un menu et
	 * de lire le choix de l'utilisateur.
	 * 
	 * @param menu
	 *            La cha�ne de caract�res contenant le menu � afficher.
	 * @param choixMin
	 *            Le caract�re contenant le premier choix du menu.
	 * @param choixMax
	 *            Le caract�re contenant le dernier choix du menu.
	 * @return Le caract�re contenant le choix de l'utilisateur en majuscule.
	 */

	public static char afficherChoisirMenu( String menu,
										    char choixMin, char choixMax ) {
		char choixLu;

		System.out.println( menu );

		choixLu = OutilsLecture.lireCaractereValide( "\nEntrez votre choix : ",
													 choixMin, choixMax );
		return choixLu;
	}

	/**
	 * La m�thode publique formaterNb() permet de formater un nombre dans
	 * le format 9 999,99.
	 * 
	 * @param nb
	 *            Le nombre � formater.
	 * @param dec
	 *            Le nombre de d�cimales � mettre apr�s la virgule.
	 * @return La cha�ne de caract�res contenant le nombre format�.
	 */

	public static String formaterNb( double nb, int dec ) {
		NumberFormat formatNb = 
				NumberFormat.getNumberInstance( Locale.CANADA_FRENCH );

		formatNb.setMinimumIntegerDigits(1);
		formatNb.setMinimumFractionDigits(dec);
		formatNb.setMaximumFractionDigits(dec);

		return formatNb.format( nb );
	}

	/**
	 * La m�thode publique formaterMonetaire() permet de formater un
	 * nombre dans le format 9 999,99 $.
	 * 
	 * @param nb
	 *            Le nombre � formater.
	 * @param dec
	 *            Le nombre de d�cimales � mettre apr�s la virgule.
	 * @return La cha�ne de caract�res contenant le nombre format�.
	 */

	public static String formaterMonetaire( double nb, int dec ) {
		NumberFormat formatNb = 
				NumberFormat.getCurrencyInstance( Locale.CANADA_FRENCH );

		formatNb.setMinimumIntegerDigits(1);
		formatNb.setMinimumFractionDigits(dec);
		formatNb.setMaximumFractionDigits(dec);

		return formatNb.format( nb );
	}

	/**
	 * La m�thode publique formaterPourcentage() permet de formater un
	 * nombre dans le format 9 999,99 %.
	 * 
	 * @param nb
	 *            Le nombre � formater.
	 * @param dec
	 *            Le nombre de d�cimales � mettre apr�s la virgule.
	 * @return La cha�ne de caract�res contenant le nombre format�.
	 */

	public static String formaterPourcentage( double nb, int dec ) {
		NumberFormat formatNb = 
				NumberFormat.getPercentInstance( Locale.CANADA_FRENCH );

		formatNb.setMinimumIntegerDigits(1);
		formatNb.setMinimumFractionDigits(dec);
		formatNb.setMaximumFractionDigits(dec);

		return formatNb.format( nb );
	}
}