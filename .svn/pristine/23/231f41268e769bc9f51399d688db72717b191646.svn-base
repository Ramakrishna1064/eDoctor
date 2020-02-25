/**
 * 
 */
package com.ensis.mediguru.dao.patient;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ensis.mediguru.dao.common.CommonDAO;
import com.ensis.mediguru.dao.common.HibernateUtil;
import com.ensis.mediguru.dto.PatientBilling;
import com.ensis.mediguru.dto.PatientPreference;
import com.ensis.mediguru.dto.PatientRegistration;
import com.ensis.mediguru.models.GetPatientProfileModel;
import com.ensis.mediguru.utils.MessageResources;

/**
 * @author Venu
 *
 */
@Repository
public class PatientRegistrationDAO extends MessageResources {

	@Autowired
	HibernateUtil hibernateUtil;

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	CommonDAO commonDAO;

	public CommonDAO getCommonDAO() {
		return commonDAO;
	}

	public void setCommonDAO(CommonDAO commonDAO) {
		this.commonDAO = commonDAO;
	}

	/**
	 * 
	 * @param patientRegistration
	 * @return
	 */
	public boolean insertPatientRegistration(
			PatientRegistration patientRegistration) {

		Object obj = hibernateUtil.create(patientRegistration);
		if (obj != null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @param PatientRegistration
	 * @return
	 */
	public int updatePatientRegistration(PatientRegistration PatientRegistration) {

		int response = 0;
		Session session = sessionFactory.getCurrentSession();
		PatientRegistration patientData = (PatientRegistration) session.get(PatientRegistration.class,
						PatientRegistration.getPatientid());
		session.flush();
		session.clear();
		//patientData.setFirstname(PatientRegistration.getFirstname());
		//patientData.setLastname(PatientRegistration.getLastname());
		patientData.setDob(PatientRegistration.getDob());
		patientData.setMobile(PatientRegistration.getMobile());
		patientData.setSkypeid(PatientRegistration.getSkypeid());
		// userData.setSkypeid(patient.getSkypeid());
		patientData.setOfficephone(PatientRegistration.getOfficephone());
		patientData.setContacthome(PatientRegistration.getContacthome());
		patientData.setAddress1(PatientRegistration.getAddress1());
		patientData.setAddress2(PatientRegistration.getAddress2());
		patientData.setCity(PatientRegistration.getCity());
		patientData.setStateid(PatientRegistration.getStateid());
		patientData.setCid(PatientRegistration.getCid());
		patientData.setZip(PatientRegistration.getZip());
		patientData.setSkypeid(PatientRegistration.getSkypeid());
		patientData.setImgid(PatientRegistration.getImgid());
		patientData.setUpdateddate(new Date());

		hibernateUtil.update(patientData);
		response = 1;
		return response;
	}
	
	/**
	 * 
	 * @param PatientRegistration
	 * @return
	 */
	public boolean updatePatientBasicInfo(PatientRegistration PatientRegistration) {

		boolean response = false;
		Session session = sessionFactory.getCurrentSession();
		PatientRegistration patientData = (PatientRegistration) session.get(PatientRegistration.class,
						PatientRegistration.getPatientid());
		session.flush();
		session.clear();
		if(patientData!=null){
		patientData.setFirstname(PatientRegistration.getFirstname());
		patientData.setLastname(PatientRegistration.getLastname());
		patientData.setDob(PatientRegistration.getDob());
		patientData.setMobile(PatientRegistration.getMobile());
		patientData.setSkypeid(PatientRegistration.getSkypeid());
		// userData.setSkypeid(patient.getSkypeid());
		patientData.setOfficephone(PatientRegistration.getOfficephone());
		patientData.setContacthome(PatientRegistration.getContacthome());
		patientData.setAddress1(PatientRegistration.getAddress1());
		patientData.setAddress2(PatientRegistration.getAddress2());
		patientData.setCity(PatientRegistration.getCity());
		patientData.setStateid(PatientRegistration.getStateid());
		patientData.setCid(PatientRegistration.getCid());
		patientData.setZip(PatientRegistration.getZip());
		patientData.setSkypeid(PatientRegistration.getSkypeid());
		patientData.setImgid(PatientRegistration.getImgid());
		patientData.setUpdateddate(new Date());

		hibernateUtil.update(patientData);
		response = true;
		}
		else
		{
			response=false;
		}
		return response;
	}

	/**
	 * 
	 * @param PatientBilling
	 * @return
	 */
	public int patientProfileCardDetails(PatientBilling PatientBilling) {
		int response = 0;
		int pbillingid = patientBillInfoExistOrnot(PatientBilling
				.getPatientid());
		if (patientBillInfoExistOrnot(PatientBilling.getPatientid()) > 0) {

			Session session = sessionFactory.getCurrentSession();
			PatientBilling billibgInfo = (PatientBilling) session.get(PatientBilling.class, pbillingid);
			session.flush();
			session.clear();
			if(billibgInfo!=null)
			{
			billibgInfo.setCardoraccountname(PatientBilling
					.getCardoraccountname());
			billibgInfo.setCardoraccountnum(PatientBilling
					.getCardoraccountnum());
			billibgInfo.setExpirydate(PatientBilling.getExpirydate());
			billibgInfo.setCvv(PatientBilling.getCvv());
			billibgInfo.setUpdateddate(new Date());

			hibernateUtil.update(billibgInfo);
			response = 1;
			}

		} else {
			// System.out.println("insert data");
			Object obj = hibernateUtil.create(PatientBilling);
			if (obj != null) {
				response = 1;
			} else {
				response = 0;
			}
		}
		return response;
	}
	
	public boolean updatepatientProfileCardDetails(PatientBilling PatientBilling) {
		boolean response = false;
		int pbillingid = patientBillInfoExistOrnot(PatientBilling
				.getPatientid());
		if (patientBillInfoExistOrnot(PatientBilling.getPatientid()) > 0) {

			Session session = sessionFactory.getCurrentSession();
			PatientBilling billibgInfo = (PatientBilling) session.get(PatientBilling.class, pbillingid);
			session.flush();
			session.clear();
			if(billibgInfo!=null)
			{
			billibgInfo.setCardoraccountname(PatientBilling
					.getCardoraccountname());
			billibgInfo.setCardoraccountnum(PatientBilling
					.getCardoraccountnum());
			billibgInfo.setExpirydate(PatientBilling.getExpirydate());
			billibgInfo.setCvv(PatientBilling.getCvv());
			billibgInfo.setUpdateddate(new Date());

			hibernateUtil.update(billibgInfo);
			response = true;
			}

		} else {
			// System.out.println("insert data");
			response =false;
		}
		return response;
	}

	/**
	 * 
	 *
	 * @param patientid
	 * @return
	 */
	public int patientBillInfoExistOrnot(int patientid) {
		int patientbillingid = 0;
		try {

			Session session = sessionFactory.getCurrentSession();
			String hql = "FROM PatientBilling p WHERE p.patientid = :patientid";
			Query query = session.createQuery(hql);
			query.setParameter("patientid", patientid);

			List results = query.list();
			Iterator itr = results.iterator();
			session.flush();
			session.clear();
			if (itr.hasNext()) {
				System.out.println("billing info exist");
				PatientBilling pbliling = (PatientBilling) itr.next();
				patientbillingid = pbliling.getPatientbillingid();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return patientbillingid;
	}

	public int patientPreferences(PatientPreference ppreferences) {
		int response = 1;
		try {

			int ppreference = patientPreferenceExistOrnot(ppreferences
					.getPatientid());
			if (ppreference > 0) {

				Session session = sessionFactory.getCurrentSession();
				PatientPreference preferencesInfo = (PatientPreference) session
						.get(PatientPreference.class, ppreference);
				session.flush();
				session.clear();

				preferencesInfo.setIssharemedicalhistory(ppreferences
						.isIssharemedicalhistory());
				preferencesInfo.setIsopentoalternatemed(ppreferences
						.isIsopentoalternatemed());
				preferencesInfo.setIsemailnotification(ppreferences
						.isIsemailnotification());
				preferencesInfo.setIssmsnotification(ppreferences
						.isIssmsnotification());
				preferencesInfo.setUpdateddate(new Date());

				hibernateUtil.update(preferencesInfo);
				response = 1;

			} else {
				Object obj = hibernateUtil.create(ppreferences);
				if (obj != null) {
					response = 1;
				} else {
					response = 0;
				}

			}

			// session.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return response;

	}
	
	public boolean updatepatientPreferences(PatientPreference ppreferences) {
		boolean response = false;
		try {

			int ppreference = patientPreferenceExistOrnot(ppreferences
					.getPatientid());
			if (ppreference > 0) {

				Session session = sessionFactory.getCurrentSession();
				PatientPreference preferencesInfo = (PatientPreference) session
						.get(PatientPreference.class, ppreference);
				session.flush();
				session.clear();

				preferencesInfo.setIssharemedicalhistory(ppreferences
						.isIssharemedicalhistory());
				preferencesInfo.setIsopentoalternatemed(ppreferences
						.isIsopentoalternatemed());
				preferencesInfo.setIsemailnotification(ppreferences
						.isIsemailnotification());
				preferencesInfo.setIssmsnotification(ppreferences
						.isIssmsnotification());
				preferencesInfo.setUpdateddate(new Date());

				hibernateUtil.update(preferencesInfo);
				response = true;

			} else {
				
					response = false;
				

			}

			// session.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return response;

	}

	/**
	 * 
	 * @param patientid
	 * @return
	 */
	public int patientPreferenceExistOrnot(int patientid) {
		int patientpreferenceid = 0;
		try {

			Session session = sessionFactory.getCurrentSession();
			String hql = "FROM PatientPreference p WHERE p.patientid = :patientid";
			Query query = session.createQuery(hql);
			query.setParameter("patientid", patientid);

			List results = query.list();
			Iterator itr = results.iterator();
			session.flush();
			session.clear();
			if (itr.hasNext()) {
				System.out.println("billing info exist");
				PatientPreference ppreference = (PatientPreference) itr.next();
				patientpreferenceid = ppreference.getPatientpreferenceid();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return patientpreferenceid;
	}

	/**
	 * 
	 * @param patientid
	 * @return
	 */
	public GetPatientProfileModel getPatientProfile(int patientid) {
		GetPatientProfileModel GetPatientProfileModel = new GetPatientProfileModel();
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql = "FROM PatientRegistration p WHERE p.patientid=:patientid";
			Query query = session.createQuery(hql);
			query.setParameter("patientid", patientid);
			session.flush();
			session.clear();

			List results = query.list();
			Iterator itr = results.iterator();
			if (itr.hasNext()) {

				PatientRegistration patient = (PatientRegistration) itr.next();
				GetPatientProfileModel
						.setFirstname((patient.getFirstname()) != null ? patient
								.getFirstname() : "");
				GetPatientProfileModel
						.setLastname((patient.getLastname()) != null ? patient
								.getLastname() : "");
				String email = commonDAO.getUserEmailbyUserid(patient
						.getUserid());
				GetPatientProfileModel.setEmail(email != null ? email : "");
				GetPatientProfileModel
						.setMobile((patient.getMobile()) != null ? patient
								.getMobile() : "");

				GetPatientProfileModel
						.setDateofbirth((patient.getDob()) != null ? patient
								.getDob() : "");
				GetPatientProfileModel
						.setContactMobile((patient.getMobile()) != null ? patient
								.getMobile() : "");
				if (patient.getDob() == null && patient.getMobile() == null) {

					GetPatientProfileModel.setProfileCompleted(false);
				} else {
					GetPatientProfileModel.setProfileCompleted(true);
				}
				// MainObject.setContactHome(patient.get)

				GetPatientProfileModel.setContactOffice((patient
						.getOfficephone()) != null ? patient.getOfficephone()
						: "");
				// MainObject.setSkypeId(patient.getSkypeid());
				GetPatientProfileModel
						.setContactHome((patient.getContacthome()) != null ? patient
								.getContacthome() : "");
				
				GetPatientProfileModel
				.setSkypeId((patient.getSkypeid()) != null ? patient
						.getSkypeid() : "");
				GetPatientProfileModel
						.setAddress1((patient.getAddress1()) != null ? patient
								.getAddress1() : "");
				GetPatientProfileModel
						.setAddress2((patient.getAddress2()) != null ? patient
								.getAddress2() : "");
				GetPatientProfileModel
						.setCity((patient.getCity()) != null ? patient
								.getCity() : "");
				GetPatientProfileModel.setCountry(commonDAO
						.getCountryName(patient.getCid()));
				GetPatientProfileModel.setState(commonDAO
						.getStatesByStateId(patient.getStateid()));
				GetPatientProfileModel
						.setZipcode((patient.getZip()) != null ? patient
								.getZip() : "");
				GetPatientProfileModel
						.setImageid((patient.getImgid()) > 0 ? patient
								.getImgid() : 0);
				// need to add imageurl

				if (patient.getImgid() > 0) {
					GetPatientProfileModel
							.setImageurl(getMessage("imageUrlPath")
									+ commonDAO.getImageName(patient.getImgid()));
				} else {
					GetPatientProfileModel.setImageurl("");
				}

				String hql1 = "FROM PatientBilling p WHERE p.patientid=:patientid";
				Query query1 = sessionFactory.getCurrentSession().createQuery(
						hql1);
				query1.setParameter("patientid", patientid);

				List results1 = query1.list();
				Iterator itr1 = results1.iterator();

				if (itr1.hasNext()) {
					PatientBilling patientbilling = (PatientBilling) itr1
							.next();

					GetPatientProfileModel.setPaymenttypeid((patientbilling
							.getPaymenttypeid()) > 0 ? patientbilling
							.getPaymenttypeid() : 0);
					GetPatientProfileModel.setCardHolderName((patientbilling
							.getCardoraccountname()) != null ? patientbilling
							.getCardoraccountname() : "");
					GetPatientProfileModel.setCardNumber((patientbilling
							.getCardoraccountnum()) != null ? patientbilling
							.getCardoraccountnum() : "");
					GetPatientProfileModel.setExpiryDate((patientbilling
							.getExpirydate()) != null ? patientbilling
							.getExpirydate() : "");
					GetPatientProfileModel
							.setCvv((patientbilling.getCvv()) != null ? patientbilling
									.getCvv() : "");
				}

				String hql2 = "FROM PatientPreference p WHERE p.patientid=:patientid";
				Query query2 = sessionFactory.getCurrentSession().createQuery(
						hql2);
				query2.setParameter("patientid", patientid);

				List results2 = query2.list();
				Iterator itr2 = results2.iterator();
				if (itr2.hasNext()) {
					PatientPreference patientpreferences = (PatientPreference) itr2
							.next();

					GetPatientProfileModel
							.setIsshareMedicalHistory((patientpreferences
									.isIssharemedicalhistory()) ? patientpreferences
									.isIssharemedicalhistory() : false);
					GetPatientProfileModel
							.setIsopenAlternateMedical((patientpreferences
									.isIsopentoalternatemed()) ? patientpreferences
									.isIsopentoalternatemed() : false);
					GetPatientProfileModel
							.setIssmsNotification((patientpreferences
									.isIssmsnotification()) ? patientpreferences
									.isIssmsnotification() : false);
					GetPatientProfileModel
							.setIsemailNotification((patientpreferences
									.isIsemailnotification()) ? patientpreferences
									.isIsemailnotification() : false);

				}

			} else {
				System.out.println("patient id not avalilable in db..");
				GetPatientProfileModel = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return GetPatientProfileModel;
	}

}
