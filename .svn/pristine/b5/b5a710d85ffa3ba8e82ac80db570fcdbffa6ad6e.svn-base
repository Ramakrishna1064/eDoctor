/**
 * 
 */
package com.ensis.mediguru.service.physician;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensis.mediguru.dao.common.CommonDAO;
import com.ensis.mediguru.dao.physician.PhysicianQuestionsDAO;
import com.ensis.mediguru.dao.physician.PhysicianScheduleDAO;
import com.ensis.mediguru.dto.PhysicianDeletedQuestionsDTO;
import com.ensis.mediguru.dto.PhysicianScheduleDTO;
import com.ensis.mediguru.dto.TreatmentAnswersDTO;
import com.ensis.mediguru.models.PatientBasicInfoModel;
import com.ensis.mediguru.models.PatientPhysicianReplyAnswerModel;
import com.ensis.mediguru.models.PhyPatQuesAnsReplyModel;
import com.ensis.mediguru.models.PhysicianQuestionsAndAnswersModel;
import com.ensis.mediguru.models.QuestionsAnswersAndReplyAnswersModel;
import com.ensis.mediguru.models.QuestionsAnswersDetailModel;
import com.ensis.mediguru.models.StatusObject;
import com.ensis.mediguru.service.patient.PatientNotificationService;
import com.ensis.mediguru.service.patient.PatientQuestionsService;
import com.ensis.mediguru.utils.MessageResources;
import com.ensis.mediguru.utils.Utilities;
import com.ensis.vo.models.VideoURLModel;

/**
 * @author Venu
 *
 */
@Service
public class PhysicianQuestionsService extends MessageResources {

	@Autowired
	PhysicianQuestionsDAO physicianQuestionsDAO;

	@Autowired
	PhysicianScheduleDAO physicianScheduleDAO;

	@Autowired
	CommonDAO commonDAO;

	@Autowired
	PatientNotificationService patientNotificationService;

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
	 * @param patientNotificationService
	 *            the patientNotificationService to set
	 */
	public void setPatientNotificationService(
			PatientNotificationService patientNotificationService) {
		this.patientNotificationService = patientNotificationService;
	}

	/**
	 * @param physicianQuestionsDAO
	 *            the physicianQuestionsDAO to set
	 */
	public void setPhysicianQuestionsDAO(
			PhysicianQuestionsDAO physicianQuestionsDAO) {
		this.physicianQuestionsDAO = physicianQuestionsDAO;
	}

	/**
	 * @param physicianScheduleDAO
	 *            the physicianScheduleDAO to set
	 */
	public void setPhysicianScheduleDAO(
			PhysicianScheduleDAO physicianScheduleDAO) {
		this.physicianScheduleDAO = physicianScheduleDAO;
	}

	/**
	 * @param commonDAO
	 *            the commonDAO to set
	 */
	public void setCommonDAO(CommonDAO commonDAO) {
		this.commonDAO = commonDAO;
	}

	/**
	 * 
	 * @param physicianid
	 * @return
	 */
	@Transactional
	public ArrayList<PhysicianQuestionsAndAnswersModel> getPhysicianQuestions(
			int physicianid) {

		ArrayList<QuestionsAnswersAndReplyAnswersModel> physicianQuestionsAndAnswersList = physicianQuestionsDAO
				.getPhysicianIndividualQuestions(physicianid);

		return processQuestionsLits(physicianQuestionsAndAnswersList);
	}

	/**
	 * 
	 * @param physicianid
	 * @param treatmentquestionid
	 * @return
	 */
	@Transactional
	public PhysicianQuestionsAndAnswersModel getPhysicianTreatmentDetails(
			int physicianid, int treatmentquestionid) {

		QuestionsAnswersAndReplyAnswersModel physicianQuestionsAndAnswersList = physicianQuestionsDAO
				.getPhysicianTreatmentDetails(physicianid, treatmentquestionid);

		return processTreatmentDetails(physicianQuestionsAndAnswersList);
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<PhysicianQuestionsAndAnswersModel> processQuestionsLits(
			ArrayList<QuestionsAnswersAndReplyAnswersModel> physicianQuestionsAndAnswersList) {

		ArrayList<PhysicianQuestionsAndAnswersModel> questionsList = new ArrayList<PhysicianQuestionsAndAnswersModel>();

		for (int i = 0; i < physicianQuestionsAndAnswersList.size(); i++) {

			QuestionsAnswersAndReplyAnswersModel mainObj = physicianQuestionsAndAnswersList
					.get(i);

			ArrayList<String> imagesArray = new ArrayList<String>();
			ArrayList<String> audiosArray = new ArrayList<String>();
			ArrayList<String> vidoesArray = new ArrayList<String>();
			ArrayList<String> thubsarrayArray = new ArrayList<String>();

			if (mainObj.getQuestionImages() != null) {

				String[] images = mainObj.getQuestionImages().split(":");
				for (int z = 0; z < images.length; z++) {

					imagesArray.add(getMessage("imageUrlPath") + images[z]);
				}
			}

			// Audio
			if (mainObj.getQuestionAudios() != null) {

				String[] audios = mainObj.getQuestionAudios().split(":");
				for (int z = 0; z < audios.length; z++) {

					audiosArray.add(getMessage("audioUrlPath") + audios[z]);
				}
			}

			// Videos
			if (mainObj.getQuestionVideos() != null) {

				String[] videos = mainObj.getQuestionVideos().split(":");
				for (int z = 0; z < videos.length; z++) {

					vidoesArray.add(getMessage("videoUrlPath") + videos[z]);
				}
			}

			// Thumbnail
			if (mainObj.getThumbnail() != null) {

				String[] thumbnail = mainObj.getThumbnail().split(":");
				for (int z = 0; z < thumbnail.length; z++) {

					thubsarrayArray.add(getMessage("imageUrlPath")
							+ thumbnail[z]);
				}
			}

			ArrayList<VideoURLModel> videoWithThumnailList = new ArrayList<VideoURLModel>();

			if (vidoesArray.size() == thubsarrayArray.size()) {

				for (int x = 0; x < vidoesArray.size(); x++) {

					VideoURLModel videoURLModel = new VideoURLModel();
					videoURLModel.setThumbnail(thubsarrayArray.get(x));
					videoURLModel.setVideoUrl(vidoesArray.get(x));
					videoWithThumnailList.add(videoURLModel);
				}
			}

			PhysicianQuestionsAndAnswersModel questionsObj = new PhysicianQuestionsAndAnswersModel();
			questionsObj.setTreatmentquestionid(mainObj
					.getTreatmentquestionid());
			questionsObj.setTreatmentid(mainObj.getTreatmentid());
			questionsObj.setPatientid(mainObj.getPatientid());
			questionsObj.setPhysicianid(mainObj.getPhysicianid());
			questionsObj.setSpecialitytypeid(mainObj.getSpecialitytypeid());
			questionsObj.setQuestion(mainObj.getQuestion());
			questionsObj.setDescription(mainObj.getDescription());
			questionsObj.setCreateddate("" + mainObj.getCreateddate());
			questionsObj.setQuestiontypeid(mainObj.getQuestiontypeid());
			questionsObj.setTreatmenttypeid(mainObj.getTreatmenttypeid());
			questionsObj.setAppointmentstatus(mainObj.getAppointmentstatus());
			if (mainObj.getReminderdate() != null) {
				questionsObj.setReminderdate("" + mainObj.getReminderdate());
			}

			PatientBasicInfoModel patientBasicInfoModel = new PatientBasicInfoModel();
			patientBasicInfoModel.setFirstname(mainObj.getFirstname());
			patientBasicInfoModel.setLastname(mainObj.getLastname());
			patientBasicInfoModel.setAddress1(mainObj.getAddress1());
			patientBasicInfoModel.setAddress2(mainObj.getAddress2());
			patientBasicInfoModel.setCity(mainObj.getCity());
			patientBasicInfoModel.setState(mainObj.getState());
			patientBasicInfoModel.setCountry(mainObj.getCountry());
			patientBasicInfoModel.setDob(mainObj.getDob());
			patientBasicInfoModel.setZip(mainObj.getZip());
			patientBasicInfoModel.setSkypeid(mainObj.getSkypeid());
			if (mainObj.getImageUrl() != null) {
				patientBasicInfoModel.setImageUrl(getMessage("imageUrlPath")
						+ mainObj.getImageUrl());
			}
			questionsObj.setPatientInfo(patientBasicInfoModel);
			questionsObj.setImageUrls(imagesArray);
			// Audio URL
			questionsObj.setAudioUrls(audiosArray);
			// Video URL
			questionsObj.setVideoUrls(videoWithThumnailList);
			questionsList.add(questionsObj);

		}
		// Sort By Question Id
		Collections.sort(questionsList, Utilities.sortyByTreatmentQuesId);
		return questionsList;
	}

	public PhysicianQuestionsAndAnswersModel processTreatmentDetails(
			QuestionsAnswersAndReplyAnswersModel physicianQuestionsAndAnswersList) {

		

			//QuestionsAnswersAndReplyAnswersModel mainObj = physicianQuestionsAndAnswersList

		
		if(physicianQuestionsAndAnswersList!=null){
			ArrayList<String> imagesArray = new ArrayList<String>();
			ArrayList<String> audiosArray = new ArrayList<String>();
			ArrayList<String> vidoesArray = new ArrayList<String>();
			ArrayList<String> thubsarrayArray = new ArrayList<String>();

			if (physicianQuestionsAndAnswersList.getQuestionImages() != null) {

				String[] images = physicianQuestionsAndAnswersList.getQuestionImages().split(":");
				for (int z = 0; z < images.length; z++) {

					imagesArray.add(getMessage("imageUrlPath") + images[z]);
				}
			}

			// Audio
			if (physicianQuestionsAndAnswersList.getQuestionAudios() != null) {

				String[] audios = physicianQuestionsAndAnswersList.getQuestionAudios().split(":");
				for (int z = 0; z < audios.length; z++) {

					audiosArray.add(getMessage("audioUrlPath") + audios[z]);
				}
			}

			// Videos
			if (physicianQuestionsAndAnswersList.getQuestionVideos() != null) {

				String[] videos = physicianQuestionsAndAnswersList.getQuestionVideos().split(":");
				for (int z = 0; z < videos.length; z++) {

					vidoesArray.add(getMessage("videoUrlPath") + videos[z]);
				}
			}

			// Thumbnail
			if (physicianQuestionsAndAnswersList.getThumbnail() != null) {

				String[] thumbnail = physicianQuestionsAndAnswersList.getThumbnail().split(":");
				for (int z = 0; z < thumbnail.length; z++) {

					thubsarrayArray.add(getMessage("imageUrlPath")
							+ thumbnail[z]);
				}
			}

			ArrayList<VideoURLModel> videoWithThumnailList = new ArrayList<VideoURLModel>();

			if (vidoesArray.size() == thubsarrayArray.size()) {

				for (int x = 0; x < vidoesArray.size(); x++) {

					VideoURLModel videoURLModel = new VideoURLModel();
					videoURLModel.setThumbnail(thubsarrayArray.get(x));
					videoURLModel.setVideoUrl(vidoesArray.get(x));
					videoWithThumnailList.add(videoURLModel);
				}
			}

			PhysicianQuestionsAndAnswersModel questionsObj = new PhysicianQuestionsAndAnswersModel();
			questionsObj.setTreatmentquestionid(physicianQuestionsAndAnswersList
					.getTreatmentquestionid());
			questionsObj.setTreatmentid(physicianQuestionsAndAnswersList.getTreatmentid());
			questionsObj.setPatientid(physicianQuestionsAndAnswersList.getPatientid());
			questionsObj.setPhysicianid(physicianQuestionsAndAnswersList.getPhysicianid());
			questionsObj.setSpecialitytypeid(physicianQuestionsAndAnswersList.getSpecialitytypeid());
			questionsObj.setQuestion(physicianQuestionsAndAnswersList.getQuestion());
			questionsObj.setDescription(physicianQuestionsAndAnswersList.getDescription());
			questionsObj.setCreateddate("" + physicianQuestionsAndAnswersList.getCreateddate());
			questionsObj.setQuestiontypeid(physicianQuestionsAndAnswersList.getQuestiontypeid());
			questionsObj.setTreatmenttypeid(physicianQuestionsAndAnswersList.getTreatmenttypeid());
			questionsObj.setAppointmentstatus(physicianQuestionsAndAnswersList.getAppointmentstatus());
			if (physicianQuestionsAndAnswersList.getReminderdate() != null) {
				questionsObj.setReminderdate("" + physicianQuestionsAndAnswersList.getReminderdate());
			}

			PatientBasicInfoModel patientBasicInfoModel = new PatientBasicInfoModel();
			patientBasicInfoModel.setFirstname(physicianQuestionsAndAnswersList.getFirstname());
			patientBasicInfoModel.setLastname(physicianQuestionsAndAnswersList.getLastname());
			patientBasicInfoModel.setAddress1(physicianQuestionsAndAnswersList.getAddress1());
			patientBasicInfoModel.setAddress2(physicianQuestionsAndAnswersList.getAddress2());
			patientBasicInfoModel.setCity(physicianQuestionsAndAnswersList.getCity());
			patientBasicInfoModel.setState(physicianQuestionsAndAnswersList.getState());
			patientBasicInfoModel.setCountry(physicianQuestionsAndAnswersList.getCountry());
			patientBasicInfoModel.setDob(physicianQuestionsAndAnswersList.getDob());
			patientBasicInfoModel.setZip(physicianQuestionsAndAnswersList.getZip());
			patientBasicInfoModel.setSkypeid(physicianQuestionsAndAnswersList.getSkypeid());
			if (physicianQuestionsAndAnswersList.getImageUrl() != null) {
				patientBasicInfoModel.setImageUrl(getMessage("imageUrlPath")
						+ physicianQuestionsAndAnswersList.getImageUrl());
			}
			questionsObj.setPatientInfo(patientBasicInfoModel);
			questionsObj.setImageUrls(imagesArray);
			// Audio URL
			questionsObj.setAudioUrls(audiosArray);
			// Video URL
			questionsObj.setVideoUrls(videoWithThumnailList);
			//questionsList.add(questionsObj);
			return questionsObj;
		}
		return null;
		
		//return questionsObj;

	}

	/**
	 * 
	 * @param physicianid
	 * @param specialityid
	 * @return
	 */
	@Transactional
	public ArrayList<PhysicianQuestionsAndAnswersModel> getPhysicianGroupQuestions(
			int physicianid, int specialityid) {

		ArrayList<QuestionsAnswersAndReplyAnswersModel> physicianQuestionsAndAnswersList = physicianQuestionsDAO
				.getPhysicianGroupQuestions(physicianid, specialityid);
		return processQuestionsLits(physicianQuestionsAndAnswersList);
	}

	/**
	 * 
	 * @param specialityid
	 * @return
	 */
	@Transactional
	public ArrayList<PhysicianQuestionsAndAnswersModel> getPhysicianOngoingQuestions(
			int physicianid) {

		ArrayList<QuestionsAnswersAndReplyAnswersModel> physicianQuestionsAndAnswersList = physicianQuestionsDAO
				.getPhysicianOngoingQuestions(physicianid);
		return processQuestionsLits(physicianQuestionsAndAnswersList);
	}

	/**
	 * 
	 * @param physicianid
	 * @return
	 */
	@Transactional
	public ArrayList<PhysicianQuestionsAndAnswersModel> getPhysicianClosedQuestions(
			int physicianid) {

		ArrayList<QuestionsAnswersAndReplyAnswersModel> physicianQuestionsAndAnswersList = physicianQuestionsDAO
				.getPhysicianClosedQuestions(physicianid);
		return processQuestionsLits(physicianQuestionsAndAnswersList);
	}

	/**
	 * 
	 * @param patientPhysicianReplyAnswerModel
	 * @return
	 */
	@Transactional
	public StatusObject replyToQuestionAns(
			PatientPhysicianReplyAnswerModel patientPhysicianReplyAnswerModel) {

		StatusObject statusObject = new StatusObject();
		TreatmentAnswersDTO treatmentPatientAnswerDTO = new TreatmentAnswersDTO();
		treatmentPatientAnswerDTO.setPatientid(patientPhysicianReplyAnswerModel
				.getPatientid());
		treatmentPatientAnswerDTO
				.setPhysicianid(patientPhysicianReplyAnswerModel
						.getPhysicianid());
		treatmentPatientAnswerDTO.setPostedby(1);
		treatmentPatientAnswerDTO.setPosteddate(new Date());
		treatmentPatientAnswerDTO.setReply(patientPhysicianReplyAnswerModel
				.getReply());
		treatmentPatientAnswerDTO
				.setTreatmentquestionid(patientPhysicianReplyAnswerModel
						.getTreatmentquestionid());

		boolean status = physicianQuestionsDAO
				.savePhysicianTeatmentReplyAns(treatmentPatientAnswerDTO);
		if (status) {

			if (patientPhysicianReplyAnswerModel.isScheduleAppointment()) {

				PhysicianScheduleDTO physicianScheduleDTO = new PhysicianScheduleDTO();
				physicianScheduleDTO.setCreateddate(new Date());
				physicianScheduleDTO
						.setPatientid(patientPhysicianReplyAnswerModel
								.getPatientid());
				physicianScheduleDTO
						.setPhysicianid(patientPhysicianReplyAnswerModel
								.getPhysicianid());
				physicianScheduleDTO
						.setScheduletypeid(patientPhysicianReplyAnswerModel
								.getScheduletypeid());// Schedule
														// type
				physicianScheduleDTO.setScheduledate(Utilities
						.getDateAndTimeFormat(patientPhysicianReplyAnswerModel
								.getScheduledate())); // Schedule
														// Date
				boolean statusSchedule = false;
				if (physicianScheduleDTO.getScheduledate() != null) {

					physicianScheduleDTO
							.setTreatmentquestionid(patientPhysicianReplyAnswerModel
									.getTreatmentquestionid()); // TQID
					physicianScheduleDTO.setStatus(1); // Status 1 one means
														// physician sent
														// appointment to
														// patient

					statusSchedule = physicianScheduleDAO
							.savePhysicianSchedule(physicianScheduleDTO);
				}

				if (statusSchedule) {

					// Notify to Patient i.e Physician send an Appointment
					patientNotificationService
							.notifytoPatientAsPhysicianSentAppointment(
									patientPhysicianReplyAnswerModel
											.getPatientid(),
									patientPhysicianReplyAnswerModel
											.getPhysicianid(),
									patientPhysicianReplyAnswerModel
											.getTreatmentquestionid());

					statusObject.setError(false);
					statusObject
							.setMessage(getMessage("schedule.appointment.answer.success"));
					return statusObject;

				} else {
					statusObject.setError(true);
					statusObject
							.setMessage(getMessage("schedule.appointment.answer.error"));
					return statusObject;
				}
			}

			int treatmentType = commonDAO
					.getTreatmentTypeFromQuestionID(patientPhysicianReplyAnswerModel
							.getTreatmentquestionid());

			if (treatmentType == 2) {

				// Notify to Patient i.e Ongoing Treatment Reply
				patientNotificationService.notifyOngoingTreatmentReply(
						patientPhysicianReplyAnswerModel.getPatientid(),
						patientPhysicianReplyAnswerModel.getPhysicianid(),
						patientPhysicianReplyAnswerModel
								.getTreatmentquestionid());
			}

			statusObject.setError(false);
			statusObject.setMessage(getMessage("patient.answer.reply.success"));
			return statusObject;

		} else {

			statusObject.setError(true);
			statusObject.setMessage(getMessage("patient.answer.reply.error"));
			return statusObject;
		}

	}

	/**
	 * 
	 * @param treatmentQuestionId
	 * @param physicianId
	 * @return
	 */
	@Transactional
	public ArrayList<PhyPatQuesAnsReplyModel> getQuestionAnswerDeatils(
			int treatmentQuestionId, int physicianId) {

		ArrayList<QuestionsAnswersDetailModel> detailsList = physicianQuestionsDAO
				.getPhysicianQuestionDetailAnswers(treatmentQuestionId,
						physicianId);
		return patientQuestionsService
				.processQuestionsAndAnswersList(detailsList);
	}

	/**
	 * 
	 * @param patientPhysicianReplyAnswerModel
	 * @return
	 */
	@Transactional
	public StatusObject deleteQuestion(
			PatientPhysicianReplyAnswerModel patientPhysicianReplyAnswerModel) {

		StatusObject statusObject = new StatusObject();
		if (patientPhysicianReplyAnswerModel != null) {

			PhysicianDeletedQuestionsDTO physicianDeletedQuestionsDTO = new PhysicianDeletedQuestionsDTO();
			physicianDeletedQuestionsDTO
					.setPhysicianid(patientPhysicianReplyAnswerModel
							.getPhysicianid());
			physicianDeletedQuestionsDTO
					.setTreatmentquestionid(patientPhysicianReplyAnswerModel
							.getTreatmentquestionid());
			physicianDeletedQuestionsDTO.setCreatedby(""
					+ patientPhysicianReplyAnswerModel.getPhysicianid());
			physicianDeletedQuestionsDTO.setCreateddate(new Date());
			boolean status = physicianQuestionsDAO
					.deletePhysicianQuestion(physicianDeletedQuestionsDTO);

			if (status) {
				statusObject.setError(false);
				statusObject.setMessage(getMessage("question.deleted.success"));
				return statusObject;
			} else {
				statusObject.setError(true);
				statusObject.setMessage(getMessage("question.deleted.error"));
				return statusObject;
			}

		} else {
			statusObject.setError(true);
			statusObject.setMessage(getMessage("question.deleted.error"));
			return statusObject;
		}
	}
}
