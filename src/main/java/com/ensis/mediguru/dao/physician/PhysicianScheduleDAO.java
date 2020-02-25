/**
 * 
 */
package com.ensis.mediguru.dao.physician;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StaleStateException;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ensis.mediguru.dao.common.HibernateUtil;
import com.ensis.mediguru.dao.patient.PatientSchedulesDAO;
import com.ensis.mediguru.dto.PhysicianScheduleDTO;
import com.ensis.mediguru.models.PatientOngoingTreatmentQueAndPhysiciansModel;
import com.ensis.mediguru.models.PatientPhysicianReplyAnswerModel;
import com.ensis.mediguru.models.PhysicianFavoriteFamilyOngoingCount;
import com.ensis.mediguru.models.PhysicianScheduleCount;
import com.ensis.mediguru.models.PhysicianSchedulesModel;
import com.ensis.mediguru.utils.Utilities;

/**
 * @author Venu
 *
 */
@Repository
public class PhysicianScheduleDAO {

	@Autowired
	HibernateUtil hibernateUtil;

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	PatientSchedulesDAO patientSchedulesDAO;

	/**
	 * @param hibernateUtil
	 *            the hibernateUtil to set
	 */
	public void setHibernateUtil(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}

	/**
	 * @param sessionFactory
	 *            the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * @param patientSchedulesDAO
	 *            the patientSchedulesDAO to set
	 */
	public void setPatientSchedulesDAO(PatientSchedulesDAO patientSchedulesDAO) {
		this.patientSchedulesDAO = patientSchedulesDAO;
	}

	/**
	 * 
	 * @param physicianScheduleDTO
	 * @return
	 */
	public boolean savePhysicianSchedule(PhysicianScheduleDTO physicianScheduleDTO) {

		if (!checkPhysicianAppointmentExists(physicianScheduleDTO.getPhysicianid(),
				physicianScheduleDTO.getTreatmentquestionid())) {

			Object obj = hibernateUtil.create(physicianScheduleDTO);
			if (obj != null)
				return true;
			return false;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @param physicianId
	 * @param treatmentquestionid
	 * @return
	 */
	public boolean checkPhysicianAppointmentExists(int physicianId, int treatmentquestionid) {

		try {

			Session session = sessionFactory.getCurrentSession();
			String hql = "FROM PhysicianScheduleDTO p WHERE p.physicianid=:physicianid "
					+ "AND p.treatmentquestionid=:treatmentquestionid ";
			Query query = session.createQuery(hql);
			query.setParameter("physicianid", physicianId);
			query.setParameter("treatmentquestionid", treatmentquestionid);
			List<?> results = query.list();
			session.flush();
			session.clear();
			if (results.size() == 0) {
				return false;
			} else {
				return true;
			}
		} catch (StaleStateException t) {
			t.printStackTrace();
			return false;
		}
	}

	/**
	 * 
	 * @param physicianid
	 * @return
	 */
	public ArrayList<PhysicianSchedulesModel> getPhysicianCuurentDaySchedules(int physicianid, String currentDate) {

		String startDateTime = currentDate + " 00:00:00";
		String endDateTime = currentDate + " 23:59:00";
		Session session = sessionFactory.getCurrentSession();
		ArrayList<PhysicianSchedulesModel> schedulesList = new ArrayList<PhysicianSchedulesModel>();
		SQLQuery sqlQuery = (SQLQuery) session
				.createSQLQuery("CALL getPhysicianCurrentDaySchedules(:physicianid,:startDate,:endDate)")
				.setResultTransformer(Transformers.aliasToBean(PhysicianSchedulesModel.class));
		sqlQuery.setParameter("physicianid", physicianid);
		sqlQuery.setParameter("startDate", startDateTime);
		sqlQuery.setParameter("endDate", endDateTime);
		List<?> result = sqlQuery.list();
		session.flush();
		session.clear();
		for (int i = 0; i < result.size(); i++) {

			if (result.get(i) != null) {

				PhysicianSchedulesModel modelObj = (PhysicianSchedulesModel) result.get(i);
				schedulesList.add(modelObj);
			}
		}
		return schedulesList;
	}

	/**
	 * 
	 * @param physicianid
	 * @return
	 */
	public PhysicianFavoriteFamilyOngoingCount getPhysicianFavFamilyOngoingCount(int physicianid) {

		Session session = sessionFactory.getCurrentSession();
		PhysicianFavoriteFamilyOngoingCount modelObj = new PhysicianFavoriteFamilyOngoingCount();
		SQLQuery sqlQuery = (SQLQuery) session
				.createSQLQuery("CALL getPhysicianPateintFavFamilyOngoingCount(:physicianid)")
				.setResultTransformer(Transformers.aliasToBean(PhysicianFavoriteFamilyOngoingCount.class));
		sqlQuery.setParameter("physicianid", physicianid);
		List<?> result = sqlQuery.list();
		session.flush();
		session.clear();

		for (int i = 0; i < result.size(); i++) {

			if (result.get(i) != null) {

				modelObj = (PhysicianFavoriteFamilyOngoingCount) result.get(i);
				return modelObj;
			}
		}
		return modelObj;
	}

	/**
	 * 
	 * @param physicianid
	 * @return
	 */
	public ArrayList<PhysicianScheduleCount> getPhysicianScheduleCount(int physicianid) {

		ArrayList<PhysicianScheduleCount> schedulesCountList = new ArrayList<PhysicianScheduleCount>();
		Session session = sessionFactory.getCurrentSession();
		SQLQuery sqlQuery = (SQLQuery) session.createSQLQuery("CALL getPhysicianScheduleCount(:physicianid)")
				.setResultTransformer(Transformers.aliasToBean(PhysicianScheduleCount.class));
		sqlQuery.setParameter("physicianid", physicianid);
		List<?> result = sqlQuery.list();
		session.flush();
		session.clear();

		for (int i = 0; i < result.size(); i++) {

			if (result.get(i) != null) {

				PhysicianScheduleCount schedulecount = (PhysicianScheduleCount) result.get(i);
				schedulesCountList.add(schedulecount);
			}
		}
		return schedulesCountList;
	}

	/**
	 * 
	 * @param physicianid
	 * @return
	 */
	public ArrayList<PatientOngoingTreatmentQueAndPhysiciansModel> getPhysicianSchedules(int physicianid, String date) {

		String startDateTime = date + " 00:00:00";
		String endDateTime = date + " 23:59:00";

		Session session = sessionFactory.getCurrentSession();
		ArrayList<PatientOngoingTreatmentQueAndPhysiciansModel> schedulesList = new ArrayList<PatientOngoingTreatmentQueAndPhysiciansModel>();
		SQLQuery sqlQuery = (SQLQuery) session
				.createSQLQuery("CALL getPhysicianOngoingSchedules(:physicianid,:startDate,:endDate)")
				.setResultTransformer(Transformers.aliasToBean(PatientOngoingTreatmentQueAndPhysiciansModel.class));
		sqlQuery.setParameter("physicianid", physicianid);
		sqlQuery.setParameter("startDate", startDateTime);
		sqlQuery.setParameter("endDate", endDateTime);
		List<?> result = sqlQuery.list();
		session.flush();
		session.clear();
		for (int i = 0; i < result.size(); i++) {

			if (result.get(i) != null) {

				PatientOngoingTreatmentQueAndPhysiciansModel modelObj = (PatientOngoingTreatmentQueAndPhysiciansModel) result
						.get(i);
				schedulesList.add(modelObj);
			}
		}
		return schedulesList;
	}

	/**
	 * 
	 * @param patientPhysicianReplyAnswerModel
	 * @return
	 */
	public boolean rescheduleAppointment(PatientPhysicianReplyAnswerModel patientPhysicianReplyAnswerModel) {

		int physicianscheduleid = patientSchedulesDAO
				.checkPhysicianScheduleExists(patientPhysicianReplyAnswerModel.getTreatmentquestionid(),
						patientPhysicianReplyAnswerModel.getPhysicianid());
		System.out.println("physicianscheduleid=="+physicianscheduleid);
		if (physicianscheduleid > 0) {

			Session session = sessionFactory.getCurrentSession();
			PhysicianScheduleDTO physicianScheduleDTO = (PhysicianScheduleDTO) session.get(PhysicianScheduleDTO.class,
					physicianscheduleid);
			if (patientPhysicianReplyAnswerModel.getScheduledate() != null) {
				physicianScheduleDTO.setRescheduledate(
						Utilities.getDateAndTimeFormat(patientPhysicianReplyAnswerModel.getScheduledate()));
			}
			if (patientPhysicianReplyAnswerModel.getScheduletypeid() != 0) {
				physicianScheduleDTO.setRescheduletypeid(patientPhysicianReplyAnswerModel.getScheduletypeid());
			}
			//physicianScheduleDTO.setStatus(status);

			Object obj = hibernateUtil.update(physicianScheduleDTO);
			if (obj != null)
				return true;
			return false;
		} else {
			return false;
		}
	}
	
	

}
