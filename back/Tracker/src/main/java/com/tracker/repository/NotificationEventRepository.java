package com.tracker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tracker.area.notifications.NotificationEvent;

/**
 * 
 * @author matias.garcia
 *
 */
public interface NotificationEventRepository extends MongoRepository<NotificationEvent, String> {

}
