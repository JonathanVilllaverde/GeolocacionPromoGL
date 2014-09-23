package com.tracker.area;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.geojson.Polygon;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author matias.garcia
 *
 */
@Document
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="type")
@JsonSubTypes({  
    @Type(value = CityArea.class, name = "CityArea"),  
    @Type(value = FrontierArea.class, name= "FrontierArea")
    })  
public abstract class Area {

	private String id;
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

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

}
