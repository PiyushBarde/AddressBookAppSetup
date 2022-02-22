package com.bridgelabz.springaddressbookapp.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ResponseDTO {
	
	public ResponseDTO() {
		super();
	}
	private String message;
	private Object contact;
	public ResponseDTO(String message,Object contact) {
		super();
		this.contact = contact;
		this.message = message;
	}
	
}
