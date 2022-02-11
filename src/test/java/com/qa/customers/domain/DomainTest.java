package com.qa.customers.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//import nl.jqno.equalsverifier.EqualsVerifier;

public class DomainTest {
	
	@Test
	public void IdTest() {
		
	}
	
	@Test
	public void testEquals_Symmetric() {
	    Customer x = new Customer(1L, "Fred", 21, "fred@mail.com");
	    Customer y = new Customer(1L, "Fred", 21, "fred@mail.com");
	    Assertions.assertTrue(x.equals(y) && y.equals(x));
	    Assertions.assertTrue(x.hashCode() == y.hashCode());
	}
	
//	@Test
//	public void testEquals() {
//		EqualsVerifier.simple().forClass(Customer.class).verify();
//		}
	
	@Test
	public void testToString() {
		Customer customerz = new Customer();
	    String expected = "Customer [Id=null, name=null, age=0, email=null]";
	    Assertions.assertEquals(expected, customerz.toString());
	}
	

}
