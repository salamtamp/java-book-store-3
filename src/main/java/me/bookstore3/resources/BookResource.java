package me.bookstore3.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import me.bookstore3.entities.Book;
import me.bookstore3.entities.RequestBook;
import me.bookstore3.services.BookService;

@RestController
@Validated
public class BookResource {
	@Autowired
	private BookService bookService;
	
	@GetMapping(path="/books")
	public List<Book> getAllBooks() {
		List<Book> books = bookService.getAllBook();
		
		/* Handle case SORT & MERGE Recommended book */
		List<Book> recommendedBook = new ArrayList<Book>();
		List<Book> nonRecommendedBook = new ArrayList<Book>();
		List<Book> resultBook = new ArrayList<Book>();
		
		/* Split Book */
		for (Book book: books) {
			if (book.getIs_recommended() == "yes") {
				recommendedBook.add(book);
			} else {
				nonRecommendedBook.add(book);
			}
		}
		
		/* Sort Recommended Book */
		Collections.sort(recommendedBook, new Comparator<Book>(){
		  public int compare(Book o1, Book o2)
		  {
		     return o1.getName().compareTo(o2.getName());
		  }
		});
		
		/* Sort Non-Recommended Book */
		Collections.sort(nonRecommendedBook, new Comparator<Book>(){
			  public int compare(Book o1, Book o2)
			  {
			     return o1.getName().compareTo(o2.getName());
			  }
			});
		
		for (Book book: recommendedBook) {
			resultBook.add(book);
		}
		
		for (Book book: nonRecommendedBook) {
			resultBook.add(book);
		}
		
		return resultBook;
	}
	
	@GetMapping(path="/books/{id}")
	public Book getBook(@PathVariable @Min(1) Integer id) {
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
