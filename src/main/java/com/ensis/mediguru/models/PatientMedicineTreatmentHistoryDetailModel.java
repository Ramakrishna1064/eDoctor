/**
 * 
 */
package com.ensis.mediguru.models;

import java.util.ArrayList;

/**
 * @author shyam
 *
 */
public class PatientMedicineTreatmentHistoryDetailModel {

	private int medicinedatatypeid;
	private String medicinetypename;
	private int patientmedicaldataid;
	private ArrayList<Integer> medicinetimings;
	private String medicinename;
	private int dosage;
	private String startdate;
	private String enddate;
	private String comments;
	private String createddate;
	
	

	public PatientMedicineTreatmentHistoryDetailModel() {
		super();
	}

	
	
	/**
	 * @return the patientmedicaldataid
	 */
	public int getPatientmedicaldataid() {
		return patientmedicaldataid;
	}



	/**
	 * @param patientmedicaldataid the patientmedicaldataid to set
	 */
	public void setPatientmedicaldataid(int patientmedicaldataid) {
		this.patientmedicaldataid = patientmedicaldataid;
	}



	/**
	 * @return the createddate
	 */
	public String getCreateddate() {
		return createddate;
	}

	/**
	 * @param createddate the createddate to set
	 */
	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	public int getMedicinedatatypeid() {
		return medicinedatatypeid;
	}

	public void setMedicinedatatypeid(int medicinedatatypeid) {
		this.medicinedatatypeid = medicinedatatypeid;
	}

	public String getMedicinetypename() {
		return medicinetypename;
	}

	public void setMedicinetypename(String medicinetypename) {
		this.medicinetypename = medicinetypename;
	}

	public ArrayList<Integer> getMedicinetimings() {
		return medicinetimings;
	}

	public void setMedicinetimings(ArrayList<Integer> medicinetimings) {
		this.medicinetimings = medicinetimings;
	}

	public String getMedicinename() {
		return medicinename;
	}

	public void setMedicinename(String medicinename) {
		this.medicinename = medicinename;
	}

	public int getDosage() {
		return dosage;
	}

	public void setDosage(int dosage) {
		this.dosage = dosage;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
