package com.tracker.domain;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author matias.garcia
 *
 */
public class PolygonWrapper {

	private List<PointWrapper> points;
	
	public PolygonWrapper(){
		super();
		this.points = new ArrayList<PointWrapper>();
	}	

	public PolygonWrapper(PointWrapper x, PointWrapper y, PointWrapper z, PointWrapper... others) {
		super();
		this.points = new ArrayList<PointWrapper>();
		this.points.add(x);
		this.points.add(y);
		this.points.add(z);
		this.points.addAll(Arrays.asList(others));
	}

	public PolygonWrapper(List<PointWrapper> points) {
		super();
		this.points = new ArrayList<PointWrapper>();
		this.points = points;
	}

	/**
	 * @return the points
	 */
	public List<PointWrapper> getPoints() {
		return points;
	}

	/**
	 * @param points the points to set
	 */
	public void setPoints(List<PointWrapper> points) {
		this.points = points;
	}
	
	
	
}
