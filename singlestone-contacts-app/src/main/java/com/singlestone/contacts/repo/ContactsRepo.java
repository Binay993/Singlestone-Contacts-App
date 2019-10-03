package com.singlestone.contacts.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.singlestone.contacts.dto.ContactDto;

@Repository
public interface ContactsRepo extends JpaRepository<ContactDto, Long> {}
