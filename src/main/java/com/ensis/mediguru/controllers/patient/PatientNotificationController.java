/**
 * 
 */
package com.ensis.mediguru.controllers.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ensis.mediguru.models.NotificationVideoCallRequestModel;
import com.ensis.mediguru.models.PatientNotificationModel;
import com.ensis.mediguru.models.StatusObject;
import com.ensis.mediguru.service.patient.PatientNotificationService;

/**
 * @author shyam
 *
 */
@Controller
@RequestMapping({ "/Patient/Notification" })
public class PatientNotificationController {

	@Autowired
	PatientNotificationService patientNotificationService;

	public void setPatientNotificationService(PatientNotificationService patientNotificationService) {
		this.patientNotificationService = patientNotificationService;
	}

	/**
	 * 
	 * @param physicianNotificationModel
	 * @return
	 */
	@RequestMapping(value = "/addDevice", method = RequestMethod.POST, headers = {
			"Content-type=application/json" }, produces = { "application/json" })
	@ResponseBody
	public StatusObject addDevice(@RequestBody PatientNotificationModel patientNotificationModel) {
		return patientNotificationService.registerPatientDevice(patientNotificationModel);
	}
	
	/**
	 * 
	 * @param notificationVideoCallRequestModel
	 * @return
	 */
	@RequestMapping(value = "/sendIncomingCallRequest", method = RequestMethod.POST, headers = {
			"Content-type=application/json" }, produces = { "application/json" })
	@ResponseBody
	public StatusObject sendIncomingCallRequest(@RequestBody 
			NotificationVideoCallRequestModel notificationVideoCallRequestModel) {

		return patientNotificationService.notifyToPhysicianIncomingcall(notificationVideoCallRequestModel);
	}
}
