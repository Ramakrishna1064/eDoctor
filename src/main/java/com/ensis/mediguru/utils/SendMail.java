package com.ensis.mediguru.utils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class SendMail extends MessageResources {

	@Autowired
	private JavaMailSender mailSender;

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	/**
	 * 
	 * @param recipients
	 * @param subject
	 * @param message
	 * @return
	 */
	public boolean sendMail(String recipients, String subject, String message) {

		String fromMailId=getMessage("mail.host.mailid");      
		return sendEmailTemplate(recipients, fromMailId, subject, message);
	}

	/**
	 * 
	 * @param toMail
	 * @param from
	 * @param subject
	 * @param htmlMsg
	 * @return
	 */
	public boolean sendEmailTemplate(String toMail, String from,
			String subject, String htmlMsg) {

		MimeMessage message = mailSender.createMimeMessage();
		try {

			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(from);
			helper.setTo(toMail);
			helper.setSubject(subject);
			helper.setText(htmlMsg, true);
			mailSender.send(message);
			return true;

		} catch (MessagingException e) {
			e.printStackTrace();
			return false;

		}

	}

}
