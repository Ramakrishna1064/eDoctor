/**
 * 
 */
package com.ensis.mediguru.dao.patient;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;

import com.ensis.mediguru.models.StartTreatmentPhysicianSearchRecordsModel;

/**
 * @author Venu
 *
 */
public class PatientStartTreatmentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * 
	 * @param location
	 * @param specialityId
	 * @return
	 */
	public List<?> getPhysicianSearchRecords( int specialityId,
			int patientid, int treatmentcost, String rating, String hours,String location) {

		Session session = sessionFactory.getCurrentSession();
		SQLQuery sqlQuery = (SQLQuery) session
				.createSQLQuery(
						"CALL getPhysician(:speciality,:patientid,:location,:treatmentcost,:rating)")
				.setResultTransformer(
						Transformers
								.aliasToBean(StartTreatmentPhysicianSearchRecordsModel.class));

		sqlQuery.setParameter("speciality", specialityId);
		sqlQuery.setParameter("location", location);
		sqlQuery.setParameter("patientid", patientid);
		sqlQuery.setParameter("treatmentcost", treatmentcost);
		sqlQuery.setParameter("rating", rating);
		//sqlQuery.setParameter("hours", hours);
		List<?> list = sqlQuery.list();
		session.flush();
		session.clear();
		return list;

	}
}
