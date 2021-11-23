package com.assignment.jpa.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	private Integer userId;
	private String name;
	private Integer balance;

	public User() {
	}

	public User(String name, Integer balance) {
		this.name = name;
		this.balance = balance;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", balance=" + balance + "]";
	}

}
