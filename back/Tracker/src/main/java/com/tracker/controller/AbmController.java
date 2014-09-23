package com.tracker.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
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
import com.tracker.domain.Car;
import com.tracker.domain.Gendarme;
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
public class AbmController {

	@Autowired
	TrackerService trackerService;
	
	@Autowired
	AreaService areaService;

	@POST
	@Path("/saveArea/frontier")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveArea(List<PointWrapper> points){
		FrontierArea fa = new FrontierArea();

		List<Point> pointsArea = new ArrayList<Point>();
		
		for( PointWrapper p:points){
			pointsArea.add(new Point(p.getX(),p.getY()));
		}
	
		fa.setPoligono(new Polygon(pointsArea));
		return Response.ok(areaService.save(fa)).build();
	}
	
	@POST
	@Path("/saveArea/city")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveAreaCity(List<PointWrapper> points){
		CityArea ca = new CityArea();
		List<Point> pointsArea = new ArrayList<Point>();
		
		for( PointWrapper p:points){
			pointsArea.add(new Point(p.getX(),p.getY()));
		}
	
		ca.setPoligono(new Polygon(pointsArea));
		return Response.ok(areaService.save(ca)).build();
	}
	
	@POST
	@Path("/saveGendarme")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveGendarme(Gendarme gendarme){
		return Response.ok(trackerService.save(gendarme)).build();
	}

	@POST
	@Path("/saveVehicle")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveGendarme(Vehicle vehicle){
		return Response.ok(trackerService.save(vehicle)).build();
	}
	
	@POST
	@Path("/registerLocation/{idtrackeable}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response register(@PathParam("idtrackeable")String id, PointWrapper point){
		trackerService.registerLocation(id, new Point(point.getX(), point.getY()));
		return Response.ok().build();
	}
	
	@POST
	@Path("/assignVehicle/{idvehicle}/{idgendarme}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response assignVehicle(@PathParam("idgendarme")String gendarme, @PathParam("idvehicle")String id){
		return Response.ok(trackerService.assignVehicle(trackerService.getAgent(gendarme), 
				trackerService.getVehicle(id))).build();
	}
	
	@POST
	@Path("/unassignVehicle/{idgendarme}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response unassignVehicle(@PathParam("idgendarme")String gendarme){
		return Response.ok(trackerService.unassignVehicle(
				trackerService.getAgent(gendarme))).build();
	}
	
	@POST
	@Path("/assignAreaCar/{idarea}/{idcar}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response assignAreaCar(@PathParam("idcar") String car, @PathParam("idarea")String area ){
		return Response.ok(trackerService.assignAreaCar((Car) trackerService.getVehicle(car), 
				(CityArea) areaService.getArea(area))).build();
	}

	@POST
	@Path("/assignAreaTruck/{idarea}/{idtruck}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response assignAreaTruck(@PathParam("idtruck") String truck, @PathParam("idarea")String area ){
		return Response.ok(trackerService.assignAreaTruck((Truck) trackerService.getVehicle(truck), 
				(FrontierArea) areaService.getArea(area))).build();
	}

}
