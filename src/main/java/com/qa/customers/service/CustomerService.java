package com.qa.customers.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.customers.domain.Customer;
import com.qa.customers.repo.CustomerRepo;

@Service
public class CustomerService implements CRUDServiceInterface<Customer> {

	private CustomerRepo repo;
	
	public CustomerService(CustomerRepo repo) {
		this.repo = repo;
	}

	@Override
	public Customer create(Customer customer) {
		return this.repo.save(customer);
	}

	@Override
	public List<Customer> readAll() {
		return this.repo.findAll();
	}

	@Override
	public Customer readById(int Id) {
		Optional<Customer> optionalCustomer = this.repo.findById(Id);
		return optionalCustomer.get();
	}

	@Override
	public Customer update(int Id, Customer t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int Id) {
		// TODO Auto-generated method stub
		return false;
	}

}
