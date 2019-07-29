package me.bookstore3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import me.bookstore3.entities.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer>{

}
