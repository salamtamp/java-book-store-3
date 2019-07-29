package me.bookstore.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookResource {
	
	@Autowired
	private BookService service;
	
	@GetMapping(path="/books")
	public List<Book> getAllBooks() {
		return service.findAll();
	}
	
	@GetMapping(path="/books/{id}")
	public Book getBook(@PathVariable Integer id) {
		return service.findOne(id);
	}
	
}
