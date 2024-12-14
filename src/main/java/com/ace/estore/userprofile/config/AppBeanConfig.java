package com.ace.estore.userprofile.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class AppBeanConfig {

	@Bean
	RestTemplate rest() {
		return new RestTemplate();
	}

	@Bean
	@Primary
	ObjectMapper mapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		return new ObjectMapper();
	}
}
