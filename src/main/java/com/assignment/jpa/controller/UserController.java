package com.assignment.jpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.jpa.exception.CustomException;
import com.assignment.jpa.services.UserService;
import com.assignment.jpa.user.User;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public List<User> allUsers() {
		return userService.findAllUsers();
	}

	@GetMapping("/users/{id}")
	public Optional<User> oneUser(@PathVariable int id) {
		Optional<User> user = userService.findOneUser(id);
		if(user.isEmpty()) {
			System.out.println("En");
			throw new CustomException("Not found");
		}
		else
			return user;
		
		
		

	}

	@GetMapping("/users/startname")
	public List<User> findByUserStartName(@RequestParam String name) {
		return userService.findByStartingName(name);
	}

	@GetMapping("/users/max")
	public User findByUserNameLength() {
		return userService.findUserMaxBal();
	}

	@GetMapping("/users/firstname")
	public List<User> findByNameFirst(String name) {
		return userService.findFirstName(name);
	}

	@GetMapping("/users/balance")
	public List<User> findByUserBalanace(int bal) {
		return userService.findByBalance(bal);
	}

	@GetMapping("/users/sort")
	public List<User> findByUserSort() {
		return userService.findByUserSort();
	}

	@GetMapping("/users/name/bal")
	public List<User> findByUserNameAndBal(String name, int bal) {
		return userService.findUserNameAndBal(name, bal);
	}

	@GetMapping("/users/pages")
	public Page<User> displayPaged(@RequestParam String field, @RequestParam int page, @RequestParam int size) {
		return userService.displayPageAndSortedUser(field, page, size);
	}

	@GetMapping("/users/pages/second")
	public Page<User> displayPageName(String name, Pageable page) {
		return userService.findByUserName(name, page);
	}

	@PostMapping("/users")
	public ResponseEntity<String> insertRecord(@RequestBody User user) {
		User user1 = userService.insertUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body("Created New User....");

	}

	@PutMapping("/users/name/{name}")
	public void updateUserByName(@PathVariable String name, @RequestParam int balance) {
		userService.updateBalance(name, balance);
	}

	@PutMapping("/users/{id}")
	public void updateUser(@PathVariable int id, @RequestBody User user) {
		userService.updateUser(id, user);
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
	}

}
