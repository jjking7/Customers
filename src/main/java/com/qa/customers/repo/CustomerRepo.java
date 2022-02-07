package com.qa.customers.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.customers.domain.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>{

}
