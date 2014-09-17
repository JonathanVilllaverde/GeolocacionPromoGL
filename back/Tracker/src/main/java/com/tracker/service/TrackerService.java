package com.tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.data.geo.Polygon;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.tracker.domain.Gendarme;
import com.tracker.domain.Trackeable;
import com.tracker.repository.TrackeableRepository;

/**
 * 
 * @author matias.garcia
 *
 */
@Service
public class TrackerService {

	@Autowired 
	TrackeableRepository repository;
	@Autowired
	MongoTemplate mongoTemplate;
	
	public <CHILD extends Trackeable> CHILD save(CHILD trackeable){
		return repository.save(trackeable);
	}
	
	public void registrarCoordenada(Gendarme gendarme) {
		// findById
		// TODO: definir como va a recibir el objeto gendarme
		// implementar query sobre el repo y no sobre mongoTemplate
		// Query { name : "name"}
		Query query = Query.query(Criteria.where("name").is(gendarme.getName()));
		Gendarme gObtained = (Gendarme) mongoTemplate.findOne(query , Trackeable.class);

		if(gObtained != null){
			// persist, no esta guardando el historial.
		    Gendarme g = new Gendarme();
		    g.setName(gObtained.getName());
		    g.setLatLong(gObtained.getLatLong());
			gObtained.getHistorial().add(g);
			gObtained.setLatLong(gendarme.getLatLong());
			gObtained.setVehicle(gendarme.getVehicle());
			gObtained = repository.save(gObtained);
	
			if(gObtained.getVehicle() != null){
				if(gObtained.getVehicle().getArea() != null){
				// findInArea
					Query queryA = Query.query(Criteria.where("latLong").within(gObtained.getVehicle().getArea().getPoligono()).
					andOperator(Criteria.where("name").is(gendarme.getName())));
			
					if(!mongoTemplate.exists(queryA , Trackeable.class)){
						gObtained.getVehicle().getArea().abandonoPuesto();
					}
				}
			}
		}else{
			gObtained = repository.save(gendarme);
		}
	}
	
	public List<Trackeable> getAgents(Point sw, Point ne){
		Point se = new Point(ne.getX(), sw.getY());
		Point nw = new Point(sw.getX(), ne.getY());
		Polygon mapArea = new Polygon(nw, ne, se, sw);
		Query queryA = Query.query(Criteria.where("latLong").within(mapArea));
		List<Trackeable> result = mongoTemplate.find(queryA,  Trackeable.class);
		
		return result;
	}
}
