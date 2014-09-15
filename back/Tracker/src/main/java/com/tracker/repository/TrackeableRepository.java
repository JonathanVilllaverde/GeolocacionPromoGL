package com.tracker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tracker.domain.Trackeable;


/**
 * 
 * @author matias.garcia
 *
 */
public interface TrackeableRepository extends MongoRepository<Trackeable, String> {

}
