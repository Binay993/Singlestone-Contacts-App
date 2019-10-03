package com.singlestone.contacts.mappers;

import java.util.HashSet;
import java.util.Set;

import com.singlestone.contacts.dto.AddressDto;
import com.singlestone.contacts.dto.ContactDto;
import com.singlestone.contacts.dto.NameDto;
import com.singlestone.contacts.dto.PhoneDto;
import com.singlestone.contacts.pojo.Address;
import com.singlestone.contacts.pojo.ContactDetails;
import com.singlestone.contacts.pojo.Name;
import com.singlestone.contacts.pojo.Phone;

public class ObjectMappper {

	public static ContactDto mapToDto(ContactDetails contactDetails) {

		if (contactDetails != null) {

			return new ContactDto(contactDetails.getId(), mapToDto(contactDetails.getName()), mapToDto(contactDetails.getAddress()),
					mapToDto(contactDetails.getPhone()), contactDetails.getEmail());
		}

		return null;
	}

	public static AddressDto mapToDto(Address address) {

		if (address != null) {
			return new AddressDto(null, address.getStreet(), address.getCity(), address.getState(), address.getZip(), null);
		}

		return null;

	}

	public static Set<PhoneDto> mapToDto(Set<Phone> phones) {

		if (phones != null && phones.size() > 0) {
			Set<PhoneDto> phoneDtos = new HashSet<>();
			for (Phone p : phones) {
				phoneDtos.add(new PhoneDto(null, p.getNumber(), p.getType(), null));
			}
			return phoneDtos;
		}

		return null;
	}

	public static NameDto mapToDto(Name name) {
		if (name != null) {
			return new NameDto(null, name.getFirst(), name.getLast(), name.getMiddle(), null);
		}
		return null;
	}

	public static ContactDetails mapToModel(ContactDto contactDto) {

		if (contactDto != null) {

			return new ContactDetails(contactDto.getId(), mapToModel(contactDto.getName()),
					mapToModel(contactDto.getAddress()), mapToModel(contactDto.getPhone()), contactDto.getEmail());
		}

		return null;
	}

	public static Address mapToModel(AddressDto addressDto) {

		if (addressDto != null) {
			return new Address(addressDto.getStreet(), addressDto.getCity(), addressDto.getState(),
					addressDto.getZip());
		}
		return null;

	}

	public static Set<Phone> mapToModel(Set<PhoneDto> phoneDtos) {

		if (phoneDtos != null && phoneDtos.size() > 0) {
			Set<Phone> phones = new HashSet<>();
			for (PhoneDto p : phoneDtos) {
				phones.add(new Phone(p.getNumber(), p.getType()));
			}
			return phones;
		}

		return null;
	}

	public static Name mapToModel(NameDto nameDto) {
		if (nameDto != null) {
			return new Name(nameDto.getFirstName(), nameDto.getMiddleName(), nameDto.getLastName());
		}
		return null;
	}

}
