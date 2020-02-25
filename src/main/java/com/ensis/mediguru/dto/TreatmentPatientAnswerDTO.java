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
@Table(name = "treatmentpatientanswer")
public class TreatmentPatientAnswerDTO {

	@Id
	private int treatmentpatientansid;

	private int treatmentquestionid;

	private int treatmentphyansid;

	private String patientreply;

	private Date patientanscreateddate;

	/**
	 * @return the treatmentpatientansid
	 */
	public int getTreatmentpatientansid() {
		return treatmentpatientansid;
	}

	/**
	 * @param treatmentpatientansid
	 *            the treatmentpatientansid to set
	 */
	public void setTreatmentpatientansid(int treatmentpatientansid) {
		this.treatmentpatientansid = treatmentpatientansid;
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
	 * @return the patientreply
	 */
	public String getPatientreply() {
		return patientreply;
	}

	/**
	 * @param patientreply
	 *            the patientreply to set
	 */
	public void setPatientreply(String patientreply) {
		this.patientreply = patientreply;
	}

	/**
	 * @return the patientanscreateddate
	 */
	public Date getPatientanscreateddate() {
		return patientanscreateddate;
	}

	/**
	 * @param patientanscreateddate the patientanscreateddate to set
	 */
	public void setPatientanscreateddate(Date patientanscreateddate) {
		this.patientanscreateddate = patientanscreateddate;
	}
	
}
