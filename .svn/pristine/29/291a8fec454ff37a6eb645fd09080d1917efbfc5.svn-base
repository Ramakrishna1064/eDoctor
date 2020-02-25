package com.ensis.mediguru.dao.patient;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ensis.mediguru.dto.PatientVitalInfoDTO;
import com.ensis.mediguru.dto.TreatmentConsultatonDTO;

public class PatientVitalInfoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public int addPatientVitalInfo(PatientVitalInfoDTO patientVitalInfoDTO) {
		int response = 0;
		try {

			Session session = sessionFactory.getCurrentSession();
			Object obj = session.save(patientVitalInfoDTO).getClass().getName();
			session.flush();
			session.clear();

			if (obj != null) {
				response = 1;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return response;
	}
	
	public int checkPatientVitalInfoExistOrnot(int patientid)
	{
		int response=0;
		
		try {

			String hql = "FROM PatientVitalInfoDTO pv WHERE "
					+ "pv.patientid = :patientid";
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery(hql);
			query.setParameter("patientid", patientid);
			
			List<?> results = query.list();
			Iterator<?> itr = results.iterator();
			if (itr.hasNext()) {
				PatientVitalInfoDTO vitalinfo = (PatientVitalInfoDTO) itr
						.next();
				response = vitalinfo.getPatientid();
			}
			session.flush();
			session.clear();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}
