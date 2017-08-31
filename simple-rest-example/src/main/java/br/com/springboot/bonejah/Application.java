package br.com.springboot.bonejah;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

@Configuration // Defines the class as a configuration class
@EnableAutoConfiguration // Enable the AutoConfiguration
@EnableSwagger // Enable Swagger
@ComponentScan(basePackages = {"br.com.springboot.bonejah"}) // Scan all packages with patter br.com.springboot.bonejah
@SpringBootApplication
public class Application {
	
	// Inject an instance of SpringSwaggerConfig
	@Autowired
	private SpringSwaggerConfig swaggerConfig;
		
	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args); I changed this line because we use the line below
		new SpringApplicationBuilder(Application.class).web(true).run(args);
	}
	
	@Bean
    public SwaggerSpringMvcPlugin groupOnePlugin() {
		//Adds Swagger settings to SwaggerSpringMvcPlugin
		return new SwaggerSpringMvcPlugin(swaggerConfig)
           .apiInfo(apiInfo()) //Added the properties of configuration
           .includePatterns("/person.*?", "/greeting.*?") //Enable Swagger for our 2 endpoints
           .swaggerGroup("admin");
    }
     
    private ApiInfo apiInfo() {
       ApiInfo apiInfo = new ApiInfo(
    		   //Contact settings, license etc. do not need to be defined
             "Swagger With Spring Boot",
             "This is a simple application to demonstrate how to work with Swagger in Spring Boot project!",
             "Free to use and mess around",
             "erudio@gmail.com",
             "Open Licence",
             "myemail@gmail.com"
       );
       return apiInfo;
    }
}
