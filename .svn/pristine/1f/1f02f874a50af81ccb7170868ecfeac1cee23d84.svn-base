/**
 * 
 */
package com.ensis.mediguru.service.physician;

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
import com.ensis.mediguru.models.PhysicianNotificationModel;
import com.ensis.mediguru.models.StatusObject;
import com.ensis.mediguru.service.common.NotifcationService;
import com.ensis.mediguru.utils.MessageResources;

/**
 * @author Venu
 *
 */
@Service
public class PhysicianNotificationService extends MessageResources {

	@Autowired
	CommonDAO commonDAO;

	@Autowired
	NotifcationService notifcationService;

	/**
	 * @param notifcationService
	 *            the notifcationService to set
	 */
	public void setNotifcationService(NotifcationService notifcationService) {
		this.notifcationService = notifcationService;
	}

	/**
	 * @param commonDAO
	 *            the commonDAO to set
	 */
	public void setCommonDAO(CommonDAO commonDAO) {
		this.commonDAO = commonDAO;
	}

	/**
	 * 
	 * @return
	 */
	@Transactional
	public StatusObject registerPhysicianDevice(
			PhysicianNotificationModel physicianNotificationModel) {

		StatusObject statusObject = new StatusObject();
		if (physicianNotificationModel != null) {

			int userId = commonDAO
					.getPhysicianUserId(physicianNotificationModel
							.getPhysicianId());
			if (userId > 0) {

				if(physicianNotificationModel.getGcmId() != null){
				
					UserNotificationDTO userNotificationDTO = new UserNotificationDTO();
					userNotificationDTO.setUserId(userId);
					userNotificationDTO.setDeviceId(physicianNotificationModel
							.getDeviceId());
					userNotificationDTO.setDeviceType(physicianNotificationModel
							.getDeviceType());
					userNotificationDTO.setGcmId(physicianNotificationModel
							.getGcmId());
					userNotificationDTO.setNotificationenable(true);
					userNotificationDTO.setCreatedby("Physician");
					userNotificationDTO.setCreateddate(new Date());
					boolean status = commonDAO
							.saveUserNotificationObj(userNotificationDTO);

					if (status) {
						statusObject.setError(false);
						statusObject
								.setMessage(getMessage("device.registration.success"));
						return statusObject;
					} else {
						statusObject.setError(true);
						statusObject
								.setMessage(getMessage("device.registration.error"));
						return statusObject;
					}
				}else{
					
					statusObject.setError(true);
					statusObject
							.setMessage(getMessage("device.registration.error"));
					return statusObject;
				}

			} else {
				statusObject.setError(true);
				statusObject
						.setMessage(getMessage("device.registration.error"));
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
	 * @param specialityId
	 * @param treatmentQuestionId
	 */
	@Transactional
	public void notifyPhysicianGroupQuestionPosted(int patientId,
			int specialityId, int treatmentQuestionId) {

		try {

			/*ArrayList<UserNotificationDTO> allDevicesList = new ArrayList<UserNotificationDTO>();
			ArrayList<DoctorRegistration> docsList = commonDAO
					.getPhysiciansListBySpeciality(specialityId);
			for (DoctorRegistration doctorRegistration : docsList) {
				int userId = commonDAO.getPhysicianUserId(doctorRegistration
						.getPhysicianid());
				ArrayList<UserNotificationDTO> devicesList = commonDAO.getUserDeviceInfo(userId);
				allDevicesList.addAll(devicesList);
			}
			PatientRegistration patientRegistration = commonDAO.getPatientBasicInfo(patientId);
			String name = patientRegistration.getFirstname() + " "
					+ patientRegistration.getLastname();
			notifcationService.sendNewQuestionNotification(name,allDevicesList, treatmentQuestionId);*/

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
	public void notifyPhysicianIndividualQuestionPosted(int patientId,
			int physicianId, int treatmentQuestionId) {

		try {
			int userId = commonDAO.getPhysicianUserId(physicianId);
			//System.out.println("--Physician UserId--->"+userId);
			ArrayList<UserNotificationDTO> devicesList = commonDAO.getUserDeviceInfo(userId);
			//System.out.println("--devicesList UserId--->"+devicesList.size());
			PatientRegistration patientRegistration = commonDAO.getPatientBasicInfo(patientId);
			String name = patientRegistration.getFirstname() + " "
					+ patientRegistration.getLastname();
			//System.out.println("--name user notfication--->"+name);
			notifcationService.sendNewQuestionNotification(name, devicesList,treatmentQuestionId);
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
	public void notifyPatientAcceptedAppointment(int patientId,int physicianId, int treatmentQuestionId){
		
		try {
			int userId = commonDAO.getPhysicianUserId(physicianId);
			ArrayList<UserNotificationDTO> devicesList = commonDAO.getUserDeviceInfo(userId);
			PatientRegistration patientRegistration = commonDAO.getPatientBasicInfo(patientId);
			String name = patientRegistration.getFirstname() + " "
					+ patientRegistration.getLastname();
			notifcationService.sendAppointmnetAcceptedNotification(name, devicesList,treatmentQuestionId);
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
	public void notifyCloseTreatment(int patientId,int physicianId, int treatmentQuestionId){
		
		try {
			int userId = commonDAO.getPhysicianUserId(physicianId);
			ArrayList<UserNotificationDTO> devicesList = commonDAO.getUserDeviceInfo(userId);
			PatientRegistration patientRegistration = commonDAO.getPatientBasicInfo(patientId);
			String name = patientRegistration.getFirstname() + " "
					+ patientRegistration.getLastname();
			notifcationService.sendCloseTreatmentNotification(name, devicesList,treatmentQuestionId);
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
	public void notifyOngoingReplyFromPatient(int patientId,int physicianId, int treatmentQuestionId){
		
		try {
			int userId = commonDAO.getPhysicianUserId(physicianId);
			ArrayList<UserNotificationDTO> devicesList = commonDAO.getUserDeviceInfo(userId);
			PatientRegistration patientRegistration = commonDAO.getPatientBasicInfo(patientId);
			String name = patientRegistration.getFirstname() + " "
					+ patientRegistration.getLastname();
			notifcationService.sendPatientOngoingReplyToPhysicianNotification(name, devicesList,treatmentQuestionId);
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
	public StatusObject notifyCallRejected(NotificationVideoCallRequestModel notificationVideoCallRequestModel){
		
		if(notificationVideoCallRequestModel != null){
			
			int userId = commonDAO.getPatientUserId(notificationVideoCallRequestModel.getPatientid());
			ArrayList<UserNotificationDTO> devicesList = commonDAO.getUserDeviceInfo(userId);
			DoctorRegistration doctorRegistration = 
					commonDAO.getPhysicianBasicInfo(notificationVideoCallRequestModel.getPhysicianid());
			String name = doctorRegistration.getFirstname() + 
					" " + doctorRegistration.getLastname();
			notifcationService.sendCallRejectedNotification(name,devicesList);
			
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
