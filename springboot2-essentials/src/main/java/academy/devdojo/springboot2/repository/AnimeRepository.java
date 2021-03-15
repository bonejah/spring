package academy.devdojo.springboot2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import academy.devdojo.springboot2.domain.Movie;

@Repository
public interface AnimeRepository extends JpaRepository<Movie, Long>{
	
	List<Movie> findByName(String name);
	
}
