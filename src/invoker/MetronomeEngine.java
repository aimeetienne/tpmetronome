package invoker;

import fr.istic.m2miage.Command;

public class MetronomeEngine {

	
	private Integer tempo;
	private Integer beatperbar ;
	private boolean running;
	private Command setbeatcommand;
	private Command barcommand;
	
	/**
	 * @return the tempo
	 */
	public Integer getTempo() {
		return tempo;
	}

	/**
	 * @param tempo the tempo to set
	 */
	public void setTempo(Integer tempo) {
		this.tempo = tempo;
	}

	/**
	 * @return the beatperbar
	 */
	public Integer getBeatperbar() {
		return beatperbar;
	}

	/**
	 * @param beatperbar the beatperbar to set
	 */
	public void setBeatperbar(Integer beatperbar) {
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
		return setbeatcommand;
	}

	/**
	 * @param setbeatcommand the setbeatcommand to set
	 */
	public void setSetbeatcommand(Command setbeatcommand) {
		this.setbeatcommand = setbeatcommand;
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
