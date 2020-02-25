/**
 * 
 */
package com.ensis.mediguru.service.patient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensis.mediguru.dao.physician.PhysicianMedicinesDAO;
import com.ensis.mediguru.dto.PatientMedicalNotes;
import com.ensis.mediguru.models.GetPatientMedicinesModel;
import com.ensis.mediguru.models.GetPatientPastMedicines;
import com.ensis.mediguru.models.PatientMedicineTreatmentHistoryDetailModel;
import com.ensis.mediguru.models.PatientOngoingMedicines;
import com.ensis.mediguru.utils.Utilities;

/**
 * @author shyam
 *
 */
@Service
public class PatientMedicinesService {

	@Autowired
	PhysicianMedicinesDAO physicianMedicinesDAO;

	public void setPhysicianMedicinesDAO(
			PhysicianMedicinesDAO physicianMedicinesDAO) {
		this.physicianMedicinesDAO = physicianMedicinesDAO;
	}

	/**
	 * 
	 * @param treatmentId
	 * @param patientId
	 * @return
	 */
	/*
	 * @Transactional public PatientOngoingMedicines getOngoingMedicines(int
	 * treatmentId, int patientId) {
	 * 
	 * // main Object PatientOngoingMedicines ongoingMedicines = new
	 * PatientOngoingMedicines();
	 * 
	 * GetPatientOngoingMedicinesModel treatmentHistoryObj = new
	 * GetPatientOngoingMedicinesModel();
	 * 
	 * // Ongoing medicines ArrayList<GetPatientOngoingMedicinesModel>
	 * medicinesArray = new ArrayList<GetPatientOngoingMedicinesModel>();
	 * 
	 * ArrayList<GetPatientPastMedicines> pastMedicines = new
	 * ArrayList<GetPatientPastMedicines>();
	 * 
	 * ArrayList<PatientMedicineTreatmentHistoryDetailModel> medicinesList = new
	 * ArrayList<PatientMedicineTreatmentHistoryDetailModel>();
	 * 
	 * ArrayList<GetPatientMedicinesModel> list = physicianMedicinesDAO
	 * .getMedicines(treatmentId, 1);
	 * 
	 * Integer consultationId = physicianMedicinesDAO
	 * .getLatestMedicalConsultationId(treatmentId);
	 * 
	 * if (consultationId != null) { ArrayList<PatientMedicalNotes> dtoNotesList
	 * = physicianMedicinesDAO .getMedicineNotes(consultationId);
	 * 
	 * if (dtoNotesList != null) {
	 * 
	 * for (PatientMedicalNotes dtoObj : dtoNotesList) {
	 * 
	 * treatmentHistoryObj.setPatientid(dtoObj.getPatientid());
	 * treatmentHistoryObj.setNotes(dtoObj.getNotes());
	 * treatmentHistoryObj.setPhysicianid(dtoObj.getPhysicianid());
	 * treatmentHistoryObj.setTreatmentid(dtoObj.getTreatmentid());
	 * treatmentHistoryObj.setCreateddate("" +
	 * Utilities.convertToDateFormat(dtoObj .getCreateddate())); //
	 * notesList.add(notesObj);
	 * 
	 * ArrayList<GetPatientMedicinesModel> OngoingMedicine =
	 * physicianMedicinesDAO .getOngoingMedicines(treatmentId);
	 * 
	 * if (OngoingMedicine != null) {
	 * 
	 * for (GetPatientMedicinesModel modelObj : OngoingMedicine) {
	 * 
	 * PatientMedicineTreatmentHistoryDetailModel detailModel = new
	 * PatientMedicineTreatmentHistoryDetailModel(); ArrayList<Integer>
	 * timingsArray = new ArrayList<Integer>(); if
	 * (modelObj.getMedicinetimings() != null) {
	 * 
	 * String[] timings = modelObj .getMedicinetimings().split(","); for (int z
	 * = 0; z < timings.length; z++) {
	 * 
	 * timingsArray.add(Integer .parseInt(timings[z])); } }
	 * detailModel.setMedicinetimings(timingsArray);
	 * detailModel.setComments(modelObj.getComments());
	 * detailModel.setDosage(modelObj.getDosage());
	 * detailModel.setMedicinename(modelObj .getMedicinename());
	 * detailModel.setStartdate("" + modelObj.getStartdate());
	 * detailModel.setEnddate("" + modelObj.getEnddate());
	 * detailModel.setMedicinedatatypeid(modelObj .getMedicinedatatypeid());
	 * detailModel.setMedicinetypename(modelObj .getMedicinetypename());
	 * detailModel.setCreateddate("" + modelObj.getCreateddate());
	 * medicinesList.add(detailModel);
	 * 
	 * } } treatmentHistoryObj.setMedicines(medicinesList);
	 * medicinesArray.add(treatmentHistoryObj);
	 * ongoingMedicines.setOngoingMedicines(medicinesArray); }
	 * 
	 * } }
	 * 
	 * List<Integer> consultationIds = physicianMedicinesDAO
	 * .getPastConsultationdIds(treatmentId);
	 * 
	 * if (consultationIds != null) { for (int i = 0; i <
	 * consultationIds.size(); i++) { // get past notes
	 * ArrayList<PatientMedicalNotes> dtoNotesList = physicianMedicinesDAO
	 * .getPastMedicineNotes(consultationIds.get(i)); GetPatientPastMedicines
	 * pastmedicines = new GetPatientPastMedicines();
	 * ArrayList<PatientMedicineTreatmentHistoryDetailModel> pastMedicinesList =
	 * new ArrayList<PatientMedicineTreatmentHistoryDetailModel>();
	 * 
	 * if (dtoNotesList != null) {
	 * 
	 * for (PatientMedicalNotes dtoObj : dtoNotesList) {
	 * 
	 * System.out.println(dtoObj.getNotes());
	 * pastmedicines.setTreatmentid(dtoObj.getTreatmentid());
	 * pastmedicines.setPatientid(dtoObj.getPatientid());
	 * pastmedicines.setNotes(dtoObj.getNotes());
	 * pastmedicines.setPhysicianid(dtoObj.getPhysicianid());
	 * pastmedicines.setCreateddate("" + Utilities.convertToDateFormat(dtoObj
	 * .getCreateddate())); pastMedicines.add(pastmedicines);
	 * 
	 * // get past medicines ArrayList<GetPatientMedicinesModel>
	 * pastMedicineslist = physicianMedicinesDAO .getPastMedicines(treatmentId,
	 * consultationIds.get(i));
	 * 
	 * System.out.println("size--man" + pastMedicineslist.size()); if
	 * (pastMedicineslist != null) { PatientMedicineTreatmentHistoryDetailModel
	 * detailModel1 = new PatientMedicineTreatmentHistoryDetailModel(); for
	 * (GetPatientMedicinesModel modelObj : pastMedicineslist) {
	 * 
	 * ArrayList<Integer> timingsArray = new ArrayList<Integer>(); if
	 * (modelObj.getMedicinetimings() != null) {
	 * 
	 * String[] timings = modelObj .getMedicinetimings().split(","); for (int z
	 * = 0; z < timings.length; z++) {
	 * 
	 * timingsArray.add(Integer .parseInt(timings[z])); } }
	 * detailModel1.setMedicinetimings(timingsArray); detailModel1
	 * .setComments(modelObj.getComments());
	 * detailModel1.setDosage(modelObj.getDosage());
	 * detailModel1.setMedicinename(modelObj .getMedicinename());
	 * detailModel1.setStartdate("" + modelObj.getStartdate());
	 * detailModel1.setEnddate("" + modelObj.getEnddate());
	 * detailModel1.setMedicinedatatypeid(modelObj .getMedicinedatatypeid());
	 * detailModel1.setMedicinetypename(modelObj .getMedicinetypename());
	 * detailModel1.setCreateddate("" + modelObj.getCreateddate());
	 * pastMedicinesList.add(detailModel1);
	 * 
	 * }
	 * 
	 * }
	 * 
	 * }
	 * 
	 * }
	 * 
	 * pastmedicines.setMedicines(pastMedicinesList);
	 * 
	 * ongoingMedicines.setPastMedicines(pastMedicines); } }
	 * 
	 * return ongoingMedicines;
	 * 
	 * }
	 */

	@Transactional
	public PatientOngoingMedicines getOngoingMedicines(int treatmentId,
			int patientId) {

		PatientOngoingMedicines allMedicinesObj = new PatientOngoingMedicines();
		ArrayList<GetPatientPastMedicines> ongoingMedicinesList = new ArrayList<GetPatientPastMedicines>();
		ArrayList<GetPatientPastMedicines> pastMedicinesList = new ArrayList<GetPatientPastMedicines>();

		ArrayList<GetPatientPastMedicines> getMedicinesList = getMedicinesList(treatmentId);
		
		System.out.println("--bam------>"+getMedicinesList.size());
		Collections.sort(getMedicinesList,Utilities.sortByConsultationId);
	
		for(int i=0;i<getMedicinesList.size();i++){
			
			if(i== 0){
				ongoingMedicinesList.add(getMedicinesList.get(i));
			}else{
				pastMedicinesList.add(getMedicinesList.get(i));
			}
		}
		
		allMedicinesObj.setOngoingMedicines(ongoingMedicinesList);
		allMedicinesObj.setPastMedicines(pastMedicinesList);

		return allMedicinesObj;
	}

	/**
	 * 
	 * @param treatmentId
	 * @return
	 */
	@Transactional
	public ArrayList<GetPatientPastMedicines> getMedicinesList(int treatmentId) {

		ArrayList<GetPatientPastMedicines> medicinesList = new ArrayList<GetPatientPastMedicines>();
		try {

			ArrayList<GetPatientMedicinesModel> mainMedicinesList = physicianMedicinesDAO
					.getPatientMedicines(treatmentId);
			if (mainMedicinesList != null) {

				for (GetPatientMedicinesModel modelObj : mainMedicinesList) {

					GetPatientPastMedicines rootObj = new GetPatientPastMedicines();
					if (modelObj != null) {

						rootObj.setCreateddate("" + modelObj.getCreateddate());
						rootObj.setNotes(modelObj.getNotes());
						if(modelObj.getConsultationid() != null){
							rootObj.setConsultationid(modelObj.getConsultationid());
						}
						
						if(modelObj.getPatientid() != null){
							rootObj.setPatientid(modelObj.getPatientid());
						}
						
						if(modelObj.getPhysicianid() != null){
							rootObj.setPhysicianid(modelObj.getPhysicianid());
						}
						
						
						rootObj.setTreatmentid(modelObj.getTreatmentid());
						ArrayList<PatientMedicineTreatmentHistoryDetailModel> consultationMedicines = new ArrayList<PatientMedicineTreatmentHistoryDetailModel>();

						if (medicinesList.size() == 0) {

							if (modelObj.getPatientmedicaldataid() != null) {

								consultationMedicines.add(constructMedicinesData(modelObj));
							}
							rootObj.setMedicines(consultationMedicines);
							medicinesList.add(rootObj);

						} else {

							boolean isAdded = false;
							int previosPosition = 0;
							GetPatientPastMedicines previousObj = new GetPatientPastMedicines();
							for (int j = 0; j < medicinesList.size(); j++) {

								if (medicinesList.get(j).getConsultationid() == modelObj
										.getConsultationid()) {

									isAdded = true;
									previosPosition = j;
									previousObj = medicinesList.get(j);
									if (medicinesList.get(j).getMedicines()
											.size() > 0) {
										
										
										consultationMedicines
												.addAll(medicinesList.get(j)
														.getMedicines());
									}
								}
							}

							if (!isAdded) {

								if (modelObj.getPatientmedicaldataid() != null) {
									consultationMedicines.add(constructMedicinesData(modelObj));
								}
								rootObj.setMedicines(consultationMedicines);
								medicinesList.add(rootObj);
							} else {

								if (modelObj.getPatientmedicaldataid() != null) {
									consultationMedicines.add(constructMedicinesData(modelObj));
								}
								previousObj.setMedicines(consultationMedicines);
								medicinesList.set(previosPosition, previousObj);
							}
						}
					}
				}
				return medicinesList;

			} else {
				return medicinesList;
			}

		} catch (Throwable t) {
			t.printStackTrace();
		}

		return medicinesList;

	}

	/**
	 * 
	 * @param modelObj
	 */
	public PatientMedicineTreatmentHistoryDetailModel constructMedicinesData(
			GetPatientMedicinesModel modelObj) {

		PatientMedicineTreatmentHistoryDetailModel medicalDataModel = new PatientMedicineTreatmentHistoryDetailModel();
		medicalDataModel.setPatientmedicaldataid(modelObj
				.getPatientmedicaldataid());
		medicalDataModel.setComments(modelObj.getComments());
		medicalDataModel.setCreateddate("" + modelObj.getCreateddate());
		medicalDataModel.setStartdate("" + modelObj.getStartdate());
		medicalDataModel.setEnddate("" + modelObj.getEnddate());
		medicalDataModel.setDosage(modelObj.getDosage());
		medicalDataModel
				.setMedicinedatatypeid(modelObj.getMedicinedatatypeid());
		medicalDataModel.setMedicinename(modelObj.getMedicinename());
		medicalDataModel.setMedicinetypename(modelObj.getMedicinetypename());
		ArrayList<Integer> timingsArray = new ArrayList<Integer>();
		if (modelObj.getMedicinetimings() != null) {

			String[] timings = modelObj.getMedicinetimings().split(",");
			for (int z = 0; z < timings.length; z++) {

				timingsArray.add(Integer.parseInt(timings[z]));
			}
		}
		medicalDataModel.setMedicinetimings(timingsArray);
		return medicalDataModel;
	}

	/**
	 * 
	 * @param treatmentId
	 * @param patientId
	 * @return
	 */
	@Transactional
	public ArrayList<GetPatientPastMedicines> getPatientMedicineTreatmentHistory(
			int treatmentId) {

		ArrayList<GetPatientPastMedicines> pastMedicines = new ArrayList<GetPatientPastMedicines>();

		List<Integer> consultationIds = physicianMedicinesDAO
				.getTreatmentConsultationdIds(treatmentId);

		if (consultationIds != null) {
			for (int i = 0; i < consultationIds.size(); i++) {
				System.out.println(consultationIds.get(i));

				ArrayList<PatientMedicalNotes> dtoNotesList = physicianMedicinesDAO
						.getPastMedicineNotes(consultationIds.get(i));
				GetPatientPastMedicines pastmedicines = new GetPatientPastMedicines();
				ArrayList<PatientMedicineTreatmentHistoryDetailModel> pastMedicinesList = new ArrayList<PatientMedicineTreatmentHistoryDetailModel>();

				if (dtoNotesList != null) {

					for (PatientMedicalNotes dtoObj : dtoNotesList) {

						pastmedicines.setTreatmentid(dtoObj.getTreatmentid());
						pastmedicines.setPatientid(dtoObj.getPatientid());
						pastmedicines.setNotes(dtoObj.getNotes());
						pastmedicines.setPhysicianid(dtoObj.getPhysicianid());
						pastmedicines.setCreateddate(""
								+ Utilities.convertToDateFormat(dtoObj
										.getCreateddate()));
						pastMedicines.add(pastmedicines);

						// get past medicines
						ArrayList<GetPatientMedicinesModel> pastMedicineslist = physicianMedicinesDAO
								.getPastMedicines(treatmentId,
										consultationIds.get(i));
						if (pastMedicineslist != null) {
							PatientMedicineTreatmentHistoryDetailModel detailModel1 = new PatientMedicineTreatmentHistoryDetailModel();
							for (GetPatientMedicinesModel modelObj : pastMedicineslist) {

								ArrayList<Integer> timingsArray = new ArrayList<Integer>();
								if (modelObj.getMedicinetimings() != null) {

									String[] timings = modelObj
											.getMedicinetimings().split(",");
									for (int z = 0; z < timings.length; z++) {

										timingsArray.add(Integer
												.parseInt(timings[z]));
									}
								}
								detailModel1.setMedicinetimings(timingsArray);
								detailModel1
										.setComments(modelObj.getComments());
								detailModel1.setDosage(modelObj.getDosage());
								detailModel1.setMedicinename(modelObj
										.getMedicinename());
								detailModel1.setStartdate(""
										+ modelObj.getStartdate());
								detailModel1.setEnddate(""
										+ modelObj.getEnddate());
								detailModel1.setMedicinedatatypeid(modelObj
										.getMedicinedatatypeid());
								detailModel1.setMedicinetypename(modelObj
										.getMedicinetypename());
								detailModel1.setCreateddate(""
										+ modelObj.getCreateddate());
								pastMedicinesList.add(detailModel1);

							}

						}

					}

				}
				pastmedicines.setMedicines(pastMedicinesList);

			}

		}

		/*
		 * if (list != null) {
		 * 
		 * for (GetPatientMedicinesModel modelObj : list) {
		 * 
		 * PatientMedicineTreatmentHistoryDetailModel detailModel = new
		 * PatientMedicineTreatmentHistoryDetailModel(); ArrayList<Integer>
		 * timingsArray = new ArrayList<Integer>(); if
		 * (modelObj.getMedicinetimings() != null) {
		 * 
		 * String[] timings = modelObj.getMedicinetimings().split(","); for (int
		 * z = 0; z < timings.length; z++) {
		 * 
		 * timingsArray.add(Integer.parseInt(timings[z])); } }
		 * detailModel.setMedicinetimings(timingsArray);
		 * detailModel.setComments(modelObj.getComments());
		 * detailModel.setDosage(modelObj.getDosage());
		 * detailModel.setMedicinename(modelObj.getMedicinename());
		 * detailModel.setStartdate("" + modelObj.getStartdate());
		 * detailModel.setEnddate("" + modelObj.getEnddate());
		 * detailModel.setMedicinedatatypeid(modelObj .getMedicinedatatypeid());
		 * detailModel.setMedicinetypename(modelObj.getMedicinetypename());
		 * detailModel.setCreateddate("" + modelObj.getCreateddate());
		 * medicinesList.add(detailModel);
		 * 
		 * } } treatmentHistoryObj.setMedicines(medicinesList);
		 * 
		 * // Notes here ArrayList<PatientMedicineNotesModel> notesList = new
		 * ArrayList<PatientMedicineNotesModel>();
		 * 
		 * ArrayList<PatientMedicalNotes> dtoNotesList = physicianMedicinesDAO
		 * .getMedicineNotes(treatmentId); if (dtoNotesList != null) {
		 * 
		 * for (PatientMedicalNotes dtoObj : dtoNotesList) {
		 * 
		 * PatientMedicineNotesModel notesObj = new PatientMedicineNotesModel();
		 * notesObj.setNoteId(dtoObj.getNoteid());
		 * notesObj.setNotes(dtoObj.getNotes()); notesObj.setCreateddate("" +
		 * dtoObj.getCreateddate()); notesList.add(notesObj); } } // add Notes
		 * to main Obj treatmentHistoryObj.setNotes(notesList);
		 */
		return pastMedicines;
	}

}
