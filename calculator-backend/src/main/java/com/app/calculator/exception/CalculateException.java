package com.app.calculator.exception;

import org.springframework.http.HttpStatus;

public class CalculateException extends Exception{
	
	private String message;
	
	private String status;
	
	public CalculateException(String msg) {
		// TODO Auto-generated constructor stub
		this.message = msg;
		this.status = HttpStatus.BAD_GATEWAY.toString();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
