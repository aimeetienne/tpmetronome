package ConcreteCommand;

import ADAPTATEUR.Adaptateur_slider;
/**
 * 
 * @author dabo mohamed et odabalo essossolam tiadema
 * c'est la commande concret qui s'occupe de lire les instructions provenant de l'ihm (slider) par le biais de antiadaptateur de slider.
 * cette commande est déclenchée à partir de l'adaptateur de slider
 */
public class ConcretCommandReadSlider implements ICommand{

	Adaptateur_slider adapteurslider;
	
	public ConcretCommandReadSlider(Adaptateur_slider adapteurslider) {
		this.adapteurslider=adapteurslider;
	}
	
	
	@Override
	public void execute() {
		adapteurslider.readCommandSlider();
	}

}
