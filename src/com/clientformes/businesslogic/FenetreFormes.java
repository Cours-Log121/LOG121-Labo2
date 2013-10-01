package com.clientformes.businesslogic;
/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: FenetreFormes.java
Date cree: 2013/05/03
*******************************************************
Historique des modifications
Etudiant(e)(s): Daniel Enachescu, Guy Pomerleau
Code(s) perm.:ENAD25079107, POMG26117702
*******************************************************
*@author Patrice Boucher
2013/05/03 Version initiale
*******************************************************/  

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;

import com.clientformes.bean.Forme;
import com.clientformes.bean.Ovale;
import com.clientformes.bean.Ovale.TypeFormeOvale;
import com.clientformes.bean.Rectangle;
import com.clientformes.bean.Rectangle.TypeFormeRectangle;
import com.clientformes.utils.ConteneurForme;
import com.clientformes.utils.IConstantes;

/**
 * Cette fenetre gere l'affichage des formes 
 * @author Patrice Boucher
 * @date 2013/05/04
 */
public class FenetreFormes extends JComponent{
	
	private static final long serialVersionUID = -2262235643903749505L;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	public static final Dimension dimension = new Dimension(500,500);
		
	/**
	 * Constructeur
	 */
	public FenetreFormes(){
		//... 
	}
	
	/**
	 * Affiche la liste de formes
	 * @param Graphics
	 */
	@Override 
	public void paintComponent(Graphics graphic){
		Forme[] tabFormes = ConteneurForme.getInstance().getTabFormes();
		
		for(int i = 0 ; i < tabFormes.length; i++){
			if(tabFormes[i] != null)
				graphic.setColor(tabFormes[i].getCouleur());
			
			if(tabFormes[i] instanceof Rectangle){				
				if(((Rectangle)tabFormes[i]).getTypeFormeRectangle() == TypeFormeRectangle.LIGNE)
					graphic.drawLine(((Rectangle)tabFormes[i]).getCoordonneeXUn(), 
							((Rectangle)tabFormes[i]).getCoordonneeXDeux(), 
							((Rectangle)tabFormes[i]).getCoordonneeYUn(),
							((Rectangle)tabFormes[i]).getCoordonneeYDeux());	
				else
					graphic.fillRect(((Rectangle)tabFormes[i]).getCoordonneeXUn(), 
							((Rectangle)tabFormes[i]).getCoordonneeYUn(), 
							((Rectangle)tabFormes[i]).getCoordonneeXDeux()-((Rectangle)tabFormes[i]).getCoordonneeXUn(),
							((Rectangle)tabFormes[i]).getCoordonneeYDeux()-((Rectangle)tabFormes[i]).getCoordonneeYUn());
			}
			else if(tabFormes[i] instanceof Ovale){
				if(((Ovale)tabFormes[i]).getTypeFormeOvale() == TypeFormeOvale.OVALE)
					graphic.fillOval(((Ovale)tabFormes[i]).getCentreX(),
							((Ovale)tabFormes[i]).getCentreY(),
							((Ovale)tabFormes[i]).getRayonX(),
							((Ovale)tabFormes[i]).getRayonY());
				else if(((Ovale)tabFormes[i]).getTypeFormeOvale() == TypeFormeOvale.CERCLE)
					graphic.fillOval(((Ovale)tabFormes[i]).getCentreX(),
							((Ovale)tabFormes[i]).getCentreY(),
							((Ovale)tabFormes[i]).getRayonX(),
							((Ovale)tabFormes[i]).getRayonY());
			}
		}	
	}
	
	/**
	 * Le Layout qui utilise (contient) FenetreFormes doit reserver 
	 * l'espace necessaire a  son affichage
	 */
	public Dimension getPreferredSize(){
		return dimension;
	}
}
