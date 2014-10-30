package ConcreteCommand;

import Controller.Controlleur;
import fr.istic.m2miage.Command;

public class CommandTempo implements Command {

	
	private Controlleur c;
	
	public CommandTempo(Controlleur c){
		this.c=c;
	}
	@Override
	public void execute() {
		c.doTempo();
		
	}
	

}
