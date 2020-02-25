/**
 * 
 */
package com.ensis.mediguru.models;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Venu
 *
 */
public class PhysicianFacilityPracticeLocationsModel {

	private String facilityname;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String country;

	private String zip;
	private String mobile1;
	private String mobile2;

	private boolean isacceptleagul;
	private boolean isacceptecompliance;

	private List<String> serviceNamesList=new ArrayList<String>();
	private List<String> locationNamesList=new ArrayList<String>();
	
	private ArrayList<String> imageUrls=new ArrayList<String>();
	
	
	
	/**
	 * @return the imageUrls
	 */
	public ArrayList<String> getImageUrls() {
		return imageUrls;
	}
	/**
	 * @param imageUrls the imageUrls to set
	 */
	public void setImageUrls(ArrayList<String> imageUrls) {
		this.imageUrls = imageUrls;
	}
	
	/**
	 * @return the facilityname
	 */
	public String getFacilityname() {
		return facilityname;
	}
	/**
	 * @param facilityname the facilityname to set
	 */
	public void setFacilityname(String facilityname) {
		this.facilityname = facilityname;
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
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
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
	 * @return the mobile1
	 */
	public String getMobile1() {
		return mobile1;
	}
	/**
	 * @param mobile1 the mobile1 to set
	 */
	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}
	/**
	 * @return the mobile2
	 */
	public String getMobile2() {
		return mobile2;
	}
	/**
	 * @param mobile2 the mobile2 to set
	 */
	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}
	/**
	 * @return the isacceptleagul
	 */
	public boolean isIsacceptleagul() {
		return isacceptleagul;
	}
	/**
	 * @param isacceptleagul the isacceptleagul to set
	 */
	public void setIsacceptleagul(boolean isacceptleagul) {
		this.isacceptleagul = isacceptleagul;
	}
	/**
	 * @return the isacceptecompliance
	 */
	public boolean isIsacceptecompliance() {
		return isacceptecompliance;
	}
	/**
	 * @param isacceptecompliance the isacceptecompliance to set
	 */
	public void setIsacceptecompliance(boolean isacceptecompliance) {
		this.isacceptecompliance = isacceptecompliance;
	}
	/**
	 * @return the serviceNamesList
	 */
	public List<String> getServiceNamesList() {
		return serviceNamesList;
	}
	/**
	 * @param serviceNamesList the serviceNamesList to set
	 */
	public void setServiceNamesList(List<String> serviceNamesList) {
		this.serviceNamesList = serviceNamesList;
	}
	/**
	 * @return the locationNamesList
	 */
	public List<String> getLocationNamesList() {
		return locationNamesList;
	}
	/**
	 * @param locationNamesList the locationNamesList to set
	 */
	public void setLocationNamesList(List<String> locationNamesList) {
		this.locationNamesList = locationNamesList;
	}
	
	
}
