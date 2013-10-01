package com.clientformes.gui;
/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: FenetrePrincipale.java
Date cree: 2013/05/03
*******************************************************
Historique des modifications
Etudiant(e)(s): Daniel Enachescu, Guy Pomerleau
Code(s) perm.:ENAD25079107, POMG26117702
*******************************************************
*@author Patrice Boucher
2013/05/03 Version initiale
*******************************************************/  

import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.clientformes.bean.Forme;
import com.clientformes.utils.ConteneurForme;
 
/**
 * Cette classe represente la fenetre principale de l'application 
 * @author Patrice Boucher
 * @date 2013/05/04
 */
public class FenetrePrincipale extends JFrame implements PropertyChangeListener{
	
	private static final long serialVersionUID = -1210804336046370508L;
	/**
	 * Constructeur
	 */
	public FenetrePrincipale(){
		
		String adresseIP = JOptionPane.showInputDialog("Quel est le nom d'h�te et le port du serveur de formes?");
		
		if (adresseIP != null && adresseIP.length() > 0 ) {
			String[] tabAdressIP = new String[1];
			tabAdressIP = adresseIP.split(":");
			CommBase commBase = new CommBase(tabAdressIP[0], Integer.parseInt(tabAdressIP[1]));
			commBase.setPropertyChangeListener(this);
						
			MenuFenetre menu = new MenuFenetre(commBase);
			this.setLayout(new BorderLayout());
			this.add(menu, BorderLayout.NORTH);
			FenetreFormes fenetreFormes = new FenetreFormes();
			this.add(fenetreFormes, BorderLayout.CENTER); // Ajoute la fenêtre de forme à la fenètre principale
			this.pack(); // Ajuste la dimension de la fenêtre principale selon celle de ses composants
			this.setVisible(true); // Rend la fenêtre principale visible.
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //... à réviser selon le comportement que vous désirez ...						
		}
		
	}
	
	/**
	 *  Appele lorsque le sujet lance "firePropertyChanger"
	 *  @param PropertyChangeEvent
	 */
	public void propertyChange(PropertyChangeEvent arg0) {
		
		if(arg0.getPropertyName().equals("NOUVELLE FORME")){
			this.repaint();
		}
	}
}
