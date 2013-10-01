/******************************************************
Cours: LOG121
Session : A2013
Groupe : 03
Projet: Laboratoire #1
Etudiant(e)(s): Daniel Enachescu, Guy Pomerleau
Code(s) perm.:ENAD25079107, POMG26117702
Charge de cours:Dominic St Jacques
Charges de labo : Alvine Boaye Belle et Mathieu Binette
Nomdu fichier:GenererForme.java
Date cree : 2013/09/26
Date dern.modif. 2013/09/26 
**/

package com.clientformes.businesslogic;

import com.clientformes.bean.Forme;
import com.clientformes.bean.Ovale;
import com.clientformes.bean.Rectangle;
import com.clientformes.bean.Ovale.TypeFormeOvale;
import com.clientformes.bean.Rectangle.TypeFormeRectangle;
import com.clientformes.utils.IConstantes;

/**
 * 
 * @author Daniel Enachescu, Guy Pomerleau
 * Classe permetant de generer une forme par rapport a une chaine de caractere
 */
public class GenererForme {
	
	/**
	 * Methode qui prend une String qui contient les donnees d'une forme
	 * et renvoit une Forme contenant les donnees dans la string tout dependant de son type
	 * @param descriptionForme : String
	 * @return Forme
	 */
	public static Forme GenererStringAForme(String descriptionForme){
		Forme formeFinale = null;
		String[] tabDescriptionForme = Decodeur.decoderDescriptionForme(descriptionForme);
		String[] coordonneeForme = tabDescriptionForme[2].split(" ");				
		
		if(tabDescriptionForme[1].equals("CARRE")){
			Rectangle formeRectangle = new Rectangle(IConstantes.COULEUR_BLEU, 
					Integer.parseInt(coordonneeForme[0]), Integer.parseInt(coordonneeForme[1]),
					Integer.parseInt(coordonneeForme[2]), Integer.parseInt(coordonneeForme[3]),
					TypeFormeRectangle.CARRE);
			formeFinale = formeRectangle;
		}
		else if(tabDescriptionForme[1].equals("RECTANGLE")){
			Rectangle formeRectangle = new Rectangle(IConstantes.COULEUR_JAUNE, 
					Integer.parseInt(coordonneeForme[0]), Integer.parseInt(coordonneeForme[1]),
					Integer.parseInt(coordonneeForme[2]), Integer.parseInt(coordonneeForme[3]),
					TypeFormeRectangle.RECTANGLE);
			formeFinale = formeRectangle;
		}
		else if(tabDescriptionForme[1].equals("LIGNE")){
			Rectangle formeRectangle = new Rectangle(IConstantes.COULEUR_MAUVE, 
					Integer.parseInt(coordonneeForme[0]), Integer.parseInt(coordonneeForme[1]),
					Integer.parseInt(coordonneeForme[2]), Integer.parseInt(coordonneeForme[3]),
					TypeFormeRectangle.LIGNE);
			formeFinale = formeRectangle;
		}
		else if(tabDescriptionForme[1].equals("OVALE")){
			Ovale formeOvale = new Ovale(IConstantes.COULEUR_ROUGE,
					Integer.parseInt(coordonneeForme[0]), Integer.parseInt(coordonneeForme[1]),
					Integer.parseInt(coordonneeForme[2]), Integer.parseInt(coordonneeForme[3]),
					TypeFormeOvale.OVALE);
			formeFinale = formeOvale;
		}
		else if(tabDescriptionForme[1].equals("CERCLE")){
			Ovale formeOvale = new Ovale(IConstantes.COULEUR_VERT,
					Integer.parseInt(coordonneeForme[0]), Integer.parseInt(coordonneeForme[1]),
					Integer.parseInt(coordonneeForme[2]), Integer.parseInt(coordonneeForme[2]),
					TypeFormeOvale.CERCLE);
			formeFinale = formeOvale;
		}
		
		return formeFinale;
	}

}
