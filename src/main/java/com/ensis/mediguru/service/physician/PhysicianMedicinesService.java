package com.ensis.mediguru.service.physician;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensis.mediguru.dao.physician.PhysicianMedicinesDAO;
import com.ensis.mediguru.dto.PatientMedicalData;
import com.ensis.mediguru.dto.PatientMedicalNotes;
import com.ensis.mediguru.dto.PatientMedicineTimings;
import com.ensis.mediguru.dto.TreatmentConsultatonDTO;
import com.ensis.mediguru.models.PatientMedicineTypeModel;
import com.ensis.mediguru.models.PatientMedicinesModel;
import com.ensis.mediguru.models.StatusObject;
import com.ensis.mediguru.models.UpdatePatientMedicine;
import com.ensis.mediguru.utils.MessageResources;
import com.ensis.mediguru.utils.Utilities;

@Service
public class PhysicianMedicinesService extends MessageResources {

	@Autowired
	PhysicianMedicinesDAO physicianMedicinesDAO;

	public void setPhysicianMedicinesDAO(
			PhysicianMedicinesDAO physicianMedicinesDAO) {
		this.physicianMedicinesDAO = physicianMedicinesDAO;
	}

	/**
	 * 
	 * @param patientMedicinesModel
	 * @return
	 */
	@Transactional
	public StatusObject addPatientMedicines(
			PatientMedicinesModel patientMedicinesModel) {

		boolean response = false;
		int medicaldataId = 0, noteId = 0;
		int consultationId = 0;

		// Step1: Create the Medical Notes
		// DTO Object

		// check patient consult physician first time or not
		Boolean firsttime = physicianMedicinesDAO
				.checkConsultPhysicianFirstTime(patientMedicinesModel
						.getTreatmentid());

		Boolean approveStatus = physicianMedicinesDAO
				.getApproveStatus(patientMedicinesModel.getTreatmentid());

		// update the approve status

		physicianMedicinesDAO.updateApproveStatus(patientMedicinesModel
				.getTreatmentid());

		if (!approveStatus) {

			// Add Patient Details to Consultation table
			TreatmentConsultatonDTO treatmentConsultatonDTO = new TreatmentConsultatonDTO();
			treatmentConsultatonDTO.setTreatmentid(patientMedicinesModel
					.getTreatmentid());
			treatmentConsultatonDTO.setPatientid(patientMedicinesModel
					.getPatientid());
			treatmentConsultatonDTO.setPhysicianid(patientMedicinesModel
					.getPhysicianid());
			treatmentConsultatonDTO.setAppointmentstatus(true);
			treatmentConsultatonDTO.setFirstconsultation(true);
			treatmentConsultatonDTO.setFollowupconsultationcount(1);
			treatmentConsultatonDTO.setCreteddate(new Date());
			consultationId = physicianMedicinesDAO
					.addPatientConsultaion(treatmentConsultatonDTO);
			System.out.println("consultationId---" + consultationId);

			if (patientMedicinesModel.getNotes() != null
					&& !(patientMedicinesModel.getNotes().equalsIgnoreCase(""))) {

				System.out.println("consultationId--------" + consultationId);
				PatientMedicalNotes patientMedicalNotes = new PatientMedicalNotes();
				patientMedicalNotes.setTreatmentid(patientMedicinesModel
						.getTreatmentid());
				patientMedicalNotes.setPatientid(patientMedicinesModel
						.getPatientid());
				patientMedicalNotes.setPhysicianid(patientMedicinesModel
						.getPhysicianid());
				patientMedicalNotes.setNotes(patientMedicinesModel.getNotes());
				patientMedicalNotes.setCreatedby(""
						+ patientMedicinesModel.getPhysicianid());
				patientMedicalNotes.setConsultationid(consultationId);
				patientMedicalNotes.setCreateddate(new Date());
				noteId = physicianMedicinesDAO
						.addPatientMedicineNotes(patientMedicalNotes);
				if (noteId > 0) {
					response = true;
				}
			}

			// Step2: Create the Medical Data
			ArrayList<PatientMedicineTypeModel> medicineTypesList = patientMedicinesModel
					.getMedicines();
			if (medicineTypesList != null) {

				for (PatientMedicineTypeModel medicineTypeModel : medicineTypesList) {

					PatientMedicalData patientMedicine = new PatientMedicalData();
					patientMedicine.setMedicinedatatypeid(medicineTypeModel
							.getMedicinedatatypeid());
					patientMedicine.setTreatmentid(patientMedicinesModel
							.getTreatmentid());
					patientMedicine.setPatientid(patientMedicinesModel
							.getPatientid());
					patientMedicine.setPhysicianid(patientMedicinesModel
							.getPhysicianid());
					patientMedicine.setMedicinename(medicineTypeModel
							.getMedicinename());
					patientMedicine.setDosage(medicineTypeModel.getDosage());
					patientMedicine.setConsultationid(consultationId);
					patientMedicine.setStartdate(Utilities
							.getMedicineDateFormat(medicineTypeModel
									.getStartdate()));
					patientMedicine.setEnddate(Utilities
							.getMedicineDateFormat(medicineTypeModel
									.getEnddate()));
					patientMedicine.setComments(medicineTypeModel.getNotes());
					patientMedicine.setCreatedby(""
							+ patientMedicinesModel.getPhysicianid());
					patientMedicine.setCreateddate(new Date());

					medicaldataId = physicianMedicinesDAO
							.addPatientMedicines(patientMedicine);
					if (medicaldataId > 1) {
						// Step3: Create the Medicine Timings
						response = physicianMedicinesDAO
								.addPatientMedicineTimings(medicineTypeModel,
										medicaldataId);
					}
				}
			}

			StatusObject statusObject = new StatusObject();
			if (medicaldataId > 1 || noteId > 1 && response) {

				if (response) {
					statusObject.setError(false);
					statusObject
							.setMessage(getMessage("physician.add.patient.medicines.success.message"));
					return statusObject;
				} else {
					statusObject.setError(true);
					statusObject
							.setMessage(getMessage("physician.add.patient.medicines.failure.message"));
					return statusObject;
				}

			} else {
				statusObject.setError(true);
				statusObject
						.setMessage(getMessage("physician.add.patient.medicines.failure.message"));
				return statusObject;
			}
		} else {// if already medicines added to this treatment
			StatusObject statusObject = new StatusObject();
			statusObject.setError(true);
			statusObject
					.setMessage(getMessage("physician.treatment.medicines.already.added"));
			return statusObject;

		}
	}

	/**
	 * 
	 * @param patientMedicalData
	 * @return
	 */
	@Transactional
	public StatusObject updatePatientMedicines(
			UpdatePatientMedicine updatePatientMedicine) {
		StatusObject statusObject = new StatusObject();

		int patientmedicialdataid = updatePatientMedicine
				.getPatientmedicaldataid();
		int response = physicianMedicinesDAO.updatePatientMedicicnes(
				updatePatientMedicine, patientmedicialdataid);
		ArrayList<PatientMedicineTimings> medicineTimings = physicianMedicinesDAO
				.getPatientMedicicneTimings(patientmedicialdataid);
		ArrayList<Integer> newMedicineTimings = new ArrayList<Integer>();
		ArrayList<PatientMedicineTimings> deletedTimings = new ArrayList<PatientMedicineTimings>();
		for (int i = 0; i < medicineTimings.size(); i++) {

			PatientMedicineTimings availTimingsModel = medicineTimings.get(i);
			boolean isSameTimingId = false;
			for (int j = 0; j < updatePatientMedicine.getMedicinetimings()
					.size(); j++) {

				Integer langId = updatePatientMedicine.getMedicinetimings()
						.get(j);
				if (langId == availTimingsModel.getMedicinetimingsid()) {
					isSameTimingId = true;
				}
			}

			if (!isSameTimingId) {
				deletedTimings.add(availTimingsModel);
			}
		}

		for (int k = 0; k < deletedTimings.size(); k++) {

			PatientMedicineTimings deletedModel = deletedTimings.get(k);
			physicianMedicinesDAO.deleteMedicineTimings(deletedModel);

		}

		for (int i = 0; i < updatePatientMedicine.getMedicinetimings().size(); i++) {

			Integer timingId = updatePatientMedicine.getMedicinetimings()
					.get(i);
			boolean isSameLangId = false;
			for (int j = 0; j < medicineTimings.size(); j++) {

				if (timingId == medicineTimings.get(j).getMedicinetimingsid()) {
					isSameLangId = true;
				}
			}
			if (!isSameLangId) {
				newMedicineTimings.add(timingId);
			}
		}

		for (int l = 0; l < newMedicineTimings.size(); l++) {

			physicianMedicinesDAO.createOrUpdateMedicineTimings(
					updatePatientMedicine.getPatientid(),
					updatePatientMedicine.getPatientmedicaldataid(),
					newMedicineTimings.get(l));
		}

		if (response == 1) {

			statusObject.setError(false);
			statusObject
					.setMessage(getMessage("physician.update.patient.medicine.success.message"));
			return statusObject;

		}

		else {
			statusObject.setError(true);
			statusObject
					.setMessage(getMessage("physician.update.patient.medicine.failure.message"));
			return statusObject;

		}

	}

	/**
	 * 
	 * @param updatePatientMedicine
	 * @return
	 */
	@Transactional
	public StatusObject deletePatientMedicine(
			UpdatePatientMedicine updatePatientMedicine) {
		StatusObject obj = new StatusObject();

		int patientmedicaldataid = updatePatientMedicine
				.getPatientmedicaldataid();
		int respone = physicianMedicinesDAO
				.deletePatientMedicine(patientmedicaldataid);
		if (respone == 1) {
			obj.setError(false);
			obj.setMessage(getMessage("physician.delete.patient.medicine.success.message"));

		} else {
			obj.setError(true);
			obj.setMessage(getMessage("physician.delete.patient.medicine.failure.message"));

		}
		return null;
	}

}
