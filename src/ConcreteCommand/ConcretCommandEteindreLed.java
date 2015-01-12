package ConcreteCommand;
/**
 * 
 * @author dabo mohamed et odabalo essossolam tiadema
 * c'est la commande concret qui s'occupe d'eteindre les led(s).
 */
import IHM.IIhm;
import LEDS.ILed;
import LEDS.Led1;
import ME.IMetronomeEngine;

public class ConcretCommandEteindreLed implements ICommand{
	
	ILed led;
	IIhm ihm;
public ConcretCommandEteindreLed(IIhm ihm, ILed led){
	this.ihm=ihm;
	this.led=led;
}

	@Override
	public void execute() {
		led.eteindreLed();
	
	}

		
	

}
