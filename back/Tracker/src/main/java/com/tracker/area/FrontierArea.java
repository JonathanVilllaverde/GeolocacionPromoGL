package com.tracker.area;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.tracker.area.events.CriticalEventArea;

/**
 * 
 * @author matias.garcia
 *
 */
public class FrontierArea extends Area {

	@JsonIgnore
	private CriticalEventArea eventArea;
	
	public FrontierArea(){
		eventArea = new CriticalEventArea();
	}

	public void abandonoPuesto(){
		eventArea.abandonoPuesto(this);
	}

	/**
	 * @return the eventArea
	 */
	public CriticalEventArea getEventArea() {
		return eventArea;
	}

	/**
	 * @param eventArea the eventArea to set
	 */
	public void setEventArea(CriticalEventArea eventArea) {
		this.eventArea = eventArea;
	}
	
}
