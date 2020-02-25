/**
 * 
 */
package com.ensis.mediguru.service.patient;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensis.mediguru.dao.common.CommonDAO;
import com.ensis.mediguru.dao.patient.PatientMyDoctorsDAO;
import com.ensis.mediguru.models.MyPhysiciansModel;
import com.ensis.mediguru.models.PhysicianFavoriteAndFamilyBean;
import com.ensis.mediguru.models.StartTreatmentPhysicianSearchRecordsModel;
import com.ensis.mediguru.models.StatusObject;
import com.ensis.mediguru.service.common.CommonService;
import com.ensis.mediguru.utils.MessageResources;
import com.ensis.mediguru.utils.Utilities;

/**
 * @author Venu
 *
 */
@Service
public class PatientMyDoctorsService extends MessageResources {

	@Autowired
	PatientMyDoctorsDAO patientMyDoctorsDAO;

	@Autowired
	CommonDAO commonDAO;
	
	@Autowired
	CommonService commonService;	
	

	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}

	public void setCommonDAO(CommonDAO commonDAO) {
		this.commonDAO = commonDAO;
	}

	public void setPatientMyDoctorsDAO(PatientMyDoctorsDAO patientMyDoctorsDAO) {
		this.patientMyDoctorsDAO = patientMyDoctorsDAO;
	}

	/**
	 * 
	 * @param physicianFavoriteAndFamilyBean
	 * @return
	 */
	@Transactional
	public StatusObject addPhysicianToFavoriteAndFamily(
			PhysicianFavoriteAndFamilyBean physicianFavoriteAndFamilyBean) {
		boolean status = patientMyDoctorsDAO
				.addPhysicianToFavoriteAndFamily(physicianFavoriteAndFamilyBean);

		StatusObject statusObject = new StatusObject();
		if (physicianFavoriteAndFamilyBean.getTypes().size() > 0) {

			if (physicianFavoriteAndFamilyBean.getTypes().size() == 1) {

				if (physicianFavoriteAndFamilyBean.getTypes().get(0) == 1) {

					if (status) {
						statusObject.setError(false);
						statusObject
								.setMessage(getMessage("add.physician.tofavorite.success"));
						return statusObject;
					} else {
						statusObject.setError(true);
						statusObject
								.setMessage(getMessage("add.physician.tofavorite.error"));
						return statusObject;
					}

				} else if (physicianFavoriteAndFamilyBean.getTypes().get(0) == 2) {

					if (status) {

						statusObject.setError(false);
						statusObject
								.setMessage(getMessage("add.physician.tofamily.success"));
						return statusObject;
					} else {

						statusObject.setError(true);
						statusObject
								.setMessage(getMessage("add.physician.tofamily.error"));
						return statusObject;
					}
				}

			} else if (physicianFavoriteAndFamilyBean.getTypes().size() == 2) {

				if (status) {

					statusObject.setError(false);
					statusObject
							.setMessage(getMessage("add.physician.tofavoriteandfamily.success"));
					return statusObject;
				} else {

					statusObject.setError(true);
					statusObject
							.setMessage(getMessage("add.physician.tofavoriteandfamily.error"));
					return statusObject;
				}
			}
		}
		statusObject.setError(true);
		statusObject
				.setMessage(getMessage("add.physician.tofavoriteandfamily.error"));
		return statusObject;

	}

	/**
	 * 
	 * @param physicianFavoriteAndFamilyBean
	 * @return
	 */
	@Transactional
	public StatusObject removePhysicianFromFavoriteAndFamily(
			PhysicianFavoriteAndFamilyBean physicianFavoriteAndFamilyBean) {
		boolean status = patientMyDoctorsDAO
				.removePhysicianFromFavoriteAndFamily(physicianFavoriteAndFamilyBean);
		StatusObject statusObject = new StatusObject();
		if (physicianFavoriteAndFamilyBean.getTypes().size() > 0) {

			if (physicianFavoriteAndFamilyBean.getTypes().size() == 1) {

				if (physicianFavoriteAndFamilyBean.getTypes().get(0) == 1) {

					if (status) {
						statusObject.setError(false);
						statusObject
								.setMessage(getMessage("remove.physician.tofavorite.success"));
						return statusObject;
					} else {
						statusObject.setError(true);
						statusObject
								.setMessage(getMessage("remove.physician.tofavorite.error"));
						return statusObject;
					}

				} else if (physicianFavoriteAndFamilyBean.getTypes().get(0) == 2) {

					if (status) {

						statusObject.setError(false);
						statusObject
								.setMessage(getMessage("remove.physician.tofamily.success"));
						return statusObject;
					} else {

						statusObject.setError(true);
						statusObject
								.setMessage(getMessage("remove.physician.tofamily.error"));
						return statusObject;
					}
				}

			} else if (physicianFavoriteAndFamilyBean.getTypes().size() == 2) {

				if (status) {

					statusObject.setError(false);
					statusObject
							.setMessage(getMessage("remove.physician.tofavoriteandfamily.success"));
					return statusObject;
				} else {

					statusObject.setError(true);
					statusObject
							.setMessage(getMessage("remove.physician.tofavoriteandfamily.error"));
					return statusObject;
				}
			}
		}
		statusObject.setError(true);
		statusObject
				.setMessage(getMessage("remove.physician.tofavoriteandfamily.error"));
		return statusObject;
	}

	/**
	 * 
	 * @param patientId
	 * @return
	 */
	@Transactional
	public ArrayList<MyPhysiciansModel> getPatientPhysicianList(
			int patientId) {

		ArrayList<MyPhysiciansModel> myPhysiciansArrayList=new ArrayList<MyPhysiciansModel>();
 		ArrayList<StartTreatmentPhysicianSearchRecordsModel> patientPhysiciansArrayList = patientMyDoctorsDAO
				.getPatientPhysiciansList(patientId);

		for (int j = 0; j < patientPhysiciansArrayList.size(); j++) {

			StartTreatmentPhysicianSearchRecordsModel Obj = 
					patientPhysiciansArrayList.get(j);

			MyPhysiciansModel myPhysiciansModel=new MyPhysiciansModel();
			
			myPhysiciansModel.setPhysicianid(Obj.getPhysicianid());
			myPhysiciansModel.setSpeciality(Obj.getSpeciality());
			myPhysiciansModel.setSpecialitytype(Obj.getSpecialitytype());
			myPhysiciansModel.setAbout(Obj.getAbout());
			myPhysiciansModel.setAddress1(Obj.getAddress1());
			myPhysiciansModel.setAddress2(Obj.getAddress2());
			myPhysiciansModel.setCity(Obj.getCity());
			myPhysiciansModel.setState(Obj.getState());
			myPhysiciansModel.setCountry(Obj.getCountry());
			myPhysiciansModel.setZip(Obj.getZip());
			myPhysiciansModel.setDob(Obj.getDob());
			myPhysiciansModel.setFirstname(Obj.getFirstname());
			myPhysiciansModel.setLastname(Obj.getLastname());
			if(Obj.getFirstvisitfee() != null){
				myPhysiciansModel.setFirstvisitfee(Obj.getFirstvisitfee());
			}
			if(Obj.getFollowupvisitfee() != null){
				myPhysiciansModel.setFollowupvisitfee(Obj.getFollowupvisitfee());
			}
			myPhysiciansModel.setInpersonAppointment(Obj.isIsInpersonAppointment());
			myPhysiciansModel.setVirtualPhoneAppointment(Obj.isIsVirtualPhoneAppointment());
			myPhysiciansModel.setVirtualSkypeAppointment(Obj.isIsVirtualSkypeAppointment());
			myPhysiciansModel.setMobile(Obj.getMobile());
			myPhysiciansModel.setOfficephone(Obj.getOfficephone());
			
			if(Obj.getRating() != null){
				
				myPhysiciansModel.setRating(Utilities.getTwoDigitDoubleValue(Obj.getRating()));
			}
			myPhysiciansModel.setSkypeid(Obj.getSkypeid());
			
			//Image URL
			if (Obj.getImageUrl() != null) {

				String imageName = getMessage("imageUrlPath") + Obj.getImageUrl();
				myPhysiciansModel.setImageUrl(imageName);
			}

			//Physician Type
			if (Obj.getPhysiciantypeid() != null) {

				if (Obj.getPhysiciantypeid().contains(",")) {

					String[] groupPhysicians = Obj.getPhysiciantypeid().split(",");
					for (int k = 0; k < groupPhysicians.length; k++) {

						int physicianTypeId = Integer.parseInt(groupPhysicians[k]);
						if (physicianTypeId == 1) {
							// Favorite
							myPhysiciansModel.setFavoritePhysician(true);
						} else if (physicianTypeId == 2) {
							// 2. Family
							myPhysiciansModel.setFamilyPhysician(true);
						} else if (physicianTypeId == 3) {
							// 3. Ongoing
							myPhysiciansModel.setOngoingPhysician(true);
						}
					}

				} else {

					int physicianTypeId = Integer.parseInt(Obj.getPhysiciantypeid());
					if (physicianTypeId == 1) {
						// Favorite
						myPhysiciansModel.setFavoritePhysician(true);
					} else if (physicianTypeId == 2) {
						// 2. Family
						myPhysiciansModel.setFamilyPhysician(true);
					} else if (physicianTypeId == 3) {
						// Ongoing
						myPhysiciansModel.setOngoingPhysician(true);
					}
				}
			}
			//add to list
			myPhysiciansArrayList.add(myPhysiciansModel);
		}
		return myPhysiciansArrayList;
	}
}
