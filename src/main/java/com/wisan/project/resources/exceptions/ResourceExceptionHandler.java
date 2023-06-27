package com.wisan.project.resources.exceptions;

import java.time.Instant;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.wisan.project.service.exceptions.ResourceNotFundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFundException e, HttpServletRequest request){
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError er = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(er);
	}
	 @ExceptionHandler(DataIntegrityViolationException.class)
	    public ResponseEntity<StandardError> dataIntegrityViolation(DataIntegrityViolationException e, HttpServletRequest request) {
	        String error = "Data integrity violation";
	        HttpStatus status = HttpStatus.BAD_REQUEST;
	        StandardError errorResponse = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
	        return ResponseEntity.status(status).body(errorResponse);
	    }

}
