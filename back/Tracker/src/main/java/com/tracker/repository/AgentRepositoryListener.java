package com.tracker.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;

import com.mongodb.DBObject;
import com.tracker.domain.Agent;
import com.tracker.domain.Vehicle;

public class AgentRepositoryListener extends AbstractMongoEventListener<Agent>{

	@Autowired 
	TrackeableRepository repository;
	
	@Override
	public void onBeforeSave(Agent source, DBObject dbo) {
		
		if(source.getVehicle() != null && source.getVehicle().getId() != null){
			dbo.put("vehicleId",source.getVehicle().getId());
			dbo.removeField("vehicle");
		}
	}
	
	@Override
	public void onAfterConvert(DBObject dbo, Agent source){
		if (dbo.get("vehicleId") != null){
			source.setVehicle((Vehicle) repository.findById((String) dbo.get("vehicleId")));
		}
	}
	
	
}
