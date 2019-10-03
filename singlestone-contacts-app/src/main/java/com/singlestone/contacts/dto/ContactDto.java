package com.singlestone.contacts.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ContactDto {

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
	private NameDto name;

	@OneToOne(cascade = CascadeType.ALL)
	private AddressDto address;

	@OneToMany(cascade = CascadeType.ALL)
	private Set<PhoneDto> phone;

	public ContactDto() {
		super();
	}

	public ContactDto(Long id, NameDto name, AddressDto address, Set<PhoneDto> phone, String email) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}

	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public NameDto getName() {
		return name;
	}

	public void setName(NameDto name) {
		this.name = name;
	}

	public AddressDto getAddress() {
		return address;
	}

	public void setAddress(AddressDto address) {
		this.address = address;
	}

	public Set<PhoneDto> getPhone() {
		return phone;
	}

	public void setPhone(Set<PhoneDto> phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
