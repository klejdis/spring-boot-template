package com.kj.mircroservice.service;

import com.kj.mircroservice.model.Contact;
import com.kj.mircroservice.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public final class ContactService {

	@Autowired
	private ContactRepository contactRepository;

	public Page<Contact> getContacts(final Integer page, final Integer size) {
		Pageable pageable = PageRequest.of(page, size);
		return contactRepository.findAll(pageable);
	}

	public Contact getContact(final Integer id) {
		return contactRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("Contact not found with ID: " + id));
	}

	public Contact deleteContact(Integer id) {
		Contact contact = getContact(id);
		contactRepository.delete(contact);
		return contact;
	}

	public Contact updateContact(Contact contact) {
		return contactRepository.save(contact);
	}

}
