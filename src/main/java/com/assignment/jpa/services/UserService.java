package com.assignment.jpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.assignment.jpa.repository.UserRepository;
import com.assignment.jpa.user.User;

//import net.bytebuddy.description.type.TypeDefinition.Sort;

//import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

@Controller
public class UserService {

	@Autowired
	UserRepository userRepository;

	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	public Optional<User> findOneUser(int id) {
		return userRepository.findById(id);
	}

	public List<User> findFirstName(String name) {
		return userRepository.findBynameLike(name);
	}

	public List<User> findByStartingName(String name) {
		return userRepository.findBynameStartingWith(name);
	}

	public List<User> findByBalance(int bal) {
		return userRepository.findWithBalance(bal);
	}

	public User findUserMaxBal() {
		return userRepository.findMax();
	}

	public List<User> findByUserSort() {
		return userRepository.findInSort(Sort.by("name"));
	}

	public List<User> findUserNameAndBal(String name, int bal) {
		return userRepository.findNameAndBal(name, bal);
	}
	public Page<User> displayPageAndSortedUser(String field,int page,int size){
		PageRequest pagable=PageRequest.of(page,size,Direction.ASC,field);
		return userRepository.findAll(pagable);
	}
	public Page<User> findByUserName(String name,Pageable page){
		return userRepository.findByName(name, page);
	}
 
	public User insertUser(User user) {
		User user1=userRepository.save(user);
		return user1;
	}

	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}

	public void updateBalance(String name, int bal) {

		userRepository.updateByName(name, bal);
	}

	public void updateUser(int id, User user) {
		User preUser = userRepository.findById(id).get();
		preUser.setName(user.getName());
		preUser.setBalance(user.getBalance());
		userRepository.save(preUser);
	}

}
