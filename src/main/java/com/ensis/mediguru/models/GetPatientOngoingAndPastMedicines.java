package com.ensis.mediguru.models;


public class GetPatientOngoingAndPastMedicines {

	private GetPatientOngoingMedicinesModel OngoingMedicines=new GetPatientOngoingMedicinesModel();
	private GetPatientPastMedicines pastMedicines=new GetPatientPastMedicines();

	/**
	 * @return the ongoingMedicines
	 */
	public GetPatientOngoingMedicinesModel getOngoingMedicines() {
		return OngoingMedicines;
	}

	/**
	 * @param ongoingMedicines the ongoingMedicines to set
	 */
	public void setOngoingMedicines(GetPatientOngoingMedicinesModel ongoingMedicines) {
		OngoingMedicines = ongoingMedicines;
	}

	/**
	 * @return the pastMedicines
	 */
	public GetPatientPastMedicines getPastMedicines() {
		return pastMedicines;
	}

	/**
	 * @param pastMedicines the pastMedicines to set
	 */
	public void setPastMedicines(GetPatientPastMedicines pastMedicines) {
		this.pastMedicines = pastMedicines;
	}
	
	

	
	
}
