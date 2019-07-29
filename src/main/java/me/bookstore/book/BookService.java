package me.bookstore.book;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;	

@Component
public class BookService {
	private static List<Book> books = new ArrayList<>();
	
	static {
		books.add(new Book(1, "Before We Were Yours: A Novel", "Lisa Wingate", 340.0, "no"));
		books.add(new Book(2, "When Never Comes", "Barbara Davis", 179.0, "no"));
		books.add(new Book(3, "Giraffes Can't Dance", "Giles Andreae, Guy Parker-Rees", 200.5, "no"));
		books.add(new Book(4, "Giraffes Can't Dance", "Giles Andreae Parker-Rees", 100.5, "no"));
	}
	
	public List<Book> findAll() {
		return books;
	}
	
	public Book findOne(int id) {
		for(Book book:books) {
			if(book.getId()==id) {
				return book;
			}
		}
		
		return null;
	}
}
