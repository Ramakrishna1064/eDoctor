/**
 * 
 */
package com.ensis.mediguru.dao.physician;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ensis.mediguru.dao.common.HibernateUtil;
import com.ensis.mediguru.dto.DoctorRegistration;
import com.ensis.mediguru.dto.Users;

/**
 * @author Venu
 *
 */
@Repository
public class PhysicianChangePasswordDAO {

	@Autowired
	HibernateUtil hibernateUtil;

	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * 
	 * @param physicianid
	 * @return
	 */
	public int getPhysicianUserId(int physicianid){
		
		int userId=0;
		String hql = "FROM DoctorRegistration p WHERE "
				+ "p.physicianid = :physicianid";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter("physicianid", physicianid);
	
		List<?> results = query.list();
		Iterator<?> itr = results.iterator();
		if (itr.hasNext()) {
			DoctorRegistration doctorRegistration = (DoctorRegistration) itr.next();
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
