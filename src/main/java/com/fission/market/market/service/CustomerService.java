package com.fission.market.market.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fission.market.market.entity.Customers;
import com.fission.market.market.entity.Products;
import com.fission.market.market.repository.CustomerRepository;
import com.fission.market.market.repository.ProductRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ProductRepository productRepository;

	public List<Customers> getCustomers() {

		System.out.println("en");
		return customerRepository.findAll();
	}

	public List<Products> getProducts() {

		return productRepository.findAll();
	}

	public void insertCustomer(Customers cust) {
		customerRepository.save(cust);
	}

	public Products insertProducts(Products prod) {
		Products prod1 = productRepository.save(prod);
		return prod1;
	}

	public void updateCustomerDetails(int id, Customers cust) {
		// TODO Auto-generated method stub
		Customers cust1=customerRepository.findById(id).get();
		cust1.setCustomerName(cust.getCustomerName());
		customerRepository.save(cust1);
	}

	public Optional<Products> getSingleProducts(String name) {
		return productRepository.findById(name);
		// TODO Auto-generated method stub
		
	}

	public Optional<Customers> getSingleCustomer(int id) {
		// TODO Auto-generated method stub
		return customerRepository.findById(id);
	}
	
	

}
