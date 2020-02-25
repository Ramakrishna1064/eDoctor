package com.ensis.mediguru.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country {

	@Id
	private int cid;
	@Column(name = "name")
	private String name;

	/*
	 * @Column(name = "code") private String code;
	 * 
	 * @Column(name = "description") private String description;
	 * 
	 * @Column(name = "createdby") private String createdby;
	 * 
	 * @Column(name = "createddate") private Date createddate;
	 * 
	 * @Column(name = "updatedby") private String updatedby;
	 * 
	 * @Column(name = "updateddate") private Date updateddate;
	 */

	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	
}
