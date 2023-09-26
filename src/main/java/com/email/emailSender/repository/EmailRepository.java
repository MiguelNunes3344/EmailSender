package com.email.emailSender.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.email.emailSender.EmailEntity;

public interface EmailRepository extends JpaRepository<EmailEntity, Long> {

}
