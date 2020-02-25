package com.ensis.mediguru.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table(name= "patientpreference")
public class PatientPreference {

	@Id
	private int patientpreferenceid;
	@Column(name = "patientid")
	private int patientid;
	@Column(name = "issharemedicalhistory")
	private boolean issharemedicalhistory;
	@Column(name = "isopentoalternatemed")
	private boolean isopentoalternatemed;
	@Column(name = "issmsnotification")
	private boolean issmsnotification;
	@Column(name = "isemailnotification")
	private boolean isemailnotification;
	@Column(name = "createdby")
	private String createdby;
	@Column(name = "createddate")
	private Date createddate;
	@Column(name = "updatedby")
	private String updatedby;
	@Column(name = "updateddate")
	private Date updateddate;
	public PatientPreference() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PatientPreference( int patientid,
			boolean issharemedicalhistory, boolean isopentoalternatemed,
			boolean issmsnotification, boolean isemailnotification,
			String createdby, Date createddate, String updatedby,
			Date updateddate) {
		super();
		//this.patientpreferenceid = patientpreferenceid;
		this.patientid = patientid;
		this.issharemedicalhistory = issharemedicalhistory;
		this.isopentoalternatemed = isopentoalternatemed;
		this.issmsnotification = issmsnotification;
		this.isemailnotification = isemailnotification;
		this.createdby = createdby;
		this.createddate = createddate;
		this.updatedby = updatedby;
		this.updateddate = updateddate;
	}
	public int getPatientpreferenceid() {
		return patientpreferenceid;
	}
	public void setPatientpreferenceid(int patientpreferenceid) {
		this.patientpreferenceid = patientpreferenceid;
	}
	public int getPatientid() {
		return patientid;
	}
	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}
	public boolean isIssharemedicalhistory() {
		return issharemedicalhistory;
	}
	public void setIssharemedicalhistory(boolean issharemedicalhistory) {
		this.issharemedicalhistory = issharemedicalhistory;
	}
	public boolean isIsopentoalternatemed() {
		return isopentoalternatemed;
	}
	public void setIsopentoalternatemed(boolean isopentoalternatemed) {
		this.isopentoalternatemed = isopentoalternatemed;
	}
	public boolean isIssmsnotification() {
		return issmsnotification;
	}
	public void setIssmsnotification(boolean issmsnotification) {
		this.issmsnotification = issmsnotification;
	}
	public boolean isIsemailnotification() {
		return isemailnotification;
	}
	public void setIsemailnotification(boolean isemailnotification) {
		this.isemailnotification = isemailnotification;
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
	public String getUpdatedby() {
		return updatedby;
	}
	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}
	public Date getUpdateddate() {
		return updateddate;
	}
	public void setUpdateddate(Date updateddate) {
		this.updateddate = updateddate;
	}
	
	
	
}
