package com.ensis.mediguru.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "treatmentconsultation")
public class TreatmentConsultatonDTO {

	@Id
	private int consultationid;
	private Integer treatmentid;
	private Integer patientid;
	private Integer physicianid;
	private Boolean appointmentstatus;
	private Boolean firstconsultation;
	private int followupconsultationcount;
	private Date creteddate;
	private Date updateddate;
	/**
	 * @return the consultationid
	 */
	public int getConsultationid() {
		return consultationid;
	}
	/**
	 * @param consultationid the consultationid to set
	 */
	public void setConsultationid(int consultationid) {
		this.consultationid = consultationid;
	}
	/**
	 * @return the treatmentid
	 */
	public Integer getTreatmentid() {
		return treatmentid;
	}
	/**
	 * @param treatmentid the treatmentid to set
	 */
	public void setTreatmentid(Integer treatmentid) {
		this.treatmentid = treatmentid;
	}
	/**
	 * @return the patientid
	 */
	public Integer getPatientid() {
		return patientid;
	}
	/**
	 * @param patientid the patientid to set
	 */
	public void setPatientid(Integer patientid) {
		this.patientid = patientid;
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
	 * @return the appointmentstatus
	 */
	public Boolean getAppointmentstatus() {
		return appointmentstatus;
	}
	/**
	 * @param appointmentstatus the appointmentstatus to set
	 */
	public void setAppointmentstatus(Boolean appointmentstatus) {
		this.appointmentstatus = appointmentstatus;
	}
	/**
	 * @return the firstconsultation
	 */
	public Boolean getFirstconsultation() {
		return firstconsultation;
	}
	/**
	 * @param firstconsultation the firstconsultation to set
	 */
	public void setFirstconsultation(Boolean firstconsultation) {
		this.firstconsultation = firstconsultation;
	}
	/**
	 * @return the followupconsultationcount
	 */
	public int getFollowupconsultationcount() {
		return followupconsultationcount;
	}
	/**
	 * @param followupconsultationcount the followupconsultationcount to set
	 */
	public void setFollowupconsultationcount(int followupconsultationcount) {
		this.followupconsultationcount = followupconsultationcount;
	}
	/**
	 * @return the creteddate
	 */
	public Date getCreteddate() {
		return creteddate;
	}
	/**
	 * @param creteddate the creteddate to set
	 */
	public void setCreteddate(Date creteddate) {
		this.creteddate = creteddate;
	}
	/**
	 * @return the updateddate
	 */
	public Date getUpdateddate() {
		return updateddate;
	}
	/**
	 * @param updateddate the updateddate to set
	 */
	public void setUpdateddate(Date updateddate) {
		this.updateddate = updateddate;
	}
	
	
	
}
