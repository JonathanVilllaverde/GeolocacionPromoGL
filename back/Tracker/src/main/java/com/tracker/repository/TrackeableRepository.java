package com.tracker.repository;

import java.util.List;

import org.springframework.data.geo.Polygon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.tracker.domain.Trackeable;


/**
 * 
 * @author matias.garcia
 *
 */



public interface TrackeableRepository extends MongoRepository<Trackeable, String> {
	
	
	

	
	@Query(value="{ 'id' : ?0 }", fields="{ 'historial' : 1}")
	Trackeable findHistorialById(String id);

    Trackeable findById(String id);
    Trackeable findByLocationWithinAndId(Polygon p, String id);
    List<Trackeable> findByLocationWithin(Polygon mapArea);
    List<Trackeable> findByInarea(Boolean inarea);
}
