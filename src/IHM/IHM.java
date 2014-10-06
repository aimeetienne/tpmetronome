package IHM;

import fr.istic.m2miage.Command;
import invoker.MetronomeEngine;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JSlider;
import javax.swing.DefaultComboBoxModel;

import ConcreteCommand.Dec;
import ConcreteCommand.Inc;
import ConcreteCommand.Start;
import ConcreteCommand.Stop;
import Controller.Controlleur;

public class IHM extends JFrame {

	
	private Controlleur control = new Controlleur(this);

      
      private JFrame metronome;//fenêtre principale

      private JButton ON;//Bouton de marche
      private JButton OFF;//Bouton d'arrêt
      private JButton Inc;//Bouton d'augmentation de mesure
      private JButton Dec;//Bouton de diminution de mesure
      private JSlider sldTempo;//Slider de tempo

      
      //ActionListener associés aux boutons et au slider
      private ActionListener listOn;
      private ActionListener listOff;
      private ActionListener listInc;
      private ActionListener listDec;
      private ChangeListener listTempo;
      
    //LED
      private JPanel led1;
      private JPanel led2;
      
      //Affichage
      private JTextField letempo;
      private JLabel lamesure;
      private JTextField measureLabel;
      private JTextField tempoLabel;
      
  	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IHM frame = new IHM();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	 public IHM() {

             
         //Implémentation de la fenêtre
         metronome=new JFrame("Métronome");
         metronome.getContentPane().setLayout(new BorderLayout());
         metronome.setSize(600, 500);
         metronome.setLocationRelativeTo(null);
         metronome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         metronome.setVisible(true);
         metronome.setResizable(false);

         //Implémentation des éléments
         ON=new JButton("ON");
         OFF=new JButton("OFF");
         Inc=new JButton("Inc");
         Dec=new JButton("Dec");
         sldTempo=new JSlider(40, 208);
         letempo=new JTextField("124");
         lamesure=new JLabel("2");
         measureLabel=new JTextField("Measure : ");
         tempoLabel=new JTextField("Tempo : ");
         led1=new JPanel();
         led2=new JPanel();
         led1.setBackground(Color.black);
         led2.setBackground(Color.black);
         JPanel buttonPanel=new JPanel();
         JPanel screenAndLedPanel=new JPanel();
         JPanel ledPanel=new JPanel();
         letempo.setEditable(false);
         lamesure.setFocusable(false);
         tempoLabel.setEditable(false);
         measureLabel.setEditable(false);
         
         //ajout des composants
         buttonPanel.setLayout(new GridLayout(1, 5));
         screenAndLedPanel.setLayout(new GridLayout(2,4));
         metronome.getContentPane().add(buttonPanel, BorderLayout.PAGE_END);
         metronome.getContentPane().add(screenAndLedPanel, BorderLayout.PAGE_START);
         metronome.getContentPane().add(sldTempo, BorderLayout.CENTER);
         screenAndLedPanel.add(tempoLabel);
         screenAndLedPanel.add(letempo);
         screenAndLedPanel.add(led1);
         screenAndLedPanel.add(led2);
         screenAndLedPanel.add(measureLabel);
         screenAndLedPanel.add(lamesure);
         
         screenAndLedPanel.add(new JPanel());
         screenAndLedPanel.add(new JPanel());
         buttonPanel.add(ON);
         buttonPanel.add(OFF);
         buttonPanel.add(new JPanel());
         buttonPanel.add(Dec);
         buttonPanel.add(Inc);
         letempo.setSize(100, 60);
         
         //Mise en place des listeners
         this.listOn=new ActionListener() {
                 public void actionPerformed(ActionEvent arg0) {
                	 Command s=new Start(control);
                	    	  s.execute();        
                 }
         };
         this.listOff=new ActionListener() {
                 public void actionPerformed(ActionEvent arg0) {
                	 Command st=new Stop(control);
                	      	  st.execute();       
                 }
         };
         this.listInc=new ActionListener() {
                 public void actionPerformed(ActionEvent arg0) {
                	 if(getlamesure()!=7 ){
                		 Command inc=new Inc(control);
             				inc.execute();
             				}    
                 }
         };
         this.listDec=new ActionListener() {
                 public void actionPerformed(ActionEvent arg0) {

     				if(getlamesure()!=2){
     					 Command dec=new Dec(control);
     							dec.execute();
     				}     
                 }
         };
         this.listTempo=new ChangeListener() {
                 public void stateChanged(ChangeEvent e) {
                                                      
                 }
         };
         ON.addActionListener(listOn);
         OFF.addActionListener(listOff);
         Inc.addActionListener(listInc);
         Dec.addActionListener(listDec);
         sldTempo.addChangeListener(listTempo);
         
 }
 
 /**
  * Flash la led 1 en utilisant un timer pour
  * que le flash soit visible
  */

	  public JTextField getScreen() {
			return letempo;
		}



		public void setScreen(JTextField letempo) {
			this.letempo = letempo;
		}



		public int getlamesure() {
			return Integer.parseInt(lamesure.getText().toString());
		}



		public void setlamesure(int i) {
			this.lamesure.setText(""+i);
		}
	
	
}
