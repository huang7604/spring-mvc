package com.springmvc.server;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MailSend {
	
	@Value("${mail.starttls.enable}")
	private String starttlsEnable;
	@Value("${mail.auth}")
	private String auth;
	@Value("${mail.port}")
	private String port;
	@Value("${mail.host}")
	private String host;
	@Value("${mail.from}")
	private String from;
	@Value("${mail.password}")
	private String password;
	public void sendMail(Address[] toAddress,String subject,String text) throws Exception{
		Authenticator au=new Authenticator(){
			@Override
			protected  PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(from,password);
			}
		};
		
		Session session=Session.getDefaultInstance(getProperties(), au);
		Message message=new MimeMessage(session);
		message.setFrom(new InternetAddress(from));
		message.setSubject(subject);
		message.setText(text);
		message.setRecipients(Message.RecipientType.TO, toAddress);
		Transport.send(message);
		
	}
	
	
	private Properties getProperties(){
		Properties properties=new Properties();
		properties.put("mail.smtp.starttls.enable",starttlsEnable);
		properties.put("mail.smtp.auth", auth);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.host", host);
		return properties;
	}

}
