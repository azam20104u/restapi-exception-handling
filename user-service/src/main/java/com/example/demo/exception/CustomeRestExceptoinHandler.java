package com.example.demo.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomeRestExceptoinHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleResourceNotFoundException(UserNotFoundException ex, WebRequest request) throws Exception {
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setDateTime(LocalDateTime.now());
		errorDetails.setStatus(HttpStatus.NOT_FOUND.value());
		errorDetails.setError("Resource not found error");
		errorDetails.setMessage(ex.getMessage());
		errorDetails.setPath(request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleInvalidArgument(MethodArgumentNotValidException ex) {
		Map<String, String> map = new HashMap<String, String>();
			ex.getBindingResult().getFieldErrors().forEach((fieldError) -> {
            map.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
		return  new ResponseEntity<Map<String, String>>(map, HttpStatus.BAD_REQUEST);
	}
}
