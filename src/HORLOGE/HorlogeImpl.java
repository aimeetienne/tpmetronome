package HORLOGE;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import ConcreteCommand.ConcretCommandReadCommand;
import ConcreteCommand.ICommand;
//import ConcreteCommand.ConcretCommandEteindreLed2;
import ConcreteCommand.TickConcreteCommand;
import ME.IMetronomeEngine;
import ME.MetronomeEngineImpl;

import java.util.Timer;
import java.util.TimerTask;
/**
 * 
 * @author dabo mohamed et odabalo essossolam tiadema
 * c'est l'horloge il s'occupe de tout ce qui gestion des threads et des differentes commande associées.
 * dans cette deuxième version on a implementé 2 methodes activé périodiquement pour fair la difference entre le timer qui gere 
 * les mouvements des led(s). tandis que l'autre c'est pour la gestion des mouvements l'adaptateur
 */
public class HorlogeImpl implements IHorloge {
	
	ICommand tickConcreteCommand;
	ICommand eteindreLed;
	ICommand eteindreLed2;
	ICommand allumerLed;
	ICommand readCommand;
	ICommand readSlider;



	IMetronomeEngine metronomeEngine;
	Timer timerEteindreLedBeat;
	Timer timerAllumerLedBeat;
	Timer timerEteindreLedBar;
	Timer timerReadCommand;
	Timer timerReadSlider;
	
	public HorlogeImpl (){
		timerEteindreLedBeat=new Timer();
		timerAllumerLedBeat=new Timer();
		timerEteindreLedBar=new Timer();
		timerReadCommand=new Timer();
		timerReadSlider=new Timer();
		
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
		    
		    class Task3 extends TimerTask{
			    public void run(){
			    	readCommand.execute();
			    	
				    }
		    }
			    
			    class Task4 extends TimerTask{
				    public void run(){
				    	readSlider.execute();
				    	System.out.println("le thread2 est lancé");
				    	
					    
			    }
		    
	 
	}
			    @Override
				public void activerPeriodiquement2(ICommand command, float periodeEnSecondes) {
			    	 timerAllumerLedBeat.schedule(new Task(),0, (long)periodeEnSecondes);
			    }
			    

	@Override
	public void activerPeriodiquement(ICommand command, float periodeEnSecondes) {
		
		
		 
		 timerReadCommand.schedule(new Task3(),0,(long)periodeEnSecondes);
		// timerReadSlider.schedule(new Task4(),0,(long)periodeEnSecondes);
		
	}
	
	
	@Override
	public void activerApresDelai(ICommand command, float delaiEnSecondes) {
		
		timerEteindreLedBeat.schedule(new Task1(),(long)delaiEnSecondes);
		timerEteindreLedBar.schedule(new Task2(),(long)delaiEnSecondes);
	
		 }
	
	

	@Override
	public void desactiver(ICommand commande) {

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


	@Override
	public void setTickConcreteReadConcret(ICommand concretCommandRead) {
		this.readCommand=concretCommandRead;
	}
	
	@Override
	public void setTickConcreteReadConcretSlider(ICommand concretCommandReadSlider) {
		this.readSlider=concretCommandReadSlider;
	}


}
