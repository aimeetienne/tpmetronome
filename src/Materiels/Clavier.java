package Materiels;

public class Clavier {

private boolean[] buttons;
	
	public Clavier() {
		buttons = new boolean[4];
		for(int i=0; i<4; i++){
			buttons[i]=false;
		}
	}
	
	/**
	 * Change la valeur du bouton en true
	 * @param numero du bouton
	 */
	public void onKeyPressed(int buttonNumber){
		buttons[buttonNumber]=true;
	}
	
	/**
	 * Retourne si le bouton est appuyé
	 * @param i
	 	 */
	public boolean buttonPressed(int i){
		return buttons[i];
	}

	/**
	 * Remet le bouton à sa valeur initiale
	 * @param numero du bouton
	 */
	public void setFalse(int buttonNumber){
		buttons[buttonNumber]=false;
	}
	
	
}
