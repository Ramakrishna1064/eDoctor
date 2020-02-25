package com.ensis.mediguru.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table(name= "physiciansspeciality")
public class PhysicianSpeciality {
	@Id
	private int physicianspeid;	 
	
	@Column(name = "physicianid")
	private int physicianid;
	
	@Column(name = "specialitytypeid")
	private int specialitytypeid;
	
	@Column(name = "qualtypeid")
	private int qualtypeid;	
	
	@Column(name = "yearqualified")
	private int yearqualified;	
	
	@Column(name = "institution")
	private int institution;
	
	@Column(name = "createdby")
	private String createdby;
	
	@Column(name = "createddate")
	private Date createddate;
	
	@Column(name = "updatedby")
	private String updatedby;
	
	@Column(name = "updateddate")
	private Date updateddate;
	
	public PhysicianSpeciality() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public PhysicianSpeciality(int physicianid, int specialitytypeid,
			int qualtypeid, int yearqualified) {
		super();
		this.physicianid = physicianid;
		this.specialitytypeid = specialitytypeid;
		this.qualtypeid = qualtypeid;
		this.yearqualified = yearqualified;
	}



	public PhysicianSpeciality(int physicianid, int specialitytypeid,
			int qualtypeid, int yearqualified, int institution) {
		super();
		this.physicianid = physicianid;
		this.specialitytypeid = specialitytypeid;
		this.qualtypeid = qualtypeid;
		this.yearqualified = yearqualified;
		this.institution = institution;
	}
	public int getPhysicianspeid() {
		return physicianspeid;
	}
	public void setPhysicianspeid(int physicianspeid) {
		this.physicianspeid = physicianspeid;
	}
	public int getPhysicianid() {
		return physicianid;
	}
	public void setPhysicianid(int physicianid) {
		this.physicianid = physicianid;
	}
	public int getSpecialitytypeid() {
		return specialitytypeid;
	}
	public void setSpecialitytypeid(int specialitytypeid) {
		this.specialitytypeid = specialitytypeid;
	}
	public int getQualtypeid() {
		return qualtypeid;
	}
	public void setQualtypeid(int qualtypeid) {
		this.qualtypeid = qualtypeid;
	}
	public int getYearqualified() {
		return yearqualified;
	}
	public void setYearqualified(int yearqualified) {
		this.yearqualified = yearqualified;
	}
	public int getInstitution() {
		return institution;
	}
	public void setInstitution(int institution) {
		this.institution = institution;
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
