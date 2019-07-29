package me.bookstore3.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RequestUser {
	private String username;
	private String password;
	private Date date_of_birth;
	
	protected RequestUser() {
		
	}
	
	public RequestUser(String username, String password, Date date_of_birth) {
		super();
		this.username = username;
		this.password = password;
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
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(String date_of_birth) {
		try {
			String date = date_of_birth.replace("/", "-");
			this.date_of_birth = new SimpleDateFormat("dd-MM-yyyy").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	@Override
	public String toString() {
		return "RequestUser [username=" + username + ", password=" + password + ", date_of_birth=" + date_of_birth
				+ "]";
	}
}

/*
 {"username": "john.doe", "password": "thisismysecret",	"date_of_birth":	"15/01/1985"}
 * */
