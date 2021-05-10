package com.java.zensar.assessment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionDetails> handleAllExceptions(Exception ex,WebRequest req){
		
		ExceptionDetails  details=new ExceptionDetails();
		details.setErrorcode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		details.setErrorMsg("Something went wrong, please try again after some time ...!");
		
		return new ResponseEntity<>(details, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
