package com.larina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.larina.model") 
@EnableJpaRepositories("com.larina.repositories")
public class StandsStateApplication {

	public static void main(String[] args) {
		SpringApplication.run(StandsStateApplication.class, args);
	}

}
