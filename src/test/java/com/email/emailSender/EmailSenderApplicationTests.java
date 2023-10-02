package com.email.emailSender;




import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;


import com.email.emailSender.dto.ClientDto;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class EmailSenderApplicationTests {
	
	@Autowired
	WebTestClient webTestClient;
	@Test
	void testClientSuccess() {
		ClientDto client = new ClientDto("Michael", "michael@gmail.com","test123");
		webTestClient
		.post()
		.uri("/client")
		.bodyValue(client)
		.exchange()
		.expectStatus()
		.isCreated()
		.expectBody()
			.jsonPath("$.name").isEqualTo(client.name())
			.jsonPath("$.email").isEqualTo(client.email())
			.jsonPath("$.password").isEqualTo(client.password());
	}
	
	
	@Test
	void testClientFailure() {
		ClientDto client = new ClientDto("","email@gmail.com","test123");
		webTestClient
		.post()
		.uri("/client")
		.bodyValue(client)
		.exchange()
		.expectStatus()
		.isBadRequest();
	}

}
