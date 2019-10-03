package com.singlestone.contacts.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PhoneDto {

	@Id
	@GeneratedValue
	private Long id;
	private String number;
	private String type;
	@ManyToOne
	private ContactDto contactDto;

	public PhoneDto() {
		super();
	}

	public PhoneDto(Long id, String number, String type, ContactDto contactDto) {
		super();
		this.id = id;
		this.number = number;
		this.type = type;
		this.contactDto = contactDto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ContactDto getContactDTO() {
		return contactDto;
	}

	public void setContactDTO(ContactDto contactDto) {
		this.contactDto = contactDto;
	}

}
