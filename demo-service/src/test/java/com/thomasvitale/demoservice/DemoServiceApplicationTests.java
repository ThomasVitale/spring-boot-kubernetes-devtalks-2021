package com.thomasvitale.demoservice;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoServiceApplicationTests {

	@Autowired
	private WebTestClient webClient;

	@Test
	void whenGetBooksThenReturn() {
		webClient
				.get().uri("/")
				.exchange()
				.expectStatus().is2xxSuccessful()
				.expectBody(String.class).isEqualTo("Spring Boot in the cloud and beyond!");
	}

}
