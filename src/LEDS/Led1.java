package LEDS;
/**
 * 
 * @author dabo mohamed et odabalo essossolam tiadema
 * c'est le led concret.
 */
import ConcreteCommand.ICommand;
import Controller.ControlleurImpl;
import HORLOGE.IHorloge;
import IHM.IIhm;
import ME.IMetronomeEngine;

import java.io.IOException;
import java.net.MalformedURLException;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class Led1 implements ILed{
	IIhm ihm;
	IHorloge horloge;
	ICommand eteindreLed;
	ICommand allumerLed;
 AudioClip sonled1;
	IMetronomeEngine metronomeEngine;
	int compteur;
	 public Led1(IIhm ihm) {
		// TODO Auto-generated constructor stub
		 this.ihm=ihm;
		 try {
			 this.sonled1 = Applet.newAudioClip(getClass().getResource("/Sons/button-6.wav"));

		 } catch (Exception ex){
			 System.out.println(ex);
		 }
       
		// 
	}

	@Override
	public void flash() {
		if(metronomeEngine.getRunning()==false){
			this.eteindreLed();
		}
		else 
		this.allumerLed();
		horloge.activerApresDelai(eteindreLed, 100);
		
		
		
	}

	@Override
	public void allumerLed() {
		//if()
		ihm.allumerLed1();
			sonled1.play();
		
	}

	@Override
	public void eteindreLed() {
		ihm.eteindreLed1();
	}

	@Override
	public void setHorloge(IHorloge horloge) {
		// TODO Auto-generated method stub
		this.horloge=horloge;
	}

	@Override
	public void setConcretCommandEteindre(ICommand eteindreLed) {
			this.eteindreLed=eteindreLed;
	}

	@Override
	public void setMetronomeEngine(IMetronomeEngine metronomeEngine) {
		// TODO Auto-generated method stub
		this.metronomeEngine=metronomeEngine;
	}

	@Override
	public void setConcretCommandAllumer(ICommand allumerLed) {
		// TODO Auto-generated method stub
		this.allumerLed=allumerLed;
	}

}
