package com.tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.data.geo.Polygon;
import org.springframework.stereotype.Service;

import com.tracker.area.Area;
import com.tracker.repository.AreaRepository;

/**
 * 
 * @author matias.garcia
 *
 */
@Service
public class AreaService {

	@Autowired
	AreaRepository areaRepository;

	/**
	 * Persiste una instancia de area.
	 * 
	 * @param ge
	 * @return 
	 */
	public <CHILD extends Area> CHILD save(CHILD area){
		return areaRepository.save(area);
	}
	
	/**
	 * Devuelve las areas
	 * @return
	 */
	public List<Area> getArea(){
		return areaRepository.findAll();
	}
	
	/**
	 * Devuelve una Lista de Areas contenidas dentro de las coordenadas.
	 * 
	 * @param sw: southwest point
	 * @param ne: northeast point 
	 */
	public List<Area> getArea(Point sw, Point ne){
		Point se = new Point(ne.getX(), sw.getY());
		Point nw = new Point(sw.getX(), ne.getY());
		Polygon mapArea = new Polygon(nw, ne, se, sw);
		return areaRepository.findByPoligonoWithin(mapArea);
	}
	
}
