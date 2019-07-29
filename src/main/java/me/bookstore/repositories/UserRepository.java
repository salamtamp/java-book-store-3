package me.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import me.bookstore.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
