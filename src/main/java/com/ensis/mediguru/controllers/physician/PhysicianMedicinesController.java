package com.ensis.mediguru.controllers.physician;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ensis.mediguru.models.GetPatientPastMedicines;
import com.ensis.mediguru.models.PatientMedicinesModel;
import com.ensis.mediguru.models.StatusObject;
import com.ensis.mediguru.models.UpdatePatientMedicine;
import com.ensis.mediguru.service.patient.PatientMedicinesService;
import com.ensis.mediguru.service.physician.PhysicianMedicinesService;

@Controller
@RequestMapping({ "/Physician/Medicines" })
public class PhysicianMedicinesController {

	@Autowired
	PhysicianMedicinesService physicianMedicinesService;

	@Autowired
	PatientMedicinesService patientMedicinesService;

	public void setPatientMedicinesService(
			PatientMedicinesService patientMedicinesService) {
		this.patientMedicinesService = patientMedicinesService;
	}

	public void setPhysicianMedicinesService(
			PhysicianMedicinesService physicianMedicinesService) {
		this.physicianMedicinesService = physicianMedicinesService;
	}

	/**
	 * 
	 * @param patientMedicinesModel
	 * @return
	 */
	@RequestMapping(value = "/addPatientMedicine", method = RequestMethod.POST, headers = { "Content-type=application/json" }, produces = { "application/json" })
	@ResponseBody
	public StatusObject addPatientMedicines(
			@RequestBody PatientMedicinesModel patientMedicinesModel) {

		return physicianMedicinesService
				.addPatientMedicines(patientMedicinesModel);

	}

	/**
	 * 
	 * @param updatePatientMedicine
	 * @return
	 */
	@RequestMapping(value = "/editPatientMedicine", method = RequestMethod.POST, headers = { "Content-type=application/json" }, produces = { "application/json" })
	@ResponseBody
	public StatusObject EditPatientMedicines(
			@RequestBody UpdatePatientMedicine updatePatientMedicine) {

		return physicianMedicinesService
				.updatePatientMedicines(updatePatientMedicine);

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
			@RequestHeader("physicianid") int patientId,
			@RequestHeader("treatmentid") int treatmentId) {

		return patientMedicinesService
				//.getPatientMedicineTreatmentHistory(treatmentId);
				.getMedicinesList(treatmentId);
	}
}
