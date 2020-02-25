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
public class PhyPatQuesAnsReplyModel {

	private Integer physicianid;
	private boolean appointmentInitiated;
	private String firstName;
	private String lastName;
	private Integer scheduletypeid;
	private String scheduledate;
	private String scheduletype;
	private Integer rescheduletypeid;
	private String rescheduledate;
	private String rescheduletype;
	private ArrayList<String> questionReplyImageUrls = new ArrayList<String>();
	private ArrayList<String> questionReplyAudioUrls=new ArrayList<String>();
	private ArrayList<VideoURLModel> questionReplyVideoUrls=new ArrayList<VideoURLModel>();
	private ArrayList<QueAnsReplyModel> answersReplies = new ArrayList<QueAnsReplyModel>();
	
	
	
	public ArrayList<String> getQuestionReplyAudioUrls() {
		return questionReplyAudioUrls;
	}

	public void setQuestionReplyAudioUrls(ArrayList<String> questionReplyAudioUrls) {
		this.questionReplyAudioUrls = questionReplyAudioUrls;
	}

	

	/**
	 * @return the questionReplyVideoUrls
	 */
	public ArrayList<VideoURLModel> getQuestionReplyVideoUrls() {
		return questionReplyVideoUrls;
	}

	/**
	 * @param questionReplyVideoUrls the questionReplyVideoUrls to set
	 */
	public void setQuestionReplyVideoUrls(ArrayList<VideoURLModel> questionReplyVideoUrls) {
		this.questionReplyVideoUrls = questionReplyVideoUrls;
	}

	/**
	 * @return the scheduletypeid
	 */
	public Integer getScheduletypeid() {
		return scheduletypeid;
	}

	/**
	 * @param scheduletypeid the scheduletypeid to set
	 */
	public void setScheduletypeid(Integer scheduletypeid) {
		this.scheduletypeid = scheduletypeid;
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
	 * @return the physicianid
	 */
	public Integer getPhysicianid() {
		return physicianid;
	}

	/**
	 * @param physicianid the physicianid to set
	 */
	public void setPhysicianid(Integer physicianid) {
		this.physicianid = physicianid;
	}

	/**
	 * @return the appointmentInitiated
	 */
	public boolean isAppointmentInitiated() {
		return appointmentInitiated;
	}

	/**
	 * @param appointmentInitiated the appointmentInitiated to set
	 */
	public void setAppointmentInitiated(boolean appointmentInitiated) {
		this.appointmentInitiated = appointmentInitiated;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
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
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the questionReplyImageUrls
	 */
	public ArrayList<String> getQuestionReplyImageUrls() {
		return questionReplyImageUrls;
	}

	/**
	 * @param questionReplyImageUrls the questionReplyImageUrls to set
	 */
	public void setQuestionReplyImageUrls(ArrayList<String> questionReplyImageUrls) {
		this.questionReplyImageUrls = questionReplyImageUrls;
	}

	/**
	 * @return the answersReplies
	 */
	public ArrayList<QueAnsReplyModel> getAnswersReplies() {
		return answersReplies;
	}

	/**
	 * @param answersReplies the answersReplies to set
	 */
	public void setAnswersReplies(ArrayList<QueAnsReplyModel> answersReplies) {
		this.answersReplies = answersReplies;
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
	public String getRescheduledate() {
		return rescheduledate;
	}

	/**
	 * @param rescheduledate the rescheduledate to set
	 */
	public void setRescheduledate(String rescheduledate) {
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
}
