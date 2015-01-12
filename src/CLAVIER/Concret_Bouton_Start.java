package CLAVIER;

import ConcreteCommand.ICommand;
import IHM.IIhm;

/**
 * 
 * @author dabo mohamed et odabalo essossolam tiadema
 * on a mis en place le pattern observeur sur les concrets boutons, pour avoir de l'information 
 * provenant de l'ihm.
 * ainsi � partir de chaque concret bouton un concret commande adapt� est sollicit� pour envoyer les instructions au Controlleur 
 * qui s'occupe de transmettre les informations diff�rents destinateurs.
 * mais dans cette deuxi�me version les instructions � destination du controlleur sont ordonn�s � partir de l'adaptateur de bouton.
 */
public class Concret_Bouton_Start implements IClavier{

	IIhm ihm;
	ICommand concretCommandRunning;
	
	 public Concret_Bouton_Start(IIhm ihm) {
		 this.ihm=ihm;
		 ihm.enregistrerRunnig(this);
	}
	
	@Override
	public void setBoutonCheckedCommand(ICommand command) {
		this.concretCommandRunning=command;
		
	}

	@Override
	public void touchePresse() {
		this.concretCommandRunning.execute();
		System.out.println("je suis dans le bouton start");
	}

	@Override
	public void setMesure(int nouvellemesure) {
		
	}

	@Override
	public int getMesure() {
		return 0;
	}

	

}
