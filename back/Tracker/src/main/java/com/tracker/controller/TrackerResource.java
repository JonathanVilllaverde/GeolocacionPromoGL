package com.tracker.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.data.geo.Polygon;
import org.springframework.stereotype.Component;

import com.tracker.area.CityArea;
import com.tracker.area.FrontierArea;
import com.tracker.domain.Agent;
import com.tracker.domain.Car;
import com.tracker.domain.PointWrapper;
import com.tracker.domain.Truck;
import com.tracker.domain.Vehicle;
import com.tracker.service.AreaService;
import com.tracker.service.TrackerService;

/**
 * TrackerResource
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
	AreaService areaService;

	@GET
	@Path("/agents/latlngbounds")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAgents(@QueryParam("southwest") String southwest,@QueryParam("northeast")String northeast) throws JsonParseException, JsonMappingException, IOException {
			
		ObjectMapper mapper = new ObjectMapper();  
		PointWrapper southPoint = mapper.readValue(southwest, PointWrapper.class);  
		PointWrapper northPoint = mapper.readValue(northeast, PointWrapper.class);     

		return Response.ok(trackerService.getAgents(new Point(southPoint.getLat(), southPoint.getLng()), 
				new Point(northPoint.getLat(), northPoint.getLng()))).build();
	}

	@GET
	@Path("/agents/idle")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getNotInArea(){
		return Response.ok(trackerService.getNotInArea()).build();
	}
	
    @GET
    @Path("/agents/{id}/history")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getHistorial(@PathParam("id") String id){
	    return Response.ok(trackerService.getHistorial(id)).build();
	}

	@POST
	@Path("/agents")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveAgent(Agent agent){
		trackerService.save(agent);
		return Response.status(Status.CREATED).build();
	}
	
	@PUT
	@Path("/agents")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateAgent(Agent agent){
		return Response.ok(trackerService.update(agent)).build();
	}
	
	@DELETE
	@Path("/agents/{agentid}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("agentid") String id){
		trackerService.remove(id);
		return Response.noContent().build();
	}
	
	@PUT
	@Path("/agents/{idagent}/vehicle/{idvehicle}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response assignVehicle(@PathParam("idagent")String agent, @PathParam("idvehicle")String id){
		return Response.ok(trackerService.assignVehicle(trackerService.getAgent(agent), 
				trackerService.getVehicle(id))).build();
	}
	
	@PUT
	@Path("/agents/{idagent}/area/{idvehicle}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response assignAreaAgent(@PathParam("idagent")String agent, @PathParam("idvehicle")String id){
		return Response.ok(trackerService.assignAreaAgent(trackerService.getAgent(agent), 
				areaService.getArea(id))).build();
	}
	
	@PUT
	@Path("/agents/{idagent}/novehicle")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response unassignVehicle(@PathParam("idagent")String agent){
		return Response.ok(trackerService.unassignVehicle(
				trackerService.getAgent(agent))).build();
	}

	@PUT
	@Path("agents/location/{idtrackeable}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response register(@PathParam("idtrackeable")String id, PointWrapper point){
		trackerService.registerLocation(id, point);
		return Response.ok().build();
	}
	
	@GET
	@Path("/areas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAreas(){
		return Response.ok(areaService.getAreas()).build();
	}
    
	@POST
	@Path("/areas/{areaname}/frontier")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveArea(@PathParam("areaname") String name, List<PointWrapper> points){
        
		FrontierArea fa = new FrontierArea(name);
		List<Point> pointsArea = new ArrayList<Point>();
		for( PointWrapper p:points){
			pointsArea.add(new Point(p.getLat(),p.getLng()));
		}
	
		fa.setPoligono(new Polygon(pointsArea));
		areaService.save(fa);
		return Response.status(Status.CREATED).build();		
	}
	
	@POST
	@Path("/areas/{areaname}/city")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveAreaCity(@PathParam("areaname")String name, List<PointWrapper> points){
		
		CityArea ca = new CityArea(name);
		List<Point> pointsArea = new ArrayList<Point>();
		for( PointWrapper p:points){
			pointsArea.add(new Point(p.getLat(),p.getLng()));
		}
	
		ca.setPoligono(new Polygon(pointsArea));
		areaService.save(ca);
		return Response.status(Status.CREATED).build();	
	}
	
	@POST
	@Path("/vehicles")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveagent(Vehicle vehicle){
		trackerService.save(vehicle);
		return Response.status(Status.CREATED).build();	
	}
	
	@PUT
	@Path("vehicles/car/{idcar}/area/{idarea}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response assignAreaCar(@PathParam("idcar") String car, @PathParam("idarea")String area ){
		return Response.ok(trackerService.assignAreaCar((Car) trackerService.getVehicle(car), 
				(CityArea) areaService.getArea(area))).build();
	}

	@PUT
	@Path("vehicles/truck/{idtruck}/area/{idarea}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response assignAreaTruck(@PathParam("idtruck") String truck, @PathParam("idarea")String area ){
		return Response.ok(trackerService.assignAreaTruck((Truck) trackerService.getVehicle(truck), 
				(FrontierArea) areaService.getArea(area))).build();
	}	

}
