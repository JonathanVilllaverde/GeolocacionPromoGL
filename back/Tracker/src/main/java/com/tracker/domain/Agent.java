package com.tracker.domain;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import com.tracker.area.Area;



/**
 * 
 * @author matias.garcia
 *
 */
public class Agent extends Trackeable{

	private String name;
	@JsonIgnore
	private Vehicle vehicle;
	@JsonIgnore
	private Area area;
	
	public Agent(){
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
	@JsonProperty("vehicle")
	public Vehicle getVehicle() {
		return vehicle;
	}

	/**
	 * 
	 * @param vehicle
	 */
	@JsonIgnore
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	/**
	 * @return the area
	 */
	@JsonIgnore
	public Area getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	@JsonIgnore
	public void setArea(Area area) {
		this.area = area;
	}
	
	public Trackeable historyRevision() {
		return vehicle;
	}

}
