package Controller;

/**
 * 
 * @author dabo mohamed et odabalo essossolam tiadema
 * c'est le controlleur, c'est la classe centrale il s'occupe de la gestion des instructions entre les differentes classes.
 */
import CLAVIER.*;
import ConcreteCommand.ConcretCommandAllumerLed;
import ConcreteCommand.ConcretCommandIncremente;
import ConcreteCommand.ConcretCommandBarEvent;
import ConcreteCommand.ConcretCommandBeatEvent;
import ConcreteCommand.ConcretCommandDecremente;
import ConcreteCommand.ConcretCommandEteindreLed;
//import ConcreteCommand.ConcretCommandIncremente;
import ConcreteCommand.ConcretCommandStop;
import ConcreteCommand.ConcretCommandtRunning;
import ConcreteCommand.ICommand;
import ConcreteCommand.Sliderchanged;
import ConcreteCommand.TempoChangedCommand;
import ConcreteCommand.TickConcreteCommand;
import DISPLAY.DisplayImpl;
import DISPLAY.IDisplay;
import HORLOGE.HorlogeImpl;
import HORLOGE.IHorloge;
import IHM.IIhm;
import IHM.IhmImpl;
import IMolette.ISlider;
import IMolette.SliderImpl;
import LEDS.ILed;
import LEDS.Led2;
import LEDS.Led1;
import ME.IMetronomeEngine;
import ME.MetronomeEngineImpl;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class ControlleurImpl implements IControlleur{


	private IMetronomeEngine metronomeEngine ;
	private ISlider slider;
	private IDisplay display;
	private ILed led1;
	private ILed led2;
	private IHorloge horloge;
	private ICommand eteindreLed;

	
	

	private static boolean b=false;

public ControlleurImpl() {
	 metronomeEngine = new MetronomeEngineImpl();
	}

public void Update(MetronomeEngineImpl metronomeEngine){
	this.metronomeEngine=metronomeEngine;
	
}



public void sliderChanged(){
	int valeurCalculer=0;
	if(slider.getPosition()>=0)
	 valeurCalculer= (int) (20+(240 - 20)*slider.getPosition());
	metronomeEngine.setTempo(valeurCalculer);
}
@Override
public void beatBarChanged(int beatBar){
	this.metronomeEngine.setBeatBar(beatBar);
}
@Override
public void tempoChanged(){
	int valeurTempo=metronomeEngine.getTempo();
	display.afficherTempo(valeurTempo);
}
@Override
public void afficherBar(){
	int valeurBar=metronomeEngine.getBar();
	display.afficherBar(valeurBar);
}


@Override
public void running() {
	b=true;
	this.metronomeEngine.setRunning(b);
}

@Override
public void stop() {
	b=false;
	this.metronomeEngine.setRunning(b);
}

@Override
public void setSlider(ISlider slider) {
	this.slider=slider;
}


@Override
public void setDisplay(IDisplay display) {
	
	this.display=display;
}

@Override
public void setLed(ILed led) {
	this.led1=led;
}
@Override
public void setMetronomeEngine(IMetronomeEngine metronomeEngine) {
	this.metronomeEngine=metronomeEngine;
}

@Override
public void setLed2(ILed led) {
	this.led2=led;
}

@Override
public void setConcretCommandEteindre(ICommand eteindreLed) {
	this.eteindreLed=eteindreLed;
}

@Override
public void setHorloge(IHorloge horloge) {
	this.horloge=horloge;
	
}

@Override
public void handleBeatEvent(){
	led1.flash();
}
@Override
public void handleBarEvent(){
	if(b==true)
	led2.flash();
}


public static void main(String[] args) {
	IControlleur controlleur=new ControlleurImpl();
IIhm ihm= new IhmImpl();

ISlider slider= new SliderImpl(ihm);
IDisplay display=new DisplayImpl();
ICommand sliderChanged=new Sliderchanged(slider, controlleur);
IMetronomeEngine metronomeEngine=new MetronomeEngineImpl();

ICommand tempoChangedCommand=new TempoChangedCommand(controlleur);
ILed led1= new Led1(ihm);
ILed led2= new Led2(ihm);

IHorloge horloge=new HorlogeImpl();
IClavier start=new Concret_Bouton_Start(ihm);
IClavier incrementer=new Concret_Bouton_Incrementer(ihm);
IClavier decrementer=new Concret_Bouton_Decrementer(ihm,incrementer);

ICommand eteindreLed=new ConcretCommandEteindreLed(ihm,led1 );
ICommand allumerLed=new ConcretCommandAllumerLed(ihm,led1);
ICommand eteindreLed2=new ConcretCommandEteindreLed(ihm,led2 );
ICommand tickConcretCommand=new TickConcreteCommand(metronomeEngine);
ICommand running= new  ConcretCommandtRunning(controlleur, start);
ICommand beatEventCommand= new ConcretCommandBeatEvent(controlleur);
ICommand barEventCommand= new ConcretCommandBarEvent(controlleur);
ICommand stop= new ConcretCommandStop(controlleur);
ICommand concretCommandIncrement=new ConcretCommandIncremente(controlleur, incrementer);
ICommand concretCommandDecrement=new ConcretCommandDecremente(controlleur, decrementer);

controlleur.setSlider(slider);
slider.setSliderchangedCmd(sliderChanged);
start.setBoutonCheckedCommand(running);
incrementer.setBoutonCheckedCommand(concretCommandIncrement);
decrementer.setBoutonCheckedCommand(concretCommandDecrement);

controlleur.setDisplay(display);


metronomeEngine.setTickConcretCommand(tickConcretCommand);
metronomeEngine.setHorloge(horloge);
horloge.setTickConcreteEteindreLed(eteindreLed,eteindreLed2);
horloge.setTickConcreteAllumerLed(allumerLed);
led1.setHorloge(horloge);
led1.setConcretCommandEteindre(eteindreLed);
led1.setMetronomeEngine(metronomeEngine);
led1.setConcretCommandAllumer(allumerLed);
led2.setHorloge(horloge);
led2.setConcretCommandEteindre(eteindreLed2);
led2.setMetronomeEngine(metronomeEngine);

ihm.setConcretCommandStop(stop);
horloge.setMetronomeEngine(metronomeEngine);
controlleur.setHorloge(horloge);

controlleur.setMetronomeEngine(metronomeEngine);

controlleur.setLed(led1);
controlleur.setLed2(led2);
controlleur.setConcretCommandEteindre(eteindreLed);
controlleur.setConcretCommandEteindre(eteindreLed2);
horloge.setTickConcreteCommand(tickConcretCommand);
metronomeEngine.setConcretCommandBeatEvent(beatEventCommand);
metronomeEngine.setConcretCommandBarEvent(barEventCommand);

metronomeEngine.setTempoChangedCommand(tempoChangedCommand);

display.setIhm(ihm);

}


}
