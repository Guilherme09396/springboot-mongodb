package com.guilherme.springmongo.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.guilherme.springmongo.services.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExcepetionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException err, HttpServletRequest req) {
		HttpStatus status = HttpStatus.NOT_FOUND; 
		StandardError error = new StandardError(Instant.now(), status.value(), err.getMessage(), "Não encontrado", req.getRequestURI());
		
		return ResponseEntity.status(status).body(error);
	}
}
