package IMolette;

import ConcreteCommand.ICommand;
import Controller.IControlleur;
import IHM.IIhm;
import IHM.IhmImpl;

public class SliderImpl implements ISlider{

	
	float position=0;
	IIhm ihm;
	ICommand sliderChanged;
	
	public SliderImpl (IIhm ihm){
	
		 this.ihm=ihm;
		 ihm.enregistrerSlider(this);
	}
	
	
	@Override
	public float getPosition() {
		return this.position;
	}

	@Override
	public void setPosition(float position) {
		this.position = position;
	}


	@Override
	public void setSliderchangedCmd(ICommand command) {
		// TODO Auto-generated method stub
		this.sliderChanged=command;
	}


	@Override
	public void actualiserPosition(float position) {
		// TODO Auto-generated method stub
		this.position=position;
		sliderChanged.execute();
		
	}

	

	


}
