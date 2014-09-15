package com.tracker.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tracker.domain.Gendarme;
import com.tracker.repository.TrackeableRepository;

/**
 * TrackerController
 * 
 * @author matias.garcia
 *
 */
@Component
@Path("/")
public class TrackerController {

	private static final Logger logger = LoggerFactory.getLogger(TrackerController.class);
	
	@Autowired 
	TrackeableRepository repository;
	
	@GET
	@Path("/test/getTrackeable")
	@Produces(MediaType.APPLICATION_JSON)
	public Response execute(){
		return Response.ok(repository.findAll()).build();
	}
	

	@GET
	@Path("/test/{value}")
	@Produces(MediaType.APPLICATION_JSON)
	public String test(@PathParam("value") String value) {
		logger.debug("value received: "+value);
		return  value;
	}
	
	@GET
	@Path("/gendarme/{value}")
	@Produces(MediaType.APPLICATION_JSON)
	public Gendarme gendarme(@PathParam("value") String value) {
		logger.debug("gendarme name received: "+value);
		Gendarme gendarme = new Gendarme();
		gendarme.setId(value);
		return  gendarme;
	}

}
