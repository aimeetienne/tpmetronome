package ConcreteCommand;

import Controller.Controlleur;
import invoker.MetronomeEngine;
import fr.istic.m2miage.Command;

public class CommandDec implements Command {

	public CommandDec(Controlleur m) {
			this.m = m;
	}

	private Controlleur m;

	@Override
	public void execute() {
		m.Beatmoins();
	}


}

