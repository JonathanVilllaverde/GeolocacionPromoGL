package com.tracker.domain;

import java.util.ArrayList;
import java.util.List;

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
public abstract class Trackeable {
	
	@Id
	private String id;
	private Point location;
//	private Area area;
	private List<HistoryData> history;
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
	public Point getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(Point location) {
		this.location = location;
	}

	/**
	 * @return the historial
	 */
	public List<HistoryData> getHistory() {
		return history;
	}
	
	/**
	 * @param history the historial to set
	 */
	public void setHistory(List<HistoryData> history) {
		this.history = history;
	}

	/**
	 * @return the area
	 */
	public abstract Area getArea();

	/**
	 * @param area the area to set
	 */
//	public abstract void setArea(Area area);

	/**
	 * @return the inarea
	 */
	public Boolean getInarea() {
		return inarea;
	}

	/**
	 * @param inarea the inarea to set
	 */
	public void setInarea(Boolean inarea) {
		this.inarea = inarea;
	}
	
}
