package com.grupo5.reto2.mail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.grupo5.reto2.security.CifradoAES;

import java.util.Properties;

@Configuration
public class MailSenderConfig {

	CifradoAES cifradoAES = new CifradoAES();
	
	String user=cifradoAES.descifrarTexto("Clave","user");
	String pass=cifradoAES.descifrarTexto("Clave","pass");
	
    @Bean("javaMailSender")
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost("smtp.gmail.com");
        sender.setPort(587);
        sender.setUsername(user);
        sender.setPassword(pass);

        Properties props = sender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return sender;
    }
}