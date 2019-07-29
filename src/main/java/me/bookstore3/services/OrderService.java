package me.bookstore3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.bookstore3.entities.Orders;
import me.bookstore3.repositories.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	public List<Orders> getAllOrder() {
		return orderRepository.findAll();
	}
	
	public Optional<Orders> getOrder(Integer id) {
		return orderRepository.findById(id);
	}
	
	public Orders createOrder(Orders order) {
		return orderRepository.save(order);
	}
}
