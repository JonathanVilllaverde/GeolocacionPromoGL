package com.tracker.area.strategy;

import com.tracker.area.Area;
import com.tracker.domain.Agent;
import com.tracker.domain.Vehicle;

/**
 * 
 * @author matias.garcia
 *
 */
public interface AreaStrategy {

	void abandonoDePuesto(Agent trackeable, Area area);
	void outOfAreaAssigned(Vehicle vehicle, Area area);
	void inArea(Agent trackeable, Area area);

}
