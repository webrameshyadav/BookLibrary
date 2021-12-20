package com.example.demo.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.model.ResponseMessage;


@ControllerAdvice  
@RestController  
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler  
{  

@ExceptionHandler(Exception.class)
private ResponseEntity<ResponseMessage> handleGenericException(Exception ex)
{
	System.out.println("Error Message: " + ex.getMessage());
	
	ResponseMessage response = new ResponseMessage();
	response.setId(-1);
	response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.name());
	response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
	response.setMessage(ex.getMessage());
	return ResponseEntity.badRequest().body(response);
	
} 
}

