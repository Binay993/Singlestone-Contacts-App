package com.singlestone.contacts.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.singlestone.contacts.exceptions.ContactsAppException;

@org.springframework.web.bind.annotation.ControllerAdvice
public class CustomExceptionHandler {
	
	@ExceptionHandler({ContactsAppException.class})
    public ResponseEntity<String> handleException(ContactsAppException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
	
}
