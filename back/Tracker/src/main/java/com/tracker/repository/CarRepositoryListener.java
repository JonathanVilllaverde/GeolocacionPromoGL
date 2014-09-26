package com.tracker.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;

import com.mongodb.DBObject;
import com.tracker.area.CityArea;
import com.tracker.domain.Car;

public class CarRepositoryListener extends AbstractMongoEventListener<Car>{

	@Autowired
	AreaRepository areaRepository;
	
	@Override
	public void onBeforeSave(Car source, DBObject dbo) {
	
		if(source.getArea() != null && source.getArea().getId() != null){
			dbo.put("areaId",source.getArea().getId());
			dbo.removeField("area");
		}
	}
	
	@Override
	public void onAfterConvert(DBObject dbo, Car source){
		if (dbo.get("areaId") != null){
			source.setArea((CityArea) areaRepository.findById((String) dbo.get("areaId")));
		}
	}
}
