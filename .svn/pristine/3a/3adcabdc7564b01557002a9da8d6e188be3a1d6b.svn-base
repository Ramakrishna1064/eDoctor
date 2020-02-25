package com.ensis.mediguru.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patientmedicaldata")
public class PatientMedicalData {

	@Id
	private int patientmedicaldataid;

	@Column(name = "medicinedatatypeid")
	private int medicinedatatypeid;

	@Column(name = "medicinename")
	private String medicinename;

	@Column(name = "dosage")
	private int dosage;

	@Column(name = "startdate")
	private Date startdate;

	@Column(name = "enddate")
	private Date enddate;

	@Column(name = "comments")
	private String comments;

	private int treatmentid;
	private int patientid;
	private int physicianid;
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

	public PatientMedicalData() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the treatmentid
	 */
	public int getTreatmentid() {
		return treatmentid;
	}

	/**
	 * @param treatmentid
	 *            the treatmentid to set
	 */
	public void setTreatmentid(int treatmentid) {
		this.treatmentid = treatmentid;
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

	public int getPatientmedicaldataid() {
		return patientmedicaldataid;
	}

	public void setPatientmedicaldataid(int patientmedicaldataid) {
		this.patientmedicaldataid = patientmedicaldataid;
	}

	public int getMedicinedatatypeid() {
		return medicinedatatypeid;
	}

	public void setMedicinedatatypeid(int medicinedatatypeid) {
		this.medicinedatatypeid = medicinedatatypeid;
	}

	public String getMedicinename() {
		return medicinename;
	}

	public void setMedicinename(String medicinename) {
		this.medicinename = medicinename;
	}

	public int getDosage() {
		return dosage;
	}

	public void setDosage(int dosage) {
		this.dosage = dosage;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
