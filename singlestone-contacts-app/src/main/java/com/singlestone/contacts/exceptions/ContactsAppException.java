package com.singlestone.contacts.exceptions;

public class ContactsAppException extends RuntimeException{

	private static final long serialVersionUID = 1L;
			
	public ContactsAppException(String errorMessage) {
		super(errorMessage);
	}
}
