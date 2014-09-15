package com.tracker.domain;

import com.tracker.area.CityArea;

/**
 * 
 * @author matias.garcia
 *
 */
public class Car extends Vehicle{
	
	private CityArea area;

	/**
	 * @return the area
	 */
	public CityArea getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(CityArea area) {
		this.area = area;
	}

}
