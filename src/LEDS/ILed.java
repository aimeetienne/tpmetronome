package LEDS;

import ConcreteCommand.ICommand;
import HORLOGE.IHorloge;
import ME.IMetronomeEngine;

public interface ILed {
	
	public void flash();
	public void allumerLed();
	public void eteindreLed();
	public void setHorloge(IHorloge horloge); 
	public void setConcretCommandEteindre(ICommand eteindreLed);
	public void setConcretCommandAllumer(ICommand allumerLed);
	public void setMetronomeEngine(IMetronomeEngine metronomeEngine);


}
