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
@Table(name = "treatmentphysiciananswer")
public class TreatmentPhysicianAnswerDTO {

	@Id
	private int treatmentphyansid;

	private int treatmentquestionid;

	private int physicianid;

	private String physicianreply;

	private String comment;

	private int rating;

	private String createdby;

	private Date physiciananscreateddate;

	public TreatmentPhysicianAnswerDTO() {
		super();
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
	 * @return the physicianreply
	 */
	public String getPhysicianreply() {
		return physicianreply;
	}

	/**
	 * @param physicianreply
	 *            the physicianreply to set
	 */
	public void setPhysicianreply(String physicianreply) {
		this.physicianreply = physicianreply;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * @param rating
	 *            the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
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

	/**
	 * @return the physiciananscreateddate
	 */
	public Date getPhysiciananscreateddate() {
		return physiciananscreateddate;
	}

	/**
	 * @param physiciananscreateddate the physiciananscreateddate to set
	 */
	public void setPhysiciananscreateddate(Date physiciananscreateddate) {
		this.physiciananscreateddate = physiciananscreateddate;
	}

}
