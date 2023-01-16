package com.grupo5.reto2.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.mail.MessagingException;

@RestController
@RequestMapping("api")
public class EmailController {

	@Autowired
	private EmailService emailService;

	@PostMapping("/sendMail")
	public String sendMail(@RequestBody EmailDetails details) {
		 
		return emailService.sendSimpleMail(details);
	}

	
	@PostMapping("/sendMailWithAttachment")
	public String sendMailWithAttachment(@RequestBody EmailDetails details) throws MessagingException {
		String status = emailService.sendMailWithAttachment();

		return status;
	}
}