package ADAPTATEUR;
import CLAVIER.IClavier;
import ConcreteCommand.ConcretCommandReadCommand;
import ConcreteCommand.ConcretCommandtRunning;
import ConcreteCommand.ICommand;
import HORLOGE.HorlogeImpl;
import HORLOGE.IHorloge;

/**
 * 
 * @author dabo mohamed et odabalo essossolam tiadema
 * l'adaptateur de bouton permet de d'adapter les événements provenants du materiel.
 *
 */

public class Adaptateur_bouton {
	
	
	IClavier bstart;
	IClavier bstop;
	IClavier bincrement;
	IClavier bdecrement;

	IHorloge horloge;
	ICommand readCommand;
	Anti_adaptateur_bouton antiadaptateur;



	public Adaptateur_bouton (IHorloge horloge){
		this.horloge=horloge;
		
	}

	public void setBstop(IClavier bstop) {
		this.bstop = bstop;
	}





	public void setBstart(IClavier bstart) {
		this.bstart = bstart;
	}



	public void setBincrement(IClavier bincrement) {
		this.bincrement = bincrement;
	}


	public void setBdecrement(IClavier bdecrement) {
		this.bdecrement = bdecrement;
	}



	public void activerHorloge(){
		horloge.activerPeriodiquement(readCommand, 1000);
	}

	public void boutonStartClicker(int nbClickButton){
		bstart.touchePresse();
	}
	
	public void boutonIncrementeClicker(int nbClickButton){
		bincrement.touchePresse();;
		}
	
	public void boutonDecrementeClicker(int nbClickButton){
		bdecrement.touchePresse();
	}
	public void boutonStopClicker(int nbClickButton){
		bstop.touchePresse();
	}

	public void setButtonStart(IClavier button) {
		this.bstart = button;
	}



	
	
	public void readCommand(){
		
		antiadaptateur.read();
	}

	public Anti_adaptateur_bouton getAntiadaptateur() {
		return antiadaptateur;
	}

	public void setAntiadaptateur(Anti_adaptateur_bouton antiadaptateur) {
		this.antiadaptateur = antiadaptateur;
	}
	

	public void setConcretCommandReadCommand(ICommand concretCommandReadCommand) {
		this.readCommand = concretCommandReadCommand;}
	
	
	public IHorloge getHorloge() {
		return horloge;
	}

	public void setHorloge(IHorloge horloge) {
		this.horloge = horloge;
	}
	
	
	
}
