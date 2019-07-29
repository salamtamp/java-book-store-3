package me.bookstore.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.bookstore.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	private static List<User> users = new ArrayList<>();
	private static int usersCount = 0;
	
	public List<User> findAll() {
//		return users;
		return userRepository.findAll();
	}
	
	public User findOne(int id) {
		for(User user: users) {
			if(user.getId()==id) {
				return user;
			}
		}
		
		return null;
	}

	public User updateOne(int id, User newUser) {
		for(User user: users) {
			if(user.getId()==id) {
				user = newUser;
				return user;
			}
		}
		
		return null;
 	}
	
	public void create(User user) {
//		if (user.getId() == null) {
//			user.setId(++usersCount);
//		}
//		
//		users.add(user);
		
		userRepository.save(user);
//		return user;
	}
}
