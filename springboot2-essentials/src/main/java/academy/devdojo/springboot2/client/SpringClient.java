package academy.devdojo.springboot2.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import academy.devdojo.springboot2.domain.Movie;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class SpringClient {

	public static void main(String[] args) {
//		ResponseEntity<Anime> responseEnity = new RestTemplate().getForEntity("http://localhost:8087/animes/2", Anime.class);
//		log.info("Response Entity: " + responseEnity);
		
//		Anime responseObject = new RestTemplate().getForObject("http://localhost:8087/animes/{id}", Anime.class, 2);
//		log.info("Response ForObject: " + responseObject);
		
//		Anime[] responseList = new RestTemplate().getForObject("http://localhost:8087/animes/all", Anime[].class);
//		log.info("Response ForObject: " + Arrays.toString(responseList));
		
//		ResponseEntity<List<Anime>> responseExchange = new RestTemplate().exchange("http://localhost:8087/animes/all", HttpMethod.GET, null,
//				new ParameterizedTypeReference<List<Anime>>() {});
//		log.info("Response Exchange: " + responseExchange);
		
//		Anime kingdom = Anime.builder().name("Kingdom").build();
//		Anime anime = new RestTemplate().postForObject("http://localhost:8087/animes", kingdom, Anime.class);
//		log.info("Anime: " + anime);
		
		Movie samuraiChamploo = Movie.builder().name("Samurai Champloo").build();
		
		ResponseEntity<Movie> samuraiChamplooSaved = new RestTemplate().exchange(
				"http://localhost:8087/animes", 
				HttpMethod.POST, 
				new HttpEntity<>(samuraiChamploo, createJsonHeader()),
				Movie.class);
		
		log.info("Response PostExchange {} ",  samuraiChamplooSaved);
		
		
		Movie animeToBeUpdated = samuraiChamplooSaved.getBody();
		animeToBeUpdated.setName("Samurai Champloo 2");
		
		ResponseEntity<Void> samuraiChamplooUpdated = new RestTemplate().exchange(
				"http://localhost:8087/animes", 
				HttpMethod.PUT, 
				new HttpEntity<>(animeToBeUpdated, createJsonHeader()),
				Void.class);
		
		log.info("Response PutExchange {} ",  samuraiChamplooUpdated);
		
		ResponseEntity<Void> samuraiChamplooToBeDeleted = new RestTemplate().exchange(
				"http://localhost:8087/animes/{id}", 
				HttpMethod.DELETE, 
				null,
				Void.class, 
				animeToBeUpdated.getId());
		
		log.info("Response DeleteExchange {} ",  samuraiChamplooToBeDeleted);
		
	}
	
	private static HttpHeaders createJsonHeader() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return httpHeaders;
	}
	
}
