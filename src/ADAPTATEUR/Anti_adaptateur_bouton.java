package ADAPTATEUR;

import CLAVIER.IClavier;
import ConcreteCommand.ICommand;
import HORLOGE.IHorloge;
import IHM.IIhm;
import IMolette.ISlider;
/**
 * 
 * @author dabo mohamed et odabalo essossolam tiadema
 * l'anti_adaptateur de bouton permet de d'annuler les événements provenants de l'ihm.
 *il existe une dissociation entre l'ihm et le controleur pour la gestion des boutons
 */

public class Anti_adaptateur_bouton  {

	Adaptateur_bouton adapteur;
	public int nbClickIncrement=0;
	public int nbClickDecrement=0;;
	public int nbClickStop=0;;
	public int nbClickStart=0;;
	
	
	int i=0;
	public static final boolean [] b=new boolean[4];
	
	public Anti_adaptateur_bouton(){
		for (i=0; i<b.length; i++){
			b[i]=true;
		}
	}

	public void activeBouton(int numeroBouton){
		
	b[numeroBouton]=!b[numeroBouton];
	
	if(numeroBouton==2){
		nbClickIncrement++;
	}
	
	if(numeroBouton==0){
		nbClickStart++;
	}
	
	if(numeroBouton==1){
		nbClickStop++;
	}
	if(numeroBouton==3){
		nbClickDecrement++;
	}
		
	}

	
	public void read(){
	
 if(nbClickStart !=0){
		adapteur.boutonStartClicker(nbClickStart);
		nbClickStart=0;}
 
 if(nbClickStop !=0){
		adapteur.boutonStopClicker(nbClickStop);
		nbClickStop=0;}
 
 if(nbClickIncrement !=0){
		adapteur.boutonIncrementeClicker(nbClickIncrement);
		nbClickIncrement=0;}
 
 if(nbClickDecrement !=0){
		adapteur.boutonDecrementeClicker(nbClickDecrement);
		nbClickDecrement=0;}
			}

	



	public void setAdapteur(Adaptateur_bouton adapteur) {
		this.adapteur = adapteur;
	}

	
}

