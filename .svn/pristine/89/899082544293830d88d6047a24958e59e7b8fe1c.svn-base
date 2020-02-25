/**
 * 
 */
package com.ensis.mediguru.service.physician;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensis.mediguru.dao.physician.PhysicianChangePasswordDAO;
import com.ensis.mediguru.dto.Users;
import com.ensis.mediguru.models.PhysicianChangePasswordModel;
import com.ensis.mediguru.models.StatusObject;
import com.ensis.mediguru.utils.MessageResources;

/**
 * @author Venu
 *
 */

@Service
public class PhysicianChangePasswordService extends MessageResources{

	@Autowired
	PhysicianChangePasswordDAO physicianChangePasswordDAO;

	/**
	 * @param physicianChangePasswordDAO the physicianChangePasswordDAO to set
	 */
	public void setPhysicianChangePasswordDAO(
			PhysicianChangePasswordDAO physicianChangePasswordDAO) {
		this.physicianChangePasswordDAO = physicianChangePasswordDAO;
	}
	
	/**
	 * 
	 * @param physicianChangePasswordModel
	 * @return
	 */
	@Transactional
	public StatusObject changePassword(PhysicianChangePasswordModel physicianChangePasswordModel){
		
		StatusObject statusObject=new StatusObject();
		if(physicianChangePasswordModel != null){
			
			int userId=physicianChangePasswordDAO.getPhysicianUserId(physicianChangePasswordModel.getPhysicianid());
			if(userId>0){
				
				Users userObj=physicianChangePasswordDAO.getUser(userId);
				if(userObj != null){
					
					if(physicianChangePasswordModel.getOldPassword().equals(userObj.getPassword())){
						
						if (physicianChangePasswordModel.getNewPassword() != null
								&& !physicianChangePasswordModel
										.getNewPassword().equalsIgnoreCase("")) {
							userObj.setPassword(physicianChangePasswordModel
									.getNewPassword().trim());
							boolean status=physicianChangePasswordDAO.updateUser(userObj);
							if(status){
								
								statusObject.setError(false);
								statusObject.setMessage(getMessage("password.change.success"));
								return statusObject;
								
							}else{
								statusObject.setError(true);
								statusObject.setMessage(getMessage("password.change.failure"));
								return statusObject;
							}
							
						}else{
							statusObject.setError(true);
							statusObject.setMessage(getMessage("physician.new.password.empty.error"));
							return statusObject;
						}
						
					}else{
						statusObject.setError(true);
						statusObject.setMessage(getMessage("physician.current.password.error"));
						return statusObject;
					}
					
				}else{
					statusObject.setError(true);
					statusObject.setMessage(getMessage("physician.not.found"));
					return statusObject;
				}
				
			}else{
				
				statusObject.setError(true);
				statusObject.setMessage(getMessage("physician.not.found"));
				return statusObject;
			}
			
		}else{
			
			statusObject.setError(true);
			statusObject.setMessage(getMessage("password.change.failure"));
			return statusObject;
		}
	}
}
