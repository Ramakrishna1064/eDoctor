/**
 * 
 */
package com.ensis.mediguru.models;

import java.util.ArrayList;

/**
 * @author Venu
 *
 */
public class PhysicianDashBoardModel {

	private int favcount;
	private int familycount;
	private int ongoingcount;
	private int inperson;
	private int phonecall;
	private int videocall;
	private int remindercount;
	//private ArrayList<PhysicianSchedulesModel> schedules;
	private ArrayList<PhysicianOngoingScheduleModel> schedules;
	
	/**
	 * @return the favcount
	 */
	public int getFavcount() {
		return favcount;
	}
	/**
	 * @param favcount the favcount to set
	 */
	public void setFavcount(int favcount) {
		this.favcount = favcount;
	}
	/**
	 * @return the familycount
	 */
	public int getFamilycount() {
		return familycount;
	}
	/**
	 * @param familycount the familycount to set
	 */
	public void setFamilycount(int familycount) {
		this.familycount = familycount;
	}
	/**
	 * @return the ongoingcount
	 */
	public int getOngoingcount() {
		return ongoingcount;
	}
	/**
	 * @param ongoingcount the ongoingcount to set
	 */
	public void setOngoingcount(int ongoingcount) {
		this.ongoingcount = ongoingcount;
	}
	/**
	 * @return the inperson
	 */
	public int getInperson() {
		return inperson;
	}
	/**
	 * @param inperson the inperson to set
	 */
	public void setInperson(int inperson) {
		this.inperson = inperson;
	}
	/**
	 * @return the phonecall
	 */
	public int getPhonecall() {
		return phonecall;
	}
	/**
	 * @param phonecall the phonecall to set
	 */
	public void setPhonecall(int phonecall) {
		this.phonecall = phonecall;
	}
	/**
	 * @return the videocall
	 */
	public int getVideocall() {
		return videocall;
	}
	/**
	 * @param videocall the videocall to set
	 */
	public void setVideocall(int videocall) {
		this.videocall = videocall;
	}
	/**
	 * @return the remindercount
	 */
	public int getRemindercount() {
		return remindercount;
	}
	/**
	 * @param remindercount the remindercount to set
	 */
	public void setRemindercount(int remindercount) {
		this.remindercount = remindercount;
	}
	/**
	 * @return the schedules
	 */
	public ArrayList<PhysicianOngoingScheduleModel> getSchedules() {
		return schedules;
	}
	/**
	 * @param schedules the schedules to set
	 */
	public void setSchedules(ArrayList<PhysicianOngoingScheduleModel> schedules) {
		this.schedules = schedules;
	}
	
}
