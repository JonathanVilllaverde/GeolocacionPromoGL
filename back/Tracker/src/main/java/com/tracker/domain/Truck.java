package com.tracker.domain;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.tracker.area.FrontierArea;

/**
 * 
 * @author matias.garcia
 *
 */
public class Truck extends Vehicle{
	
	@JsonIgnore
    private FrontierArea area;
    
    public Truck(){
    	super();
    }

	/**
	 * @return the area
	 */
    @JsonIgnore
	public FrontierArea getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
    @JsonIgnore
	public void setArea(FrontierArea area) {
		this.area = area;
	}

	public Trackeable historyRevision() {
		return null;
	}
}
