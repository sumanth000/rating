package com.rating.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = {
	    "com.rating.controller",
	    "com.rating.repository",
	    "com.rating.service"
	})
@EnableJpaRepositories(basePackages = "com.rating.repository")
	@EntityScan(basePackages = "com.rating.entity")
public class SpringStarter1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringStarter1Application.class, args);
	}

}
