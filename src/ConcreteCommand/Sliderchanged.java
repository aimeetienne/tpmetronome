package ConcreteCommand;
/**
 * 
 * @author dabo mohamed et odabalo essossolam tiadema
 * c'est la commande concret qui s'occupe d'informer lorsqu'il ya un changement sur le slider.
 */
import Controller.ControlleurImpl;
import Controller.IControlleur;
import IHM.IIhm;
import IMolette.ISlider;
import IMolette.SliderImpl;
import ME.IMetronomeEngine;

public class Sliderchanged implements ICommand{
	ISlider slider;
	IControlleur controlleur;
	IIhm ihm;
	

	public Sliderchanged(ISlider slider, IControlleur controlleur ) {
		this.slider=slider;
		this.controlleur=controlleur;
	}
	

	@Override
	public void execute() {
		controlleur.sliderChanged();
	}

	
}
