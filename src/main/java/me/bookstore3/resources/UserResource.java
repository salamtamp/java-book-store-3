package me.bookstore3.resources;

import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import me.bookstore3.entities.Book;
import me.bookstore3.entities.Orders;
import me.bookstore3.entities.RequestOrder;
import me.bookstore3.entities.RequestUser;
import me.bookstore3.entities.User;
import me.bookstore3.services.UserService;
import me.bookstore3.services.BookService;
import me.bookstore3.services.OrderService;

@RestController
public class UserResource {
	@Autowired
	private UserService userService;
	
	@Autowired
	private OrderService orderService;

	@Autowired
	private BookService bookService;
	
	@GetMapping(path="/users")
	public List<User> getAllUsers() {
		return userService.getAllUser();
	}
	
	@GetMapping(path="/users/{id}")
	public Optional<User> getUser(@PathVariable Integer id) {
		return userService.getUser(id);
	}
	
	@PostMapping(path="/users")
	public ResponseEntity<Object> createUser(@RequestBody RequestUser requestUser) {
		String username = requestUser.getUsername();
		String password = requestUser.getPassword();
		String name = username.substring(0, username.indexOf("."));
		String surname = username.substring(username.indexOf(".") + 1, username.length());  
		Date date_of_birth = requestUser.getDate_of_birth();
		
		User createdUser = userService.createUser(new User(name, surname, date_of_birth, username, password));
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping(path="/users/orders/{userId}")
	public String createOrderOnUser(@PathVariable Integer userId, @RequestBody RequestOrder requestOrder) {
		List<Integer> orders = requestOrder.getOrders();
		Double totalPrice = 0.00;
		
		for (Integer bookId: orders) {
			Book book = bookService.getBook(bookId);
			Double price = 0.00;
			
			if (book != null) {
				price = book.getPrice();
			}
			
			Orders newOrder = new Orders(userId, bookId, price);
			orderService.createOrder(newOrder);
			totalPrice += price;
		}	
		
		return totalPrice.toString();
	}

	@DeleteMapping(path="/users/{id}")
	public void deleteUser(@PathVariable Integer id) {
		userService.deleteUser(id);
	}
}
