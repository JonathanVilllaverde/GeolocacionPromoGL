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
public class CriticalAreaStrategy implements AreaStrategy {

	NotificationService service;
	
	/**
	 * TODO: 1 ) notificar al gendarme
	 * TODO: 2 ) reasignar otro gendarme al puesto
	 */
	public void abandonoDePuesto(Agent agent, Area area) {
		AbandonedArea event = new AbandonedArea();
		event.setArea(area);
		event.setAgent(agent);
		event.setDate(new Date());
		service.saveEvent(event);		
	}
	
	public void outOfAreaAssigned(Vehicle vehicle, Area area) {
		OutOfAreaAssigned event = new OutOfAreaAssigned();
		event.setArea(area);
		event.setVehicle(vehicle);		
		service.saveEvent(event);
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
		service.saveEvent(new InCourse(area,trackeable,new Date()));			
	}

}
