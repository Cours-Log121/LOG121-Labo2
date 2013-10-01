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
 * Classe qui est l'objet Ovale
 * qui contient un Ovale et un Cercle dependant de son type
 * @author Daniel Enachescu, Guy Pomerleau
 *
 */
public class Ovale extends Forme {
	
	public enum TypeFormeOvale{
		CERCLE, OVALE
	}
	
	private int centreX;
	private int centreY;
	private int rayonX;
	private int rayonY;
	private TypeFormeOvale typeFormeOvale;
	
	public Ovale(){		
	}

	public Ovale(Color couleur, int centreX, int centreY, int rayonX, int rayonY,
			TypeFormeOvale typeFormeOvale) {
		super(couleur);
		this.centreX = centreX;
		this.centreY = centreY;
		this.rayonX = rayonX;
		this.rayonY = rayonY;
		this.typeFormeOvale = typeFormeOvale;
	}

	public int getCentreX() {
		return centreX;
	}

	public void setCentreX(int centreX) {
		this.centreX = centreX;
	}

	public int getCentreY() {
		return centreY;
	}

	public void setCentreY(int centreY) {
		this.centreY = centreY;
	}

	public int getRayonX() {
		return rayonX;
	}

	public void setRayonX(int rayonX) {
		this.rayonX = rayonX;
	}

	public int getRayonY() {
		return rayonY;
	}

	public void setRayonY(int rayonY) {
		this.rayonY = rayonY;
	}

	public TypeFormeOvale getTypeFormeOvale() {
		return typeFormeOvale;
	}

	public void setTypeFormeOvale(TypeFormeOvale typeFormeOvale) {
		this.typeFormeOvale = typeFormeOvale;
	}

	@Override
	public String toString() {
		return "Ovale [centreX=" + centreX + ", centreY=" + centreY
				+ ", rayonX=" + rayonX + ", rayonY=" + rayonY
				+ ", typeFormeOvale=" + typeFormeOvale + "]";
	}
	
	
}
