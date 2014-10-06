package ConcreteCommand;

import Controller.Controlleur;
import fr.istic.m2miage.Command;

public class Start implements Command{
	private Controlleur c;
	public Start(Controlleur c){
		this.c=c;
	}
	@Override
	public void execute() {
		c.Start();	
	}

}
