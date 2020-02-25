/**
 * 
 */
package com.ensis.mediguru.models;

/**
 * @author Venu
 *
 */
public class PhysicianNotificationModel {

	private int physicianId;
	private int deviceType;
	private String deviceId;
	private String gcmId;
	private boolean notificationEnabled;

	/**
	 * @return the physicianId
	 */
	public int getPhysicianId() {
		return physicianId;
	}

	/**
	 * @param physicianId
	 *            the physicianId to set
	 */
	public void setPhysicianId(int physicianId) {
		this.physicianId = physicianId;
	}

	/**
	 * @return the deviceType
	 */
	public int getDeviceType() {
		return deviceType;
	}

	/**
	 * @param deviceType
	 *            the deviceType to set
	 */
	public void setDeviceType(int deviceType) {
		this.deviceType = deviceType;
	}

	/**
	 * @return the deviceId
	 */
	public String getDeviceId() {
		return deviceId;
	}

	/**
	 * @param deviceId
	 *            the deviceId to set
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	/**
	 * @return the gcmId
	 */
	public String getGcmId() {
		return gcmId;
	}

	/**
	 * @param gcmId
	 *            the gcmId to set
	 */
	public void setGcmId(String gcmId) {
		this.gcmId = gcmId;
	}

	/**
	 * @return the notificationEnabled
	 */
	public boolean isNotificationEnabled() {
		return notificationEnabled;
	}

	/**
	 * @param notificationEnabled
	 *            the notificationEnabled to set
	 */
	public void setNotificationEnabled(boolean notificationEnabled) {
		this.notificationEnabled = notificationEnabled;
	}
}
