package academy.devdojo.springboot2.integration;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

import academy.devdojo.springboot2.domain.Movie;
import academy.devdojo.springboot2.domain.DevDojoUser;
import academy.devdojo.springboot2.repository.AnimeRepository;
import academy.devdojo.springboot2.repository.DevDojoUserRepository;
import academy.devdojo.springboot2.requests.AnimePostRequestBody;
import academy.devdojo.springboot2.util.AnimeCreator;
import academy.devdojo.springboot2.util.AnimePostRequestBodyCreator;
import academy.devdojo.springboot2.wrapper.PageableResponse;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class AnimeControllerIT {

	@Autowired
	@Qualifier(value = "testRestTemplateRoleUser")
	private TestRestTemplate testRestTemplateRoleUser;
	
	@Autowired
	@Qualifier(value = "testRestTemplateRoleAdmin")
	private TestRestTemplate testRestTemplateRoleAdmin;
	
	@Autowired
	private AnimeRepository animeRepository;
	
	@Autowired
	private DevDojoUserRepository devDojoUserRepository;
	
	private static final DevDojoUser USER = DevDojoUser.builder()
			.name("DevDojo")
			.password("{bcrypt}$2a$10$ipQqPN1jJSPYfUX725QhreDo/k83Y8bodUUk865jCkmAP7SFA5G.C")
			.username("devdojo")
			.authorities("ROLE_USER")
			.build();
	
	private static final DevDojoUser ADMIN = DevDojoUser.builder()
			.name("Bruno")
			.password("{bcrypt}$2a$10$ipQqPN1jJSPYfUX725QhreDo/k83Y8bodUUk865jCkmAP7SFA5G.C")
			.username("bonejah")
			.authorities("ROLE_ADMIN, ROLE_USER")
			.build();
	
	@TestConfiguration
	@Lazy
	static class Config {
		
		@Bean(name = "testRestTemplateRoleUser")
		public TestRestTemplate testRestTemplateRoleUserCreator(@Value("${local.server.port}") int port) {
			RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder()
					.rootUri("http://localhost:" + port)
					.basicAuthentication("devdojo", "academy");
			
			return new TestRestTemplate(restTemplateBuilder);
		}
		
		@Bean(name = "testRestTemplateRoleAdmin")
		public TestRestTemplate testRestTemplateRoleAdminCreator(@Value("${local.server.port}") int port) {
			RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder()
					.rootUri("http://localhost:" + port)
					.basicAuthentication("bonejah", "academy");
			
			return new TestRestTemplate(restTemplateBuilder);
		}
		
	}
	
	@Test
	@DisplayName("list returns list of animes inside page object when successful")
	void list_ReturnsListOfAnimesInsidePageObject_WhenSuccessful() {
		devDojoUserRepository.save(USER);
		
		Movie savedAnime = animeRepository.save(AnimeCreator.createAnimeToBeSaved());
		
		PageableResponse<Movie> animePage = testRestTemplateRoleUser.exchange("/animes", HttpMethod.GET, null, 
				new ParameterizedTypeReference<PageableResponse<Movie>>() {
		}).getBody();

		Assertions.assertThat(animePage).isNotNull();

		Assertions.assertThat(animePage.toList()).isNotEmpty().hasSize(1);

		Assertions.assertThat(animePage.toList().get(0).getName()).isEqualTo(savedAnime.getName());
	}

	@Test
	@DisplayName("listAll returns list of animes when successful")
	void listAll_ReturnsListOfAnimes_WhenSuccessful() {
		devDojoUserRepository.save(USER);
		
		Movie savedAnime = animeRepository.save(AnimeCreator.createAnimeToBeSaved());
		
		List<Movie> animes = testRestTemplateRoleUser.exchange("/animes/all", HttpMethod.GET, null, 
				new ParameterizedTypeReference<List<Movie>>() {
		}).getBody();

		Assertions.assertThat(animes)
			.isNotNull()
			.isNotEmpty()
			.hasSize(1);

		Assertions.assertThat(animes.get(0).getName()).isEqualTo(savedAnime.getName());
	}

	@Test
	@DisplayName("findById returns anime when successful")
	void findById_ReturnsAnime_WhenSuccessful() {
		devDojoUserRepository.save(USER);
		
		Movie savedAnime = animeRepository.save(AnimeCreator.createAnimeToBeSaved());
		
		Long idExpected = savedAnime.getId();
	
		Movie anime = testRestTemplateRoleUser.getForObject("/animes/{id}", Movie.class, idExpected);
		
		Assertions.assertThat(anime).isNotNull();
		
		Assertions.assertThat(anime.getId()).isEqualTo(idExpected);
	}

	@Test
	@DisplayName("findByName returns a list of anime when successful")
	void findByName_ReturnsListOfAnime_WhenSuccessful() {
		devDojoUserRepository.save(USER);
		
		Movie savedAnime = animeRepository.save(AnimeCreator.createAnimeToBeSaved());
		
		String expectedName = savedAnime.getName();
		String url = String.format("/animes/find?name=%s", expectedName);

		List<Movie> animes = testRestTemplateRoleUser.exchange(url, HttpMethod.GET, null, 
				new ParameterizedTypeReference<List<Movie>>() {
		}).getBody();

		Assertions.assertThat(animes).isNotNull().isNotEmpty().hasSize(1);

		Assertions.assertThat(animes.get(0).getName()).isEqualTo(expectedName);
	}
	
	@Test
	@DisplayName("findByName returns an empty list of anime when anime is not found")
	void findByName_ReturnsAnEmptyListOfAnime_WhenIsNotFound() {
		devDojoUserRepository.save(USER);
		
		List<Movie> animes = testRestTemplateRoleUser.exchange("/animes/find?name=xpto", HttpMethod.GET, null, 
				new ParameterizedTypeReference<List<Movie>>() {
		}).getBody();

		Assertions.assertThat(animes)
			.isNotNull()
			.isEmpty();
	}
	
	@Test
	@DisplayName("save returns anime when successful")
	void save_ReturnsAnime_WhenSuccessful() {
		devDojoUserRepository.save(USER);
		
		AnimePostRequestBody animePostRequestBody = AnimePostRequestBodyCreator.createAnimePostRequestBody();
		
		ResponseEntity<Movie> responseEntity = testRestTemplateRoleUser.postForEntity("/animes", animePostRequestBody, Movie.class);

		Assertions.assertThat(responseEntity).isNotNull();
		Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		Assertions.assertThat(responseEntity.getBody()).isNotNull();
		Assertions.assertThat(responseEntity.getBody().getId()).isNotNull();
	}
	
	@Test
	@DisplayName("update returns anime when successful")
	void update_ReturnsAnime_WhenSuccessful() {
		devDojoUserRepository.save(USER);
		
		Movie savedAnime = animeRepository.save(AnimeCreator.createAnimeToBeSaved());
		savedAnime.setName("new name");
		
		ResponseEntity<Void> responseEntity = testRestTemplateRoleUser.exchange("/animes", HttpMethod.PUT, new HttpEntity<>(savedAnime), Void.class);

		Assertions.assertThat(responseEntity).isNotNull();
		Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
	}
	
	@Test
	@DisplayName("delete removes anime when successful")
	void delete_RemovesAnime_WhenSuccessful() {
		devDojoUserRepository.save(ADMIN);
		
		Movie savedAnime = animeRepository.save(AnimeCreator.createAnimeToBeSaved());
		
		ResponseEntity<Void> responseEntity = testRestTemplateRoleAdmin.exchange("/animes/admin/{id}", HttpMethod.DELETE, null, Void.class, savedAnime.getId());

		Assertions.assertThat(responseEntity).isNotNull();
		Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
	}
	
	@Test
	@DisplayName("delete returns 403 when user is not admin")
	void delete_Return403_WhenUserIsNotAdmin() {
		devDojoUserRepository.save(USER);
		
		Movie savedAnime = animeRepository.save(AnimeCreator.createAnimeToBeSaved());
		
		ResponseEntity<Void> responseEntity = testRestTemplateRoleUser.exchange("/animes/admin/{id}", HttpMethod.DELETE, null, Void.class, savedAnime.getId());

		Assertions.assertThat(responseEntity).isNotNull();
		Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.FORBIDDEN);
	}
	
}
