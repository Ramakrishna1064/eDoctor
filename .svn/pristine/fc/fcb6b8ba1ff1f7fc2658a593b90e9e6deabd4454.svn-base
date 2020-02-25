package com.ensis.mediguru.dao.patient;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ensis.mediguru.dao.common.HibernateUtil;
import com.ensis.mediguru.dto.PhysicianReview;
import com.ensis.mediguru.dto.Treatment;

@Repository
public class PatientCloseTreatmentDAO {

	@Autowired
	HibernateUtil hibernateUtil;

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * 
	 * @param treatmentid
	 * @return
	 */
	public int closeTreatment(int treatmentid) {
		int response = 0;
		Session session = sessionFactory.getCurrentSession();
		Treatment treatmentData = (Treatment) session.get(Treatment.class,
				treatmentid);
		// System.out.println(treatmentData.getTreatmenttypeid());
		if (treatmentData != null) {
			if (treatmentData.getTreatmenttypeid() != 3) {
				String hql = "UPDATE Treatment set treatmenttypeid = :treatmenttypeid "
						+ "WHERE treatmentid = :treatmentid";

				Query query = session.createQuery(hql);
				query.setParameter("treatmenttypeid", 3);
				query.setParameter("treatmentid", treatmentid);
				response = query.executeUpdate();
			} else {// Treatment already closed
				response = 2;
			}
		} else {// Treatment does not exist
			response = 3;
		}
		return response;
	}

	/**
	 * 
	 * @param physicianid
	 * @param title
	 * @param comment
	 * @param rating
	 * @return
	 */
	public boolean savePhysicinaReview(PhysicianReview phyreview) {

		Object obj = hibernateUtil.create(phyreview);
		if (obj != null)
			return true;
		return false;
	}
	
	/**
	 * 
	 * @param treatmentid
	 * @return
	 */
	public int openclosedTreatment(int treatmentid)
	{
		int response=0;
		Session session = sessionFactory.getCurrentSession();
		Treatment treatmentData = (Treatment) session.get(Treatment.class,
				treatmentid);
		if(treatmentData!=null)
		{
			if (treatmentData.getTreatmenttypeid() != 2) {
				String hql = "UPDATE Treatment set treatmenttypeid = :treatmenttypeid "
						+ "WHERE treatmentid = :treatmentid";

				Query query = session.createQuery(hql);
				query.setParameter("treatmenttypeid", 2);
				query.setParameter("treatmentid", treatmentid);
				response = query.executeUpdate();
			} else {// Treatment already opened
				response = 2;
			}
		} else {// Treatment does not exist
			response = 3;
		}
		return response;
		
		
		
	}

}
