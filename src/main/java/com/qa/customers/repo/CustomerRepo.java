package com.qa.customers.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.customers.domain.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long>{

//	@Query("SELECT s FROM Customer s WHERE s.id = ?1")
//	Optional<Customer> findCustomerById(Long Id);

}
