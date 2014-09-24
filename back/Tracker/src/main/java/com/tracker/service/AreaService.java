package com.tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.data.geo.Polygon;
import org.springframework.scheduling.annotation.Async;
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
	@Async("abmExecutor")
	public <CHILD extends Area> CHILD save(CHILD area){
		return areaRepository.save(area);
	}
	
	/**
	 * Devuelve el area identificada.
	 * @return
	 */
	public Area getArea(String id){
		return areaRepository.findById(id);
	}
	
	/**
	 * Devuelve las areas
	 * @return
	 */
	public List<Area> getAreas(){
		return areaRepository.findAll();
	}
	
	/**
	 * Devuelve una Lista de Areas contenidas dentro de las coordenadas.
	 * 
	 * @param sw: southwest point
	 * @param ne: northeast point 
	 */
	public List<Area> getAreas(Point sw, Point ne){
		Point se = new Point(ne.getX(), sw.getY());
		Point nw = new Point(sw.getX(), ne.getY());
		Polygon mapArea = new Polygon(nw, ne, se, sw);
		return areaRepository.findByPoligonoWithin(mapArea);
	}
	
}
