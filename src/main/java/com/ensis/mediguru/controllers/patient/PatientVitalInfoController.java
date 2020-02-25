package com.ensis.mediguru.controllers.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ensis.mediguru.models.PatientVitalInfoModel;
import com.ensis.mediguru.models.StatusObject;
import com.ensis.mediguru.service.patient.PatientVitalInfoService;

@Controller
@RequestMapping({ "Patient" })
public class PatientVitalInfoController {

	@Autowired
	PatientVitalInfoService patientVitalInfoService;

	/**
	 * @param patientVitalInfoService
	 *            the patientVitalInfoService to set
	 */
	public void setPatientVitalInfoService(
			PatientVitalInfoService patientVitalInfoService) {
		this.patientVitalInfoService = patientVitalInfoService;
	}

	@RequestMapping(value = "/vitalInfo", method = RequestMethod.POST, produces = { "application/json" }, headers = { "Content-type=application/json" })
	@ResponseBody
	public StatusObject patientVitalInfo(
			@RequestBody PatientVitalInfoModel patientVitalInfoModel) {
		return patientVitalInfoService
				.addPatientVitalInfo(patientVitalInfoModel);
	}

}
