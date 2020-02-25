package com.ensis.mediguru.dto;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "physicianlanguage")
public class PhysicianLanguage {
	@Id
	private int phylangid;
	
	@Column(name = "physicianid")
	private int physicianid;
	
	@Column(name = "langtypeid")
	private int langtypeid;
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "createdby")
	private String createdby;
	
	@Column(name = "createddate")
	private Date createddate;
	
	@Column(name = "updatedby")
	private String updatedby;
	
	@Column(name = "updateddate")
	private Date updateddate;

	public PhysicianLanguage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhysicianLanguage(int physicianid, int langtypeid) {
		super();
		this.physicianid = physicianid;
		this.langtypeid = langtypeid;
	}

	public PhysicianLanguage(int langtypeid) {
		super();
		this.langtypeid = langtypeid;
	}

	public int getPhylangid() {
		return phylangid;
	}

	public void setPhylangid(int phylangid) {
		this.phylangid = phylangid;
	}

	public int getPhysicianid() {
		return physicianid;
	}

	public void setPhysicianid(int physicianid) {
		this.physicianid = physicianid;
	}

	public int getLangtypeid() {
		return langtypeid;
	}

	public void setLangtypeid(int langtypeid) {
		this.langtypeid = langtypeid;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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
