package com.tracker.domain;

import com.tracker.area.FrontierArea;

/**
 * 
 * @author matias.garcia
 *
 */
public class Truck extends Vehicle{

    private FrontierArea area;
    
    public Truck(){
    	super();
    }

	/**
	 * @return the area
	 */
	public FrontierArea getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(FrontierArea area) {
		this.area = area;
	}

	
}
