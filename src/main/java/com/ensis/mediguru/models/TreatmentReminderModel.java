/**
 * 
 */
package com.ensis.mediguru.models;


/**
 * @author Venu
 *
 */
public class TreatmentReminderModel {

	private int treatmentquestionid;
	private int physicianid;
	private String reminderdate;
	private String comments;

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
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	

}
