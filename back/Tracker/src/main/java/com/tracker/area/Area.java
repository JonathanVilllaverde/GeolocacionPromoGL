package com.tracker.area;

import org.springframework.data.geo.Polygon;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author matias.garcia
 *
 */
@Document
public abstract class Area {

	private Polygon poligono;
	private AreaStrategies areaStrategy;

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

	public AreaStrategies getAreaStrategy() {
		return areaStrategy;
	}
	
	public void setAreaStrategy(AreaStrategies areaStrategy){
		this.areaStrategy = areaStrategy;
	}
	
	public enum AreaStrategies{
		CRITICAL,
		NORMAL;
	}

}
