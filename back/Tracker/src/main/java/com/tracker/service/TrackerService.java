package com.tracker.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.data.geo.Polygon;
import org.springframework.stereotype.Service;

import com.tracker.area.Area.AreaStrategies;
import com.tracker.area.CityArea;
import com.tracker.area.FrontierArea;
import com.tracker.area.notifications.NotificationEvent;
import com.tracker.area.strategy.AreaStrategy;
import com.tracker.domain.Car;
import com.tracker.domain.Gendarme;
import com.tracker.domain.HistoryData;
import com.tracker.domain.Trackeable;
import com.tracker.domain.Truck;
import com.tracker.domain.Vehicle;
import com.tracker.repository.TrackeableRepository;

/**
 * 
 * @author matias.garcia
 *
 */
@Service
public class TrackerService {

	@Autowired 
	TrackeableRepository repository;
	
	@Resource(name ="areaStrategies")
	private Map<AreaStrategies, AreaStrategy> areaStrategies;
	
	@Resource(name ="notificationMap")
	private Map<String, NotificationEvent > map;
		
	public <CHILD extends Trackeable> CHILD save(CHILD trackeable){
		return repository.save(trackeable);
	}
	
	public void registerLocation(Trackeable registered) {
		controlEvents(repository.findById(registered.getId()), registered.getLocation());
	}

	public List<Trackeable> getAgents(Point sw, Point ne){
		

		Point se = new Point(ne.getX(), sw.getY());
		Point nw = new Point(sw.getX(), ne.getY());
		Polygon mapArea = new Polygon(nw, ne, se, sw);
		return repository.findByLocationWithin(mapArea);
	}

	private void controlEvents(Trackeable trackeable, Point newLocation) {

		NotificationEvent event = null;
		trackeable.setLocation(newLocation);
		repository.save(trackeable);
		
		if (!inArea(trackeable.getArea().getPoligono(), trackeable.getId())) {
			AreaStrategy ae = areaStrategies.get(trackeable.getArea().getAreaStrategy());
			event = map.get(trackeable.getClass().getSimpleName());
			trackeable.setInarea(Boolean.FALSE);
			event.execute(ae, trackeable);
		}else{
			trackeable.setInarea(Boolean.TRUE);
		}
		
		saveHistory(trackeable.getLocation(), trackeable, event);
	}

	private Boolean inArea(Polygon poligono, String id) {
		return repository.findByLocationWithinAndId(poligono,id) != null;
	}

	private Trackeable saveHistory(Point point, Trackeable trackeable, NotificationEvent notificationEvent) {
		HistoryData historyData = new HistoryData(point,notificationEvent);
		trackeable.getHistory().add(historyData);
		trackeable.setLocation(point);
		return repository.save(trackeable);
	}
	
	public Gendarme assignVehicle(Gendarme g, Vehicle v){
		g.setVehicle(v);
		return repository.save(g);
	}
	
	public Gendarme unassignVehicle(Gendarme g){
		g.setVehicle(null);
		return repository.save(g);
	}

	public Car assignAreaCar(Car car, CityArea area){
		car.setArea(area);
		return repository.save(car);
	}
	
	public Truck assignAreaTruck(Truck truck, FrontierArea area){
		truck.setArea(area);
		return repository.save(truck);
	}
	
	public List<Trackeable> getNotInArea(){
		return repository.findByInarea(Boolean.FALSE);
	}

	
	public List<HistoryData> getHistorial(String id){
		return repository.findById(id).getHistory();
	}

	public Vehicle getVehicle(String id) {
		return (Vehicle) repository.findById(id);
	}
}
