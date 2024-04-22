package com.kj.mircroservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Contact extends BaseEntity {

	static final int MESSAGE_MIN = 3;
	static final int MESSAGE_MAX = 50;
	static final int MOBILE_NUM_LENGTH = 10;
	static final int EMAIL_MIN = 3;
	static final int EMAIL_MAX = 50;
	static final int SUBJECT_MIN = 5;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	private int id;

	@NotBlank(message = "Name is mandatory")
	@Size(min = MESSAGE_MIN, max = MESSAGE_MAX, message = "Name must be between 2 and 50 characters")
	private String name;

	@NotBlank(message = "Mobile number must not be blank")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
	private String mobileNum;

	@NotBlank(message = "Email is mandatory")
	@Size(min = MESSAGE_MIN, max = MESSAGE_MAX, message = "Email must be between 3 and 50 characters")
	private String email;

	@NotBlank(message = "Subject must not be blank")
	@Size(min = SUBJECT_MIN, message = "Subject must be at least 5 characters long")
	private String subject;

	@NotBlank(message = "Message must not be blank")
	@Size(min = MOBILE_NUM_LENGTH, message = "Message must be at least 10 characters long")
	private String message;

	private String status;

}
