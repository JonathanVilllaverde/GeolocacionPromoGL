package com.tracker.domain;

import java.util.Date;

import org.springframework.data.geo.Point;

/**
 * 
 * @author matias.garcia
 *
 */
public class HistoryData {

	private Point location;
	private Date date;
	private String notification;
	
	public HistoryData(){
		super();
	}
	
	public HistoryData(Point point, String notificationEvent) {
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
	public String getNotification() {
		return notification;
	}
	/**
	 * @param notification the notification to set
	 */
	public void setNotification(String notification) {
		this.notification = notification;
	}
	
	
}
