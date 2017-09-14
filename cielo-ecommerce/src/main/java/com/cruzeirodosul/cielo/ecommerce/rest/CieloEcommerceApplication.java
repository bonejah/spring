package com.cruzeirodosul.cielo.ecommerce.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan(basePackages = {"com.cruzeirodosul.cielo.ecommerce"})
@EnableAutoConfiguration
public class CieloEcommerceApplication {
	public static void main(String[] args) {
		SpringApplication.run(CieloEcommerceApplication.class, args);
	}
}
