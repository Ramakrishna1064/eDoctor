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
@Table(name = "facilityservices")
public class ClinicServices {

	@Id
	private int id;

	@Column(name = "servicename")
	private String servicename;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getServicename() {
		return servicename;
	}

	public void setServicename(String servicename) {
		this.servicename = servicename;
	}

}
