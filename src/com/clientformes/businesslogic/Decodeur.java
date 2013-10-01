/******************************************************
Cours: LOG121
Session : A2013
Groupe : 03
Projet: Laboratoire #1
Etudiant(e)(s): Daniel Enachescu, Guy Pomerleau
Code(s) perm.:ENAD25079107, POMG26117702
Charge de cours:Dominic St Jacques
Charges de labo : Alvine Boaye Belle et Mathieu Binette
Nomdu fichier:Forme.java
Date cree : 2013/09/16
Date dern.modif. 2013/09/16 
**/

package com.clientformes.businesslogic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ca.etsmtl.log.util.IDLogger;

/**
 * 
 * @author Daniel Enachescu, Guy Pomerleau
 * Classe permettant de decoder la string envoye du serveur avec un regex et ajouter
 * le numero de sequence dans un fichier
 */
public class Decodeur {	
	
	private static Pattern pattern = Pattern.compile("^([0-9]*) <([A-Z]*)> ([0-9 ]*)</([A-Z]*)>");
	private static String[] tabDescriptionForme = new String[3];
	
	/**
	 * Decode la chaine de charactere
	 * @param descriptionForme  String
	 * @return tableau de String[]
	 */
	public static String[] decoderDescriptionForme(String descriptionForme){
		Matcher charactereEgal = pattern.matcher(descriptionForme);
		if(charactereEgal.find()){
			tabDescriptionForme[0] = charactereEgal.group(1);
			tabDescriptionForme[1] = charactereEgal.group(2);
			tabDescriptionForme[2] = charactereEgal.group(3);
		}
		
		IDLoggerInsertionFichier(Integer.parseInt(tabDescriptionForme[0]));
		
		return tabDescriptionForme;
	}
	
	private static void IDLoggerInsertionFichier(int sequence){
		IDLogger logger = IDLogger.getInstance();
		logger.logID(sequence);
	}
	
}


