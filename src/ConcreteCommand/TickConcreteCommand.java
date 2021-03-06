package ConcreteCommand;

import ME.IMetronomeEngine;
import ME.MetronomeEngineImpl;
/**
 * 
 * @author dabo mohamed et odabalo essossolam tiadema
 * c'est la commande concret qui s'occupe de la gestion du tick.
 */
public class TickConcreteCommand implements ICommand {

	IMetronomeEngine metronomeEngine;
 public TickConcreteCommand(IMetronomeEngine metronomeEngine) {
	 this.metronomeEngine=metronomeEngine;
	 
	}
 
	@Override
	public void execute() {
		this.metronomeEngine.tick();
	}

	
}
