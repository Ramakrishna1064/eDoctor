/**
 * 
 */
package com.ensis.mediguru.service.physician;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensis.mediguru.dao.physician.PhysicianScheduleDAO;
import com.ensis.mediguru.models.PhysicianDashBoardModel;
import com.ensis.mediguru.models.PhysicianFavoriteFamilyOngoingCount;
import com.ensis.mediguru.models.PhysicianScheduleCount;
import com.ensis.mediguru.utils.Utilities;

/**
 * @author Venu
 *
 */
@Service
public class PhysicianDashBoardService {

	@Autowired
	PhysicianScheduleService physicianScheduleService;

	@Autowired
	PhysicianScheduleDAO physicianScheduleDAO;

	/**
	 * @param physicianScheduleService
	 *            the physicianScheduleService to set
	 */
	public void setPhysicianScheduleService(
			PhysicianScheduleService physicianScheduleService) {
		this.physicianScheduleService = physicianScheduleService;
	}

	/**
	 * @param physicianScheduleDAO
	 *            the physicianScheduleDAO to set
	 */
	public void setPhysicianScheduleDAO(
			PhysicianScheduleDAO physicianScheduleDAO) {
		this.physicianScheduleDAO = physicianScheduleDAO;
	}

	/**
	 * 
	 * @param physicianId
	 * @return
	 */
	@Transactional
	public PhysicianDashBoardModel getPhysicianDashBoardInfo(int physicianId) {

		PhysicianDashBoardModel physicianDashBoardModel = new PhysicianDashBoardModel();
		
		String currentdate=Utilities.getCurrentDate();
		physicianDashBoardModel.setSchedules(physicianScheduleService.getPhysicianSchedules(physicianId, currentdate));
		
		/*physicianDashBoardModel.setSchedules(physicianScheduleService
				.getPhysicianCuurentDaySchedules(physicianId));*/
		
		PhysicianFavoriteFamilyOngoingCount favFamilyModel = physicianScheduleDAO
				.getPhysicianFavFamilyOngoingCount(physicianId);

		ArrayList<PhysicianScheduleCount> scheduleCountList = physicianScheduleDAO
				.getPhysicianScheduleCount(physicianId);
		
		for(PhysicianScheduleCount physicianScheduleCountObj: scheduleCountList){
						
			if (physicianScheduleCountObj.getScheduletypeid() != null) {
				
				if (Integer.parseInt(physicianScheduleCountObj.getScheduletypeid()) == 1) {
					physicianDashBoardModel.setInperson(Integer
							.parseInt(physicianScheduleCountObj.getNumber()));
				}
				if (Integer.parseInt(physicianScheduleCountObj.getScheduletypeid()) == 2) {
					physicianDashBoardModel.setPhonecall(Integer
							.parseInt(physicianScheduleCountObj.getNumber()));
				}
				if (Integer.parseInt(physicianScheduleCountObj.getScheduletypeid()) == 3) {
					physicianDashBoardModel.setVideocall(Integer
							.parseInt(physicianScheduleCountObj.getNumber()));
				}
			}
		}

		//Family Count
		if (favFamilyModel.getFamilycount() != null) {
			physicianDashBoardModel.setFamilycount(Integer
					.parseInt(favFamilyModel.getFamilycount()));
		}

		//Fav Count
		if (favFamilyModel.getFavcount() != null) {
			physicianDashBoardModel.setFavcount(Integer.parseInt(favFamilyModel
					.getFavcount()));
		}

		//Ongoing Count
		if (favFamilyModel.getOngoingcount() != null) {
			physicianDashBoardModel.setOngoingcount(Integer
					.parseInt(favFamilyModel.getOngoingcount()));
		}
		
		//Reminder Count
		if(favFamilyModel.getRemindercount() != null){
			
			physicianDashBoardModel.setRemindercount(Integer
					.parseInt(favFamilyModel.getRemindercount()));
		}
		
		return physicianDashBoardModel;
	}
}
