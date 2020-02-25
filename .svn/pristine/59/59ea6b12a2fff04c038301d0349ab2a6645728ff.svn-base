/**
 * 
 */
package com.ensis.mediguru.service.physician;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensis.mediguru.dao.physician.PhysicianTreatmentQuestionReminderDAO;
import com.ensis.mediguru.dto.TreatmentQuestionReminderDTO;
import com.ensis.mediguru.models.PatientBasicInfoModel;
import com.ensis.mediguru.models.PhysicianQuestionsReminderGetModel;
import com.ensis.mediguru.models.PhysicianQuestionsReminderViewModel;
import com.ensis.mediguru.models.StatusObject;
import com.ensis.mediguru.models.TreatmentReminderModel;
import com.ensis.mediguru.utils.MessageResources;
import com.ensis.mediguru.utils.Utilities;
import com.ensis.vo.models.VideoURLModel;

/**
 * @author Venu
 *
 */
@Service
public class PhysicianTreatmentQuestionReminderService extends MessageResources {

	@Autowired
	PhysicianTreatmentQuestionReminderDAO phyciPhysicianTreatmentQuestionReminderDAO;

	/**
	 * @param phyciPhysicianTreatmentQuestionReminderDAO
	 *            the phyciPhysicianTreatmentQuestionReminderDAO to set
	 */
	public void setPhyciPhysicianTreatmentQuestionReminderDAO(
			PhysicianTreatmentQuestionReminderDAO phyciPhysicianTreatmentQuestionReminderDAO) {
		this.phyciPhysicianTreatmentQuestionReminderDAO = phyciPhysicianTreatmentQuestionReminderDAO;
	}

	/**
	 * 
	 * @param treatmentReminderModel
	 * @return
	 */
	@Transactional
	public StatusObject saveTreatmentReminder(TreatmentReminderModel treatmentReminderModel) {

		StatusObject statusObject = new StatusObject();
		if (treatmentReminderModel != null) {

			TreatmentQuestionReminderDTO treatmentQuestionReminderDTO = new TreatmentQuestionReminderDTO();
			treatmentQuestionReminderDTO.setPhysicianid(treatmentReminderModel.getPhysicianid());
			treatmentQuestionReminderDTO.setTreatmentquestionid(treatmentReminderModel.getTreatmentquestionid());
			treatmentQuestionReminderDTO.setComments(treatmentReminderModel.getComments());
			treatmentQuestionReminderDTO
					.setReminderdate((Utilities.getDateAndTimeFormat(treatmentReminderModel.getReminderdate()))); // Reminder
																													// Date
			treatmentQuestionReminderDTO.setIsdeleted(false);
			treatmentQuestionReminderDTO.setIsremindercompleted(false);
			treatmentQuestionReminderDTO.setReschedulecount(0);
			treatmentQuestionReminderDTO.setCreatedby("Physician");
			treatmentQuestionReminderDTO.setCreateddate(new Date());
			boolean status = phyciPhysicianTreatmentQuestionReminderDAO
					.saveTreatmentQuerstionReminder(treatmentQuestionReminderDTO);
			if (status) {
				statusObject.setError(false);
				statusObject.setMessage(getMessage("treatment.question.reminder.success"));
				return statusObject;
			} else {
				statusObject.setError(true);
				statusObject.setMessage(getMessage("treatment.question.reminder.failure"));
				return statusObject;
			}

		} else {
			statusObject.setError(true);
			statusObject.setMessage(getMessage("treatment.question.reminder.failure"));
			return statusObject;
		}
	}

	/**
	 * 
	 * @param physicianid
	 * @param date
	 * @return
	 */
	@Transactional
	public ArrayList<PhysicianQuestionsReminderViewModel> getPhysicianReminders(int physicianid, String date) {

		ArrayList<PhysicianQuestionsReminderGetModel> remindersList = phyciPhysicianTreatmentQuestionReminderDAO
				.getQuestionReminders(physicianid, date);

		ArrayList<PhysicianQuestionsReminderViewModel> currentRemindersList = new ArrayList<PhysicianQuestionsReminderViewModel>();

		if (remindersList != null) {

			for (PhysicianQuestionsReminderGetModel obj : remindersList) {

				PhysicianQuestionsReminderViewModel reminderObj = new PhysicianQuestionsReminderViewModel();
				reminderObj.setTreatmentquestionid(obj.getTreatmentquestionid());
				reminderObj.setQuestiontypeid(obj.getQuestiontypeid());
				reminderObj.setCreateddate("" + obj.getCreateddate());
				reminderObj.setReminderdate("" + obj.getReminderdate());
				reminderObj.setQuestion(obj.getQuestion());
				reminderObj.setDescription(obj.getDescription());
				reminderObj.setRemindernote(obj.getRemindernote());
				reminderObj.setPatientid(obj.getPatientid());
				reminderObj.setPhysicianid(obj.getPhysicianid());
				reminderObj.setIsremindercompleted(obj.isIsremindercompleted());

				ArrayList<String> imagesArray = new ArrayList<String>();
				ArrayList<String> audiosArray = new ArrayList<String>();
				ArrayList<String> vidoesArray = new ArrayList<String>();
				ArrayList<String> thubsarrayArray=new ArrayList<String>();

				// Image URL's
				if (obj.getQuestionImages() != null) {

					String[] images = obj.getQuestionImages().split(":");
					for (int z = 0; z < images.length; z++) {

						imagesArray.add(getMessage("imageUrlPath") + images[z]);
					}
				}

				// Audio
				if (obj.getQuestionAudios() != null) {

					String[] audios = obj.getQuestionAudios().split(":");
					for (int z = 0; z < audios.length; z++) {

						audiosArray.add(getMessage("audioUrlPath") + audios[z]);
					}
				}

				// Videos
				if (obj.getQuestionVideos() != null) {

					String[] videos = obj.getQuestionVideos().split(":");
					for (int z = 0; z < videos.length; z++) {

						vidoesArray.add(getMessage("videoUrlPath") + videos[z]);
					}
				}
				
				//Thumbnail
				if(obj.getThumbnail()!= null){
					
					String[] thumbnail=obj.getThumbnail().split(":");
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

				// Image URL
				reminderObj.setQuestionImages(imagesArray);
				// Audio URL
				reminderObj.setAudioUrls(audiosArray);
				// Video URL
				reminderObj.setVideoUrls(videoWithThumnailList);

				PatientBasicInfoModel patientBasicInfoModel = new PatientBasicInfoModel();
				patientBasicInfoModel.setFirstname(obj.getFirstname());
				patientBasicInfoModel.setLastname(obj.getLastname());
				patientBasicInfoModel.setAddress1(obj.getAddress1());
				patientBasicInfoModel.setAddress2(obj.getAddress2());
				patientBasicInfoModel.setCity(obj.getCity());
				patientBasicInfoModel.setState(obj.getState());
				patientBasicInfoModel.setCountry(obj.getCountry());
				patientBasicInfoModel.setDob(obj.getDob());
				patientBasicInfoModel.setZip(obj.getZip());
				if (obj.getImageUrl() != null) {
					patientBasicInfoModel.setImageUrl(getMessage("imageUrlPath") + obj.getImageUrl());
				}
				reminderObj.setPatientInfo(patientBasicInfoModel);

				currentRemindersList.add(reminderObj);
			}
		}
		return currentRemindersList;
	}

	/**
	 * 
	 * @param treatmentReminderModel
	 * @return
	 */
	@Transactional
	public StatusObject deleteReminder(TreatmentReminderModel treatmentReminderModel) {

		try {

			if (treatmentReminderModel != null) {

				TreatmentQuestionReminderDTO reminderObj = phyciPhysicianTreatmentQuestionReminderDAO.getReminderObj(
						treatmentReminderModel.getPhysicianid(), treatmentReminderModel.getTreatmentquestionid());

				if (reminderObj != null) {

					if (reminderObj.isIsdeleted()) {

						StatusObject statusObject = new StatusObject();
						statusObject.setError(true);
						statusObject.setMessage(getMessage("reminder.deleted.already"));
						return statusObject;

					} else {
						reminderObj.setIsdeleted(true);
						boolean status = phyciPhysicianTreatmentQuestionReminderDAO.updateReminderObj(reminderObj);
						if (status) {

							StatusObject statusObject = new StatusObject();
							statusObject.setError(false);
							statusObject.setMessage(getMessage("reminder.delete.success"));
							return statusObject;
						} else {

							StatusObject statusObject = new StatusObject();
							statusObject.setError(true);
							statusObject.setMessage(getMessage("reminder.delete.error"));
							return statusObject;
						}
					}

				} else {

					StatusObject statusObject = new StatusObject();
					statusObject.setError(true);
					statusObject.setMessage(getMessage("reminder.delete.error"));
					return statusObject;
				}
			} else {
				StatusObject statusObject = new StatusObject();
				statusObject.setError(true);
				statusObject.setMessage(getMessage("reminder.delete.error"));
				return statusObject;
			}

		} catch (Throwable e) {
			// TODO: handle exception
			StatusObject statusObject = new StatusObject();
			statusObject.setError(true);
			statusObject.setMessage(getMessage("reminder.delete.error"));
			return statusObject;
		}
	}
	
	/**
	 * 
	 * @param treatmentReminderModel
	 * @return
	 */
	@Transactional
	public StatusObject rescheduleReminder(TreatmentReminderModel treatmentReminderModel) {

		StatusObject statusObject = new StatusObject();
		if (treatmentReminderModel != null) {
			
			TreatmentQuestionReminderDTO reminderObj = phyciPhysicianTreatmentQuestionReminderDAO.getReminderObj(
					treatmentReminderModel.getPhysicianid(), treatmentReminderModel.getTreatmentquestionid());
			
			if(reminderObj != null){
				
				if(treatmentReminderModel.getComments() != null){
					reminderObj.setComments(treatmentReminderModel.getComments());
				}
				
				if(treatmentReminderModel.getReminderdate() != null){
					reminderObj.setReminderdate((Utilities.getDateAndTimeFormat(
							treatmentReminderModel.getReminderdate()))); // Reminder Date
				}
				
				reminderObj.setIsdeleted(false);
				reminderObj.setIsremindercompleted(false);
				int count=reminderObj.getReschedulecount()+1;
				reminderObj.setReschedulecount(count);
				boolean status = phyciPhysicianTreatmentQuestionReminderDAO.updateReminderObj(reminderObj);																		
				
				if (status) {
					statusObject.setError(false);
					statusObject.setMessage(getMessage("reminder.reschedule.sucess"));
					return statusObject;
				} else {
					statusObject.setError(true);
					statusObject.setMessage(getMessage("reminder.reschedule.error"));
					return statusObject;
				}
				
			}else{
				
				statusObject.setError(true);
				statusObject.setMessage(getMessage("reminder.reschedule.error"));
				return statusObject;
			}

		} else {
			statusObject.setError(true);
			statusObject.setMessage(getMessage("treatment.question.reminder.failure"));
			return statusObject;
		}
	}
	
	/**
	 * 
	 * @param treatmentReminderModel
	 * @return
	 */
	@Transactional
	public StatusObject completeReminder(TreatmentReminderModel treatmentReminderModel) {

		StatusObject statusObject = new StatusObject();
		if (treatmentReminderModel != null) {
			
			TreatmentQuestionReminderDTO reminderObj = phyciPhysicianTreatmentQuestionReminderDAO.getReminderObj(
					treatmentReminderModel.getPhysicianid(), treatmentReminderModel.getTreatmentquestionid());
			
			if(reminderObj != null){
						
				if(reminderObj.isIsremindercompleted()){
					
					statusObject.setError(true);
					statusObject.setMessage(getMessage("reminder.completed.alreay"));
					return statusObject;
					
				}else{
				
					reminderObj.setIsremindercompleted(true);
					boolean status = phyciPhysicianTreatmentQuestionReminderDAO.updateReminderObj(reminderObj);																		
					
					if (status) {
						statusObject.setError(false);
						statusObject.setMessage(getMessage("reminder.completed.success"));
						return statusObject;
					} else {
						statusObject.setError(true);
						statusObject.setMessage(getMessage("reminder.completed.error"));
						return statusObject;
					}
				}
				
			}else{
				
				statusObject.setError(true);
				statusObject.setMessage(getMessage("reminder.completed.error"));
				return statusObject;
			}

		} else {
			statusObject.setError(true);
			statusObject.setMessage(getMessage("reminder.completed.error"));
			return statusObject;
		}
	}
}
