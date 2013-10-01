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

package com.clientformes.bean;

import java.awt.Color;

/**
 * Classe qui est l'objet de Forme
 * @author Daniel Enachescu, Guy Pomerleau
 *
 */
public abstract class Forme {
	
	private Color couleur;
	
	public Forme(){		
	}	

	public Forme(Color couleur) {
		this.couleur = couleur;
	}

	public Color getCouleur() {
		return couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}
}
