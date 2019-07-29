package me.bookstore3.services;

import org.springframework.stereotype.Service;

@Service
public class HealthcheckService {
	private String message;
	
	public HealthcheckService() {
		super();
		this.message = "ok";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
