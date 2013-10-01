/******************************************************
Cours: LOG121
Session : A2013
Groupe : 03
Projet: Laboratoire #1
Etudiant(e)(s): Daniel Enachescu, Guy Pomerleau
Code(s) perm.:ENAD25079107, POMG26117702
Charge de cours:Dominic St Jacques
Charges de labo : Alvine Boaye Belle et Mathieu Binette
Nomdu fichier:ConteneurForme.java
Date cree : 2013/09/25
Date dern.modif. 2013/09/25 
**/

package com.clientformes.utils;

import com.clientformes.bean.Forme;

/**
 * 
 * @author Daniel Enachescu, Guy Pomerleau
 * Classe qui contient toutes les formes dans un tableau
 */
public class ConteneurForme {
	
	private Forme[] tabFormes = new Forme[10];
	private static ConteneurForme instance = null;
	
	/**
	 * Constructeur vide
	 */
	private ConteneurForme(){
		
	}
	
	/**
	 * Initialise une instance de cette classe et la renvoie
	 * @return ConteneurForme
	 */
	public static synchronized ConteneurForme getInstance(){
		if(instance == null){
			instance = new ConteneurForme();
		}
		return instance;
	}
	
	public Forme[] getTabFormes(){
		return this.tabFormes;
	}
	
	/**
	 * Ajoute une forme a la fin du conteneur
	 * @param Forme 
	 * @return Tableau content les formes
	 */
	public Forme[] ajouterForme(Forme forme){
		for (int i = 0; i < tabFormes.length; i++) {
			if (i == tabFormes.length-1) {
				if(tabFormes[i] != null)
					decalerTableauForme();
				tabFormes[tabFormes.length-1] = forme;
			}			
				
			if (tabFormes[i] == null) {
				tabFormes[i] = forme;
				break;
			}
		}
		return tabFormes;
	}
	
	/**
	 * Decaler le tableau de droite a gauche
	 */
	private void decalerTableauForme(){		
		for(int i = 1; i < tabFormes.length ; i++){
			tabFormes[i-1] = tabFormes[i];
		}
	}

}
