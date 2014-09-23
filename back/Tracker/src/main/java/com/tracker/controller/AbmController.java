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
import com.tracker.domain.Trackeable;
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
	@Path("/registerLocation")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response register(Trackeable trackeable){
		trackerService.registerLocation(trackeable);
		return Response.ok().build();
	}
	
	@POST
	@Path("/assignVehicle/{vehicle}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response assignVehicle(Gendarme g, @PathParam("vehicle")String id){
		return Response.ok(trackerService.assignVehicle(g, trackerService.getVehicle(id))).build();
	}
	
	@POST
	@Path("/unassignVehicle")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response unassignVehicle(Gendarme g){
		return Response.ok(trackerService.unassignVehicle(g)).build();
	}
	
	@POST
	@Path("/assignAreaCar/{area}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response assignAreaCar(Car car, @PathParam("area")String area ){
		return Response.ok(trackerService.assignAreaCar(car, (CityArea) areaService.getArea(area))).build();
	}

	@POST
	@Path("/assignAreaTruck/{area}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response assignAreaTruck(Truck truck, @PathParam("area")String area ){
		return Response.ok(trackerService.assignAreaTruck(truck, (FrontierArea) areaService.getArea(area))).build();
	}

}
