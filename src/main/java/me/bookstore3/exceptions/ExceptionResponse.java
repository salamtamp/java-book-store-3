package me.bookstore3.exceptions;

import java.util.Date;

public class ExceptionResponse {
	private Date timestamp;
	private String message;
	private String httpCodeMessage;
	
	public ExceptionResponse(Date timestamp, String message, String httpCodeMessage) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.httpCodeMessage = httpCodeMessage;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getHttpCodeMessage() {
		return httpCodeMessage;
	}
	public void setHttpCodeMessage(String httpCodeMessage) {
		this.httpCodeMessage = httpCodeMessage;
	}
	@Override
	public String toString() {
		return "ExceptionResponse [timestamp=" + timestamp + ", message=" + message + ", httpCodeMessage="
				+ httpCodeMessage + "]";
	}
}