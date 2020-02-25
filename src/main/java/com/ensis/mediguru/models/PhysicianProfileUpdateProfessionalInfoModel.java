/**
 * 
 */
package com.ensis.mediguru.models;

import java.util.ArrayList;

/**
 * @author Venu
 *
 */
public class PhysicianProfileUpdateProfessionalInfoModel {
	
	private int physicianid;

	// physiciansspeciality -- table
	private ArrayList<PhysicianSpecialityAndQualificationsModel> specialityAndQualifications;

	// physicianprofessionainfo -- table
	private String practicestartdate;
	private int firstvisitfee;
	private int followupvisitfee;
	private boolean personAppointment;
	private boolean virtualPhoneAppointment;
	private boolean virtualSkypeAppointment;

	// physicianavailability -- table
	private ArrayList<AvailabilityTimingsModel> availabilityTimings;
	
	

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
	 * @return the specialityAndQualifications
	 */
	public ArrayList<PhysicianSpecialityAndQualificationsModel> getSpecialityAndQualifications() {
		return specialityAndQualifications;
	}

	/**
	 * @param specialityAndQualifications the specialityAndQualifications to set
	 */
	public void setSpecialityAndQualifications(
			ArrayList<PhysicianSpecialityAndQualificationsModel> specialityAndQualifications) {
		this.specialityAndQualifications = specialityAndQualifications;
	}

	/**
	 * @return the practicestartdate
	 */
	public String getPracticestartdate() {
		return practicestartdate;
	}

	/**
	 * @param practicestartdate the practicestartdate to set
	 */
	public void setPracticestartdate(String practicestartdate) {
		this.practicestartdate = practicestartdate;
	}

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

	/**
	 * @return the personAppointment
	 */
	public boolean isPersonAppointment() {
		return personAppointment;
	}

	/**
	 * @param personAppointment the personAppointment to set
	 */
	public void setPersonAppointment(boolean personAppointment) {
		this.personAppointment = personAppointment;
	}

	/**
	 * @return the virtualPhoneAppointment
	 */
	public boolean isVirtualPhoneAppointment() {
		return virtualPhoneAppointment;
	}

	/**
	 * @param virtualPhoneAppointment the virtualPhoneAppointment to set
	 */
	public void setVirtualPhoneAppointment(boolean virtualPhoneAppointment) {
		this.virtualPhoneAppointment = virtualPhoneAppointment;
	}

	/**
	 * @return the virtualSkypeAppointment
	 */
	public boolean isVirtualSkypeAppointment() {
		return virtualSkypeAppointment;
	}

	/**
	 * @param virtualSkypeAppointment the virtualSkypeAppointment to set
	 */
	public void setVirtualSkypeAppointment(boolean virtualSkypeAppointment) {
		this.virtualSkypeAppointment = virtualSkypeAppointment;
	}

	/**
	 * @return the availabilityTimings
	 */
	public ArrayList<AvailabilityTimingsModel> getAvailabilityTimings() {
		return availabilityTimings;
	}

	/**
	 * @param availabilityTimings the availabilityTimings to set
	 */
	public void setAvailabilityTimings(
			ArrayList<AvailabilityTimingsModel> availabilityTimings) {
		this.availabilityTimings = availabilityTimings;
	}
	
	

}
