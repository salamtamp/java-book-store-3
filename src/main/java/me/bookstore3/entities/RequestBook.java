package me.bookstore3.entities;

public class RequestBook {
	private String book_name;
	private String author_name;
	private Double price;
	private String is_recommended;
	
	public RequestBook(String book_name, String author_name, Double price, String is_recommended) {
		super();
		this.book_name = book_name;
		this.author_name = author_name;
		this.price = price;
		this.is_recommended = is_recommended;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
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
		return "RequestBook [book_name=" + book_name + ", author_name=" + author_name + ", price=" + price
				+ ", is_recommended=" + is_recommended + "]";
	}
	
	
}
