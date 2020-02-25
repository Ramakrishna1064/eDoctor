/**
 * 
 */
package com.ensis.mediguru.models;

/**
 * @author shyam
 *
 */
public class MyPhysiciansModel {

	private int physicianid;
	private int speciality;
	private int firstvisitfee;
	private int followupvisitfee;

	private String firstname;
	private String lastname;
	private String dob;
	private String mobile;
	private String officephone;
	private String skypeid;
	private String address1;
	private String address2;
	private String city;
	private String zip;
	private String country;
	private String state;
	private String specialitytype;
	private String about;
	private String imageUrl;

	boolean isInpersonAppointment;
	boolean isVirtualPhoneAppointment;
	boolean	isVirtualSkypeAppointment;
	boolean isFavoritePhysician;
	boolean isFamilyPhysician;
	boolean	isOngoingPhysician;
	
	private double rating;

	public int getPhysicianid() {
		return physicianid;
	}

	public void setPhysicianid(int physicianid) {
		this.physicianid = physicianid;
	}

	public int getSpeciality() {
		return speciality;
	}

	public void setSpeciality(int speciality) {
		this.speciality = speciality;
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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getOfficephone() {
		return officephone;
	}

	public void setOfficephone(String officephone) {
		this.officephone = officephone;
	}

	public String getSkypeid() {
		return skypeid;
	}

	public void setSkypeid(String skypeid) {
		this.skypeid = skypeid;
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

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSpecialitytype() {
		return specialitytype;
	}

	public void setSpecialitytype(String specialitytype) {
		this.specialitytype = specialitytype;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public boolean isInpersonAppointment() {
		return isInpersonAppointment;
	}

	public void setInpersonAppointment(boolean isInpersonAppointment) {
		this.isInpersonAppointment = isInpersonAppointment;
	}

	public boolean isVirtualPhoneAppointment() {
		return isVirtualPhoneAppointment;
	}

	public void setVirtualPhoneAppointment(boolean isVirtualPhoneAppointment) {
		this.isVirtualPhoneAppointment = isVirtualPhoneAppointment;
	}

	public boolean isVirtualSkypeAppointment() {
		return isVirtualSkypeAppointment;
	}

	public void setVirtualSkypeAppointment(boolean isVirtualSkypeAppointment) {
		this.isVirtualSkypeAppointment = isVirtualSkypeAppointment;
	}

	public boolean isFavoritePhysician() {
		return isFavoritePhysician;
	}

	public void setFavoritePhysician(boolean isFavoritePhysician) {
		this.isFavoritePhysician = isFavoritePhysician;
	}

	public boolean isFamilyPhysician() {
		return isFamilyPhysician;
	}

	public void setFamilyPhysician(boolean isFamilyPhysician) {
		this.isFamilyPhysician = isFamilyPhysician;
	}

	public boolean isOngoingPhysician() {
		return isOngoingPhysician;
	}

	public void setOngoingPhysician(boolean isOngoingPhysician) {
		this.isOngoingPhysician = isOngoingPhysician;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
	
}
