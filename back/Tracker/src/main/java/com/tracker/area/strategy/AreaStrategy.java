package com.tracker.area.strategy;

import com.tracker.area.Area;
import com.tracker.domain.Gendarme;
import com.tracker.domain.Vehicle;

/**
 * 
 * @author matias.garcia
 *
 */
public interface AreaStrategy {

	void abandonoDePuesto(Gendarme trackeable, Area area);
	void outOfAreaAssigned(Vehicle vehicle, Area area);

}
