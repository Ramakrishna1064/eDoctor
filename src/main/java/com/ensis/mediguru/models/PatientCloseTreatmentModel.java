/**
 * 
 */
package com.ensis.mediguru.models;

/**
 * @author Ensis
 *
 */
public class PatientCloseTreatmentModel {
	
	private int treatmentid;
	private int patientid;
	private int physicianid;
	private String title;
	private String comment;
	private double rating;
	
	
	public int getPhysicianid() {
		return physicianid;
	}
	public void setPhysicianid(int physicianid) {
		this.physicianid = physicianid;
	}
	public int getTreatmentid() {
		return treatmentid;
	}
	public void setTreatmentid(int treatmentid) {
		this.treatmentid = treatmentid;
	}
	public int getPatientid() {
		return patientid;
	}
	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	
}
