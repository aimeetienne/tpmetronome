package HORLOGE;
/**
 * 
 * @author dabo mohamed et odabalo essossolam tiadema
 * c'est l'horloge il s'occupe de tout ce qui gestion des threads et des differentes commande associées.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import ConcreteCommand.ICommand;
//import ConcreteCommand.ConcretCommandEteindreLed2;
import ConcreteCommand.TickConcreteCommand;
import ME.IMetronomeEngine;
import ME.MetronomeEngineImpl;

import java.util.Timer;
import java.util.TimerTask;

public class HorlogeImpl implements IHorloge {
	
	ICommand tickConcreteCommand;
	ICommand eteindreLed;
	ICommand eteindreLed2;
	ICommand allumerLed;
	IMetronomeEngine metronomeEngine;
	Timer timerEteindreLedBeat;
	Timer timerAllumerLedBeat;
	Timer timerEteindreLedBar;
	public HorlogeImpl (){
		timerEteindreLedBeat=new Timer();
		timerAllumerLedBeat=new Timer();
		timerEteindreLedBar=new Timer();
		
	}
	
	class Task extends TimerTask{
	    public void run(){
	    	tickConcreteCommand.execute();
	    }
	 
	}
	
	class Task1 extends TimerTask{
	    public void run(){
	    	eteindreLed.execute();
		    }
	}
	    
		class Task2 extends TimerTask{
		    public void run(){
		    	eteindreLed2.execute();
			    }
	   
	 
	}

	@Override
	public void activerPeriodiquement(ICommand command, float periodeEnSecondes) {
		
		 timerAllumerLedBeat.schedule(new Task(),0, (long)periodeEnSecondes);
	}
	
	
	@Override
	public void activerApresDelai(ICommand command, float delaiEnSecondes) {
		
		timerEteindreLedBeat.schedule(new Task1(),(long)delaiEnSecondes);
		timerEteindreLedBar.schedule(new Task2(),(long)delaiEnSecondes);
	
		 }
	
	

	@Override
	public void desactiver(ICommand commande) {
		commande.execute();
		this.timerAllumerLedBeat.cancel();
		this.timerEteindreLedBar.cancel();
		this.timerEteindreLedBeat.cancel();
		timerEteindreLedBeat=new Timer();
		timerAllumerLedBeat=new Timer();
		timerEteindreLedBar=new Timer();
		
		
	}
	

	@Override
	public void setTickConcreteCommand(ICommand tickConcretCommand) {
		this.tickConcreteCommand=tickConcretCommand;
	}

	@Override
	public void setTickConcreteAllumerLed(ICommand allumerLed) {
		this.allumerLed=allumerLed;
	}

	@Override
	public void setMetronomeEngine(IMetronomeEngine moEngine) {
		this.metronomeEngine=moEngine;
	}


	@Override
	public void setTickConcreteEteindreLed(ICommand eteindreLed, ICommand eteindreLed2) {
		this.eteindreLed=eteindreLed;
		this.eteindreLed2=eteindreLed2;
	}


}
