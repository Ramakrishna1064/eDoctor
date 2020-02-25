/**
 * 
 */
package com.ensis.mediguru.models;

import java.util.ArrayList;

/**
 * @author Venu
 *
 */
public class PhysicianFavoriteAndFamilyBean {

	private int patientId;
	private int doctorId;
	private ArrayList<Integer> types;

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public ArrayList<Integer> getTypes() {
		return types;
	}

	public void setTypes(ArrayList<Integer> types) {
		this.types = types;
	}

}
