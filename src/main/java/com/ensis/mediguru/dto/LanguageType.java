package com.ensis.mediguru.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "languagetype")
public class LanguageType {

	@Id
	private int langtypeid;
	@Column(name = "name")
	private String name;

	public int getLangtypeid() {
		return langtypeid;
	}

	public void setLangtypeid(int langtypeid) {
		this.langtypeid = langtypeid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LanguageType() {
		super();
		// TODO Auto-generated constructor stub
	}

}
