package com.tracker.domain;

/**
 * 
 * @author matias.garcia
 *
 */
public abstract class Vehicle extends Trackeable {

	private Gendarme driver;
	private String patente;
	
	public Vehicle(){
		super();
	}

	/**
	 * @return the driver
	 */
	public Gendarme getDriver() {
		return driver;
	}

	/**
	 * @param driver the driver to set
	 */
	public void setDriver(Gendarme driver) {
		this.driver = driver;
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
