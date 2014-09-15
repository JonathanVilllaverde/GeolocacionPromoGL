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
	private Point latLong;
	private List<Trackeable> historial;
	
	public Trackeable(){
		historial = new ArrayList<Trackeable>();
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
	 * @return the latLong
	 */
	public Point getLatLong() {
		return latLong;
	}
	/**
	 * @param latLong the latLong to set
	 */
	public void setLatLong(Point latLong) {
		this.latLong = latLong;
	}
	
	/**
	 * @return the historial
	 */
	public List<Trackeable> getHistorial() {
		return historial;
	}
	/**
	 * @param historial the historial to set
	 */
	public void setHistorial(List<Trackeable> historial) {
		this.historial = historial;
	}
	
	/**
	 * @return the area
	 */
	public abstract Area getArea();

	
}
