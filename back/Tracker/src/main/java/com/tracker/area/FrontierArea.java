package com.tracker.area;


/**
 * 
 * @author matias.garcia
 *
 */
public class FrontierArea extends Area {
	
	public FrontierArea(){
		super();
		this.setAreaStrategy(AreaStrategies.CRITICAL);
	}
	
	public FrontierArea(String name){
		super();
		this.setAreaStrategy(AreaStrategies.CRITICAL);
		this.setName(name);
	}

}
