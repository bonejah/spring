package academy.devdojo.springboot2.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import academy.devdojo.springboot2.domain.Movie;
import academy.devdojo.springboot2.exception.BadRequestException;
import academy.devdojo.springboot2.mapper.AnimeMapper;
import academy.devdojo.springboot2.repository.AnimeRepository;
import academy.devdojo.springboot2.requests.AnimePostRequestBody;
import academy.devdojo.springboot2.requests.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor
public class AnimeService {
	
	private final AnimeRepository animeRepository;
	
	public Page<Movie> listAll(Pageable pageable) {
		return animeRepository.findAll(pageable);
	}
	
	public List<Movie> listAllNonPageable() {
		return animeRepository.findAll();
	}
	
	
	public List<Movie> findByName(String name) {
		return animeRepository.findByName(name);
	}
	
	public Movie findById(Long id) {
		return animeRepository.findById(id)
				.orElseThrow(() -> new BadRequestException("Anime Not Found."));
	}

	@Transactional(rollbackOn = Exception.class)
	public Movie save(AnimePostRequestBody animePostRequestBody) {
		return animeRepository.save(AnimeMapper.INSTANCE.toAnime(animePostRequestBody));
	}

	@Transactional
	public void delete(long id) {
		animeRepository.delete(findById(id));
	}

	@Transactional
	public void update(AnimePutRequestBody animePutRequestBody) {
		Movie animeSaved = findById(animePutRequestBody.getId());
		
		Movie anime = AnimeMapper.INSTANCE.toAnime(animePutRequestBody);
		anime.setId(animeSaved.getId());
		
		animeRepository.save(anime);
	}
	
}
