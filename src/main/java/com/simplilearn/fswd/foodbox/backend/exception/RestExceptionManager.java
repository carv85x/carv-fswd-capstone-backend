package com.simplilearn.fswd.foodbox.backend.exception;

import java.sql.SQLIntegrityConstraintViolationException;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.simplilearn.fswd.foodbox.backend.model.Message;

public class RestExceptionManager extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(EntityNotFoundException.class)
	private ResponseEntity<Message> manageEntityNotFound(EntityNotFoundException e) {
		Message error = new Message(HttpStatus.NOT_FOUND, "Entity not found", e.getMessage());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	private ResponseEntity<Message> manageConstraintViolationException(EntityNotFoundException e) {
		Message error = new Message(HttpStatus.NOT_ACCEPTABLE, "Blank or null value", e.getMessage());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	private ResponseEntity<Message> manageMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
		Message error = new Message(HttpStatus.NOT_ACCEPTABLE, "Incorrect date format (expected \"yyyy-MM-dd\"", e.getMessage());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(NullPointerException.class)
	private ResponseEntity<Message> NullPointerException(NullPointerException e) {
		Message error = new Message(HttpStatus.INTERNAL_SERVER_ERROR, "Null attribute found", e.getMessage());
		
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	private ResponseEntity<Message> manageSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e) {
		Message error = new Message(HttpStatus.INTERNAL_SERVER_ERROR,"Wrong or invalid ID", e.getMessage());
		
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	private ResponseEntity<Message> manageIllegalArgumentException(IllegalArgumentException e) {
		Message error = new Message(HttpStatus.NOT_ACCEPTABLE,"Illegal argument", e.getMessage());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
	}

}
