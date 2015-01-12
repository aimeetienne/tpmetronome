package ConcreteCommand;
/**
 * 
 * @author dabo mohamed et odabalo essossolam tiadema
 * c'est la commande concret qui s'occupe d'allumer les led(s).
 */
import IHM.IIhm;
import LEDS.ILed;
import ME.IMetronomeEngine;

public class ConcretCommandAllumerLed implements ICommand{

	ILed led;
	IIhm ihm;
public ConcretCommandAllumerLed(IIhm ihm,ILed led){
	this.ihm=ihm;
	this.led=led;
}
	@Override
	public void execute() {
		led.allumerLed();
		
	}
	

}
