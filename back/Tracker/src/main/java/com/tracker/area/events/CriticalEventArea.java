package com.tracker.area.events;

import com.tracker.area.Area;

/**
 * 
 * @author matias.garcia
 *
 */
public class CriticalEventArea implements EventArea {

	/**
	 * busca un gendarme cercano y le asigna el area
	 * 
	 */
	public void abandonoPuesto(Area area) {
		System.out.println("abandono el puesto el gendarme, reasigno un nuevo gendarme");
	}

}
