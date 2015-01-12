package ADAPTATEUR;

/**
 * 
 * @author dabo mohamed et odabalo essossolam tiadema
 * l'anti_adaptateur de slider permet de d'annuler les événements provenants de l'ihm.
 *il existe une dissociation entre l'ihm et le controleur pour la gestion du slider
 */

public class Anti_adaptateur_slider {
	
	Adaptateur_slider adapteurslider;
	
	public Anti_adaptateur_slider(){
		
	}
	
	
	
	public void readPositionSlider(float position){
		this.adapteurslider.setPositionSlider(position);
		
	}



	public void setAdapteurslider(Adaptateur_slider adapteurslider) {
		this.adapteurslider = adapteurslider;
	}




}
