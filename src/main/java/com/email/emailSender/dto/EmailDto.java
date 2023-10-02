package com.email.emailSender.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;



public record EmailDto(
		@NotBlank String ownerRef,
		@NotBlank @Email String emailFrom,
		@NotBlank @Email String emailTo,
		String subject,
		@NotBlank String text
		) {

}
