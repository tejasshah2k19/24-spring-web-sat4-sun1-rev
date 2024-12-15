package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailerService {

	@Autowired
	JavaMailSender javaMailSender;

	public void sendMailForOtp(String email, String otp) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("Otp For Change Password");
		message.setText("Below is the otp to upadate the password : " + otp);
		message.setFrom("tejasshah2k19@gmail.com");
		javaMailSender.send(message);
	}
}
