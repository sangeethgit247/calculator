package com.app.calculator.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.calculator.dto.ErrorDto;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class CalculateExceptionController {
	
	@ExceptionHandler(exception = CalculateException.class)
	public ResponseEntity<ErrorDto> handlerForCalculateException(CalculateException exp){
		
		ErrorDto dto = new ErrorDto();
		
		dto.setErrorMessage(exp.getMessage());
		dto.setStatusCode(500);
		
		return ResponseEntity.badRequest().body(dto);
	}
	
	@ExceptionHandler(exception = Exception.class)
	public ResponseEntity<ErrorDto> handlerForGenericException(Exception ex){
		
		ErrorDto dto = new ErrorDto();
		
		dto.setErrorMessage(ex.getMessage());
		dto.setStatusCode(500);
		
		return ResponseEntity.badRequest().body(dto);
	}
	
	@ExceptionHandler(exception = ConstraintViolationException.class)
	public ResponseEntity<Map<String, String>> handlerForConstraintViolations(ConstraintViolationException exp){
		
		Map<String, String> errors = new HashMap<>();
		exp.getConstraintViolations().forEach(violation -> {
			String fullPath = violation.getPropertyPath().toString();
			String fieldName = fullPath.contains(".") ? fullPath.
					substring(fullPath.lastIndexOf('.') + 1) : fullPath;
			String errorMessage = violation.getMessage();
			errors.put(fieldName, errorMessage);
		});
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getFieldErrors().forEach(error -> {
	        errors.put(error.getField(), error.getDefaultMessage());
	    });

	    return ResponseEntity
	            .status(HttpStatus.BAD_REQUEST)
	            .body(errors);
	}


}
