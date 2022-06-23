package com.kys95.checkstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CheckstudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckstudyApplication.class, args);
	}

}
