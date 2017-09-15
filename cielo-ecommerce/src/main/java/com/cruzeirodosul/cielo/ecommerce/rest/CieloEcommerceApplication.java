package com.cruzeirodosul.cielo.ecommerce.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.cruzeirodosul.cielo.ecommerce.*"})
@EnableJpaRepositories("com.cruzeirodosul.cielo.ecommerce.repository")
@EntityScan({"com.cruzeirodosul.cielo.ecommerce.model", "com.cruzeirodosul.cielo.ecommerce.sdk"})
public class CieloEcommerceApplication {
	public static void main(String[] args) {
		SpringApplication.run(CieloEcommerceApplication.class, args);
	}
}
