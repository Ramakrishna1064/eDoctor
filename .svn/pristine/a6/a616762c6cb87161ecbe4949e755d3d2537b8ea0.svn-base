/**
 * 
 */
package com.ensis.mediguru.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author shyam
 *
 */
@Entity
@Table(name = "patientmedicalnotes")
public class PatientMedicalNotes {

	@Id
	private int noteid;
	private int treatmentid;
	private int patientid;
	private int physicianid;
	private String notes;
	private String createdby;
	private Date createddate;
	private Integer consultationid;

	
	/**
	 * @return the consultationid
	 */
	public Integer getConsultationid() {
		return consultationid;
	}

	/**
	 * @param consultationid the consultationid to set
	 */
	public void setConsultationid(Integer consultationid) {
		this.consultationid = consultationid;
	}

	public int getNoteid() {
		return noteid;
	}

	public void setNoteid(int noteid) {
		this.noteid = noteid;
	}

	public int getTreatmentid() {
		return treatmentid;
	}

	public void setTreatmentid(int treatmentid) {
		this.treatmentid = treatmentid;
	}

	public int getPatientid() {
		return patientid;
	}

	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public int getPhysicianid() {
		return physicianid;
	}

	public void setPhysicianid(int physicianid) {
		this.physicianid = physicianid;
	}

}
