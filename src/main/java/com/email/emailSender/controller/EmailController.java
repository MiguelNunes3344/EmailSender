package com.email.emailSender.controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.email.emailSender.EmailEntity;
import com.email.emailSender.dto.EmailDto;
import com.email.emailSender.services.EmailService;

@RestController
public class EmailController {

	
	@Autowired
	EmailService emailSerivce;
	
	@PostMapping
	public ResponseEntity<EmailDto> sendEmail(@RequestBody @Valid EmailDto EmailDto) {
		var emailEntity = new EmailEntity();
		BeanUtils.copyProperties(EmailDto, emailEntity,"id");
		emailSerivce.sendEmail(emailEntity);
		return ResponseEntity.ok().build();
	}
}
