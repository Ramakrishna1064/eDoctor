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

import com.ensis.mediguru.models.PhysicianQuestionsReminderViewModel;
import com.ensis.mediguru.models.StatusObject;
import com.ensis.mediguru.models.TreatmentReminderModel;
import com.ensis.mediguru.service.physician.PhysicianTreatmentQuestionReminderService;

/**
 * @author Venu
 *
 */
@Controller
@RequestMapping({ "/Physician/reminder" })
public class PhysicianTreatmentQuestionReminderContoller {

	@Autowired
	PhysicianTreatmentQuestionReminderService physicianTreatmentQuestionReminderService;

	/**
	 * 
	 * @param treatmentReminderModel
	 * @return
	 */
	@RequestMapping(value = "/addQuestionToReminder", method = RequestMethod.POST, headers = {
			"Content-type=application/json" }, produces = { "application/json" })
	@ResponseBody
	public StatusObject addQuestionToReminder(@RequestBody TreatmentReminderModel treatmentReminderModel) {

		return physicianTreatmentQuestionReminderService.saveTreatmentReminder(treatmentReminderModel);
	}

	/**
	 * 
	 * @param physicianid
	 * @param date
	 * @return
	 */
	@RequestMapping(value = "/getReminders", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public ArrayList<PhysicianQuestionsReminderViewModel> getReminders(@RequestHeader("physicianid") int physicianid,
			@RequestHeader("reminderdate") String date) {
		return physicianTreatmentQuestionReminderService.getPhysicianReminders(physicianid, date);
	}

	/**
	 * 
	 * @param treatmentReminderModel
	 * @return
	 */
	@RequestMapping(value = "/deleteReminder", method = RequestMethod.DELETE, headers = {
			"Content-type=application/json" }, produces = { "application/json" })
	@ResponseBody
	public StatusObject deleteReminder(@RequestBody TreatmentReminderModel treatmentReminderModel) {

		return physicianTreatmentQuestionReminderService.deleteReminder(treatmentReminderModel);
	}

	/**
	 * 
	 * @param treatmentReminderModel
	 * @return
	 */
	@RequestMapping(value = "/rescheduleReminder", 
					method = RequestMethod.POST, 
					headers = {"Content-type=application/json" },
					produces = { "application/json" })
	@ResponseBody
	public StatusObject rescheduleReminder(@RequestBody TreatmentReminderModel treatmentReminderModel) {

		return physicianTreatmentQuestionReminderService.rescheduleReminder(treatmentReminderModel);
	}
	
	/**
	 * 
	 * @param treatmentReminderModel
	 * @return
	 */
	@RequestMapping(value = "/completeReminder", method = RequestMethod.POST, headers = {
			"Content-type=application/json" }, produces = { "application/json" })
	@ResponseBody
	public StatusObject completeReminder(@RequestBody TreatmentReminderModel treatmentReminderModel) {

		return physicianTreatmentQuestionReminderService.completeReminder(treatmentReminderModel);
	}

}
