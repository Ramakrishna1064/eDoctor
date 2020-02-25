/**
 * 
 */
package com.ensis.mediguru.controllers.physician;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ensis.mediguru.models.NotificationVideoCallRequestModel;
import com.ensis.mediguru.models.PhysicianNotificationModel;
import com.ensis.mediguru.models.StatusObject;
import com.ensis.mediguru.service.physician.PhysicianNotificationService;

/**
 * @author Venu
 *
 */
@Controller
@RequestMapping({ "/Physician/Notification" })
public class PhysicianNotificationController {

	@Autowired
	PhysicianNotificationService physicianNotificationService;

	/**
	 * @param physicianNotificationService
	 *            the physicianNotificationService to set
	 */
	public void setPhysicianNotificationService(PhysicianNotificationService physicianNotificationService) {
		this.physicianNotificationService = physicianNotificationService;
	}

	/**
	 * 
	 * @param physicianNotificationModel
	 * @return
	 */
	@RequestMapping(value = "/addDevice", method = RequestMethod.POST, headers = {
			"Content-type=application/json" }, produces = { "application/json" })
	@ResponseBody
	public StatusObject addDevice(@RequestBody PhysicianNotificationModel physicianNotificationModel) {

		return physicianNotificationService.registerPhysicianDevice(physicianNotificationModel);
	}

	/**
	 * 
	 * @param notificationVideoCallRequestModel
	 * @return
	 */
	@RequestMapping(value = "/sendCallReject", method = RequestMethod.POST, headers = {
			"Content-type=application/json" }, produces = { "application/json" })
	@ResponseBody
	public StatusObject sendCallReject(@RequestBody NotificationVideoCallRequestModel notificationVideoCallRequestModel) {

		return physicianNotificationService.notifyCallRejected(notificationVideoCallRequestModel);
	}
}
