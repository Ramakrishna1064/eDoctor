/**
 * 
 */
package com.ensis.mediguru.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Venu
 *
 */

@Entity
@Table(name = "patientphysicians")
public class PatientPhysicians {

	@Id
	private int id;
	@Column(name = "patientid")
	private int patientid;
	@Column(name = "physicianid")
	private int physicianid;
	@Column(name = "physiciantypeid")
	private int physiciantypeid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPatientid() {
		return patientid;
	}

	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}

	public int getPhysicianid() {
		return physicianid;
	}

	public void setPhysicianid(int physicianid) {
		this.physicianid = physicianid;
	}

	public int getPhysiciantypeid() {
		return physiciantypeid;
	}

	public void setPhysiciantypeid(int physiciantypeid) {
		this.physiciantypeid = physiciantypeid;
	}

}
