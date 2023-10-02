package com.email.emailSender.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ClientDto(@NotBlank String name,@NotBlank @Email String email,@NotBlank String password) {

}
