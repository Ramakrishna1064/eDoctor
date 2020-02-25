/**
 * 
 */
package com.ensis.mediguru.service.patient;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensis.mediguru.dao.patient.PatientQuestionsDAO;
import com.ensis.mediguru.dao.patient.PatientStartTreatmentDAO;
import com.ensis.mediguru.models.GetPhysicianReviewComments;
import com.ensis.mediguru.models.PhysicianCommentsModel;
import com.ensis.mediguru.models.PhysicianSearchRecordsModel;
import com.ensis.mediguru.models.StartTreatmentPhysicianSearchRecordsModel;
import com.ensis.mediguru.utils.DistanceCalculator;
import com.ensis.mediguru.utils.LatitudeAndLongitudeWithPincode;
import com.ensis.mediguru.utils.MessageResources;
import com.ensis.mediguru.utils.Utilities;

/**
 * @author Venu
 *
 */
@Service
public class PatientStartTreatmentService extends MessageResources {

	@Autowired
	PatientStartTreatmentDAO patientStartTreatmentDAO;

	public void setPatientStartTreatmentDAO(
			PatientStartTreatmentDAO patientStartTreatmentDAO) {
		this.patientStartTreatmentDAO = patientStartTreatmentDAO;
	}

	@Autowired
	PatientQuestionsDAO patientQuestionsDAO;

	public void setPatientQuestionsDAO(PatientQuestionsDAO patientQuestionsDAO) {
		this.patientQuestionsDAO = patientQuestionsDAO;
	}

	/**
	 * 
	 * @param location
	 * @param specialityId
	 * @param patientid
	 * @return
	 * @throws Exception
	 */
	@Transactional
	public List<PhysicianSearchRecordsModel> getPhysiciansList(
			int specialityId, int patientid, int treatmentcost, String rating,
			String hours, String patientlatitude, String patientlongitude,
			String miles, String location) throws Exception {
		System.out.println(hours);
		System.out.println(location);
		if (location.endsWith("")) {
			location = "";
		}
		//patientlatitude="";patientlongitude="";
		String address1 = "", address2 = "", city = "", state = "", country = "";
		List<PhysicianSearchRecordsModel> searchResults = new ArrayList<PhysicianSearchRecordsModel>();
		List<?> list = patientStartTreatmentDAO
				.getPhysicianSearchRecords(specialityId, patientid,
						treatmentcost, rating, hours, location);
		    for (int i = 0; i < list.size(); i++) {

			StartTreatmentPhysicianSearchRecordsModel Obj = (StartTreatmentPhysicianSearchRecordsModel) list
					.get(i);

			if (Obj.getAddress1() != null && Obj.getAddress1() != "") {
				address1 = Obj.getAddress1();
			}
			if (Obj.getAddress2() != null && Obj.getAddress2() != "") {
				address2 = Obj.getAddress2();
			}
			if (Obj.getCity() != null && Obj.getCity() != "") {
				city = Obj.getCity();
			}
			if (Obj.getState() != null && Obj.getState() != "") {
				state = Obj.getState();
			}
			if (Obj.getCountry() != null && Obj.getCountry() != "") {
				country = Obj.getCountry();
			}

			if (patientlatitude.equals("") )
			{
			
				PhysicianSearchRecordsModel searchResultsModel = new PhysicianSearchRecordsModel();

				searchResultsModel.setPhysicianid(Obj.getPhysicianid());
				searchResultsModel.setSpeciality(Obj.getSpeciality());
				searchResultsModel.setSpecialitytype(Obj.getSpecialitytype());
				searchResultsModel.setAbout(Obj.getAbout());
				searchResultsModel.setAddress1(Obj.getAddress1());
				searchResultsModel.setAddress2(Obj.getAddress2());
				searchResultsModel.setCity(Obj.getCity());
				searchResultsModel.setState(Obj.getState());
				searchResultsModel.setCountry(Obj.getCountry());
				searchResultsModel.setZip(Obj.getZip());
				searchResultsModel.setDob(Obj.getDob());
				searchResultsModel.setFirstname(Obj.getFirstname());
				searchResultsModel.setLastname(Obj.getLastname());
				if (Obj.getFirstvisitfee() != null) {
					searchResultsModel.setFirstvisitfee(Obj.getFirstvisitfee());
				}
				if (Obj.getFollowupvisitfee() != null) {
					searchResultsModel.setFollowupvisitfee(Obj
							.getFollowupvisitfee());
				}
				searchResultsModel.setIsInpersonAppointment(Obj
						.isIsInpersonAppointment());
				searchResultsModel.setIsVirtualPhoneAppointment(Obj
						.isIsVirtualPhoneAppointment());
				searchResultsModel.setIsVirtualSkypeAppointment(Obj
						.isIsVirtualSkypeAppointment());
				searchResultsModel.setMobile(Obj.getMobile());
				searchResultsModel.setOfficephone(Obj.getOfficephone());
				if (Obj.getRating() != null) {

					searchResultsModel.setRating(Utilities
							.getTwoDigitDoubleValue(Obj.getRating()));
				}
				searchResultsModel.setSkypeid(Obj.getSkypeid());

				// Image URL
				if (Obj.getImageUrl() != null) {

					String imageName = getMessage("imageUrlPath")
							+ Obj.getImageUrl();
					searchResultsModel.setImageUrl(imageName);
				}

				// Physician Type
				if (Obj.getPhysiciantypeid() != null) {

					if (Obj.getPhysiciantypeid().contains(",")) {

						String[] groupPhysicians = Obj.getPhysiciantypeid().split(
								",");
						for (int k = 0; k < groupPhysicians.length; k++) {

							int physicianTypeId = Integer
									.parseInt(groupPhysicians[k]);
							if (physicianTypeId == 1) {
								// Favorite
								searchResultsModel.setFavoritePhysician(true);
							} else if (physicianTypeId == 2) {
								// 2. Family
								searchResultsModel.setFamilyPhysician(true);
							} else if (physicianTypeId == 3) {
								// 3. Ongoing
								searchResultsModel.setOngoingPhysician(true);
							}
						}

					} else {

						int physicianTypeId = Integer.parseInt(Obj
								.getPhysiciantypeid());
						if (physicianTypeId == 1) {
							// Favorite
							searchResultsModel.setFavoritePhysician(true);
						} else if (physicianTypeId == 2) {
							// 2. Family
							searchResultsModel.setFamilyPhysician(true);
						} else if (physicianTypeId == 3) {
							// Ongoing
							searchResultsModel.setOngoingPhysician(true);
						}
					}
				}

				// add the comments
				searchResultsModel.setReviews(getPhysicianCommentsList(Obj
						.getPhysicianid()));
				// add the Model to array list
				searchResults.add(searchResultsModel);
			
			}
			else
			{

				System.out.println("patientlatitude--" + patientlatitude
						+ "patientlongitude---" + patientlongitude);
				String physicianAddres = address1 + "," + address2 + "," + city
						+ "," + state + "," + country;

				String latLongs[] = LatitudeAndLongitudeWithPincode
						.getLatLongPositions(physicianAddres);

				Double distanceInMiles = DistanceCalculator.distance(
						Double.parseDouble(latLongs[0]),
						Double.parseDouble(latLongs[1]),
						Double.parseDouble(patientlatitude),
						Double.parseDouble(patientlongitude), "M");

				System.out.println("distance----" + distanceInMiles);
				int val = Double.compare(distanceInMiles,
						Double.parseDouble(miles));
				System.out.println("retval====" + val);
				
			

			 if (distanceInMiles <= Double.parseDouble(miles)) {
			PhysicianSearchRecordsModel searchResultsModel = new PhysicianSearchRecordsModel();

			searchResultsModel.setPhysicianid(Obj.getPhysicianid());
			searchResultsModel.setSpeciality(Obj.getSpeciality());
			searchResultsModel.setSpecialitytype(Obj.getSpecialitytype());
			searchResultsModel.setAbout(Obj.getAbout());
			searchResultsModel.setAddress1(Obj.getAddress1());
			searchResultsModel.setAddress2(Obj.getAddress2());
			searchResultsModel.setCity(Obj.getCity());
			searchResultsModel.setState(Obj.getState());
			searchResultsModel.setCountry(Obj.getCountry());
			searchResultsModel.setZip(Obj.getZip());
			searchResultsModel.setDob(Obj.getDob());
			searchResultsModel.setFirstname(Obj.getFirstname());
			searchResultsModel.setLastname(Obj.getLastname());
			if (Obj.getFirstvisitfee() != null) {
				searchResultsModel.setFirstvisitfee(Obj.getFirstvisitfee());
			}
			if (Obj.getFollowupvisitfee() != null) {
				searchResultsModel.setFollowupvisitfee(Obj
						.getFollowupvisitfee());
			}
			searchResultsModel.setIsInpersonAppointment(Obj
					.isIsInpersonAppointment());
			searchResultsModel.setIsVirtualPhoneAppointment(Obj
					.isIsVirtualPhoneAppointment());
			searchResultsModel.setIsVirtualSkypeAppointment(Obj
					.isIsVirtualSkypeAppointment());
			searchResultsModel.setMobile(Obj.getMobile());
			searchResultsModel.setOfficephone(Obj.getOfficephone());
			if (Obj.getRating() != null) {

				searchResultsModel.setRating(Utilities
						.getTwoDigitDoubleValue(Obj.getRating()));
			}
			searchResultsModel.setSkypeid(Obj.getSkypeid());

			// Image URL
			if (Obj.getImageUrl() != null) {

				String imageName = getMessage("imageUrlPath")
						+ Obj.getImageUrl();
				searchResultsModel.setImageUrl(imageName);
			}

			// Physician Type
			if (Obj.getPhysiciantypeid() != null) {

				if (Obj.getPhysiciantypeid().contains(",")) {

					String[] groupPhysicians = Obj.getPhysiciantypeid().split(
							",");
					for (int k = 0; k < groupPhysicians.length; k++) {

						int physicianTypeId = Integer
								.parseInt(groupPhysicians[k]);
						if (physicianTypeId == 1) {
							// Favorite
							searchResultsModel.setFavoritePhysician(true);
						} else if (physicianTypeId == 2) {
							// 2. Family
							searchResultsModel.setFamilyPhysician(true);
						} else if (physicianTypeId == 3) {
							// 3. Ongoing
							searchResultsModel.setOngoingPhysician(true);
						}
					}

				} else {

					int physicianTypeId = Integer.parseInt(Obj
							.getPhysiciantypeid());
					if (physicianTypeId == 1) {
						// Favorite
						searchResultsModel.setFavoritePhysician(true);
					} else if (physicianTypeId == 2) {
						// 2. Family
						searchResultsModel.setFamilyPhysician(true);
					} else if (physicianTypeId == 3) {
						// Ongoing
						searchResultsModel.setOngoingPhysician(true);
					}
				}
			}

			// add the comments
			searchResultsModel.setReviews(getPhysicianCommentsList(Obj
					.getPhysicianid()));
			// add the Model to array list
			searchResults.add(searchResultsModel);
			 }// if condition
			
				
			}
		}
		return searchResults;
	}

	/**
	 * 
	 * @param physicianId
	 * @return
	 */
	public ArrayList<PhysicianCommentsModel> getPhysicianCommentsList(
			int physicianId) {

		// get the Physician Reviews
		ArrayList<GetPhysicianReviewComments> commentsList = patientQuestionsDAO
				.getPhysicianReviewComments(physicianId);

		ArrayList<PhysicianCommentsModel> reviewsList = new ArrayList<PhysicianCommentsModel>();

		if (commentsList != null) {

			for (GetPhysicianReviewComments commentsObj : commentsList) {

				PhysicianCommentsModel physicianCommentsModel = new PhysicianCommentsModel();
				if (commentsObj.getRating() != null) {
					physicianCommentsModel.setRating(commentsObj.getRating());
				}
				physicianCommentsModel.setComment(commentsObj.getComment());
				physicianCommentsModel.setTitle(commentsObj.getTitle());
				physicianCommentsModel.setPatientName(commentsObj
						.getFirstname() + " " + commentsObj.getLastname());

				reviewsList.add(physicianCommentsModel);
			}
		}
		return reviewsList;
	}
}
