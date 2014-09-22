package com.tracker.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tracker.area.Area;
import com.tracker.domain.Gendarme;
import com.tracker.domain.Vehicle;
import com.tracker.service.AreaService;
import com.tracker.service.TrackerService;

/**
 * TrackerController
 * 
 * @author matias.garcia
 *
 */
@Component
@Path("/abm")
public class AbmController {

	@Autowired
	TrackerService trackerService;
	
	@Autowired
	AreaService areaService;

	@POST
	@Path("/saveArea/{area}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveArea(@PathParam("area") Area area){
		return Response.ok(areaService.save(area)).build();
	}
	
	@POST
	@Path("/saveGendarme/{gendarme}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveGendarme(@PathParam("gendarme") Gendarme gendarme){
		return Response.ok(trackerService.save(gendarme)).build();
	}

	@POST
	@Path("/saveVehicle/{vehicle}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveGendarme(@PathParam("vehicle") Vehicle vehicle){
		return Response.ok(trackerService.save(vehicle)).build();
	}

}
