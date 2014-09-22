package com.tracker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.tracker.domain.Trackeable;


/**
 * 
 * @author matias.garcia
 *
 */



public interface TrackeableRepository extends MongoRepository<Trackeable, String> {
	
	
	
	Trackeable findById(String id);
	
	@Query(value="{ 'id' : ?0 }", fields="{ 'historial' : 1}")
	Trackeable findHistorialById(String id);

}
