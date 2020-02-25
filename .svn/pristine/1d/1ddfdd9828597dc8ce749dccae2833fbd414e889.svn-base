/**
 * 
 */
package com.ensis.mediguru.service.physician;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensis.mediguru.dao.common.CommonDAO;
import com.ensis.mediguru.dao.physician.PhysicianRegistrationDAO;
import com.ensis.mediguru.dto.DoctorRegistration;
import com.ensis.mediguru.dto.Users;
import com.ensis.mediguru.models.PhysicianRegistrationModel;
import com.ensis.mediguru.models.StatusObject;
import com.ensis.mediguru.utils.MessageResources;
import com.ensis.mediguru.utils.SendMail;
import com.ensis.mediguru.utils.Utilities;

/**
 * @author Venu
 *
 */
@Service
public class PhysicianRegistrationService extends MessageResources {

	@Autowired
	CommonDAO commonDAO;

	@Autowired
	PhysicianRegistrationDAO physicianRegistrationDAO;
	
	@Autowired
	SendMail sendMail;	

	public void setSendMail(SendMail sendMail) {
		this.sendMail = sendMail;
	}

	public void setPhysicianRegistrationDAO(
			PhysicianRegistrationDAO physicianRegistrationDAO) {
		this.physicianRegistrationDAO = physicianRegistrationDAO;
	}

	public void setCommonDAO(CommonDAO commonDAO) {
		this.commonDAO = commonDAO;
	}
	
	

	@Transactional
	public StatusObject registerPhysician(
			PhysicianRegistrationModel physicianRegistrationModel) {

		StatusObject statusObj = new StatusObject();
		// Check Email Id exists or Not
		long emailResult = commonDAO.checkEmailExists(physicianRegistrationModel.getMailid());

		if (emailResult == 0) {

			Users userObj = new Users();
			userObj.setPasswordotp(Utilities.getRandomNumber()); // OTP
			userObj.setUsertypeid(2); // Because Physician is Two
			userObj.setPassword(physicianRegistrationModel.getPassword()); // Password
			userObj.setEmail(physicianRegistrationModel.getMailid()); // Mail
			userObj.setCreatedby(physicianRegistrationModel.getFirstname()); // Physician
																				// Name
			userObj.setCreateddate(new Date()); // Current Date

			// insert into Users table
			int userId = commonDAO.insertUserObj(userObj);
			if (userId == 0) {

				statusObj.setError(true);
				statusObj.setMessage(getMessage("registration.error.message"));
				return statusObj;

			} else {

				DoctorRegistration physician = new DoctorRegistration(userId,
						physicianRegistrationModel.getFirstname(),
						physicianRegistrationModel.getLastname(),
						physicianRegistrationModel.getMobile(),
						physicianRegistrationModel.getSkypeid(),
						physicianRegistrationModel.getAddress1(),
						physicianRegistrationModel.getAddress2(),
						physicianRegistrationModel.getCity(),
						physicianRegistrationModel.getStateid(),
						physicianRegistrationModel.getCid(),
						physicianRegistrationModel.getZip(),
						physicianRegistrationModel.getPrimaryregnumber(),
						physicianRegistrationModel.getSpeciality(),
						physicianRegistrationModel.getImgid());
				physician.setCreatedby(physicianRegistrationModel
						.getFirstname());
				physician.setCreateddate(new Date());

				physicianRegistrationDAO.insertPhysicianRegistration(physician);
				
				
				//send Mail
				String dlink = getMessage("dlink");
				String body = "Please find the verification link <a href='"
						+ dlink
						+ "?mailid="
						+ physicianRegistrationModel.getMailid()
						+ "'>&nbsp;Click Here</a>"
						+ "<br><br>Please contact 'kris.ensis@gmail.com' if you have issues.";

				String recipients = physicianRegistrationModel.getMailid();
				String subject = getMessage("registration.email.subject");	
				//Send Email to Registered Mail
				sendMail.sendMail(recipients, subject, body);
				
				statusObj.setError(false);
				statusObj.setMessage(getMessage("registration.success.message"));
				return statusObj;

			}

		} else {
			statusObj.setError(true);
			statusObj.setMessage(getMessage("registration.email.exists"));
			return statusObj;
		}
	}
}
