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

import com.ensis.mediguru.models.PhysicianRegistrationModel;
import com.ensis.mediguru.models.StatusObject;
import com.ensis.mediguru.service.physician.PhysicianRegistrationService;

/**
 * @author Venu
 *
 */
@Controller
public class PhysicianRegistrationController {

	@Autowired
	PhysicianRegistrationService PhysicianRegistrationService;
	
	@RequestMapping(value = "/DoctorRegistration", method = RequestMethod.POST, headers = { "Content-type=application/json" }, produces = { "application/json" })
	@ResponseBody
	public StatusObject registerPhysician(
			@RequestBody PhysicianRegistrationModel physicianRegistrationModel) {
		return PhysicianRegistrationService
				.registerPhysician(physicianRegistrationModel);
	}
}
