package com.ensis.mediguru.service.patient;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ensis.mediguru.dao.patient.PostQuestionToPhysicianDAO;
import com.ensis.mediguru.dto.Treatment;
import com.ensis.mediguru.dto.TreatmentImages;
import com.ensis.mediguru.dto.TreatmentQuestion;
import com.ensis.mediguru.models.StatusObject;
import com.ensis.mediguru.service.physician.PhysicianNotificationService;
import com.ensis.mediguru.utils.MessageResources;

/**
 * 
 * @author ensis
 *
 */
@Service
public class PostQuestionToPhysicianService extends MessageResources{

	@Autowired
	PostQuestionToPhysicianDAO postQuestionToPhysicianDAO;
	
	@Autowired
	PhysicianNotificationService physicianNotificationService;
	
	

	/**
	 * @param physicianNotificationService the physicianNotificationService to set
	 */
	public void setPhysicianNotificationService(
			PhysicianNotificationService physicianNotificationService) {
		this.physicianNotificationService = physicianNotificationService;
	}


	public void setPostQuestionToPhysicianDAO(
			PostQuestionToPhysicianDAO postQuestionToPhysicianDAO) {
		this.postQuestionToPhysicianDAO = postQuestionToPhysicianDAO;
	}


	/**
	 * 
	 * @param requestParams
	 * @param file
	 * @param quesType
	 * @param tretstatustypeid
	 * @return
	 */
	@Transactional
	public StatusObject postStartTreatmentQuestionToPhysician(MultipartFile[] imageFile,
			MultipartFile[] audioFile,MultipartFile[] videoFile,
			int patientid,
			int physicianid,int specialityid,String title, String description, int tretstatustypeid)
	{
		
		StatusObject statusObj=new StatusObject();
		Treatment treatment = new Treatment();
		treatment.setPatientid(patientid);
		if(tretstatustypeid == 1){
			treatment.setPhysicianid(physicianid);
		}
		treatment.setTreatmenttypeid(1); //Start Treatment Questions
		treatment.setSpecialitytypeid(specialityid);
		treatment.setCreateddate(new Date());
		treatment.setTretstatustypeid(tretstatustypeid); 
		int treatmentid= postQuestionToPhysicianDAO.treatment(treatment);
		
		if(treatmentid >0 ){
		
			TreatmentQuestion treatmentQuestion = new TreatmentQuestion();
			treatmentQuestion.setPatientid(patientid);
			treatmentQuestion.setQuestiontypeid(tretstatustypeid); //question type 1 single 2for Group
			treatmentQuestion.setTreatmentid(treatmentid);
			treatmentQuestion.setQuestion(title);
			treatmentQuestion.setDescription(description);
			treatmentQuestion.setCreateddate(new Date());
			int treatmentQuestionId=postQuestionToPhysicianDAO.newTreatQuestion(treatmentQuestion);
			
			if (treatmentid > 0 && treatmentQuestionId > 0) {
				
				//Image File
				if(imageFile != null){
				
					for (int i = 0; i < imageFile.length; i++) {
						
						MultipartFile files = imageFile[i];
						TreatmentImages treatmentimages=new TreatmentImages();
						treatmentimages.setTreatmentquestionid(treatmentQuestionId);
						treatmentimages.setFilename(files.getOriginalFilename());
						treatmentimages.setCreateddate(new Date());
						treatmentimages.setFiletype(1);//Image is One--1
						treatmentimages.setImgtype(1);
						if(tretstatustypeid == 1){
							treatmentimages.setPhysicianid(physicianid);
						}else{
							treatmentimages.setPhysicianid(null);
						}
						postQuestionToPhysicianDAO.saveTreatmentImages(files,treatmentimages);
					}
				}
				
				//Audio
				if(audioFile != null){
					
					for (int i = 0; i < audioFile.length; i++) {
						
						MultipartFile afiles = audioFile[i];
						TreatmentImages treatmentimages=new TreatmentImages();
						treatmentimages.setTreatmentquestionid(treatmentQuestionId);
						treatmentimages.setFilename(afiles.getOriginalFilename());
						treatmentimages.setCreateddate(new Date());
						treatmentimages.setFiletype(2);//Audio is Two--2
						treatmentimages.setImgtype(1);
						if(tretstatustypeid == 1){
							treatmentimages.setPhysicianid(physicianid);
						}else{
							treatmentimages.setPhysicianid(null);
						}
						postQuestionToPhysicianDAO.saveTreatmentAudioFile(afiles, treatmentimages);
					}
				}
				
				//Video 
				if(videoFile != null){
					
					for (int i = 0; i < videoFile.length; i++) {
						
						MultipartFile vfiles = videoFile[i];
						System.out.println("vfiles.getSize()------"+vfiles.getSize());
						TreatmentImages treatmentimages=new TreatmentImages();
						treatmentimages.setTreatmentquestionid(treatmentQuestionId);
						treatmentimages.setFilename(vfiles.getOriginalFilename());
						treatmentimages.setCreateddate(new Date());
						treatmentimages.setFiletype(3);//Video is Three--3
						treatmentimages.setImgtype(1);
						if(tretstatustypeid == 1){
							treatmentimages.setPhysicianid(physicianid);
						}else{
							treatmentimages.setPhysicianid(null);
						}
							
						postQuestionToPhysicianDAO.saveTreatmentVideoFile(vfiles,treatmentimages);
						
					}
				}
				
			}
			else
			{
				statusObj.setError(true);
				statusObj.setMessage(getMessage("post.questionto.physician.failure.message"));
				return statusObj;
			}
			if (treatmentid > 0 && treatmentQuestionId > 0) {

				statusObj.setError(false);
				statusObj.setMessage(getMessage("post.questionto.physician.success.message"));
				
				if(tretstatustypeid == 1){
					physicianNotificationService.notifyPhysicianIndividualQuestionPosted(patientid,physicianid,treatmentQuestionId);
				}else{
					physicianNotificationService.notifyPhysicianGroupQuestionPosted(patientid,specialityid,treatmentQuestionId);
				}
				
				return statusObj;
			}
		}
		statusObj.setError(true);
		statusObj.setMessage(getMessage("post.questionto.physician.failure.message"));
		return statusObj;
	}
	
}
