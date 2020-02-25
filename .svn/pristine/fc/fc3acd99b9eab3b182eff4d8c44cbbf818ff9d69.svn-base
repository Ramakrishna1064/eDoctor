/**
 * 
 */
package com.ensis.mediguru.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Venu
 *
 */
@Entity
@Table(name = "treatmentquestionsreminders")
public class TreatmentQuestionReminderDTO {

	@Id
	private int id;
	private int treatmentquestionid;
	private int physicianid;
	private String comments;
	private Date reminderdate;
	private boolean isremindercompleted;
	private boolean isdeleted;
	private int reschedulecount;
	private Date createddate;
	private String createdby;
	private Date updateddate;
	
	

	public Date getUpdateddate() {
		return updateddate;
	}

	public void setUpdateddate(Date updateddate) {
		this.updateddate = updateddate;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments
	 *            the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * @return the createdby
	 */
	public String getCreatedby() {
		return createdby;
	}

	/**
	 * @param createdby
	 *            the createdby to set
	 */
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public boolean isIsremindercompleted() {
		return isremindercompleted;
	}

	public void setIsremindercompleted(boolean isremindercompleted) {
		this.isremindercompleted = isremindercompleted;
	}

	public boolean isIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(boolean isdeleted) {
		this.isdeleted = isdeleted;
	}

	public int getReschedulecount() {
		return reschedulecount;
	}

	public void setReschedulecount(int reschedulecount) {
		this.reschedulecount = reschedulecount;
	}

}
