package ConcreteCommand;

import CLAVIER.IClavier;
import Controller.IControlleur;
import ME.IMetronomeEngine;
/**
 * 
 * @author dabo mohamed et odabalo essossolam tiadema
 * c'est la commande concret qui s'occupe de decrementer la mesure.
 */
public class ConcretCommandDecremente implements ICommand{
	
	
		IControlleur controlleur;
		IClavier Decrementer;
		
		 public ConcretCommandDecremente(IControlleur controlleur,IClavier Decrementer) {
			 this.controlleur=controlleur;
			 this.Decrementer=Decrementer;
		}
		
		@Override
		public void execute() {
			controlleur.beatBarChanged(Decrementer.getMesure());
			controlleur.afficherBar();
		}


	

	}



