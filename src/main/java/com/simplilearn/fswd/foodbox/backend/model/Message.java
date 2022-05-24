package com.simplilearn.fswd.foodbox.backend.model;

import java.util.Date;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date time;
	private int code;
	private String status;
	private String message;
	private String details;
	
	public Message() {
		time = new Date();
	}

	public Message(HttpStatus httpStatus, String message, String details) {
		super();
		this.code = httpStatus.value();
		this.status = httpStatus.name();
		this.message = message;
		this.details = details;
	}
	
	
}
