/**
 * 
 */
package com.ensis.mediguru.controllers.physician;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ensis.mediguru.models.PhysicianCreateProfileModel;
import com.ensis.mediguru.models.PhysicianProfileModel;
import com.ensis.mediguru.models.PhysicianProfileUpdateClinicInfoModel;
import com.ensis.mediguru.models.PhysicianProfileUpdatePersonalInfo;
import com.ensis.mediguru.models.PhysicianProfileUpdateProfessionalInfoModel;
import com.ensis.mediguru.models.StatusObject;
import com.ensis.mediguru.service.physician.PhysicianProfileService;

/**
 * @author Venu
 *
 */
@Controller
@RequestMapping({ "/Physician/Profile" })
public class PhysicianProfileController {

	@Autowired
	PhysicianProfileService physicianProfileService;

	/**
	 * 
	 * @param physicianid
	 * @return
	 */
	@RequestMapping(value = "/getPhysicianProfile", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public PhysicianProfileModel getPhysicianProfile(
			@RequestHeader("physicianid") int physicianid) {

		return physicianProfileService.getPhysicianProfile(physicianid);
	}

	/**
	 * 
	 * @param profileObj
	 * @return
	 */
	@RequestMapping(value = "/createProfile", method = RequestMethod.POST, headers = { "Content-type=application/json" }, produces = { "application/json" })
	@ResponseBody
	public StatusObject createProfile(
			@RequestBody PhysicianCreateProfileModel profileObj) {
		return physicianProfileService.createProfile(profileObj);
	}

	/**
	 * 
	 * @param request
	 * @param requestParams
	 * @return
	 */
	@RequestMapping(value = "/uploadProfileProfessionalImages", method = RequestMethod.POST, produces = { "application/json" })
	@ResponseBody
	public StatusObject uploadProfileProfessionalImages(
			MultipartHttpServletRequest request,
			@RequestParam Map<String, String> requestParams) {

		int physicianid = Integer.parseInt(requestParams.get("physicianid"));
		return physicianProfileService.uploadProfileProfessionalImages(request,
				physicianid);
	}

	/**
	 * 
	 * @param personalInfoModel
	 * @return
	 */
	@RequestMapping(value = "/updatePersonalInfo", method = RequestMethod.POST, headers = { "Content-type=application/json" }, produces = { "application/json" })
	@ResponseBody
	public StatusObject updatePersonalInfo(
			@RequestBody PhysicianProfileUpdatePersonalInfo personalInfoModel) {
		return physicianProfileService
				.updateProfilePersonalInfo(personalInfoModel);
	}

	/**
	 * 
	 * @param professionalInfoModel
	 * @return
	 */
	@RequestMapping(value = "/updateProfessionalInfo", method = RequestMethod.POST, headers = { "Content-type=application/json" }, produces = { "application/json" })
	@ResponseBody
	public StatusObject updateProfessionalInfo(
			@RequestBody PhysicianProfileUpdateProfessionalInfoModel professionalInfoModel) {
		return physicianProfileService
				.updateProfileProfessionalInfo(professionalInfoModel);
	}

	/**
	 * 
	 * @param clinicInfoModel
	 * @return
	 */
	@RequestMapping(value = "/updateClinicInfoModel", method = RequestMethod.POST, headers = { "Content-type=application/json" }, produces = { "application/json" })
	@ResponseBody
	public StatusObject updateClinicInfo(
			@RequestBody PhysicianProfileUpdateClinicInfoModel clinicInfoModel) {
		return physicianProfileService.updateProfileClinicInfo(clinicInfoModel);
	}

}
