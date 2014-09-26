package com.tracker.area.strategy;

import com.tracker.area.Area;
import com.tracker.domain.Agent;
import com.tracker.domain.Trackeable;
import com.tracker.domain.Vehicle;

/**
 * 
 * @author matias.garcia
 *
 */
public class CriticalAreaStrategy implements AreaStrategy {

	/**
	 * TODO: 1 ) notificar al gendarme
	 * TODO: 2 ) reasignar otro gendarme al puesto
	 */
	public void abandonoDePuesto(Agent agent, Area area) {
		/* comportamiento de abandono de puesto */
	}
	
	public void outOfAreaAssigned(Vehicle vehicle, Area area) {
		/* comportamiento de abandono de area asignada */
	}

	public void inArea(Trackeable trackeable, Area area) {
		/*comportamiento cuando esta dentro del area*/
	}


}
