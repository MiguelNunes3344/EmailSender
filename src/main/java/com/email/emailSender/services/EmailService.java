package com.email.emailSender.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.email.emailSender.EmailEntity;
import com.email.emailSender.enuns.StatusEmail;
import com.email.emailSender.repository.EmailRepository;

@Service
public class EmailService {

	
	@Autowired
	EmailRepository emailRepository;
	
	@Autowired
	JavaMailSender emailSender;
	
	public List<EmailEntity> findAll() {
		
		return null;
	}

	public void sendEmail(EmailEntity emailEntity) {
		emailEntity.setSendDateEmail(LocalDateTime.now());
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(emailEntity.getEmailFrom());
			message.setTo(emailEntity.getEmailTo());
			message.setSubject(emailEntity.getSubject());
			message.setText(emailEntity.getText());
			emailSender.send(message);
			emailEntity.setStatusEmail(StatusEmail.sent);
			emailRepository.save(emailEntity);
		} catch (MailException e) {
			emailEntity.setStatusEmail(StatusEmail.error);
		} finally {
			emailRepository.save(emailEntity);
		}
		
	}
}
