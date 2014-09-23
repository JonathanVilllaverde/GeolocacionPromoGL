package com.tracker;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tracker.area.Area;
import com.tracker.area.CityArea;
import com.tracker.area.FrontierArea;
import com.tracker.domain.Car;
import com.tracker.domain.Gendarme;
import com.tracker.domain.PointWrapper;
import com.tracker.domain.PolygonWrapper;
import com.tracker.domain.Trackeable;
import com.tracker.domain.Truck;
import com.tracker.repository.TrackeableRepository;
import com.tracker.service.AreaService;
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
	AreaService areaService;
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Autowired
	TrackeableRepository repo;
	
	private FrontierArea area;
	private CityArea cityArea;
	
	
	public void setUp(){
		area = new FrontierArea();
		cityArea = new CityArea();
		
		PointWrapper x = new PointWrapper(-73.99756, 40.73083);
		PointWrapper y = new PointWrapper(-73.99756, 40.741404);
		PointWrapper z = new PointWrapper(-73.988135, 40.741404);
		PointWrapper other = new PointWrapper(-73.988135, 40.73083);
		
		PointWrapper[] others = {x,y,z};
		
		
		PolygonWrapper poligono = new PolygonWrapper(x, y, z, others);

		area.setPoligono(poligono);
//		cityArea.setPoligono(poligono);
		
	}
	
	@Test
	public void testSaveArea(){
		area = new FrontierArea();
		cityArea = new CityArea();
		
		PointWrapper x = new PointWrapper(-73.99756, 40.73083);
		PointWrapper y = new PointWrapper(-73.99756, 40.741404);
		PointWrapper z = new PointWrapper(-73.988135, 40.741404);
		
		PointWrapper[] others = {x,y,z};
		
		
		PolygonWrapper poligono = new PolygonWrapper(x, y, z, others);
		area.setPoligono(poligono);
		
		
		areaService.save(area);
	}
	
	@Test 
	public void testGetAreas(){
		List<Area> result = areaService.getAreas();
		System.out.println(result.getClass());
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
		gendarme.setLocation(new Point(-73.99756, 40.73083));

		service.save(gendarme);
	}
	
	@Test
	public void testServiceNormal(){
		Gendarme gendarme = new Gendarme();
		gendarme.setName("gendarmeNormal");
		gendarme.setLocation(new Point(-73.99756, 40.73083));

		service.save(gendarme);
	}
	
	@Test
	public void testReceivePointOfGendarme(){

		Gendarme gendarmeReceived = new Gendarme();
		gendarmeReceived.setName("gendarNormal");
		gendarmeReceived.setLocation(new Point(-2, 2));
		
		Query query = Query.query(Criteria.where("patente").is("CFG-222"));
		Truck truck = (Truck) mongoTemplate.findOne(query , Trackeable.class);

		gendarmeReceived.setVehicle(truck);
		service.registerLocation(gendarmeReceived);
	}
	

	@Test
	public void testRepo(){
		Trackeable t = repo.findById("541fd9032237f166e2624270");
		t.setLocation(new Point(-3, 3));
//		t.setLocation(new Point(-73.99756 , 40.73083));
		service.registerLocation((Gendarme) t);
		assertNotNull(t);
	}
	
	@Test
	public void testNotInArea(){

		List<Trackeable> l = service.getNotInArea();
		assertNotNull(l);
	}
	

}
