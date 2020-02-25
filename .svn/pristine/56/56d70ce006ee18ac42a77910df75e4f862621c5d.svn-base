/**
 * 
 */
package com.ensis.mediguru.controllers.patient;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ensis.mediguru.models.PatientOngoingQuestionsModel;
import com.ensis.mediguru.models.PatientPhysicianReplyAnswerModel;
import com.ensis.mediguru.models.PatientQuestionsAndAnswersModel;
import com.ensis.mediguru.models.PhyPatQuesAnsReplyModel;
import com.ensis.mediguru.models.StatusObject;
import com.ensis.mediguru.service.patient.PatientQuestionsService;

/**
 * @author Venu
 *
 */
@Controller
@RequestMapping({ "/Patient/Questions" })
public class PatientQuestionsController {

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
	 * 
	 * @param patientId
	 * @return
	 */
	@RequestMapping(value = "/getQuestionsAndAnswers", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public ArrayList<PatientQuestionsAndAnswersModel> getQuestionsAndAnswers(
			@RequestHeader("patientid") int patientId) {

		return patientQuestionsService.getPatientQuestions(patientId);
	}

	@RequestMapping(value = "/replyToQuestionAns", method = RequestMethod.POST, headers = "content-type=multipart/*", produces = { "application/json" })
	@ResponseBody
	public StatusObject replyToQuestionAns(
			@RequestParam Map<String, String> requestParams,
			@RequestParam("imagename") MultipartFile[] imageFile,
			@RequestParam("audioname") MultipartFile[] audioFile,
			@RequestParam("videoname") MultipartFile[] videoFile)
			throws Exception {

		int patientid = Integer.parseInt(requestParams.get("patientid"));
		int physicianid = Integer.parseInt(requestParams.get("physicianid"));
		int treatmentquestionid = Integer.parseInt(requestParams
				.get("treatmentquestionid"));
		String reply = requestParams.get("reply");

		PatientPhysicianReplyAnswerModel modelObj = new PatientPhysicianReplyAnswerModel();
		modelObj.setPatientid(patientid);
		modelObj.setPhysicianid(physicianid);
		modelObj.setReply(reply);
		modelObj.setTreatmentquestionid(treatmentquestionid);
		// send to service class
		return patientQuestionsService.replyToQuestionAns(modelObj, imageFile,
				audioFile, videoFile);

	}

	/**
	 * 
	 * @param patientId
	 * @return
	 */
	@RequestMapping(value = "/getOngoingQuestions", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public ArrayList<PatientOngoingQuestionsModel> getOngoingQuestions(
			@RequestHeader("patientid") int patientId) {

		return patientQuestionsService.getOngoingPhysicians(patientId);
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
			@RequestHeader("patientid") int patientId) {

		return patientQuestionsService
				.getQuestionAnswerDeatils(treatmentquestionid);
	}

	@RequestMapping(value = "/getTreatmentQuestionDetails", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public PatientOngoingQuestionsModel getTreatmentQuestionDetails(
			@RequestHeader("patientid") int patientId,
			@RequestHeader("treatmentquestionid") int treatmentquestionid) {

		return patientQuestionsService.getPatientTreatmentDetails(patientId,
				treatmentquestionid);
		// return null;
	}

}
