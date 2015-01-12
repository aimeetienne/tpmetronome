package ConcreteCommand;

import Controller.ControlleurImpl;
import Controller.IControlleur;
import ME.IMetronomeEngine;
/**
 * 
 * @author dabo mohamed et odabalo essossolam tiadema
 * c'est la commande concret qui s'occupe de la gestion des mesures.
 */
public class ConcretCommandBarEvent implements ICommand {

	private IControlleur controlleur ;
	public ConcretCommandBarEvent(IControlleur controlleur) {
			this.controlleur = controlleur;
	}



	@Override
	public void execute() {
		controlleur.handleBarEvent();
	}

	

}
