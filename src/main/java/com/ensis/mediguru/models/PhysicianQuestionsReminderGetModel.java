/**
 * 
 */
package com.ensis.mediguru.models;

import java.util.Date;

/**
 * @author Venu
 *
 */
public class PhysicianQuestionsReminderGetModel {

	private Integer treatmentquestionid;
	private Integer physicianid;
	private Date reminderdate;
	private String Question;
	private String description;
	private Date createddate;
	private Integer questiontypeid;
	private Integer patientid;
	private String firstname;
	private String lastname;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String country;
	private String zip;
	private String dob;
	private String imageUrl;
	private String questionImages;
	private String questionAudios;
	private String questionVideos;
	private String thumbnail;
	private String remindernote;
	private boolean isremindercompleted;

	public boolean isIsremindercompleted() {
		return isremindercompleted;
	}

	public void setIsremindercompleted(boolean isremindercompleted) {
		this.isremindercompleted = isremindercompleted;
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
	 * @return the reminderdate
	 */
	public Date getReminderdate() {
		return reminderdate;
	}

	/**
	 * @param reminderdate
	 *            the reminderdate to set
	 */
	public void setReminderdate(Date reminderdate) {
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
	public Date getCreateddate() {
		return createddate;
	}

	/**
	 * @param createddate
	 *            the createddate to set
	 */
	public void setCreateddate(Date createddate) {
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
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname
	 *            the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname
	 *            the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the address1
	 */
	public String getAddress1() {
		return address1;
	}

	/**
	 * @param address1
	 *            the address1 to set
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}

	/**
	 * @param address2
	 *            the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param zip
	 *            the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}

	/**
	 * @param dob
	 *            the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}

	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * @param imageUrl
	 *            the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * @return the questionImages
	 */
	public String getQuestionImages() {
		return questionImages;
	}

	/**
	 * @param questionImages
	 *            the questionImages to set
	 */
	public void setQuestionImages(String questionImages) {
		this.questionImages = questionImages;
	}

	public String getQuestionAudios() {
		return questionAudios;
	}

	public void setQuestionAudios(String questionAudios) {
		this.questionAudios = questionAudios;
	}

	public String getQuestionVideos() {
		return questionVideos;
	}

	public void setQuestionVideos(String questionVideos) {
		this.questionVideos = questionVideos;
	}

	/**
	 * @return the thumbnail
	 */
	public String getThumbnail() {
		return thumbnail;
	}

	/**
	 * @param thumbnail the thumbnail to set
	 */
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	

}
