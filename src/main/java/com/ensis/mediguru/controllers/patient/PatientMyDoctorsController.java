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

import com.ensis.mediguru.models.MyPhysiciansModel;
import com.ensis.mediguru.models.PhysicianFavoriteAndFamilyBean;
import com.ensis.mediguru.models.StatusObject;
import com.ensis.mediguru.service.patient.PatientMyDoctorsService;

/**
 * @author Venu
 *
 */
@Controller
@RequestMapping({ "Patient/myDoctors" })
public class PatientMyDoctorsController {
	
	@Autowired
	PatientMyDoctorsService patientMyDoctorsService;
	

	public void setPatientMyDoctorsService(
			PatientMyDoctorsService patientMyDoctorsService) {
		this.patientMyDoctorsService = patientMyDoctorsService;
	}


	/**
	 * Add Physician To Family And Favorite
	 * 
	 * @param physicianFavoriteAndFamilyBean
	 * @return
	 */
	@RequestMapping(value = "/addPhysicianToFavoriteAndFamily", 
			method = RequestMethod.POST, 
			headers = { "Content-type=application/json" }, 
			produces = { "application/json" })
	@ResponseBody
	public StatusObject addPhysicianToFavoriteAndFamily(
			@RequestBody PhysicianFavoriteAndFamilyBean physicianFavoriteAndFamilyBean) {
		return patientMyDoctorsService
				.addPhysicianToFavoriteAndFamily(physicianFavoriteAndFamilyBean);
	}
	
	
	/**
	 * Remove From Family And Favorite
	 * 
	 * @param physicianFavoriteAndFamilyBean
	 * @return
	 */
	@RequestMapping(value = "/removePhysicianFromFavoriteAndFamily", 
			method = RequestMethod.POST, 
			headers = { "Content-type=application/json" }, 
			produces = { "application/json" })
	@ResponseBody
	public StatusObject removePhysicianFromFavoriteAndFamily(
			@RequestBody PhysicianFavoriteAndFamilyBean physicianFavoriteAndFamilyBean) {
		return patientMyDoctorsService
				.removePhysicianFromFavoriteAndFamily(physicianFavoriteAndFamilyBean);
	}
	
	/**
	 * 
	 * @param patientId
	 * @return
	 */
	@RequestMapping(value = "/getMyDoctors", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public ArrayList<MyPhysiciansModel> getPatientPhysicians(@RequestHeader("patientid") int patientId) {
		
		return patientMyDoctorsService.getPatientPhysicianList(patientId);
	}	
	
}
