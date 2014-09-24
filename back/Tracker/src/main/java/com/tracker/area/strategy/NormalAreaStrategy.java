package com.tracker.area.strategy;

import java.util.Date;

import com.tracker.area.Area;
import com.tracker.area.notifications.AbandonedArea;
import com.tracker.area.notifications.InCourse;
import com.tracker.area.notifications.OutOfAreaAssigned;
import com.tracker.domain.Agent;
import com.tracker.domain.Trackeable;
import com.tracker.domain.Vehicle;
import com.tracker.service.NotificationService;

/**
 * 
 * @author matias.garcia
 *
 */
public class NormalAreaStrategy implements AreaStrategy{
	
	NotificationService service;
	
	/**
	 * TODO: 1 ) notificar al gendarme
	 */
	public void abandonoDePuesto(Agent gendarme, Area area) {
		service.saveEvent(new AbandonedArea(area, gendarme, new Date()));
	}
	
	public void outOfAreaAssigned(Vehicle vehicle, Area area) {
		service.saveEvent(new OutOfAreaAssigned(vehicle.getArea(), vehicle, new Date()));
	}

	/**
	 * @return the service
	 */
	public NotificationService getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(NotificationService service) {
		this.service = service;
	}

	public void inArea(Trackeable trackeable, Area area) {
		InCourse event = new InCourse();
		event.setArea(area);
		event.setTrackeable(trackeable);
		event.setDate(new Date());
		service.saveEvent(event);			
	}

}
