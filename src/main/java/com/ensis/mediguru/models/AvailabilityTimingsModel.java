/**
 * 
 */
package com.ensis.mediguru.models;

import java.util.ArrayList;

/**
 * @author Venu
 *
 */
public class AvailabilityTimingsModel {

	private String fromDay;
	private String toDay;

	private ArrayList<AvailabilityTimeModel> timings=new ArrayList<AvailabilityTimeModel>();

	public String getFromDay() {
		return fromDay;
	}

	public void setFromDay(String fromDay) {
		this.fromDay = fromDay;
	}

	public String getToDay() {
		return toDay;
	}

	public void setToDay(String toDay) {
		this.toDay = toDay;
	}

	public ArrayList<AvailabilityTimeModel> getTimings() {
		return timings;
	}

	public void setTimings(ArrayList<AvailabilityTimeModel> timings) {
		this.timings = timings;
	}

	

}
