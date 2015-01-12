package CLAVIER;

import ConcreteCommand.ICommand;

public interface IClavier {
	public void setBoutonCheckedCommand(ICommand command);
	public void actualiser();
	public void setMesure(int nouvellemesure);
	public int getMesure();
	

}
