package com.email.emailSender.controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.email.emailSender.ClientEntity;
import com.email.emailSender.dto.ClientDto;
import com.email.emailSender.services.ClientService;
import com.email.emailSender.services.EmailService;

@RestController
@RequestMapping(value = "client")
public class ClientController {

	
	@Autowired
	EmailService emailService;
	
	@Autowired
	ClientService clientService;
	
	@PostMapping
	public ResponseEntity<ClientEntity> saveClient(@RequestBody @Valid ClientDto clientDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(clientService.saveClient(clientDto));
		
	}
	@GetMapping
	public String verifyClient(@RequestParam(name = "id")Long id) {
		ClientEntity client = clientService.findById(id);
		client.setVerified(true);
		clientService.updateVerify(client);
		return "Your account has been verified";
	}
	@GetMapping("/register")
	public ModelAndView index() {
		ModelAndView index = new ModelAndView("index");
		return index;
	}

}
