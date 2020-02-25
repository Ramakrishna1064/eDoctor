/**
 * 
 */
package com.ensis.mediguru.controllers.physician;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ensis.mediguru.models.PhysicianPatientsOngoingPastViewModel;
import com.ensis.mediguru.service.physician.PhysicianPatientsService;

/**
 * @author Venu
 *
 */
@Controller
@RequestMapping({ "/Physician/Pateints" })
public class PatientPhysiciansController {

	@Autowired
	PhysicianPatientsService physicianPatientsService;

	/**
	 * @param physicianPatientsService the physicianPatientsService to set
	 */
	public void setPhysicianPatientsService(
			PhysicianPatientsService physicianPatientsService) {
		this.physicianPatientsService = physicianPatientsService;
	}
	
	
	/**
	 * 
	 * @param physicianid
	 * @return
	 */
	@RequestMapping(value = "/getPatients", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public ArrayList<PhysicianPatientsOngoingPastViewModel> getPatients(@RequestHeader("physicianid") int physicianid) {
		return physicianPatientsService.getPhysicanPatients(physicianid);
	}
}
