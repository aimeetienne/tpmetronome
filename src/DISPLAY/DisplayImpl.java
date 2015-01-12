package DISPLAY;

import IHM.IIhm;
/**
 * 
 * @author dabo mohamed et odabalo essossolam tiadema
 * c'est l'afficheur concret qui s'occupe d'afficher les informations provenant du metronome engine.
 */
public class DisplayImpl implements IDisplay {
	
	IIhm ihm;
	
	public DisplayImpl(){
		
	}

	@Override
	public void afficherTempo(int valeurTempo) {
		ihm.afficherTempo(""+valeurTempo);
	}
	public void afficherBar(int valeurBar) {
		ihm.afficherMesure(""+valeurBar);
	}
	

	@Override
	public void setIhm(IIhm ihm) {
		this.ihm=ihm;
	}

}
