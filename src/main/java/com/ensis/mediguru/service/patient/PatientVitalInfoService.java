package com.ensis.mediguru.service.patient;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensis.mediguru.dao.patient.PatientVitalInfoDAO;
import com.ensis.mediguru.dto.PatientVitalInfoDTO;
import com.ensis.mediguru.models.PatientVitalInfoModel;
import com.ensis.mediguru.models.StatusObject;
import com.ensis.mediguru.utils.MessageResources;

@Service
public class PatientVitalInfoService extends MessageResources {

	@Autowired
	PatientVitalInfoDAO patientVitalInfoDAO;

	/**
	 * @param patientVitalInfoDAO
	 *            the patientVitalInfoDAO to set
	 */
	public void setPatientVitalInfoDAO(PatientVitalInfoDAO patientVitalInfoDAO) {
		this.patientVitalInfoDAO = patientVitalInfoDAO;
	}

	@Transactional
	public StatusObject addPatientVitalInfo(
			PatientVitalInfoModel patientVitalInfoModel) {
		PatientVitalInfoDTO vitalInfo = new PatientVitalInfoDTO();
		vitalInfo.setPatientid(patientVitalInfoModel.getPatientid());
		vitalInfo.setHeight(patientVitalInfoModel.getHeight());
		vitalInfo.setWeight(patientVitalInfoModel.getWeight());
		vitalInfo.setHeartrate(patientVitalInfoModel.getHeartrate());
		vitalInfo.setBloodpreasure(patientVitalInfoModel.getHeartrate());
		vitalInfo
				.setBodytemperature(patientVitalInfoModel.getBodytemperature());
		vitalInfo.setSugarlevel(patientVitalInfoModel.getSugarlevel());
		vitalInfo.setCreateddate(new Date());

		// check info exist or not
		int responseId = patientVitalInfoDAO
				.checkPatientVitalInfoExistOrnot(patientVitalInfoModel
						.getPatientid());
		if (responseId < 0) {

			int response = patientVitalInfoDAO.addPatientVitalInfo(vitalInfo);

			if (response > 0) {
				StatusObject obj = new StatusObject();
				obj.setError(false);
				obj.setMessage(getMessage("patient.vital.info.added.success.message"));
				return obj;
			} else {
				StatusObject obj = new StatusObject();
				obj.setError(true);
				obj.setMessage(getMessage("patient.vital.info.added.failure.message"));
				return obj;

			}
		} else {
			StatusObject obj = new StatusObject();
			obj.setError(true);
			obj.setMessage(getMessage("patient.vital.info.already.added"));
			return obj;
		}

	}
}
