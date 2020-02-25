package com.ensis.mediguru.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="availabilitytype")
public class AvailabilityType {
	@Id
	private int availtypeid;
	@Column(name = "name")
	private String name;	
	@Column(name = "code")
	private String code;	
	@Column(name = "description")
	private String description;	
	@Column(name = "createdby")
	private String createdby;
	@Column(name = "createddate")
	private Date createddate;
	@Column(name = "updatedby")
	private String updatedby;
	@Column(name = "updateddate")
	private Date updateddate;
	public AvailabilityType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AvailabilityType(String name) {
		super();
		this.name = name;
	}
	public int getAvailtypeid() {
		return availtypeid;
	}
	public void setAvailtypeid(int availtypeid) {
		this.availtypeid = availtypeid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
