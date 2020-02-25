/**
 * 
 */
package com.ensis.mediguru.service.patient;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensis.mediguru.dao.common.CommonDAO;
import com.ensis.mediguru.dto.DoctorRegistration;
import com.ensis.mediguru.dto.PatientRegistration;
import com.ensis.mediguru.dto.UserNotificationDTO;
import com.ensis.mediguru.models.NotificationVideoCallRequestModel;
import com.ensis.mediguru.models.PatientNotificationModel;
import com.ensis.mediguru.models.StatusObject;
import com.ensis.mediguru.service.common.NotifcationService;
import com.ensis.mediguru.utils.MessageResources;

/**
 * @author Venu
 *
 */
@Service
public class PatientNotificationService extends MessageResources {

	@Autowired
	NotifcationService notifcationService;

	@Autowired
	CommonDAO commonDAO;

	/**
	 * @param commonDAO
	 *            the commonDAO to set
	 */
	public void setCommonDAO(CommonDAO commonDAO) {
		this.commonDAO = commonDAO;
	}

	/**
	 * @param notifcationService
	 *            the notifcationService to set
	 */
	public void setNotifcationService(NotifcationService notifcationService) {
		this.notifcationService = notifcationService;
	}

	
	
	@Transactional
	public StatusObject registerPatientDevice(PatientNotificationModel patientNotificationModel) {

		StatusObject statusObject = new StatusObject();
		if (patientNotificationModel != null) {

			int userId = commonDAO.getPatientUserId(patientNotificationModel.getPatientId());
			if (userId > 0) {

				if(patientNotificationModel.getGcmId() != null){
					
					UserNotificationDTO userNotificationDTO = new UserNotificationDTO();
					userNotificationDTO.setUserId(userId);
					userNotificationDTO.setDeviceId(patientNotificationModel.getDeviceId());
					userNotificationDTO.setDeviceType(patientNotificationModel.getDeviceType());
					userNotificationDTO.setGcmId(patientNotificationModel.getGcmId());
					userNotificationDTO.setNotificationenable(true);
					userNotificationDTO.setCreatedby("Patient");
					userNotificationDTO.setCreateddate(new Date());
					boolean status = commonDAO.saveUserNotificationObj(userNotificationDTO);

					if (status) {
						statusObject.setError(false);
						statusObject.setMessage(getMessage("device.registration.success"));
						return statusObject;
					} else {
						statusObject.setError(true);
						statusObject.setMessage(getMessage("device.registration.error"));
						return statusObject;
					}
				}else{
					statusObject.setError(true);
					statusObject.setMessage(getMessage("device.registration.error"));
					return statusObject;
				}
				
			
			} else {
				statusObject.setError(true);
				statusObject.setMessage(getMessage("device.registration.error"));
				return statusObject;
			}
		} else {
			statusObject.setError(true);
			statusObject.setMessage(getMessage("device.registration.error"));
			return statusObject;
		}
	}

	/**
	 * 
	 * @param patientId
	 * @param physicianId
	 * @param treatmentQuestionId
	 */
	@Transactional
	public void notifytoPatientAsPhysicianSentAppointment(int patientId, int physicianId, int treatmentQuestionId) {

		try {
			int userId = commonDAO.getPatientUserId(patientId);
			ArrayList<UserNotificationDTO> devicesList = commonDAO.getUserDeviceInfo(userId);
			DoctorRegistration doctorRegistration = commonDAO.getPhysicianBasicInfo(physicianId);
			String name = doctorRegistration.getFirstname() + " " + doctorRegistration.getLastname();
			notifcationService.sendPhysicianSentAppointmentNotification(name, devicesList, treatmentQuestionId);
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	/**
	 * 
	 * @param patientId
	 * @param physicianId
	 * @param treatmentQuestionId
	 */
	@Transactional
	public void notifyOngoingTreatmentReply(int patientId, int physicianId, int treatmentQuestionId) {

		try {
			int userId = commonDAO.getPatientUserId(patientId);
			ArrayList<UserNotificationDTO> devicesList = commonDAO.getUserDeviceInfo(userId);
			DoctorRegistration doctorRegistration = commonDAO.getPhysicianBasicInfo(physicianId);
			String name = doctorRegistration.getFirstname() + " " + doctorRegistration.getLastname();
			notifcationService.sendOngoingTreatmentReplyToPatientNotification(name, devicesList, treatmentQuestionId);
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param notificationVideoCallRequestModel
	 * @return
	 */
	@Transactional
	public StatusObject notifyToPhysicianIncomingcall(NotificationVideoCallRequestModel notificationVideoCallRequestModel){
		
		if(notificationVideoCallRequestModel != null){
			
		
			int userId = commonDAO.getPhysicianUserId(notificationVideoCallRequestModel.getPhysicianid());
			ArrayList<UserNotificationDTO> devicesList = commonDAO.getUserDeviceInfo(userId);
			PatientRegistration patientRegistration = commonDAO.getPatientBasicInfo(notificationVideoCallRequestModel.getPatientid());
			String name = patientRegistration.getFirstname() + " "
					+ patientRegistration.getLastname();
			notifcationService.sendIncomingCallNotification(notificationVideoCallRequestModel.getPatientid(),name,
					notificationVideoCallRequestModel.getRoomId(), devicesList);
			
			StatusObject statusObject=new StatusObject();
			statusObject.setError(true);
			statusObject.setMessage(getMessage("notification.sent.success"));
			return statusObject;
		}else{
			
			StatusObject statusObject=new StatusObject();
			statusObject.setError(true);
			statusObject.setMessage(getMessage("notification.sent.error"));
			return statusObject;
		}
	
	}
}
