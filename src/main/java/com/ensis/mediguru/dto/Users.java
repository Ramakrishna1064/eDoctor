package com.ensis.mediguru.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

	@Id
	private int userid;

	@Column(name = "usertypeid")
	private int usertypeid;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "passwordotp")
	private int passwordotp;

	@Column(name = "otpexpiration")
	private Date otpexpiration;

	@Column(name = "lastsuccessfullogin")
	private Date lastsuccessfulllogin;

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

	public Users(int userid, int usertypeid, String email, String password,
			int passwordotp, Date otpexpiration, Date lastsuccessfulllogin,
			int status, String createdby, Date createddate, String updatedby,
			Date updateddate) {
		super();
		this.userid = userid;
		this.usertypeid = usertypeid;
		this.email = email;
		this.password = password;
		this.passwordotp = passwordotp;
		this.otpexpiration = otpexpiration;
		this.lastsuccessfulllogin = lastsuccessfulllogin;
		this.status = status;
		this.createdby = createdby;
		this.createddate = createddate;
		this.updatedby = updatedby;
		this.updateddate = updateddate;
	}

	// instant registration
	public Users(int usertypeid, String email, String password, int passwordotp) {
		super();

		this.usertypeid = usertypeid;
		this.email = email;
		this.password = password;
		this.passwordotp = passwordotp;
	}

	// forgot password(change the password)
	public Users(int passwordotp, String password) {
		super();
		this.passwordotp = passwordotp;
		this.password = password;
	}

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getUsertypeid() {
		return usertypeid;
	}

	public void setUsertypeid(int usertypeid) {
		this.usertypeid = usertypeid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPasswordotp() {
		return passwordotp;
	}

	public void setPasswordotp(int passwordotp) {
		this.passwordotp = passwordotp;
	}

	public Date getOtpexpiration() {
		return otpexpiration;
	}

	public void setOtpexpiration(Date otpexpiration) {
		this.otpexpiration = otpexpiration;
	}

	public Date getLastsuccessfulllogin() {
		return lastsuccessfulllogin;
	}

	public void setLastsuccessfulllogin(Date lastsuccessfulllogin) {
		this.lastsuccessfulllogin = lastsuccessfulllogin;
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
