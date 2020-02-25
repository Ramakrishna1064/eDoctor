/**
 * 
 */
package com.ensis.mediguru.models;

import java.util.ArrayList;

/**
 * @author shyam
 *
 */
public class PatientMedicineTypeModel {

	private int medicinedatatypeid;
	private ArrayList<Integer> medicinetimings;
	private String medicinename;
	private int dosage;
	private String startdate;
	private String enddate;
	private String notes;

	public PatientMedicineTypeModel() {
		super();
	}

	public int getMedicinedatatypeid() {
		return medicinedatatypeid;
	}

	public void setMedicinedatatypeid(int medicinedatatypeid) {
		this.medicinedatatypeid = medicinedatatypeid;
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

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
