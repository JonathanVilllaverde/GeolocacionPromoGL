package com.tracker.domain;

import com.tracker.area.Area;

/**
 * 
 * @author matias.garcia
 *
 */
public class Gendarme extends Trackeable{

	private Area area;
	private String name;
	
	public Gendarme(){
		super();
	}

	/**
	 * @return the area
	 */
	public Area getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(Area area) {
		this.area = area;
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


}
