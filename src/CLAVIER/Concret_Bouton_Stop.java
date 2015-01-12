package CLAVIER;

import ConcreteCommand.ICommand;
import IHM.IIhm;
/**
 * 
 * @author dabo mohamed et odabalo essossolam tiadema
 * on a mis en place le pattern observeur sur les concrets boutons, pour avoir de l'information 
 * provenant de l'ihm.
 * ainsi à partir de chaque concret bouton un concret commande adapté est sollicité pour envoyer les instructions au Controlleur 
 * qui s'occupe de transmettre les informations différents destinateurs.
 * mais dans cette deuxième version les instructions à destination du controlleur sont ordonnés à partir de l'adaptateur de bouton.
 */
public class Concret_Bouton_Stop implements IClavier{
	IIhm ihm;
	ICommand concretCommandStop;
	
	 public Concret_Bouton_Stop(IIhm ihm) {
			 this.ihm=ihm;
			 ihm.enregistrerStop(this);
		}
		
		@Override
		public void setBoutonCheckedCommand(ICommand command) {
			this.concretCommandStop=command;	
		}

		@Override
		public void touchePresse() {
			this.concretCommandStop.execute();
		}

		@Override
		public void setMesure(int nouvellemesure) {	
		}

		@Override
		public int getMesure() {
			return 0;
		}

}
