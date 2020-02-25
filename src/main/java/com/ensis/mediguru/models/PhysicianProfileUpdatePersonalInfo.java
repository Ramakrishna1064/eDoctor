/**
 * 
 */
package com.ensis.mediguru.models;

import java.util.ArrayList;


/**
 * @author Venu
 *
 */
public class PhysicianProfileUpdatePersonalInfo {

	private int physicianid;
	private String firstname;
	private String lastname;
	private String dob;
	private String mobile;
	private String skypeid;
	private String officephone;
	private String address1;
	private String address2;
	private String city;
	private Integer stateid;
	private Integer cid;
	private String zip;
	private String about;
	private int imgid;
	
	private ArrayList<Integer> languageTypes;
	
	

	/**
	 * @return the imgid
	 */
	public int getImgid() {
		return imgid;
	}

	/**
	 * @param imgid the imgid to set
	 */
	public void setImgid(int imgid) {
		this.imgid = imgid;
	}

	/**
	 * @return the physicianid
	 */
	public int getPhysicianid() {
		return physicianid;
	}

	/**
	 * @param physicianid the physicianid to set
	 */
	public void setPhysicianid(int physicianid) {
		this.physicianid = physicianid;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the skypeid
	 */
	public String getSkypeid() {
		return skypeid;
	}

	/**
	 * @param skypeid the skypeid to set
	 */
	public void setSkypeid(String skypeid) {
		this.skypeid = skypeid;
	}

	/**
	 * @return the officephone
	 */
	public String getOfficephone() {
		return officephone;
	}

	/**
	 * @param officephone the officephone to set
	 */
	public void setOfficephone(String officephone) {
		this.officephone = officephone;
	}

	/**
	 * @return the address1
	 */
	public String getAddress1() {
		return address1;
	}

	/**
	 * @param address1 the address1 to set
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}

	/**
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the stateid
	 */
	public Integer getStateid() {
		return stateid;
	}

	/**
	 * @param stateid the stateid to set
	 */
	public void setStateid(Integer stateid) {
		this.stateid = stateid;
	}

	/**
	 * @return the cid
	 */
	public Integer getCid() {
		return cid;
	}

	/**
	 * @param cid the cid to set
	 */
	public void setCid(Integer cid) {
		this.cid = cid;
	}

	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * @return the about
	 */
	public String getAbout() {
		return about;
	}

	/**
	 * @param about the about to set
	 */
	public void setAbout(String about) {
		this.about = about;
	}

	/**
	 * @return the languageTypes
	 */
	public ArrayList<Integer> getLanguageTypes() {
		return languageTypes;
	}

	/**
	 * @param languageTypes the languageTypes to set
	 */
	public void setLanguageTypes(ArrayList<Integer> languageTypes) {
		this.languageTypes = languageTypes;
	}
	
}
