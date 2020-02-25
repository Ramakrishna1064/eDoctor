package com.ensis.mediguru.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "specilitytype")
public class SpecialityType {

	@Id
	private int specialitytypeid;

	@Column(name = "specialityname")
	private String specialityname;

	public int getSpecialitytypeid() {
		return specialitytypeid;
	}

	public void setSpecialitytypeid(int specialitytypeid) {
		this.specialitytypeid = specialitytypeid;
	}

	public String getSpecialityname() {
		return specialityname;
	}

	public void setSpecialityname(String specialityname) {
		this.specialityname = specialityname;
	}

}
