package com.singlestone.contacts.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.singlestone.contacts.dto.ContactDto;
import com.singlestone.contacts.repo.ContactsRepo;

@Component
public class ContactDaoImpl extends DaoImpl {

	@Autowired
	public ContactDaoImpl(ContactsRepo contactRepo) {
		super(contactRepo);
	}

	@Override
	public Object saveEntity(Object dto) {
		return contactRepo.save((ContactDto)dto);
	}

	@Override
	public Object getEntityById(Long id) {
		 Optional<ContactDto> resp =  contactRepo.findById(id);
		 return resp.isPresent() ? resp.get() : null;
	}

	@Override
	public void deleteById(Long id) {
		contactRepo.deleteById(id);
		
	}

	@Override
	public List<? extends Object> getAll() {
		 return contactRepo.findAll();
	}


}
