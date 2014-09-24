package com.tracker.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
 * TrackerController
 * 
 * @author matias.garcia
 *
 */
@Component
@Path("/abm")
public class AbmResource {

	@Autowired
	TrackerService trackerService;
	
	@Autowired
	AreaService areaService;

	@POST
	@Path("/area/{areaname}/frontier")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveArea(@PathParam("areaname") String name, List<PointWrapper> points){
        
		FrontierArea fa = new FrontierArea(name);
		List<Point> pointsArea = new ArrayList<Point>();
		for( PointWrapper p:points){
			pointsArea.add(new Point(p.getX(),p.getY()));
		}
	
		fa.setPoligono(new Polygon(pointsArea));
		return Response.ok(areaService.save(fa)).build();
	}
	
	@POST
	@Path("/area/{areaname}/city")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveAreaCity(@PathParam("areaname")String name, List<PointWrapper> points){
		
		CityArea ca = new CityArea(name);
		List<Point> pointsArea = new ArrayList<Point>();
		for( PointWrapper p:points){
			pointsArea.add(new Point(p.getX(),p.getY()));
		}
	
		ca.setPoligono(new Polygon(pointsArea));
		return Response.ok(areaService.save(ca)).build();
	}
	
	@PUT
	@Path("/agent")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveagent(Agent agent){
		return Response.ok(trackerService.save(agent)).build();
	}

	@PUT
	@Path("/vehicle")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveagent(Vehicle vehicle){
		return Response.ok(trackerService.save(vehicle)).build();
	}
	
	@PUT
	@Path("/location/{idtrackeable}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response register(@PathParam("idtrackeable")String id, PointWrapper point){
		trackerService.registerLocation(id, new Point(point.getX(), point.getY()));
		return Response.ok().build();
	}
	
	@PUT
	@Path("/agent/{idagent}/vehicle/{idvehicle}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response assignVehicle(@PathParam("idagent")String agent, @PathParam("idvehicle")String id){
		return Response.ok(trackerService.assignVehicle(trackerService.getAgent(agent), 
				trackerService.getVehicle(id))).build();
	}
	
	@PUT
	@Path("/agent/{idagent}/area/{idvehicle}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response assignAreaAgent(@PathParam("idagent")String agent, @PathParam("idvehicle")String id){
		return Response.ok(trackerService.assignAreaAgent(trackerService.getAgent(agent), 
				areaService.getArea(id))).build();
	}
	
	@PUT
	@Path("/agent/{idagent}/novehicle")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response unassignVehicle(@PathParam("idagent")String agent){
		return Response.ok(trackerService.unassignVehicle(
				trackerService.getAgent(agent))).build();
	}
	
	@PUT
	@Path("/car/{idcar}/area/{idarea}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response assignAreaCar(@PathParam("idcar") String car, @PathParam("idarea")String area ){
		return Response.ok(trackerService.assignAreaCar((Car) trackerService.getVehicle(car), 
				(CityArea) areaService.getArea(area))).build();
	}

	@PUT
	@Path("/truck/{idtruck}/area/{idarea}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response assignAreaTruck(@PathParam("idtruck") String truck, @PathParam("idarea")String area ){
		return Response.ok(trackerService.assignAreaTruck((Truck) trackerService.getVehicle(truck), 
				(FrontierArea) areaService.getArea(area))).build();
	}

}
