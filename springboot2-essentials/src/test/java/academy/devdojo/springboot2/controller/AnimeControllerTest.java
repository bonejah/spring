package academy.devdojo.springboot2.controller;

import java.util.Collections;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import academy.devdojo.springboot2.domain.Movie;
import academy.devdojo.springboot2.requests.AnimePostRequestBody;
import academy.devdojo.springboot2.requests.AnimePutRequestBody;
import academy.devdojo.springboot2.service.AnimeService;
import academy.devdojo.springboot2.util.AnimeCreator;
import academy.devdojo.springboot2.util.AnimePostRequestBodyCreator;
import academy.devdojo.springboot2.util.AnimePutRequestBodyCreator;
import academy.devdojo.springboot2.util.DateUtil;

@ExtendWith(SpringExtension.class)
public class AnimeControllerTest {

	@InjectMocks
	private AnimeController animeController;

	@Mock
	private DateUtil dateUtil;

	@Mock
	private AnimeService animeServiceMock;

	@BeforeEach
	void setup() {
		PageImpl<Movie> animePage = new PageImpl<>(List.of(AnimeCreator.createValidAnime()));

		BDDMockito.when(animeServiceMock.listAll(ArgumentMatchers.any())).thenReturn(animePage);

		BDDMockito.when(animeServiceMock.listAllNonPageable()).thenReturn(List.of(AnimeCreator.createValidAnime()));

		BDDMockito.when(animeServiceMock.findById(ArgumentMatchers.anyLong()))
				.thenReturn(AnimeCreator.createValidAnime());

		BDDMockito.when(animeServiceMock.findByName(ArgumentMatchers.anyString()))
				.thenReturn(List.of(AnimeCreator.createValidAnime()));
		
		BDDMockito.when(animeServiceMock.save(ArgumentMatchers.any(AnimePostRequestBody.class)))
			.thenReturn(AnimeCreator.createValidAnime());
		
		BDDMockito.doNothing().when(animeServiceMock).update(ArgumentMatchers.any(AnimePutRequestBody.class));
		
		BDDMockito.doNothing().when(animeServiceMock).delete(ArgumentMatchers.anyLong());
	}

	@Test
	@DisplayName("list returns list of animes inside page object when successful")
	void list_ReturnsListOfAnimesInsidePageObject_WhenSuccessful() {
		String expectedName = AnimeCreator.createValidAnime().getName();

		Page<Movie> animePage = animeController.list(null).getBody();

		Assertions.assertThat(animePage).isNotNull();

		Assertions.assertThat(animePage.toList()).isNotEmpty().hasSize(1);

		Assertions.assertThat(animePage.toList().get(0).getName()).isEqualTo(expectedName);
	}

	@Test
	@DisplayName("listAll returns list of animes when successful")
	void listAll_ReturnsListOfAnimes_WhenSuccessful() {
		String expectedName = AnimeCreator.createValidAnime().getName();

		List<Movie> animes = animeController.listAll().getBody();

		Assertions.assertThat(animes).isNotNull().isNotEmpty().hasSize(1);

		Assertions.assertThat(animes.get(0).getName()).isEqualTo(expectedName);
	}

	@Test
	@DisplayName("findById returns anime when successful")
	void findById_ReturnsAnime_WhenSuccessful() {
		Long expectedId = AnimeCreator.createValidAnime().getId();

		Movie anime = animeController.findById(1L).getBody();

		Assertions.assertThat(anime).isNotNull();

		Assertions.assertThat(anime.getId()).isEqualTo(expectedId);
	}

	@Test
	@DisplayName("findByName returns a list of anime when successful")
	void findByName_ReturnsListOfAnime_WhenSuccessful() {
		String expectedName = AnimeCreator.createValidAnime().getName();

		List<Movie> animes = animeController.findByName("anime").getBody();

		Assertions.assertThat(animes).isNotNull().isNotEmpty().hasSize(1);

		Assertions.assertThat(animes.get(0).getName()).isEqualTo(expectedName);
	}
	
	@Test
	@DisplayName("findByName returns an empty list of anime when anime is not found")
	void findByName_ReturnsAnEmptyListOfAnime_WhenIsNotFound() {
		BDDMockito.when(animeServiceMock.findByName(ArgumentMatchers.anyString()))
			.thenReturn(Collections.emptyList());

		List<Movie> animes = animeController.findByName("anime").getBody();

		Assertions.assertThat(animes).isNotNull().isEmpty();		
	}
	
	@Test
	@DisplayName("save returns anime when successful")
	void save_ReturnsAnime_WhenSuccessful() {
		Movie anime = animeController.save(AnimePostRequestBodyCreator.createAnimePostRequestBody()).getBody();

		Assertions.assertThat(anime).isNotNull().isEqualTo(AnimeCreator.createValidAnime());
	}
	
	@Test
	@DisplayName("update returns anime when successful")
	void update_ReturnsAnime_WhenSuccessful() {
		Assertions.assertThatCode(() -> animeController.update(AnimePutRequestBodyCreator.createAnimePutRequestBody()))
			.doesNotThrowAnyException();
		
		ResponseEntity<Void> entity = animeController.update(AnimePutRequestBodyCreator.createAnimePutRequestBody());
		
		Assertions.assertThat(entity).isNotNull();
		
		Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
	}
	
	@Test
	@DisplayName("delete removes anime when successful")
	void delete_RemovesAnime_WhenSuccessful() {
		Assertions.assertThatCode(() -> animeController.delete(1L)).doesNotThrowAnyException();
		
		ResponseEntity<Void> entity = animeController.delete(1L);
		
		Assertions.assertThat(entity).isNotNull();
		
		Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
	}

}
