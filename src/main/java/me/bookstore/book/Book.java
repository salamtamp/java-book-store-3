package me.bookstore.book;

public class Book {
	private Integer id;
	private String name;
	private String author;
	private Double price;
	private String recommended;
	
	public Book(Integer id, String name, String author, Double price, String recommended) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
		this.recommended = recommended;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}

	public String getRecommended() {
		return recommended;
	}

	public void setRecommended(String recommended) {
		this.recommended = recommended;
	}
	
}
