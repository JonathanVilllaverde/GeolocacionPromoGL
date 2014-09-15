package com.tracker.area;

import org.springframework.data.geo.Polygon;

/**
 * 
 * @author matias.garcia
 *
 */
public abstract class Area {

	private Polygon poligono;

	/**
	 * @return the poligono
	 */
	public Polygon getPoligono() {
		return poligono;
	}
	/**
	 * @param poligono the poligono to set
	 */
	public void setPoligono(Polygon poligono) {
		this.poligono = poligono;
	}
	
	public abstract void abandonoPuesto();

}
