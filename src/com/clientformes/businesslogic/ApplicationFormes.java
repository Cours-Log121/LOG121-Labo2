/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: ApplicationFormes.java
Date cree: 2013/05/03
*******************************************************
Historique des modifications
Etudiant(e)(s): Daniel Enachescu, Guy Pomerleau
Code(s) perm.:ENAD25079107, POMG26117702
*******************************************************
*@author Patrice Boucher
2013/05/03 Version initiale
Modifiee:2013/09/25
*******************************************************/

package com.clientformes.businesslogic; 

/**
 * Cette classe represente l'application dans son ensemble. 
 * @author Patrice Boucher
 * @date 2013/05/04
 */
public class ApplicationFormes{
	/**
	 * main de l'application
	 * @param args
	 */
	public static void main(String[] args) {
		new ApplicationFormes();
	}
	
	/**
	 * Constructeur
	 */
	public ApplicationFormes(){
			
		FenetrePrincipale fenetre = new FenetrePrincipale();
		CommBase comm = new CommBase(this);
		comm.setPropertyChangeListener(fenetre);
	}
	
}
