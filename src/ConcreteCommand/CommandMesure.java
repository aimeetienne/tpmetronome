package ConcreteCommand;

import Controller.Controlleur;
import fr.istic.m2miage.Command;

public class CommandMesure implements Command {

	private Controlleur c;
	
	public CommandMesure(Controlleur c){
		
		this.c= c;
	}
	
	@Override
	public void execute() {
		c.doMesure();
	}

}
