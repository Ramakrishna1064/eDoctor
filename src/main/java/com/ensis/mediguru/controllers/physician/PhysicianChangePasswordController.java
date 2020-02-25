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

import com.ensis.mediguru.models.PhysicianChangePasswordModel;
import com.ensis.mediguru.models.StatusObject;
import com.ensis.mediguru.service.physician.PhysicianChangePasswordService;

/**
 * @author Venu
 *
 */
@Controller
@RequestMapping({ "/Physician/Pwd" })
public class PhysicianChangePasswordController {

	@Autowired
	PhysicianChangePasswordService physicianChangePasswordService;
	

	/**
	 * @param physicianChangePasswordService the physicianChangePasswordService to set
	 */
	public void setPhysicianChangePasswordService(
			PhysicianChangePasswordService physicianChangePasswordService) {
		this.physicianChangePasswordService = physicianChangePasswordService;
	}



	/**
	 * 
	 * @param physicianChangePasswordModel
	 * @return
	 */
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST, headers = { "Content-type=application/json" }, produces = { "application/json" })
	@ResponseBody
	public StatusObject changePassword(
			@RequestBody PhysicianChangePasswordModel physicianChangePasswordModel) {
		return physicianChangePasswordService
				.changePassword(physicianChangePasswordModel);
	}
}
