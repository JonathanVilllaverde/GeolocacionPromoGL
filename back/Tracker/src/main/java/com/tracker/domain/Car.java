package com.tracker.domain;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import com.tracker.area.CityArea;

/**
 * 
 * @author matias.garcia
 *
 */
public class Car extends Vehicle{
	
	@JsonIgnore
	private CityArea area;

	public Car(){
		super();
	}
	/**
	 * @return the area
	 */
	@JsonProperty("area")
	public CityArea getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	@JsonIgnore
	public void setArea(CityArea area) {
		this.area = area;
	}


}
