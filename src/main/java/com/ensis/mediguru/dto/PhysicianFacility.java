package com.ensis.mediguru.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="physicianfacility")
public class PhysicianFacility {
	
	@Id
	private int physicianfacilityid;
	
	@Column(name = "physicianid")
	private int physicianid;
	
	@Column(name = "facilityname")
	private String facilityname;
	
	@Column(name = "address1")
	private String address1;
	
	@Column(name = "address2")
	private String address2;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "stateid")
	private int stateid;
	
	@Column(name = "cid")
	private int cid;
	
	@Column(name = "zip")
	private String zip;
	
	@Column(name = "mobile1")
	private String mobile1;
	
	@Column(name = "mobile2")
	private String mobile2;
	
	@Column(name = "imagegallery")
	private String imagegallery;
	
	@Column(name = "isacceptleagul")
	private boolean acceptleagul;
	
	@Column(name = "isacceptecompliance")
	private boolean acceptecompliance;	
	
	@Column(name = "createdby")
	private String createdby;
	
	@Column(name = "createddate")
	private Date createddate;
	
	@Column(name = "updatedby")
	private String updatedby;
	
	@Column(name = "updateddate")
	private Date updateddate;
	
	public PhysicianFacility() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPhysicianfacilityid() {
		return physicianfacilityid;
	}

	public void setPhysicianfacilityid(int physicianfacilityid) {
		this.physicianfacilityid = physicianfacilityid;
	}

	public int getPhysicianid() {
		return physicianid;
	}

	public void setPhysicianid(int physicianid) {
		this.physicianid = physicianid;
	}

	public String getFacilityname() {
		return facilityname;
	}

	public void setFacilityname(String facilityname) {
		this.facilityname = facilityname;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getStateid() {
		return stateid;
	}

	public void setStateid(int stateid) {
		this.stateid = stateid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getMobile1() {
		return mobile1;
	}

	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}

	public String getMobile2() {
		return mobile2;
	}

	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}

	public String getImagegallery() {
		return imagegallery;
	}

	public void setImagegallery(String imagegallery) {
		this.imagegallery = imagegallery;
	}

	

	/**
	 * @return the acceptleagul
	 */
	public boolean isAcceptleagul() {
		return acceptleagul;
	}

	/**
	 * @param acceptleagul the acceptleagul to set
	 */
	public void setAcceptleagul(boolean acceptleagul) {
		this.acceptleagul = acceptleagul;
	}

	/**
	 * @return the acceptecompliance
	 */
	public boolean isAcceptecompliance() {
		return acceptecompliance;
	}

	/**
	 * @param acceptecompliance the acceptecompliance to set
	 */
	public void setAcceptecompliance(boolean acceptecompliance) {
		this.acceptecompliance = acceptecompliance;
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
