package com.tracker.area.notifications;

import java.util.Date;

import com.tracker.area.strategy.AreaStrategy;
import com.tracker.domain.Trackeable;

/**
 * 
 * @author matias.garcia
 *
 */
public abstract class NotificationEvent {

	private Date date;

	
	public NotificationEvent(Date date) {
		super();
		this.date = date;
	}

	public NotificationEvent() {
		super();
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

	public abstract void execute(AreaStrategy ea, Trackeable trackeable);

}
