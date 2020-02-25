/**
 * 
 */
package com.ensis.mediguru.models;

/**
 * @author Venu
 *
 */
public class PatientPhysiciansModel {

	int physicianid, speciality, imgid, stateid, cid;
	private int firstvisitfee;
	public String getSkypeid() {
		return skypeid;
	}

	public void setSkypeid(String skypeid) {
		this.skypeid = skypeid;
	}

	private int followupvisitfee;

	String firstname, lastname, dob, mobile, officephone, skypeid,address1, address2,
			city, zip, country, state, specialitytype, about, imageUrl,
			physiciantypeid;

	boolean isInpersonAppointment, isVirtualPhoneAppointment,
			isVirtualSkypeAppointment, isFavoritePhysician, isFamilyPhysician,
			isOngoingPhysician;

	
	
	/**
	 * @return the firstvisitfee
	 */
	public int getFirstvisitfee() {
		return firstvisitfee;
	}

	/**
	 * @param firstvisitfee the firstvisitfee to set
	 */
	public void setFirstvisitfee(int firstvisitfee) {
		this.firstvisitfee = firstvisitfee;
	}

	/**
	 * @return the followupvisitfee
	 */
	public int getFollowupvisitfee() {
		return followupvisitfee;
	}

	/**
	 * @param followupvisitfee the followupvisitfee to set
	 */
	public void setFollowupvisitfee(int followupvisitfee) {
		this.followupvisitfee = followupvisitfee;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getPhysiciantypeid() {
		return physiciantypeid;
	}

	public void setPhysiciantypeid(String physiciantypeid) {
		this.physiciantypeid = physiciantypeid;
	}

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

	public int getImgid() {
		return imgid;
	}

	public void setImgid(int imgid) {
		this.imgid = imgid;
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

}
