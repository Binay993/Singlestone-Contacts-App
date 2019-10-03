package com.singlestone.contacts.web;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.singlestone.contacts.manager.ContactsManager;
import com.singlestone.contacts.pojo.ContactDetails;

@RestController
@RequestMapping(path = "/contacts")
public class Controller{
	
	private ContactsManager contactsManager;
	
	@Autowired
	public Controller(ContactsManager contactsManager) {
		this.contactsManager = contactsManager;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ContactDetails getContacts(@PathVariable("id") Long id) {
		return contactsManager.retreiveContact(id);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<ContactDetails> getAlleContacts() {
		return contactsManager.retreiveContacts();
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ContactDetails saveContacts(@RequestBody ContactDetails contactDetails) {		
		return contactsManager.saveContact(contactDetails);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ContactDetails updateContacts(@PathVariable("id") Long id, @RequestBody ContactDetails contactDetails) {
		return contactsManager.updateContact(id, contactDetails);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteContact(@PathVariable("id") Long id) {
		contactsManager.deleteContact(id);
	}
	
}
