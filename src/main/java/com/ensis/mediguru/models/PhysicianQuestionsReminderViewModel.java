package com.ensis.mediguru.models;

import java.util.ArrayList;

import com.ensis.vo.models.VideoURLModel;

/**
 * @author Venu
 *
 */
public class PhysicianQuestionsReminderViewModel {

	private Integer physicianid;
	private Integer patientid;
	private Integer treatmentquestionid;
	private String reminderdate;
	private String Question;
	private String description;
	private String createddate;
	private String remindernote;
	private Integer questiontypeid;
	private ArrayList<String> questionImages = new ArrayList<String>();
	private ArrayList<String> audioUrls = new ArrayList<String>();
	private ArrayList<VideoURLModel> videoUrls = new ArrayList<VideoURLModel>();
	private PatientBasicInfoModel patientInfo;
	private boolean isremindercompleted;

	public PhysicianQuestionsReminderViewModel() {
		super();
	}

	public boolean isIsremindercompleted() {
		return isremindercompleted;
	}

	public void setIsremindercompleted(boolean isremindercompleted) {
		this.isremindercompleted = isremindercompleted;
	}

	/**
	 * @return the physicianid
	 */
	public Integer getPhysicianid() {
		return physicianid;
	}

	/**
	 * @param physicianid
	 *            the physicianid to set
	 */
	public void setPhysicianid(Integer physicianid) {
		this.physicianid = physicianid;
	}

	/**
	 * @return the patientid
	 */
	public Integer getPatientid() {
		return patientid;
	}

	/**
	 * @param patientid
	 *            the patientid to set
	 */
	public void setPatientid(Integer patientid) {
		this.patientid = patientid;
	}

	/**
	 * @return the remindernote
	 */
	public String getRemindernote() {
		return remindernote;
	}

	/**
	 * @param remindernote
	 *            the remindernote to set
	 */
	public void setRemindernote(String remindernote) {
		this.remindernote = remindernote;
	}

	/**
	 * @return the treatmentquestionid
	 */
	public Integer getTreatmentquestionid() {
		return treatmentquestionid;
	}

	/**
	 * @param treatmentquestionid
	 *            the treatmentquestionid to set
	 */
	public void setTreatmentquestionid(Integer treatmentquestionid) {
		this.treatmentquestionid = treatmentquestionid;
	}

	/**
	 * @return the reminderdate
	 */
	public String getReminderdate() {
		return reminderdate;
	}

	/**
	 * @param reminderdate
	 *            the reminderdate to set
	 */
	public void setReminderdate(String reminderdate) {
		this.reminderdate = reminderdate;
	}

	/**
	 * @return the question
	 */
	public String getQuestion() {
		return Question;
	}

	/**
	 * @param question
	 *            the question to set
	 */
	public void setQuestion(String question) {
		Question = question;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the createddate
	 */
	public String getCreateddate() {
		return createddate;
	}

	/**
	 * @param createddate
	 *            the createddate to set
	 */
	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	/**
	 * @return the questiontypeid
	 */
	public Integer getQuestiontypeid() {
		return questiontypeid;
	}

	/**
	 * @param questiontypeid
	 *            the questiontypeid to set
	 */
	public void setQuestiontypeid(Integer questiontypeid) {
		this.questiontypeid = questiontypeid;
	}

	/**
	 * @return the questionImages
	 */
	public ArrayList<String> getQuestionImages() {
		return questionImages;
	}

	/**
	 * @param questionImages
	 *            the questionImages to set
	 */
	public void setQuestionImages(ArrayList<String> questionImages) {
		this.questionImages = questionImages;
	}

	/**
	 * @return the patientInfo
	 */
	public PatientBasicInfoModel getPatientInfo() {
		return patientInfo;
	}

	/**
	 * @param patientInfo
	 *            the patientInfo to set
	 */
	public void setPatientInfo(PatientBasicInfoModel patientInfo) {
		this.patientInfo = patientInfo;
	}

	public ArrayList<String> getAudioUrls() {
		return audioUrls;
	}

	public void setAudioUrls(ArrayList<String> audioUrls) {
		this.audioUrls = audioUrls;
	}

	/**
	 * @return the videoUrls
	 */
	public ArrayList<VideoURLModel> getVideoUrls() {
		return videoUrls;
	}

	/**
	 * @param videoUrls the videoUrls to set
	 */
	public void setVideoUrls(ArrayList<VideoURLModel> videoUrls) {
		this.videoUrls = videoUrls;
	}

	
}
