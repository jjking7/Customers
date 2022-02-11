package com.qa.customers.service;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.customers.domain.Customer;
import com.qa.customers.repo.CustomerRepo;

@SpringBootTest
public class ServiceUnitTest {

	private Customer customer;
	private Customer mockCustomer;
	private Customer customer1;
	private Customer customer2;
	
	@Autowired
	private CustomerService customerService;
	
	@MockBean
	private CustomerRepo customerRepo;
	
	
	@BeforeEach
	public void initsetup() {
		customer = new Customer("Fred", 21, "fred@mail@com");
		mockCustomer = new Customer(1L, "Fred", 21, "fred@mail.com");
		customer1 = new Customer("Jeff", 25, "jeff@mail.com");
		customer2 = new Customer("John", 29, "john@mail.com");
	}
		//First we create a customer
		
		
//	}
	
	//Create
	@Test
	public void createCustomerTest() {
		
		Mockito.when(this.customerRepo.save(customer)).thenReturn(mockCustomer);

		assertThat(this.customerService.create(customer)).isEqualTo(mockCustomer);

		Mockito.verify(this.customerRepo, Mockito.times(1)).save(customer);
		
	}
	
	//ReadAll
	@Test
	public void readAllCustomerTest() {
		
		List<Customer> list = List.of(customer, customer1, customer2);
		
		Mockito.when(this.customerRepo.findAll()).thenReturn(list);
		
		assertThat(this.customerService.readAll()).isEqualTo(list);
		
		Mockito.verify(this.customerRepo, Mockito.times(1)).findAll();
	}
	
	//ReadById 
	@Test
	public void readByIdTest() {
		
		Mockito.when(customerRepo.findById(1L)).thenReturn(Optional.ofNullable(mockCustomer));
		Customer test = this.customerService.readById(1L);
		
		assertThat(test.getName()).isEqualTo("Fred");
		assertThat(test.getAge()).isEqualTo(21);
		assertThat(test.getEmail()).isEqualTo("fred@mail.com");
	}
	
	//Update
//	@Test
//	public void updateCustomerTest() {
	
	//Delete
//	@Test
//	public void deleteCustomerTest() {

}