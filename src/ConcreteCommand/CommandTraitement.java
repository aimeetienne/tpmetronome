package ConcreteCommand;

import Controller.Controlleur;
import fr.istic.m2miage.Command;

public class CommandTraitement implements Command {

	private Controlleur c;
	
	public CommandTraitement(Controlleur c){
		this.c=c;
	}
	
	@Override
	public void execute() {
		c.traitement();
		
	}

}
