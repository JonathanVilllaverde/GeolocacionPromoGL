package com.tracker.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tracker.area.Area;
import com.tracker.domain.PolygonWrapper;

/**
 * 
 * @author matias.garcia
 *
 */
public interface AreaRepository extends MongoRepository<Area, String> {

	List<Area> findByPoligonoWithin(PolygonWrapper mapArea);
	Area findById(String id);

}
