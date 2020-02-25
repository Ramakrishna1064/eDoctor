package com.ensis.mediguru.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patientmedicinetimings")
public class PatientMedicineTimings {

	@Id
	private int id;

	@Column(name = "patientmedicaldataid")
	private int patientmedicaldataid;

	@Column(name = "medicinetimingsid")
	private int medicinetimingsid;

	public PatientMedicineTimings() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPatientmedicaldataid() {
		return patientmedicaldataid;
	}

	public void setPatientmedicaldataid(int patientmedicaldataid) {
		this.patientmedicaldataid = patientmedicaldataid;
	}

	public int getMedicinetimingsid() {
		return medicinetimingsid;
	}

	public void setMedicinetimingsid(int medicinetimingsid) {
		this.medicinetimingsid = medicinetimingsid;
	}

}
