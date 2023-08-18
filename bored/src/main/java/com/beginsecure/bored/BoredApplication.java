package com.beginsecure.bored;

import com.beginsecure.bored.model.Activity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BoredApplication {

	@Value("${api.url}")
	private String apiURL;

	private static final Logger log = LoggerFactory.getLogger(BoredApplication.class);
	public static void main(String[] args) {
		log.info("In main method");
		SpringApplication.run(BoredApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return results -> {
			Activity activity = restTemplate.getForObject(apiURL, Activity.class);
			log.info(activity.toString());
		};
	}

}
