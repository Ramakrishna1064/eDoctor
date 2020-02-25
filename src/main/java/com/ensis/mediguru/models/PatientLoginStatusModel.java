/**
 * 
 */
package com.ensis.mediguru.models;

/**
 * @author Venu
 *
 */
public class PatientLoginStatusModel {

	private boolean error;
	private String message;
	private int patientid;
	private boolean isActive;

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getPatientid() {
		return patientid;
	}

	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
