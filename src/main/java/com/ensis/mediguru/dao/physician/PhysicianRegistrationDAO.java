/**
 * 
 */
package com.ensis.mediguru.dao.physician;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ensis.mediguru.dao.common.HibernateUtil;
import com.ensis.mediguru.dto.DoctorRegistration;

/**
 * @author Venu
 *
 */
@Repository
public class PhysicianRegistrationDAO {

	@Autowired
	HibernateUtil hibernateUtil;
	
	/**
	 * 
	 * @param physician
	 * @return
	 */
	public boolean insertPhysicianRegistration(DoctorRegistration physician) {

		Object obj = hibernateUtil.create(physician);
		if (obj != null) {
			return true;
		} else {
			return false;
		}
	}
}
