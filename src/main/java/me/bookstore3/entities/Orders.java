package me.bookstore3.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Orders {
	@GeneratedValue
	@Id
	private Integer id;
	private Integer user_id;
	private Integer book_id;
	private Double price;
	
	protected Orders() {
		
	}

	public Orders(Integer user_id, Integer book_id, Double price) {
		super();
		this.user_id = user_id;
		this.book_id = book_id;
		this.price = price;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getBook_id() {
		return book_id;
	}
	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}
	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", user_id=" + user_id + ", book_id=" + book_id + ", price=" + price + "]";
	}

}
