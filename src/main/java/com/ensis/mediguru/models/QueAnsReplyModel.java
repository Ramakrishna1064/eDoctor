/**
 * 
 */
package com.ensis.mediguru.models;


/**
 * @author Venu
 *
 */
public class QueAnsReplyModel {

	private String reply;
	private Integer treatmentansid;
	private Integer postedby;	
	private String posteddate;
	/**
	 * @return the reply
	 */
	public String getReply() {
		return reply;
	}
	/**
	 * @param reply the reply to set
	 */
	public void setReply(String reply) {
		this.reply = reply;
	}
	/**
	 * @return the treatmentansid
	 */
	public Integer getTreatmentansid() {
		return treatmentansid;
	}
	/**
	 * @param treatmentansid the treatmentansid to set
	 */
	public void setTreatmentansid(Integer treatmentansid) {
		this.treatmentansid = treatmentansid;
	}
	/**
	 * @return the postedby
	 */
	public Integer getPostedby() {
		return postedby;
	}
	/**
	 * @param postedby the postedby to set
	 */
	public void setPostedby(Integer postedby) {
		this.postedby = postedby;
	}
	/**
	 * @return the posteddate
	 */
	public String getPosteddate() {
		return posteddate;
	}
	/**
	 * @param posteddate the posteddate to set
	 */
	public void setPosteddate(String posteddate) {
		this.posteddate = posteddate;
	}
	
	
	
}
