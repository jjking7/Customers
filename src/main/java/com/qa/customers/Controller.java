package com.qa.customers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.customers.domain.Customer;

@RestController
@RequestMapping(path = "/customers")
public class Controller {
	
	public List<Customer> customers = new ArrayList<>();
	
	//Create
	@PostMapping("/postcustomer")
	public ResponseEntity<?> postCustomer(@RequestBody Customer c) {
		customers.add(c);
		return new ResponseEntity<Customer>(c, HttpStatus.CREATED);
	}
	
}
