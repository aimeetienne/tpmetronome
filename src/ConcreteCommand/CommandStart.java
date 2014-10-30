package ConcreteCommand;

import Controller.Controlleur;
import fr.istic.m2miage.Command;

public class CommandStart implements Command{
	private Controlleur c;
	public CommandStart(Controlleur c){
		this.c=c;
	}
	@Override
	public void execute() {
		c.Start();	
	}

}
