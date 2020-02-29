package com.learnreactivespring.playground;

import java.time.Duration;

import org.junit.Test;

import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

public class ColdAndHotPublisherTest {
	
	@Test
	public void couldPublisherTest() throws InterruptedException {
		Flux<String> stringFLux = Flux.just("A", "B", "C", "D", "E", "F")
			.delayElements(Duration.ofSeconds(1));
		
		stringFLux.subscribe(s -> System.out.println("Subscriber 1 : " + s));
		
		Thread.sleep(2000);
		
		stringFLux.subscribe(s -> System.out.println("Subscriber 2 : " + s));
		
		Thread.sleep(4000);
	}
	
	@Test
	public void hotPublisherTest() throws InterruptedException {
		Flux<String> stringFLux = Flux.just("A", "B", "C", "D", "E", "F")
			.delayElements(Duration.ofSeconds(1));
		
		ConnectableFlux<String> connectableFlux = stringFLux.publish();
		connectableFlux.connect();
		connectableFlux.subscribe(s -> System.out.println("Subscriber 1 : " + s));
		
		Thread.sleep(3000);
		
		connectableFlux.subscribe(s -> System.out.println("Subscriber 2 : " + s));
		
		Thread.sleep(4000);
	}

}
