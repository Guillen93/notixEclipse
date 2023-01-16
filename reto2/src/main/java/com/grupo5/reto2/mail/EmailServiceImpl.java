package com.grupo5.reto2.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender mailSender;

	public String sendSimpleMail(EmailDetails details) {

		try {

			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(details.getRecipient());
			message.setSubject(details.getSubject());
			message.setText(details.getMsgBody());
			mailSender.send(message);

			return "Mail Sent Successfully...";
		}

		catch (Exception e) {
			return "Error while Sending Mail";
		}
	}

	public String sendMailWithAttachment() throws jakarta.mail.MessagingException {

		return null;
	}

}