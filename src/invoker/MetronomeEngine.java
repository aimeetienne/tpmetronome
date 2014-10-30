package invoker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import Controller.Controlleur;
import Controller.Controlleur;
import Materiels.Horloge;
import fr.istic.m2miage.Command;

public class MetronomeEngine {

	private Collection<Controlleur> observers;
	private int tempo;
	private int mesure ;
	private int compteurTempo=0;
	private boolean running;
	private Command cmdTempo;
	private Command cmdMesure;
	private Command cmdTraitement;
	private Horloge horloge;
	
	public MetronomeEngine(int tempo, int mesure, Horloge horloge){
		this.tempo=tempo;
		this.mesure=mesure;
		this.horloge=horloge;
		this.running=false;
		this.observers=new ArrayList<Controlleur>();
	}
	
	/**
	 * @return the tempo
	 */
	public int getTempo() {
		return tempo;
	}

	/**
	 * Modifie le tempo du moteur et joue le 
	 * rôle de notifieur pour le controleur qui
	 * est aussi un observeur
	 */
	public void setTempo(int tempo) {
		if(this.running){
			this.setRunning(false);
			this.compteurTempo=0;
			this.tempo=tempo;
			Iterator<Controlleur> i=observers.iterator();
			while(i.hasNext()){
				i.next().updateMoteur();
			}
			this.setRunning(true);
		}
	}
	/**
	 * @return the beatperbar
	 */
	public int getMesure() {
		return this.mesure;
	}


	/**
	 * Defini la mesure du moteur
	 */
	public void setMesure(int mesure) {
		if(mesure>0 && mesure<=7){
			this.mesure=mesure;
			while(i.hasNext()){
				i.next().updateMoteur();
			}
		}
	}		Iterator<Controlleur> i=observers.iterator();
	
	/**
	 * @return the running
	 */
	public boolean isRunning() {
		return running;
	}

	/**
	 * Met en route le moteur ou l'éteint
	 */
	public void setRunning(boolean running) {
		this.running = running;
		if(isRunning()){
			long delai=120/tempo;
			
		}
		
		
	}


	
	public Command getCmdTempo() {
		return cmdTempo;
	}

	public void setCmdTempo(Command cmdTempo) {
		this.cmdTempo = cmdTempo;
	}

	public Command getCmdMesure() {
		return cmdMesure;
	}

	public void setCmdMesure(Command cmdMesure) {
		this.cmdMesure = cmdMesure;
	}

	public Command getCmdTraitement() {
		return cmdTraitement;
	}

	public void setCmdTraitement(Command cmdTraitement) {
		this.cmdTraitement = cmdTraitement;
	}

	

	
}
