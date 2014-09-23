package com.tracker.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Component;

import com.tracker.service.AreaService;
import com.tracker.service.NotificationService;
import com.tracker.service.TrackerService;

/**
 * TrackerController
 * 
 * @author matias.garcia
 *
 */
@Component
@Path("/")
public class TrackerController {

	@Autowired
	TrackerService trackerService;
	
	@Autowired
	NotificationService notificationService;
	
	@Autowired
	AreaService areaService;
	
	@GET
	@Path("/getAgents/{swLat}/{swLong}/{neLat}/{neLong}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAgents(@PathParam("swLat") double swLat,@PathParam("swLong") double swLong,@PathParam("neLat") double neLat,@PathParam("neLong") double neLong) {
		return Response.ok(trackerService.getAgents(new Point(swLat, swLong), new Point(neLat, neLong))).build();
	}
	
	@GET
	@Path("/getNotifications")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getNotifications(){
		return Response.ok(notificationService.getNotifications()).build();
	}

	@GET
	@Path("/getAreas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAreas(){
		return Response.ok(areaService.getAreas()).build();
	}
	

//	 @GET
//	 @Path("/test/save")
//	 @Produces(MediaType.APPLICATION_JSON)
//	 public Response save(){
//	  
//	  Gendarme g = new Gendarme();
//	  g.setName("testHeroku");
//	  return Response.ok(repository.save(g)).build();
//	 }
	 
	 @GET
	 @Path("/gendarme/getHistorial/{id}")
	 @Produces(MediaType.APPLICATION_JSON)
	 public Response getHistorial(@PathParam("id") String id){
		 return Response.ok(trackerService.getHistorial(id)).build();
	 }


	@GET
	@Path("/getNotInArea")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getNotInArea(){
		return Response.ok(trackerService.getNotInArea()).build();
	}
	
}
