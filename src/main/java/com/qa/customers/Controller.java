package com.qa.customers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	//Read
	@GetMapping(path = "/getById/{Id}")
	public ResponseEntity<?> getCustomer(@PathVariable Optional<Integer> Id) {
		if (Id.isPresent()) {
			return new ResponseEntity<Customer>(customers.get(Id.get()), HttpStatus.FOUND);
		} else {
			return new ResponseEntity<List<Customer>>(customers, HttpStatus.NOT_FOUND);
		}
	}
	
	//Update
	@PutMapping(path = "/updateById/{Id}")
	public ResponseEntity<?> putCustomer(@PathVariable int Id, @RequestBody Customer c) {			
		try {
		customers.set(Id, c);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);		
		}
		
		return new ResponseEntity<Customer>(c, HttpStatus.ACCEPTED);
		}
	
	//Delete
	@DeleteMapping(path = "/DeleteById/{Id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable int Id) {
		try {
			Customer toBeRemoved = customers.get(Id);
			customers.remove(Id);
			return new ResponseEntity<Customer>(toBeRemoved, HttpStatus.ACCEPTED);
		
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
