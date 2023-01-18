package com.grupo5.reto2.mail;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class EmailDetails {

	@NotNull(message = "el campo no puede ser nulo")
	@NotEmpty(message = "el campo no puede estar vacio")
	private String recipient;
	@NotNull(message = "el campo no puede ser nulo")
	@NotEmpty(message = "el campo no puede estar vacio")
	private String msgBody;
	@NotNull(message = "el campo no puede ser nulo")
	@NotEmpty(message = "el campo no puede estar vacio")
	private String subject;
	private String attachment;

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getMsgBody() {
		return msgBody;
	}

	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

}