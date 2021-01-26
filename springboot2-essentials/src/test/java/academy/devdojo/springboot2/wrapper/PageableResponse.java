package academy.devdojo.springboot2.wrapper;

import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageableResponse<T> extends PageImpl<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2473621709391240767L;
	
	private boolean first;
    private boolean last;
    private int totalPages;
    private int numberOfElements;

    @JsonCreator(mode = Mode.PROPERTIES )
    public PageableResponse(@JsonProperty("content") List<T> content,
        @JsonProperty("number") int number,
        @JsonProperty("size") int size,
        @JsonProperty("totalElements") int totalElements,
        @JsonProperty("last") boolean last,
        @JsonProperty("first") boolean first,
        @JsonProperty("totalPages") int totalPages,
        @JsonProperty("numberOfElements") int numberOfElements,
        @JsonProperty("pageable") JsonNode pageable,
        @JsonProperty("sort") JsonNode sort) {
        super(content, PageRequest.of(number, size), totalElements);

        this.last = last;
        this.first = first;
        this.totalPages = totalPages;
        this.numberOfElements = numberOfElements;

    }
}
