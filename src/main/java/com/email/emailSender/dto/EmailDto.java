package com.email.emailSender.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


public record EmailDto(
		@NotBlank String ownerRef,
		@NotBlank @Email String emailFrom,
		@NotBlank @Email String emailTo,
		String subject,
		@NotBlank String text
		) {

}
