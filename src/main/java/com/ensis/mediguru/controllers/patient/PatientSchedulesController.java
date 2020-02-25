/**
 * 
 */
package com.ensis.mediguru.controllers.patient;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ensis.mediguru.models.PatientAcceptAppointmentModel;
import com.ensis.mediguru.models.PatientSchedulesModel;
import com.ensis.mediguru.models.StatusObject;
import com.ensis.mediguru.service.patient.PatientSchedulesService;

/**
 * @author Venu
 *
 */
@Controller
@RequestMapping({ "/Patient/Schedules" })
public class PatientSchedulesController {

	@Autowired
	PatientSchedulesService patientSchedulesService;

	/**
	 * @param patientSchedulesService the patientSchedulesService to set
	 */
	public void setPatientSchedulesService(
			PatientSchedulesService patientSchedulesService) {
		this.patientSchedulesService = patientSchedulesService;
	}


	/**
	 * 
	 * @param patientId
	 * @return
	 */
	@RequestMapping(value = "/getPatientSchedules", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public ArrayList<PatientSchedulesModel> getPatientSchedules(@RequestHeader("patientid") int patientId) {
		
		return patientSchedulesService.getPatientSchedules(patientId);
	}
	
	
	@RequestMapping(value = "/acceptAppointment", method = RequestMethod.POST, produces = { "application/json" })
	@ResponseBody
	public StatusObject acceptAppointment(@RequestBody PatientAcceptAppointmentModel patientAcceptAppointmentModel) {
		return patientSchedulesService.acceptScheduleAppointment(patientAcceptAppointmentModel);
	}
	
}
