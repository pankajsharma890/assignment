package com.uxpsystems.assignment.CustomException;

import java.util.Date;

public class ExceptiionResponse {
	
	private Date timeStamp;
	private String message;
	private String details;
	
	public ExceptiionResponse() {
		
	}
	
	public ExceptiionResponse(Date timeStamp, String message, String details) {
		this.timeStamp = timeStamp;
		this.message = message;
		this.details = details;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		details = details;
	}
	
	

}
