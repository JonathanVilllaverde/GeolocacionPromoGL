package com.tracker.area.notifications;

import java.util.Date;

import com.tracker.area.Area;
import com.tracker.area.strategy.AreaStrategy;
import com.tracker.domain.Agent;
import com.tracker.domain.Trackeable;

public class InCourse extends NotificationEvent {

	private Trackeable trackeable;
	private Area area;

	public InCourse(){
		super();
	}
	
	public InCourse(Date date, Agent gendarme) {
		super(date);
		this.trackeable = gendarme;
	}
	
	public InCourse(Area area, Trackeable trackeable, Date date) {
		super();
		this.setArea(area);
		this.setTrackeable(trackeable);
		this.setDate(date);
	}


	/**
	 * @return the trackeable
	 */
	public Trackeable getTrackeable() {
		return trackeable;
	}

	/**
	 * @param trackeable the trackeable to set
	 */
	public void setTrackeable(Trackeable trackeable) {
		this.trackeable = trackeable;
	}

	/**
	 * @return the area
	 */
	public Area getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(Area area) {
		this.area = area;
	}

	public void execute(AreaStrategy ea, Trackeable trackeable) {
		ea.inArea((Agent) trackeable, trackeable.getArea());
	}
	
	@Override
	public String toString(){
		return "En su puesto.";
	}
	
}