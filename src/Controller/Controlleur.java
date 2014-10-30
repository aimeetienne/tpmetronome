package Controller;

import invoker.MetronomeEngine;

import java.awt.Button;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import IHM.IHM;
import fr.istic.m2miage.Command;

public class Controlleur {

	private MetronomeEngine model;
	private IHM ihm ;
	
public Controlleur(IHM ihm2, MetronomeEngine model) {
		this.ihm= ihm2;
		this.model=model;
	}




public void Beatplus(){
	model.setMesure(model.getMesure()+1);
	}

public void Beatmoins(){
	model.setMesure(model.getMesure()-1);
	}

public void Tempoplus(){
	model.setTempo(model.getTempo()+1);
}


public void Tempomoins(){
	model.setTempo(model.getTempo()-1);

}


/**
 * D�marre le moteur
 */
public void Start(){
	if(!model.isRunning())
		model.setRunning(true);
}

/**
 *Arr�te le moteur
 */

public void Stop(){
	if(model.isRunning())
		model.setRunning(false);
}

/**
 * Pour chaque tempo en flashant la LED1 et en jouant un son
 */
public void doTempo() {

}

/**
 * Traitement de tempo et de la mesure
 */
public void traitement(){
	}

/**
 * Marquant le premier temp de chaque mesure en flashant la LED2 et en jouant un son
 */
public void doMesure() {
	
}

public IHM getIhm() {
	return ihm;
}


public void setIhm(IHM ihm) {
	this.ihm = ihm;
}

public MetronomeEngine getModel() {
	return model;
}


public void setModel(MetronomeEngine model) {
	this.model = model;
}

/**
 * Notification venant du moteur pour mettre l'ihm � jour
 */
public void updateMoteur() {
	ihm.setLeTempo(Integer.toString(model.getTempo()));
	ihm.setlamesure(Integer.toString(model.getMesure()));
}



}

