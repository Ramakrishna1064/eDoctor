/**
 * 
 */
package com.ensis.mediguru.service.physician;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensis.mediguru.dao.physician.PhysicianScheduleDAO;
import com.ensis.mediguru.models.PatientBasicInfoModel;
import com.ensis.mediguru.models.PatientOngoingTreatmentQueAndPhysiciansModel;
import com.ensis.mediguru.models.PatientPhysicianReplyAnswerModel;
import com.ensis.mediguru.models.PhysicianOngoingScheduleModel;
import com.ensis.mediguru.models.PhysicianSchedulesModel;
import com.ensis.mediguru.models.StatusObject;
import com.ensis.mediguru.utils.MessageResources;
import com.ensis.mediguru.utils.Utilities;
//import com.sun.deploy.uitoolkit.impl.fx.ui.UITextArea;

/**
 * @author Venu
 *
 */
@Service
public class PhysicianScheduleService extends MessageResources{

	@Autowired
	PhysicianScheduleDAO physicianScheduleDAO;
	
	/**
	 * @param physicianScheduleDAO the physicianScheduleDAO to set
	 */
	public void setPhysicianScheduleDAO(PhysicianScheduleDAO physicianScheduleDAO) {
		this.physicianScheduleDAO = physicianScheduleDAO;
	}


	/**
	 * 
	 * @param physicianId
	 * @return
	 */
	@Transactional
	public ArrayList<PhysicianSchedulesModel> getPhysicianCuurentDaySchedules(int physicianId){
	
		String currentday=Utilities.getCurrentDate();
		ArrayList<PhysicianSchedulesModel> schedulesList=physicianScheduleDAO.
				getPhysicianCuurentDaySchedules(physicianId,currentday);
		for(int i=0;i<schedulesList.size();i++){
			PhysicianSchedulesModel schedulesModel=schedulesList.get(i);
			schedulesModel.setAppointmentDate(Utilities.convertDateFormat(schedulesModel.getScheduledate()));
			if(schedulesModel.getImageurl() != null){
				
				schedulesModel.setImageurl(getMessage("imageUrlPath")+schedulesModel.getImageurl());
			}
			schedulesList.set(i, schedulesModel);
		}
		return schedulesList;
	}
	
	/**
	 * 
	 * @param physicianId
	 * @return
	 */
	@Transactional
	public ArrayList<PhysicianOngoingScheduleModel> getPhysicianSchedules(int physicianId,String date){
		
		ArrayList<PhysicianOngoingScheduleModel> schedulesList=new ArrayList<PhysicianOngoingScheduleModel>();
			
		
		ArrayList<PatientOngoingTreatmentQueAndPhysiciansModel> mainQuestionsList=
				physicianScheduleDAO.getPhysicianSchedules(physicianId,date);
		
		for (int i = 0; i < mainQuestionsList.size(); i++) {

			PatientOngoingTreatmentQueAndPhysiciansModel mainObj = mainQuestionsList.get(i);
			
			
			ArrayList<String> imagesArray=new ArrayList<String>();
			ArrayList<String> audiosArray=new ArrayList<String>();
			ArrayList<String> vidoesArray=new ArrayList<String>();
			
			//Images
			if(mainObj.getQuestionImages() != null){
				
				String[] images=mainObj.getQuestionImages().split(":");
				for(int z=0;z<images.length;z++){
					
					imagesArray.add(getMessage("imageUrlPath")+ images[z]);
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
			
			//Root
			PhysicianOngoingScheduleModel questionsObj = new PhysicianOngoingScheduleModel();
			questionsObj.setTreatmentquestionid(mainObj.getTreatmentquestionid());
		    questionsObj.setQuestiontypeid(mainObj.getQuestiontypeid());
		    //questionsObj.setTreatmenttypeid(mainObj.getTreatmenttypeid());
			questionsObj.setQuestion(mainObj.getQuestion());
			questionsObj.setDescription(mainObj.getDescription());
			questionsObj.setCreateddate(""+mainObj.getCreateddate());
			questionsObj.setScheduledate(""+mainObj.getScheduledate());
			questionsObj.setScheduletype(mainObj.getScheduletype());
			questionsObj.setScheduletypeid(mainObj.getScheduletypeid());
			questionsObj.setTreatmentid(mainObj.getTreatmentid());
			questionsObj.setAppointmentstatus(mainObj.getAppointmentstatus());
			
			//Patient Info
			PatientBasicInfoModel physicianOngoingBasicInfo=new PatientBasicInfoModel();
			physicianOngoingBasicInfo.setPatientid(mainObj.getPatientid());
			physicianOngoingBasicInfo.setFirstname(mainObj.getFirstname());
			physicianOngoingBasicInfo.setLastname(mainObj.getLastname());
			physicianOngoingBasicInfo.setDob(mainObj.getDob());
			physicianOngoingBasicInfo.setAddress1(mainObj.getAddress1());
			physicianOngoingBasicInfo.setAddress2(mainObj.getAddress2());
			physicianOngoingBasicInfo.setCity(mainObj.getCity());
			physicianOngoingBasicInfo.setState(mainObj.getState());
			physicianOngoingBasicInfo.setCountry(mainObj.getCountry());
			physicianOngoingBasicInfo.setZip(mainObj.getZip());
			
			
			if(mainObj.getImageUrl() != null){
				physicianOngoingBasicInfo.setImageUrl(getMessage("imageUrlPath")+mainObj.getImageUrl());
			}
			
			questionsObj.setPatientInfo(physicianOngoingBasicInfo);			
			//Image URL
			questionsObj.setImageUrls(imagesArray);		
			//Audio URL
			questionsObj.setAudioUrls(audiosArray);
			//Video URL
			questionsObj.setVideoUrls(vidoesArray);
			schedulesList.add(questionsObj);
		}
		
		// Sort By Question Id
		Collections.sort(schedulesList,	Utilities.soryByPhysicianOngoingTreatemntQues);
		return schedulesList;	
	}
	
	/**
	 * 
	 * @param patientPhysicianReplyAnswerModel
	 * @return
	 */
	@Transactional
	public StatusObject rescheduleAppointment(PatientPhysicianReplyAnswerModel patientPhysicianReplyAnswerModel){
		
		StatusObject statusObject=new StatusObject();
		if(patientPhysicianReplyAnswerModel != null){
			
			
			
			boolean status=physicianScheduleDAO.rescheduleAppointment(patientPhysicianReplyAnswerModel);
			if(status){
				statusObject.setError(false);
				statusObject.setMessage(getMessage("appointment.rescheduled.success"));
				return statusObject;
			}else{
				statusObject.setError(true);
				statusObject.setMessage(getMessage("appointment.rescheduled.error"));
				return statusObject;
			}
		}else{
			statusObject.setError(true);
			statusObject.setMessage(getMessage("appointment.rescheduled.error"));
			return statusObject;
		}
	}
}
