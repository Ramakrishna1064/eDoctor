/**
 * 
 */
package com.ensis.mediguru.dao.patient;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ensis.mediguru.dao.common.HibernateUtil;
import com.ensis.mediguru.dto.PatientRegistration;
import com.ensis.mediguru.dto.Users;

/**
 * @author Venu
 *
 */
@Repository
public class PatientChangePasswordDAO {

	@Autowired
	HibernateUtil hibernateUtil;

	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * 
	 * @param physicianid
	 * @return
	 */
	public int getPatientUserId(int patientid){
		
		int userId=0;
		String hql = "FROM PatientRegistration p WHERE "
				+ "p.patientid = :patientid";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter("patientid", patientid);
	
		List<?> results = query.list();
		Iterator<?> itr = results.iterator();
		if (itr.hasNext()) {
			PatientRegistration doctorRegistration = (PatientRegistration) itr.next();
			userId = doctorRegistration.getUserid();
		}
		session.flush();
		session.clear();
		return userId;
	}
	
	/**
	 * 
	 * @param userId
	 * @return
	 */
	public Users getUser(int userId){
		
		String hql = "FROM Users p WHERE "
				+ "p.userid = :userid";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter("userid", userId);
	
		List<?> results = query.list();
		Iterator<?> itr = results.iterator();
		if (itr.hasNext()) {
			
			Users users = (Users) itr.next();	
			return users;
		}
		session.flush();
		session.clear();
		return null;
	}
	
	/**
	 * 
	 * @param userObj
	 * @return
	 */
	public boolean updateUser(Users userObj){
	
		Object obj=hibernateUtil.update(userObj);
		if(obj != null)
			return true;
		return false;
	}
}
