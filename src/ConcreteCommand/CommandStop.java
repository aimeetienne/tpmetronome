package ConcreteCommand;

import Controller.Controlleur;
import fr.istic.m2miage.Command;

public class CommandStop implements Command {

	public CommandStop(Controlleur c) {
		super();
		this.c = c;
	}

	private Controlleur c;

	@Override
	public void execute() {
		
		c.Stop();
	}
	
	
}
