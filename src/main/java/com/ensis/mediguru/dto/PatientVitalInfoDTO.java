package com.ensis.mediguru.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patientvitalinfo")
public class PatientVitalInfoDTO {

	@Id
	private int vitalid;
	private int patientid;
	private String height;
	private String weight;
	private String heartrate;
	private String bloodpreasure;
	private String bodytemperature;
	private String sugarlevel;
	private Date createddate;
	private String updateddate;

	/**
	 * @return the vitalid
	 */
	public int getVitalid() {
		return vitalid;
	}

	/**
	 * @param vitalid
	 *            the vitalid to set
	 */
	public void setVitalid(int vitalid) {
		this.vitalid = vitalid;
	}

	/**
	 * @return the patientid
	 */
	public int getPatientid() {
		return patientid;
	}

	/**
	 * @param patientid
	 *            the patientid to set
	 */
	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}

	/**
	 * @return the height
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(String height) {
		this.height = height;
	}

	/**
	 * @return the weight
	 */
	public String getWeight() {
		return weight;
	}

	/**
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}

	/**
	 * @return the heartrate
	 */
	public String getHeartrate() {
		return heartrate;
	}

	/**
	 * @param heartrate
	 *            the heartrate to set
	 */
	public void setHeartrate(String heartrate) {
		this.heartrate = heartrate;
	}

	/**
	 * @return the bloodpreasure
	 */
	public String getBloodpreasure() {
		return bloodpreasure;
	}

	/**
	 * @param bloodpreasure
	 *            the bloodpreasure to set
	 */
	public void setBloodpreasure(String bloodpreasure) {
		this.bloodpreasure = bloodpreasure;
	}

	/**
	 * @return the bodytemperature
	 */
	public String getBodytemperature() {
		return bodytemperature;
	}

	/**
	 * @param bodytemperature
	 *            the bodytemperature to set
	 */
	public void setBodytemperature(String bodytemperature) {
		this.bodytemperature = bodytemperature;
	}

	/**
	 * @return the sugarlevel
	 */
	public String getSugarlevel() {
		return sugarlevel;
	}

	/**
	 * @param sugarlevel
	 *            the sugarlevel to set
	 */
	public void setSugarlevel(String sugarlevel) {
		this.sugarlevel = sugarlevel;
	}

	

	/**
	 * @return the createddate
	 */
	public Date getCreateddate() {
		return createddate;
	}

	/**
	 * @param createddate the createddate to set
	 */
	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	/**
	 * @return the updateddate
	 */
	public String getUpdateddate() {
		return updateddate;
	}

	/**
	 * @param updateddate
	 *            the updateddate to set
	 */
	public void setUpdateddate(String updateddate) {
		this.updateddate = updateddate;
	}

}
