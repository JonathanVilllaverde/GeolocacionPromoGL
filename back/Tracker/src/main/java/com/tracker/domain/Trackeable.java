package com.tracker.domain;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.mapping.Document;

import com.tracker.area.Area;


/**
 * 
 * @author matias.garcia
 *
 */
@Document
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="type")
@JsonSubTypes({  
    @Type(value = Truck.class, name = "Truck"),  
    @Type(value = Car.class, name= "Car"),
    @Type(value = Gendarme.class, name= "Gendarme")
    })
public abstract class Trackeable {
	
	@Id
	private String id;
	@JsonIgnore
	private Point location;
	@JsonIgnore
	private List<HistoryData> history;
	@JsonIgnore
	private Boolean inarea;
	
	public Trackeable(){
		this.inarea = Boolean.FALSE;
		this.history = new ArrayList<HistoryData>();
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
	 * @return the location
	 */
	@JsonProperty("location")
	public Point getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	@JsonIgnore
	public void setLocation(Point location) {
		this.location = location;
	}

	/**
	 * @return the historial
	 */
	@JsonProperty("history")
	public List<HistoryData> getHistory() {
		return history;
	}
	
	/**
	 * @param history the historial to set
	 */
	@JsonIgnore
	public void setHistory(List<HistoryData> history) {
		this.history = history;
	}

	/**
	 * @return the area
	 */
	public abstract Area getArea();

	/**
	 * @return the inarea
	 */
	@JsonProperty("inarea")
	public Boolean getInarea() {
		return inarea;
	}

	/**
	 * @param inarea the inarea to set
	 */
	@JsonIgnore
	public void setInarea(Boolean inarea) {
		this.inarea = inarea;
	}
	
}
