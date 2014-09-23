package com.tracker.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tracker.domain.PolygonWrapper;
import com.tracker.domain.Trackeable;


/**
 * 
 * @author matias.garcia
 *
 */
public interface TrackeableRepository extends MongoRepository<Trackeable, String> {

    Trackeable findById(String id);
    Trackeable findByLocationWithinAndId(PolygonWrapper p, String id);
    List<Trackeable> findByLocationWithin(PolygonWrapper mapArea);
    List<Trackeable> findByInarea(Boolean inarea);
}
