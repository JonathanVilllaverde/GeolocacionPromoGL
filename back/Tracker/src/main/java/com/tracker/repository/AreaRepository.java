package com.tracker.repository;

import java.util.List;

import org.springframework.data.geo.Polygon;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.tracker.area.Area;

/**
 * 
 * @author matias.garcia
 *
 */
public interface AreaRepository extends MongoRepository<Area, String> {

	List<Area> findByPoligonoWithin(Polygon mapArea);

}
