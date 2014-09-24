package com.tracker.area.notifications;

import java.util.Date;

import com.tracker.area.Area;
import com.tracker.area.strategy.AreaStrategy;
import com.tracker.domain.Agent;
import com.tracker.domain.Trackeable;

/**
 * 
 * @author matias.garcia
 *
 */
public class AbandonedArea extends NotificationEvent {

	private Agent agent;
	private Area area;

	public AbandonedArea(){
		super();
	}
	
	public AbandonedArea(Date date, Agent gendarme) {
		super(date);
		this.agent = gendarme;
	}
	
	public AbandonedArea(Area area, Agent gendarme, Date date) {
		super();
		this.setArea(area);
		this.setAgent(gendarme);
		this.setDate(date);
	}

	/**
	 * @return the gendarme
	 */
	public Agent getAgent() {
		return agent;
	}

	/**
	 * @param gendarme the gendarme to set
	 */
	public void setAgent(Agent gendarme) {
		this.agent = gendarme;
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
		ea.abandonoDePuesto((Agent) trackeable, trackeable.getArea());
	}
	
	@Override
	public String toString(){
		return "Abandono de puesto";
	}
	
}
