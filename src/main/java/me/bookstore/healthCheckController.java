package me.bookstore;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class healthCheckController {
	
	@GetMapping(path="/healthcheck")
	public String healthCheck() {
		return "ok";
	}
}
