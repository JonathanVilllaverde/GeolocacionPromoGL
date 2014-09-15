package com.tracker.domain;


/**
 * 
 * @author matias.garcia
 *
 */
public class Gendarme extends Trackeable{

	private String name;
	private Vehicle vehicle;
	
	public Gendarme(){
		super();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 *
	 * @return
	 */
	public Vehicle getVehicle() {
		return vehicle;
	}

	/**
	 * 
	 * @param vehicle
	 */
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}


}
