/**
 * 
 */
package com.ensis.mediguru.controllers.patient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ensis.mediguru.models.PhysicianSearchRecordsModel;
import com.ensis.mediguru.service.patient.PatientStartTreatmentService;

/**
 * @author Venu
 *
 */
@Controller
@RequestMapping({ "Patient" })
public class PatientStratTreatmentController {

	@Autowired
	PatientStartTreatmentService patientStartTreatmentService;

	public void setPatientStartTreatmentService(
			PatientStartTreatmentService patientStartTreatmentService) {
		this.patientStartTreatmentService = patientStartTreatmentService;
	}

	/**
	 * 
	 * @param specialitytypeid
	 * @param patientid
	 * @param location
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/searchPhysicianList", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public List<PhysicianSearchRecordsModel> getPhysiciansList(
			@RequestHeader int specialitytypeid, @RequestHeader int patientid,
			@RequestHeader int treatmentcost, @RequestHeader String rating,
			@RequestHeader String hours, @RequestHeader String latitude,
			@RequestHeader String longitude, @RequestHeader String miles,@RequestHeader String location)
			throws Exception {

		return patientStartTreatmentService.getPhysiciansList(specialitytypeid,
				patientid, treatmentcost, rating, hours, latitude, longitude,
				miles,location);
	}

	

}
