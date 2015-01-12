package IHM;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.BorderLayout;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.Color;
import java.beans.FeatureDescriptor;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JSlider;
import javax.swing.DefaultComboBoxModel;

import ADAPTATEUR.Anti_adaptateur_bouton;
import ADAPTATEUR.Anti_adaptateur_slider;
import CLAVIER.IClavier;
import ConcreteCommand.*;
import Controller.ControlleurImpl;
import DISPLAY.IDisplay;
import IMolette.ISlider;
import IMolette.SliderImpl;
import ME.MetronomeEngineImpl;

/**
 * 
 * @author dabo mohamed et odabalo essossolam tiadema
 * c'est l'ihm il existe un pattern observeur entre l'ihm et les boutons concrets.
 * mais dans cette deuxième version les methodes actualisées du pattern observeur ne sont pas solliciter car 
 * le déclenchement des évenements concernant le metronome engine ne sont plus liés a l'ihm. Ainsi l'ihm ne peut prévenir que 
 * le anti adaptateur de bouton et de slider, qui a leur tour est visité regulièrement par les adaptateurs de bouton et de slider 
 * qui peuvent ainsi informé  par l'intermediare de bouton concret et de commande concrete le metronome engine.
 */

public class IhmImpl extends JFrame implements IIhm,  ActionListener, ChangeListener{

private JFrame fenetre;//fenêtre principale
private JButton bStart;//Bouton de marche
private JButton bStop;//Bouton d'arrêt
private JButton bIncremente;//Bouton d'augmentation de mesure
private JButton bDecremente;//Bouton de diminution de mesure
private JSlider sliderTempo;//Slider de tempo
private JPanel conteneur;
private Label afficheurTempo;
private Label afficheurMesure;
static String valeurSliderTempo;
int mesure=2;
static float position=0;

private Label led1;
private Label led2;
private Anti_adaptateur_bouton antiadaptateur;
private Anti_adaptateur_slider antiadaptateurslider;
private ICommand commande ;
private ICommand sliderChanged ;
private ICommand Stop;
private ISlider slider;
private IClavier bRunning;
private IClavier bIncrementer;
private IClavier bDecrementer;
private IClavier boutonStop;

/**
* Launch the application.
*/
@SuppressWarnings("static-access")
public IhmImpl() {
		fenetre=new JFrame("MétronomeV2");
		conteneur=new JPanel();
		afficheurTempo=new Label("");
		afficheurMesure=new Label("");
		led1=new Label("");
		led2=new Label("");
	
		bDecremente=new JButton("Decremente");
		bIncremente=new JButton("Incremente");
		bStop=new JButton("Stop");
		bStart=new JButton("Start");
		 sliderTempo = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);
	        sliderTempo.setMinorTickSpacing(5);
	        sliderTempo.setMajorTickSpacing(20);
	        sliderTempo.setPaintTicks(true);
	        sliderTempo.setPaintLabels(true);
	        sliderTempo.setLabelTable(sliderTempo.createStandardLabels(1));

		
		
		fenetre.setSize(600, 200);
		fenetre.setLocationRelativeTo(null);
		
		afficheurTempo.setPreferredSize(new Dimension(200, 30));
		afficheurMesure.setPreferredSize(new Dimension(200, 30));
		afficheurMesure.setText("Selectionner la mesure et le tempo");

		led1.setPreferredSize(new Dimension(35, 15));
		led1.setVisible(true);
		led1.setBackground(getBackground().black);
		led1.setBounds(getBounds());
		led2.setPreferredSize(new Dimension(35, 15));
		led2.setVisible(true);
		led2.setBackground(getBackground().black);
		led2.setBounds(getBounds());
		sliderTempo.setPreferredSize(new Dimension(500,50));
		
		conteneur.add(afficheurTempo );
		conteneur.add(afficheurMesure );
		conteneur.add(led1);
		conteneur.add(led2);
		conteneur.add(bDecremente);
		conteneur.add(bIncremente);
		conteneur.add(bStart);
		conteneur.add(bStop);
		conteneur.add(sliderTempo);
		
		afficheurTempo.setVisible(true);
		afficheurMesure.setVisible(true);
		bDecremente.addActionListener(this);
		bIncremente.addActionListener(this);
		bStop.addActionListener(this);
		bStart.addActionListener(this);
		sliderTempo.addChangeListener(this);;
		fenetre.setContentPane(conteneur);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);

		
	}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	JButton button= (JButton) e.getSource();
	if(bStart == button){
		antiadaptateur.activeBouton(0);
	}
	
	
	if(bIncremente == button){
		if(mesure  < 7){
		mesure++;
		antiadaptateur.activeBouton(2);
		this.notifierDecrement();
		this.notifierIncremente();
		}
		else if(mesure ==7){
			this.notifierIncremente();
		}
	}
	
	
	if(bDecremente == button){
		if(mesure > 2){
		mesure--;
		antiadaptateur.activeBouton(3);
		this.notifierIncremente();
		this.notifierDecrement();
		}
		else if(mesure==2){
			this.notifierDecrement();
		}
	}
	
	if(bStop==button){
		antiadaptateur.activeBouton(1);}
	
	
	}


public void stateChanged(ChangeEvent ev){
double v=sliderTempo.getValue() ;
 position=(float) (v/10);
	valeurSliderTempo= ""+ position;
	antiadaptateurslider.readPositionSlider(position);
	
	
  }

@Override
public void setSliderChanged(ICommand command) {
	// TODO Auto-generated method stub
	this.sliderChanged=command;
}

@Override
public float getPosition() {
	// TODO Auto-generated method stub
	return position;
}

@Override
public void enregistrerSlider(ISlider slider) {
	// TODO Auto-generated method stub
	this.slider=slider;
}

@Override
public void supprimerObservateur(ISlider slider) {
	// TODO Auto-generated method stub
	
}

@Override
public void notifierSliders() {
}

@Override
public void setSlider(ISlider slider) {
	this.slider=slider;
}

@Override
public void afficherTempo(String s) {
	afficheurTempo.setText("Tempo =" +" "+s);
}

@Override
public void afficherMesure(String s) {
	afficheurMesure.setText("mesure =" +" "+s);
}

@Override
public void enregistrerRunnig(IClavier bRunning) {
	this.bRunning=bRunning;
}

@Override
public void notifierRunning() {
	// TODO Auto-generated method stub
	//this.bRunning.actualiser();
}

@Override
public void enregistrerStop(IClavier bStop) {
	// TODO Auto-generated method stub
	this.boutonStop=bStop;
}

@Override
public void notifierStop() {
	// TODO Auto-generated method stub
	//this.boutonStop.actualiser();
}

@Override
public void enregistrerIncremente(IClavier bIncrementer) {
	// TODO Auto-generated method stub
	this.bIncrementer=bIncrementer;

}

@Override
public void notifierIncremente() {
	// TODO Auto-generated method stub
	//this.bIncrementer.actualiser();
	this.bIncrementer.setMesure(mesure);
}

@Override
public void enregistrerDecremente(IClavier bDecrementer) {
	// TODO Auto-generated method stub
this.bDecrementer=bDecrementer;	
}

@Override
public void notifierDecrement() {
	// TODO Auto-generated method stub
	//this.bDecrementer.actualiser();
	this.bDecrementer.setMesure(mesure);
}

@Override
public void allumerLed1() {

	// TODO Auto-generated method stub
	led1.setBackground(Color.white);
}

@Override
public void eteindreLed1() {
	// TODO Auto-generated method stub
	led1.setBackground(Color.black);
}

@Override
public void setConcretCommandStop(ICommand command) {
	this.Stop=command;
}

@Override
public void allumerLed2() {
	led2.setBackground(Color.white);
}

@Override
public void eteindreLed2() {
	led2.setBackground(Color.black);
}


@Override
public void setAntiadaptateur(Anti_adaptateur_bouton antiadaptateur) {
	this.antiadaptateur=antiadaptateur;
}

@Override
public int getMesure() {
	return mesure;
}

@Override
public void setAntiadaptateurSlider(Anti_adaptateur_slider antiadaptateurslider) {
	this.antiadaptateurslider=antiadaptateurslider;
}



}
