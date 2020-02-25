/**
 * 
 */
package com.ensis.mediguru.models;

import java.util.ArrayList;

/**
 * @author Venu
 *
 */
public class PhysicianOngoingScheduleModel {


	private int treatmentid;
	private int treatmentquestionid;
	private int treatmenttypeid;
	private int questiontypeid;
	private Boolean appointmentstatus;
	private String Question;
	private String description;
	private String createddate;
	
	private String scheduledate;
	private Integer scheduletypeid;
	private String scheduletype;

	private ArrayList<String> imageUrls = new ArrayList<String>();
	private ArrayList<String> audioUrls=new ArrayList<String>();
	private ArrayList<String> videoUrls=new ArrayList<String>();
	
	
	
	

	

	/**
	 * @return the appointmentstatus
	 */
	public Boolean getAppointmentstatus() {
		return appointmentstatus;
	}

	/**
	 * @param appointmentstatus the appointmentstatus to set
	 */
	public void setAppointmentstatus(Boolean appointmentstatus) {
		this.appointmentstatus = appointmentstatus;
	}

	/**
	 * @param scheduletypeid the scheduletypeid to set
	 */
	public void setScheduletypeid(Integer scheduletypeid) {
		this.scheduletypeid = scheduletypeid;
	}

	public int getTreatmentid() {
		return treatmentid;
	}

	public void setTreatmentid(int treatmentid) {
		this.treatmentid = treatmentid;
	}

	private PatientBasicInfoModel patientInfo;

	/**
	 * @return the treatmentquestionid
	 */
	public int getTreatmentquestionid() {
		return treatmentquestionid;
	}

	/**
	 * @param treatmentquestionid the treatmentquestionid to set
	 */
	public void setTreatmentquestionid(int treatmentquestionid) {
		this.treatmentquestionid = treatmentquestionid;
	}

	/**
	 * @return the treatmenttypeid
	 */
	public int getTreatmenttypeid() {
		return treatmenttypeid;
	}

	/**
	 * @param treatmenttypeid the treatmenttypeid to set
	 */
	public void setTreatmenttypeid(int treatmenttypeid) {
		this.treatmenttypeid = treatmenttypeid;
	}

	/**
	 * @return the questiontypeid
	 */
	public int getQuestiontypeid() {
		return questiontypeid;
	}

	/**
	 * @param questiontypeid the questiontypeid to set
	 */
	public void setQuestiontypeid(int questiontypeid) {
		this.questiontypeid = questiontypeid;
	}

	/**
	 * @return the scheduledate
	 */
	public String getScheduledate() {
		return scheduledate;
	}

	/**
	 * @param scheduledate the scheduledate to set
	 */
	public void setScheduledate(String scheduledate) {
		this.scheduledate = scheduledate;
	}

	/**
	 * @return the scheduletypeid
	 */
	public int getScheduletypeid() {
		return scheduletypeid;
	}

	/**
	 * @param scheduletypeid the scheduletypeid to set
	 */
	public void setScheduletypeid(int scheduletypeid) {
		this.scheduletypeid = scheduletypeid;
	}

	

	/**
	 * @return the scheduletype
	 */
	public String getScheduletype() {
		return scheduletype;
	}

	/**
	 * @param scheduletype the scheduletype to set
	 */
	public void setScheduletype(String scheduletype) {
		this.scheduletype = scheduletype;
	}

	/**
	 * @return the question
	 */
	public String getQuestion() {
		return Question;
	}

	/**
	 * @param question the question to set
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
	 * @param description the description to set
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
	 * @param createddate the createddate to set
	 */
	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	/**
	 * @return the imageUrls
	 */
	public ArrayList<String> getImageUrls() {
		return imageUrls;
	}

	/**
	 * @param imageUrls the imageUrls to set
	 */
	public void setImageUrls(ArrayList<String> imageUrls) {
		this.imageUrls = imageUrls;
	}

	

	/**
	 * @return the patientInfo
	 */
	public PatientBasicInfoModel getPatientInfo() {
		return patientInfo;
	}

	/**
	 * @param patientInfo the patientInfo to set
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

	public ArrayList<String> getVideoUrls() {
		return videoUrls;
	}

	public void setVideoUrls(ArrayList<String> videoUrls) {
		this.videoUrls = videoUrls;
	}
	
}
