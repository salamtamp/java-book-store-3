package me.bookstore3.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import me.bookstore3.entities.Book;
import me.bookstore3.entities.RequestBook;
import me.bookstore3.services.BookService;

@RestController
public class BookResource {
	@Autowired
	private BookService bookService;
	
	@GetMapping(path="/books")
	public List<Book> getAllBooks() {
		return bookService.getAllBook();
	}
	
	@GetMapping(path="/books/{id}")
	public Optional<Book> getBook(@PathVariable Integer id) {
		return bookService.getBook(id);
	}
	
	@PostMapping(path="/books")
	public void createBooks(@RequestBody List<RequestBook> books) {
		for (RequestBook book: books) {
			Book newBook = new Book(
				book.getBook_name(),
				book.getAuthor_name(), 
				book.getPrice(), 
				book.getIs_recommended()
			);
			
			bookService.createBook(newBook);			
		}
	}
	
	
	
}
