package com.uxpsystems.assignment.CustomException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class StatusNotValidException extends RuntimeException {

	
	public StatusNotValidException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	

}
