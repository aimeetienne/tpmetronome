package IMolette;

import ConcreteCommand.ICommand;
import Controller.IControlleur;

public interface ISlider {
	
	public float getPosition();
	public void actualiserPosition(float position);
	public void setPosition(float position);
	public void setSliderchangedCmd(ICommand command);
	
}
