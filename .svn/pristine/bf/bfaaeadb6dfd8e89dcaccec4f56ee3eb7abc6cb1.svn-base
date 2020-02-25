/**
 * 
 */
package com.ensis.mediguru.dao.patient;

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
import com.ensis.mediguru.dto.PatientPhysicians;
import com.ensis.mediguru.models.PhysicianFavoriteAndFamilyBean;
import com.ensis.mediguru.models.StartTreatmentPhysicianSearchRecordsModel;

/**
 * @author Venu
 *
 */
@Repository
public class PatientMyDoctorsDAO {

	@Autowired
	HibernateUtil hibernateUtil;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * 
	 * @param physicianFavoriteAndFamilyBean
	 * @return
	 */
	public boolean addPhysicianToFavoriteAndFamily(PhysicianFavoriteAndFamilyBean physicianFavoriteAndFamilyBean){		
		
		PatientPhysicians patientPhysicians = new PatientPhysicians();
		patientPhysicians.setPatientid(physicianFavoriteAndFamilyBean.getPatientId());
		patientPhysicians.setPhysicianid(physicianFavoriteAndFamilyBean.getDoctorId());
		Object obj = null;
		for(int i=0;i<physicianFavoriteAndFamilyBean.getTypes().size();i++){
			
			if(physicianFavoriteAndFamilyBean.getTypes().get(i) == 1){
				
				patientPhysicians.setPhysiciantypeid(1);// Favorite
				if (!(checkPhysicianAddedAlready(
						physicianFavoriteAndFamilyBean.getPatientId(),
						physicianFavoriteAndFamilyBean.getDoctorId(), 1))) {
					Session session=sessionFactory.getCurrentSession();
					obj = session.save(patientPhysicians);
					session.flush();
					session.clear();
				}				
			}else if(physicianFavoriteAndFamilyBean.getTypes().get(i) == 2){
				
				patientPhysicians.setPhysiciantypeid(2);// Family
				if (!(checkPhysicianAddedAlready(
						physicianFavoriteAndFamilyBean.getPatientId(),
						physicianFavoriteAndFamilyBean.getDoctorId(), 2))) {
					Session session=sessionFactory.getCurrentSession();
					obj = session.save(patientPhysicians);
					session.flush();
					session.clear();
				}				
			}else if(physicianFavoriteAndFamilyBean.getTypes().get(i) == 3){
				
				patientPhysicians.setPhysiciantypeid(3);// Ongoing
				if (!(checkPhysicianAddedAlready(
						physicianFavoriteAndFamilyBean.getPatientId(),
						physicianFavoriteAndFamilyBean.getDoctorId(), 3))) {
					Session session=sessionFactory.getCurrentSession();
					obj = session.save(patientPhysicians);
					session.flush();
					session.clear();
				}				
			}
		}
		if(obj == null)
			return false;	
		return true;		
	}
	
	/**
	 * 
	 * @param physicianFavoriteAndFamilyBean
	 * @return
	 */
	public boolean removePhysicianFromFavoriteAndFamily(
			PhysicianFavoriteAndFamilyBean physicianFavoriteAndFamilyBean) {

		PatientPhysicians patientPhysicians = new PatientPhysicians();
		patientPhysicians.setPatientid(physicianFavoriteAndFamilyBean
				.getPatientId());
		patientPhysicians.setPhysicianid(physicianFavoriteAndFamilyBean
				.getDoctorId());
		Object obj = null;
		for (int i = 0; i < physicianFavoriteAndFamilyBean.getTypes().size(); i++) {

			if (physicianFavoriteAndFamilyBean.getTypes().get(i) == 1) {

				patientPhysicians.setPhysiciantypeid(1);// Favorite
				if (checkPhysicianAddedAlready(
						physicianFavoriteAndFamilyBean.getPatientId(),
						physicianFavoriteAndFamilyBean.getDoctorId(), 1)) {
					
					Session session=sessionFactory.getCurrentSession();
					Query query = session
							.createQuery(
									"DELETE FROM PatientPhysicians WHERE patientid=:PATIENTID AND physicianid=:PHYSICIANID AND physiciantypeid=:PHYSICINATYPEID");
					query.setParameter("PATIENTID",
							physicianFavoriteAndFamilyBean.getPatientId());
					query.setParameter("PHYSICIANID",
							physicianFavoriteAndFamilyBean.getDoctorId());
					query.setParameter("PHYSICINATYPEID", 1);
					obj = query.executeUpdate();
					session.flush();
					session.clear();
					
				}
			} else if (physicianFavoriteAndFamilyBean.getTypes().get(i) == 2) {

				patientPhysicians.setPhysiciantypeid(2);// Family
				if (checkPhysicianAddedAlready(
						physicianFavoriteAndFamilyBean.getPatientId(),
						physicianFavoriteAndFamilyBean.getDoctorId(), 2)) {
					
					Session session=sessionFactory.getCurrentSession();
					Query query = session
							.createQuery(
									"DELETE FROM PatientPhysicians WHERE patientid=:PATIENTID AND physicianid=:PHYSICIANID AND physiciantypeid=:PHYSICINATYPEID");
					query.setParameter("PATIENTID",
							physicianFavoriteAndFamilyBean.getPatientId());
					query.setParameter("PHYSICIANID",
							physicianFavoriteAndFamilyBean.getDoctorId());
					query.setParameter("PHYSICINATYPEID", 2);
					obj = query.executeUpdate();
					session.flush();
					session.clear();
				}
			}
		}
		if (obj == null)
			return false;
		return true;
	}
	
	/**
	 * 
	 * @param patientId
	 * @param physicianId
	 * @param physiciantypeid
	 * @return
	 */
	public boolean checkPhysicianAddedAlready(int patientId, int physicianId, int physiciantypeid){
		
		try {
			String hql = "FROM PatientPhysicians p WHERE p.patientid = :patientid AND "
					+ "p.physicianid=:physicianid AND p.physiciantypeid=:physiciantypeid ";
			
			Session session=sessionFactory.getCurrentSession();
			Query query = session.createQuery(hql);
			query.setParameter("patientid", patientId);
			query.setParameter("physicianid", physicianId);
			query.setParameter("physiciantypeid", physiciantypeid);
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
	 * @param patientId
	 * @return
	 */
	public ArrayList<StartTreatmentPhysicianSearchRecordsModel> getPatientPhysiciansList(int patientId){
		
		ArrayList<StartTreatmentPhysicianSearchRecordsModel> patientPhysiciansArrayList = 
				new ArrayList<StartTreatmentPhysicianSearchRecordsModel>();
		Session session=sessionFactory.getCurrentSession();
		SQLQuery sqlQuery = (SQLQuery) session.createSQLQuery(
				"CALL getPatientDoctors(:patientid)").setResultTransformer(
				Transformers.aliasToBean(StartTreatmentPhysicianSearchRecordsModel.class));
		sqlQuery.setParameter("patientid", patientId);
		List<?> result = sqlQuery.list();
		session.flush();
		session.clear();
		//System.out.println("Yes size ---->"+result.size());
		for (int i = 0; i < result.size(); i++) {

			if(result.get(i) != null){
			
				StartTreatmentPhysicianSearchRecordsModel patientPhysiciansModel = (StartTreatmentPhysicianSearchRecordsModel) result
						.get(i);
				patientPhysiciansArrayList.add(patientPhysiciansModel);
			}
		}
		return patientPhysiciansArrayList;
	}
}
