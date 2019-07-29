package me.bookstore.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@GeneratedValue
	@Id
	private Integer id;
	
	private String name;
	private String surname;
	private Date dateOfBirth;
//	private List<Integer> books;
	
	protected User() {
		
	}
	
	public User(Integer id, String name, String surname, Date dateOfBirth) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
//		this.books = books;
	}

	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void setDateOfBirth(Date date_of_Birth) {
		this.dateOfBirth = date_of_Birth;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", dateOfBirth=" + dateOfBirth
				+ "]";
	}
	
}
