package com.tracker.area.notifications;

import java.util.Date;

import com.tracker.area.Area;
import com.tracker.area.strategy.AreaStrategy;
import com.tracker.domain.Gendarme;
import com.tracker.domain.Trackeable;

/**
 * 
 * @author matias.garcia
 *
 */
public class AbandonoDePuesto extends NotificationEvent {

	private Gendarme gendarme;
	private Area area;

	public AbandonoDePuesto(){
		super();
	}
	
	public AbandonoDePuesto(Date date, Gendarme gendarme) {
		super(date);
		this.gendarme = gendarme;
	}
	
	public AbandonoDePuesto(Area area, Gendarme gendarme, Date date) {
		super();
		this.setArea(area);
		this.setGendarme(gendarme);
		this.setDate(date);
	}

	/**
	 * @return the gendarme
	 */
	public Gendarme getGendarme() {
		return gendarme;
	}

	/**
	 * @param gendarme the gendarme to set
	 */
	public void setGendarme(Gendarme gendarme) {
		this.gendarme = gendarme;
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
		ea.abandonoDePuesto((Gendarme) trackeable, trackeable.getArea());
	}
	
}
