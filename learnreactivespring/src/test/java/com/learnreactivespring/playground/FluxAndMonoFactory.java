package com.learnreactivespring.playground;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import org.junit.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class FluxAndMonoFactory {
	
	List<String> names = Arrays.asList("adam", "anna", "jack", "jenny");
	
	@Test
	public void fluxUsingIterable() {
		Flux<String> namesFlux = Flux.fromIterable(names);
		StepVerifier.create(namesFlux.log())
			.expectNext("adam", "anna", "jack", "jenny")
			.verifyComplete();
	}
	
	@Test
	public void fluxUsingArray() {
		String [] namesArray = new String[] {"adam", "anna", "jack", "jenny"}; 
		
		Flux<String> namesFlux = Flux.fromArray(namesArray);
		StepVerifier.create(namesFlux.log())
			.expectNext("adam", "anna", "jack", "jenny")
			.verifyComplete();
	}
	
	@Test
	public void fluxUsingStream() {
		Flux<String> namesStream = Flux.fromStream(names.stream());
		
		StepVerifier.create(namesStream.log())
			.expectNext("adam", "anna", "jack", "jenny")
			.verifyComplete();
	}

	@Test
	public void monoUsingJustOrEmpty() {
		Mono<String> mono = Mono.justOrEmpty(null);
		
		StepVerifier.create(mono.log())
			.verifyComplete();
	}
	
	@Test
	public void monoUsingSupplier() {
		Supplier<String> stringSupplier = () -> "adam";
		
		System.out.println(stringSupplier.get());
		
		Mono<String> monoSupplier = Mono.fromSupplier(stringSupplier);
		StepVerifier.create(monoSupplier.log())
			.expectNext("adam")
			.verifyComplete();
	}
	
	@Test
	public void fluxUsingRange() {
		Flux<Integer> range = Flux.range(1, 5);
		
		StepVerifier.create(range)
			.expectNext(1,2 ,3,4,5)
			.verifyComplete();
	}

}
