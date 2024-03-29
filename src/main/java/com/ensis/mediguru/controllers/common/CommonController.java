/**
 * 
 */
package com.ensis.mediguru.controllers.common;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ensis.mediguru.dto.ClinicServices;
import com.ensis.mediguru.dto.Country;
import com.ensis.mediguru.dto.LanguageType;
import com.ensis.mediguru.dto.MedicineTypes;
import com.ensis.mediguru.dto.QualificationType;
import com.ensis.mediguru.dto.SpecialityType;
import com.ensis.mediguru.dto.State;
import com.ensis.mediguru.dto.Users;
import com.ensis.mediguru.models.CardTypes;
import com.ensis.mediguru.models.CommonProfileData;
import com.ensis.mediguru.models.PatientLoginStatusModel;
import com.ensis.mediguru.models.PhysicianLoginStatusModel;
import com.ensis.mediguru.models.ProfileUploadImageStatusModel;
import com.ensis.mediguru.models.StatusObject;
import com.ensis.mediguru.service.common.CommonService;
import com.ensis.mediguru.service.common.NotifcationService;
import com.ensis.mediguru.utils.MessageResources;

/**
 * @author Venu
 *
 */
@Controller
public class CommonController extends MessageResources {

	@Autowired
	CommonService commonService;
	
	@Autowired
	NotifcationService notifcationService;

	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/Country/GetCountry", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public List<Country> getCountriesList() {
		// TO DO
		return commonService.getCountries();
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/State/GetStates", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public List<State> getStates() {
		// TO DO
		return commonService.getStates();
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/SpecialityType/GetSpeciality", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public List<SpecialityType> getSpeciality() {
		// TO DO
		return commonService.getSpecialities();
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/LanguageType/GetLanguagetypes", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public List<LanguageType> getLanguages() {
		// TO DO
		return commonService.getLanguages();
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/QualificationType/getQualificationTypes", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public List<QualificationType> getQualifications() {
		// TO DO
		return commonService.getQualifications();
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/Clinic/GetClinicService", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public List<ClinicServices> getClinicServices() {
		// TO DO
		return commonService.getClinicServices();
	}

	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/GetCommonProfileData", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public CommonProfileData getCommonProfileData() {
		// TO DO
		return commonService.getCommonProfileData();
	}

	/**
	 * Doctor Login
	 * 
	 * @param userObj
	 * @return
	 */
	@RequestMapping(value = "/User/DoctorLogin", method = RequestMethod.POST, headers = { "Content-type=application/json" }, produces = { "application/json" })
	@ResponseBody
	public PhysicianLoginStatusModel validatePhysicianLogin(
			@RequestBody Users userObj) {
		return commonService.validatePhysicianLogin(userObj);
	}

	/**
	 * Patient Login
	 * 
	 * @param userObj
	 * @return
	 */
	@RequestMapping(value = "/User/PatientLogin", method = RequestMethod.POST, headers = { "Content-type=application/json" }, produces = { "application/json" })
	@ResponseBody
	public PatientLoginStatusModel validatePatientLogin(
			@RequestBody Users userObj) {
		return commonService.validatePatientLogin(userObj);
	}

	/**
	 * Send OTP to Register Email for Forgot Password
	 * 
	 * @param userObj
	 * @return
	 */
	@RequestMapping(value = "/App/SendOtpToRegisterEmail", method = RequestMethod.POST, headers = { "Content-type=application/json" }, produces = { "application/json" })
	@ResponseBody
	public StatusObject sendOtpToRegisterEmail(@RequestBody Users userObj) {
		return commonService.sendOTPtoRegisterEmail(userObj);
	}

	/**
	 * Reset Password
	 * 
	 * @param userObj
	 * @return
	 */
	@RequestMapping(value = "/App/forgotPassword", method = RequestMethod.POST, headers = { "Content-type=application/json" }, produces = { "application/json" })
	@ResponseBody
	public StatusObject forgotPassword(@RequestBody Users userObj) {
		return commonService.resetPassword(userObj);
	}

	/**
	 * Re send Verification Link
	 * 
	 * @param userObj
	 * @return
	 */
	@RequestMapping(value = "/App/resendLink", method = RequestMethod.POST, headers = { "Content-type=application/json" }, produces = { "application/json" })
	@ResponseBody
	public StatusObject resendLink(@RequestBody Users userObj) {
		return commonService.resendVerificationLink(userObj);
	}

	/**
	 * get the card types
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getCardTypes", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public List<CardTypes> getPaymentCardTypes() {
		// TO DO
		return commonService.getPaymentCardTypes();
	}

	/**
	 * 
	 * @param name
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "/UploadImage", method = RequestMethod.POST)
	public @ResponseBody ProfileUploadImageStatusModel uploadFileHandler(
			@RequestParam("imagename") MultipartFile file) {
		return commonService.profileUploadImage(file);
	}

	/**
	 * 
	 * @param mailid
	 * @return
	 */
	@RequestMapping(value = "/Emailverify", method = RequestMethod.GET)
	@ResponseBody
	public StatusObject verifyEmail(@RequestParam("mailid") String mailid) {

		return commonService.verifyEmail(mailid);

	}

	/**
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/getImage", method = RequestMethod.GET, produces = { "image/jpg" })
	@ResponseBody
	public byte[] getLogo(@RequestParam("fileName") String file)
			throws IOException {

		return commonService.getImage(file);
	}
	
	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/getMedicineTypes", method = RequestMethod.GET,produces = { "application/json" })
	@ResponseBody
	public List<MedicineTypes> getMedicinetypes()
			throws IOException {

		return commonService.getMedicinetypes();
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/testiOSNotification", method = RequestMethod.GET,produces = { "application/json" })
	@ResponseBody
	public StatusObject testiOSNotification(){

		//notifcationService.sendiOSTestNotification();
		return null;
	}
	
	/**
	 * 
	 * @param requestParams
	 * @param file
	 * @param videofile
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/testMultipleFilesFormat", 
			method = RequestMethod.POST,
			headers = "content-type=multipart/*",
			produces = { "application/json" })
	@ResponseBody
	public StatusObject postStartTreatmentQuestionToPhysician(
			@RequestParam Map<String, String> requestParams,
			@RequestParam("imagename") MultipartFile[] file,
			@RequestParam("videofile") MultipartFile[] videoFiles,
			@RequestParam("audiofile") MultipartFile[] audioFiles) throws Exception {

		
		for(MultipartFile videoFileObj: videoFiles){
			
			System.out.println("=== Size is ==>"+videoFileObj.getSize());
			System.out.println("=== Name ===>"+videoFileObj.getOriginalFilename());
			commonService.saveVideoFileIntoDisk(videoFileObj);
		}
		
		for(MultipartFile audioFileObj: audioFiles){
			
			System.out.println("=== Audio File Size is ==>"+audioFileObj.getSize());
			System.out.println("=== Audio File Name ===>"+audioFileObj.getOriginalFilename());
			System.out.println("=== File Content Type ===>"+audioFileObj.getContentType());
			commonService.saveAudioFileIntoDisk(audioFileObj);
		}
		
		return null;

	}
	
	/**
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/getAudio", method = RequestMethod.GET)
	@ResponseBody
	public HttpServletResponse getAudio(@RequestParam("fileName") String fileName,HttpServletRequest request,HttpServletResponse response)
			throws IOException {

		return commonService.getAudioFile(fileName,response);
	}
	
	/**
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/getVideo", method = RequestMethod.GET )
	@ResponseBody
	public HttpServletResponse getVideo(@RequestParam("fileName") String fileName, HttpServletRequest    request,HttpServletResponse response)
			throws IOException {
		
		return  commonService.getVideoFile(fileName,response);
		}
}
