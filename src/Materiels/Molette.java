package Materiels;

public class Molette {
	
	private float current;
	private float newValue;
	
	/**
	 * Constructeur de la molette
	 */
	public Molette(){
		this.current=0.5f;
		this.newValue=current;
	}
	
	/**
	 * retourne la position actuel de la molette
	 * @return
	 */
	public float getCurrent(){
		return this.current;
	}
	
	/**
	 * retourne la nouvelle position 
	 * @return
	 */
	public float getNewValue(){
		return this.newValue;
	}
	
	/**
	 * Défini la nouvelle valeur de la molette
	 * @param f
	 */
	public void setNewValue(float f){
		this.newValue=f;
	}
	
	/**
	 * Défini la valeur actuelle de la molette
	 * @param f
	 */
	public void setCurrent(float f){
		this.current=f;
	}

}
