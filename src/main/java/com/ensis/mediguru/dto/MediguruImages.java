package com.ensis.mediguru.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity  
	@Table(name= "images")
	public class MediguruImages {

		@Id		
		private int imgid;	
		@Column(name = "imagename")
		private String imagename;		
		@Column(name = "createdby")
		private String createdby;
		@Column(name = "createddate")
		private Date createddate;
		@Column(name = "updatedby")
		private String updatedby;
		@Column(name = "updatedate")
		private Date updatedate;
		public MediguruImages() {
			super();
			// TODO Auto-generated constructor stub
		}
		public MediguruImages(int imgid, String imagename) {
			super();
			this.imgid = imgid;
			this.imagename = imagename;
		}
		public int getImgid() {
			return imgid;
		}
		public void setImgid(int imgid) {
			this.imgid = imgid;
		}
		public String getImagename() {
			return imagename;
		}
		public void setImagename(String imagename) {
			this.imagename = imagename;
		}
		public String getCreatedby() {
			return createdby;
		}
		public void setCreatedby(String createdby) {
			this.createdby = createdby;
		}
		public Date getCreateddate() {
			return createddate;
		}
		public void setCreateddate(Date createddate) {
			this.createddate = createddate;
		}
		public String getUpdatedby() {
			return updatedby;
		}
		public void setUpdatedby(String updatedby) {
			this.updatedby = updatedby;
		}
		public Date getUpdatedate() {
			return updatedate;
		}
		public void setUpdatedate(Date updatedate) {
			this.updatedate = updatedate;
		}
	
}

