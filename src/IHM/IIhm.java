package IHM;

import CLAVIER.IClavier;
import ConcreteCommand.ICommand;
import Controller.IControlleur;
import IMolette.ISlider;

public interface IIhm {
	
	public void setSliderChanged(ICommand command);
	public void setConcretCommandStop(ICommand command);
	public float getPosition();
	public void enregistrerSlider(ISlider slider);    
	public void supprimerObservateur(ISlider slider); 
	public void enregistrerRunnig(IClavier bRunning);
	public void notifierRunning();
	public void enregistrerStop(IClavier bStop);
	public void notifierStop();
	
	public void enregistrerIncremente(IClavier bIncrementer);
	public void notifierIncremente();
	public int getMesure();
	public void enregistrerDecremente(IClavier bDecrementer);
	public void notifierDecrement();
	public void notifierSliders();
	public void setSlider(ISlider slider);
	public void afficherMesure(String s);
	public void afficherTempo(String s);
	public void allumerLed1();
	public void eteindreLed1();
	
	public void allumerLed2();
	public void eteindreLed2();
	//public void linfochaud();

}
