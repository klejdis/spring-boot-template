package com.kj.mircroservice.controller;

import com.kj.mircroservice.model.Contact;
import com.kj.mircroservice.service.ContactService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {

	private final ContactService contactService;

	public ContactController(final ContactService contactService) {
		this.contactService = contactService;
	}

	@Operation(summary = "Get paginated contacts", description = "Get paginated contacts")
	@ApiResponse(responseCode = "200", description = "Return paginated contacts")
	@GetMapping("/contacts")
	public ResponseEntity<List<Contact>> contacts(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		return ResponseEntity.ok().body(contactService.getContacts(page, size).getContent());
	}

	@GetMapping("/contacts/{id}")
	public ResponseEntity<Contact> contact(@PathVariable final Integer id) {
		try {
			return ResponseEntity.ok().body(contactService.getContact(id));
		}
		catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/contacts/{id}/delete")
	public final ResponseEntity<?> deleteContact(@PathVariable final Integer id) {
		try {
			return ResponseEntity.ok().build();
		}
		catch (Exception e) {
			return ResponseEntity.unprocessableEntity().body(e.toString());
		}
	}

	@Operation(summary = "Create a new contact", description = "Create a new contact")
	@PatchMapping("/contacts/{id}/update")
	public final ResponseEntity<?> updateContact(@PathVariable final Integer id, @RequestBody @Valid Contact contact) {
		try {
			return ResponseEntity.ok().body(contactService.updateContact(contact));
		}
		catch (Exception e) {
			return ResponseEntity.unprocessableEntity().body(e.toString());
		}
	}

}
