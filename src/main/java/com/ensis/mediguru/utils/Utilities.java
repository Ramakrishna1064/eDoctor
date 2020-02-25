/**
 * 
 */
package com.ensis.mediguru.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import com.ensis.mediguru.models.GetPatientPastMedicines;
import com.ensis.mediguru.models.PatientOngoingQuestionsModel;
import com.ensis.mediguru.models.PatientOngoingRepliesModel;
import com.ensis.mediguru.models.PatientQuestionsAndAnswersModel;
import com.ensis.mediguru.models.PhysicianOngoingScheduleModel;
import com.ensis.mediguru.models.PhysicianQuestionsAndAnswersModel;

/**
 * @author Venu
 *
 */
public class Utilities {

	public static int getRandomNumber() {

		int randomNumber = 0;
		randomNumber = (int) ((Math.random() * 9000000) + 1000000);
		return randomNumber;
	}

	/**
	 * 
	 * @param stringValue
	 * @return
	 */
	public static int getInteger(String stringValue) {

		return Integer.parseInt(stringValue);
	}

	/**
	 * 
	 * @param dateAndTimeString
	 * @return
	 */
	public static Date getDateAndTimeFormat(String dateAndTimeString) {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		try {
			Date date = simpleDateFormat.parse(dateAndTimeString);
			return date;
		} catch (ParseException ex) {
			System.out.println("Exception " + ex);
			return null;
		}
	}
	
	public static Date getDateAndTime(String dateAndTimeString) {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		try {
			Date date = simpleDateFormat.parse(dateAndTimeString);
			return date;
		} catch (ParseException ex) {
			System.out.println("Exception " + ex);
			return null;
		}
	}

	/**
	 * 
	 */
	public static Comparator<PhysicianQuestionsAndAnswersModel> sortyByTreatmentQuesId = new Comparator<PhysicianQuestionsAndAnswersModel>() {

		public int compare(PhysicianQuestionsAndAnswersModel o1, PhysicianQuestionsAndAnswersModel o2) {
			// TODO Auto-generated method stub
			return o1.getTreatmentquestionid() - o2.getTreatmentquestionid();
		}
	};
	
	/**
	 * 
	 */
	public static Comparator<GetPatientPastMedicines> sortByConsultationId = new Comparator<GetPatientPastMedicines>() {

		public int compare(GetPatientPastMedicines o1, GetPatientPastMedicines o2) {
			// TODO Auto-generated method stub
			return o2.getConsultationid() - o1.getConsultationid();
		}
	};

	/**
	 * 
	 */
	public static Comparator<PatientQuestionsAndAnswersModel> sortyByPatientTreatmentQuesId = new Comparator<PatientQuestionsAndAnswersModel>() {

		public int compare(PatientQuestionsAndAnswersModel o1, PatientQuestionsAndAnswersModel o2) {
			// TODO Auto-generated method stub
			return o1.getTreatmentquestionid() - o2.getTreatmentquestionid();
		}
	};

	/**
	 * 
	 */
	public static Comparator<PatientOngoingQuestionsModel> soryByPatientOngoingTreatemntQues = new Comparator<PatientOngoingQuestionsModel>() {

		public int compare(PatientOngoingQuestionsModel o1, PatientOngoingQuestionsModel o2) {
			// TODO Auto-generated method stub
			return o1.getTreatmentquestionid() - o2.getTreatmentquestionid();
		}
	};

	/**
	 * 
	 */
	public static Comparator<PhysicianOngoingScheduleModel> soryByPhysicianOngoingTreatemntQues = new Comparator<PhysicianOngoingScheduleModel>() {

		public int compare(PhysicianOngoingScheduleModel o1, PhysicianOngoingScheduleModel o2) {
			// TODO Auto-generated method stub
			return o1.getTreatmentquestionid() - o2.getTreatmentquestionid();
		}
	};

	/**
	 * 
	 */
	public static Comparator<PatientOngoingRepliesModel> sortByPatientOnggoingReplyModel = new Comparator<PatientOngoingRepliesModel>() {

		public int compare(PatientOngoingRepliesModel o1, PatientOngoingRepliesModel o2) {
			// TODO Auto-generated method stub
			return o1.getTreatmentphyansid() - o2.getTreatmentphyansid();
		}
	};

	/**
	 * 
	 */
	/*
	 * public static Comparator<PhyPatQuesAnsReplyModel>
	 * sortyByPhysicianTreantmentAnswerID = new
	 * Comparator<PhyPatQuesAnsReplyModel>() {
	 * 
	 * public int compare(PhyPatQuesAnsReplyModel o1, PhyPatQuesAnsReplyModel
	 * o2) { // TODO Auto-generated method stub return o1.getTreatmentphyansid()
	 * - o2.getTreatmentphyansid(); } };
	 */

	/**
	 * 
	 * @param date
	 * @return
	 */
	public static String convertDateFormat(Date date) {

		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		System.out.println("Format 1:   " + dateFormatter.format(date));
		return dateFormatter.format(date);
	}
	
	/**
	 * 
	 * @param date
	 * @return
	 */
	public static String convertToDateFormat(Date date) {

		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("Format 1:   " + dateFormatter.format(date));
		return dateFormatter.format(date);
	}

	/**
	 * 
	 * @return
	 */
	public static String getCurrentDate() {

		try {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date d = new Date();
			String formattedTime = sdf.format(d);
			return formattedTime;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param rating
	 * @return
	 */
	public static double getTwoDigitDoubleValue(String rating) {

		if (rating != null) {

			double value = Double.parseDouble(rating);
			String result = String.format("%.2f", value);
			return Double.parseDouble(result);
		}
		return 0;

	}

	/**
	 * 
	 * @param param
	 * @return
	 */
	public static Date getMedicineDateFormat(String param) {

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd");
			Date d = sdf.parse(param);
			String formattedTime = output.format(d);
			Date opDate = output.parse(formattedTime);
			return opDate;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

}
