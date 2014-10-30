package ConcreteCommand;

import Controller.Controlleur;
import fr.istic.m2miage.Command;

public class CommandInc implements Command {
private Controlleur c;
	
	public CommandInc(Controlleur c){
		this.c=c;
		
	}
	
	@Override
	public void execute() {
	c.Beatplus();
	}

}
