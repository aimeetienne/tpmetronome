package HORLOGE;
//import ConcreteCommand.ConcretCommandEteindreLed2;
import ConcreteCommand.ICommand;
import ME.IMetronomeEngine;
public interface IHorloge {

	public void activerPeriodiquement(ICommand command, float periodeEnSecondes);
	public void activerPeriodiquement2(ICommand command, float periodeEnSecondes);
	public void activerApresDelai(ICommand command, float delaiEnSecondes);
	public void desactiver(ICommand commande);
	public void setTickConcreteCommand(ICommand tickConcretCommand);
	public void setTickConcreteEteindreLed(ICommand eteindreLed, ICommand eteindreLed2);
	public void setTickConcreteReadConcret(ICommand concretCommandRead);
	public void setTickConcreteAllumerLed(ICommand allumerLed);
	public void setMetronomeEngine(IMetronomeEngine moEngine);  
	public void setTickConcreteReadConcretSlider(ICommand concretCommandReadSlider);
	
}
