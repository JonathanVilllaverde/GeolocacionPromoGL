package com.tracker.area.events;

import com.tracker.area.Area;

/**
 * 
 * @author matias.garcia
 *
 */
public class NormalEventArea implements EventArea{

	/**
	 * las areas no criticas no ejecutan acciones.
	 */
	public void abandonoPuesto(Area area) {
		System.out.println("abandono el puesto el gendarme, no hago nada");		
	}

}
