package com.singlestone.contacts.manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.singlestone.contacts.dao.ContactDaoImpl;
import com.singlestone.contacts.dto.ContactDto;
import com.singlestone.contacts.exceptions.ContactsAppException;
import com.singlestone.contacts.mappers.ObjectMappper;
import com.singlestone.contacts.pojo.ContactDetails;
import com.singlestone.contacts.pojo.Phone;

@Component
public class ContactsManager {

	private final List<String> PHONE_TYPES = Arrays.asList("work", "home", "mobile");
	private ContactDaoImpl contactDao;

	@Autowired
	public ContactsManager(ContactDaoImpl contactDao) {
		this.contactDao = contactDao;
	}

	public void deleteContact(Long id) {
		contactDao.deleteById(id);
	}

	public ContactDetails updateContact(Long id, ContactDetails contactDetails) {
		ContactDetails original = this.retreiveContact(id);
		if (original == null) {
			throw new ContactsAppException("No record found for id: " + id);
		}
		copyProperties(contactDetails, original);
		return saveContact(original);

	}

	public List<ContactDetails> retreiveContacts() {

		List<ContactDto> dtos = (List<ContactDto>) contactDao.getAll();
		List<ContactDetails> response = new ArrayList<ContactDetails>();
		dtos.forEach(dto -> {
			response.add(ObjectMappper.mapToModel(dto));
		});
		return response;
	}

	public ContactDetails retreiveContact(Long id) {

		ContactDto contactDto = (ContactDto) contactDao.getEntityById(id);
		return ObjectMappper.mapToModel(contactDto);

	}

	public ContactDetails saveContact(ContactDetails contactDetails) {

		validatePayload(contactDetails);
		ContactDto contactDto = ObjectMappper.mapToDto(contactDetails);
		contactDto = (ContactDto) contactDao.saveEntity(contactDto);
		return ObjectMappper.mapToModel(contactDto);

	}

	private void validatePayload(ContactDetails contactDetails) {

		if (contactDetails == null) {
			throw new ContactsAppException("Empty request.");
		}

		if (contactDetails.getPhone() == null) {
			throw new ContactsAppException("Phone number cannot be empty");
		}

		isPhoneValid(contactDetails);
	}

	private void isPhoneValid(ContactDetails contactDetails) {

		for (Phone phone : contactDetails.getPhone()) {
			if (!PHONE_TYPES.contains(phone.getType())) {
				throw new ContactsAppException("Only mobile|home|work phone type supported.");
			}
		}

	}

	private String copyIfNotNull(String checkThis, String replaceThis) {

		if (!StringUtils.isEmpty(checkThis)) {
			return checkThis;
		} else {
			return replaceThis;
		}
	}

	private void copyProperties(ContactDetails src, ContactDetails dest) {

		dest.setEmail(copyIfNotNull(src.getEmail(), dest.getEmail()));
		if (src.getAddress() != null) {
			if (dest.getAddress() == null) {
				dest.setAddress(src.getAddress());
			} else {
				dest.getAddress().setStreet(copyIfNotNull(src.getAddress().getStreet(), dest.getAddress().getStreet()));
				dest.getAddress().setState(copyIfNotNull(src.getAddress().getState(), dest.getAddress().getState()));
				if (src.getAddress().getZip() != 0) {
					dest.getAddress().setZip(src.getAddress().getZip());
				}
				dest.getAddress().setCity(copyIfNotNull(src.getAddress().getCity(), dest.getAddress().getCity()));
			}
		}

		if (src.getName() != null) {
			if (dest.getName() == null) {
				dest.setName(src.getName());
			} else {

				dest.getName().setFirst(copyIfNotNull(src.getName().getFirst(), dest.getName().getFirst()));
				dest.getName().setLast(copyIfNotNull(src.getName().getLast(), dest.getName().getLast()));
				dest.getName().setMiddle(copyIfNotNull(src.getName().getMiddle(), dest.getName().getMiddle()));
			}
		}

		if (src.getPhone() != null) {
			if (dest.getPhone() == null) {
				dest.setPhone(src.getPhone());
			} else {
				for (Phone p : src.getPhone()) {
					Phone temp = null;
					for (Phone phone : dest.getPhone()) {
						if (phone.getType().equals(p.getType())) {
							temp = phone;
							break;
						}
					}
					if (temp != null) {
						temp.setNumber(p.getNumber());
					} else {
						dest.getPhone().add(p);
					}
				}
			}
		}

	}
}
