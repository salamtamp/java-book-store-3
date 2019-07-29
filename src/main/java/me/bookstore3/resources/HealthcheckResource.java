package me.bookstore3.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthcheckResource {
	
	@GetMapping(path="/")
	public String status() {
		return "ok";
	}
	
	@GetMapping(path="/healthcheck")
	public String healthcheck() {
		return "ok";
	}
}
