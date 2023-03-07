package com.project.theglory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ThegloryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThegloryApplication.class, args);
	}

}
