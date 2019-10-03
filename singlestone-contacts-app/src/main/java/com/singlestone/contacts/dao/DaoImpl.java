package com.singlestone.contacts.dao;

import org.springframework.stereotype.Component;

import com.singlestone.contacts.repo.ContactsRepo;

@Component
public abstract class DaoImpl implements DaoIf {

	protected ContactsRepo contactRepo;

	public DaoImpl(ContactsRepo contactRepo) {
		this.contactRepo = contactRepo;
	}

}
