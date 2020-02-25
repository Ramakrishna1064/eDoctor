/**
 * 
 */
package com.ensis.mediguru.models;

import java.util.ArrayList;

import com.ensis.vo.models.VideoURLModel;

/**
 * @author Ensis
 *
 */
public class PatientClosedTreatmentModel {

	
	private int treatmentid;
	private int treatmentquestionid;
	private int treatmenttypeid;
	private int questiontypeid;
	private String Question;
	private String description;
	private String createddate;

	private ArrayList<String> imageUrls = new ArrayList<String>();
	private ArrayList<String> audioUrls=new ArrayList<String>();
	private ArrayList<VideoURLModel> videoUrls=new ArrayList<VideoURLModel>();


	private PhysicianOngoingBasicInfo physicianInfo;

	public int getTreatmentid() {
		return treatmentid;
	}

	public void setTreatmentid(int treatmentid) {
		this.treatmentid = treatmentid;
	}

	public int getTreatmentquestionid() {
		return treatmentquestionid;
	}

	public void setTreatmentquestionid(int treatmentquestionid) {
		this.treatmentquestionid = treatmentquestionid;
	}

	public int getTreatmenttypeid() {
		return treatmenttypeid;
	}

	public void setTreatmenttypeid(int treatmenttypeid) {
		this.treatmenttypeid = treatmenttypeid;
	}

	public int getQuestiontypeid() {
		return questiontypeid;
	}

	public void setQuestiontypeid(int questiontypeid) {
		this.questiontypeid = questiontypeid;
	}

	public String getQuestion() {
		return Question;
	}

	public void setQuestion(String question) {
		Question = question;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	public ArrayList<String> getImageUrls() {
		return imageUrls;
	}

	public void setImageUrls(ArrayList<String> imageUrls) {
		this.imageUrls = imageUrls;
	}

	public PhysicianOngoingBasicInfo getPhysicianInfo() {
		return physicianInfo;
	}

	public void setPhysicianInfo(PhysicianOngoingBasicInfo physicianInfo) {
		this.physicianInfo = physicianInfo;
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
