/**
 * 
 */
package com.ensis.mediguru.models;

import java.util.Date;

/**
 * @author Venu
 *
 */
public class QuestionsAnswersDetailModel {

	private int patientid;
	private int physicianid;
	private String reply;
	private int postedby;
	private Date posteddate;
	private String firstname;
	private String lastname;
	private String replyimages;
	private String questionAudios;
	private String questionVideos;
	private String thumbnail;
	private Integer treatmentansid;
	private Integer status;
	private Integer scheduletypeid;
	private Date scheduledate;
	private String scheduletype;
	
	private Integer rescheduletypeid;
	private Date rescheduledate;
	private String rescheduletype;
	

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
	 * @return the scheduletypeid
	 */
	public Integer getScheduletypeid() {
		return scheduletypeid;
	}

	/**
	 * @param scheduletypeid
	 *            the scheduletypeid to set
	 */
	public void setScheduletypeid(Integer scheduletypeid) {
		this.scheduletypeid = scheduletypeid;
	}

	/**
	 * @return the scheduledate
	 */
	public Date getScheduledate() {
		return scheduledate;
	}

	/**
	 * @param scheduledate
	 *            the scheduledate to set
	 */
	public void setScheduledate(Date scheduledate) {
		this.scheduledate = scheduledate;
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
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return the treatmentansid
	 */
	public Integer getTreatmentansid() {
		return treatmentansid;
	}

	/**
	 * @param treatmentansid
	 *            the treatmentansid to set
	 */
	public void setTreatmentansid(Integer treatmentansid) {
		this.treatmentansid = treatmentansid;
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
	 * @return the physicianid
	 */
	public int getPhysicianid() {
		return physicianid;
	}

	/**
	 * @param physicianid
	 *            the physicianid to set
	 */
	public void setPhysicianid(int physicianid) {
		this.physicianid = physicianid;
	}

	/**
	 * @return the reply
	 */
	public String getReply() {
		return reply;
	}

	/**
	 * @param reply
	 *            the reply to set
	 */
	public void setReply(String reply) {
		this.reply = reply;
	}

	/**
	 * @return the postedby
	 */
	public int getPostedby() {
		return postedby;
	}

	/**
	 * @param postedby
	 *            the postedby to set
	 */
	public void setPostedby(int postedby) {
		this.postedby = postedby;
	}

	/**
	 * @return the posteddate
	 */
	public Date getPosteddate() {
		return posteddate;
	}

	/**
	 * @param posteddate
	 *            the posteddate to set
	 */
	public void setPosteddate(Date posteddate) {
		this.posteddate = posteddate;
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
	 * @return the replyimages
	 */
	public String getReplyimages() {
		return replyimages;
	}

	/**
	 * @param replyimages
	 *            the replyimages to set
	 */
	public void setReplyimages(String replyimages) {
		this.replyimages = replyimages;
	}

	/**
	 * @return the rescheduletypeid
	 */
	public Integer getRescheduletypeid() {
		return rescheduletypeid;
	}

	/**
	 * @param rescheduletypeid the rescheduletypeid to set
	 */
	public void setRescheduletypeid(Integer rescheduletypeid) {
		this.rescheduletypeid = rescheduletypeid;
	}

	/**
	 * @return the rescheduledate
	 */
	public Date getRescheduledate() {
		return rescheduledate;
	}

	/**
	 * @param rescheduledate the rescheduledate to set
	 */
	public void setRescheduledate(Date rescheduledate) {
		this.rescheduledate = rescheduledate;
	}

	/**
	 * @return the rescheduletype
	 */
	public String getRescheduletype() {
		return rescheduletype;
	}

	/**
	 * @param rescheduletype the rescheduletype to set
	 */
	public void setRescheduletype(String rescheduletype) {
		this.rescheduletype = rescheduletype;
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
