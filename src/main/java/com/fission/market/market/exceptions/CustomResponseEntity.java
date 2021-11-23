package com.fission.market.market.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntity extends ResponseEntityExceptionHandler {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ExceptionHandler(CustomException.class)
	public ResponseEntity notFound(Exception e) {
		CustomResponse cr = new CustomResponse("Resourse Not Found", new Date());
		return new ResponseEntity(cr, HttpStatus.NOT_FOUND);

	}

}
