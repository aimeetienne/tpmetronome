package CLAVIER;

import ConcreteCommand.ICommand;

public interface IClavier {
	public void setBoutonCheckedCommand(ICommand command);
	public void touchePresse();
	public void setMesure(int nouvellemesure);
	public int getMesure();
	

}
