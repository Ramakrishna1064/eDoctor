/**
 * 
 */
package com.ensis.mediguru.dao.physician;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ensis.mediguru.dao.common.HibernateUtil;
import com.ensis.mediguru.dto.PhysicianDeletedQuestionsDTO;
import com.ensis.mediguru.dto.TreatmentAnswersDTO;
import com.ensis.mediguru.dto.TreatmentImages;
import com.ensis.mediguru.dto.TreatmentPhysicianAnswerDTO;
import com.ensis.mediguru.models.QuestionsAnswersAndReplyAnswersModel;
import com.ensis.mediguru.models.QuestionsAnswersDetailModel;

/**
 * @author Venu
 *
 */
@Repository
public class PhysicianQuestionsDAO {

	@Autowired
	private HibernateUtil hibernateUtil;

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * 
	 * @param physicianid
	 * @return
	 */
	public ArrayList<QuestionsAnswersAndReplyAnswersModel> getPhysicianIndividualQuestions(
			int physicianid) {
		try {
			ArrayList<QuestionsAnswersAndReplyAnswersModel> physicianQuestionsArrayList = new ArrayList<QuestionsAnswersAndReplyAnswersModel>();
			Session session = sessionFactory.getCurrentSession();
			SQLQuery sqlQuery = (SQLQuery) session
					.createSQLQuery(
							"CALL getPhysicianQuestions(:physicianid,:treatmenttypeid)")
					.setResultTransformer(
							Transformers
									.aliasToBean(QuestionsAnswersAndReplyAnswersModel.class));
			sqlQuery.setParameter("physicianid", physicianid);
			sqlQuery.setParameter("treatmenttypeid", 1);
			List<?> result = sqlQuery.list();
			session.flush();
			session.clear();
			for (int i = 0; i < result.size(); i++) {

				if (result.get(i) != null) {

					QuestionsAnswersAndReplyAnswersModel modelObj = (QuestionsAnswersAndReplyAnswersModel) result
							.get(i);
					physicianQuestionsArrayList.add(modelObj);
				}
			}

			return physicianQuestionsArrayList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	
	public QuestionsAnswersAndReplyAnswersModel getPhysicianTreatmentDetails(
			int physicianid,int treatmentquestionid) {
		try {
			ArrayList<QuestionsAnswersAndReplyAnswersModel> physicianQuestionsArrayList = new ArrayList<QuestionsAnswersAndReplyAnswersModel>();
			Session session = sessionFactory.getCurrentSession();
			SQLQuery sqlQuery = (SQLQuery) session
					.createSQLQuery(
							"CALL getPhysicianTreatmentDetails(:physicianid,:treatmenttypeid,:treatmentquestionid)")
					.setResultTransformer(
							Transformers
									.aliasToBean(QuestionsAnswersAndReplyAnswersModel.class));
			sqlQuery.setParameter("physicianid", physicianid);
			sqlQuery.setParameter("treatmenttypeid", 1);
			sqlQuery.setParameter("treatmentquestionid", treatmentquestionid);
			List<?> result = sqlQuery.list();
			session.flush();
			session.clear();
			for (int i = 0; i < result.size(); i++) {

				if (result.get(i) != null) {

					QuestionsAnswersAndReplyAnswersModel modelObj = (QuestionsAnswersAndReplyAnswersModel) result
							.get(0);
					//physicianQuestionsArrayList.add(modelObj);
					return modelObj;
					
				}
			}

			//return modelObj;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param physicianid
	 * @return
	 */
	public ArrayList<QuestionsAnswersAndReplyAnswersModel> getPhysicianOngoingQuestions(
			int physicianid) {

		try {

			ArrayList<QuestionsAnswersAndReplyAnswersModel> physicianQuestionsArrayList = new ArrayList<QuestionsAnswersAndReplyAnswersModel>();
			Session session = sessionFactory.getCurrentSession();
			SQLQuery sqlQuery = (SQLQuery) session
					.createSQLQuery(
							"CALL getPhysicianQuestions(:physicianid,:treatmenttypeid)")
					.setResultTransformer(
							Transformers
									.aliasToBean(QuestionsAnswersAndReplyAnswersModel.class));
			sqlQuery.setParameter("physicianid", physicianid);
			sqlQuery.setParameter("treatmenttypeid", 2);
			List<?> result = sqlQuery.list();
			session.flush();
			session.clear();
			for (int i = 0; i < result.size(); i++) {

				if (result.get(i) != null) {

					QuestionsAnswersAndReplyAnswersModel modelObj = (QuestionsAnswersAndReplyAnswersModel) result
							.get(i);
					physicianQuestionsArrayList.add(modelObj);
				}
			}

			return physicianQuestionsArrayList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 
	 * @param physicianid
	 * @return
	 */
	public ArrayList<QuestionsAnswersAndReplyAnswersModel> getPhysicianClosedQuestions(
			int physicianid) {

		try {

			ArrayList<QuestionsAnswersAndReplyAnswersModel> physicianQuestionsArrayList = new ArrayList<QuestionsAnswersAndReplyAnswersModel>();
			Session session = sessionFactory.getCurrentSession();
			SQLQuery sqlQuery = (SQLQuery) session
					.createSQLQuery(
							"CALL getPhysicianQuestions(:physicianid,:treatmenttypeid)")
					.setResultTransformer(
							Transformers
									.aliasToBean(QuestionsAnswersAndReplyAnswersModel.class));
			sqlQuery.setParameter("physicianid", physicianid);
			sqlQuery.setParameter("treatmenttypeid", 3);
			List<?> result = sqlQuery.list();
			session.flush();
			session.clear();
			for (int i = 0; i < result.size(); i++) {

				if (result.get(i) != null) {

					QuestionsAnswersAndReplyAnswersModel modelObj = (QuestionsAnswersAndReplyAnswersModel) result
							.get(i);
					physicianQuestionsArrayList.add(modelObj);
				}
			}

			return physicianQuestionsArrayList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param treatmentQuesId
	 * @return
	 */
	public ArrayList<TreatmentImages> getTreatmentImages(int treatmentQuesId) {

		try {

			ArrayList<TreatmentImages> treatmentImages = new ArrayList<TreatmentImages>();
			Session session = sessionFactory.getCurrentSession();
			Query query = session
					.createQuery("from TreatmentImages WHERE treatmentquestionid=:TreatmentQuestionId");
			query.setParameter("TreatmentQuestionId", treatmentQuesId);
			List<TreatmentImages> treatmentImagesList = query.list();
			session.flush();
			session.clear();
			for (int i = 0; i < treatmentImagesList.size(); i++) {

				// if (treatmentImagesList.get(i) != null) {

				TreatmentImages treaImageObj = treatmentImagesList.get(i);
				treaImageObj.setImage(treaImageObj.getImage());
				treatmentImages.add(treaImageObj);
				// }
			}
			return treatmentImages;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param physicianid
	 * @param tretstatustypeid
	 * @return
	 */
	public ArrayList<QuestionsAnswersAndReplyAnswersModel> getPhysicianGroupQuestions(int physicianid,
			int specialitytypeid) {
		try {

			ArrayList<QuestionsAnswersAndReplyAnswersModel> physicianQuestionsArrayList =
					new ArrayList<QuestionsAnswersAndReplyAnswersModel>();
			Session session = sessionFactory.getCurrentSession();
			SQLQuery sqlQuery = (SQLQuery) session
					.createSQLQuery(
							"CALL getPhysicianGroupQuestions(:physicianid,:specialitytypeid)")
					.setResultTransformer(
							Transformers
									.aliasToBean(QuestionsAnswersAndReplyAnswersModel.class));

			sqlQuery.setParameter("physicianid", physicianid);
			sqlQuery.setParameter("specialitytypeid", specialitytypeid);
			List<?> result = sqlQuery.list();
			session.flush();
			session.clear();
			for (int i = 0; i < result.size(); i++) {

				if (result.get(i) != null) {

					QuestionsAnswersAndReplyAnswersModel physicianQuestionsAndAnswersModel = (QuestionsAnswersAndReplyAnswersModel) result
							.get(i);
					physicianQuestionsArrayList
							.add(physicianQuestionsAndAnswersModel);
				}
			}

			return physicianQuestionsArrayList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param treatmentPhysicianAnswerDTO
	 * @return
	 */
	public int savePhysicianTreatmentAnswer(
			TreatmentPhysicianAnswerDTO treatmentPhysicianAnswerDTO) {

		Object obj = hibernateUtil.create(treatmentPhysicianAnswerDTO);
		if (obj != null) {

			Session session = sessionFactory.getCurrentSession();
			int treatmentphyansid = (Integer) session
					.createCriteria(TreatmentPhysicianAnswerDTO.class)
					.setProjection(Projections.max("treatmentphyansid"))
					.uniqueResult();
			session.flush();
			session.clear();
			return treatmentphyansid;
		}
		return 0;
	}

	/**
	 * 
	 * @param treatmentPatientAnswerDTO
	 * @return
	 */
	public boolean savePhysicianTeatmentReplyAns(
			TreatmentAnswersDTO treatmentPatientAnswerDTO) {

		Object obj = hibernateUtil.create(treatmentPatientAnswerDTO);
		if (obj != null)
			return true;
		return false;
	}
	
	/**
	 * 
	 * @param treatmentquestionId
	 * @param physicianId
	 * @return
	 */
	public ArrayList<QuestionsAnswersDetailModel> getPhysicianQuestionDetailAnswers(
			int treatmentquestionId, int physicianId) {

		try {

			ArrayList<QuestionsAnswersDetailModel> physicianQuestionsArrayList = new ArrayList<QuestionsAnswersDetailModel>();

			Session session = sessionFactory.getCurrentSession();
			SQLQuery sqlQuery = (SQLQuery) session
					.createSQLQuery(
							"CALL getPhysicianQuestionDetails(:treatmentquestionid,:physicianid)")
					.setResultTransformer(
							Transformers
									.aliasToBean(QuestionsAnswersDetailModel.class));

			sqlQuery.setParameter("treatmentquestionid", treatmentquestionId);
			sqlQuery.setParameter("physicianid", physicianId);
			List<?> result = sqlQuery.list();
			session.flush();
			session.clear();
			for (int i = 0; i < result.size(); i++) {

				if (result.get(i) != null) {

					QuestionsAnswersDetailModel physicianQuestionsAndAnswersModel = (QuestionsAnswersDetailModel) result
							.get(i);
					physicianQuestionsArrayList
							.add(physicianQuestionsAndAnswersModel);
				}
			}

			return physicianQuestionsArrayList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 
	 * @param physicianDeletedQuestionsDTO
	 * @return
	 */
	public boolean deletePhysicianQuestion(PhysicianDeletedQuestionsDTO physicianDeletedQuestionsDTO){
		
		int deletedQuesId=checkIsDeletedQuestionsExist(physicianDeletedQuestionsDTO.getPhysicianid(),
				physicianDeletedQuestionsDTO.getTreatmentquestionid());
		if(deletedQuesId>0){
			return false;
		}else{
			Object obj = hibernateUtil.create(physicianDeletedQuestionsDTO);
			if (obj != null)
				return true;
			return false;
		}
	}
	
	/**
	 * 
	 * @param physicianId
	 * @param treatmentquestionId
	 * @return
	 */
	public int checkIsDeletedQuestionsExist(int physicianId, int treatmentquestionId){
		
		int deletedId = 0;
		try {

			String hql = "FROM PhysicianDeletedQuestionsDTO WHERE "
					+ "treatmentquestionid = :treatmentquestionid AND "
					+ "physicianid=:physicianid";
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery(hql);
			query.setParameter("treatmentquestionid", treatmentquestionId);
			query.setParameter("physicianid", physicianId);

			List<?> results = query.list();
			Iterator<?> itr = results.iterator();
			while (itr.hasNext()) {
				PhysicianDeletedQuestionsDTO ppreference = (PhysicianDeletedQuestionsDTO) itr.next();
				deletedId = ppreference.getDeletedquesid();
			}
			session.flush();
			session.clear();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return deletedId;
	}

}
