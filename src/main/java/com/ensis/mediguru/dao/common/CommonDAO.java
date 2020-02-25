package com.ensis.mediguru.dao.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ensis.mediguru.dto.ClinicServices;
import com.ensis.mediguru.dto.Country;
import com.ensis.mediguru.dto.DoctorRegistration;
import com.ensis.mediguru.dto.LanguageType;
import com.ensis.mediguru.dto.MedicineTypes;
import com.ensis.mediguru.dto.MediguruImages;
import com.ensis.mediguru.dto.PatientRegistration;
import com.ensis.mediguru.dto.PaymentType;
import com.ensis.mediguru.dto.QualificationType;
import com.ensis.mediguru.dto.SpecialityType;
import com.ensis.mediguru.dto.State;
import com.ensis.mediguru.dto.UserNotificationDTO;
import com.ensis.mediguru.dto.Users;
import com.ensis.mediguru.models.GetPatientMedicinesModel;
import com.ensis.mediguru.models.TreatmentTypeSTPModel;

/**
 * @author Venu
 *
 */
@Repository
public class CommonDAO {

	@Autowired
	private HibernateUtil hibernateUtil;

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * 
	 * @return
	 */
	public List<Country> getCountriesList() {

		return hibernateUtil.fetchAll(Country.class);
	}

	/**
	 * 
	 * @return
	 */
	public List<State> getStatesList() {

		return hibernateUtil.fetchAll(State.class);
	}

	/**
	 * 
	 * @return
	 */
	public List<SpecialityType> getSpecialities() {

		return hibernateUtil.fetchAll(SpecialityType.class);
	}

	/**
	 * 
	 * @return
	 */
	public List<LanguageType> getLanguages() {

		return hibernateUtil.fetchAll(LanguageType.class);
	}

	/**
	 * 
	 * @return
	 */
	public List<QualificationType> getQualifications() {

		return hibernateUtil.fetchAll(QualificationType.class);
	}

	/**
	 * 
	 * @return
	 */
	public List<ClinicServices> getClinicServices() {
		return hibernateUtil.fetchAll(ClinicServices.class);
	}

	/**
	 * 
	 * @param email
	 * @param password
	 * @param type
	 * @return
	 */
	public List<?> validateUserLogin(String email, String password, int type) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Users.class);
		criteria.add(Restrictions.eq("email", email));
		criteria.add(Restrictions.eq("password", password));
		criteria.add(Restrictions.eq("usertypeid", type));
		// result will stored in list object.
		List<?> list = criteria.list();
		session.flush();
		session.clear();
		return list;
	}

	/**
	 * 
	 * @param email
	 * @return
	 */
	public List<?> getPatientLoginUserId(String email) {

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery("CALL PatientLogin(:email)")
				.addEntity(PatientRegistration.class)
				.setParameter("email", email);
		List<?> list = query.list();
		session.flush();
		session.clear();
		return list;
	}

	/**
	 * 
	 * @param email
	 * @return
	 */
	public List getPhysicianLoginUserId(String email) {

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery("CALL DoctorLogin(:email)")
				.addEntity(DoctorRegistration.class)
				.setParameter("email", email);
		List<?> list = query.list();
		session.flush();
		session.clear();
		return list;
	}

	/**
	 * 
	 * @param emailId
	 * @return
	 */
	public long checkEmailExists(String emailId) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Users.class);
		criteria.add(Restrictions.eq("email", emailId));
		criteria.setProjection(Projections.rowCount());
		long count = (Long) criteria.uniqueResult();
		session.flush();
		session.clear();
		return count;
	}

	/**
	 * 
	 * @param userOj
	 * @return
	 */
	public int insertUserObj(Users userOj) {

		Object obj = hibernateUtil.create(userOj);
		if (obj != null) {

			Session session = sessionFactory.getCurrentSession();
			int userID = (Integer) session.createCriteria(Users.class)
					.setProjection(Projections.max("userid")).uniqueResult();
			session.flush();
			session.clear();
			return userID;

		} else {

			return 0;
		}
	}

	/**
	 * 
	 * @param userObj
	 * @return
	 */
	public int updateOTPPassword(Users userObj) {

		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("update Users set passwordotp=:passwordotp where email=:email");
		query.setInteger("passwordotp", userObj.getPasswordotp());
		query.setString("email", userObj.getEmail());
		int status = query.executeUpdate();
		session.flush();
		session.clear();
		return status;
	}

	/**
	 * 
	 * @param userObj
	 * @return
	 */
	public int resetPassword(Users userObj) {

		Session session = sessionFactory.getCurrentSession();
		Query q = session
				.createQuery("update Users set password=:password where passwordotp=:passwordotp and status=1");
		q.setString("password", userObj.getPassword());
		q.setInteger("passwordotp", userObj.getPasswordotp());
		int result = q.executeUpdate();
		session.flush();
		session.clear();
		return result;

	}

	/**
	 * 
	 * @param userid
	 * @return
	 */
	public String getUserEmailbyUserid(int userid) {
		String email = "";
		try {

			Session session = sessionFactory.getCurrentSession();
			String hql = "FROM Users u WHERE u.userid = :userid";
			Query query = session.createQuery(hql);
			query.setParameter("userid", userid);

			List results = query.list();
			Iterator itr = results.iterator();
			session.flush();
			session.clear();
			if (itr.hasNext()) {
				Users user = (Users) itr.next();
				email = user.getEmail();
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return email;
	}

	/**
	 * 
	 * @param countryid
	 * @return
	 */
	public String getCountryName(int countryid) {
		String name = "";
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from Country where cid="
					+ countryid);
			List<Country> countriesList = query.list();
			Iterator countryIteratore = countriesList.iterator();
			session.flush();
			session.clear();
			while (countryIteratore.hasNext()) {
				Country country = (Country) countryIteratore.next();
				name = country.getName();
			}
			return name;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return name;
	}

	/**
	 * 
	 * @param stateid
	 * @return
	 */
	public String getStatesByStateId(int stateid) {
		String name = "";
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("from State where stateid=" + stateid);
		List<State> statesList = query.list();
		Iterator statesIteratore = statesList.iterator();
		session.flush();
		session.clear();
		while (statesIteratore.hasNext()) {
			State state = (State) statesIteratore.next();
			name = state.getName();
		}

		return name;
	}

	/**
	 * 
	 * @param imgid
	 * @return
	 */
	public String getImageName(int imgid) {
		// TODO Auto-generated method stub

		String imageInfo = "";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from MediguruImages where imgid="
				+ imgid);
		List<MediguruImages> usersList = query.list();
		Iterator usersIteratore = usersList.iterator();
		session.flush();
		session.clear();
		if (usersIteratore.hasNext()) {
			MediguruImages img = (MediguruImages) usersIteratore.next();
			imageInfo = img.getImagename();
		}
		return imageInfo;
	}

	/**
	 * 
	 * @return
	 */
	public List<PaymentType> getPaymentCardTypes() {

		return hibernateUtil.fetchAll(PaymentType.class);
	}

	/**
	 * 
	 * @param specialityid
	 * @return
	 */
	public String getDoctorSpecialityById(int specialityid) {

		// TODO Auto-generated method stub
		String name = "";
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("from SpecialityType where specialitytypeid="
						+ specialityid);
		List<SpecialityType> specialityesList = query.list();
		Iterator<?> specialityIteratore = specialityesList.iterator();
		session.flush();
		session.clear();
		while (specialityIteratore.hasNext()) {
			SpecialityType specialitys = (SpecialityType) specialityIteratore
					.next();
			name = specialitys.getSpecialityname();
		}
		return name;
	}

	/**
	 * 
	 * @param fileName
	 * @return
	 */
	public int uploadProfileImage(String fileName) {

		int imgid = 0;
		try {
			MediguruImages mediguruimages = new MediguruImages();
			mediguruimages.setImagename(fileName);
			mediguruimages.setCreatedby("admin");
			mediguruimages.setCreateddate(new Date());
			hibernateUtil.create(mediguruimages);

			Session session = sessionFactory.getCurrentSession();
			imgid = (Integer) session.createCriteria(MediguruImages.class)
					.setProjection(Projections.max("id")).uniqueResult();
			System.out.println("maxid-->" + imgid);
			session.flush();
			session.clear();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return imgid;
	}

	/**
	 * 
	 * @param mailid
	 * @return
	 */
	public int verifyEmail(String mailid) {
		int response = 0;
		try {

			Session session = sessionFactory.getCurrentSession();
			Query q = session
					.createQuery("update Users set status=1 where email=:mailid");
			q.setString("mailid", mailid);
			response = q.executeUpdate();
			session.flush();
			session.clear();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return response;

	}

	/**
	 * 
	 * @return
	 */
	public List<MedicineTypes> getMedicineTypeList() {

		return hibernateUtil.fetchAll(MedicineTypes.class);
	}

	/**
	 * 
	 * @param patientId
	 * @param treatmentid
	 * @return
	 */
	public ArrayList<GetPatientMedicinesModel> getTreatmentMedicineList(int patientId, int treatmentId) {
		
		Session session = sessionFactory.getCurrentSession();
		SQLQuery sqlQuery = (SQLQuery) session.createSQLQuery(
				"CALL getPatientMedicines(:patientid,:treatmentid)")
				.setResultTransformer(
						Transformers
								.aliasToBean(GetPatientMedicinesModel.class));
		sqlQuery.setParameter("patientid", patientId);
		sqlQuery.setParameter("treatmentid", treatmentId);

		ArrayList<GetPatientMedicinesModel> list = (ArrayList<GetPatientMedicinesModel>) sqlQuery.list();
		session.flush();
		session.clear();
		return list;

	}
	
	/**
	 * 
	 * @param physicianId
	 * @return
	 */
	public int getPhysicianUserId(int physicianId){
		
		int userId=0;
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("from DoctorRegistration where physicianid="
						+ physicianId);
		List<DoctorRegistration> docList = query.list();
		Iterator<?> specialityIteratore = docList.iterator();
		session.flush();
		session.clear();
		while (specialityIteratore.hasNext()) {
			DoctorRegistration doctorRegistration = (DoctorRegistration) specialityIteratore
					.next();
			userId = doctorRegistration.getUserid();
		}
		return userId;
	}
	
	
	/**
	 * 
	 * @param patientId
	 * @return
	 */
	public int getPatientUserId(int patientId){
		
		int userId=0;
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("from PatientRegistration where patientid="
						+ patientId);
		List<PatientRegistration> patientRegList = query.list();
		Iterator<?> patientIter = patientRegList.iterator();
		session.flush();
		session.clear();
		while (patientIter.hasNext()) {
			PatientRegistration patientRegistration = (PatientRegistration) patientIter
					.next();
			userId = patientRegistration.getUserid();
		}
		return userId;
	}
	
	/**
	 * 
	 * @param userNotificationDTO
	 * @return
	 */
	public boolean saveUserNotificationObj(UserNotificationDTO userNotificationDTO) {

		UserNotificationDTO modelObj=checkDeviceRegisteredOrNot(userNotificationDTO);
		if(modelObj != null){
			
			modelObj.setGcmId(userNotificationDTO.getGcmId());
			modelObj.setUpdatedby(""+modelObj.getUserId());
			modelObj.setUpdateddate(new Date());
			modelObj.setDeviceId(userNotificationDTO.getDeviceId());
			Object obj = hibernateUtil.update(modelObj);
			if (obj != null)
				return true;
			return false;
			
		}else{
			
			Object obj = hibernateUtil.create(userNotificationDTO);
			if (obj != null)
				return true;
			return false;
		}	

	}
	
	/**
	 * 
	 * @param userNotificationDTO
	 * @return
	 */
	public UserNotificationDTO checkDeviceRegisteredOrNot(UserNotificationDTO userNotificationDTO) {

		
		try {

			/*String hql = "FROM UserNotificationDTO u WHERE "
					+ "u.userId = :userId AND"
					+ " u.deviceId=:deviceId AND"
					+ " u.deviceType=:deviceType";*/
			
			String hql = "FROM UserNotificationDTO u WHERE "
					+ "u.userId = :userId AND"
					+ " u.deviceType=:deviceType";
			
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery(hql);
			query.setParameter("userId", userNotificationDTO.getUserId());
			//query.setParameter("deviceId", userNotificationDTO.getDeviceId());
			query.setParameter("deviceType", userNotificationDTO.getDeviceType());

			List<?> results = query.list();
			Iterator<?> itr = results.iterator();
			while (itr.hasNext()) {
				UserNotificationDTO modelObj = (UserNotificationDTO) itr.next();
				return modelObj;
			}
			session.flush();
			session.clear();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param userId
	 * @return
	 */
	public ArrayList<UserNotificationDTO> getUserDeviceInfo(int userId){
		
		try {

			ArrayList<UserNotificationDTO> devicesList=new ArrayList<UserNotificationDTO>();
			String hql = "FROM UserNotificationDTO u WHERE "
					+ "u.userId = :userId";
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery(hql);
			query.setParameter("userId", userId);

			List<?> results = query.list();
			Iterator<?> itr = results.iterator();
			while (itr.hasNext()) {
				UserNotificationDTO userNotificationDTO = (UserNotificationDTO) itr.next();
				devicesList.add(userNotificationDTO);
			}
			session.flush();
			session.clear();
			return devicesList;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * 
	 * @param patientid
	 * @return
	 */
	public PatientRegistration getPatientBasicInfo(int patientid){
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("from PatientRegistration where patientid="
						+ patientid);
		List<PatientRegistration> patientRegList = query.list();
		Iterator<?> patientIter = patientRegList.iterator();
		session.flush();
		session.clear();
		while (patientIter.hasNext()) {
			PatientRegistration patientRegistration = (PatientRegistration) patientIter
					.next();
			return patientRegistration;
		}
		return null;
	}
	
	/**
	 * 
	 * @param physicianid
	 * @return
	 */
	public DoctorRegistration getPhysicianBasicInfo(int physicianid) {

		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("from DoctorRegistration where physicianid="
						+ physicianid);
		List<PatientRegistration> patientRegList = query.list();
		Iterator<?> patientIter = patientRegList.iterator();
		session.flush();
		session.clear();
		while (patientIter.hasNext()) {
			DoctorRegistration doctorRegistration = (DoctorRegistration) patientIter
					.next();
			return doctorRegistration;
		}
		return null;
	}
	
	/**
	 */
	public ArrayList<DoctorRegistration> getPhysiciansListBySpeciality(int speciality){
		
		ArrayList<DoctorRegistration> docArrayList=new ArrayList<DoctorRegistration>();
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("from DoctorRegistration where speciality="
						+ speciality);
		List<DoctorRegistration> docList = query.list();
		Iterator<?> specialityIteratore = docList.iterator();
		session.flush();
		session.clear();
		while (specialityIteratore.hasNext()) {
			DoctorRegistration doctorRegistration = (DoctorRegistration) specialityIteratore
					.next();
			docArrayList.add(doctorRegistration);
		}
		return docArrayList;
	
	}
	
	/**
	 * 
	 * @param treatmentQuestionId
	 * @return
	 */
	public int getTreatmentTypeFromQuestionID(int treatmentQuestionId){
		
	
		Session session=sessionFactory.getCurrentSession();
		SQLQuery sqlQuery = (SQLQuery) session.createSQLQuery(
				"CALL getTreatmentTypeFromTQID(:treatmentquestionid)").setResultTransformer(
				Transformers.aliasToBean(TreatmentTypeSTPModel.class));
		sqlQuery.setParameter("treatmentquestionid", treatmentQuestionId);
		List<?> result = sqlQuery.list();
		session.flush();
		session.clear();
		for (int i = 0; i < result.size(); i++) {

			if(result.get(i) != null){
			
				TreatmentTypeSTPModel treatmentTypeSTPModel = (TreatmentTypeSTPModel) result
						.get(i);
				return treatmentTypeSTPModel.getTreatmenttypeid();
				
			}
		}
		return 0;
	}
}
