package com.tracker;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.data.geo.Polygon;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tracker.area.CityArea;
import com.tracker.area.FrontierArea;
import com.tracker.area.events.CriticalEventArea;
import com.tracker.area.events.NormalEventArea;
import com.tracker.domain.Car;
import com.tracker.domain.Gendarme;
import com.tracker.domain.Trackeable;
import com.tracker.domain.Truck;
import com.tracker.repository.TrackeableRepository;
import com.tracker.service.TrackerService;

/**
 * Testing dummy instance of mongodb
 * 
 * @author matias.garcia
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MongoDbTest {

	@Autowired
	TrackerService service;
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Autowired
	TrackeableRepository repo;
	
	private FrontierArea area;
	private CityArea cityArea;
	
	@Before
	public void setUp(){
		area = new FrontierArea();
		area.setEventArea(new CriticalEventArea());
		cityArea = new CityArea();
		cityArea.setEventArea(new NormalEventArea());
		
		Point x = new Point(-73.99756, 40.73083);
		Point y = new Point(-73.99756, 40.741404);
		Point z = new Point(-73.988135, 40.741404);
		Point other = new Point(-73.988135, 40.73083);
		Polygon poligono = new Polygon(x, y, z, other);

		area.setPoligono(poligono);
		cityArea.setPoligono(poligono);
	}

	@Test
	public void testSaveTruck(){
		Truck truck = new Truck();
		truck.setArea(area);
		truck.setPatente("CFG-222");
		service.save(truck);
	}
	
	@Test
	public void testSaveCar(){
		Car car = new Car();
		car.setArea(cityArea);
		car.setPatente("CFG-223");
		service.save(car);
	}
	
	@Test
	public void testServiceCritical(){
		Gendarme gendarme = new Gendarme();
		gendarme.setName("gendarmeCritical");
		gendarme.setLatLong(new Point(-73.99756, 40.73083));

		service.save(gendarme);
	}
	
	@Test
	public void testServiceNormal(){
		Gendarme gendarme = new Gendarme();
		gendarme.setName("gendarmeNormal");
		gendarme.setLatLong(new Point(-73.99756, 40.73083));

		service.save(gendarme);
	}
	
	@Test
	public void testReceivePointOfGendarme(){

		Gendarme gendarmeReceived = new Gendarme();
		gendarmeReceived.setName("gendarNormal");
		gendarmeReceived.setLatLong(new Point(-2, 2));
		
		Query query = Query.query(Criteria.where("patente").is("CFG-222"));
		Truck truck = (Truck) mongoTemplate.findOne(query , Trackeable.class);

		gendarmeReceived.setVehicle(truck);
		service.registrarCoordenada(gendarmeReceived);
	}
	
	@Test
	public void testReceivePointOfGendarmeCrit(){

		Gendarme gendarmeReceived = new Gendarme();
		gendarmeReceived.setName("gendarmeCritical");
		gendarmeReceived.setLatLong(new Point(-3, 3));
		service.registrarCoordenada(gendarmeReceived);
	}
	


}
