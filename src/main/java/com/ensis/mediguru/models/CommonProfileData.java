/**
 * 
 */
package com.ensis.mediguru.models;

import java.util.ArrayList;

import com.ensis.mediguru.dto.ClinicServices;
import com.ensis.mediguru.dto.Country;
import com.ensis.mediguru.dto.LanguageType;
import com.ensis.mediguru.dto.QualificationType;
import com.ensis.mediguru.dto.SpecialityType;
import com.ensis.mediguru.dto.State;

/**
 * @author Venu
 *
 */
public class CommonProfileData {

	private ArrayList<SpecialityType> specialities=new ArrayList<SpecialityType>();

	private ArrayList<LanguageType> languages=new ArrayList<LanguageType>();;

	private ArrayList<QualificationType> qualificationsList=new ArrayList<QualificationType>();;

	private ArrayList<State> states=new ArrayList<State>();

	private ArrayList<Country> countries=new ArrayList<Country>();

	private ArrayList<ClinicServices> clinicServices=new ArrayList<ClinicServices>();

	public ArrayList<SpecialityType> getSpecialities() {
		return specialities;
	}

	public void setSpecialities(ArrayList<SpecialityType> specialities) {
		this.specialities = specialities;
	}

	public ArrayList<LanguageType> getLanguages() {
		return languages;
	}

	public void setLanguages(ArrayList<LanguageType> languages) {
		this.languages = languages;
	}

	public ArrayList<QualificationType> getQualificationsList() {
		return qualificationsList;
	}

	public void setQualificationsList(
			ArrayList<QualificationType> qualificationsList) {
		this.qualificationsList = qualificationsList;
	}

	public ArrayList<State> getStates() {
		return states;
	}

	public void setStates(ArrayList<State> states) {
		this.states = states;
	}

	public ArrayList<Country> getCountries() {
		return countries;
	}

	public void setCountries(ArrayList<Country> countries) {
		this.countries = countries;
	}

	public ArrayList<ClinicServices> getClinicServices() {
		return clinicServices;
	}

	public void setClinicServices(ArrayList<ClinicServices> clinicServices) {
		this.clinicServices = clinicServices;
	}
}
