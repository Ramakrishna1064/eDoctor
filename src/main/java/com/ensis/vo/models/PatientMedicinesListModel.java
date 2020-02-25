package com.ensis.vo.models;

import java.util.ArrayList;

import com.ensis.mediguru.models.PatientMedicineTreatmentHistoryDetailModel;

public class PatientMedicinesListModel {

	private ArrayList<PatientMedicineTreatmentHistoryDetailModel> medicines = new ArrayList<PatientMedicineTreatmentHistoryDetailModel>();
	private ArrayList<PatientMedicineNotesModel> notes = new ArrayList<PatientMedicineNotesModel>();

	public PatientMedicinesListModel() {
		super();
	}

	/**
	 * @return the medicines
	 */
	public ArrayList<PatientMedicineTreatmentHistoryDetailModel> getMedicines() {
		return medicines;
	}

	/**
	 * @param medicines the medicines to set
	 */
	public void setMedicines(ArrayList<PatientMedicineTreatmentHistoryDetailModel> medicines) {
		this.medicines = medicines;
	}

	/**
	 * @return the notes
	 */
	public ArrayList<PatientMedicineNotesModel> getNotes() {
		return notes;
	}

	/**
	 * @param notes the notes to set
	 */
	public void setNotes(ArrayList<PatientMedicineNotesModel> notes) {
		this.notes = notes;
	}
}
