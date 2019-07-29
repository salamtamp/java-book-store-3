package me.bookstore3.entities;

import java.util.Date;

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
	private Date date_of_birth;
	private String username;
	private String password;
	protected User() {
		
	}
	
	public User(String name, String surname, Date date_of_birth, String username, String password) {
		super();
		this.name = name;
		this.surname = surname;
		this.date_of_birth = date_of_birth;
		this.username = username;
		this.password = password;
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
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", date_of_birth=" + date_of_birth
				+ ", username=" + username + ", password=" + password + "]";
	}
		
}


/* 
== Mock user data == 
 
{
	"name": "Ashley",
	"surname": "Davis",
	"date_of_birth": "1988-05-01",
	"username": "user_01",
	"password": "user_01_pass"
},
{
	"name": "Sarah",
	"surname": "Brown",
	"date_of_birth": "1992-03-27",
	"username": "user_02",
	"password": "user_02_pass"
},
{
	"name": "Nicole",
	"surname": "Moore",
	"date_of_birth": "1987-10-14",
	"username": "user_03",
	"password": "user_03_pass"
},
{
	"name": "Elizabeth",
	"surname": "Blaese",
	"date_of_birth": "2001-01-31",
	"username": "user_04",
	"password": "user_04_pass"
},
{
	"name": "Amanda",
	"surname": "Smith",
	"date_of_birth": "1913-10-21",
	"username": "user_05",
	"password": "user_05_pass"
}

*/