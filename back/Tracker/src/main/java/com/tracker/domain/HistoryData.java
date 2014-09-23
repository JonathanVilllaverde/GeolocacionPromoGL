package com.tracker.domain;

import java.util.Date;

import org.springframework.data.geo.Point;

import com.tracker.area.notifications.NotificationEvent;

/**
 * 
 * @author matias.garcia
 *
 */
public class HistoryData {

	private Point location;
	private Date date;
	private NotificationEvent notification;
	
	public HistoryData(Point point, NotificationEvent notificationEvent) {
		super();
		this.location = point;
		this.notification = notificationEvent;
		this.date = new Date();
	}
	/**
	 * @return the location
	 */
	public Point getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(Point location) {
		this.location = location;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the notification
	 */
	public NotificationEvent getNotification() {
		return notification;
	}
	/**
	 * @param notification the notification to set
	 */
	public void setNotification(NotificationEvent notification) {
		this.notification = notification;
	}
	
	
}
