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
public class NormalAreaStrategy implements AreaStrategy{
	
	NotificationService service;
	
	/**
	 * TODO: 1 ) notificar al gendarme
	 */
	public void abandonoDePuesto(Gendarme gendarme, Area area) {
		service.saveEvent(new AbandonoDePuesto(area, gendarme, new Date()));
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

}
