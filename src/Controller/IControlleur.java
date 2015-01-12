package Controller;

import CLAVIER.IClavier;
import ConcreteCommand.ConcretCommandBeatEvent;
import ConcreteCommand.ICommand;
import ConcreteCommand.TempoChangedCommand;
import DISPLAY.IDisplay;
import HORLOGE.IHorloge;
import IHM.IIhm;
import IMolette.ISlider;
import IMolette.SliderImpl;
import LEDS.ILed;
import ME.IMetronomeEngine;
import ME.MetronomeEngineImpl;

public interface IControlleur {
	
	public void sliderChanged();
	public void setMetronomeEngine(IMetronomeEngine metronomeEngine);
	public void setSlider(ISlider slider);
	public void setDisplay(IDisplay display) ;
	
	public void setLed(ILed led);
	public void setLed2(ILed led);

	public void setConcretCommandEteindre(ICommand eteindreLed);
	public void setHorloge(IHorloge horloge); 
	public void beatBarChanged(int beatBar);
	public void tempoChanged();
	public void afficherBar();
	public void running();
	public void stop();
	public void handleBeatEvent();
	public void handleBarEvent();

	
}
