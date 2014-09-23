package com.tracker.domain;


/**
 * 
 * @author matias.garcia
 *
 */
public class PointWrapper{

	private Double x;
	private Double y;
	
	public PointWrapper(Double x, Double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public PointWrapper(PointWrapper point) {
		super();
		this.x = point.getX();
		this.y = point.getY();
	}
	
	public PointWrapper(){
		super();
	}

	/**
	 * @return the x
	 */
	public Double getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(Double x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public Double getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(Double y) {
		this.y = y;
	}
	
	
}
