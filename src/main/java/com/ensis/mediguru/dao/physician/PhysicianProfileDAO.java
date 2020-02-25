/**
 * 
 */
package com.ensis.mediguru.dao.physician;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ensis.mediguru.dao.common.HibernateUtil;
import com.ensis.mediguru.dto.DoctorRegistration;
import com.ensis.mediguru.dto.LanguageType;
import com.ensis.mediguru.dto.PhysicianAvailability;
import com.ensis.mediguru.dto.PhysicianClinicGallery;
import com.ensis.mediguru.dto.PhysicianFacility;
import com.ensis.mediguru.dto.PhysicianFacilityPlacesDTO;
import com.ensis.mediguru.dto.PhysicianFacilityService;
import com.ensis.mediguru.dto.PhysicianLanguage;
import com.ensis.mediguru.dto.PhysicianProfessionaInfo;
import com.ensis.mediguru.dto.PhysicianProfessionalCertificates;
import com.ensis.mediguru.dto.PhysicianSpeciality;
import com.ensis.mediguru.models.AvailabilityTimeModel;
import com.ensis.mediguru.models.AvailabilityTimingsModel;
import com.ensis.mediguru.models.PhysicianClinicInfoModel;
import com.ensis.mediguru.models.PhysicianCreateProfileModel;
import com.ensis.mediguru.models.PhysicianProfileClinicGetModel;
import com.ensis.mediguru.models.PhysicianProfilePersonalInfoModel;
import com.ensis.mediguru.models.PhysicianProfileSpecQualificationGetModel;
import com.ensis.mediguru.models.PhysicianSpecialityAndQualificationsModel;

/**
 * @author Venu
 *
 */
@Repository
public class PhysicianProfileDAO {

	@Autowired
	HibernateUtil hibernateUtil;

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * 
	 * @param profileObj
	 * @return
	 */
	public boolean createPhysicianProfile(PhysicianCreateProfileModel profileObj) {

		try {

			Session session = sessionFactory.getCurrentSession();
			DoctorRegistration doctor = (DoctorRegistration) session.get(
					DoctorRegistration.class, profileObj.getPhysicianid());
			session.flush();
			session.clear();

			doctor.setDob(profileObj.getDob());
			doctor.setMobile(profileObj.getMobile());
			doctor.setAbout(profileObj.getAbout());
			doctor.setUpdatedby("doctor");
			doctor.setUpdateddate(new Date());
			hibernateUtil.update(doctor);

			// Languages
			for (int i = 0; i < profileObj.getLanguageTypes().size(); i++) {

				createOrUpdateLangugaes(profileObj.getPhysicianid(), profileObj
						.getLanguageTypes().get(i));
			}

			// Specialities
			for (int j = 0; j < profileObj.getSpecialityAndQualifications()
					.size(); j++) {

				createOrUpdatePhysicianSpecialityAndQualifications(
						profileObj.getPhysicianid(), profileObj
								.getSpecialityAndQualifications().get(j));
			}

			// Create Professional Info
			createPhysicianProfessionInfo(profileObj);

			// Availability timings
			for (int k = 0; k < profileObj.getAvailabilityTimings().size(); k++) {

				for (int l = 0; l < profileObj.getAvailabilityTimings().get(k)
						.getTimings().size(); l++) {

					createPhysicianAvailabilityTimings(
							profileObj.getPhysicianid(), profileObj
									.getAvailabilityTimings().get(k),
							profileObj.getAvailabilityTimings().get(k)
									.getTimings().get(l));
				}
			}

			// physician facility
			int physicianfacilityid = createOrUpdatePhysicianFacility(
					profileObj.getPhysicianid(), profileObj.getClinicInfo());

			System.out
					.println("--physicianfacilityid-->" + physicianfacilityid);

			if (physicianfacilityid > 0) {

				// Facility Service Name
				for (int m = 0; m < profileObj.getClinicInfo().getServices()
						.size(); m++) {

					createOrUpdatePhysicianFacilityService(physicianfacilityid,
							profileObj.getClinicInfo().getServices().get(m));
				}

				// Facility Locations
				for (int n = 0; n < profileObj.getClinicInfo()
						.getPracticeLocations().size(); n++) {

					createOrUpdatePhysicianFacilityServicePlaces(
							physicianfacilityid, profileObj.getClinicInfo()
									.getPracticeLocations().get(n));
				}
			}

			return true;

		} catch (Throwable t) {
			t.printStackTrace();
		}
		return false;
	}

	/**
	 * 
	 * @param physicianId
	 * @param languageId
	 */
	public void createOrUpdateLangugaes(int physicianId, int languageId) {

		try {

			int phyLangPrimaryId = checkLanguageExists(physicianId, languageId);
			if (phyLangPrimaryId > 0) {

				Session session = sessionFactory.getCurrentSession();
				PhysicianLanguage physicianlanguage = (PhysicianLanguage) session
						.get(PhysicianLanguage.class, phyLangPrimaryId);
				session.flush();
				session.clear();
				physicianlanguage.setPhysicianid(physicianId);
				physicianlanguage.setLangtypeid(languageId);
				hibernateUtil.update(physicianlanguage);

			} else {

				PhysicianLanguage physicianlanguage = new PhysicianLanguage();
				physicianlanguage.setPhysicianid(physicianId);
				physicianlanguage.setLangtypeid(languageId);
				hibernateUtil.create(physicianlanguage).getClass().getName();

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param physicianId
	 * @param languageId
	 * @return
	 */
	public int checkLanguageExists(int physicianId, int languageId) {

		int phyLangId = 0;
		try {

			String hql = "FROM PhysicianLanguage p WHERE "
					+ "p.physicianid = :physicianid AND p.langtypeid=:langtypeid";
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery(hql);
			query.setParameter("physicianid", physicianId);
			query.setParameter("langtypeid", languageId);

			List<?> results = query.list();
			Iterator<?> itr = results.iterator();
			if (itr.hasNext()) {
				PhysicianLanguage ppreference = (PhysicianLanguage) itr.next();
				phyLangId = ppreference.getPhylangid();
			}
			session.flush();
			session.clear();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return phyLangId;
	}

	/**
	 * 
	 * @param specialityObj
	 */
	public void createOrUpdatePhysicianSpecialityAndQualifications(
			int physicianId,
			PhysicianSpecialityAndQualificationsModel specialityObj) {

		try {

			int physpecialitySpecID = checkPhysicianSpecialityAndQualificationExists(
					physicianId, specialityObj.getSpecialitytypeid());
			if (physpecialitySpecID > 0) {

				Session session = sessionFactory.getCurrentSession();
				PhysicianSpeciality physicianSpeciality = (PhysicianSpeciality) session.get(PhysicianSpeciality.class,
								physpecialitySpecID);
				session.flush();
				session.clear();
				physicianSpeciality.setPhysicianid(physicianId);
				physicianSpeciality.setSpecialitytypeid(specialityObj
						.getSpecialitytypeid());
				physicianSpeciality
						.setQualtypeid(specialityObj.getQualtypeid());
				physicianSpeciality.setYearqualified(specialityObj
						.getYearqualified());
				hibernateUtil.update(physicianSpeciality);

			} else {

				PhysicianSpeciality physicianSpeciality = new PhysicianSpeciality();
				physicianSpeciality.setPhysicianid(physicianId);
				physicianSpeciality.setSpecialitytypeid(specialityObj
						.getSpecialitytypeid());
				physicianSpeciality
						.setQualtypeid(specialityObj.getQualtypeid());
				physicianSpeciality.setYearqualified(specialityObj
						.getYearqualified());
				hibernateUtil.create(physicianSpeciality).getClass().getName();

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param physicianId
	 * @param specialitytypeid
	 * @return
	 */
	public int checkPhysicianSpecialityAndQualificationExists(int physicianId,
			int specialitytypeid) {

		int physpecialitySpecID = 0;
		try {

			String hql = "FROM PhysicianSpeciality p WHERE "
					+ "p.physicianid = :physicianid AND p.specialitytypeid=:specialitytypeid";
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery(hql);
			query.setParameter("physicianid", physicianId);
			query.setParameter("specialitytypeid", specialitytypeid);

			List<?> results = query.list();
			Iterator<?> itr = results.iterator();
			if (itr.hasNext()) {
				PhysicianSpeciality physicianSpeciality = (PhysicianSpeciality) itr
						.next();
				physpecialitySpecID = physicianSpeciality.getPhysicianspeid();
			}
			session.flush();
			session.clear();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return physpecialitySpecID;
	}

	/**
	 * 
	 * @param profileObj
	 */
	public void createPhysicianProfessionInfo(
			PhysicianCreateProfileModel profileObj) {

		try {

			int physicianprofessionainfoid = checkPhysicianProfessionInfoExists(profileObj
					.getPhysicianid());
			if (physicianprofessionainfoid > 0) {

				Session session = sessionFactory.getCurrentSession();
				PhysicianProfessionaInfo physicianProfessionaInfo = (PhysicianProfessionaInfo) session
						.get(PhysicianProfessionaInfo.class,
								physicianprofessionainfoid);

				session.flush();
				session.clear();

				physicianProfessionaInfo.setPhysicianid(profileObj
						.getPhysicianid());
				physicianProfessionaInfo.setPracticestartdate(profileObj
						.getPracticestartdate());
				physicianProfessionaInfo.setFirstvisitfee(profileObj
						.getFirstvisitfee());
				physicianProfessionaInfo.setFollowupvisitfee(profileObj
						.getFollowupvisitfee());
				physicianProfessionaInfo.setInpersonAppointment(profileObj
						.isPersonAppointment());
				physicianProfessionaInfo.setVirtualPhoneAppointment(profileObj
						.isVirtualPhoneAppointment());
				physicianProfessionaInfo.setVirtualSkypeAppointment(profileObj
						.isVirtualSkypeAppointment());
				hibernateUtil.update(physicianProfessionaInfo);

			} else {

				PhysicianProfessionaInfo physicianProfessionaInfo = new PhysicianProfessionaInfo();
				physicianProfessionaInfo.setPhysicianid(profileObj
						.getPhysicianid());
				physicianProfessionaInfo.setPracticestartdate(profileObj
						.getPracticestartdate());
				physicianProfessionaInfo.setFirstvisitfee(profileObj
						.getFirstvisitfee());
				physicianProfessionaInfo.setFollowupvisitfee(profileObj
						.getFollowupvisitfee());
				physicianProfessionaInfo.setInpersonAppointment(profileObj
						.isPersonAppointment());
				physicianProfessionaInfo.setVirtualPhoneAppointment(profileObj
						.isVirtualPhoneAppointment());
				physicianProfessionaInfo.setVirtualSkypeAppointment(profileObj
						.isVirtualSkypeAppointment());
				hibernateUtil.create(physicianProfessionaInfo).getClass()
						.getName();

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param physicianId
	 * @return
	 */
	public int checkPhysicianProfessionInfoExists(int physicianId) {

		int physicianprofessionainfoid = 0;
		try {

			String hql = "FROM PhysicianProfessionaInfo p WHERE "
					+ "p.physicianid = :physicianid";
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery(hql);
			query.setParameter("physicianid", physicianId);
			List<?> results = query.list();
			Iterator<?> itr = results.iterator();
			if (itr.hasNext()) {

				PhysicianProfessionaInfo physicianProfessionaInfo = (PhysicianProfessionaInfo) itr
						.next();
				physicianprofessionainfoid = physicianProfessionaInfo
						.getPhysicianprofessionainfoid();
			}
			session.flush();
			session.clear();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return physicianprofessionainfoid;
	}

	/**
	 * 
	 * @param physicianId
	 * @param availabilityTimingsModel
	 * @param timeModel
	 */
	public void createPhysicianAvailabilityTimings(int physicianId,
			AvailabilityTimingsModel availabilityTimingsModel,
			AvailabilityTimeModel timeModel) {

		try {

			int phyavailid = checkPhysicianAvailabilityTimingsExists(
					physicianId, availabilityTimingsModel, timeModel);
			if (phyavailid > 0) {

				Session session = sessionFactory.getCurrentSession();
				PhysicianAvailability physicianAvailability = (PhysicianAvailability) session
						.get(PhysicianAvailability.class, phyavailid);
				session.flush();
				session.clear();
				physicianAvailability.setPhysicianid(physicianId);
				physicianAvailability.setFromday(availabilityTimingsModel
						.getFromDay());
				physicianAvailability.setToday(availabilityTimingsModel
						.getToDay());
				physicianAvailability.setFromtime(timeModel.getFromTime());
				physicianAvailability.setTotime(timeModel.getToTime());
				hibernateUtil.update(physicianAvailability);

			} else {

				PhysicianAvailability physicianAvailability = new PhysicianAvailability();
				physicianAvailability.setPhysicianid(physicianId);
				physicianAvailability.setFromday(availabilityTimingsModel
						.getFromDay());
				physicianAvailability.setToday(availabilityTimingsModel
						.getToDay());
				physicianAvailability.setFromtime(timeModel.getFromTime());
				physicianAvailability.setTotime(timeModel.getToTime());
				hibernateUtil.create(physicianAvailability).getClass()
						.getName();

			}

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	/**
	 * 
	 * @param physicianId
	 * @param availabilityTimingsModel
	 * @param timeModel
	 * @return
	 */
	public int checkPhysicianAvailabilityTimingsExists(int physicianId,
			AvailabilityTimingsModel availabilityTimingsModel,
			AvailabilityTimeModel timeModel) {

		int phyavailid = 0;
		try {

			String hql = "FROM PhysicianAvailability p WHERE "
					+ "p.physicianid = :physicianid AND p.fromday=:fromDay AND p.today=:toDay AND p.fromtime=:fromTime";
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery(hql);
			query.setParameter("physicianid", physicianId);
			query.setParameter("fromDay", availabilityTimingsModel.getFromDay());
			query.setParameter("toDay", availabilityTimingsModel.getToDay());
			query.setParameter("fromTime", timeModel.getFromTime());
			List<?> results = query.list();
			Iterator<?> itr = results.iterator();
			if (itr.hasNext()) {

				PhysicianAvailability physicianAvailability = (PhysicianAvailability) itr
						.next();
				phyavailid = physicianAvailability.getPhyavailid();
			}
			session.flush();
			session.clear();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return phyavailid;
	}

	/**
	 * 
	 * @param physicianId
	 * @param clinicInfo
	 * @return
	 */
	public int createOrUpdatePhysicianFacility(int physicianId,
			PhysicianClinicInfoModel clinicInfo) {

		int physicianfacilityid = 0;
		try {

			physicianfacilityid = checkPhysicianFacilityExists(physicianId);
			if (physicianfacilityid > 0) {

				Session session = sessionFactory.getCurrentSession();
				PhysicianFacility physicianFacility = (PhysicianFacility) session
						.get(PhysicianFacility.class, physicianfacilityid);
				session.flush();
				session.clear();
				physicianFacility.setPhysicianid(physicianId);
				physicianFacility.setFacilityname(clinicInfo.getClinicName());
				physicianFacility.setAddress1(clinicInfo.getAddress1());
				physicianFacility.setAddress2(clinicInfo.getAddress2());
				physicianFacility.setCity(clinicInfo.getCity());
				physicianFacility.setStateid(clinicInfo.getStateid());
				physicianFacility.setCid(clinicInfo.getCid());
				physicianFacility.setZip(clinicInfo.getZip());
				physicianFacility.setMobile1(clinicInfo.getMobile1());
				physicianFacility.setMobile2(clinicInfo.getMobile2());
				physicianFacility.setAcceptleagul(clinicInfo.isAcceptleagul());
				physicianFacility.setAcceptecompliance(clinicInfo.isAcceptecompliance());
				hibernateUtil.update(physicianFacility);

				return physicianfacilityid;

			} else {

				PhysicianFacility physicianFacility = new PhysicianFacility();
				physicianFacility.setPhysicianid(physicianId);
				physicianFacility.setFacilityname(clinicInfo.getClinicName());
				physicianFacility.setAddress1(clinicInfo.getAddress1());
				physicianFacility.setAddress2(clinicInfo.getAddress2());
				physicianFacility.setCity(clinicInfo.getCity());
				physicianFacility.setStateid(clinicInfo.getStateid());
				physicianFacility.setCid(clinicInfo.getCid());
				physicianFacility.setZip(clinicInfo.getZip());
				physicianFacility.setMobile1(clinicInfo.getMobile1());
				physicianFacility.setMobile2(clinicInfo.getMobile2());
				physicianFacility.setAcceptleagul(clinicInfo.isAcceptleagul());
				physicianFacility.setAcceptecompliance(clinicInfo.isAcceptecompliance());
				hibernateUtil.create(physicianFacility).getClass().getName();

				Session session = sessionFactory.getCurrentSession();
				physicianfacilityid = (Integer) session
						.createCriteria(PhysicianFacility.class)
						.setProjection(Projections.max("physicianfacilityid"))
						.uniqueResult();
				session.flush();
				session.clear();

				return physicianfacilityid;
			}

		} catch (Throwable t) {
			t.printStackTrace();
		}
		return physicianfacilityid;
	}

	/**
	 * 
	 * @param physicianId
	 * @return
	 */
	public int checkPhysicianFacilityExists(int physicianId) {

		int physicianfacilityid = 0;
		try {

			Session session = sessionFactory.getCurrentSession();
			String hql = "FROM PhysicianFacility p WHERE "
					+ "p.physicianid = :physicianid";
			Query query = session.createQuery(hql);
			query.setParameter("physicianid", physicianId);
			List<?> results = query.list();
			Iterator<?> itr = results.iterator();
			if (itr.hasNext()) {

				PhysicianFacility physicianProfessionaInfo = (PhysicianFacility) itr
						.next();
				physicianfacilityid = physicianProfessionaInfo
						.getPhysicianfacilityid();
			}
			session.flush();
			session.clear();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return physicianfacilityid;
	}

	/**
	 * 
	 * @param physicianfacilityid
	 * @param facilityServiceName
	 */
	public void createOrUpdatePhysicianFacilityService(int physicianfacilityid,
			String facilityServiceName) {

		try {

			int physicianfaclserviceid = checkPhysicianFacilityServiceExists(
					physicianfacilityid, facilityServiceName);
			if (physicianfaclserviceid > 0) {

			} else {

				PhysicianFacilityService physicianFacilityService = new PhysicianFacilityService();
				physicianFacilityService
						.setPhysicianfacilityid(physicianfacilityid);
				physicianFacilityService.setServicename(facilityServiceName);
				hibernateUtil.create(physicianFacilityService).getClass()
						.getName();

			}

		} catch (Throwable t) {
			t.printStackTrace();
		}

	}

	/**
	 * 
	 * @param physicianfacilityid
	 * @param facilityServiceName
	 * @return
	 */
	public int checkPhysicianFacilityServiceExists(int physicianfacilityid,
			String facilityServiceName) {

		int physicianfaclserviceid = 0;
		try {

			Session session = sessionFactory.getCurrentSession();
			String hql = "FROM PhysicianFacilityService p WHERE "
					+ "p.physicianfacilityid = :physicianfacilityid AND p.servicename=:servicename";
			Query query = session.createQuery(hql);
			query.setParameter("physicianfacilityid", physicianfacilityid);
			query.setParameter("servicename", facilityServiceName);
			List<?> results = query.list();
			Iterator<?> itr = results.iterator();
			if (itr.hasNext()) {

				PhysicianFacilityService physicianProfessionaInfo = (PhysicianFacilityService) itr
						.next();
				physicianfaclserviceid = physicianProfessionaInfo
						.getPhysicianfaclserviceid();
			}
			session.flush();
			session.clear();

		} catch (Throwable t) {

		}
		return physicianfaclserviceid;
	}

	/**
	 * 
	 * @param physicianfacilityid
	 * @param placeName
	 */
	public void createOrUpdatePhysicianFacilityServicePlaces(
			int physicianfacilityid, String placeName) {

		try {

			int id = checkPhysicianFacilityServicePlacesExists(
					physicianfacilityid, placeName);
			if (id > 0) {

			} else {

				PhysicianFacilityPlacesDTO physicianFacilityPlacesDTO = new PhysicianFacilityPlacesDTO();
				physicianFacilityPlacesDTO
						.setPhysicianfacilityid(physicianfacilityid);
				physicianFacilityPlacesDTO.setLocationname(placeName);
				hibernateUtil.create(physicianFacilityPlacesDTO).getClass()
						.getName();

			}

		} catch (Throwable t) {
			t.printStackTrace();
		}

	}

	/**
	 * 
	 * @param physicianfacilityid
	 * @param facilityServiceName
	 * @return
	 */
	public int checkPhysicianFacilityServicePlacesExists(
			int physicianfacilityid, String placeName) {

		int id = 0;
		try {

			Session session = sessionFactory.getCurrentSession();
			String hql = "FROM PhysicianFacilityPlacesDTO p WHERE "
					+ "p.physicianfacilityid = :physicianfacilityid AND p.locationname=:locationname";
			Query query = session.createQuery(hql);
			query.setParameter("physicianfacilityid", physicianfacilityid);
			query.setParameter("locationname", placeName);
			List<?> results = query.list();
			Iterator<?> itr = results.iterator();
			if (itr.hasNext()) {

				PhysicianFacilityPlacesDTO physicianProfessionaInfo = (PhysicianFacilityPlacesDTO) itr
						.next();
				id = physicianProfessionaInfo.getId();
			}
			session.flush();
			session.clear();

		} catch (Throwable t) {

		}
		return id;
	}

	/**
	 * 
	 * @param physicianid
	 * @return
	 */
	public PhysicianProfilePersonalInfoModel getPhysicianProfilePersonalInfo(
			int physicianid) {

		Session session = sessionFactory.getCurrentSession();
		PhysicianProfilePersonalInfoModel patientPhysiciansModel = null;
		SQLQuery sqlQuery = (SQLQuery) session.createSQLQuery(
				"CALL getPhysicianProfile(:physicianid)").setResultTransformer(
				Transformers
						.aliasToBean(PhysicianProfilePersonalInfoModel.class));
		sqlQuery.setParameter("physicianid", physicianid);
		List<?> result = sqlQuery.list();
		session.flush();
		session.clear();
		for (int i = 0; i < result.size(); i++) {

			if (result.get(i) != null) {

				patientPhysiciansModel = (PhysicianProfilePersonalInfoModel) result
						.get(i);
			}
		}
		return patientPhysiciansModel;
	}

	/**
	 * 
	 * @param physicianid
	 * @return
	 */
	public List<LanguageType> getPhysicianLanguages(int physicianid) {

		Session session = sessionFactory.getCurrentSession();
		List<LanguageType> languages = new ArrayList<LanguageType>();
		SQLQuery sqlQuery = (SQLQuery) session.createSQLQuery(
				"CALL getPhysicianLanguages(:physicianid)")
				.setResultTransformer(
						Transformers.aliasToBean(LanguageType.class));
		sqlQuery.setParameter("physicianid", physicianid);
		List<?> result = sqlQuery.list();
		session.flush();
		session.clear();
		for (int i = 0; i < result.size(); i++) {

			if (result.get(i) != null) {

				LanguageType languageType = (LanguageType) result.get(i);
				languages.add(languageType);
			}
		}
		return languages;
	}

	/**
	 * 
	 * @param physicianid
	 * @return
	 */
	public List<PhysicianProfileSpecQualificationGetModel> getPhysicianSpecialitiesQualifications(
			int physicianid) {

		Session session = sessionFactory.getCurrentSession();
		List<PhysicianProfileSpecQualificationGetModel> specialities = new ArrayList<PhysicianProfileSpecQualificationGetModel>();
		SQLQuery sqlQuery = (SQLQuery) session
				.createSQLQuery(
						"CALL getPhysicianSpecialityQualifications(:physicianid)")
				.setResultTransformer(
						Transformers
								.aliasToBean(PhysicianProfileSpecQualificationGetModel.class));
		sqlQuery.setParameter("physicianid", physicianid);
		List<?> result = sqlQuery.list();
		session.flush();
		session.clear();
		for (int i = 0; i < result.size(); i++) {

			if (result.get(i) != null) {

				PhysicianProfileSpecQualificationGetModel specialityObj = (PhysicianProfileSpecQualificationGetModel) result
						.get(i);
				specialities.add(specialityObj);
			}
		}
		return specialities;
	}

	/**
	 * 
	 * @param physicianid
	 * @return
	 */
	public PhysicianProfileClinicGetModel getPhysicianCliniInfo(
			int physicianid) {

		Session session = sessionFactory.getCurrentSession();
		PhysicianProfileClinicGetModel physicianClinicInfoModel = null;
		SQLQuery sqlQuery = (SQLQuery) session
				.createSQLQuery(
						"CALL getPhysicianFacilityLocations(:physicianid)")
				.setResultTransformer(
						Transformers
								.aliasToBean(PhysicianProfileClinicGetModel.class));
		sqlQuery.setParameter("physicianid", physicianid);
		List<?> result = sqlQuery.list();
		session.flush();
		session.clear();
		for (int i = 0; i < result.size(); i++) {

			if (result.get(i) != null) {

				physicianClinicInfoModel = (PhysicianProfileClinicGetModel) result
						.get(i);
			}
		}
		return physicianClinicInfoModel;
	}

	/**
	 * 
	 * @param physicianid
	 * @return
	 */
	public List<PhysicianAvailability> getPhysicianAvailabilityTimings(
			int physicianid) {

		Session session = sessionFactory.getCurrentSession();
		List<PhysicianAvailability> availabilityTimes = new ArrayList<PhysicianAvailability>();
		String hql = "FROM PhysicianAvailability p WHERE "
				+ "p.physicianid = :physicianid";
		Query query = session.createQuery(hql);
		query.setParameter("physicianid", physicianid);
		List<?> results = query.list();
		session.flush();
		session.clear();
		for (int i = 0; i < results.size(); i++) {

			PhysicianAvailability physicianAvailability = (PhysicianAvailability) results
					.get(i);
			availabilityTimes.add(physicianAvailability);
		}
		return availabilityTimes;
	}

	/**
	 * 
	 * @param diskSaveFileUUID
	 * @param fileOriginalName
	 * @param physicianid
	 * @return
	 */
	public boolean uploadPhysicianClinicGallery(String diskSaveFileUUID,
			String fileOriginalName, int physicianid) {
		try {

			Session session = sessionFactory.getCurrentSession();
			PhysicianClinicGallery clinicGallery = new PhysicianClinicGallery();
			clinicGallery.setCreateddate(new Date());
			clinicGallery.setPhysicianid(physicianid);
			clinicGallery.setFilename(fileOriginalName);
			clinicGallery.setImage(diskSaveFileUUID);
			clinicGallery.setCreateddate(new Date());
			session.save(clinicGallery).getClass().getName();
			session.flush();
			session.clear();
			clinicGallery = null;
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 
	 * @param diskSaveFileUUID
	 * @param fileOriginalName
	 * @param physicianid
	 * @return
	 */
	public boolean uploadPhysicianProfessionImages(String diskSaveFileUUID,
			String fileOriginalName, int physicianid, int specialityid) {

		try {

			Session session = sessionFactory.getCurrentSession();
			PhysicianProfessionalCertificates certificates = new PhysicianProfessionalCertificates();
			certificates.setCreateddate(new Date());
			certificates.setPhysicianid(physicianid);
			certificates.setSpecialityid(specialityid);
			certificates.setFilename(fileOriginalName);
			certificates.setImage(diskSaveFileUUID);
			session.save(certificates).getClass().getName();
			session.flush();
			session.clear();
			certificates = null;
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 
	 * @param physicianid
	 * @return
	 */
	public DoctorRegistration getPhysicianModel(int physicianid){
		
		Session session = sessionFactory.getCurrentSession();
		DoctorRegistration doctor = (DoctorRegistration) session.get(
				DoctorRegistration.class, physicianid);
		session.flush();
		session.clear();
		return doctor;
	}
	
	/**
	 * 
	 * @param doctorRegistration
	 * @return
	 */
	public boolean updatePhysicianModel(DoctorRegistration doctorRegistration){
		
		Object obj=hibernateUtil.update(doctorRegistration);
		if(obj != null)
			return true;
		return false;
	}
	
	/**
	 * 
	 * @param physicianid
	 * @return
	 */
	public ArrayList<PhysicianLanguage> getPhysicianAvailLanguages(int physicianid){
		
		Session session = sessionFactory.getCurrentSession();
		List<PhysicianLanguage> languages = new ArrayList<PhysicianLanguage>();
		String hql = "FROM PhysicianLanguage p WHERE "
				+ "p.physicianid = :physicianid";
		Query query = session.createQuery(hql);
		query.setParameter("physicianid", physicianid);
		List<?> results = query.list();
		session.flush();
		session.clear();
		for (int i = 0; i < results.size(); i++) {

			PhysicianLanguage physicianLanguage = (PhysicianLanguage) results
					.get(i);
			languages.add(physicianLanguage);
		}
		return (ArrayList<PhysicianLanguage>) languages;
	}
	
	/**
	 * 
	 * @param physicianLanguage
	 * @return
	 */
	public boolean deletePhysicianLanguage(PhysicianLanguage physicianLanguage){
		
		Session session = sessionFactory.getCurrentSession();
		session.delete(physicianLanguage);
		session.flush();
		session.clear();
		return true;
	}
	
	/**
	 * 
	 * @param physicianid
	 * @return
	 */
	public PhysicianProfessionaInfo getPhysicianProfessionAvailInfo(int physicianid){
		
		int physicianprofessionainfoid = checkPhysicianProfessionInfoExists(physicianid);
		if(physicianprofessionainfoid>0){
			
			Session session = sessionFactory.getCurrentSession();
			PhysicianProfessionaInfo physicianProfessionaInfo = (PhysicianProfessionaInfo) session
					.get(PhysicianProfessionaInfo.class,
							physicianprofessionainfoid);

			session.flush();
			session.clear();
			return physicianProfessionaInfo;
		}
		return null;
		
	}
	
	/**
	 * 
	 * @param physicianfacilityid
	 * @return
	 */
	public PhysicianFacility getPhysicianFacilityAvail(int physicianfacilityid){
		
		Session session = sessionFactory.getCurrentSession();
		PhysicianFacility physicianFacility = (PhysicianFacility) session
				.get(PhysicianFacility.class, physicianfacilityid);
		session.flush();
		session.clear();
		return physicianFacility;
	}
	
	/**
	 * 
	 * @param physicianfacilityid
	 * @return
	 */
	public ArrayList<PhysicianFacilityService> getPhysicianFacilityServices(int physicianfacilityid){
		
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM PhysicianFacilityService p WHERE "
				+ "p.physicianfacilityid = :physicianfacilityid";
		Query query = session.createQuery(hql);
		query.setParameter("physicianfacilityid", physicianfacilityid);
		List<PhysicianFacilityService> results = query.list();
		session.flush();
		session.clear();
		return (ArrayList<PhysicianFacilityService>) results;
	}
	
	/**
	 * 
	 * @param physicianFacilityService
	 * @return
	 */
	public boolean deletePhysicianFacilityService(PhysicianFacilityService physicianFacilityService){
		
		Session session = sessionFactory.getCurrentSession();
		session.delete(physicianFacilityService);
		session.flush();
		session.clear();
		return true;
	}
	
	/**
	 * 
	 * @param physicianfacilityid
	 * @return
	 */
	public ArrayList<PhysicianFacilityPlacesDTO> getPhysicianPracticePlacesAvail(int physicianfacilityid){
		
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM PhysicianFacilityPlacesDTO p WHERE "
				+ "p.physicianfacilityid = :physicianfacilityid";
		Query query = session.createQuery(hql);
		query.setParameter("physicianfacilityid", physicianfacilityid);
		List<PhysicianFacilityPlacesDTO> results = query.list();
		session.flush();
		session.clear();
		return (ArrayList<PhysicianFacilityPlacesDTO>) results;
	}
	
	/**
	 * 
	 * @param physicianFacilityPlacesDTO
	 * @return
	 */
	public boolean deletePhysicianFacilityPlacesAvail(PhysicianFacilityPlacesDTO physicianFacilityPlacesDTO){
		
		Session session = sessionFactory.getCurrentSession();
		session.delete(physicianFacilityPlacesDTO);
		session.flush();
		session.clear();
		return true;
	}
}
