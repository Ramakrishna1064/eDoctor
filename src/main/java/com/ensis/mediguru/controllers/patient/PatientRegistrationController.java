/**
 * 
 */
package com.ensis.mediguru.controllers.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ensis.mediguru.models.GetPatientProfileModel;
import com.ensis.mediguru.models.PatientProfileCompletionModel;
import com.ensis.mediguru.models.PatientRegistrationModel;
import com.ensis.mediguru.models.StatusObject;
import com.ensis.mediguru.service.patient.PatientRegistrationService;

/**
 * @author Venu
 *
 */
@Controller
public class PatientRegistrationController {

	@Autowired
	PatientRegistrationService patientRegistrationService;

	public void setPatientRegistrationService(
			PatientRegistrationService patientRegistrationService) {
		this.patientRegistrationService = patientRegistrationService;
	}

	@RequestMapping(value = "/PatientRegistration", method = RequestMethod.POST, headers = { "Content-type=application/json" }, produces = { "application/json" })
	@ResponseBody
	public StatusObject registerPatient(
			@RequestBody PatientRegistrationModel patientRegistrationModel) {
		return patientRegistrationService
				.patientRegistration(patientRegistrationModel);
	}

	/**
	 * 
	 * @param PatientProfileCompletionModel
	 * @return
	 */
	@RequestMapping(value = "/Patient/createProfile", method = RequestMethod.POST, headers = { "Content-type=application/json" }, produces = { "application/json" })
	@ResponseBody
	public StatusObject createProfile(
			@RequestBody PatientProfileCompletionModel PatientProfileCompletionModel) {
		return patientRegistrationService
				.createPatientProfile(PatientProfileCompletionModel);
	}

	/**
	 * 
	 * @param patientid
	 * @return
	 */
	@RequestMapping(value = "/Patient/getProfile", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public GetPatientProfileModel getPatientProfile(
			@RequestHeader("patientid") int patientid) {

		return patientRegistrationService.getPatientProfile(patientid);
	}

	/**
	 * 
	 * @param PatientProfileCompletionModel
	 * @return
	 */
	@RequestMapping(value = "/Patient/updateProfile", method = RequestMethod.POST, produces = { "application/json" })
	@ResponseBody
	public StatusObject updatePatientProfile(
			@RequestBody PatientProfileCompletionModel PatientProfileCompletionModel) {

		return patientRegistrationService
				.updatePatientProfile(PatientProfileCompletionModel);
		// return null;
	}

	/**
	 * 
	 * @param PatientProfileCompletionModel
	 * @return
	 */
	@RequestMapping(value = "/Patient/updatePatientPrefAndBillingInfo", method = RequestMethod.POST, produces = { "application/json" })
	@ResponseBody
	public StatusObject updatePatientPrefAndBillingInfo(
			@RequestBody PatientProfileCompletionModel PatientProfileCompletionModel) {

		return patientRegistrationService
				.updatePatientPreferenceAndBillingInfo(PatientProfileCompletionModel);

	}

}
