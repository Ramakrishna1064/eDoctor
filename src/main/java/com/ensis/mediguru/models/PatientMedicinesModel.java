package com.ensis.mediguru.models;

import java.util.ArrayList;
import java.util.Date;

public class PatientMedicinesModel {

	private int physicianid;
	private int patientid;
	private int treatmentid;
	private String notes;
	private ArrayList<PatientMedicineTypeModel> medicines = new ArrayList<PatientMedicineTypeModel>();
	private Date createddate;

	public PatientMedicinesModel() {
		super();
	}

	
	
	
	/**
	 * @return the createddate
	 */
	public Date getCreateddate() {
		return createddate;
	}




	/**
	 * @param createddate the createddate to set
	 */
	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}




	public int getPhysicianid() {
		return physicianid;
	}



	public void setPhysicianid(int physicianid) {
		this.physicianid = physicianid;
	}



	public int getPatientid() {
		return patientid;
	}

	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}

	public int getTreatmentid() {
		return treatmentid;
	}

	public void setTreatmentid(int treatmentid) {
		this.treatmentid = treatmentid;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public ArrayList<PatientMedicineTypeModel> getMedicines() {
		return medicines;
	}

	public void setMedicines(ArrayList<PatientMedicineTypeModel> medicines) {
		this.medicines = medicines;
	}

}
