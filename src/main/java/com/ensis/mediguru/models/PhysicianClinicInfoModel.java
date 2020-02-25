package com.ensis.mediguru.models;

import java.util.ArrayList;

public class PhysicianClinicInfoModel {

	private String clinicName;
	private String address1;
	private String address2;
	private String city;
	private int stateid;
	private int cid;

	private String zip;
	private String mobile1;
	private String mobile2;

	private boolean acceptleagul;
	private boolean acceptecompliance;
	
	//physicianfaclservice
	private ArrayList<String> services;
	
	//physicianpracticeplaces
	private ArrayList<String> practiceLocations;

	public String getClinicName() {
		return clinicName;
	}

	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
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

	
	public boolean isAcceptleagul() {
		return acceptleagul;
	}

	public void setAcceptleagul(boolean acceptleagul) {
		this.acceptleagul = acceptleagul;
	}

	public boolean isAcceptecompliance() {
		return acceptecompliance;
	}

	public void setAcceptecompliance(boolean acceptecompliance) {
		this.acceptecompliance = acceptecompliance;
	}

	public ArrayList<String> getPracticeLocations() {
		return practiceLocations;
	}

	public void setPracticeLocations(ArrayList<String> practiceLocations) {
		this.practiceLocations = practiceLocations;
	}

	public ArrayList<String> getServices() {
		return services;
	}

	public void setServices(ArrayList<String> services) {
		this.services = services;
	}
	
	

}
