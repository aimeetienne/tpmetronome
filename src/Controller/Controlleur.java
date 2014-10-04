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

	
	private IHM ihm ;
	private MetronomeEngine model = new MetronomeEngine();


public Controlleur(IHM ihm2) {
		this.ihm= ihm2;
	}

public void Beatplus(){
	model.setBeatperbar(model.getBeatperbar()+1);
	
	}

public void Beatmoins(){
	model.setBeatperbar(model.getBeatperbar()-1);
	ihm.setLabel(model.getBeatperbar());
}

public void Tempoplus(){
	int i=model.getTempo();
	i++;
}


public void Tempomoins(){
	int i=model.getTempo();
	i++;
	
	
}



}

