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
public class TrackerResource {

	@Autowired
	TrackerService trackerService;
	
	@Autowired
	NotificationService notificationService;
	
	@Autowired
	AreaService areaService;
	
	@GET
	@Path("/agents/swlat/{swLat}/swlong/{swLong}/nelat/{neLat}/nelong/{neLong}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAgents(@PathParam("swLat") double swLat,@PathParam("swLong") double swLong,@PathParam("neLat") double neLat,@PathParam("neLong") double neLong) {
		return Response.ok(trackerService.getAgents(new Point(swLat, swLong), new Point(neLat, neLong))).build();
	}

	@GET
	@Path("/agents/notinarea")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getNotInArea(){
		return Response.ok(trackerService.getNotInArea()).build();
	}
	
	@GET
	@Path("/notifications")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getNotifications(){
		return Response.ok(notificationService.getNotifications()).build();
	}

	@GET
	@Path("/areas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAreas(){
		return Response.ok(areaService.getAreas()).build();
	}
	 
    @GET
    @Path("/agent/{id}/history")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getHistorial(@PathParam("id") String id){
	    return Response.ok(trackerService.getHistorial(id)).build();
	}
	
}
