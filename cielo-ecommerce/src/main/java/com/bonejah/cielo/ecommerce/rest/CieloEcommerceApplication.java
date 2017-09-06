package com.bonejah.cielo.ecommerce.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.bonejah.cielo.ecommerce"})
@EnableAutoConfiguration
public class CieloEcommerceApplication {
	public static void main(String[] args) {
		SpringApplication.run(CieloEcommerceApplication.class, args);
	}
}
