package com.bonejah.festa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.bonejah.festa"})
@SpringBootApplication
public class GestaFestaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaFestaApplication.class, args);
	}
}
