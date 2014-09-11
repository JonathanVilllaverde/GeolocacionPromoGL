package tracker.com.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import tracker.com.domain.Gendarme;



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
		gendarme.setName(value);
		return  gendarme;
	}

}
