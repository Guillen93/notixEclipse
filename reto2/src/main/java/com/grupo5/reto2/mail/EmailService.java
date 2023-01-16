package com.grupo5.reto2.mail;

import jakarta.mail.MessagingException;

//Interface
public interface EmailService {

 // Method
 // To send a simple email
 String sendSimpleMail(EmailDetails details);

 // Method
 // To send an email with attachment
 String sendMailWithAttachment() throws MessagingException;
}