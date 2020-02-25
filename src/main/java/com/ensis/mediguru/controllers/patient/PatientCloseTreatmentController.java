package com.ensis.mediguru.controllers.patient;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ensis.mediguru.models.OpenClosedTreatmentModel;
import com.ensis.mediguru.models.PatientCloseTreatmentModel;
import com.ensis.mediguru.models.PatientClosedTreatmentModel;
import com.ensis.mediguru.models.StatusObject;
import com.ensis.mediguru.service.patient.PatientCloseTreatmentService;

@Controller
@RequestMapping({ "Patient" })
public class PatientCloseTreatmentController {

	@Autowired
	PatientCloseTreatmentService patientCloseTreatmentService;

	public void setPatientCloseTreatmentService(
			PatientCloseTreatmentService patientCloseTreatmentService) {
		this.patientCloseTreatmentService = patientCloseTreatmentService;
	}

	/**
	 * 
	 * @param patientCloseTreatmentModel
	 * @return
	 */
	@RequestMapping(value = "/closeTreatment", method = RequestMethod.POST, headers = { "Content-type=application/json" }, produces = { "application/json" })
	@ResponseBody
	public StatusObject patientCloseTreatment(
			@RequestBody PatientCloseTreatmentModel patientCloseTreatmentModel) {

		return patientCloseTreatmentService
				.patientCloseTreatment(patientCloseTreatmentModel);
	}
	
	@RequestMapping(value = "/getClosedTreatments", method = RequestMethod.GET,  produces = { "application/json" })
	@ResponseBody
	public ArrayList<PatientClosedTreatmentModel> getclosedTreatment(
			@RequestHeader("patientid") int patientId) {

		return patientCloseTreatmentService.getClosedTreatment(patientId);
				
	}
	
	@RequestMapping(value = "/openClosedTreatment", method = RequestMethod.POST, produces = { "application/json" })
	@ResponseBody
	public StatusObject openClosedTreatment(
			@RequestBody OpenClosedTreatmentModel openClosedTreatmentModel) {

		return patientCloseTreatmentService.openClosedTreatment(openClosedTreatmentModel.getTreatmentid());
				
	}
	
}
