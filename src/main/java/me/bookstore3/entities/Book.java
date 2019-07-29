package me.bookstore3.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Integer id;
	private String name;
	private String author;
	private Double price;
	private String is_recommended;
	protected Book() {
		
	}
	
	public Book(String name, String author, Double price, String is_recommended) {
		super();
		this.name = name;
		this.author = author;
		this.price = price;
		this.is_recommended = is_recommended;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getIs_recommended() {
		return is_recommended;
	}
	public void setIs_recommended(String is_recommended) {
		this.is_recommended = is_recommended;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", price=" + price + ", is_recommended="
				+ is_recommended + "]";
	}
}
