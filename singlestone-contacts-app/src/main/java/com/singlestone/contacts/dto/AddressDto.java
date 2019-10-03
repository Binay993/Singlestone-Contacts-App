package com.singlestone.contacts.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class AddressDto {

	@Id
	@GeneratedValue
	private Long id;
	private String street;
	private String city;
	private String state;
	private int zip;

	@OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
	private ContactDto contactDto;

	public AddressDto() {
		super();
	}

	public AddressDto(Long id, String street, String city, String state, int zip, ContactDto contactDto) {
		super();
		this.id = id;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.contactDto = contactDto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

}
