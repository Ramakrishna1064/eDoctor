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
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ensis.mediguru.dao.common.HibernateUtil;
import com.ensis.mediguru.dto.TreatmentQuestionReminderDTO;
import com.ensis.mediguru.models.PhysicianQuestionsReminderGetModel;

/**
 * @author Venu
 *
 */
@Repository
public class PhysicianTreatmentQuestionReminderDAO {

	@Autowired
	private HibernateUtil hibernateUtil;

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * 
	 * @param treatmentQuestionReminderDTO
	 * @return
	 */
	public boolean saveTreatmentQuerstionReminder(
			TreatmentQuestionReminderDTO treatmentQuestionReminderDTO) {

		if (treatmentQuestionReminderDTO != null) {

			TreatmentQuestionReminderDTO reminderObj = getReminderObj(
					treatmentQuestionReminderDTO.getPhysicianid(),
					treatmentQuestionReminderDTO.getTreatmentquestionid());
			
			if (reminderObj != null) {

				if (reminderObj.isIsdeleted()) {

					// Update the Question to undelete
					reminderObj.setIsdeleted(false);
					reminderObj.setIsremindercompleted(false);
					reminderObj.setComments(treatmentQuestionReminderDTO.getComments());
					reminderObj.setReminderdate(treatmentQuestionReminderDTO.getReminderdate());
					return updateReminderObj(reminderObj);

				} else {
					return false;
				}

			} else {

				Object obj = hibernateUtil.create(treatmentQuestionReminderDTO);
				if (obj != null)
					return true;
				return false;
			}
		}
		return false;
	}

	
	
	/**
	 * 
	 * @param physicianid
	 * @param date
	 * @return
	 */
	public ArrayList<PhysicianQuestionsReminderGetModel> getQuestionReminders(int physicianid,String date){
		
		String startDateTime=date+" 00:00:00";
		String endDateTime=date+" 23:59:00";
		Session session=sessionFactory.getCurrentSession();
		ArrayList<PhysicianQuestionsReminderGetModel> remindersList=
				new ArrayList<PhysicianQuestionsReminderGetModel>(); 
		SQLQuery sqlQuery = (SQLQuery) session
				.createSQLQuery(
						"CALL getPhysicianQuestionReminders(:physicianid,:startDate,:endDate)")
				.setResultTransformer(
						Transformers
								.aliasToBean(PhysicianQuestionsReminderGetModel.class));
		sqlQuery.setParameter("physicianid", physicianid);
		sqlQuery.setParameter("startDate", startDateTime);
		sqlQuery.setParameter("endDate", endDateTime);
		List<?> result = sqlQuery.list();
		session.flush();
		session.clear();
		for (int i = 0; i < result.size(); i++) {

			if (result.get(i) != null) {

				PhysicianQuestionsReminderGetModel modelObj =(PhysicianQuestionsReminderGetModel) result.get(i);
				remindersList.add(modelObj);
			}
		}
		return remindersList;
	}
	
	/**
	 * 
	 * @param physicianId
	 * @param treatmentquestionid
	 */
	public TreatmentQuestionReminderDTO getReminderObj(int physicianId,int treatmentquestionid){
		
		String hql = "FROM TreatmentQuestionReminderDTO t WHERE "
				+ "t.physicianid = :physicianid AND t.treatmentquestionid=:treatmentquestionid";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter("physicianid", physicianId);
		query.setParameter("treatmentquestionid", treatmentquestionid);
		List<?> results = query.list();
		Iterator<?> itr = results.iterator();
		if (itr.hasNext()) {
			TreatmentQuestionReminderDTO treatmentQuestionReminderDTO = (TreatmentQuestionReminderDTO) itr
					.next();
			return treatmentQuestionReminderDTO;
		}
		session.flush();
		session.clear();
		return null;
	}
	
	/**
	 * 
	 * @param reminderObj
	 * @return
	 */
	public boolean updateReminderObj(TreatmentQuestionReminderDTO reminderObj){
		
		try{
			
			reminderObj.setUpdateddate(new Date());
			Object obj=hibernateUtil.update(reminderObj);
			if(obj != null)
				return true;
			return false;
			
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
}
