package me.bookstore3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import me.bookstore3.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
