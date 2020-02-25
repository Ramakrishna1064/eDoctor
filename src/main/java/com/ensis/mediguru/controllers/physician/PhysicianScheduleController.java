/**
 * 
 */
package com.ensis.mediguru.controllers.physician;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ensis.mediguru.models.PatientPhysicianReplyAnswerModel;
import com.ensis.mediguru.models.PhysicianOngoingScheduleModel;
import com.ensis.mediguru.models.StatusObject;
import com.ensis.mediguru.service.physician.PhysicianScheduleService;

/**
 * @author Venu
 *
 */
@Controller
@RequestMapping({ "/Physician/schedules" })
public class PhysicianScheduleController {

	
	@Autowired
	PhysicianScheduleService physicianScheduleService;

	
	/**
	 * @param physicianScheduleService the physicianScheduleService to set
	 */
	public void setPhysicianScheduleService(
			PhysicianScheduleService physicianScheduleService) {
		this.physicianScheduleService = physicianScheduleService;
	}


	/**
	 * 
	 * @param physicianid
	 * @return
	 */
	@RequestMapping(value = "/getSchedules", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public ArrayList<PhysicianOngoingScheduleModel> getIndividualQuestions(@RequestHeader("physicianid") int physicianid,
			@RequestHeader("scheduledate") String date) {
		return physicianScheduleService.getPhysicianSchedules(physicianid,""+date);
	}
	
	/**
	 * 
	 * @param patientPhysicianReplyAnswerModel
	 * @return
	 */
	@RequestMapping(value = "/reschedule", method = RequestMethod.POST, headers = { "Content-type=application/json" }, produces = { "application/json" })
	@ResponseBody
	public StatusObject reschedule(@RequestBody PatientPhysicianReplyAnswerModel patientPhysicianReplyAnswerModel) {
		return physicianScheduleService.rescheduleAppointment(patientPhysicianReplyAnswerModel);
	}
}
