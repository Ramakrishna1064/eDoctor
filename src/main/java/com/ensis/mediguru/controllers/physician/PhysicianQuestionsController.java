/**
 * 
 */
package com.ensis.mediguru.controllers.physician;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ensis.mediguru.models.PatientPhysicianReplyAnswerModel;
import com.ensis.mediguru.models.PhyPatQuesAnsReplyModel;
import com.ensis.mediguru.models.PhysicianQuestionsAndAnswersModel;
import com.ensis.mediguru.models.StatusObject;
import com.ensis.mediguru.service.patient.PatientQuestionsService;
import com.ensis.mediguru.service.physician.PhysicianQuestionsService;

/**
 * @author Venu
 *
 */
@Controller
@RequestMapping({ "/Physician/Questions" })
public class PhysicianQuestionsController {

	@Autowired
	PhysicianQuestionsService physicianQuestionsService;

	@Autowired
	PatientQuestionsService patientQuestionsService;

	/**
	 * @param patientQuestionsService
	 *            the patientQuestionsService to set
	 */
	public void setPatientQuestionsService(
			PatientQuestionsService patientQuestionsService) {
		this.patientQuestionsService = patientQuestionsService;
	}

	/**
	 * @param physicianQuestionsService
	 *            the physicianQuestionsService to set
	 */
	public void setPhysicianQuestionsService(
			PhysicianQuestionsService physicianQuestionsService) {
		this.physicianQuestionsService = physicianQuestionsService;
	}

	/**
	 * 
	 * @param physicianid
	 * @return
	 */
	@RequestMapping(value = "/getIndividualQuestions", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public ArrayList<PhysicianQuestionsAndAnswersModel> getIndividualQuestions(
			@RequestHeader("physicianid") int physicianid) {
		return physicianQuestionsService.getPhysicianQuestions(physicianid);
	}

	/**
	 * 
	 * @param physicianid
	 * @return
	 */
	@RequestMapping(value = "/getGroupQuestions", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public ArrayList<PhysicianQuestionsAndAnswersModel> getGroupQuestions(
			@RequestHeader("physicianid") int physicianid,
			@RequestHeader("specialityid") int specialityid) {
		return physicianQuestionsService.getPhysicianGroupQuestions(
				physicianid, specialityid);
	}

	/**
	 * 
	 * @param physicianid
	 * @return
	 */
	@RequestMapping(value = "/getOngoingQuestions", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public ArrayList<PhysicianQuestionsAndAnswersModel> getOngoingQuestions(
			@RequestHeader("physicianid") int physicianid) {
		return physicianQuestionsService
				.getPhysicianOngoingQuestions(physicianid);
	}

	/**
	 * 
	 * @param physicianid
	 * @return
	 */
	@RequestMapping(value = "/getClosedQuestions", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public ArrayList<PhysicianQuestionsAndAnswersModel> getClosedQuestions(
			@RequestHeader("physicianid") int physicianid) {
		return physicianQuestionsService
				.getPhysicianClosedQuestions(physicianid);
	}

	/**
	 * 
	 * @param treatmentquestionid
	 * @param patientId
	 * @return
	 */
	@RequestMapping(value = "/getQuestionDeatils", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public ArrayList<PhyPatQuesAnsReplyModel> getQuestionDeatils(
			@RequestHeader("treatmentquestionid") int treatmentquestionid,
			@RequestHeader("physicianid") int physicianid) {

		return physicianQuestionsService.getQuestionAnswerDeatils(
				treatmentquestionid, physicianid);
	}

	/**
	 * 
	 * @param treatmentPatientAnswerDTO
	 * @return
	 */
	@RequestMapping(value = "/replyAnswer", method = RequestMethod.POST, headers = { "Content-type=application/json" }, produces = { "application/json" })
	@ResponseBody
	public StatusObject replyToQuestionAns(
			@RequestBody PatientPhysicianReplyAnswerModel patientPhysicianReplyAnswerModel) {
		return physicianQuestionsService
				.replyToQuestionAns(patientPhysicianReplyAnswerModel);
	}

	/**
	 * 
	 * @param patientPhysicianReplyAnswerModel
	 * @return
	 */
	@RequestMapping(value = "/deleteQuestion", method = RequestMethod.DELETE, headers = { "Content-type=application/json" }, produces = { "application/json" })
	@ResponseBody
	public StatusObject deleteQuestion(
			@RequestBody PatientPhysicianReplyAnswerModel patientPhysicianReplyAnswerModel) {
		return physicianQuestionsService
				.deleteQuestion(patientPhysicianReplyAnswerModel);
	}

	/**
	 * 
	 * @param patientPhysicianReplyAnswerModel
	 * @return
	 */
	@RequestMapping(value = "/treatmentQuestionDetails", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public PhysicianQuestionsAndAnswersModel questionDetails(
			@RequestHeader("treatmentquestionid") int treatmentquestionid,
			@RequestHeader("physicianid") int physicianid) {
		// return
		return physicianQuestionsService.getPhysicianTreatmentDetails(
				physicianid, treatmentquestionid);
		// return null;
	}

}
