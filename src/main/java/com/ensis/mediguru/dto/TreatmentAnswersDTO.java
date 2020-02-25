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
@Table(name="treatmentanswer")
public class TreatmentAnswersDTO {

	@Id
	private int treatmentansid;
	private int treatmentquestionid;
	private int patientid;
	private int physicianid;
	private String reply;
	private int postedby;
	private Date posteddate;
	
	
	/**
	 * @return the treatmentansid
	 */
	public int getTreatmentansid() {
		return treatmentansid;
	}
	/**
	 * @param treatmentansid the treatmentansid to set
	 */
	public void setTreatmentansid(int treatmentansid) {
		this.treatmentansid = treatmentansid;
	}
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
	 * @return the patientid
	 */
	public int getPatientid() {
		return patientid;
	}
	/**
	 * @param patientid the patientid to set
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
	 * @param physicianid the physicianid to set
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
	 * @param reply the reply to set
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
	 * @param postedby the postedby to set
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
	 * @param posteddate the posteddate to set
	 */
	public void setPosteddate(Date posteddate) {
		this.posteddate = posteddate;
	}	
}
