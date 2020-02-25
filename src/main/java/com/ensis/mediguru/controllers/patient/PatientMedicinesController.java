/**
 * 
 */
package com.ensis.mediguru.controllers.patient;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ensis.mediguru.models.GetPatientPastMedicines;
import com.ensis.mediguru.models.PatientOngoingMedicines;
import com.ensis.mediguru.service.patient.PatientMedicinesService;
import com.ensis.mediguru.service.physician.PhysicianMedicinesService;

/**
 * @author Ensis
 *
 */
@Controller
@RequestMapping({ "/Patient/Medicines" })
public class PatientMedicinesController {

	@Autowired
	PatientMedicinesService patientMedicinesService;

	@Autowired
	PhysicianMedicinesService physicianMedicinesService;
	
	public void setPatientMedicinesService(
			PatientMedicinesService patientMedicinesService) {
		this.patientMedicinesService = patientMedicinesService;
	}
	
	

	/**
	 * @param physicianMedicinesService the physicianMedicinesService to set
	 */
	public void setPhysicianMedicinesService(
			PhysicianMedicinesService physicianMedicinesService) {
		this.physicianMedicinesService = physicianMedicinesService;
	}



	/**
	 * 
	 * @param patientId
	 * @param treatmentid
	 * @return
	 */
	@RequestMapping(value = "/getOngoingMedicines", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public PatientOngoingMedicines getOngoingMedicines(
			@RequestHeader("patientid") int patientId,
			@RequestHeader("treatmentid") int treatmentId) {

		return patientMedicinesService.getOngoingMedicines(treatmentId,
				patientId);
	}


	/**
	 * 
	 * @param patientId
	 * @param treatmentId
	 * @return
	 */
	@RequestMapping(value = "/getTreatmentHistory", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public ArrayList<GetPatientPastMedicines> getTreatmentHistory(
			@RequestHeader("patientid") int patientId,
			@RequestHeader("treatmentid") int treatmentId) {

		return patientMedicinesService.getMedicinesList(treatmentId);
	}
}
