package me.bookstore.user;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Register {
	private String username;
	private String password;
	private Date date_of_birth;
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		try {
			this.date_of_birth = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date_of_birth);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
