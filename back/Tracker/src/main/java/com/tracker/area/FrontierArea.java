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

}
