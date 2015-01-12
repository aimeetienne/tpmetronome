package IMolette;

import ConcreteCommand.ICommand;
import Controller.IControlleur;
import IHM.IIhm;
import IHM.IhmImpl;
/**
 * 
 * @author dabo mohamed et odabalo essossolam tiadema
 * c'est le slider concret qui s'occupe de générer les valeurs entre 0 et 10 qui sont ensuite transformer pour obtenir les valeurs
 * du tempo.
 */
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
		this.sliderChanged=command;
	}


	@Override
	public void actualiserPosition(float position) {
		this.position=position;
		sliderChanged.execute();
		
	}


}
