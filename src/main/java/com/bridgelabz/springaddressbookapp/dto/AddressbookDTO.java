package com.bridgelabz.springaddressbookapp.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AddressbookDTO {
	@Pattern(regexp = "^[A-Z]{1}[a-z A-Z]{2,}",message = "invalid name first word must be capital")
	private String firstName;
	@Pattern(regexp = "^[A-Z]{1}[a-z A-Z]{2,}",message = "invalid name first word must be capital")
	private String lastName;
	@Email
	private String email;
	@NotEmpty
	private long phoneNumber;
	@NotEmpty
	private String city;
	@NotBlank
	private String state;
	@NotNull
	private Integer zip;
}
