/**
 * 
 */
package com.ensis.mediguru.service.physician;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ensis.mediguru.dao.physician.PhysicianProfileDAO;
import com.ensis.mediguru.dto.DoctorRegistration;
import com.ensis.mediguru.dto.PhysicianAvailability;
import com.ensis.mediguru.dto.PhysicianFacility;
import com.ensis.mediguru.dto.PhysicianFacilityPlacesDTO;
import com.ensis.mediguru.dto.PhysicianFacilityService;
import com.ensis.mediguru.dto.PhysicianLanguage;
import com.ensis.mediguru.dto.PhysicianProfessionaInfo;
import com.ensis.mediguru.models.AvailabilityTimeModel;
import com.ensis.mediguru.models.AvailabilityTimingsModel;
import com.ensis.mediguru.models.PhysicianClinicInfoModel;
import com.ensis.mediguru.models.PhysicianCreateProfileModel;
import com.ensis.mediguru.models.PhysicianFacilityPracticeLocationsModel;
import com.ensis.mediguru.models.PhysicianProfileClinicGetModel;
import com.ensis.mediguru.models.PhysicianProfileModel;
import com.ensis.mediguru.models.PhysicianProfilePersonalInfoModel;
import com.ensis.mediguru.models.PhysicianProfileSpecQualificationGetModel;
import com.ensis.mediguru.models.PhysicianProfileUpdateClinicInfoModel;
import com.ensis.mediguru.models.PhysicianProfileUpdatePersonalInfo;
import com.ensis.mediguru.models.PhysicianProfileUpdateProfessionalInfoModel;
import com.ensis.mediguru.models.PhysicianSpecialityAndQualificationsModel;
import com.ensis.mediguru.models.StatusObject;
import com.ensis.mediguru.service.common.CommonService;
import com.ensis.mediguru.utils.MessageResources;

/**
 * @author Venu
 *
 */
@Service
public class PhysicianProfileService extends MessageResources {

	@Autowired
	PhysicianProfileDAO physicianProfileDAO;

	@Autowired
	CommonService commonService;

	public void setPhysicianProfileDAO(PhysicianProfileDAO physicianProfileDAO) {
		this.physicianProfileDAO = physicianProfileDAO;
	}

	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}

	@Transactional
	public StatusObject createProfile(PhysicianCreateProfileModel profileObj) {

		if (physicianProfileDAO.createPhysicianProfile(profileObj)) {
			StatusObject statusObject = new StatusObject();
			statusObject.setError(false);
			statusObject
					.setMessage(getMessage("physician.profile.success.message"));
			return statusObject;
		} else {
			StatusObject statusObject = new StatusObject();
			statusObject.setError(true);
			statusObject
					.setMessage(getMessage("physician.profile.error.message"));
			return statusObject;
		}
	}

	@Transactional
	public PhysicianProfileModel getPhysicianProfile(int physicianid) {

		PhysicianProfileModel physicianProfileModel = new PhysicianProfileModel();
		// Personal Info
		PhysicianProfilePersonalInfoModel professionalInfoModel = physicianProfileDAO
				.getPhysicianProfilePersonalInfo(physicianid);

		if (professionalInfoModel != null) {

			if (professionalInfoModel.getImageUrl() != null) {

				professionalInfoModel.setImageUrl(getMessage("imageUrlPath")
						+ professionalInfoModel.getImageUrl());
			}
		}

		physicianProfileModel
				.setPhysicianProfilePersonalInfo(professionalInfoModel);
		// Languages
		physicianProfileModel.setLanguages(physicianProfileDAO
				.getPhysicianLanguages(physicianid));
		// Specialities and Qualifications
		
		List<PhysicianProfileSpecQualificationGetModel> specialitiesQualificationsList=
				physicianProfileDAO.getPhysicianSpecialitiesQualifications(physicianid);
		
		ArrayList<PhysicianSpecialityAndQualificationsModel> allSpecQualList=
				new ArrayList<PhysicianSpecialityAndQualificationsModel>();
		for(PhysicianProfileSpecQualificationGetModel ispecModelObj: specialitiesQualificationsList){
			
			PhysicianSpecialityAndQualificationsModel smodelObj=new 
					PhysicianSpecialityAndQualificationsModel();
			smodelObj.setQualificationname(ispecModelObj.getQualificationname());
			smodelObj.setQualtypeid(ispecModelObj.getQualtypeid());
			smodelObj.setSpecialityname(ispecModelObj.getSpecialityname());
			smodelObj.setSpecialitytypeid(ispecModelObj.getSpecialitytypeid());
			smodelObj.setYearqualified(ispecModelObj.getYearqualified());
			ArrayList<String> imageUrls=new ArrayList<String>();
			
			if (ispecModelObj.getImagename() != null) {

				if(ispecModelObj.getImagename().contains(":")){
				
					String[] images = ispecModelObj.getImagename().split(":");
					for (int z = 0; z < images.length; z++) {

						imageUrls.add(getMessage("imageUrlPath") + images[z]);
					}
					
				}else{
					
					imageUrls.add(getMessage("imageUrlPath") + ispecModelObj.getImagename());
				}
			}
			smodelObj.setImageUrls(imageUrls);
			allSpecQualList.add(smodelObj);
			
		}
		
		physicianProfileModel.setSpecialitiesAndQualifications(allSpecQualList);
		
		PhysicianProfileClinicGetModel clinicInfoAVailModel=physicianProfileDAO
				.getPhysicianCliniInfo(physicianid);
		
		PhysicianFacilityPracticeLocationsModel physicianClinicInfo=
				new PhysicianFacilityPracticeLocationsModel();
		
		if(clinicInfoAVailModel != null){
			
			physicianClinicInfo.setFacilityname(clinicInfoAVailModel.getFacilityname());
			physicianClinicInfo.setAddress1(clinicInfoAVailModel.getAddress1());
			physicianClinicInfo.setAddress2(clinicInfoAVailModel.getAddress2());
			physicianClinicInfo.setCity(clinicInfoAVailModel.getCity());
			physicianClinicInfo.setState(clinicInfoAVailModel.getState());
			physicianClinicInfo.setCountry(clinicInfoAVailModel.getCountry());
			physicianClinicInfo.setZip(clinicInfoAVailModel.getZip());
			physicianClinicInfo.setMobile1(clinicInfoAVailModel.getMobile1());
			physicianClinicInfo.setMobile2(clinicInfoAVailModel.getMobile2());
			
			physicianClinicInfo.setIsacceptecompliance(clinicInfoAVailModel.isIsacceptecompliance());
			physicianClinicInfo.setIsacceptleagul(clinicInfoAVailModel.isIsacceptleagul());
			
			ArrayList<String> clinicImageUrls=new ArrayList<String>();
			if (clinicInfoAVailModel.getImagename() != null) {

				if(clinicInfoAVailModel.getImagename().contains(":")){
				
					String[] images = clinicInfoAVailModel.getImagename().split(":");
					for (int z = 0; z < images.length; z++) {

						clinicImageUrls.add(getMessage("imageUrlPath") + images[z]);
					}
					
				}else{
					
					clinicImageUrls.add(getMessage("imageUrlPath") + clinicInfoAVailModel.getImagename());
				}
			}
			physicianClinicInfo.setImageUrls(clinicImageUrls);
			
			List<String> serviceNamesList=new ArrayList<String>();
			if (clinicInfoAVailModel.getServicename() != null) {

				if(clinicInfoAVailModel.getServicename().contains(",")){
				
					String[] images = clinicInfoAVailModel.getServicename().split(",");
					for (int z = 0; z < images.length; z++) {

						serviceNamesList.add(images[z]);
					}
					
				}else{
					
					serviceNamesList.add(clinicInfoAVailModel.getServicename());
				}
			}
			physicianClinicInfo.setServiceNamesList(serviceNamesList);
			
			ArrayList<String> practiceLocationsList=new ArrayList<String>();
			if (clinicInfoAVailModel.getLocationname() != null) {

				if(clinicInfoAVailModel.getLocationname().contains(",")){
				
					String[] images = clinicInfoAVailModel.getLocationname().split(",");
					for (int z = 0; z < images.length; z++) {

						practiceLocationsList.add(images[z]);
					}
					
				}else{
					
					practiceLocationsList.add(clinicInfoAVailModel.getLocationname());
				}
			}
			physicianClinicInfo.setLocationNamesList(practiceLocationsList);
			 
		}
		
		// clinic info
		physicianProfileModel.setClinicInfo(physicianClinicInfo);
		// Avaialability timings
		// physicianProfileModel.setAvailabilityTimings(physicianProfileDAO.getPhysicianAvailabilityTimings(physicianid));

		List<PhysicianAvailability> availabilityTimings = physicianProfileDAO
				.getPhysicianAvailabilityTimings(physicianid);

		ArrayList<AvailabilityTimingsModel> masterDaysList = new ArrayList<AvailabilityTimingsModel>();

		for (int i = 0; i < availabilityTimings.size(); i++) {

			AvailabilityTimingsModel availabilityTimingsModel = new AvailabilityTimingsModel();
			availabilityTimingsModel.setFromDay(availabilityTimings.get(i)
					.getFromday());
			availabilityTimingsModel.setToDay(availabilityTimings.get(i)
					.getToday());

			ArrayList<AvailabilityTimeModel> userTimesList = new ArrayList<AvailabilityTimeModel>();

			AvailabilityTimeModel timingObj = new AvailabilityTimeModel();
			timingObj.setFromTime(availabilityTimings.get(i).getFromtime());
			timingObj.setToTime(availabilityTimings.get(i).getTotime());

			// boolean isTimeNeedtoSet=false;

			if (masterDaysList.size() > 0) {

				boolean isDaysAdded = true;
				boolean isTimesAdded = true;
				for (int j = 0; j < masterDaysList.size(); j++) {

					if (masterDaysList.get(j).getFromDay()
							.equals(availabilityTimingsModel.getFromDay())
							&& masterDaysList
									.get(j)
									.getToDay()
									.equals(availabilityTimingsModel.getToDay())) {

						isDaysAdded = false;
						// Timings
						if (masterDaysList.get(j).getTimings() != null
								&& masterDaysList.get(j).getTimings().size() > 0) {

							ArrayList<AvailabilityTimeModel> masterTimesList = masterDaysList
									.get(j).getTimings();

							for (int k = 0; k < masterTimesList.size(); k++) {

								if (masterTimesList.get(k).getFromTime()
										.equals(timingObj.getFromTime())
										&& masterTimesList.get(k).getToTime()
												.equals(timingObj.getToTime())) {
									isTimesAdded = false;
								}
							}
						}

					}

					if (isTimesAdded) {

						if (!isDaysAdded) {

							AvailabilityTimingsModel newObj = masterDaysList
									.get(j);
							ArrayList<AvailabilityTimeModel> newTimiesList = newObj
									.getTimings();
							userTimesList.add(timingObj);
							newTimiesList.addAll(userTimesList);
							newObj.setTimings(newTimiesList);
							masterDaysList.set(j, newObj);

						}

					}
				}

				if (isTimesAdded) {

					// isTimeNeedtoSet = true;
					userTimesList.add(timingObj);
					availabilityTimingsModel.setTimings(userTimesList);

				}

				if (isDaysAdded) {

					masterDaysList.add(availabilityTimingsModel);
				}

			} else {

				userTimesList.add(timingObj);
				availabilityTimingsModel.setTimings(userTimesList);
				masterDaysList.add(availabilityTimingsModel);
			}

		}
		physicianProfileModel.setAvailabilityTimings(masterDaysList);
		return physicianProfileModel;
	}

	@Transactional
	public StatusObject uploadProfileProfessionalImages(
			MultipartHttpServletRequest request, int physicianid) {

		boolean status = false;
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Iterator<String> iterator = multipartRequest.getFileNames();
		while (iterator.hasNext()) {

			String key = (String) iterator.next();
			List<MultipartFile> files = request.getFiles(key);

			if (key.equalsIgnoreCase("clinicgalary")) {

				for (MultipartFile uploadClinicImages : files) {

					// System.out.println("------>" + files.size());
					String fileUUIDName = commonService
							.saveImgaeFileIntoDisk(uploadClinicImages);
					if (fileUUIDName != null) {

						status = physicianProfileDAO
								.uploadPhysicianClinicGallery(fileUUIDName,
										uploadClinicImages
												.getOriginalFilename(),
										physicianid);

					}
				}
			} else {

				for (MultipartFile uploadClinicImages : files) {

					// System.out.println("------>" + files.size());
					String fileUUIDName = commonService
							.saveImgaeFileIntoDisk(uploadClinicImages);
					if (fileUUIDName != null) {

						status = physicianProfileDAO
								.uploadPhysicianProfessionImages(fileUUIDName,
										uploadClinicImages
												.getOriginalFilename(),
										physicianid, Integer.parseInt(key));
					}
				}
			}
		}
		StatusObject statusObject = new StatusObject();
		if (status) {
			statusObject.setError(false);
			statusObject
					.setMessage(getMessage("Profile.upload.success.message"));
		} else {
			statusObject.setError(true);
			statusObject
					.setMessage(getMessage("profile.upload.failure.message"));
		}
		return statusObject;
	}

	/**
	 * 
	 * @param personalInfoModel
	 * @return
	 */
	@Transactional
	public StatusObject updateProfilePersonalInfo(
			PhysicianProfileUpdatePersonalInfo personalInfoModel) {

		boolean status=false;
		StatusObject statusObject = new StatusObject();
		if (personalInfoModel != null) {

			DoctorRegistration doctorRegistration = physicianProfileDAO
					.getPhysicianModel(personalInfoModel.getPhysicianid());

			if (doctorRegistration != null) {

				// First Name
				if (personalInfoModel.getFirstname() != null) {
					doctorRegistration.setFirstname(personalInfoModel
							.getFirstname());
				}

				// Last Name
				if (personalInfoModel.getLastname() != null) {
					doctorRegistration.setLastname(personalInfoModel
							.getLastname());
				}

				// DOB
				if (personalInfoModel.getDob() != null) {
					doctorRegistration.setDob(personalInfoModel
							.getDob());
				}

				// Mobile
				if (personalInfoModel.getMobile() != null) {
					doctorRegistration.setMobile(personalInfoModel
							.getMobile());
				}
				
				//Office Phone
				if (personalInfoModel.getOfficephone() != null) {
					doctorRegistration.setOfficephone(personalInfoModel
							.getOfficephone());
				}

				//Skype id
				if (personalInfoModel.getSkypeid() != null) {
					doctorRegistration.setSkypeid(personalInfoModel
							.getSkypeid());
				}

				//Address1
				if (personalInfoModel.getAddress1() != null) {
					doctorRegistration.setAddress1(personalInfoModel
							.getAddress1());
				}
				//Address2
				if (personalInfoModel.getAddress2() != null) {
					doctorRegistration.setAddress2(personalInfoModel
							.getAddress2());
				}
				
				//City
				if (personalInfoModel.getCity() != null) {
					doctorRegistration.setCity(personalInfoModel
							.getCity());
				}
				
				//State
				if (personalInfoModel.getStateid() != null) {
					doctorRegistration.setStateid(personalInfoModel
							.getStateid());
				}
				
				//Country
				if (personalInfoModel.getCid() != null) {
					doctorRegistration.setCid(personalInfoModel
							.getCid());
				}
				
				//Zip
				if (personalInfoModel.getZip() != null) {
					doctorRegistration.setZip(personalInfoModel
							.getZip());
				}
				
				//About
				if (personalInfoModel.getAbout() != null) {
					doctorRegistration.setAbout(personalInfoModel
							.getAbout());
				}
				
				doctorRegistration.setImgid(personalInfoModel.getImgid());
				
				doctorRegistration.setUpdatedby(doctorRegistration.getFirstname());
				doctorRegistration.setUpdateddate(new Date());
				
				status=physicianProfileDAO.updatePhysicianModel(doctorRegistration);
				
				ArrayList<PhysicianLanguage> physicianLanguages= physicianProfileDAO.
						getPhysicianAvailLanguages(personalInfoModel.getPhysicianid());
				
				ArrayList<Integer> newLanguages=new ArrayList<Integer>();
				ArrayList<PhysicianLanguage> deletedLanguages=new ArrayList<PhysicianLanguage>();
				
				for(int i=0;i<physicianLanguages.size();i++){
					
					PhysicianLanguage availLangModel=physicianLanguages.get(i);
					boolean isSameLangId=false;
					for (int j = 0; j < personalInfoModel.getLanguageTypes().size(); j++) {
						
						Integer langId=personalInfoModel.getLanguageTypes().get(j);						
						if(langId  == availLangModel.getLangtypeid()){
							isSameLangId=true;
						}
					}
					
					if(!isSameLangId){
						deletedLanguages.add(availLangModel);
					}
				}
				
				//delete existing languages
				for(int k=0;k<deletedLanguages.size();k++){
					
					PhysicianLanguage deletedModel=deletedLanguages.get(k);
					physicianProfileDAO.deletePhysicianLanguage(deletedModel);
					
				}
				
				for(int i=0;i<personalInfoModel.getLanguageTypes().size();i++){
				
					Integer langId=personalInfoModel.getLanguageTypes().get(i);
					boolean isSameLangId=false;
					for(int j=0;j<physicianLanguages.size();j++){
						
						if(langId  == physicianLanguages.get(j).getLangtypeid()){
							isSameLangId=true;
						}
					}
					if(!isSameLangId){
						newLanguages.add(langId);
					}
				}
				
				for(int l=0;l<newLanguages.size();l++){
					
					physicianProfileDAO.createOrUpdateLangugaes(
							personalInfoModel.getPhysicianid(),
							newLanguages.get(l));
				}
				
			}
		}
		if(status){
			statusObject.setError(false);
			statusObject.setMessage(getMessage("profile.personal.info.update.success"));
		}else{
			statusObject.setError(true);
			statusObject.setMessage(getMessage("profile.personal.info.update.failure"));
		}
		return statusObject;
	}

	/**
	 * 
	 * @param professionalInfoModel
	 * @return
	 */
	@Transactional
	public StatusObject updateProfileProfessionalInfo(
			PhysicianProfileUpdateProfessionalInfoModel professionalInfoModel) {

		StatusObject statusObject = new StatusObject();
		if (professionalInfoModel != null) {

			ArrayList<PhysicianSpecialityAndQualificationsModel> specialityAndQualifications = professionalInfoModel
					.getSpecialityAndQualifications();
			//Specialties and Qualifications
			for(int i=0;i<specialityAndQualifications.size();i++){
				
				physicianProfileDAO.createOrUpdatePhysicianSpecialityAndQualifications(professionalInfoModel.getPhysicianid(),
						specialityAndQualifications.get(i));
			}
			
			PhysicianProfessionaInfo physicianProfessionaInfo=physicianProfileDAO.
					getPhysicianProfessionAvailInfo(professionalInfoModel.getPhysicianid());
			
			PhysicianCreateProfileModel physicianCreateProfileModel=new PhysicianCreateProfileModel();
			physicianCreateProfileModel.setPhysicianid(professionalInfoModel.getPhysicianid());
			
			if(physicianProfessionaInfo != null){
				
				//Professional Info

				//Start Date
				if(professionalInfoModel.getPracticestartdate() != null){
					physicianCreateProfileModel.setPracticestartdate(professionalInfoModel.getPracticestartdate());
				}else{
					physicianCreateProfileModel.setPracticestartdate(physicianProfessionaInfo.getPracticestartdate());
				}
				
				//First Visit Fee
				if(professionalInfoModel.getFirstvisitfee() != 0){
					physicianCreateProfileModel.setFirstvisitfee(professionalInfoModel.getFirstvisitfee());
				}else{
					physicianCreateProfileModel.setFirstvisitfee(physicianProfessionaInfo.getFirstvisitfee());
				}
				
				//Follow up Visit Fee
				if(professionalInfoModel.getFollowupvisitfee() != 0){
					physicianCreateProfileModel.setFollowupvisitfee(professionalInfoModel.getFollowupvisitfee());
				}else{
					physicianCreateProfileModel.setFollowupvisitfee(physicianProfessionaInfo.getFollowupvisitfee());
				}				
				
			}else{
			
				//Professional Info
				physicianCreateProfileModel.setPracticestartdate(professionalInfoModel.getPracticestartdate());
				physicianCreateProfileModel.setFirstvisitfee(professionalInfoModel.getFirstvisitfee());
				physicianCreateProfileModel.setFollowupvisitfee(professionalInfoModel.getFollowupvisitfee());
				
			}			
			physicianCreateProfileModel.setPersonAppointment(professionalInfoModel.isPersonAppointment());
			physicianCreateProfileModel.setVirtualPhoneAppointment(professionalInfoModel.isVirtualPhoneAppointment());
			physicianCreateProfileModel.setVirtualSkypeAppointment(professionalInfoModel.isVirtualSkypeAppointment());
			physicianProfileDAO.createPhysicianProfessionInfo(physicianCreateProfileModel);
			
			// Availability timings
			for (int k = 0; k < professionalInfoModel.getAvailabilityTimings().size(); k++) {

				for (int l = 0; l < professionalInfoModel.getAvailabilityTimings().get(k)
						.getTimings().size(); l++) {

					physicianProfileDAO.createPhysicianAvailabilityTimings(
							professionalInfoModel.getPhysicianid(), professionalInfoModel
									.getAvailabilityTimings().get(k),
									professionalInfoModel.getAvailabilityTimings().get(k)
									.getTimings().get(l));
				}
			}	
			statusObject.setError(false);
			statusObject.setMessage(getMessage("profile.professional.info.update.success"));
			return statusObject;
		}else{
			statusObject.setError(true);
			statusObject.setMessage(getMessage("profile.professional.info.update.failure"));
			return statusObject;
		}
		
	}

	/**
	 * 
	 * @param clinicInfoModel
	 * @return
	 */
	@Transactional
	public StatusObject updateProfileClinicInfo(
			PhysicianProfileUpdateClinicInfoModel clinicInfoModel) {

		StatusObject statusObject = new StatusObject();
		
		if(clinicInfoModel != null){
		
			// physician facility
			int physicianfacilityid=0;
			
			physicianfacilityid = physicianProfileDAO.
					checkPhysicianFacilityExists(clinicInfoModel.getPhysicianid());
			
			PhysicianClinicInfoModel clinicInfo=new PhysicianClinicInfoModel();
			
			if(physicianfacilityid > 0){
				
				PhysicianFacility physicianFacility=physicianProfileDAO.
						getPhysicianFacilityAvail(physicianfacilityid);
				System.out.println("---->"+physicianFacility.isAcceptecompliance());
				clinicInfo.setAcceptecompliance(physicianFacility.isAcceptecompliance());
				clinicInfo.setAcceptleagul(physicianFacility.isAcceptleagul());	
			}

			clinicInfo.setAddress1(clinicInfoModel.getAddress1());
			clinicInfo.setAddress2(clinicInfoModel.getAddress2());
			clinicInfo.setClinicName(clinicInfoModel.getClinicName());
			clinicInfo.setCity(clinicInfoModel.getCity());
			clinicInfo.setStateid(clinicInfoModel.getStateid());
			clinicInfo.setCid(clinicInfoModel.getCid());
			clinicInfo.setZip(clinicInfoModel.getZip());
			clinicInfo.setMobile1(clinicInfoModel.getMobile1());
			clinicInfo.setMobile2(clinicInfoModel.getMobile2());
			
			physicianfacilityid=physicianProfileDAO.createOrUpdatePhysicianFacility(
					clinicInfoModel.getPhysicianid(),clinicInfo);
			
			if (physicianfacilityid > 0) {

				
				ArrayList<PhysicianFacilityService> availFacilityServices=
						physicianProfileDAO.getPhysicianFacilityServices(physicianfacilityid);
				
				ArrayList<PhysicianFacilityService> deletedFacilities=new ArrayList<PhysicianFacilityService>();
				
				for(int i=0;i<availFacilityServices.size();i++){
					
					PhysicianFacilityService modelObj=availFacilityServices.get(i);
					boolean isSameServiceName=false;
					for (int j = 0; j < clinicInfoModel.getServices().size(); j++) {
						
						String facilityServiceName =clinicInfoModel.getServices().get(j);						
						if(facilityServiceName  == modelObj.getServicename()){
							isSameServiceName=true;
						}
					}
					
					if(!isSameServiceName){
						deletedFacilities.add(modelObj);
					}
				}
				
				//Delete updated services
				for(int m=0;m<deletedFacilities.size();m++){
					
					physicianProfileDAO.deletePhysicianFacilityService(deletedFacilities.get(m));
				}
				
				ArrayList<String> newlyAddedServies=new ArrayList<String>();
				for(int i=0;i<clinicInfoModel.getServices().size();i++){
					
					String  faclServiceName=clinicInfoModel.getServices().get(i);
					boolean isSameService=false;
					for(int j=0;j<availFacilityServices.size();j++){
						
						if(faclServiceName  == availFacilityServices.get(j).getServicename()){
							isSameService=true;
						}
					}
					if(!isSameService){
						newlyAddedServies.add(faclServiceName);
					}
				}
				
				
				// Facility Service Name
				for (int m = 0; m < newlyAddedServies.size(); m++) {

					physicianProfileDAO.createOrUpdatePhysicianFacilityService(
							physicianfacilityid,
							newlyAddedServies.get(m));
				}
				
				
				ArrayList<PhysicianFacilityPlacesDTO>  availLocationsList=physicianProfileDAO.
						getPhysicianPracticePlacesAvail(physicianfacilityid);
				ArrayList<PhysicianFacilityPlacesDTO> deletedLocations=new ArrayList<PhysicianFacilityPlacesDTO>();
				
				for(int i=0;i<availLocationsList.size();i++){
					
					PhysicianFacilityPlacesDTO modelObj=availLocationsList.get(i);
					boolean isSameLocation=false;
					for (int j = 0; j < clinicInfoModel.getPracticeLocations().size(); j++) {
						
						String facilityServiceName =clinicInfoModel.getPracticeLocations().get(j);						
						if(facilityServiceName  == modelObj.getLocationname()){
							isSameLocation=true;
						}
					}
					
					if(!isSameLocation){
						deletedLocations.add(modelObj);
					}
				}
				
				//delete user deleted locations
				for(int y=0;y<deletedLocations.size();y++){
					
					physicianProfileDAO.deletePhysicianFacilityPlacesAvail(deletedLocations.get(y));
				}
				
				ArrayList<String> newlyAddedLocations=new ArrayList<String>();
				for(int i=0;i<clinicInfoModel.getPracticeLocations().size();i++){
					
					String  locationName=clinicInfoModel.getPracticeLocations().get(i);
					boolean isSmaeLocation=false;
					for(int j=0;j<availLocationsList.size();j++){
						
						if(locationName  == availLocationsList.get(j).getLocationname()){
							isSmaeLocation=true;
						}
					}
					if(!isSmaeLocation){
						newlyAddedLocations.add(locationName);
					}
				}

				// Facility Locations
				for (int n = 0; n < newlyAddedLocations.size(); n++) {

					physicianProfileDAO
							.createOrUpdatePhysicianFacilityServicePlaces(
									physicianfacilityid, newlyAddedLocations.get(n));
				}
			}
			statusObject.setError(false);
			statusObject.setMessage(getMessage("profile.clinic.info.update.success"));
			return statusObject;
		}else{
			statusObject.setError(true);
			statusObject.setMessage(getMessage("profile.clinic.info.update.failure"));
			return statusObject;
		}
	}
	
}
