package com.learnreactivespring.playground;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class FluxAndMonoWithTimeTest {
	
	@Test
	public void infiniteSequence() throws InterruptedException {
		Flux<Long> infiniteFlux = Flux.interval(Duration.ofMillis(100))
				.log();
		
		infiniteFlux
			.subscribe((element) -> System.out.println("Value is : " + element));
		
		Thread.sleep(3000);
	}
	
	@Test
	public void infiniteSequenceTest() throws InterruptedException {
		Flux<Long> infiniteFlux = Flux.interval(Duration.ofMillis(100))
				.take(3)
				.log();
		
		StepVerifier.create(infiniteFlux)
			.expectSubscription()
			.expectNext(0L, 1L, 2L)
			.verifyComplete();
	}
	
	@Test
	public void infiniteSequenceMap() throws InterruptedException {
		Flux<Integer> infiniteFlux = Flux.interval(Duration.ofMillis(100))
				.map(l -> new Integer(l.intValue()))
				.take(3)
				.log();
		
		StepVerifier.create(infiniteFlux)
			.expectSubscription()
			.expectNext(0, 1, 2)
			.verifyComplete();
	}
	
	@Test
	public void infiniteSequenceMapWithDelay() throws InterruptedException {
		Flux<Integer> infiniteFlux = Flux.interval(Duration.ofMillis(100))
				.delayElements(Duration.ofSeconds(1))
				.map(l -> new Integer(l.intValue()))
				.take(3)
				.log();
		
		StepVerifier.create(infiniteFlux)
			.expectSubscription()
			.expectNext(0, 1, 2)
			.verifyComplete();
	}
}
