package academy.devdojo.springboot2.handler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import academy.devdojo.springboot2.exception.BadRequestException;
import academy.devdojo.springboot2.exception.BadRequestExceptionDetails;
import academy.devdojo.springboot2.exception.ExceptionDetails;
import academy.devdojo.springboot2.exception.ValidationExceptionDetails;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<BadRequestExceptionDetails> handleBadRequestException(BadRequestException exception) {
		return new ResponseEntity<>(
				BadRequestExceptionDetails.builder().timesTamp(LocalDateTime.now())
						.status(HttpStatus.BAD_REQUEST.value()).title("Bad Request Exception, check the documentation.")
						.details(exception.getMessage()).developerMessage(exception.getClass().getName()).build(),
				HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<FieldError> errors = ex.getBindingResult().getFieldErrors();

		String fields = errors.stream().map(FieldError::getField).collect(Collectors.joining());
		String fieldsMessages = errors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining());

		return new ResponseEntity<>(ValidationExceptionDetails.builder().timesTamp(LocalDateTime.now())
				.status(HttpStatus.BAD_REQUEST.value()).title("Bad Request Exception, invalid fields.")
				.details("Check field(s) error(s).").developerMessage(ex.getClass().getName()).fields(fields)
				.fieldsMessage(fieldsMessages).build(), HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		ExceptionDetails exceptionDetails = ExceptionDetails.builder().timesTamp(LocalDateTime.now())
				.status(status.value()).title(ex.getCause().getMessage()).details(ex.getMessage())
				.developerMessage(ex.getClass().getName()).build();

		return new ResponseEntity<>(exceptionDetails, headers, status);
	}

}
