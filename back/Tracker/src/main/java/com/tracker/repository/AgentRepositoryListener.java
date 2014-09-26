package com.tracker.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;

import com.mongodb.DBObject;
import com.tracker.area.Area;
import com.tracker.domain.Agent;
import com.tracker.domain.Vehicle;

public class AgentRepositoryListener extends AbstractMongoEventListener<Agent>{

	@Autowired 
	TrackeableRepository repository;
	@Autowired
	AreaRepository areaRepository;
	
	@Override
	public void onBeforeSave(Agent source, DBObject dbo) {
		
		if(source.getVehicle() != null && source.getVehicle().getId() != null){
			dbo.put("vehicleId",source.getVehicle().getId());
			dbo.removeField("vehicle");
		}
		
		if(source.getArea() != null && source.getArea().getId() != null){
			dbo.put("areaId",source.getArea().getId());
			dbo.removeField("area");
		}
	}
	
	@Override
	public void onAfterConvert(DBObject dbo, Agent source){
		if (dbo.get("vehicleId") != null){
			source.setVehicle((Vehicle) repository.findById((String) dbo.get("vehicleId")));
		}
		if (dbo.get("areaId") != null){
			source.setArea((Area) areaRepository.findById((String) dbo.get("areaId")));
		}
	}
	
	
}
