package LEDS;

import java.applet.Applet;
import java.applet.AudioClip;

import ConcreteCommand.ConcretCommandEteindreLed;
import ConcreteCommand.ICommand;
import HORLOGE.HorlogeImpl;
import HORLOGE.IHorloge;
import IHM.IIhm;
import ME.IMetronomeEngine;
/**
 * 
 * @author dabo mohamed et odabalo essossolam tiadema
 * c'est le led2 concret.
 */
public class Led2 implements ILed {

	
	IIhm ihm;
	IHorloge horloge;
	ICommand eteindreLed;
	ICommand allumerLed;
	IMetronomeEngine metronomeEngine;
	AudioClip sonled2;
	 public Led2(IIhm ihm) {
		// TODO Auto-generated constructor stub
		 this.sonled2 = Applet.newAudioClip(getClass().getResource("/Sons/beep-01a.wav"));
		 this.ihm=ihm;
	}
		@Override
		public void flash() {
			this.allumerLed();
			 eteindreLed=new ConcretCommandEteindreLed(ihm, this);
			horloge.activerApresDelai(eteindreLed, 1000);
		}

		@Override
		public void allumerLed() {
			ihm.allumerLed2();;
			sonled2.play();
		}

		@Override
		public void eteindreLed() {
			ihm.eteindreLed2();
		}

		@Override
		public void setHorloge(IHorloge horloge) {
			this.horloge=horloge;
		}

		@Override
		public void setConcretCommandEteindre(ICommand eteindreLed) {
			// TODO Auto-generated method stub
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
