package me.bookstore3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import me.bookstore3.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
