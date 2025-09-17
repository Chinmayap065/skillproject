package com.mtd.EcomApp.config;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handleNotFound(ResourceNotFoundException ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<String> handleBusiness(BusinessException ex){
		return ResponseEntity.badRequest().body(ex.getMessage());
	}

}
