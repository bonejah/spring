package br.com.springboot.bonejah;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Api(value="greeting") // Tell Swagger that this is an endpoint and REST should be documented 
@RestController
@RequestMapping("/greeting")
public class GreetingController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@ApiOperation(value = "Show Greeting Message")
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Greeting greeting(@RequestParam (value="name", defaultValue="World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
