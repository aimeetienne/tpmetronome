package ConcreteCommand;
/**
 * 
 * @author dabo mohamed et odabalo essossolam tiadema
 * c'est la commande concret qui s'occupe d'arreter le metronome engine.
 */
import Controller.ControlleurImpl;
import Controller.IControlleur;
import ME.IMetronomeEngine;

public class ConcretCommandStop implements ICommand{
	
	IControlleur controlleur;
	
	public ConcretCommandStop(IControlleur controlleur){
		this.controlleur=controlleur;
	}

	
	@Override
	public void execute() {
		controlleur.stop();
	}

}
