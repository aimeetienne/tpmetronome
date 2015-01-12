package ME;

import ConcreteCommand.ICommand;
import Controller.IControlleur;
import HORLOGE.IHorloge;

public interface IMetronomeEngine {
	public void setTempo(int tempo);
	public int getTempo();
	public void setTempoChangedCommand(ICommand command);
	public void setConcretCommandBeatEvent(ICommand command);
	public void setConcretCommandBarEvent(ICommand command);
	public ICommand getTempoChangedCommand();
	public void setRunning(Boolean b);
	public boolean getRunning();
	public void setTickConcretCommand(ICommand command);
	public void setHorloge(IHorloge horloge);
	public void setBeatBar(int BeatBar);
	public int getBar();
public void tick();
}
