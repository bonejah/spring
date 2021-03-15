package academy.devdojo.springboot2.util;

import academy.devdojo.springboot2.domain.Movie;

public class AnimeCreator {
	

	public static Movie createAnimeToBeSaved() {
		return Movie.builder()
				.name("Hajime no Ippo")
				.build();
	}
	
	public static Movie createValidAnime() {
		return Movie.builder()
				.name("Hajime no Ippo")
				.id(1L)
				.build();
	}
	
	public static Movie createValidUpdatedAnime() {
		return Movie.builder()
				.name("Hajime no Ippo")
				.id(1L)
				.build();
	}

}
