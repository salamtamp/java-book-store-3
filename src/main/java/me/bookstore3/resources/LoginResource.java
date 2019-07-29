package me.bookstore3.resources;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginResource {

	@PostMapping(path="/login")
	public void login(@RequestBody Map<String, String> json) {
		String username = json.get("username");
		String password = json.get("password");
		
		System.out.println("username: " + username);
		System.out.println("password: " + password);
		
//		auth.inMemoryAuthentication()
//        .withUser("user1").password(passwordEncoder().encode("user1Pass")).roles("USER")
	}
}
