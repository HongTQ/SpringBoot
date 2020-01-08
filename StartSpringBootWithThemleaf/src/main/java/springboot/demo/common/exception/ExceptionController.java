package springboot.demo.common.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<Object> exception(MethodArgumentNotValidException argumentNotValidException) {
//		Map<String, String> errors = new HashMap<String, String>();
		List<ExceptionMessage> listExceptionMessages = new ArrayList<ExceptionMessage>();
		argumentNotValidException.getBindingResult().getAllErrors().forEach((error) -> {
			ExceptionMessage exceptionMessage = new ExceptionMessage(((FieldError) error).getField(),
					((FieldError) error).getDefaultMessage());
			listExceptionMessages.add(exceptionMessage);
		});
		return new ResponseEntity<>(listExceptionMessages, HttpStatus.NOT_FOUND);
	}
}
