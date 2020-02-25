/**
 * 
 */
package com.ensis.mediguru.models;

/**
 * @author Venu
 *
 */
public class PatientPhysicianReplyAnswerModel {

	private int treatmentquestionid;
	private int physicianid;
	private int patientid;
	private String reply;

	private boolean scheduleAppointment;
	private String scheduledate;
	private int scheduletypeid;

	/**
	 * @return the scheduleAppointment
	 */
	public boolean isScheduleAppointment() {
		return scheduleAppointment;
	}

	/**
	 * @param scheduleAppointment
	 *            the scheduleAppointment to set
	 */
	public void setScheduleAppointment(boolean scheduleAppointment) {
		this.scheduleAppointment = scheduleAppointment;
	}

	/**
	 * @return the scheduledate
	 */
	public String getScheduledate() {
		return scheduledate;
	}

	/**
	 * @param scheduledate
	 *            the scheduledate to set
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
	 * @param scheduletypeid
	 *            the scheduletypeid to set
	 */
	public void setScheduletypeid(int scheduletypeid) {
		this.scheduletypeid = scheduletypeid;
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
}
