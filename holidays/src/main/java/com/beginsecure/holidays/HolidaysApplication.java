package com.beginsecure.holidays;

import com.beginsecure.holidays.model.Holiday;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootApplication
public class HolidaysApplication {
	@Value("${api.url}")
	private String apiURL;

	private static final Logger log = LoggerFactory.getLogger(HolidaysApplication.class);
	public static void main(String[] args) {
		log.info("In main method");
		SpringApplication.run(HolidaysApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return new CommandLineRunner() {
			@Override
			public void run(String... results) throws Exception {
				//for (String holidayString : results) {
//				Holiday holiday = restTemplate.getForObject(apiURL, Holiday.class);
//				log.info(holiday.toString());
				//}
				ResponseEntity<List<Holiday>> holidayResponse =
						restTemplate.exchange(apiURL,
								HttpMethod.GET, null, new ParameterizedTypeReference<List<Holiday>>() {
								});
				List<Holiday> holidays = holidayResponse.getBody();
				for (Holiday holiday : holidays) {
					log.info(holiday.toString());
				}
			}

		};

	}


}
