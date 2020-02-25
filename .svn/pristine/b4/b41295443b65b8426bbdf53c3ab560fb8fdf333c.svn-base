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
import com.ensis.mediguru.dto.Treatment;
import com.ensis.mediguru.dto.TreatmentAnswersDTO;
import com.ensis.mediguru.dto.TreatmentConsultatonDTO;
import com.ensis.mediguru.dto.TreatmentQuestion;
import com.ensis.mediguru.models.GetPhysicianReviewComments;
import com.ensis.mediguru.models.PatientClosedTreatmentQueAndPhysiciansModel;
import com.ensis.mediguru.models.PatientOngoingTreatmentQueAndPhysiciansModel;
import com.ensis.mediguru.models.QuestionsAnswersAndReplyAnswersModel;
import com.ensis.mediguru.models.QuestionsAnswersDetailModel;

/**
 * @author Venu
 *
 */
@Repository
public class PatientQuestionsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private HibernateUtil hibernateUtil;

	/**
	 * 
	 * @param patientId
	 * @return
	 */
	public List<TreatmentQuestion> getPatientQuestionsAndAnswers(int patientId) {

		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("from TreatmentQuestion WHERE patientid=:PATIENTID");
		query.setParameter("PATIENTID", patientId);
		List<TreatmentQuestion> questionsAndAnswersList = query.list();
		session.flush();
		session.clear();
		return questionsAndAnswersList;

	}

	/**
	 * 
	 * @param treatmentPatientAnswerDTO
	 * @return
	 */
	public boolean savePatientTeatmentReplyAns(
			TreatmentAnswersDTO treatmentPatientAnswerDTO) {

		Object obj = hibernateUtil.create(treatmentPatientAnswerDTO);
		if (obj != null)
			return true;
		return false;
	}

	/**
	 * 
	 * @param questionType
	 * @return
	 */
	public boolean updateTreattmentQuestion(int treatmentquestionid,
			int questionType, int physicianId) {

		int treatmentid = checkTreatmentQuestionExists(treatmentquestionid);
		if (treatmentid > 0) {

			Session session = sessionFactory.getCurrentSession();
			Treatment treatment = (Treatment) session.get(Treatment.class,
					treatmentid);
			session.flush();
			session.clear();
			treatment.setTreatmenttypeid(2);
			treatment.setPhysicianid(physicianId);
			Object obj = hibernateUtil.update(treatment);
			if (obj != null)
				return true;
		}
		return false;

	}

	/**
	 * 
	 * @param treatmentquestonId
	 * @return
	 */
	public int getTreatmentIdByTreatmentQuestionID(int treatmentquestonId) {
		int treatmentid = 0;
		try {

			Session session = sessionFactory.getCurrentSession();
			String hql = "FROM TreatmentQuestion p WHERE "
					+ "p.treatmentquestionid = :treatmentquestionid";
			Query query = session.createQuery(hql);
			query.setParameter("treatmentquestionid", treatmentquestonId);
			List<?> results = query.list();
			Iterator<?> itr = results.iterator();
			if (itr.hasNext()) {
				TreatmentQuestion treatmentQuestion = (TreatmentQuestion) itr
						.next();
				treatmentid = treatmentQuestion.getTreatmentid();
			}
			session.flush();
			session.clear();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return treatmentid;
	}

	/**
	 * 
	 * @param treatmentId
	 * @return
	 */

	public int checktreatmentExistinConsultationOrNot(int treatmentId) {
		int consultationcount = 0;
		try {

			String hql = "FROM TreatmentConsultatonDTO t WHERE "
					+ "t.treatmentid = :treatmentId";
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery(hql);
			query.setParameter("treatmentId", treatmentId);

			List<?> results = query.list();
			Iterator<?> itr = results.iterator();
			if (itr.hasNext()) {
				TreatmentConsultatonDTO consultation = (TreatmentConsultatonDTO) itr
						.next();
				consultationcount = consultation.getFollowupconsultationcount();
			}
			session.flush();
			session.clear();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return consultationcount;

	}

	/**
	 * 
	 * @param treatmentid
	 * @return
	 */
	public int updateTreatmentconsultation(int treatmentid, int count) {

		System.out.println("treatmentid====" + treatmentid);
		Session session = sessionFactory.getCurrentSession();

		String hql = "update TreatmentConsultatonDTO t set t.appointmentstatus=:appointmentstatus WHERE t.treatmentid=:treatmentid";

		Query query = session.createQuery(hql);
		query.setParameter("appointmentstatus", false);
		// query.setParameter("followupconsultationcount", count + 1);
		query.setParameter("treatmentid", treatmentid);
		int res = query.executeUpdate();
		return res;
	}

	/**
	 * 
	 * @param treatmentid
	 * @param count
	 * @return
	 */
	public int updateApproveStatus(int treatmentid) {

		System.out.println("treatmentid====" + treatmentid);
		Session session = sessionFactory.getCurrentSession();

		String hql = "update TreatmentConsultatonDTO t set t.appointmentstatus=:appointmentstatus WHERE t.treatmentid=:treatmentid";

		Query query = session.createQuery(hql);
		query.setParameter("appointmentstatus", false);
		query.setParameter("treatmentid", treatmentid);
		int response = query.executeUpdate();
		return response;
	}

	/**
	 * 
	 * @param consultatonDTO
	 * @return
	 */
	public boolean insertTreatmentInconsultation(
			TreatmentConsultatonDTO consultatonDTO) {
		Object obj = hibernateUtil.create(consultatonDTO);
		if (obj != null)
			return true;
		return false;
	}

	/**
	 * 
	 * @param treatmentquestionid
	 * @return
	 */
	public int checkTreatmentQuestionExists(int treatmentquestionid) {

		int treatmentid = 0;
		try {

			Session session = sessionFactory.getCurrentSession();
			String hql = "FROM TreatmentQuestion p WHERE "
					+ "p.treatmentquestionid = :treatmentquestionid";
			Query query = session.createQuery(hql);
			query.setParameter("treatmentquestionid", treatmentquestionid);
			List<?> results = query.list();
			Iterator<?> itr = results.iterator();
			if (itr.hasNext()) {
				TreatmentQuestion treatmentQuestion = (TreatmentQuestion) itr
						.next();
				treatmentid = treatmentQuestion.getTreatmentid();
			}
			session.flush();
			session.clear();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return treatmentid;
	}

	/**
	 * 
	 * @param patientId
	 * @return
	 */
	public ArrayList<PatientOngoingTreatmentQueAndPhysiciansModel> getPatientOngoingQuestions(
			int patientId) {

		ArrayList<PatientOngoingTreatmentQueAndPhysiciansModel> onGoingQuesList = new ArrayList<PatientOngoingTreatmentQueAndPhysiciansModel>();

		Session session = sessionFactory.getCurrentSession();
		SQLQuery sqlQuery = (SQLQuery) session
				.createSQLQuery("CALL getPatientOngoingQuestions(:patientid)")
				.setResultTransformer(
						Transformers
								.aliasToBean(PatientOngoingTreatmentQueAndPhysiciansModel.class));

		sqlQuery.setParameter("patientid", patientId);
		List<?> result = sqlQuery.list();
		session.flush();
		session.clear();
		for (int i = 0; i < result.size(); i++) {

			if (result.get(i) != null) {

				PatientOngoingTreatmentQueAndPhysiciansModel onGoingModel = (PatientOngoingTreatmentQueAndPhysiciansModel) result
						.get(i);
				onGoingQuesList.add(onGoingModel);
			}
		}

		return onGoingQuesList;
	}

	/**
	 * 
	 * @param patientId
	 * @param treatmentquestionid
	 * @return
	 */
	public PatientOngoingTreatmentQueAndPhysiciansModel getPatientTreatmentDetails(
			int patientId, int treatmentquestionid) {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery sqlQuery = (SQLQuery) session
				.createSQLQuery("CALL getPatientTreatmentDetails(:patientid,:treatmentquestionid)")
				.setResultTransformer(
						Transformers
								.aliasToBean(PatientOngoingTreatmentQueAndPhysiciansModel.class));

		sqlQuery.setParameter("patientid", patientId);
		sqlQuery.setParameter("treatmentquestionid", treatmentquestionid);
		List<?> result = sqlQuery.list();
		session.flush();
		session.clear();
		for (int i = 0; i < result.size(); i++) {

			if (result.get(0) != null) {

				PatientOngoingTreatmentQueAndPhysiciansModel onGoingModel = (PatientOngoingTreatmentQueAndPhysiciansModel) result
						.get(0);
				return onGoingModel;
			}
			
			}
			return null;
		}

		
		
	

	/**
	 * 
	 * @param patientId
	 * @return
	 */
	public ArrayList<PatientClosedTreatmentQueAndPhysiciansModel> getPatientClosedTreatment(
			int patientId) {

		ArrayList<PatientClosedTreatmentQueAndPhysiciansModel> onGoingQuesList = new ArrayList<PatientClosedTreatmentQueAndPhysiciansModel>();

		Session session = sessionFactory.getCurrentSession();
		SQLQuery sqlQuery = (SQLQuery) session
				.createSQLQuery("CALL getPatientClosedTreatments(:patientid)")
				.setResultTransformer(
						Transformers
								.aliasToBean(PatientClosedTreatmentQueAndPhysiciansModel.class));

		sqlQuery.setParameter("patientid", patientId);
		List<?> result = sqlQuery.list();
		session.flush();
		session.clear();
		for (int i = 0; i < result.size(); i++) {

			if (result.get(i) != null) {

				PatientClosedTreatmentQueAndPhysiciansModel onGoingModel = (PatientClosedTreatmentQueAndPhysiciansModel) result
						.get(i);
				onGoingQuesList.add(onGoingModel);
			}
		}

		return onGoingQuesList;
	}

	/**
	 * 
	 * @param patientid
	 * @return
	 */
	public ArrayList<QuestionsAnswersAndReplyAnswersModel> getPatinetQuestions(
			int patientid) {

		try {

			ArrayList<QuestionsAnswersAndReplyAnswersModel> physicianQuestionsArrayList = new ArrayList<QuestionsAnswersAndReplyAnswersModel>();

			Session session = sessionFactory.getCurrentSession();
			SQLQuery sqlQuery = (SQLQuery) session
					.createSQLQuery("CALL getPatientAllQuestions(:patientid)")
					.setResultTransformer(
							Transformers
									.aliasToBean(QuestionsAnswersAndReplyAnswersModel.class));

			sqlQuery.setParameter("patientid", patientid);
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
	 * @param treatmentquestionid
	 * @return
	 */
	public ArrayList<QuestionsAnswersDetailModel> getPatinetQuestionDetailAnswers(
			int treatmentquestionid) {

		try {

			ArrayList<QuestionsAnswersDetailModel> physicianQuestionsArrayList = new ArrayList<QuestionsAnswersDetailModel>();

			Session session = sessionFactory.getCurrentSession();
			SQLQuery sqlQuery = (SQLQuery) session
					.createSQLQuery(
							"CALL getStartTreatmentQuestionDetail(:treatmentquestionid)")
					.setResultTransformer(
							Transformers
									.aliasToBean(QuestionsAnswersDetailModel.class));

			sqlQuery.setParameter("treatmentquestionid", treatmentquestionid);
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
	 * @param treatmentquestionid
	 * @return
	 */
	public ArrayList<QuestionsAnswersDetailModel> getOngoingQuestionDetail(
			int treatmentquestionid) {

		try {

			ArrayList<QuestionsAnswersDetailModel> physicianQuestionsArrayList = new ArrayList<QuestionsAnswersDetailModel>();

			Session session = sessionFactory.getCurrentSession();
			SQLQuery sqlQuery = (SQLQuery) session
					.createSQLQuery(
							"CALL getOngoingQuestionDetail(:treatmentquestionid)")
					.setResultTransformer(
							Transformers
									.aliasToBean(QuestionsAnswersDetailModel.class));

			sqlQuery.setParameter("treatmentquestionid", treatmentquestionid);
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
	 * @param physicianId
	 * @return
	 */
	public ArrayList<GetPhysicianReviewComments> getPhysicianReviewComments(
			int physicianId) {

		try {

			ArrayList<GetPhysicianReviewComments> commentsList = new ArrayList<GetPhysicianReviewComments>();

			Session session = sessionFactory.getCurrentSession();
			SQLQuery sqlQuery = (SQLQuery) session
					.createSQLQuery(
							"CALL getPhysicianReviewComments(:physicianid)")
					.setResultTransformer(
							Transformers
									.aliasToBean(GetPhysicianReviewComments.class));

			sqlQuery.setParameter("physicianid", physicianId);
			List<?> result = sqlQuery.list();
			session.flush();
			session.clear();
			for (int i = 0; i < result.size(); i++) {

				if (result.get(i) != null) {

					GetPhysicianReviewComments commentsModel = (GetPhysicianReviewComments) result
							.get(i);
					commentsList.add(commentsModel);
				}
			}

			return commentsList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
