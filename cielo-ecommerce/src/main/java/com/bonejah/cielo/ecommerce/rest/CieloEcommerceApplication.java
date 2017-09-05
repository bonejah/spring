package com.bonejah.cielo.ecommerce.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.bonejah.cielo.ecommerce")
@SpringBootApplication
public class CieloEcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CieloEcommerceApplication.class, args);
	}
}
