package com.email.emailSender.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.email.emailSender.ClientEntity;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

}
