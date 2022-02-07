package com.qa.customers.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.customers.domain.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

}
