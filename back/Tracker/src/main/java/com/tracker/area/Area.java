package com.tracker.area;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Polygon;
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

	@Id
	private String id;
	private String name;
	@JsonIgnore
	private Polygon poligono;
	private AreaStrategies areaStrategy;

	/**
	 * @return the poligono
	 */
	@JsonProperty("poligono")
	public Polygon getPoligono() {
		return poligono;
	}
	/**
	 * @param poligono the poligono to set
	 */
	@JsonIgnore
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
