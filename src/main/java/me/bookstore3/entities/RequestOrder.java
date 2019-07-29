package me.bookstore3.entities;

import java.util.List;

public class RequestOrder {
	private List<Integer> orders;

	protected RequestOrder() {
		
	}
	
	public RequestOrder(List<Integer> orders) {
		super();
		this.orders = orders;
	}

	public List<Integer> getOrders() {
		return orders;
	}

	public void setOrders(List<Integer> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "RequestOrder [orders=" + orders + "]";
	}
	
	
}
