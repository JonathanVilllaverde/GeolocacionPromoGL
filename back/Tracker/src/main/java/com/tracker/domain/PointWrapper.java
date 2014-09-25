package com.tracker.domain;

/**
 * 
 * @author matias.garcia
 *
 */
public class PointWrapper {

	private Double lat;
	private Double lng;
	
	public PointWrapper(){
		super();
	}
	
	public PointWrapper(Double x, Double y) {
		super();
		this.lat = x;
		this.lng = y;
	}
	
	/**
	 * @return the x
	 */
	public Double getLat() {
		return lat;
	}
	/**
	 * @param x the x to set
	 */
	public void setLat(Double x) {
		this.lat = x;
	}
	/**
	 * @return the y
	 */
	public Double getLng() {
		return lng;
	}
	/**
	 * @param y the y to set
	 */
	public void setLng(Double y) {
		this.lng = y;
	}
	
	
}
