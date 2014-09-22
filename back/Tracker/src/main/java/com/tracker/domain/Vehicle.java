package com.tracker.domain;



/**
 * 
 * @author matias.garcia
 *
 */
public abstract class Vehicle extends Trackeable {

	private String patente;
	
	public Vehicle(){
		super();
	}

	/**
	 * @return the patente
	 */
	public String getPatente() {
		return patente;
	}

	/**
	 * @param patente the patente to set
	 */
	public void setPatente(String patente) {
		this.patente = patente;
	}


}
