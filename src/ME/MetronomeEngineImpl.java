package ME;
/**
 * @author dabo mohamed et odabalo essossolam tiadema
 * c'est le metronome engine principale.
 */
import ConcreteCommand.ConcretCommandBeatEvent;
import ConcreteCommand.ICommand;
import ConcreteCommand.TempoChangedCommand;
import ConcreteCommand.TickConcreteCommand;
import Controller.IControlleur;
import HORLOGE.IHorloge;
import HORLOGE.HorlogeImpl;;
public class MetronomeEngineImpl implements IMetronomeEngine{

	
	private int tempo=20;
	private int bar;
	int compteur=0;
	private boolean running;
	private ICommand beatEvenCommand;
	private ICommand barEventCommand;
	private IHorloge horloge;
	private ICommand tickConcretCommand;
	private ICommand tempoChangedCommand;
	private ICommand concretCommandIncrement;
	private ICommand concretCommandDecrement;
	public MetronomeEngineImpl(){
		
	}
	/**
	 * @return the tempo
	 */
	public int getTempo() {
		return tempo;
	}
	
	public void setTempoChangedCommand(ICommand command){
		this.tempoChangedCommand=command;
		
	}
	
	public ICommand getTempoChangedCommand(){
		return tempoChangedCommand;
	}

	/**
	 * @param tempo the tempo to set
	 */
	public void setTempo(int tempo) {
		this.tempo = tempo;
		tempoChangedCommand.execute();
	}


	/**
	 * @return the running
	 */
	public boolean isRunning() {
		return running=true;
		
	}
	@Override
	public void setRunning(Boolean b) {
		// TODO Auto-generated method stub
		float temps=(float)60/(float)this.getTempo()*1000;
		this.running=b;
		if(b==true){
		horloge.activerPeriodiquement(tickConcretCommand, temps);}
		if(b==false){
			horloge.desactiver(tickConcretCommand);
			this.beatEvenCommand.execute();
		}
		
	}

	public ICommand getSetBeatEventCommand() {
		return beatEvenCommand;
	}

	/**
	 * @param setbeatcommand the setbeatcommand to set
	 */
	public void setBeatEventCommand(ICommand beatEveCommand) {
		this.beatEvenCommand = barEventCommand;
		barEventCommand.execute();
	}

	public ICommand getBarEventCommand() {
		return barEventCommand;
	}
	@Override
	public int getBar() {
		return bar;
	}
	public void setBar(int bar) {
		this.bar = bar;
		this.concretCommandDecrement.execute();
		this.concretCommandIncrement.execute();
	}
	/**
	 * @param barcommand the barcommand to set
	 */
	public void setBarEventCommand(ICommand barEventcommand) {
		this.barEventCommand = barEventcommand;
	}
	@Override
	public void setTickConcretCommand(ICommand command) {
		// TODO Auto-generated method stub
		this.tickConcretCommand=command;
	}
	@Override
	public void tick(){
		boolean b=(compteur%this.getBar())==0;
		this.beatEvenCommand.execute();
		compteur++;
		if(b==true){
		this.barEventCommand.execute();}
	}
	@Override
	public void setConcretCommandBeatEvent(ICommand command) {
		// TODO Auto-generated method stub
		this.beatEvenCommand=command;
	}
	@Override
	public void setConcretCommandBarEvent(ICommand command) {
		// TODO Auto-generated method stub
		this.barEventCommand=command;
	}

	@Override
	public void setHorloge(IHorloge horloge) {
		// TODO Auto-generated method stub
		this.horloge=horloge;
	}
	@Override
	public boolean getRunning() {
		// TODO Auto-generated method stub
		return running;
	}
	@Override
	public void setBeatBar(int beatBar) {
		this.bar=beatBar;
	}
	
	
}
