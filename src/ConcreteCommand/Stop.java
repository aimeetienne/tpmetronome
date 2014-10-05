package ConcreteCommand;

import Controller.Controlleur;
import fr.istic.m2miage.Command;

public class Stop implements Command {

	public Stop(Controlleur c) {
		super();
		this.c = c;
	}

	private Controlleur c;

	@Override
	public void execute() {
		
		
	}
	
	
}
