/**
 * 
 */
package com.ensis.mediguru.models;

import java.util.ArrayList;

import com.ensis.vo.models.VideoURLModel;

/**
 * @author Venu
 *
 */
public class PatientQuestionsAndAnswersModel {

	private Integer treatmentquestionid;
	private Integer patientid;
	private Integer physicianid;
	// private Integer specialitytypeid;
	private String Question;
	private String description;
	private ArrayList<String> imageUrls;
	private ArrayList<String> audioUrls;
	private ArrayList<VideoURLModel> videoUrls;
	private String createddate;
	private Integer questiontypeid;
	private Integer treatmenttypeid;

	private Integer replyCount;

	private String firstName;
	private String lastName;

	// private ArrayList<PhyPatQuesAnsReplyModel> replies = new
	// ArrayList<PhyPatQuesAnsReplyModel>();

	/**
	 * @return the treatmenttypeid
	 */
	public Integer getTreatmenttypeid() {
		return treatmenttypeid;
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

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	 * @return the replyCount
	 */
	public Integer getReplyCount() {
		return replyCount;
	}

	/**
	 * @param replyCount
	 *            the replyCount to set
	 */
	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}

	/**
	 * @param treatmenttypeid
	 *            the treatmenttypeid to set
	 */
	public void setTreatmenttypeid(Integer treatmenttypeid) {
		this.treatmenttypeid = treatmenttypeid;
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
	 * @return the imageUrls
	 */
	public ArrayList<String> getImageUrls() {
		return imageUrls;
	}

	/**
	 * @param imageUrls
	 *            the imageUrls to set
	 */
	public void setImageUrls(ArrayList<String> imageUrls) {
		this.imageUrls = imageUrls;
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

}
