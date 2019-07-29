package me.bookstore.user;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import me.bookstore.book.Book;
import me.bookstore.book.BookService;

@RestController
public class UserResource {
	@Autowired
	private UserService userService;
	
	@Autowired
	private BookService bookService;
	
	@GetMapping(path="/users")
	public List<User> getAllUsers() {
		return userService.findAll();
	}
	
	@GetMapping(path="/users/{id}")
	public User getUser(@PathVariable Integer id) {
		return userService.findOne(id);
	}
	
	@PostMapping(path="/users")
	public void createUser(@RequestBody Register register) {
		String username = register.getUsername();
		String name = username.substring(0, username.indexOf("."));
		String surname = username.substring(username.indexOf(".") + 1, username.length());  
		Date date_of_birth = register.getDate_of_birth();
//		List<Integer> books = new ArrayList<>();
		
		// Create new user
		User user = new User();
		user.setName(name);
		user.setSurname(surname);
		user.setDateOfBirth(date_of_birth);
//		user.setBooks(books);
		
		userService.create(user);
//		User createdUser = userService.create(user);
		
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdUser.getId()).toUri();
//		return ResponseEntity.created(location).build();
	}
	
	@PostMapping(path="/users/orders")
	public void updateOrderUser(@RequestBody Order order) {
		List<Integer> books = new ArrayList<>();
		Double sumPrice = 0.00;
		
		/* Hard code userId for test update book to user */
		Integer userId = 1;
		
		User user = userService.findOne(userId);
		
		for (int bookId : order.getOrders()) {
			Book book = bookService.findOne(bookId);
			books.add(bookId);
			sumPrice += book.getPrice();
		}
		
		user.setBooks(books);
		
		// Update book to user
		userService.updateOne(userId, user);
		System.out.println(String.format("total: %.2f", sumPrice));
	}
}
