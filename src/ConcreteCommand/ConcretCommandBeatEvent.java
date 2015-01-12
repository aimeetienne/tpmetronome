package ConcreteCommand;

import Controller.ControlleurImpl;
import Controller.IControlleur;
import ME.IMetronomeEngine;
import ME.MetronomeEngineImpl;
/**
 * 
 * @author dabo mohamed et odabalo essossolam tiadema
 * c'est la commande concret qui s'occupe de la gestion du transport du tempo.
 */
public class ConcretCommandBeatEvent implements ICommand {

	private IControlleur controlleur ;
	private ICommand concretCommandBarEvent;
	public ConcretCommandBeatEvent(IControlleur controlleur) {
			this.controlleur = controlleur;
	}



	@Override
	public void execute() {
		controlleur.handleBeatEvent();
	}






}
