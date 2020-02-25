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
import com.ensis.mediguru.dto.PatientMedicalData;
import com.ensis.mediguru.dto.PatientMedicalNotes;
import com.ensis.mediguru.dto.PatientMedicineTimings;
import com.ensis.mediguru.dto.TreatmentConsultatonDTO;
import com.ensis.mediguru.models.GetPatientMedicinesModel;
import com.ensis.mediguru.models.PatientMedicineTypeModel;
import com.ensis.mediguru.models.PatientPastConsultationIds;
import com.ensis.mediguru.models.UpdatePatientMedicine;
import com.ensis.mediguru.utils.Utilities;

@Repository
public class PhysicianMedicinesDAO {

	@Autowired
	private HibernateUtil hibernateUtil;

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * 
	 * @param patientMedicalNotes
	 * @return
	 */
	public int addPatientMedicineNotes(PatientMedicalNotes patientMedicalNotes) {
		int response = 0;
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(patientMedicalNotes);
			int noteid = (Integer) session
					.createCriteria(PatientMedicalNotes.class)
					.setProjection(Projections.max("noteid")).uniqueResult();
			response = noteid;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	/**
	 * 
	 * @param treatmentId
	 * @return
	 */
	public Boolean checkConsultPhysicianFirstTime(int treatmentId) {
		Boolean firstconsultation = false;
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
				firstconsultation = consultation.getFirstconsultation();
			}
			session.flush();
			session.clear();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return firstconsultation;

	}

	/**
	 * 
	 * @param treatmentId
	 * @return
	 */
	public Boolean getApproveStatus(int treatmentId) {
		Boolean firstconsultation = false;
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
				firstconsultation = consultation.getAppointmentstatus();
			}
			session.flush();
			session.clear();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return firstconsultation;

	}

	/**
	 * 
	 * @param treatmentConsultatonDTO
	 * @return
	 */
	public int addPatientConsultaion(
			TreatmentConsultatonDTO treatmentConsultatonDTO) {
		int consultationid = 0;
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(treatmentConsultatonDTO);
			consultationid = (Integer) session
					.createCriteria(TreatmentConsultatonDTO.class)
					.setProjection(Projections.max("consultationid"))
					.uniqueResult();
			return consultationid;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return consultationid;
	}

	/**
	 * 
	 * @param treatmentid
	 * @return
	 */
	public int updateApproveStatus(int treatmentid) {

		System.out.println("treatmentid====" + treatmentid);
		Session session = sessionFactory.getCurrentSession();

		String hql = "update TreatmentConsultatonDTO t set t.appointmentstatus=:appointmentstatus WHERE t.treatmentid=:treatmentid";

		Query query = session.createQuery(hql);
		query.setParameter("appointmentstatus", true);
		query.setParameter("treatmentid", treatmentid);
		int response = query.executeUpdate();
		return response;
	}

	/**
	 * 
	 * @param patientMedicine
	 * @return
	 */
	public int addPatientMedicines(PatientMedicalData patientMedicine) {
		int response = 0;
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(patientMedicine);
			int medicaldataid = (Integer) session
					.createCriteria(PatientMedicalData.class)
					.setProjection(Projections.max("patientmedicaldataid"))
					.uniqueResult();
			response = medicaldataid;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	/**
	 * 
	 * @param patientMedicalData
	 * @param patientmedicialdataid
	 * @return
	 */
	public int updatePatientMedicicnes(
			UpdatePatientMedicine updatePatientMedicine,
			int patientmedicialdataid) {
		System.out.println(patientmedicialdataid);
		int response = 0;
		try {
			Session session = sessionFactory.getCurrentSession();
			PatientMedicalData medicineData = (PatientMedicalData) session.get(
					PatientMedicalData.class, patientmedicialdataid);

			System.out.println(medicineData.getDosage());
			medicineData.setMedicinedatatypeid(updatePatientMedicine
					.getMedicinedatatypeid());
			medicineData.setMedicinename(updatePatientMedicine
					.getMedicinename());
			medicineData.setDosage(updatePatientMedicine.getDosage());
			medicineData
					.setStartdate(Utilities
							.getMedicineDateFormat(updatePatientMedicine
									.getStartdate()));
			medicineData.setEnddate(Utilities
					.getMedicineDateFormat(updatePatientMedicine.getEnddate()));
			medicineData.setComments(updatePatientMedicine.getNotes());
			hibernateUtil.update(medicineData);
			return response = 1;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	/**
	 * 
	 * @param patientMedicinesModel
	 * @param medicaldataId
	 * @return
	 */
	public boolean addPatientMedicineTimings(
			PatientMedicineTypeModel medicineTypeModel, int medicaldataId) {

		Object obj = null;
		try {
			PatientMedicineTimings medicineTimings = new PatientMedicineTimings();
			for (int i = 0; i < medicineTypeModel.getMedicinetimings().size(); i++) {

				Session session = sessionFactory.getCurrentSession();
				medicineTimings.setPatientmedicaldataid(medicaldataId);
				medicineTimings.setMedicinetimingsid(medicineTypeModel
						.getMedicinetimings().get(i));
				obj = session.save(medicineTimings);
				session.flush();
				session.clear();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (obj == null)
			return false;
		return true;

	}

	/**
	 * 
	 * @param patientmedicaldataid
	 * @return
	 */
	public ArrayList<PatientMedicineTimings> getPatientMedicicneTimings(
			int patientmedicaldataid) {

		List<PatientMedicineTimings> timings = new ArrayList<PatientMedicineTimings>();
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("from PatientMedicineTimings WHERE patientmedicaldataid=:patientmedicaldataid");
		query.setParameter("patientmedicaldataid", patientmedicaldataid);
		// query.setParameter("medicinetimingsid", medicinetimingsid);
		List<?> results = query.list();
		session.flush();
		session.clear();
		for (int i = 0; i < results.size(); i++) {

			PatientMedicineTimings treatmentTimings = (PatientMedicineTimings) results
					.get(i);
			timings.add(treatmentTimings);
		}
		return (ArrayList<PatientMedicineTimings>) timings;

	}

	/**
	 * 
	 * @param medicinetimings
	 * @return
	 */
	public boolean deleteMedicineTimings(PatientMedicineTimings medicinetimings) {

		Session session = sessionFactory.getCurrentSession();
		session.delete(medicinetimings);
		session.flush();
		session.clear();
		return true;
	}

	/**
	 * 
	 * @param physicianId
	 * @param languageId
	 */
	public void createOrUpdateMedicineTimings(int patientid,
			int patientmedicaldataid, int medicinetimingsid) {

		try {

			int medTimingPrimaryId = checkMedicineTimingExists(
					patientmedicaldataid, medicinetimingsid);
			if (medTimingPrimaryId > 0) {
				System.out.println(patientid + "--" + patientmedicaldataid
						+ "--" + medicinetimingsid);
				Session session = sessionFactory.getCurrentSession();
				PatientMedicineTimings medicineTimings = (PatientMedicineTimings) session
						.get(PatientMedicineTimings.class, medTimingPrimaryId);

				medicineTimings.setPatientmedicaldataid(patientmedicaldataid);
				medicineTimings.setMedicinetimingsid(medicinetimingsid);

				session.flush();
				session.clear();

				hibernateUtil.update(medicineTimings);

			} else {

				System.out.println(patientid + "--" + patientmedicaldataid
						+ "--" + medicinetimingsid);

				PatientMedicineTimings medicineTimings = new PatientMedicineTimings();
				medicineTimings.setPatientmedicaldataid(patientmedicaldataid);
				medicineTimings.setMedicinetimingsid(medicinetimingsid);

				hibernateUtil.create(medicineTimings).getClass().getName();

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param patientmedicaldataid
	 * @param medicinetimingsid
	 * @return
	 */
	public int checkMedicineTimingExists(int patientmedicaldataid,
			int medicinetimingsid) {

		int mTimingId = 0;
		try {

			String hql = "FROM PatientMedicineTimings p WHERE "
					+ "p.patientmedicaldataid = :patientmedicaldataid AND p.medicinetimingsid=:medicinetimingsid";
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery(hql);
			query.setParameter("patientmedicaldataid", patientmedicaldataid);
			query.setParameter("medicinetimingsid", medicinetimingsid);

			List<?> results = query.list();
			Iterator<?> itr = results.iterator();
			if (itr.hasNext()) {
				PatientMedicineTimings mtimings = (PatientMedicineTimings) itr
						.next();
				mTimingId = mtimings.getMedicinetimingsid();
			}
			session.flush();
			session.clear();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return mTimingId;
	}

	/**
	 * 
	 * @param patientmedicaldataid
	 * @return
	 */
	public int deletePatientMedicine(int patientmedicaldataid) {
		int response = 0;
		try {
			Session session = sessionFactory.getCurrentSession();
			PatientMedicalData medicialData = (PatientMedicalData) session.get(
					PatientMedicalData.class, patientmedicaldataid);
			session.delete(medicialData);
			response = 1;
			return response;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	/**
	 * 
	 * @param treatmentId
	 * @param type
	 * @return
	 */
	public ArrayList<GetPatientMedicinesModel> getMedicines(int treatmentId,
			int type) {

		//
		Session session = sessionFactory.getCurrentSession();
		SQLQuery sqlQuery = (SQLQuery) session.createSQLQuery(
				"CALL getPatientMedicines(:treatmentid,:sectype)")
				.setResultTransformer(
						Transformers
								.aliasToBean(GetPatientMedicinesModel.class));
		sqlQuery.setParameter("treatmentid", treatmentId);
		sqlQuery.setParameter("sectype", type);

		ArrayList<GetPatientMedicinesModel> list = (ArrayList<GetPatientMedicinesModel>) sqlQuery
				.list();
		session.flush();
		session.clear();
		return list;
	}

	public ArrayList<GetPatientMedicinesModel> getOngoingMedicines(
			int treatmentId) {

		//
		Session session = sessionFactory.getCurrentSession();
		SQLQuery sqlQuery = (SQLQuery) session.createSQLQuery(
				"CALL getOngoingPatientMedicines(:treatmentid)")
				.setResultTransformer(
						Transformers
								.aliasToBean(GetPatientMedicinesModel.class));
		sqlQuery.setParameter("treatmentid", treatmentId);
		ArrayList<GetPatientMedicinesModel> list = (ArrayList<GetPatientMedicinesModel>) sqlQuery
				.list();
		session.flush();
		session.clear();
		return list;
	}
	
	public ArrayList<GetPatientMedicinesModel> getPastMedicines(
			int treatmentId,Integer consultationid) {

		System.out.println(treatmentId+"-comming man--"+consultationid);
		//
		Session session = sessionFactory.getCurrentSession();
		SQLQuery sqlQuery = (SQLQuery) session.createSQLQuery(
				"CALL getPatientPastMedicines(:treatmentid,:consultationid)")
				.setResultTransformer(
						Transformers
								.aliasToBean(GetPatientMedicinesModel.class));
		sqlQuery.setParameter("treatmentid", treatmentId);
		sqlQuery.setParameter("consultationid", consultationid);
		ArrayList<GetPatientMedicinesModel> list = (ArrayList<GetPatientMedicinesModel>) sqlQuery
				.list();
		session.flush();
		session.clear();
		System.out.println(list.size());
		return list;
	}

	/**
	 * 
	 * @param treatmentId
	 * @return
	 */
	public ArrayList<PatientMedicalNotes> getMedicineNotes(int consultationId) {

		ArrayList<PatientMedicalNotes> notesList = new ArrayList<PatientMedicalNotes>();
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("from PatientMedicalNotes WHERE consultationid=:consultationId");
		query.setParameter("consultationId", consultationId);
		List<?> results = query.list();
		session.flush();
		session.clear();
		for (int i = 0; i < results.size(); i++) {

			PatientMedicalNotes notes = (PatientMedicalNotes) results.get(i);
			notesList.add(notes);
		}
		return notesList;
	}
	
	/**
	 * 
	 * @param consultationId
	 * @return
	 */
	public ArrayList<PatientMedicalNotes> getPastMedicineNotes(int consultationId) {

		ArrayList<PatientMedicalNotes> notesList = new ArrayList<PatientMedicalNotes>();
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("from PatientMedicalNotes WHERE consultationid=:consultationId");
		query.setParameter("consultationId", consultationId);
		List<?> results = query.list();
		session.flush();
		session.clear();
		for (int i = 0; i < results.size(); i++) {

			PatientMedicalNotes notes = (PatientMedicalNotes) results.get(i);
			notesList.add(notes);
		}
		return notesList;
	}

	public Integer getLatestMedicalConsultationId(int treatmentId) {

		Integer Id = 0;
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("SELECT  MAX(consultationid) FROM TreatmentConsultatonDTO WHERE treatmentid=:treatmentid");
		query.setParameter("treatmentid", treatmentId);
		List<?> results = query.list();
		session.flush();
		session.clear();
		for (int i = 0; i < results.size(); i++) {
			System.out.println(results.get(i));
			Id = (Integer) results.get(i);

		}
		return Id;
	}

	/**
	 * 
	 * @param treatmentId
	 * @return
	 */
	public List<Integer> getPastConsultationdIds(int treatmentId) {
		List<Integer> s = new ArrayList<Integer>();
		Session session = sessionFactory.getCurrentSession();
		SQLQuery sqlQuery = (SQLQuery) session.createSQLQuery(
				"CALL getPastConsultationIds(:treatmentid)")
				.setResultTransformer(
						Transformers
								.aliasToBean(PatientPastConsultationIds.class));
		sqlQuery.setParameter("treatmentid", treatmentId);
		List<?> results = sqlQuery.list();
		session.flush();
		session.clear();
		for (int i = 0; i < results.size(); i++) {

			PatientPastConsultationIds id = (PatientPastConsultationIds) results
					.get(i);
			s.add(i, id.getConsultationid());

		}
		return s;

	}
	
	/**
	 * 
	 * @param treatmentId
	 * @return
	 */
	public List<Integer> getTreatmentConsultationdIds(int treatmentId) {
		List<Integer> s = new ArrayList<Integer>();
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("SELECT consultationid FROM TreatmentConsultatonDTO tm WHERE tm.treatmentid=:treatmentid ORDER BY consultationid DESC");
		query.setParameter("treatmentid", treatmentId);
		List<?> results = query.list();
		session.flush();
		session.clear();
		for (int i = 0; i < results.size(); i++) {

			
			s.add(i,(Integer) results.get(i));

		}
		return s;

	}
	
	/**
	 * 
	 * @param treatmentId
	 * @return
	 */

	public ArrayList<PatientMedicalNotes> getMedicineNote(int treatmentId) {

		ArrayList<PatientMedicalNotes> notesList = new ArrayList<PatientMedicalNotes>();
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("from PatientMedicalNotes WHERE treatmentid=:treatmentid");
		query.setParameter("treatmentid", treatmentId);
		List<?> results = query.list();
		session.flush();
		session.clear();
		for (int i = 0; i < results.size(); i++) {

			PatientMedicalNotes notes = (PatientMedicalNotes) results.get(i);
			notesList.add(notes);
		}
		return notesList;
	}
	
	
	/**
	 * 
	 * @param treatmentId
	 * @return
	 */
	public ArrayList<GetPatientMedicinesModel> getPatientMedicines(int treatmentId){
		
		ArrayList<GetPatientMedicinesModel> medicinesList = new ArrayList<GetPatientMedicinesModel>();
		Session session = sessionFactory.getCurrentSession();
		SQLQuery sqlQuery = (SQLQuery) session.createSQLQuery(
				"CALL getPatientMedicines(:treatmentid)")
				.setResultTransformer(
						Transformers
								.aliasToBean(GetPatientMedicinesModel.class));
		sqlQuery.setParameter("treatmentid", treatmentId);
		List<?> results = sqlQuery.list();
		session.flush();
		session.clear();
		for (int i = 0; i < results.size(); i++) {

			GetPatientMedicinesModel medicinesModel = (GetPatientMedicinesModel) results
					.get(i);
			medicinesList.add(medicinesModel);
		
		}
		System.out.println("---->"+medicinesList.size());
		return medicinesList;
	}
}
