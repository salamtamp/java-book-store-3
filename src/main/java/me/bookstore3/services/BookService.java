package me.bookstore3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.bookstore3.entities.Book;
import me.bookstore3.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getAllBook() {
		return bookRepository.findAll();
	}
	
	public Book getBook(Integer id) {
		return bookRepository.findById(id).orElse(null);
	}
	
	public void createBook(Book book) {
		bookRepository.save(book);
	}
}
