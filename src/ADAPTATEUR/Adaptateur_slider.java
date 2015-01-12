package ADAPTATEUR;

import ConcreteCommand.ICommand;
import HORLOGE.IHorloge;
import IMolette.ISlider;

/**
 * 
 * @author dabo mohamed et odabalo essossolam tiadema
 * l'adaptateur de slider permet de d'adapter les événements provenants du materiel (de anti_adaptateur_slider).
 *
 */
public class Adaptateur_slider {
	IHorloge horloge;
	ICommand readCommandSlider;
	Anti_adaptateur_slider antiadaptateurslider;
	float position=0;
	ISlider slider;
	
	
	public  Adaptateur_slider(IHorloge horloge){
		this.horloge=horloge;

	}
	
	
	public void setSlider(ISlider slider) {
		this.slider = slider;
	}


	public void activerHorloge(){
		horloge.activerPeriodiquement(readCommandSlider, 100);
		}


	public void setHorloge(IHorloge horloge) {
		this.horloge = horloge;
	}


	public void setReadCommandSlidet(ICommand readCommand) {
		this.readCommandSlider = readCommand;
	}


	public void setAntiadaptateurslider(Anti_adaptateur_slider antiadaptateurslider) {
		this.antiadaptateurslider = antiadaptateurslider;
	}
	
	public void readCommandSlider(){
		
		this.antiadaptateurslider.readPositionSlider(position);
	}
	
	public void setPositionSlider(float position){
		this.position=position;
		slider.actualiserPosition(this.position);;
	}
	
}
