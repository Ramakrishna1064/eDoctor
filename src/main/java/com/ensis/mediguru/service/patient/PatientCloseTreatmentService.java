package com.ensis.mediguru.service.patient;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensis.mediguru.dao.patient.PatientCloseTreatmentDAO;
import com.ensis.mediguru.dao.patient.PatientQuestionsDAO;
import com.ensis.mediguru.dto.PhysicianReview;
import com.ensis.mediguru.models.PatientCloseTreatmentModel;
import com.ensis.mediguru.models.PatientClosedTreatmentModel;
import com.ensis.mediguru.models.PatientClosedTreatmentQueAndPhysiciansModel;
import com.ensis.mediguru.models.PhysicianOngoingBasicInfo;
import com.ensis.mediguru.models.StatusObject;
import com.ensis.mediguru.service.physician.PhysicianNotificationService;
import com.ensis.mediguru.utils.MessageResources;
import com.ensis.mediguru.utils.Utilities;
import com.ensis.vo.models.VideoURLModel;

@Service
public class PatientCloseTreatmentService extends MessageResources {

	@Autowired
	PatientCloseTreatmentDAO patientCloseTreatmentDAO;

	@Autowired
	PatientQuestionsDAO patientQuestionsDAO;
	
	@Autowired
	PhysicianNotificationService physicianNotificationService;

	/**
	 * @param patientQuestionsDAO the patientQuestionsDAO to set
	 */
	public void setPatientQuestionsDAO(PatientQuestionsDAO patientQuestionsDAO) {
		this.patientQuestionsDAO = patientQuestionsDAO;
	}

	/**
	 * @param physicianNotificationService the physicianNotificationService to set
	 */
	public void setPhysicianNotificationService(
			PhysicianNotificationService physicianNotificationService) {
		this.physicianNotificationService = physicianNotificationService;
	}

	public void setPatientCloseTreatmentDAO(
			PatientCloseTreatmentDAO patientCloseTreatmentDAO) {
		this.patientCloseTreatmentDAO = patientCloseTreatmentDAO;
	}

	/**
	 * 
	 * @param patientCloseTreatmentModel
	 * @return
	 */
	@Transactional
	public StatusObject patientCloseTreatment(
			PatientCloseTreatmentModel patientCloseTreatmentModel)

	{
		StatusObject statusObject = new StatusObject();
		if (patientCloseTreatmentModel != null) {
			int treatmentid = patientCloseTreatmentModel.getTreatmentid();
			int response = patientCloseTreatmentDAO.closeTreatment(treatmentid);
			if (response == 1) {
				int physicianid = patientCloseTreatmentModel.getPhysicianid();
				String title = patientCloseTreatmentModel.getTitle();
				String comment = patientCloseTreatmentModel.getComment();
				Double rating = patientCloseTreatmentModel.getRating();
				
				//Construct the Physician Review Model -- Venu Modified
				PhysicianReview phyreview = new PhysicianReview();
				phyreview.setPhysicianid(physicianid);
				phyreview.setPatientid(patientCloseTreatmentModel.getPatientid());
				phyreview.setTitle(title);
				phyreview.setComment(comment);
				phyreview.setRating(rating);
				phyreview.setCreateddate(new Date());
				
				System.out.println("---->"+patientCloseTreatmentModel.getPatientid());

				//Save the  Physician Review Model -- Venu Modified
				boolean respone = patientCloseTreatmentDAO.savePhysicinaReview(phyreview);

				if (respone) {
					statusObject.setError(false);
					statusObject
							.setMessage(getMessage("patient.close.treatment.success.message"));
					
					physicianNotificationService.notifyCloseTreatment(patientCloseTreatmentModel.getPatientid(),
							patientCloseTreatmentModel.getPhysicianid(),
							patientCloseTreatmentModel.getTreatmentid());
					
					return statusObject;
				}

			}// Treatment already closed
			else if (response == 2) {
				statusObject.setError(false);
				statusObject
						.setMessage(getMessage("patient.close.treatment.already.closed"));
				return statusObject;

			}// Treatment does not exist
			else if (response == 3) {
				statusObject.setError(false);
				statusObject
						.setMessage(getMessage("patient.close.treatment.failure.message"));
				return statusObject;
			}

		}

		return statusObject;
	}

	/**
	 * 
	 * @param patientId
	 * @return
	 */
	@Transactional
	public ArrayList<PatientClosedTreatmentModel> getClosedTreatment(
			int patientId) {
		// TODO Auto-generated method stub

		ArrayList<PatientClosedTreatmentQueAndPhysiciansModel> mainQuestionsList = patientQuestionsDAO
				.getPatientClosedTreatment(patientId);

		ArrayList<PatientClosedTreatmentModel> patientClosedQuestionsList = new ArrayList<PatientClosedTreatmentModel>();

		for (int i = 0; i < mainQuestionsList.size(); i++) {

			PatientClosedTreatmentQueAndPhysiciansModel mainObj = mainQuestionsList
					.get(i);

			ArrayList<String> imagesArray = new ArrayList<String>();
			ArrayList<String> audiosArray=new ArrayList<String>();
			ArrayList<String> vidoesArray=new ArrayList<String>();
			ArrayList<String> thubsarrayArray=new ArrayList<String>();
			
			//Images
			if (mainObj.getQuestionImages() != null) {

				String[] images = mainObj.getQuestionImages().split(":");
				for (int z = 0; z < images.length; z++) {

					imagesArray.add(getMessage("imageUrlPath") + images[z]);
				}
			}
			//Audio
			if(mainObj.getQuestionAudios() != null){
				
				String[] audios=mainObj.getQuestionAudios().split(":");
				for(int z=0;z<audios.length;z++){
					
					audiosArray.add(getMessage("audioUrlPath")+ audios[z]);
				}
			}
			
			//Videos
			if(mainObj.getQuestionVideos() != null){
				
				String[] videos=mainObj.getQuestionVideos().split(":");
				for(int z=0;z<videos.length;z++){
					
					vidoesArray.add(getMessage("videoUrlPath")+ videos[z]);
				}
			}
			
			
			//Thumbnail
			if(mainObj.getThumbnail()!= null){
				
				String[] thumbnail=mainObj.getThumbnail().split(":");
				for(int z=0;z<thumbnail.length;z++){
					
					thubsarrayArray.add(getMessage("imageUrlPath")+ thumbnail[z]);
				}
			}
			
			ArrayList<VideoURLModel> videoWithThumnailList=new ArrayList<VideoURLModel>();
			
			if(vidoesArray.size() == thubsarrayArray.size()){
				
				for(int x=0;x<vidoesArray.size();x++){
					
					VideoURLModel videoURLModel=new VideoURLModel();
					videoURLModel.setThumbnail(thubsarrayArray.get(x));
					videoURLModel.setVideoUrl(vidoesArray.get(x));
					videoWithThumnailList.add(videoURLModel);
				}
			}

			PatientClosedTreatmentModel closeTreatObj = new PatientClosedTreatmentModel();
			closeTreatObj.setTreatmentid(mainObj.getTreatmentid());
			closeTreatObj.setTreatmentquestionid(mainObj
					.getTreatmentquestionid());
			closeTreatObj.setTreatmenttypeid(mainObj.getTreatmenttypeid());
			closeTreatObj.setQuestion(mainObj.getQuestion());
			closeTreatObj.setDescription(mainObj.getDescription());
			closeTreatObj.setCreateddate("" + mainObj.getCreateddate());
			closeTreatObj.setQuestiontypeid(mainObj.getQuestiontypeid());
			// closeTreatObj.setTreatmentid(mainObj.getTreatmenttypeid());
			 //Image URL
			closeTreatObj.setImageUrls(imagesArray);		
			//Audio URL
			closeTreatObj.setAudioUrls(audiosArray);
			//Video URL
			closeTreatObj.setVideoUrls(videoWithThumnailList);

			// Physician Info
			PhysicianOngoingBasicInfo physicianOngoingBasicInfo = new PhysicianOngoingBasicInfo();
			physicianOngoingBasicInfo.setFirstname(mainObj.getFirstname());
			physicianOngoingBasicInfo.setLastname(mainObj.getLastname());
			physicianOngoingBasicInfo.setPhysicianid(mainObj.getPhysicianid());
			physicianOngoingBasicInfo.setDob(mainObj.getDob());
			physicianOngoingBasicInfo.setAddress1(mainObj.getAddress1());
			physicianOngoingBasicInfo.setAddress2(mainObj.getAddress2());
			physicianOngoingBasicInfo.setCity(mainObj.getCity());
			physicianOngoingBasicInfo.setState(mainObj.getState());
			physicianOngoingBasicInfo.setCountry(mainObj.getCountry());
			physicianOngoingBasicInfo.setZip(mainObj.getZip());
			physicianOngoingBasicInfo.setAbout(mainObj.getAbout());
			physicianOngoingBasicInfo.setMobile(mainObj.getMobile());
			physicianOngoingBasicInfo.setOfficephone(mainObj.getOfficephone());
			if(mainObj.getRating() != null){
				
				physicianOngoingBasicInfo.setRating(Utilities.getTwoDigitDoubleValue(mainObj.getRating()));
			}

			if (mainObj.getPhysiciantypeid() != null) {

				if (mainObj.getPhysiciantypeid().contains(",")) {

					String[] groupPhysicians = mainObj.getPhysiciantypeid()
							.split(",");
					for (int k = 0; k < groupPhysicians.length; k++) {

						int physicianTypeId = Integer
								.parseInt(groupPhysicians[k]);
						if (physicianTypeId == 1) {
							// Favorite
							physicianOngoingBasicInfo
									.setFavoritePhysician(true);
						} else if (physicianTypeId == 2) {
							// 2. Family
							physicianOngoingBasicInfo.setFamilyPhysician(true);
						} else if (physicianTypeId == 3) {
							// 3. Ongoing
							physicianOngoingBasicInfo.setOngoingPhysician(true);
						}
					}

				} else {

					int physicianTypeId = Integer.parseInt(mainObj
							.getPhysiciantypeid());
					if (physicianTypeId == 1) {
						// Favorite
						physicianOngoingBasicInfo.setFavoritePhysician(true);
					} else if (physicianTypeId == 2) {
						// 2. Family
						physicianOngoingBasicInfo.setFamilyPhysician(true);
					} else if (physicianTypeId == 3) {
						// Ongoing
						physicianOngoingBasicInfo.setOngoingPhysician(true);
					}
				}
			}

			if(mainObj.getFirstvisitfee() != null){
				physicianOngoingBasicInfo.setFirstvisitfee(mainObj.getFirstvisitfee());
			}
			
			if(mainObj.getFollowupvisitfee() != null){
				physicianOngoingBasicInfo.setFollowupvisitfee(mainObj.getFollowupvisitfee());
			}
			
			
			if (mainObj.getImageUrl() != null) {
				physicianOngoingBasicInfo
						.setImageUrl(getMessage("imageUrlPath")
								+ mainObj.getImageUrl());
			}

			if(mainObj.getIsInpersonAppointment() != null){
				physicianOngoingBasicInfo.setIsInpersonAppointment(mainObj.getIsInpersonAppointment());
			}
			
			if(mainObj.getIsVirtualPhoneAppointment() != null){
				physicianOngoingBasicInfo.setIsVirtualPhoneAppointment(mainObj.getIsVirtualPhoneAppointment());
			}
			
			if(mainObj.getIsVirtualSkypeAppointment() != null){
				physicianOngoingBasicInfo.setIsVirtualSkypeAppointment(mainObj.getIsVirtualSkypeAppointment());
			}
			
			
			physicianOngoingBasicInfo.setSpeciality(mainObj.getSpeciality());
			physicianOngoingBasicInfo.setSpecialitytype(mainObj.getSpecialitytype());

			closeTreatObj.setPhysicianInfo(physicianOngoingBasicInfo);

			if (patientClosedQuestionsList.size() == 0) {

				patientClosedQuestionsList.add(closeTreatObj);

			} else {

				boolean isTreatmentquestionIdAdded = false;
				for (int j = 0; j < patientClosedQuestionsList.size(); j++) {

					if (patientClosedQuestionsList.get(j)
							.getTreatmentquestionid() == mainObj
							.getTreatmentquestionid()) {
						isTreatmentquestionIdAdded = true;
					}
				}
				if (!isTreatmentquestionIdAdded) {
					patientClosedQuestionsList.add(closeTreatObj);
				}
			}

		}
		return patientClosedQuestionsList;
	}

	@Transactional
	public StatusObject openClosedTreatment(int treatmentid) {
		StatusObject obj = new StatusObject();
		int response = patientCloseTreatmentDAO
				.openclosedTreatment(treatmentid);
		if (response == 1) {
			obj.setError(false);
			obj.setMessage(getMessage("patient.open.closed.treatment.success.message"));
			return obj;
		}// Treatment already opened
		else if (response == 2) {
			obj.setError(false);
			obj.setMessage(getMessage("patient.open.closed.treatment.already.opened"));
			return obj;

		}// Treatment does not exist
		else if (response == 3) {
			obj.setError(false);
			obj.setMessage(getMessage("patient.open.closed.treatment.failure.message"));
			return obj;
		}

		return obj;
	}
}
