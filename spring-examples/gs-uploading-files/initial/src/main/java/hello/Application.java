package hello;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import hello.storage.StorageProperties;
import hello.storage.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    CommandLineRunner init(StorageService storageService) {
    	return (args) -> {
    		storageService.deleteAll();
    		storageService.init();
    	};
    }
}
