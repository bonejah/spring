package academy.devdojo.springboot2.repository;

import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.util.AnimeCreator;

@DataJpaTest
@DisplayName("Tests for AnimeRespository")
public class AnimeRepositoryTest {
	
	@Autowired
	private AnimeRepository animeRepository;

	@Test
	@DisplayName("Save persists anime when Successful")
	public void save_PersistsAnime_WhenSuccessful() {
		Anime animeToBeSaved = AnimeCreator.createAnimeToBeSaved();
		
		Anime animeSaved = this.animeRepository.save(animeToBeSaved);
		
		Assertions.assertThat(animeSaved).isNotNull();
		Assertions.assertThat(animeSaved.getId()).isNotNull();
		Assertions.assertThat(animeSaved.getName()).isEqualTo(animeToBeSaved.getName());
	}
	
	@Test
	@DisplayName("Save updates anime when Successful")
	public void save_UpdatesAnime_WhenSuccessful() {
		Anime animeToBeSaved = AnimeCreator.createAnimeToBeSaved();
		
		Anime animeSaved = this.animeRepository.save(animeToBeSaved);
		
		animeSaved.setName("Overload");
		
		Anime animeUpdated = this.animeRepository.save(animeSaved);
		
		Assertions.assertThat(animeUpdated).isNotNull();
		Assertions.assertThat(animeUpdated.getId()).isNotNull();
		Assertions.assertThat(animeUpdated.getName()).isEqualTo(animeSaved.getName());
	}
	
	@Test
	@DisplayName("Delete removes anime when Successful")
	public void delete_RemovesAnime_WhenSuccessful() {
		Anime animeToBeSaved = AnimeCreator.createAnimeToBeSaved();
		
		Anime animeSaved = this.animeRepository.save(animeToBeSaved);
		
		this.animeRepository.delete(animeSaved);
		
		Optional<Anime> animeOptional = this.animeRepository.findById(animeSaved.getId());
		
		Assertions.assertThat(animeOptional.isEmpty()).isTrue();
	}
	

	@Test
	@DisplayName("Find By Name returns list of anime when Successful")
	public void findByName_ReturnsListOfAnime_WhenSuccessful() {
		Anime animeToBeSaved = AnimeCreator.createAnimeToBeSaved();
		
		Anime animeSaved = this.animeRepository.save(animeToBeSaved);
		
		String name = animeSaved.getName();
		
		List<Anime> animes = this.animeRepository.findByName(name);
		
		Assertions.assertThat(animes).isNotEmpty().contains(animeSaved);
	}
	
	@Test
	@DisplayName("Find By Name returns empty list when no anime is found")
	public void findByName_ReturnsEmptyList_WhenAnimeIsNotFound() {
		List<Anime> animes = this.animeRepository.findByName("Thunder Cats");
		
		Assertions.assertThat(animes).isEmpty();
	}
	
	@Test
	@DisplayName("Save throw ConstraintViolationException when name is empty")
	public void save_ThrowsConstraintViolationException_WhenNameIsEmpty() {
//		Assertions.assertThatThrownBy(() -> this.animeRepository.save(new Anime()))
//			.isInstanceOf(ConstraintViolationException.class);
		
		Assertions.assertThatExceptionOfType(ConstraintViolationException.class)
			.isThrownBy(() -> this.animeRepository.save(new Anime()))
			.withMessageContaining("The anime name cannot be empty");
	}
	
}
