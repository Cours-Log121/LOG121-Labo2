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
 * Classe qui est l'objet Rectangle
 * qui contient un Carre, une ligne et un Rectangle dependant de son type
 * @author Daniel Enachescu, Guy Pomerleau
 *
 */
public class Rectangle extends Forme{
	
	public enum TypeFormeRectangle{
		CARRE, RECTANGLE, LIGNE
	}
	
	private int coordonneeXUn;
	private int coordonneeXDeux;
	private int coordonneeYUn;
	private int coordonneeYDeux;
	private TypeFormeRectangle typeFormeRectangle;
	
	
	public Rectangle(){		
	}	

	public Rectangle(Color couleur, int coordonneeXUn, int coordonneeXDeux, int coordonneeyUn,
			int coordonneeyDeux2, TypeFormeRectangle typeFormeRectangle) {
		super(couleur);
		this.coordonneeXUn = coordonneeXUn;
		this.coordonneeXDeux = coordonneeXDeux;
		this.coordonneeYUn = coordonneeyUn;
		this.coordonneeYDeux = coordonneeyDeux2;
		this.typeFormeRectangle = typeFormeRectangle;  
	}

	public int getCoordonneeXUn() {
		return coordonneeXUn;
	}

	public void setCoordonneeXUn(int coordonneeXUn) {
		this.coordonneeXUn = coordonneeXUn;
	}

	public int getCoordonneeXDeux() {
		return coordonneeXDeux;
	}

	public void setCoordonneeXDeux(int coordonneeXDeux) {
		this.coordonneeXDeux = coordonneeXDeux;
	}

	public int getCoordonneeYUn() {
		return coordonneeYUn;
	}

	public void setCoordonneeYUn(int coordonneeYUn) {
		this.coordonneeYUn = coordonneeYUn;
	}

	public int getCoordonneeYDeux() {
		return coordonneeYDeux;
	}

	public void setCoordonneeYDeux(int coordonneeYDeux) {
		this.coordonneeYDeux = coordonneeYDeux;
	}

	public TypeFormeRectangle getTypeFormeRectangle() {
		return typeFormeRectangle;
	}

	public void setTypeFormeRectangle(TypeFormeRectangle typeFormeRectangle) {
		this.typeFormeRectangle = typeFormeRectangle;
	}

	@Override
	public String toString() {
		return "Rectangle [coordonneeXUn=" + coordonneeXUn
				+ ", coordonneeXDeux=" + coordonneeXDeux + ", coordonneeYUn="
				+ coordonneeYUn + ", coordonneeYDeux=" + coordonneeYDeux
				+ ", typeFormeRectangle=" + typeFormeRectangle + "]";
	}	

}
