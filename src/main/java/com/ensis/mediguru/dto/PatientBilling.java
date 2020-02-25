package com.ensis.mediguru.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table(name= "patientbilling")
public class PatientBilling {

	@Id
	private int patientbillingid;
	@Column(name = "patientid")
	private int patientid;
	@Column(name = "paymenttypeid")
	private int paymenttypeid;
	@Column(name = "cardoraccountnum")
	private String cardoraccountnum;
	@Column(name = "cardoraccountname")
	private String cardoraccountname;
	@Column(name = "expirydate")
	private String expirydate;
	@Column(name = "ccv")
	private String cvv;
	@Column(name = "createdby")
	private String createdby;
	@Column(name = "createddate")
	private Date createddate;
	@Column(name = "updatedby")
	private String updatedby;
	@Column(name = "updateddate")
	private Date updateddate;
	public PatientBilling() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PatientBilling(int patientbillingid, int patientid,
			int paymenttypeid, String cardoraccountnum,
			String cardoraccountname, String expirydate, String cvv,
			String createdby, Date createddate, String updatedby,
			Date updateddate) {
		super();
		this.patientbillingid = patientbillingid;
		this.patientid = patientid;
		this.paymenttypeid = paymenttypeid;
		this.cardoraccountnum = cardoraccountnum;
		this.cardoraccountname = cardoraccountname;
		this.expirydate = expirydate;
		this.cvv = cvv;
		this.createdby = createdby;
		this.createddate = createddate;
		this.updatedby = updatedby;
		this.updateddate = updateddate;
	}
	public int getPatientbillingid() {
		return patientbillingid;
	}
	public void setPatientbillingid(int patientbillingid) {
		this.patientbillingid = patientbillingid;
	}
	public int getPatientid() {
		return patientid;
	}
	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}
	public int getPaymenttypeid() {
		return paymenttypeid;
	}
	public void setPaymenttypeid(int paymenttypeid) {
		this.paymenttypeid = paymenttypeid;
	}
	public String getCardoraccountnum() {
		return cardoraccountnum;
	}
	public void setCardoraccountnum(String cardoraccountnum) {
		this.cardoraccountnum = cardoraccountnum;
	}
	public String getCardoraccountname() {
		return cardoraccountname;
	}
	public void setCardoraccountname(String cardoraccountname) {
		this.cardoraccountname = cardoraccountname;
	}
	public String getExpirydate() {
		return expirydate;
	}
	public void setExpirydate(String expirydate) {
		this.expirydate = expirydate;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
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
