package com.assignment.jpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomException extends RuntimeException {

	public CustomException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
