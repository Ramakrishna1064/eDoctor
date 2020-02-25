/**
 * 
 */
package com.ensis.mediguru.models;

/**
 * @author Venu
 *
 */
public class PatientAcceptAppointmentModel {

	private int treatmentquestionid;
	private int patientid;
	private int physicianid;
	
	
	/**
	 * @return the treatmentquestionid
	 */
	public int getTreatmentquestionid() {
		return treatmentquestionid;
	}
	/**
	 * @param treatmentquestionid the treatmentquestionid to set
	 */
	public void setTreatmentquestionid(int treatmentquestionid) {
		this.treatmentquestionid = treatmentquestionid;
	}
	/**
	 * @return the patientid
	 */
	public int getPatientid() {
		return patientid;
	}
	/**
	 * @param patientid the patientid to set
	 */
	public void setPatientid(int patientid) {
		this.patientid = patientid;
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
	
}
