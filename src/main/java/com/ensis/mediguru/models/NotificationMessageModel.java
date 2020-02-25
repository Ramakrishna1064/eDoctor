package com.ensis.mediguru.models;

public class NotificationMessageModel {

	private String message;
	private int id;
	private String roomUrl;
	private int patientid;
	private int physicianid;
	
	
	
	
	
	/**
	 * @return the patientid
	 */
	public int getPatientid() {
		return patientid;
	}

	/**
	 * @param patientid the patientid to set
	 */
	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}

	/**
	 * @return the physicianid
	 */
	public int getPhysicianid() {
		return physicianid;
	}

	/**
	 * @param physicianid the physicianid to set
	 */
	public void setPhysicianid(int physicianid) {
		this.physicianid = physicianid;
	}

	public NotificationMessageModel() {
		super();
	}
	
	/**
	 * @return the roomUrl
	 */
	public String getRoomUrl() {
		return roomUrl;
	}
	/**
	 * @param roomUrl the roomUrl to set
	 */
	public void setRoomUrl(String roomUrl) {
		this.roomUrl = roomUrl;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}	
	
}
