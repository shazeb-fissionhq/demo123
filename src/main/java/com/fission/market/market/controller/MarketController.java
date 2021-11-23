package com.fission.market.market.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fission.market.market.entity.Customers;
import com.fission.market.market.entity.Products;
import com.fission.market.market.exceptions.CustomException;
import com.fission.market.market.service.CustomerService;

@RestController
public class MarketController {
	@Autowired
	private CustomerService customerService;

	@GetMapping("/customers")
	public List<Customers> getCustomerDetails() {
		return customerService.getCustomers();
	}

	@GetMapping("/products")
	public List<Products> getProductsDetails() {
		return customerService.getProducts();
	}

	@GetMapping("/customers/{id}")
	public Optional<Customers> getSingleCustomer(@PathVariable int id) {
		Optional<Customers> cust = customerService.getSingleCustomer(id);
		if (cust.isEmpty()) {
			throw new CustomException();
		} else
			return cust;
	}

	@GetMapping("/products/{name}")
	public Optional<Products> getSingleProduct(@PathVariable String name) {
		Optional<Products> prod = customerService.getSingleProducts(name);
		if (prod.isEmpty()) {
			throw new CustomException();
		} else
			return prod;
	}

	@PostMapping("/customers")
	public ResponseEntity<String> insertCustomerDetails(@RequestBody Customers cust) {
		customerService.insertCustomer(cust);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}

	@PostMapping("/products")
	public ResponseEntity<String> insertProductDetails(@RequestBody Products prod) {
		Products prod1 = customerService.insertProducts(prod);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}

	@PutMapping("/customers/{id}")
	public void updateCustomerDetails(@PathVariable int id, @RequestBody Customers cust) {
		customerService.updateCustomerDetails(id, cust);
	}

}
