/**
 * 
 */
package com.ensis.mediguru.service.patient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ensis.mediguru.dao.common.CommonDAO;
import com.ensis.mediguru.dao.patient.PatientQuestionsDAO;
import com.ensis.mediguru.dao.patient.PostQuestionToPhysicianDAO;
import com.ensis.mediguru.dto.TreatmentAnswersDTO;
import com.ensis.mediguru.dto.TreatmentImages;
import com.ensis.mediguru.models.PatientOngoingQuestionsModel;
import com.ensis.mediguru.models.PatientOngoingTreatmentQueAndPhysiciansModel;
import com.ensis.mediguru.models.PatientPhysicianReplyAnswerModel;
import com.ensis.mediguru.models.PatientQuestionsAndAnswersModel;
import com.ensis.mediguru.models.PhyPatQuesAnsReplyModel;
import com.ensis.mediguru.models.PhysicianOngoingBasicInfo;
import com.ensis.mediguru.models.QueAnsReplyModel;
import com.ensis.mediguru.models.QuestionsAnswersAndReplyAnswersModel;
import com.ensis.mediguru.models.QuestionsAnswersDetailModel;
import com.ensis.mediguru.models.StatusObject;
import com.ensis.mediguru.service.physician.PhysicianNotificationService;
import com.ensis.mediguru.service.physician.PhysicianQuestionsService;
import com.ensis.mediguru.utils.MessageResources;
import com.ensis.mediguru.utils.Utilities;
import com.ensis.vo.models.VideoURLModel;

/**
 * @author Venu
 *
 */
@Service
public class PatientQuestionsService extends MessageResources {

	@Autowired
	PatientQuestionsDAO patientQuestionsDAO;

	@Autowired
	PhysicianQuestionsService physicianQuestionsService;

	@Autowired
	PostQuestionToPhysicianDAO postQuestionToPhysicianDAO;

	@Autowired
	CommonDAO commonDAO;

	@Autowired
	PhysicianNotificationService physicianNotificationService;

	/**
	 * @param physicianNotificationService
	 *            the physicianNotificationService to set
	 */
	public void setPhysicianNotificationService(
			PhysicianNotificationService physicianNotificationService) {
		this.physicianNotificationService = physicianNotificationService;
	}

	/**
	 * @param commonDAO
	 *            the commonDAO to set
	 */
	public void setCommonDAO(CommonDAO commonDAO) {
		this.commonDAO = commonDAO;
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
	 * @param postQuestionToPhysicianDAO
	 *            the postQuestionToPhysicianDAO to set
	 */
	public void setPostQuestionToPhysicianDAO(
			PostQuestionToPhysicianDAO postQuestionToPhysicianDAO) {
		this.postQuestionToPhysicianDAO = postQuestionToPhysicianDAO;
	}

	/**
	 * @return the patientQuestionsDAO
	 */
	public PatientQuestionsDAO getPatientQuestionsDAO() {
		return patientQuestionsDAO;
	}

	public void setPatientQuestionsDAO(PatientQuestionsDAO patientQuestionsDAO) {
		this.patientQuestionsDAO = patientQuestionsDAO;
	}

	/**
	 * 
	 * @param patientId
	 * @return
	 */
	@Transactional
	public ArrayList<PatientQuestionsAndAnswersModel> getPatientQuestions(
			int patientId) {

		ArrayList<QuestionsAnswersAndReplyAnswersModel> individualQuestions = patientQuestionsDAO
				.getPatinetQuestions(patientId);
		return processQuestionsLits(individualQuestions);
	}

	/**
	 * 
	 * @param patientTreatmentReplyAnswerModel
	 * @return
	 */
	@Transactional
	public StatusObject replyToQuestionAns(
			PatientPhysicianReplyAnswerModel patientPhysicianReplyAnswerModel,
			MultipartFile[] imageFile, MultipartFile[] audioFile,
			MultipartFile[] videoFile) {

		StatusObject statusObject = new StatusObject();
		TreatmentAnswersDTO treatmentPatientAnswerDTO = new TreatmentAnswersDTO();
		treatmentPatientAnswerDTO.setPatientid(patientPhysicianReplyAnswerModel
				.getPatientid());
		treatmentPatientAnswerDTO
				.setPhysicianid(patientPhysicianReplyAnswerModel
						.getPhysicianid());
		treatmentPatientAnswerDTO.setPostedby(2);
		treatmentPatientAnswerDTO.setPosteddate(new Date());
		treatmentPatientAnswerDTO.setReply(patientPhysicianReplyAnswerModel
				.getReply());
		treatmentPatientAnswerDTO
				.setTreatmentquestionid(patientPhysicianReplyAnswerModel
						.getTreatmentquestionid());

		boolean status = patientQuestionsDAO
				.savePatientTeatmentReplyAns(treatmentPatientAnswerDTO);
		
		if (status) {

			// Image file
			if (imageFile != null) {

				for (int i = 0; i < imageFile.length; i++) {

					MultipartFile files = imageFile[i];
					TreatmentImages treatmentimages = new TreatmentImages();
					treatmentimages.setTreatmentquestionid(patientPhysicianReplyAnswerModel.getTreatmentquestionid());
					treatmentimages.setFilename(files.getOriginalFilename());
					treatmentimages.setCreateddate(new Date());
					treatmentimages.setFiletype(1);// Image is One--1
					treatmentimages.setImgtype(2);
					treatmentimages
							.setPhysicianid(patientPhysicianReplyAnswerModel
									.getPhysicianid());
					postQuestionToPhysicianDAO.saveTreatmentImages(files,
							treatmentimages);
				}
			}

			// Audio file
			if (audioFile != null) {

				for (int i = 0; i < audioFile.length; i++) {

					MultipartFile files = audioFile[i];
					TreatmentImages treatmentimages = new TreatmentImages();
					treatmentimages
							.setTreatmentquestionid(patientPhysicianReplyAnswerModel
									.getTreatmentquestionid());
					treatmentimages.setFilename(files.getOriginalFilename());
					treatmentimages.setCreateddate(new Date());
					treatmentimages.setFiletype(2);// Audio File is One--2
					treatmentimages.setImgtype(2);
					treatmentimages.setPhysicianid(patientPhysicianReplyAnswerModel
									.getPhysicianid());
					postQuestionToPhysicianDAO.saveTreatmentAudioFile(files,
							treatmentimages);
				}
			}

			// Video File
			if (videoFile != null) {

				for (int i = 0; i < videoFile.length; i++) {

					MultipartFile files = videoFile[i];
					TreatmentImages treatmentimages = new TreatmentImages();
					treatmentimages
							.setTreatmentquestionid(patientPhysicianReplyAnswerModel
									.getTreatmentquestionid());
					treatmentimages.setFilename(files.getOriginalFilename());
					treatmentimages.setCreateddate(new Date());
					treatmentimages.setFiletype(3);// Video File is three --3
					treatmentimages.setImgtype(2);
					treatmentimages
							.setPhysicianid(patientPhysicianReplyAnswerModel
									.getPhysicianid());
					postQuestionToPhysicianDAO.saveTreatmentVideoFile(files,
							treatmentimages);
				}
			}

			// get the treatment type
			int treatmentType = commonDAO
					.getTreatmentTypeFromQuestionID(patientPhysicianReplyAnswerModel
							.getTreatmentquestionid());

			if (treatmentType == 2) {

				// Send Notification
				physicianNotificationService.notifyOngoingReplyFromPatient(
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
	 * @param physicianQuestionsAndAnswersList
	 * @return
	 */
	public ArrayList<PatientQuestionsAndAnswersModel> processQuestionsLits(
			ArrayList<QuestionsAnswersAndReplyAnswersModel> physicianQuestionsAndAnswersList) {

		ArrayList<PatientQuestionsAndAnswersModel> questionsList = new ArrayList<PatientQuestionsAndAnswersModel>();

		for (int i = 0; i < physicianQuestionsAndAnswersList.size(); i++) {

			QuestionsAnswersAndReplyAnswersModel mainObj = physicianQuestionsAndAnswersList
					.get(i);

			ArrayList<String> imagesArray = new ArrayList<String>();
			ArrayList<String> audiosArray = new ArrayList<String>();
			ArrayList<String> vidoesArray = new ArrayList<String>();
			ArrayList<String> thubsarrayArray = new ArrayList<String>();

			// Images
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

			PatientQuestionsAndAnswersModel questionsObj = new PatientQuestionsAndAnswersModel();
			questionsObj.setTreatmentquestionid(mainObj
					.getTreatmentquestionid());
			questionsObj.setPatientid(mainObj.getPatientid());
			questionsObj.setPhysicianid(mainObj.getPhysicianid());
			questionsObj.setQuestion(mainObj.getQuestion());
			questionsObj.setDescription(mainObj.getDescription());
			questionsObj.setCreateddate("" + mainObj.getCreateddate());
			questionsObj.setQuestiontypeid(mainObj.getQuestiontypeid());
			questionsObj.setTreatmenttypeid(mainObj.getTreatmenttypeid());
			questionsObj
					.setReplyCount(Integer.parseInt(mainObj.getReplyCount()));
			questionsObj.setFirstName(mainObj.getFirstname());
			questionsObj.setLastName(mainObj.getLastname());
			// Image URL
			questionsObj.setImageUrls(imagesArray);
			// Audio URL
			questionsObj.setAudioUrls(audiosArray);
			// Video URL
			questionsObj.setVideoUrls(videoWithThumnailList);

			if (questionsList.size() == 0) {

				questionsList.add(questionsObj);

			} else {

				boolean isTreatmentquestionIdAdded = false;
				for (int j = 0; j < questionsList.size(); j++) {

					if (questionsList.get(j).getTreatmentquestionid() == mainObj
							.getTreatmentquestionid()) {
						isTreatmentquestionIdAdded = true;
					}
				}
				if (!isTreatmentquestionIdAdded) {
					questionsList.add(questionsObj);
				}
			}
		}
		// Sort By Question Id
		Collections
				.sort(questionsList, Utilities.sortyByPatientTreatmentQuesId);
		return questionsList;
	}

	/**
	 * 
	 * @param patientId
	 * @return
	 */
	@Transactional
	public ArrayList<PatientOngoingQuestionsModel> getOngoingPhysicians(
			int patientId) {
		// TODO Auto-generated method stub

		ArrayList<PatientOngoingTreatmentQueAndPhysiciansModel> mainQuestionsList = patientQuestionsDAO
				.getPatientOngoingQuestions(patientId);

		ArrayList<PatientOngoingQuestionsModel> patientOngoingQuestionsList = new ArrayList<PatientOngoingQuestionsModel>();

		for (int i = 0; i < mainQuestionsList.size(); i++) {

			PatientOngoingTreatmentQueAndPhysiciansModel mainObj = mainQuestionsList
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

			PatientOngoingQuestionsModel questionsObj = new PatientOngoingQuestionsModel();
			questionsObj.setTreatmentid(mainObj.getTreatmentid());
			questionsObj.setTreatmentquestionid(mainObj
					.getTreatmentquestionid());
			questionsObj.setPatientid(mainObj.getPatientid());
			questionsObj.setQuestion(mainObj.getQuestion());
			questionsObj.setDescription(mainObj.getDescription());
			questionsObj.setCreateddate("" + mainObj.getCreateddate());
			questionsObj.setQuestiontypeid(mainObj.getQuestiontypeid());
			questionsObj.setTreatmenttypeid(mainObj.getTreatmenttypeid());

			questionsObj.setScheduledate("" + mainObj.getScheduledate());
			questionsObj.setScheduletype(mainObj.getScheduletype());
			questionsObj.setScheduletypeid(mainObj.getScheduletypeid());
			// Image URL
			questionsObj.setImageUrls(imagesArray);
			// Audio URL
			questionsObj.setAudioUrls(audiosArray);
			// Video URL
			questionsObj.setVideoUrls(videoWithThumnailList);

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
			physicianOngoingBasicInfo.setSkypeid(mainObj.getSkypeid());
			physicianOngoingBasicInfo.setOfficephone(mainObj.getOfficephone());
			physicianOngoingBasicInfo.setOngoingPhysician(true);
			if (mainObj.getRating() != null) {

				physicianOngoingBasicInfo.setRating(Utilities
						.getTwoDigitDoubleValue(mainObj.getRating()));
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

			if (mainObj.getFirstvisitfee() != null) {
				physicianOngoingBasicInfo.setFirstvisitfee(mainObj
						.getFirstvisitfee());
			}

			if (mainObj.getFollowupvisitfee() != null) {

				physicianOngoingBasicInfo.setFollowupvisitfee(mainObj
						.getFollowupvisitfee());
			}

			if (mainObj.getImageUrl() != null) {
				physicianOngoingBasicInfo
						.setImageUrl(getMessage("imageUrlPath")
								+ mainObj.getImageUrl());
			}

			// physicianOngoingBasicInfo.setIsInpersonAppointment(mainObj.isIsInpersonAppointment());
			// physicianOngoingBasicInfo.setIsVirtualPhoneAppointment(mainObj.isIsVirtualPhoneAppointment());
			// physicianOngoingBasicInfo.setIsVirtualSkypeAppointment(mainObj.isIsVirtualSkypeAppointment());

			if (mainObj.getIsInpersonAppointment() != null) {
				physicianOngoingBasicInfo.setIsInpersonAppointment(mainObj
						.getIsInpersonAppointment());
			}

			if (mainObj.getIsInpersonAppointment() != null) {
				physicianOngoingBasicInfo.setIsVirtualPhoneAppointment(mainObj
						.getIsVirtualPhoneAppointment());
			}

			if (mainObj.getIsInpersonAppointment() != null) {
				physicianOngoingBasicInfo.setIsVirtualSkypeAppointment(mainObj
						.getIsVirtualSkypeAppointment());
			}

			physicianOngoingBasicInfo.setSpeciality(mainObj.getSpeciality());
			physicianOngoingBasicInfo.setSpecialitytype(mainObj
					.getSpecialitytype());

			questionsObj.setPhysicianInfo(physicianOngoingBasicInfo);

			if (patientOngoingQuestionsList.size() == 0) {

				patientOngoingQuestionsList.add(questionsObj);

			} else {

				boolean isTreatmentquestionIdAdded = false;
				for (int j = 0; j < patientOngoingQuestionsList.size(); j++) {

					if (patientOngoingQuestionsList.get(j)
							.getTreatmentquestionid() == mainObj
							.getTreatmentquestionid()) {
						isTreatmentquestionIdAdded = true;
					}
				}
				if (!isTreatmentquestionIdAdded) {
					patientOngoingQuestionsList.add(questionsObj);
				}
			}
		}

		// Sort By Question Id
		Collections.sort(patientOngoingQuestionsList,
				Utilities.soryByPatientOngoingTreatemntQues);
		return patientOngoingQuestionsList;
	}

	@Transactional
	public PatientOngoingQuestionsModel getPatientTreatmentDetails(int patientId,int treatmentquestionid) {
		PatientOngoingTreatmentQueAndPhysiciansModel mainQuestionsList = patientQuestionsDAO
				.getPatientTreatmentDetails(patientId, treatmentquestionid);
		


		ArrayList<PatientOngoingQuestionsModel> patientOngoingQuestionsList = new ArrayList<PatientOngoingQuestionsModel>();


		ArrayList<String> imagesArray = new ArrayList<String>();
		ArrayList<String> audiosArray = new ArrayList<String>();
		ArrayList<String> vidoesArray = new ArrayList<String>();
		ArrayList<String> thubsarrayArray = new ArrayList<String>();
		
		if(mainQuestionsList!=null){

		if (mainQuestionsList.getQuestionImages() != null) {

			String[] images = mainQuestionsList.getQuestionImages().split(":");
			for (int z = 0; z < images.length; z++) {

				imagesArray.add(getMessage("imageUrlPath") + images[z]);
			}
		}

		// Audio
		if (mainQuestionsList.getQuestionAudios() != null) {

			String[] audios = mainQuestionsList.getQuestionAudios().split(":");
			for (int z = 0; z < audios.length; z++) {

				audiosArray.add(getMessage("audioUrlPath") + audios[z]);
			}
		}

		// Videos
		if (mainQuestionsList.getQuestionVideos() != null) {

			String[] videos = mainQuestionsList.getQuestionVideos().split(":");
			for (int z = 0; z < videos.length; z++) {

				vidoesArray.add(getMessage("videoUrlPath") + videos[z]);
			}
		}

		// Thumbnail
		if (mainQuestionsList.getThumbnail() != null) {

			String[] thumbnail = mainQuestionsList.getThumbnail().split(":");
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

		PatientOngoingQuestionsModel questionsObj = new PatientOngoingQuestionsModel();
		questionsObj.setTreatmentid(mainQuestionsList.getTreatmentid());
		questionsObj.setTreatmentquestionid(mainQuestionsList
				.getTreatmentquestionid());
		questionsObj.setQuestion(mainQuestionsList.getQuestion());
		questionsObj.setDescription(mainQuestionsList.getDescription());
		questionsObj.setCreateddate("" + mainQuestionsList.getCreateddate());
		questionsObj.setQuestiontypeid(mainQuestionsList.getQuestiontypeid());
		questionsObj.setTreatmenttypeid(mainQuestionsList.getTreatmenttypeid());
		questionsObj.setPatientid(mainQuestionsList.getPatientid());

		questionsObj.setScheduledate("" + mainQuestionsList.getScheduledate());
		questionsObj.setScheduletype(mainQuestionsList.getScheduletype());
		questionsObj.setScheduletypeid(mainQuestionsList.getScheduletypeid());
		// Image URL
		questionsObj.setImageUrls(imagesArray);
		// Audio URL
		questionsObj.setAudioUrls(audiosArray);
		// Video URL
		questionsObj.setVideoUrls(videoWithThumnailList);

		// Physician Info
		PhysicianOngoingBasicInfo physicianOngoingBasicInfo = new PhysicianOngoingBasicInfo();
		physicianOngoingBasicInfo.setFirstname(mainQuestionsList.getFirstname());
		physicianOngoingBasicInfo.setLastname(mainQuestionsList.getLastname());
		physicianOngoingBasicInfo.setPhysicianid(mainQuestionsList.getPhysicianid());
		physicianOngoingBasicInfo.setDob(mainQuestionsList.getDob());
		physicianOngoingBasicInfo.setAddress1(mainQuestionsList.getAddress1());
		physicianOngoingBasicInfo.setAddress2(mainQuestionsList.getAddress2());
		physicianOngoingBasicInfo.setCity(mainQuestionsList.getCity());
		physicianOngoingBasicInfo.setState(mainQuestionsList.getState());
		physicianOngoingBasicInfo.setCountry(mainQuestionsList.getCountry());
		physicianOngoingBasicInfo.setZip(mainQuestionsList.getZip());
		physicianOngoingBasicInfo.setAbout(mainQuestionsList.getAbout());
		physicianOngoingBasicInfo.setMobile(mainQuestionsList.getMobile());
		physicianOngoingBasicInfo.setSkypeid(mainQuestionsList.getSkypeid());
		physicianOngoingBasicInfo.setOfficephone(mainQuestionsList.getOfficephone());
		physicianOngoingBasicInfo.setOngoingPhysician(true);
		if (mainQuestionsList.getRating() != null) {

			physicianOngoingBasicInfo.setRating(Utilities
					.getTwoDigitDoubleValue(mainQuestionsList.getRating()));
		}

		if (mainQuestionsList.getPhysiciantypeid() != null) {

			if (mainQuestionsList.getPhysiciantypeid().contains(",")) {

				String[] groupPhysicians = mainQuestionsList.getPhysiciantypeid()
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

				int physicianTypeId = Integer.parseInt(mainQuestionsList
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

		if (mainQuestionsList.getFirstvisitfee() != null) {
			physicianOngoingBasicInfo.setFirstvisitfee(mainQuestionsList
					.getFirstvisitfee());
		}

		if (mainQuestionsList.getFollowupvisitfee() != null) {

			physicianOngoingBasicInfo.setFollowupvisitfee(mainQuestionsList
					.getFollowupvisitfee());
		}

		if (mainQuestionsList.getImageUrl() != null) {
			physicianOngoingBasicInfo
					.setImageUrl(getMessage("imageUrlPath")
							+ mainQuestionsList.getImageUrl());
		}

		// physicianOngoingBasicInfo.setIsInpersonAppointment(mainObj.isIsInpersonAppointment());
		// physicianOngoingBasicInfo.setIsVirtualPhoneAppointment(mainObj.isIsVirtualPhoneAppointment());
		// physicianOngoingBasicInfo.setIsVirtualSkypeAppointment(mainObj.isIsVirtualSkypeAppointment());

		if (mainQuestionsList.getIsInpersonAppointment() != null) {
			physicianOngoingBasicInfo.setIsInpersonAppointment(mainQuestionsList
					.getIsInpersonAppointment());
		}

		if (mainQuestionsList.getIsInpersonAppointment() != null) {
			physicianOngoingBasicInfo.setIsVirtualPhoneAppointment(mainQuestionsList
					.getIsVirtualPhoneAppointment());
		}

		if (mainQuestionsList.getIsInpersonAppointment() != null) {
			physicianOngoingBasicInfo.setIsVirtualSkypeAppointment(mainQuestionsList
					.getIsVirtualSkypeAppointment());
		}

		physicianOngoingBasicInfo.setSpeciality(mainQuestionsList.getSpeciality());
		physicianOngoingBasicInfo.setSpecialitytype(mainQuestionsList
				.getSpecialitytype());

		questionsObj.setPhysicianInfo(physicianOngoingBasicInfo);

		patientOngoingQuestionsList.add(questionsObj);
		return questionsObj;
		}
		return null;
		
	}

	/**
	 * 
	 * @param treatmentQuestionId
	 * @return
	 */
	@Transactional
	public ArrayList<PhyPatQuesAnsReplyModel> getQuestionAnswerDeatils(
			int treatmentQuestionId) {

		// get the treatment type
		int treatmentType = commonDAO
				.getTreatmentTypeFromQuestionID(treatmentQuestionId);

		// if ongoing questions call another type procedure
		if (treatmentType == 2) {

			ArrayList<QuestionsAnswersDetailModel> detailsList = patientQuestionsDAO
					.getOngoingQuestionDetail(treatmentQuestionId);
			return processQuestionsAndAnswersList(detailsList);

		} else {

			ArrayList<QuestionsAnswersDetailModel> detailsList = patientQuestionsDAO
					.getPatinetQuestionDetailAnswers(treatmentQuestionId);
			return processQuestionsAndAnswersList(detailsList);
		}
	}

	/**
	 * 
	 * @param detailsList
	 * @return
	 */
	public ArrayList<PhyPatQuesAnsReplyModel> processQuestionsAndAnswersList(
			ArrayList<QuestionsAnswersDetailModel> detailsList) {

		ArrayList<PhyPatQuesAnsReplyModel> mainList = new ArrayList<PhyPatQuesAnsReplyModel>();
		if (detailsList != null) {

			for (int i = 0; i < detailsList.size(); i++) {

				QuestionsAnswersDetailModel mainObj = detailsList.get(i);
				PhyPatQuesAnsReplyModel replyObj = new PhyPatQuesAnsReplyModel();
				replyObj.setFirstName(mainObj.getFirstname());
				replyObj.setLastName(mainObj.getLastname());
				replyObj.setPhysicianid(mainObj.getPhysicianid());
				if (mainObj.getStatus() != null) {

					if (mainObj.getStatus() == 1) {

						replyObj.setAppointmentInitiated(true);
					}

					replyObj.setScheduledate("" + mainObj.getScheduledate());
					replyObj.setScheduletypeid(mainObj.getScheduletypeid());
					replyObj.setScheduletype(mainObj.getScheduletype());

					replyObj.setRescheduledate("" + mainObj.getRescheduledate());
					replyObj.setRescheduletypeid(mainObj.getRescheduletypeid());
					replyObj.setRescheduletype(mainObj.getRescheduletype());
				}

				ArrayList<String> replyImagesArray = new ArrayList<String>();
				ArrayList<String> audiosArray = new ArrayList<String>();
				ArrayList<String> vidoesArray = new ArrayList<String>();
				ArrayList<String> thubsarrayArray = new ArrayList<String>();

				if (mainObj.getReplyimages() != null) {

					String[] images = mainObj.getReplyimages().split(":");
					for (int z = 0; z < images.length; z++) {

						replyImagesArray.add(getMessage("imageUrlPath")
								+ images[z]);
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

				// Images
				replyObj.setQuestionReplyImageUrls(replyImagesArray);
				// Audio
				replyObj.setQuestionReplyAudioUrls(audiosArray);
				// Videos
				replyObj.setQuestionReplyVideoUrls(videoWithThumnailList);

				ArrayList<QueAnsReplyModel> answersReplies = new ArrayList<QueAnsReplyModel>();
				QueAnsReplyModel queAnsReplyModel = new QueAnsReplyModel();
				queAnsReplyModel.setPostedby(mainObj.getPostedby());
				queAnsReplyModel.setPosteddate("" + mainObj.getPosteddate());
				queAnsReplyModel.setReply(mainObj.getReply());
				queAnsReplyModel.setTreatmentansid(mainObj.getTreatmentansid());

				if (mainList.size() == 0) {

					answersReplies.add(queAnsReplyModel);
					replyObj.setAnswersReplies(answersReplies);
					mainList.add(replyObj);

				} else {

					boolean isRepliesAdded = false;
					for (int j = 0; j < mainList.size(); j++) {

						if (mainList.get(j).getPhysicianid() == mainObj
								.getPhysicianid()) {

							isRepliesAdded = true;
							answersReplies.addAll(mainList.get(j)
									.getAnswersReplies());
							answersReplies.add(queAnsReplyModel);
							replyObj.setAnswersReplies(answersReplies);
							mainList.set(j, replyObj);
						}
					}

					if (isRepliesAdded) {

					} else {

						answersReplies.add(queAnsReplyModel);
						replyObj.setAnswersReplies(answersReplies);
						mainList.add(replyObj);
					}
				}
			}
		}
		return mainList;
	}

}
