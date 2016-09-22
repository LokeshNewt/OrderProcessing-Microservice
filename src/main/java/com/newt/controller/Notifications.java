package com.newt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class Notifications {

	private JavaMailSender javaMailSender;

	 
	 
	 @Autowired
	 public Notifications(JavaMailSender javaMailSender) {
	 super();
		 this.javaMailSender = javaMailSender;
	 }
	 public void sendNotification(String Message) throws MailException
	 {
	  SimpleMailMessage mail = new SimpleMailMessage();
	  mail.setFrom("kumar.ch035@gamil.com");
	  mail.setTo("kumar.ch035@gmail.com");
	  mail.setSubject(Message);
	  mail.setText("Your order is not processing some problems.....");	  
	  javaMailSender.send(mail);
	   
	  
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
@Autowired
private JavaMailSender javaMailSender;

 @Autowired
 public Notifications(JavaMailSender javaMailSender) {
  this.javaMailSender = javaMailSender;
 }
 
 public Notifications() {
	// TODO Auto-generated constructor stub
}

public void sendNotification(String Message) throws MailException
 {
  SimpleMailMessage mail = new SimpleMailMessage();
  mail.setFrom("kumar.ch035@gamil.com");
  mail.setTo("kumar.ch035@gmail.com");
  mail.setSubject(Message);
  mail.setText("blabla");
  
  javaMailSender.send(mail);
  

}*/
 
}
