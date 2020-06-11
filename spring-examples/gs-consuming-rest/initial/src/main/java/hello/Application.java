package hello;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	public CommandLineRunner run() {
//		SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
//		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("BCOHPROXY01", 8080));
//		clientHttpRequestFactory.setProxy(proxy);
//		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
		
		RestTemplate restTemplate = new RestTemplate();
		return args -> {
			Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
			log.info(quote.toString());
		};
	}
}
