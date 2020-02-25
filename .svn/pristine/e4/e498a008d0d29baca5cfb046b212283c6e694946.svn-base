/**
 * 
 */
package com.ensis.mediguru.dao.patient;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ensis.mediguru.dao.common.HibernateUtil;
import com.ensis.mediguru.dto.PhysicianScheduleDTO;
import com.ensis.mediguru.models.PatientSchedulesModel;

/**
 * @author Venu
 *
 */
@Repository
public class PatientSchedulesDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	HibernateUtil hibernateUtil;

	/**
	 * 
	 * @param patientId
	 * @return
	 */
	public ArrayList<PatientSchedulesModel> getPatientSchedules(int patientId) {

		ArrayList<PatientSchedulesModel> patientSchedulesList = new ArrayList<PatientSchedulesModel>();

		Session session=sessionFactory.getCurrentSession();
		SQLQuery sqlQuery = (SQLQuery) session
				.createSQLQuery("CALL getPatientSchedules(:patientid)")
				.setResultTransformer(
						Transformers.aliasToBean(PatientSchedulesModel.class));

		sqlQuery.setParameter("patientid", patientId);
		List<?> result = sqlQuery.list();
		session.flush();
		session.clear();
		for (int i = 0; i < result.size(); i++) {

			if (result.get(i) != null) {

				PatientSchedulesModel patientSchedulesModel = (PatientSchedulesModel) result
						.get(i);
				patientSchedulesList.add(patientSchedulesModel);
			}
		}

		return patientSchedulesList;
	}
	
	/**
	 * 
	 * @param treatmentphyansid
	 * @return
	 */
	public boolean acceptScheduleAppointment(int treatmentquestionid, int physicianId){
		
		int physicianscheduleid=checkPhysicianScheduleExists(treatmentquestionid,physicianId);
		if (physicianscheduleid > 0) {
			
			Session session=sessionFactory.getCurrentSession();
			PhysicianScheduleDTO physicianScheduleDTO = (PhysicianScheduleDTO) session
					.get(PhysicianScheduleDTO.class, physicianscheduleid);
			
			if(physicianScheduleDTO.getRescheduledate() != null){
				physicianScheduleDTO.setScheduledate(physicianScheduleDTO.getRescheduledate());
				physicianScheduleDTO.setRescheduledate(null);
			}
			
			if(physicianScheduleDTO.getRescheduletypeid() != null){
				physicianScheduleDTO.setScheduletypeid(physicianScheduleDTO.getRescheduletypeid());
				physicianScheduleDTO.setRescheduletypeid(null);
			}
			
			System.out.println("--physicianId------>"+physicianScheduleDTO.getPhysicianid());
			
			physicianScheduleDTO.setStatus(2); //Accept Appointment
			session.flush();
			session.clear();
			Object obj=hibernateUtil.update(physicianScheduleDTO);
			if(obj != null)
				return true;
			return false;
			
		} else {
			return false;
		}
	}
	
	
	/**
	 * 
	 * @param treatmentquestionid
	 * @return
	 */
	public int checkPhysicianScheduleExists(int treatmentquestionid,int physicianid) {

		int physicianscheduleid = 0;
		try {

			Session session=sessionFactory.getCurrentSession();
			String hql = "FROM PhysicianScheduleDTO p WHERE "
					+ "p.treatmentquestionid = :treatmentquestionid and p.physicianid =:physicianid";
			Query query = session.createQuery(hql);
			query.setParameter("treatmentquestionid", treatmentquestionid);
			query.setParameter("physicianid", physicianid);
			List<?> results = query.list();
			Iterator<?> itr = results.iterator();
			session.flush();
			session.clear();
			if (itr.hasNext()) {
				PhysicianScheduleDTO physicianScheduleDTO = (PhysicianScheduleDTO) itr.next();
				physicianscheduleid = physicianScheduleDTO.getPhysicianscheduleid();
				System.out.println("physicianscheduleid--"+physicianscheduleid);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return physicianscheduleid;
	}
}
