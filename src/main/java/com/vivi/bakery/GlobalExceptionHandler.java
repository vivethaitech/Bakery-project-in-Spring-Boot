package com.vivi.bakery;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value=DuplicateException.class)
	@ResponseStatus(HttpStatus.ALREADY_REPORTED)
	public ResponseEntity<Object> handleException(DuplicateException de){
		Map<String,Object> body = new HashMap<>();
		body.put("TimeStamp", LocalDateTime.now());
		body.put("message", de.getMessage());
		body.put("Status", HttpStatus.ALREADY_REPORTED.value());
		return new ResponseEntity<>(body,HttpStatus.ALREADY_REPORTED);
	}

	@ExceptionHandler(value=PriceHighException.class)
	@ResponseStatus(HttpStatus.ALREADY_REPORTED)
	public ResponseEntity<Object> handleException(PriceHighException pe){
		Map<String,Object> body = new HashMap<>();
		body.put("TimeStamp", LocalDateTime.now());
		body.put("message", pe.getMessage());
		body.put("Status", HttpStatus.ALREADY_REPORTED.value());
		return new ResponseEntity<>(body,HttpStatus.ALREADY_REPORTED);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleExceptions(MethodArgumentNotValidException ex) {
	    Map<String, String> body = new HashMap<String, String>();

	    List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
	    for (int i = 0; i < allErrors.size(); i++) {
	        FieldError fieldError = (FieldError) allErrors.get(i);
	        String fieldName = fieldError.getField();
	        String errorMessage = fieldError.getDefaultMessage();
	        body.put(fieldName, errorMessage);
	    }
	    return new ResponseEntity<Object>(body, HttpStatus.BAD_REQUEST);
	}
}
