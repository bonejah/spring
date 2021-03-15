package academy.devdojo.springboot2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import academy.devdojo.springboot2.domain.Movie;
import academy.devdojo.springboot2.requests.AnimePostRequestBody;
import academy.devdojo.springboot2.requests.AnimePutRequestBody;

@Mapper(componentModel = "spring")
public abstract class AnimeMapper {
	
	public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);

	public abstract Movie toAnime(AnimePostRequestBody animePostRequestBody);
	
	public abstract Movie toAnime(AnimePutRequestBody animePutRequestBody);
	
}
