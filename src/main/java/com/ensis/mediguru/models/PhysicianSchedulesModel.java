/**
 * 
 */
package com.ensis.mediguru.models;

import java.util.Date;

/**
 * @author Venu
 *
 */
public class PhysicianSchedulesModel {

	private String Question;
	private String description;
	private int questiontypeid;
	private int patientid;
	private int treatmentquestionid;
	private int treatmentphyansid;
	private int scheduletypeid;
	private Date scheduledate;
	private String scheduletype;
	private String appointmentDate;
	private String firstname;
	private String lastname;
	private String dob;
	private String mobile;
	private String officephone;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String country;
	private String zip;
	private String imageurl;
	private int treatmentid;
	

	/**
	 * @return the treatmentid
	 */
	public int getTreatmentid() {
		return treatmentid;
	}

	/**
	 * @param treatmentid the treatmentid to set
	 */
	public void setTreatmentid(int treatmentid) {
		this.treatmentid = treatmentid;
	}

	/**
	 * @return the scheduledate
	 */
	public Date getScheduledate() {
		return scheduledate;
	}

	/**
	 * @param scheduledate the scheduledate to set
	 */
	public void setScheduledate(Date scheduledate) {
		this.scheduledate = scheduledate;
	}

	/**
	 * @return the imageurl
	 */
	public String getImageurl() {
		return imageurl;
	}

	/**
	 * @param imageurl the imageurl to set
	 */
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
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
	 * @return the questiontypeid
	 */
	public int getQuestiontypeid() {
		return questiontypeid;
	}

	/**
	 * @param questiontypeid
	 *            the questiontypeid to set
	 */
	public void setQuestiontypeid(int questiontypeid) {
		this.questiontypeid = questiontypeid;
	}

	/**
	 * @return the patientid
	 */
	public int getPatientid() {
		return patientid;
	}

	/**
	 * @param patientid
	 *            the patientid to set
	 */
	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}

	/**
	 * @return the treatmentquestionid
	 */
	public int getTreatmentquestionid() {
		return treatmentquestionid;
	}

	/**
	 * @param treatmentquestionid
	 *            the treatmentquestionid to set
	 */
	public void setTreatmentquestionid(int treatmentquestionid) {
		this.treatmentquestionid = treatmentquestionid;
	}

	/**
	 * @return the treatmentphyansid
	 */
	public int getTreatmentphyansid() {
		return treatmentphyansid;
	}

	/**
	 * @param treatmentphyansid
	 *            the treatmentphyansid to set
	 */
	public void setTreatmentphyansid(int treatmentphyansid) {
		this.treatmentphyansid = treatmentphyansid;
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
	 * @param scheduletype
	 *            the scheduletype to set
	 */
	public void setScheduletype(String scheduletype) {
		this.scheduletype = scheduletype;
	}

	/**
	 * @return the appointmentDate
	 */
	public String getAppointmentDate() {
		return appointmentDate;
	}

	/**
	 * @param appointmentDate
	 *            the appointmentDate to set
	 */
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
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
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile
	 *            the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the officephone
	 */
	public String getOfficephone() {
		return officephone;
	}

	/**
	 * @param officephone
	 *            the officephone to set
	 */
	public void setOfficephone(String officephone) {
		this.officephone = officephone;
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

}
