/**
 * 
 */
package com.ensis.mediguru.models;

import java.util.ArrayList;

/**
 * @author shyam
 *
 */
public class PatientMedicinesTreatmentHistoryModel {
	
	private int patientid;
	private int treatmentid;
	private int physicianid;
	private String notes;
	private String createddate;
	private int noteId;
	private ArrayList<PatientMedicineTreatmentHistoryDetailModel> medicines = new ArrayList<PatientMedicineTreatmentHistoryDetailModel>();

	public PatientMedicinesTreatmentHistoryModel() {
		super();
	}

	public int getNoteId() {
		return noteId;
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
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

	public int getPhysicianid() {
		return physicianid;
	}

	public void setPhysicianid(int physicianid) {
		this.physicianid = physicianid;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	public ArrayList<PatientMedicineTreatmentHistoryDetailModel> getMedicines() {
		return medicines;
	}

	public void setMedicines(ArrayList<PatientMedicineTreatmentHistoryDetailModel> medicines) {
		this.medicines = medicines;
	}

}
