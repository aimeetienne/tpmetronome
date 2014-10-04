package invoker;

import fr.istic.m2miage.Command;

public class MetronomeEngine {

	
	private int tempo;
	private int beatperbar ;
	private boolean running;
	private Command beatcommand;
	private Command barcommand;
	
	/**
	 * @return the tempo
	 */
	public int getTempo() {
		return tempo;
	}

	/**
	 * @param tempo the tempo to set
	 */
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	/**
	 * @return the beatperbar
	 */
	public int getBeatperbar() {
		return beatperbar;
	}

	/**
	 * @param beatperbar the beatperbar to set
	 */
	public void setBeatperbar(int beatperbar) {
		this.beatperbar = beatperbar;
	}

	/**
	 * @return the running
	 */
	public boolean isRunning() {
		return running;
	}

	/**
	 * @param running the running to set
	 */
	public void setRunning(boolean running) {
		this.running = running;
	}

	/**
	 * @return the setbeatcommand
	 */
	public Command getSetbeatcommand() {
		return beatcommand;
	}

	/**
	 * @param setbeatcommand the setbeatcommand to set
	 */
	public void setSetbeatcommand(Command setbeatcommand) {
		this.beatcommand = setbeatcommand;
	}

	/**
	 * @return the barcommand
	 */
	public Command getBarcommand() {
		return barcommand;
	}

	/**
	 * @param barcommand the barcommand to set
	 */
	public void setBarcommand(Command barcommand) {
		this.barcommand = barcommand;
	}

	
}
