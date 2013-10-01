package com.clientformes.businesslogic;
/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: CommBase.java
Date cree: 2013/05/03
*******************************************************
Historique des modifications
Etudiant(e)(s): Daniel Enachescu, Guy Pomerleau
Code(s) perm.:ENAD25079107, POMG26117702 
*******************************************************
*@author Patrice Boucher
2013/05/03 Version initiale
*******************************************************/  

import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.SwingWorker;

import com.clientformes.bean.Forme;
import com.clientformes.utils.ConteneurForme;

/**
 * Base d'une communication via un fil d'execution parallele.
 */
public class CommBase{
	
	private final int DELAI = 1000;
	private SwingWorker threadComm =null;
	private PrintWriter output;
	private ApplicationFormes applicationFormes = null;
	private PropertyChangeListener listener = null;
	private boolean isActif = false;
	private String host;
	private int port;
	private Socket socket = null;
	
	/**
	 * Constructeur
	 */
	public CommBase(ApplicationFormes applicationFormes){
		this.applicationFormes = applicationFormes;
	}
	
	/**
	 * Constructeur qui set les adresses du serveur
	 * @param host : String
	 * @param port : String
	 */
	public CommBase(String host, int port){
		
		this.host = host;
		this.port = port;
	}
	
	/**
	 * D�finir le r�cepteur de l'information re�ue dans la communication avec le serveur
	 * @param listener sera alerte lors de l'appel de "firePropertyChanger" par le SwingWorker
	 */
	public void setPropertyChangeListener(PropertyChangeListener listener){
		this.listener = listener;
	}
	
	/**
	 * Demarre la communication
	 */
	public void start(){
		creerCommunication();
	}
	
	/**
	 * Arrete la communication
	 */
	public void stop(){
		if(threadComm!=null)
			threadComm.cancel(true); 
		isActif = false;
	}
	
	/**
	 * Creer le necessaire pour la communication avec le serveur
	 */
	protected void creerCommunication(){
		// Crée un fil d'exécusion parallèle au fil courant,
		threadComm = new SwingWorker(){
			@Override
			protected Object doInBackground() throws Exception {
				Forme formeRecue = null;				
				BufferedReader input;
				System.out.println("Le fils d'execution parallele est lance");
				//Socket socket = null;
				do{
					try {
						socket = new Socket(host, port);
						
						if(!socket.isConnected())
							System.out.println("Le serveur n'est pas partie");
					} catch (Exception ex) {
						socket.close();
						System.out.println(ex.getMessage());
					}					
				}while(!socket.isConnected());				
				
				output = new PrintWriter(socket.getOutputStream(),true);
				input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				while(true){
					String descriptionForme;
					output.println("GET");
					
					Thread.sleep(DELAI);
					
					if((descriptionForme = input.readLine()).length() > 0){
						if(descriptionForme.contains("commande")){	
							descriptionForme = input.readLine();							
						}						
						
						formeRecue = GenererForme.GenererStringAForme(descriptionForme);							
						ajouterFormeRecuAuConteneur(formeRecue);
						
						//La méthode suivante alerte l'observateur 
						if(listener!=null)
							firePropertyChange("NOUVELLE FORME", null, (Object) "FORME ENVOYE");						
						
					}
				}
			}
		};
		if(listener!=null)
		   threadComm.addPropertyChangeListener(listener); // La méthode "propertyChange" de ApplicationFormes sera donc appelée lorsque le SwinkWorker invoquera la méthode "firePropertyChanger" 		
		threadComm.execute(); // Lance le fil d'exécution parallèle.
		isActif = true;
	}
	
	/**
	 * Ajouter la forme recue dans le classe qui contient toutes les formes
	 * @param Forme 
	 */
	private void ajouterFormeRecuAuConteneur(Forme formeRecu){		
		ConteneurForme.getInstance().ajouterForme(formeRecu);
	}
	
	/**
	 * Fermer le serveur sans "Deconnexion sans END"
	 */
	public void fermerConnectionServeur(){		
		try {
			output.println("END");
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @return si le fil d'execution parallele est actif
	 */
	public boolean isActif(){
		return isActif;
	}
}
