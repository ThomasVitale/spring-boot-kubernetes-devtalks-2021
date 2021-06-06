package com.thomasvitale.demonative;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ConfigurationPropertiesScan
public class DemoNativeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoNativeApplication.class, args);
	}
}

@RestController
class DemoController {
	private static final Logger log = LoggerFactory.getLogger(DemoController.class);
	private final DemoProperties demoProperties;

	DemoController(DemoProperties demoProperties) {
		this.demoProperties = demoProperties;
	}

	@GetMapping("/")
	public Mono<String> getMessage() {
		log.info("Message requested");
		return Mono.just(demoProperties.getMessage());
	}
}

@ConfigurationProperties(prefix = "demo")
class DemoProperties {

	private String message = "Welcome to Spring Native!";

	String getMessage() {
		return message;
	}

	void setMessage(String message) {
		this.message = message;
	}
}
