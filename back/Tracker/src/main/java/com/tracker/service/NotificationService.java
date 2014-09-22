package com.tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.area.notifications.NotificationEvent;
import com.tracker.repository.NotificationEventRepository;

/**
 * 
 * @author matias.garcia
 *
 */
@Service
public class NotificationService {

	@Autowired
	NotificationEventRepository eventRepo;

	/**
	 * Persiste el evento 
	 * 
	 * @param ge
	 */
	public void saveEvent(NotificationEvent ge){
		eventRepo.save(ge);
	}
	
	/**
	 * Devuelve los NotificationEvents
	 * @return
	 */
	public List<NotificationEvent> getNotifications(){
		return eventRepo.findAll();
	}
	
}
