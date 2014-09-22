package com.tracker.area.strategy;

import java.util.Date;

import com.tracker.area.Area;
import com.tracker.area.notifications.AbandonoDePuesto;
import com.tracker.area.notifications.OutOfAreaAssigned;
import com.tracker.domain.Gendarme;
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
	public void abandonoDePuesto(Gendarme gendarme, Area area) {
		AbandonoDePuesto event = new AbandonoDePuesto();
		event.setArea(area);
		event.setGendarme(gendarme);
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

}
