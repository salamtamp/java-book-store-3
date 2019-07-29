package me.bookstore3.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import me.bookstore3.services.HealthcheckService;

@RestController
public class HealthcheckResource {
	@Autowired
	private HealthcheckService healthcheckService;
	
	@GetMapping(path="/")
	public String status() {
		return healthcheckService.getMessage();
	}
	
	@GetMapping(path="/healthcheck")
	public String healthcheck() {
		return healthcheckService.getMessage();
	}
}
