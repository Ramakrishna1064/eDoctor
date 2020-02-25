/**
 * 
 */
package com.ensis.mediguru.models;

import java.util.ArrayList;

/**
 * @author Venu
 *
 */
public class NotificationRootModel {

	private ArrayList<String> registration_ids;
	private String priority;
	private NotificationBodyModel notification;
	private NotificationDataModel data;
	

	/**
	 * @return the data
	 */
	public NotificationDataModel getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(NotificationDataModel data) {
		this.data = data;
	}

	/**
	 * @return the registration_ids
	 */
	public ArrayList<String> getRegistration_ids() {
		return registration_ids;
	}

	/**
	 * @param registration_ids the registration_ids to set
	 */
	public void setRegistration_ids(ArrayList<String> registration_ids) {
		this.registration_ids = registration_ids;
	}

	/**
	 * @return the priority
	 */
	public String getPriority() {
		return priority;
	}

	/**
	 * @param priority
	 *            the priority to set
	 */
	public void setPriority(String priority) {
		this.priority = priority;
	}

	/**
	 * @return the notification
	 */
	public NotificationBodyModel getNotification() {
		return notification;
	}

	/**
	 * @param notification
	 *            the notification to set
	 */
	public void setNotification(NotificationBodyModel notification) {
		this.notification = notification;
	}

}
