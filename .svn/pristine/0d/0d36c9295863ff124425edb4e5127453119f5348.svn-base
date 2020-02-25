package com.ensis.mediguru.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "physicianprofessionainfo")
public class PhysicianProfessionaInfo {
	
	@Id
	private int physicianprofessionainfoid;
	
	@Column(name = "physicianid")	
	private int physicianid;
	
	@Column(name = "practicestartdate")
	private String practicestartdate;
	
	@Column(name = "firstvisitfee")
	private int firstvisitfee;
	
	@Column(name = "followupvisitfee")
	private int followupvisitfee;
	
	@Column(name = "IsInpersonAppointment")
	private boolean IsInpersonAppointment;
	
	@Column(name = "IsVirtualPhoneAppointment")
	private boolean IsVirtualPhoneAppointment;
	
	@Column(name = "IsVirtualSkypeAppointment")
	private boolean IsVirtualSkypeAppointment;

	@Column(name = "createdby")
	private String createdby;
	
	@Column(name = "createddate")
	private Date createddate;
	
	@Column(name = "updatedby")
	private String updatedby;
	
	@Column(name = "updateddate")
	private Date updateddate;

	public PhysicianProfessionaInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhysicianProfessionaInfo(int physicianid, String practicestartdate,
			int firstvisitfee, int followupvisitfee,
			boolean isInpersonAppointment, boolean isVirtualPhoneAppointment,
			boolean isVirtualSkypeAppointment) {
		super();
		this.physicianid = physicianid;
		this.practicestartdate = practicestartdate;
		this.firstvisitfee = firstvisitfee;
		this.followupvisitfee = followupvisitfee;
		IsInpersonAppointment = isInpersonAppointment;
		IsVirtualPhoneAppointment = isVirtualPhoneAppointment;
		IsVirtualSkypeAppointment = isVirtualSkypeAppointment;
	}

	public int getPhysicianprofessionainfoid() {
		return physicianprofessionainfoid;
	}

	public void setPhysicianprofessionainfoid(int physicianprofessionainfoid) {
		this.physicianprofessionainfoid = physicianprofessionainfoid;
	}

	public int getPhysicianid() {
		return physicianid;
	}

	public void setPhysicianid(int physicianid) {
		this.physicianid = physicianid;
	}

	public String getPracticestartdate() {
		return practicestartdate;
	}

	public void setPracticestartdate(String practicestartdate) {
		this.practicestartdate = practicestartdate;
	}

	public int getFirstvisitfee() {
		return firstvisitfee;
	}

	public void setFirstvisitfee(int firstvisitfee) {
		this.firstvisitfee = firstvisitfee;
	}

	public int getFollowupvisitfee() {
		return followupvisitfee;
	}

	public void setFollowupvisitfee(int followupvisitfee) {
		this.followupvisitfee = followupvisitfee;
	}

	public boolean isInpersonAppointment() {
		return IsInpersonAppointment;
	}

	public void setInpersonAppointment(boolean isInpersonAppointment) {
		IsInpersonAppointment = isInpersonAppointment;
	}

	public boolean isVirtualPhoneAppointment() {
		return IsVirtualPhoneAppointment;
	}

	public void setVirtualPhoneAppointment(boolean isVirtualPhoneAppointment) {
		IsVirtualPhoneAppointment = isVirtualPhoneAppointment;
	}

	public boolean isVirtualSkypeAppointment() {
		return IsVirtualSkypeAppointment;
	}

	public void setVirtualSkypeAppointment(boolean isVirtualSkypeAppointment) {
		IsVirtualSkypeAppointment = isVirtualSkypeAppointment;
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
