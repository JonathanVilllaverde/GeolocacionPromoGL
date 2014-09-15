package com.tracker.area;

import com.tracker.area.events.NormalEventArea;


/**
 * 
 * @author matias.garcia
 *
 */
public class CityArea extends Area {

	private NormalEventArea eventArea;
	
	public CityArea(){
		eventArea = new NormalEventArea();
	}

	public void abandonoPuesto(){
		eventArea.abandonoPuesto(this);
	}

	/**
	 * @return the eventArea
	 */
	public NormalEventArea getEventArea() {
		return eventArea;
	}

	/**
	 * @param eventArea the eventArea to set
	 */
	public void setEventArea(NormalEventArea eventArea) {
		this.eventArea = eventArea;
	}

}
