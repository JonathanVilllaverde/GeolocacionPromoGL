package com.tracker.area.notifications;

import java.util.Date;

import com.tracker.area.Area;
import com.tracker.area.strategy.AreaStrategy;
import com.tracker.domain.Trackeable;
import com.tracker.domain.Vehicle;

/**
 * 
 * @author matias.garcia
 *
 */
public class OutOfAreaAssigned extends NotificationEvent{

	private Area area;
	private Vehicle vehicle;
	
	public OutOfAreaAssigned(Area area, Vehicle vehicle, Date date) {
		super();
		this.area = area;
		this.setVehicle(vehicle);
		this.setDate(date);
	}
	
	public OutOfAreaAssigned() {
		super();
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

	/**
	 * @return the vehicle
	 */
	public Vehicle getVehicle() {
		return vehicle;
	}

	/**
	 * @param vehicle the vehicle to set
	 */
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public void execute(AreaStrategy ea, Trackeable trackeable) {
		ea.outOfAreaAssigned((Vehicle) trackeable, trackeable.getArea());
	}
	
	@Override
	public String toString(){
		return "Fuera del area Asignada.";
	}

}
