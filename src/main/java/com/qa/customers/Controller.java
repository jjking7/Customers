package com.qa.customers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.qa.customers.service.CustomerService;

@RestController
@RequestMapping(path = "/customers")
public class Controller {
	
	@Autowired
	CustomerService service;
	
	//Create
	@PostMapping("/postCustomer")
	public ResponseEntity<Customer> postCustomer(@RequestBody Customer c) {
		return new ResponseEntity<Customer>(this.service.create(c), HttpStatus.CREATED);
	}
	
	//Read
	@GetMapping("/getAll")
	public ResponseEntity<List<Customer>> getCustomer() {
		return new ResponseEntity<List<Customer>>(this.service.readAll(), HttpStatus.FOUND);
	}
	
	//ReadById
	@GetMapping(path = "/getById/{Id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable Long Id) {
			return new ResponseEntity<Customer>(this.service.readById(Id), HttpStatus.FOUND);
	}
	
	//Update
	@PutMapping(path = "/updateById/{Id}")
	public ResponseEntity<Customer> putCustomer(@PathVariable Long Id, @RequestBody Customer c) {			
			return new ResponseEntity<Customer>(service.updateById(Id, c), HttpStatus.ACCEPTED);	
	}
	
	//Delete
	@DeleteMapping(path = "/deleteById/{Id}")
	public ResponseEntity<Boolean> deleteCustomer(@PathVariable Long Id) {
		boolean isDeleted = service.deleteById(Id);
		if (isDeleted /* = true */) {
			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.NOT_ACCEPTABLE);
		}
		
	}
}
