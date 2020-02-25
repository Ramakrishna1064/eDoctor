/**
 * 
 */
package com.ensis.mediguru.service.patient;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensis.mediguru.dao.patient.PatientMyDoctorsDAO;
import com.ensis.mediguru.dao.patient.PatientQuestionsDAO;
import com.ensis.mediguru.dao.patient.PatientSchedulesDAO;
import com.ensis.mediguru.dto.TreatmentConsultatonDTO;
import com.ensis.mediguru.models.PatientAcceptAppointmentModel;
import com.ensis.mediguru.models.PatientSchedulesModel;
import com.ensis.mediguru.models.PhysicianFavoriteAndFamilyBean;
import com.ensis.mediguru.models.StatusObject;
import com.ensis.mediguru.service.physician.PhysicianNotificationService;
import com.ensis.mediguru.utils.MessageResources;
import com.ensis.mediguru.utils.Utilities;

/**
 * @author Venu
 *
 */
@Service
public class PatientSchedulesService extends MessageResources {

	@Autowired
	PatientSchedulesDAO patientSchedulesDAO;

	@Autowired
	PatientQuestionsDAO patientQuestionsDAO;

	@Autowired
	PatientMyDoctorsDAO patientMyDoctorsDAO;

	@Autowired
	PhysicianNotificationService physicianNotificationService;

	/**
	 * @return the physicianNotificationService
	 */
	public PhysicianNotificationService getPhysicianNotificationService() {
		return physicianNotificationService;
	}

	/**
	 * @param physicianNotificationService
	 *            the physicianNotificationService to set
	 */
	public void setPhysicianNotificationService(
			PhysicianNotificationService physicianNotificationService) {
		this.physicianNotificationService = physicianNotificationService;
	}

	/**
	 * @return the patientSchedulesDAO
	 */
	public PatientSchedulesDAO getPatientSchedulesDAO() {
		return patientSchedulesDAO;
	}

	/**
	 * @return the patientQuestionsDAO
	 */
	public PatientQuestionsDAO getPatientQuestionsDAO() {
		return patientQuestionsDAO;
	}

	/**
	 * @return the patientMyDoctorsDAO
	 */
	public PatientMyDoctorsDAO getPatientMyDoctorsDAO() {
		return patientMyDoctorsDAO;
	}

	/**
	 * @param patientMyDoctorsDAO
	 *            the patientMyDoctorsDAO to set
	 */
	public void setPatientMyDoctorsDAO(PatientMyDoctorsDAO patientMyDoctorsDAO) {
		this.patientMyDoctorsDAO = patientMyDoctorsDAO;
	}

	/**
	 * @param patientQuestionsDAO
	 *            the patientQuestionsDAO to set
	 */
	public void setPatientQuestionsDAO(PatientQuestionsDAO patientQuestionsDAO) {
		this.patientQuestionsDAO = patientQuestionsDAO;
	}

	/**
	 * @param patientSchedulesDAO
	 *            the patientSchedulesDAO to set
	 */
	public void setPatientSchedulesDAO(PatientSchedulesDAO patientSchedulesDAO) {
		this.patientSchedulesDAO = patientSchedulesDAO;
	}

	/**
	 * 
	 * @param patientId
	 * @return
	 */
	@Transactional
	public ArrayList<PatientSchedulesModel> getPatientSchedules(int patientId) {

		ArrayList<PatientSchedulesModel> schedulesList = patientSchedulesDAO
				.getPatientSchedules(patientId);
		for (int i = 0; i < schedulesList.size(); i++) {
			PatientSchedulesModel patientSchedulesModel = schedulesList.get(i);
			patientSchedulesModel
					.setAppointmentDateTime(Utilities
							.convertDateFormat(patientSchedulesModel
									.getScheduledate()));
			if (patientSchedulesModel.getImageUrl() != null) {

				patientSchedulesModel.setImageUrl(getMessage("imageUrlPath")
						+ patientSchedulesModel.getImageUrl());
			}
			schedulesList.set(i, patientSchedulesModel);
		}
		return schedulesList;
	}

	/**
	 * 
	 * @param treatmentphyansid
	 * @return
	 */
	@Transactional
	public StatusObject acceptScheduleAppointment(
			PatientAcceptAppointmentModel patientAcceptAppointmentModel) {

		boolean status = patientSchedulesDAO
				.acceptScheduleAppointment(patientAcceptAppointmentModel
						.getTreatmentquestionid(),patientAcceptAppointmentModel.getPhysicianid());
		int treatmentId = patientQuestionsDAO
				.getTreatmentIdByTreatmentQuestionID(patientAcceptAppointmentModel
						.getTreatmentquestionid());
		// update the approve status in TreatmentConsultation to false
		int response = patientQuestionsDAO.updateApproveStatus(treatmentId);
		System.out.println("update respose" + response);

		StatusObject statusObject = new StatusObject();
		if (status) {

			// update the treatment question type to ongoing treatment
			patientQuestionsDAO.updateTreattmentQuestion(
					patientAcceptAppointmentModel.getTreatmentquestionid(), 2,
					patientAcceptAppointmentModel.getPhysicianid());

			// update the treatment consultation table
			int treatmentid = patientQuestionsDAO
					.getTreatmentIdByTreatmentQuestionID(patientAcceptAppointmentModel
							.getTreatmentquestionid());
			int followupcount = patientQuestionsDAO
					.checktreatmentExistinConsultationOrNot(treatmentid);

			if (followupcount > 0) {
				// update the appointment status and follow up consultation
				// count
				patientQuestionsDAO.updateTreatmentconsultation(treatmentid,
						followupcount);
			} else {
				// insert
				TreatmentConsultatonDTO consultatonDTO = new TreatmentConsultatonDTO();
				consultatonDTO.setPatientid(patientAcceptAppointmentModel
						.getPatientid());
				consultatonDTO.setTreatmentid(treatmentid);
				consultatonDTO.setPhysicianid(patientAcceptAppointmentModel
						.getPhysicianid());
				consultatonDTO.setAppointmentstatus(false);
				consultatonDTO.setCreteddate(new Date());
				consultatonDTO.setFirstconsultation(true);
				boolean respone = patientQuestionsDAO
						.insertTreatmentInconsultation(consultatonDTO);
			}

			// add the doctor to ongoing
			PhysicianFavoriteAndFamilyBean favFamily = new PhysicianFavoriteAndFamilyBean();
			favFamily.setDoctorId(patientAcceptAppointmentModel
					.getPhysicianid());
			favFamily
					.setPatientId(patientAcceptAppointmentModel.getPatientid());
			ArrayList<Integer> favType = new ArrayList<Integer>();
			favType.add(3);
			favFamily.setTypes(favType);
			patientMyDoctorsDAO.addPhysicianToFavoriteAndFamily(favFamily);

			// Send Notification to Device
			physicianNotificationService.notifyPatientAcceptedAppointment(
					patientAcceptAppointmentModel.getPatientid(),
					patientAcceptAppointmentModel.getPhysicianid(),
					patientAcceptAppointmentModel.getTreatmentquestionid());

			statusObject.setError(false);
			statusObject.setMessage(getMessage("appointment.accepted.success"));
			return statusObject;

		} else {
			statusObject.setError(true);
			statusObject.setMessage(getMessage("appointment.accepted.error"));
			return statusObject;
		}
	}
}
