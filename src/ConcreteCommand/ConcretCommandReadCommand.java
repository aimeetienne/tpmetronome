package ConcreteCommand;

import ADAPTATEUR.Adaptateur_bouton;
import ADAPTATEUR.Anti_adaptateur_bouton;
/**
 * 
 * @author dabo mohamed et odabalo essossolam tiadema
 * c'est la commande concret qui s'occupe de lire les instructions provenant de l'ihm (les actions sur les bouton) par le biais de antiadaptateur de bouton.
 * cette commande est déclenchée à partir de l'adaptateur de bouton
 */
public class ConcretCommandReadCommand implements ICommand{
	
	Adaptateur_bouton adaptateur;
	
	public ConcretCommandReadCommand(Adaptateur_bouton adaptateur) {
		this.adaptateur=adaptateur;
	}

	@Override
	public void execute() {
		adaptateur.readCommand();
	}
	
	

}
