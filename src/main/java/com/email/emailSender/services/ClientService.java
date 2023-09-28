package com.email.emailSender.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.email.emailSender.ClientEntity;
import com.email.emailSender.EmailEntity;
import com.email.emailSender.dto.ClientDto;
import com.email.emailSender.enuns.StatusEmail;
import com.email.emailSender.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	EmailService emailService;
	
	public ClientEntity saveClient(ClientDto clientDto) {
		var clientEn = new ClientEntity();
		BeanUtils.copyProperties(clientDto, clientEn);
		ClientEntity clientId = clientRepository.save(clientEn);
		var email = new EmailEntity("Miguel","migueldummy08@gmail.com",clientDto.email(),"Welcome","Thanks For you registration active your account here http://localhost:8080/client?id="+clientId.getId(),LocalDateTime.now(),StatusEmail.sent);
		emailService.sendEmail(email);
		return clientEn;
		
	}
	public ClientEntity findById(Long id) {
		Optional<ClientEntity> client = clientRepository.findById(id);
		return client.get();
	}
	public void updateVerify(ClientEntity clientEntity) {
		clientRepository.save(clientEntity);
	}
}
