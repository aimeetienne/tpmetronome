package ConcreteCommand;
/**
 * 
 * @author dabo mohamed et odabalo essossolam tiadema
 * c'est la commande concret qui s'occupe d'incrementer la mesure.
 */
import CLAVIER.IClavier;
import CLAVIER.Concret_Bouton_Incrementer;
import Controller.IControlleur;
import ME.IMetronomeEngine;

public class ConcretCommandIncremente implements ICommand{

	
	IControlleur controlleur;
	IClavier Incrementer;
	
	 public ConcretCommandIncremente(IControlleur controlleur,IClavier Incrementer) {
		 this.controlleur=controlleur;
		 this.Incrementer=Incrementer;
	}
	
	@Override
	public void execute() {
		controlleur.beatBarChanged(Incrementer.getMesure());
		controlleur.afficherBar();
	}

	

}
