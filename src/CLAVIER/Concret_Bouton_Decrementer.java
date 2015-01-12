package CLAVIER;

import ConcreteCommand.ICommand;
import IHM.IIhm;
/**
 * 
 * @author dabo mohamed et hodabalo essos-solam tiadema
 * on a mis en place le pattern observeur sur les concrets boutons, pour avoir de l'information 
 * provenant de l'ihm.
 * ainsi � partir de chaque concret bouton un concret commande adapt� est sollicit� pour envoyer les instructions au Controlleur 
 * qui s'occupe de transmettre les informations diff�rents destinateurs.
 */
public class Concret_Bouton_Decrementer implements IClavier{
	
	
	IIhm ihm;
	ICommand concretCommandDecrement;
	IClavier incrementer;
	
	
	 public Concret_Bouton_Decrementer (IIhm ihm,IClavier incrementer) {
		 this.ihm=ihm;
		 ihm.enregistrerDecremente(this);
		 this.incrementer=incrementer;
	}

	@Override
	public void setBoutonCheckedCommand(ICommand command) {
		this.concretCommandDecrement=command;
	}

	@Override
	public void actualiser() {
		this.concretCommandDecrement.execute();
	}


	@Override
	public void setMesure(int nouvellemesure) {
		
	}

	@Override
	public int getMesure() {
		return this.ihm.getMesure();
	}

}
