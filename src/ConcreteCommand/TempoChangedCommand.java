package ConcreteCommand;
/**
 * 
 * @author dabo mohamed et odabalo essossolam tiadema
 * c'est la commande concret qui s'occupe d'informer lorsqu'il ya un changement du tempo.
 */
import javax.activation.CommandObject;

import Controller.ControlleurImpl;
import Controller.IControlleur;
import ME.IMetronomeEngine;


public class TempoChangedCommand implements ICommand {
	IControlleur controlleur;
	
	public TempoChangedCommand(IControlleur controlleur) {
		this.controlleur=controlleur;
	}

	@Override
	public void execute() {
		controlleur.tempoChanged();
	}



}
