/**
 * 
 */
package com.ensis.mediguru.service.patient;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ensis.mediguru.dao.common.CommonDAO;
import com.ensis.mediguru.dao.patient.PatientRegistrationDAO;
import com.ensis.mediguru.dto.PatientBilling;
import com.ensis.mediguru.dto.PatientPreference;
import com.ensis.mediguru.dto.PatientRegistration;
import com.ensis.mediguru.dto.Users;
import com.ensis.mediguru.models.GetPatientProfileModel;
import com.ensis.mediguru.models.PatientProfileCompletionModel;
import com.ensis.mediguru.models.PatientRegistrationModel;
import com.ensis.mediguru.models.StatusObject;
import com.ensis.mediguru.utils.MessageResources;
import com.ensis.mediguru.utils.SendMail;
import com.ensis.mediguru.utils.Utilities;

/**
 * @author Venu
 *
 */
public class PatientRegistrationService extends MessageResources {

	@Autowired
	CommonDAO commonDAO;

	@Autowired
	PatientRegistrationDAO patientRegistrationDAO;

	@Autowired
	SendMail sendMail;

	public void setCommonDAO(CommonDAO commonDAO) {
		this.commonDAO = commonDAO;
	}

	public void setPatientRegistrationDAO(
			PatientRegistrationDAO patientRegistrationDAO) {
		this.patientRegistrationDAO = patientRegistrationDAO;
	}

	public void setSendMail(SendMail sendMail) {
		this.sendMail = sendMail;
	}

	@Transactional
	public StatusObject patientRegistration(
			PatientRegistrationModel patientRegistrationModel) {

		StatusObject statusObj = new StatusObject();
		// Check Email Id exists or Not
		long emailResult = commonDAO.checkEmailExists(patientRegistrationModel
				.getMailid());
		// System.out.println("Email Result---->"+emailResult);
		if (emailResult == 0) {

			Users userObj = new Users();
			userObj.setPasswordotp(Utilities.getRandomNumber()); // OTP
			userObj.setUsertypeid(1); // Because Patient is One
			userObj.setPassword(patientRegistrationModel.getPassword()); // Password
			userObj.setEmail(patientRegistrationModel.getMailid()); // Mail
			userObj.setCreatedby(patientRegistrationModel.getFirstname()); // Patient
																			// Name
			userObj.setCreateddate(new Date()); // Current Date

			// insert into Users table
			int userId = commonDAO.insertUserObj(userObj);
			if (userId == 0) {

				statusObj.setError(true);
				statusObj.setMessage(getMessage("registration.error.message"));
				return statusObj;

			} else {

				PatientRegistration patientRegistration = new PatientRegistration();
				patientRegistration.setUserid(userId);
				patientRegistration.setFirstname(patientRegistrationModel
						.getFirstname());
				patientRegistration.setLastname(patientRegistrationModel
						.getLastname());
				patientRegistration.setCreatedby(patientRegistrationModel
						.getFirstname());
				patientRegistration.setCreateddate(new Date());
				patientRegistrationDAO
						.insertPatientRegistration(patientRegistration);

				String dlink = getMessage("dlink");

				// Do it later Mr. Malli babu..... for dynamically using
				// message.properties

				String body = "Please find the verification link <a href='"
						+ dlink
						+ "?mailid="
						+ patientRegistrationModel.getMailid()
						+ "'>&nbsp;Click Here</a>"
						+ "<br><br>Please contact 'kris.ensis@gmail.com' if you have issues.";

				String recipients = patientRegistrationModel.getMailid();
				String subject = getMessage("registration.email.subject");

				// Send Email to Registered Mail
				sendMail.sendMail(recipients, subject, body);

				statusObj.setError(false);
				statusObj
						.setMessage(getMessage("registration.success.message"));
				return statusObj;

			}

		} else {
			statusObj.setError(true);
			statusObj.setMessage(getMessage("registration.email.exists"));
			return statusObj;
		}

	}

	@Transactional
	public StatusObject createPatientProfile(
			PatientProfileCompletionModel patientProfileCompletionModel) {
		StatusObject statusObj = new StatusObject();

		PatientRegistration patientRegistration = new PatientRegistration();

		patientRegistration.setFirstname(patientProfileCompletionModel
				.getFirstname());
		patientRegistration.setLastname(patientProfileCompletionModel
				.getLastname());
		patientRegistration.setPatientid(patientProfileCompletionModel
				.getPatientid());
		patientRegistration.setDob(patientProfileCompletionModel
				.getDateofbirth());
		patientRegistration.setMobile(patientProfileCompletionModel
				.getContactMobile());
		patientRegistration.setSkypeid(patientProfileCompletionModel
				.getSkypeid());
		// patient.setSkypeid(profile.getSkypeId());
		patientRegistration.setSkypeid(patientProfileCompletionModel
				.getSkypeid());
		patientRegistration.setContacthome(patientProfileCompletionModel
				.getContactHome());
		patientRegistration.setOfficephone(patientProfileCompletionModel
				.getContactOffice());
		patientRegistration.setAddress1(patientProfileCompletionModel
				.getAddress1());
		patientRegistration.setAddress2(patientProfileCompletionModel
				.getAddress2());
		patientRegistration.setCity(patientProfileCompletionModel.getCity());
		patientRegistration
				.setStateid(patientProfileCompletionModel.getState());
		patientRegistration.setCid(patientProfileCompletionModel.getCountry());
		patientRegistration.setZip(patientProfileCompletionModel.getZipcode());
		patientRegistration
				.setImgid(patientProfileCompletionModel.getImageid());

		// update the patient data in patient table.
		int response = patientRegistrationDAO
				.updatePatientRegistration(patientRegistration);
		// System.out.println("response---"+response);

		PatientBilling patientBilling = new PatientBilling();

		patientBilling.setPatientid(patientProfileCompletionModel
				.getPatientid());
		patientBilling.setPaymenttypeid(patientProfileCompletionModel
				.getPaymenttypeid());
		patientBilling.setCardoraccountnum(patientProfileCompletionModel
				.getCardNumber());
		patientBilling.setCardoraccountname(patientProfileCompletionModel
				.getCardHolderName());
		patientBilling.setExpirydate(patientProfileCompletionModel
				.getExpiryDate());
		patientBilling.setCvv(patientProfileCompletionModel.getCvv());
		patientBilling.setCreateddate(new Date());

		int patientCardDetailsResponse = patientRegistrationDAO
				.patientProfileCardDetails(patientBilling);
		// System.out.println("patientCardDetails---"+patientCardDetailsResponse);

		PatientPreference PatientPreference = new PatientPreference();

		PatientPreference.setPatientid(patientProfileCompletionModel
				.getPatientid());
		PatientPreference
				.setIssharemedicalhistory(patientProfileCompletionModel
						.isIsshareMedicalHistory());
		PatientPreference.setIsopentoalternatemed(patientProfileCompletionModel
				.isIsopenAlternateMedical());
		PatientPreference.setIssmsnotification(patientProfileCompletionModel
				.isIssmsNotification());
		PatientPreference.setIsemailnotification(patientProfileCompletionModel
				.isIsmailNotification());
		PatientPreference.setCreateddate(new Date());

		int patientPreferenceResponse = patientRegistrationDAO
				.patientPreferences(PatientPreference);
		// System.out.println("patientPreferenceResponse---"+patientPreferenceResponse);

		if (response == 1 && patientCardDetailsResponse == 1
				&& patientPreferenceResponse == 1) {
			statusObj.setError(false);
			statusObj.setMessage(getMessage("patient.profile.success.message"));
			return statusObj;

		} else {

			statusObj.setError(true);
			statusObj.setMessage(getMessage("patient.profile.failure.message"));
			return statusObj;

		}

	}

	/**
	 * 
	 * @param patientid
	 * @return
	 */
	@Transactional
	public GetPatientProfileModel getPatientProfile(int patientid) {
		return patientRegistrationDAO.getPatientProfile(patientid);

	}

	@Transactional
	public StatusObject updatePatientProfile(
			PatientProfileCompletionModel patientProfileCompletionModel) {
		StatusObject statusObj = new StatusObject();

		PatientRegistration patientRegistration = new PatientRegistration();

		patientRegistration.setPatientid(patientProfileCompletionModel
				.getPatientid());
		patientRegistration.setFirstname(patientProfileCompletionModel
				.getFirstname());
		patientRegistration.setLastname(patientProfileCompletionModel
				.getLastname());
		patientRegistration.setDob(patientProfileCompletionModel
				.getDateofbirth());
		patientRegistration.setMobile(patientProfileCompletionModel
				.getContactMobile());
		// patient.setSkypeid(profile.getSkypeId());
		patientRegistration.setContacthome(patientProfileCompletionModel
				.getContactHome());
		patientRegistration.setOfficephone(patientProfileCompletionModel
				.getContactOffice());
		patientRegistration.setAddress1(patientProfileCompletionModel
				.getAddress1());
		patientRegistration.setAddress2(patientProfileCompletionModel
				.getAddress2());
		patientRegistration.setCity(patientProfileCompletionModel.getCity());
		patientRegistration
				.setStateid(patientProfileCompletionModel.getState());
		patientRegistration.setCid(patientProfileCompletionModel.getCountry());
		patientRegistration.setZip(patientProfileCompletionModel.getZipcode());
		patientRegistration
				.setImgid(patientProfileCompletionModel.getImageid());
		patientRegistration.setSkypeid(patientProfileCompletionModel
				.getSkypeid());

		// update the patient data in patient table.
		boolean response = patientRegistrationDAO
				.updatePatientBasicInfo(patientRegistration);
		// System.out.println("response---"+response);

		// System.out.println("patientPreferenceResponse---"+patientPreferenceResponse);

		if (response) {
			statusObj.setError(false);
			statusObj
					.setMessage(getMessage("patient.profile.update.success.message"));
			return statusObj;

		} else {

			statusObj.setError(true);
			statusObj
					.setMessage(getMessage("patient.profile.update.failure.message"));
			return statusObj;

		}

	}

	@Transactional
	public StatusObject updatePatientPreferenceAndBillingInfo(
			PatientProfileCompletionModel patientProfileCompletionModel) {
		StatusObject statusObj = new StatusObject();
		PatientBilling patientBilling = new PatientBilling();

		patientBilling.setPatientid(patientProfileCompletionModel
				.getPatientid());
		patientBilling.setPaymenttypeid(patientProfileCompletionModel
				.getPaymenttypeid());
		patientBilling.setCardoraccountnum(patientProfileCompletionModel
				.getCardNumber());
		patientBilling.setCardoraccountname(patientProfileCompletionModel
				.getCardHolderName());
		patientBilling.setExpirydate(patientProfileCompletionModel
				.getExpiryDate());
		patientBilling.setCvv(patientProfileCompletionModel.getCvv());
		patientBilling.setCreateddate(new Date());

		boolean patientCardDetailsResponse = patientRegistrationDAO
				.updatepatientProfileCardDetails(patientBilling);
		// System.out.println("patientCardDetails---"+patientCardDetailsResponse);

		PatientPreference PatientPreference = new PatientPreference();

		PatientPreference.setPatientid(patientProfileCompletionModel
				.getPatientid());
		PatientPreference
				.setIssharemedicalhistory(patientProfileCompletionModel
						.isIsshareMedicalHistory());
		PatientPreference.setIsopentoalternatemed(patientProfileCompletionModel
				.isIsopenAlternateMedical());
		PatientPreference.setIssmsnotification(patientProfileCompletionModel
				.isIssmsNotification());
		PatientPreference.setIsemailnotification(patientProfileCompletionModel
				.isIsmailNotification());
		PatientPreference.setCreateddate(new Date());

		boolean patientPreferenceResponse = patientRegistrationDAO
				.updatepatientPreferences(PatientPreference);

		if (patientCardDetailsResponse == true
				&& patientPreferenceResponse == true) {
			statusObj.setError(false);
			statusObj
					.setMessage(getMessage("patient.preferences.billing.update.success.message"));
			return statusObj;

		} else {

			statusObj.setError(true);
			statusObj
					.setMessage(getMessage("patient.preferences.billing.update.failure.message"));
			return statusObj;

		}

		// return null;
	}
}
