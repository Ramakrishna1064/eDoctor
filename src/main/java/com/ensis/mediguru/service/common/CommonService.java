/**
 * 
 */
package com.ensis.mediguru.service.common;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ensis.mediguru.dao.common.CommonDAO;
import com.ensis.mediguru.dto.ClinicServices;
import com.ensis.mediguru.dto.Country;
import com.ensis.mediguru.dto.DoctorRegistration;
import com.ensis.mediguru.dto.LanguageType;
import com.ensis.mediguru.dto.MedicineTypes;
import com.ensis.mediguru.dto.PatientRegistration;
import com.ensis.mediguru.dto.PaymentType;
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
import com.ensis.mediguru.utils.GenerateGUID;
import com.ensis.mediguru.utils.MessageResources;
import com.ensis.mediguru.utils.SendMail;
import com.ensis.mediguru.utils.Utilities;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * @author Venu
 *
 */
@Service
public class CommonService extends MessageResources {

	@Autowired
	private CommonDAO commonDAO;

	@Autowired
	private SendMail sendMail;

	@Autowired
	GenerateThumbnailService generateThumbnailService;
	
	@Autowired
	VideoThumbnailsService videoThumbnailsService;
	
	

	/**
	 * @param videoThumbnailsService the videoThumbnailsService to set
	 */
	public void setVideoThumbnailsService(
			VideoThumbnailsService videoThumbnailsService) {
		this.videoThumbnailsService = videoThumbnailsService;
	}

	public void setGenerateThumbnailService(
			GenerateThumbnailService generateThumbnailService) {
		this.generateThumbnailService = generateThumbnailService;
	}

	public void setSendMail(SendMail sendMail) {
		this.sendMail = sendMail;
	}

	public void setCommonDAO(CommonDAO commonDAO) {
		this.commonDAO = commonDAO;
	}

	@Transactional
	public List<Country> getCountries() {

		return commonDAO.getCountriesList();
	}

	@Transactional
	public List<State> getStates() {

		return commonDAO.getStatesList();
	}

	@Transactional
	public List<SpecialityType> getSpecialities() {

		return commonDAO.getSpecialities();
	}

	@Transactional
	public List<LanguageType> getLanguages() {

		return commonDAO.getLanguages();
	}

	@Transactional
	public List<QualificationType> getQualifications() {

		return commonDAO.getQualifications();
	}

	@Transactional
	public List<ClinicServices> getClinicServices() {

		return commonDAO.getClinicServices();
	}

	
	@Transactional
	public CommonProfileData getCommonProfileData() {

		CommonProfileData commonProfileData = new CommonProfileData();
		commonProfileData.setLanguages((ArrayList<LanguageType>) commonDAO
				.getLanguages());
		commonProfileData
				.setClinicServices((ArrayList<ClinicServices>) commonDAO
						.getClinicServices());
		commonProfileData.setCountries((ArrayList<Country>) commonDAO
				.getCountriesList());
		commonProfileData.setStates((ArrayList<State>) commonDAO
				.getStatesList());
		commonProfileData
				.setQualificationsList((ArrayList<QualificationType>) commonDAO
						.getQualifications());
		commonProfileData.setSpecialities((ArrayList<SpecialityType>) commonDAO
				.getSpecialities());
		return commonProfileData;
	}

	/**
	 * 
	 * @param user
	 * @return
	 */
	@Transactional
	public PatientLoginStatusModel validatePatientLogin(Users user) {

		List list = commonDAO.validateUserLogin(user.getEmail(),
				user.getPassword(), 1);
		PatientLoginStatusModel statusObj = new PatientLoginStatusModel();
		if (list.size() > 0) {

			statusObj.setError(false);
			Users userObj = (Users) list.get(0);
			if (userObj.getStatus() <= 0) {

				statusObj.setMessage(getMessage("login.email.notverified"));
				statusObj.setActive(false);
				return statusObj;

			} else {

				statusObj.setMessage(getMessage("login.success"));
				statusObj.setActive(true);
				// get the Patient Id whoever login
				List userIdResult = commonDAO.getPatientLoginUserId(user
						.getEmail());
				PatientRegistration patientRegistration = (PatientRegistration) userIdResult
						.get(0);
				// set the Id to Status Obj
				statusObj.setPatientid(patientRegistration.getPatientid());
				return statusObj;
			}

		} else {
			statusObj.setError(true);
			statusObj.setActive(false);
			statusObj.setMessage(getMessage("login.email.password.error"));
			return statusObj;
		}

	}

	/**
	 * 
	 * @param user
	 * @return
	 */
	@Transactional
	public PhysicianLoginStatusModel validatePhysicianLogin(Users user) {

		List list = commonDAO.validateUserLogin(user.getEmail(),
				user.getPassword(), 2);
		PhysicianLoginStatusModel statusObj = new PhysicianLoginStatusModel();
		if (list.size() > 0) {

			statusObj.setError(false);
			Users userObj = (Users) list.get(0);
			if (userObj.getStatus() <= 0) {

				statusObj.setMessage(getMessage("login.email.notverified"));
				statusObj.setActive(false);
				return statusObj;

			} else {

				statusObj.setMessage(getMessage("login.success"));
				statusObj.setActive(true);
				// get the Patient Id whoever login
				List userIdResult = commonDAO.getPhysicianLoginUserId(user
						.getEmail());
				DoctorRegistration doctor = (DoctorRegistration) userIdResult
						.get(0);
				// set the Id to Status Obj
				statusObj.setDoctorid(doctor.getPhysicianid());
				return statusObj;
			}

		} else {
			statusObj.setError(true);
			statusObj.setActive(false);
			statusObj.setMessage(getMessage("login.email.password.error"));
			return statusObj;
		}
	}

	/**
	 * 
	 * @param userObj
	 * @return
	 */
	@Transactional
	public StatusObject sendOTPtoRegisterEmail(Users userObj) {

		StatusObject statusObj = new StatusObject();
		int OTPPassword = Utilities.getRandomNumber();
		userObj.setPasswordotp(OTPPassword);
		int status = commonDAO.updateOTPPassword(userObj);
		if (status > 0) {

			String recipients = userObj.getEmail();
			String subject = getMessage("forgot.password.otp.subject");
			String message = getMessage("forgot.password.otp.body",
					new Object[] { OTPPassword });
			// send Mail
			sendMail.sendMail(recipients, subject, message);

			statusObj.setError(false);
			statusObj.setMessage(getMessage("otp.send.success.message"));
			return statusObj;

		} else {
			statusObj.setError(true);
			statusObj.setMessage(getMessage("email.not.verified"));
			return statusObj;
		}
	}

	/**
	 * Reset Password when Forgot Request
	 * 
	 * @param userObj
	 * @return
	 */
	@Transactional
	public StatusObject resetPassword(Users userObj) {

		StatusObject statusObj = new StatusObject();
		int status = commonDAO.resetPassword(userObj);
		if (status > 0) {
			statusObj.setError(false);
			statusObj.setMessage(getMessage("forgot.password.reset.success"));
			return statusObj;
		} else {
			statusObj.setError(true);
			statusObj.setMessage(getMessage("forgot.password.reset.error"));
			return statusObj;
		}
	}

	/**
	 * Resend Verfication Link
	 * 
	 * @param userObj
	 * @return
	 */
	@Transactional
	public StatusObject resendVerificationLink(Users userObj) {

		StatusObject statusObj = new StatusObject();
		long emailResult = commonDAO.checkEmailExists(userObj.getEmail());
		if (emailResult != 0) {

			String dlink = getMessage("dlink");
			String body = "Please find the verification link <a href='"
					+ dlink
					+ "?mailid="
					+ userObj.getEmail()
					+ "'>&nbsp;Click Here</a>"
					+ "<br><br>Please contact 'kris.ensis@gmail.com' if you have issues.";
			String subject = getMessage("registration.email.resend.verification");

			// send Mail
			if (sendMail.sendMail(userObj.getEmail(), subject, body)) {

				statusObj.setError(false);
				statusObj
						.setMessage(getMessage("resend.verification.link.success"));
				return statusObj;

			} else {

				statusObj.setError(true);
				statusObj
						.setMessage(getMessage("registration.email.notexists"));
				return statusObj;
			}

		} else {

			statusObj.setError(true);
			statusObj.setMessage(getMessage("registration.email.notexists"));
			return statusObj;
		}
	}

	/**
	 * Get the Card Types
	 * 
	 * @return
	 */
	@Transactional
	public ArrayList<CardTypes> getPaymentCardTypes() {

		ArrayList<CardTypes> cardTypesList = new ArrayList<CardTypes>();
		ArrayList<PaymentType> paymentList = (ArrayList<PaymentType>) commonDAO
				.getPaymentCardTypes();
		for (PaymentType paymentType : paymentList) {

			CardTypes cardType = new CardTypes(paymentType.getPtypeid(),
					paymentType.getName());
			cardTypesList.add(cardType);
		}
		return cardTypesList;
	}

	/**
	 * 
	 * @param imageId
	 * @return
	 */
	@Transactional
	public String getImagePathURL(int imageId) {

		String imageName = commonDAO.getImageName(imageId);
		String imagePath = getMessage("imageUrlPath") + imageName;
		return imagePath;

	}

	/**
	 * 
	 * @param file
	 * @return
	 */
	@Transactional
	public ProfileUploadImageStatusModel profileUploadImage(MultipartFile file) {
		ProfileUploadImageStatusModel StatusObj = new ProfileUploadImageStatusModel();
		if (!file.isEmpty()) {
			try {

				System.out.println(file.getOriginalFilename());

				String fileName = saveImgaeFileIntoDisk(file);
				if (fileName != null) {

					int imageid = commonDAO.uploadProfileImage(fileName);
					StatusObj.setImageid(imageid);
					StatusObj.setError(false);
					StatusObj
							.setMessage(getMessage("Profile.upload.success.message"));
					return StatusObj;
				} else {

					StatusObj.setError(true);
					StatusObj
							.setMessage(getMessage("profile.upload.failure.message"));
					return StatusObj;
				}

			} catch (Exception e) {
				e.printStackTrace();

				StatusObj.setError(true);
				StatusObj
						.setMessage(getMessage("profile.upload.failure.message"));
				return StatusObj;
			}
		} else {
			StatusObj.setError(true);
			StatusObj.setMessage(getMessage("profile.upload.failure.message"));
			return StatusObj;
		}
	}

	/**
	 * 
	 * @param file
	 * @return
	 */
	@Transactional
	public String saveImgaeFileIntoDisk(MultipartFile file) {

		try {

			String uuid = GenerateGUID.generateGuidValue();
			String fileName = uuid + "_" + file.getOriginalFilename();
			byte[] bytes = file.getBytes();
			File savefile = new File(getMessage("imagePath") + fileName);
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(savefile));
			stream.write(bytes);
			stream.close();
			return fileName;

		} catch (Throwable t) {
			t.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * @param file
	 * @return
	 */
	@Transactional
	public String saveVideoFileIntoDisk(MultipartFile file) {

		try {

			String uuid = GenerateGUID.generateGuidValue();
			String name = uuid + "_"
					+ FilenameUtils.getBaseName(file.getOriginalFilename())
					+ ".mp4";
			System.out.println("converto----" + name);
			String fileName = uuid + "_" + file.getOriginalFilename();
			byte[] bytes = file.getBytes();
			File savefile = new File(getMessage("videoPath") + name);
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(savefile));
			stream.write(bytes);
			stream.close();
			return name;

		} catch (Throwable t) {
			t.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * @param videoFilePath
	 * @return
	 */
	public String generateThumnail(String videoFilePath) {

		String fileName = "";
		try {
			String videoFile = getMessage("videoPath") + videoFilePath;
			String uuid = GenerateGUID.generateGuidValue();
			fileName = uuid + "_thumbnail.jpg";
			String thumbnailPath = getMessage("imagePath") + fileName;
			System.out.println("-videoFile--->" + videoFile);
			System.out.println("-thumbnailPath--->" + thumbnailPath);
			//generateThumbnailService.getThumb(videoFile, thumbnailPath);
			//VideoThumbnailsService.GenerateVideoThumbnail(videoFile, thumbnailPath);
			return fileName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileName;
	}

	/**
	 * 
	 * @param file
	 * @return
	 */
	@Transactional
	public String saveAudioFileIntoDisk(MultipartFile file) {

		try {

			String uuid = GenerateGUID.generateGuidValue();
			String fileName = uuid + "_" + file.getOriginalFilename();
			byte[] bytes = file.getBytes();
			File savefile = new File(getMessage("audioPath") + fileName);
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(savefile));
			stream.write(bytes);
			stream.close();
			return fileName;

		} catch (Throwable t) {
			t.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * @param mailid
	 * @return
	 */

	@Transactional
	public StatusObject verifyEmail(String mailid) {
		StatusObject statusObj = new StatusObject();
		int response = commonDAO.verifyEmail(mailid);
		if (response > 0) {
			statusObj.setError(false);
			statusObj.setMessage(getMessage("verify.success.message"));
			return statusObj;

		} else {
			
			statusObj.setError(true);
			statusObj.setMessage(getMessage("verify.faliure.message"));
			return statusObj;
		}

	}

	/**
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public byte[] getImage(String fileName) throws IOException {

		InputStream inputStream = new FileInputStream(getMessage("imagePath")
				+ fileName);

		// Prepare buffered image.
		BufferedImage img = ImageIO.read(inputStream);

		// Create a byte array output stream.
		ByteArrayOutputStream bao = new ByteArrayOutputStream();

		// Write to output stream
		ImageIO.write(img, "jpg", bao);
		return bao.toByteArray();
	}

	/**
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public HttpServletResponse getAudioFile(String fileName,HttpServletResponse response) throws IOException {

		/*InputStream inputStream = new FileInputStream(getMessage("audioPath")
				+ fileName);
		byte[] buffer = null;
		try {

			buffer = new byte[inputStream.available()];
			inputStream.read(buffer);
			inputStream.close();
			return buffer;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;*/
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		String filePath1 = getMessage("audioPath")+fileName;        
	    int fileSize = (int) new File(filePath1).length();
	    response.setContentLength(fileSize);
	    response.setContentType("audio/mp3");
	    response.setBufferSize(fileSize);
	    FileInputStream inputStream = new FileInputStream(filePath1);
	    String filename = FilenameUtils.getName(filePath1);
	    
	    OutputStream outputStream = response.getOutputStream();
	    
	    int value = IOUtils.copy(inputStream, outputStream);
	    System.out.println("File Size :: "+fileSize);
	    System.out.println("Copied Bytes :: "+value);
	    IOUtils.closeQuietly(inputStream);
	    IOUtils.closeQuietly(outputStream);
	    response.setStatus(HttpServletResponse.SC_OK);
		
	    return response;
	}

	/**
	 * 
	 * @param fileName
	 * @return
	 * @return
	 * @return
	 * @throws IOException
	 */
	public HttpServletResponse getVideoFile(String fileName, HttpServletResponse response) throws IOException {

		//String file=getMessage("videoPath")+fileName;
	/*	
		File file1 = new File(file);
		//response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
		 response.setHeader("Content-Type", "audio/mp3");
		 response.setHeader("Content-Length", Long.toString(file1.length()));
		 response.setHeader("Content-Range:", "bytes=1000-2000/629765");
		response.setHeader("Content-Disposition", "attachment; filename="+fileName);
        InputStream iStream = new FileInputStream(file);
        IOUtils.copy(iStream, response.getOutputStream());
        response.flushBuffer();*/
		
		
	    // String filePath = getMessage("videoPath") + fileName;
		// ResourceLoader resourceLoader = new DefaultResourceLoader();

		// return resourceLoader.getResource(filePath);
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		String filePath1 = getMessage("videoPath")+fileName;        
	    int fileSize = (int) new File(filePath1).length();
	    response.setContentLength(fileSize);
	    response.setContentType("video/mp4");
	    //response.setBufferSize(fileSize);
	   
	    FileInputStream inputStream = new FileInputStream(filePath1);
	    
	    OutputStream outputStream = response.getOutputStream();
	    
	    int value = IOUtils.copy(inputStream, outputStream);
	    System.out.println("File Size :: "+fileSize);
	    System.out.println("Copied Bytes :: "+value);
	    IOUtils.closeQuietly(inputStream);
	    IOUtils.closeQuietly(outputStream);
	    response.setStatus(HttpServletResponse.SC_OK);
		
	    return response;
	}

	/**
	 * 
	 * @return
	 */
	@Transactional
	public List<MedicineTypes> getMedicinetypes() {

		return commonDAO.getMedicineTypeList();
	}

}
