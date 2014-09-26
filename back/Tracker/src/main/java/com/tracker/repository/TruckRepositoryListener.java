package com.tracker.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;

import com.mongodb.DBObject;
import com.tracker.area.FrontierArea;
import com.tracker.domain.Truck;

public class TruckRepositoryListener extends AbstractMongoEventListener<Truck>{

	@Autowired
	AreaRepository areaRepository;
	
	@Override
	public void onBeforeSave(Truck source, DBObject dbo) {
	
		if(source.getArea() != null && source.getArea().getId() != null){
			dbo.put("areaId",source.getArea().getId());
			dbo.removeField("area");
		}
	}
	
	@Override
	public void onAfterConvert(DBObject dbo, Truck source){
		if (dbo.get("areaId") != null){
			source.setArea((FrontierArea) areaRepository.findById((String) dbo.get("areaId")));
		}
	}
}
