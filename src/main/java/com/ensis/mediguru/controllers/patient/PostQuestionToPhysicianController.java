package com.ensis.mediguru.controllers.patient;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ensis.mediguru.models.StatusObject;
import com.ensis.mediguru.service.patient.PostQuestionToPhysicianService;
import com.ensis.mediguru.utils.MessageResources;

/**
 * 
 * @author ensis
 *
 */
@Controller
@RequestMapping({ "Patient/Questions" })
public class PostQuestionToPhysicianController extends MessageResources {

	@Autowired
	PostQuestionToPhysicianService postQuestionToPhysicianService;

	public void setPostQuestionToPhysicianService(
			PostQuestionToPhysicianService postQuestionToPhysicianService) {
		this.postQuestionToPhysicianService = postQuestionToPhysicianService;
	}

	/**
	 * 
	 * @param requestParams
	 * @param file
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "/postStartTreatmentQuestionToPhysician", 
			method = RequestMethod.POST,
			headers = "content-type=multipart/*",
			produces = { "application/json" })
	@ResponseBody
	public StatusObject postStartTreatmentQuestionToPhysician(
			@RequestParam Map<String, String> requestParams,
			@RequestParam("imagename") MultipartFile[] imagefile,
			@RequestParam("audioname") MultipartFile[] audioFile,
			@RequestParam("videoname") MultipartFile[] videoFile) throws Exception {

		int patientid=Integer.parseInt(requestParams.get("patientid"));
		int physicianid=Integer.parseInt(requestParams.get("physicianid"));
		int specialityid=Integer.parseInt(requestParams.get("specialityid"));		
		String title=requestParams.get("title");
		String description=requestParams.get("description");
		
		return postQuestionToPhysicianService
				.postStartTreatmentQuestionToPhysician(imagefile,audioFile,videoFile,
						patientid,physicianid,specialityid,title, description, 1);

	}
	
	/**
	 * 
	 * @param requestParams
	 * @param file
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/postStartTreatmentQuestionToAllPhysician", 
			method = RequestMethod.POST,
			headers = "content-type=multipart/*",
			produces = { "application/json" })
	@ResponseBody
	public StatusObject postStartTreatmentQuestionToAllPhysician(
			@RequestParam Map<String, String> requestParams,
			@RequestParam("imagename") MultipartFile[] imageFile,
			@RequestParam("audioname") MultipartFile[] audioFile,
			@RequestParam("videoname") MultipartFile[] videoFile) throws Exception {
		
		int patientid=Integer.parseInt(requestParams.get("patientid"));
		int physicianid=0;
		if(requestParams.containsKey("physicianid")){
			physicianid=Integer.parseInt(requestParams.get("physicianid"));
		}		
		int specialityid=Integer.parseInt(requestParams.get("specialityid"));		
		String title=requestParams.get("title");
		String description=requestParams.get("description");
		
		return postQuestionToPhysicianService
				.postStartTreatmentQuestionToPhysician(imageFile,audioFile,videoFile,
						patientid,physicianid,specialityid,title, description, 2);

	}

}
