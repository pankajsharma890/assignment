package com.uxpsystems.assignment.CustomException;


import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.function.EntityResponse;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@RestController
public class GlobleExceptionHandler extends ResponseEntityExceptionHandler{
	
	
@ExceptionHandler(Exception.class)	
public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
	
	
	ExceptiionResponse exceptionResponse = new  ExceptiionResponse(new Date(),ex.getMessage(),request.getDescription(false));
	
	return new ResponseEntity(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	
}

@ExceptionHandler(StatusNotValidException.class)	
public final ResponseEntity<Object> statusNotValidException(Exception ex, WebRequest request) throws Exception {
	
	
	ExceptiionResponse exceptionResponse = new  ExceptiionResponse(new Date(),ex.getMessage(),request.getDescription(false));
	
	return new ResponseEntity(exceptionResponse,HttpStatus.BAD_REQUEST);
	
}

@Override
protected ResponseEntity<Object> handleMethodArgumentNotValid(
		MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

	ExceptiionResponse exceptionResponse = new  ExceptiionResponse(new Date(),ex.getMessage(),ex.getBindingResult().toString());
	
	return new ResponseEntity(exceptionResponse,HttpStatus.BAD_REQUEST);
}

}
