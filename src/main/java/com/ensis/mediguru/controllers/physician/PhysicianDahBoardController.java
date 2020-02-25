/**
 * 
 */
package com.ensis.mediguru.controllers.physician;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ensis.mediguru.models.PhysicianDashBoardModel;
import com.ensis.mediguru.service.physician.PhysicianDashBoardService;

/**
 * @author Venu
 *
 */
@Controller
@RequestMapping({ "/Physician/DashBoard" })
public class PhysicianDahBoardController {

	
	@Autowired
	PhysicianDashBoardService physicianDashBoardService;	
	
	/**
	 * @param physicianDashBoardService the physicianDashBoardService to set
	 */
	public void setPhysicianDashBoardService(
			PhysicianDashBoardService physicianDashBoardService) {
		this.physicianDashBoardService = physicianDashBoardService;
	}

	/**
	 * 
	 * @param physicianid
	 * @return
	 */
	@RequestMapping(value = "/getDashBoardInfo", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public PhysicianDashBoardModel getIndividualQuestions(@RequestHeader("physicianid") int physicianid) {
	
		return physicianDashBoardService.getPhysicianDashBoardInfo(physicianid);
	}
}
