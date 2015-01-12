package ConcreteCommand;

import CLAVIER.IClavier;
import Controller.IControlleur;
import IHM.IIhm;
import ME.IMetronomeEngine;
/**
 * 
 * @author dabo mohamed et odabalo essossolam tiadema
 * c'est la commande concret qui s'occupe de demarrer le metronome engine.
 */
public class ConcretCommandtRunning implements ICommand {
	IControlleur controlleur;
	IClavier start;
	 public ConcretCommandtRunning(IControlleur controlleur,IClavier start){
		 this.controlleur=controlleur;
		 this.start=start;
	}

	@Override
	public void execute() {
		controlleur.running();
		
	}

	

}
