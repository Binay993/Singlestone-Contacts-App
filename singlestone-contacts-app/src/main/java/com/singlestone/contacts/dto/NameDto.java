package com.singlestone.contacts.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class NameDto {

	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String lastName;
	private String middleName;

	@OneToOne(mappedBy = "name", cascade = CascadeType.ALL)
	private ContactDto contactDto;

	public NameDto() {
		super();
	}

	public NameDto(Long id, String firstName, String lastName, String middleName, ContactDto contactDto) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.contactDto = contactDto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public ContactDto getContactDTO() {
		return contactDto;
	}

	public void setContactDTO(ContactDto contactDto) {
		this.contactDto = contactDto;
	}

}
