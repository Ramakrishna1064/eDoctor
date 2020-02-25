/**
 * 
 */
package com.ensis.mediguru.dao.physician;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ensis.mediguru.dao.common.HibernateUtil;
import com.ensis.mediguru.models.PhysicianPatientsOngoingPastGetModel;

/**
 * @author Venu
 *
 */
@Repository
public class PhysicianPatientsDAO {

	@Autowired
	HibernateUtil hibernateUtil;

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * 
	 * @param physicianid
	 * @return
	 */
	public ArrayList<PhysicianPatientsOngoingPastGetModel> getPhysicianPatients(
			int physicianid) {

		try {

			ArrayList<PhysicianPatientsOngoingPastGetModel> physiciansList = new ArrayList<PhysicianPatientsOngoingPastGetModel>();
			Session session = sessionFactory.getCurrentSession();
			SQLQuery sqlQuery = (SQLQuery) session
					.createSQLQuery(
							"CALL getPhysicianOngoingAndPastPatients(:physicianid)")
					.setResultTransformer(
							Transformers
									.aliasToBean(PhysicianPatientsOngoingPastGetModel.class));
			sqlQuery.setParameter("physicianid", physicianid);
			List<?> result = sqlQuery.list();
			session.flush();
			session.clear();
			for (int i = 0; i < result.size(); i++) {

				if (result.get(i) != null) {

					PhysicianPatientsOngoingPastGetModel modelObj = (PhysicianPatientsOngoingPastGetModel) result
							.get(i);
					physiciansList.add(modelObj);
				}
			}

			return physiciansList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
