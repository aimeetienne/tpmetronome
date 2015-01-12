package ConcreteCommand;
/**
 * 
 * @author dabo mohamed et odabalo essossolam tiadema
 * c'est la commande concret qui s'occupe de decrementer la mesure.
 */
import CLAVIER.IClavier;
import Controller.IControlleur;
import ME.IMetronomeEngine;

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



