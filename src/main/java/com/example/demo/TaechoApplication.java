package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo", "com.mysite.sbb"})
@EnableJpaRepositories(basePackages = {"com.mysite.sbb"})
@EntityScan(basePackages = {"com.mysite.sbb"})
public class TaechoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaechoApplication.class, args);
	}

}
