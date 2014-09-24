package com.tracker.area;



/**
 * 
 * @author matias.garcia
 *
 */
public class CityArea extends Area {
	
	public CityArea(){
		super();
		this.setAreaStrategy(AreaStrategies.NORMAL);
	}

	public CityArea(String name) {
		super();
		this.setAreaStrategy(AreaStrategies.NORMAL);
		this.setName(name);
	}

}
