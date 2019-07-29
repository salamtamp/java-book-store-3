package me.bookstore3.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import me.bookstore3.entities.Book;
import me.bookstore3.entities.Orders;
import me.bookstore3.entities.RequestOrder;
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
	public void createUser(@RequestBody User user) {
		userService.createUser(user);
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
		
		return Double.toString(totalPrice);
	}
	
	@DeleteMapping(path="/users/{id}")
	public void deleteUser(@PathVariable Integer id) {
		userService.deleteUser(id);
	}
}
