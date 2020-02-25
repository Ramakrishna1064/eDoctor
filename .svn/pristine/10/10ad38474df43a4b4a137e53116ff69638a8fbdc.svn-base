/**
 * 
 */
package com.ensis.mediguru.service.physician;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensis.mediguru.dao.physician.PhysicianPatientsDAO;
import com.ensis.mediguru.models.PhysicianPatientsOngoingPastGetModel;
import com.ensis.mediguru.models.PhysicianPatientsOngoingPastViewModel;
import com.ensis.mediguru.utils.MessageResources;

/**
 * @author Venu
 *
 */
@Service
public class PhysicianPatientsService extends MessageResources{

	@Autowired
	PhysicianPatientsDAO physicianPatientsDAO;
	
	
	/**
	 * @param physicianPatientsDAO the physicianPatientsDAO to set
	 */
	public void setPhysicianPatientsDAO(PhysicianPatientsDAO physicianPatientsDAO) {
		this.physicianPatientsDAO = physicianPatientsDAO;
	}


	/**
	 * 
	 * @param physicianid
	 * @return
	 */
	@Transactional
	public ArrayList<PhysicianPatientsOngoingPastViewModel> getPhysicanPatients(int physicianid){
		
		ArrayList<PhysicianPatientsOngoingPastGetModel> patientsList=
				physicianPatientsDAO.getPhysicianPatients(physicianid);
		
		ArrayList<PhysicianPatientsOngoingPastViewModel> patientsOngoingList=
				new ArrayList<PhysicianPatientsOngoingPastViewModel>();
		
		if(patientsList != null){
			
			for(PhysicianPatientsOngoingPastGetModel patientObj:patientsList){
				
				PhysicianPatientsOngoingPastViewModel modelObj=new PhysicianPatientsOngoingPastViewModel();
				modelObj.setPatientid(patientObj.getPatientid());
				modelObj.setFirstname(patientObj.getFirstname());
				modelObj.setLastname(patientObj.getLastname());
				modelObj.setAddress1(patientObj.getAddress1());
				modelObj.setAddress2(patientObj.getAddress2());
				modelObj.setCity(patientObj.getCity());
				modelObj.setState(patientObj.getState());
				modelObj.setCountry(patientObj.getCountry());
				modelObj.setZip(patientObj.getZip());
				
				if(patientObj.getImageUrl() != null){
					modelObj.setImageUrl(getMessage("imageUrlPath")+patientObj.getImageUrl());
				}
				
				if (patientObj.getPhysiciantypeid().contains(",")) {

					String[] groupPhysicians = patientObj
							.getPhysiciantypeid().split(",");
					for (int k = 0; k < groupPhysicians.length; k++) {

						int physicianTypeId = Integer.parseInt(groupPhysicians[k]);
						if (physicianTypeId == 3) {
							// Ongoing
							modelObj.setOngoingPatient(true);
						} else if (physicianTypeId == 4) {
							//Past
							modelObj.setPastPatient(true);
						} 
					}

				} else {

					int physicianTypeId = Integer.parseInt(patientObj.getPhysiciantypeid());
					if (physicianTypeId == 3) {
						// Ongoing
						modelObj.setOngoingPatient(true);
					} else if (physicianTypeId == 4) {
						//Past
						modelObj.setPastPatient(true);
					} 
				}
				
				patientsOngoingList.add(modelObj);
			}
		}
		
		return patientsOngoingList;
	}
}
