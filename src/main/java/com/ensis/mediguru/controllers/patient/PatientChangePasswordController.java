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

import com.ensis.mediguru.models.PatientChangePasswordModel;
import com.ensis.mediguru.models.StatusObject;
import com.ensis.mediguru.service.patient.PatientChangePasswordService;

/**
 * @author Venu
 *
 */
@Controller
@RequestMapping({ "/Patient/Pwd" })
public class PatientChangePasswordController {

	@Autowired
	PatientChangePasswordService patientChangePasswordService;
	
	
	/**
	 * @param patientChangePasswordService the patientChangePasswordService to set
	 */
	public void setPatientChangePasswordService(
			PatientChangePasswordService patientChangePasswordService) {
		this.patientChangePasswordService = patientChangePasswordService;
	}


	/**
	 * 
	 * @param patientChnagePasswordModel
	 * @return
	 */
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST, headers = { "Content-type=application/json" },
			produces = { "application/json" })
	@ResponseBody
	public StatusObject changePassword(
			@RequestBody PatientChangePasswordModel patientChnagePasswordModel) {
		return patientChangePasswordService.changePassword(patientChnagePasswordModel);
	}
}
