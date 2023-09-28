package com.email.emailSender.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public record ClientDto(@NotBlank String name,@NotBlank @Email String email,@NotBlank String password) {

}
