package com.grupo5.reto2.mail;

import jakarta.mail.MessagingException;


public interface EmailService {


 String sendSimpleMail(EmailDetails details);


 String sendMailWithAttachment() throws MessagingException;
}