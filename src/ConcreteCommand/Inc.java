package ConcreteCommand;

import Controller.Controlleur;
import fr.istic.m2miage.Command;

public class Inc implements Command {
private Controlleur c;
	
	public Inc(Controlleur c){
		this.c=c;
		
	}
	
	@Override
	public void execute() {
	c.Beatplus();
	}

}
