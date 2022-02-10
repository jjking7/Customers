package com.qa.customers.domain;

import org.junit.Assert;
import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class DomainTest {
	
	@Test
	public void IdTest() {
		
	}
	
	@Test
	public void testEquals_Symmetric() {
	    Customer x = new Customer(1L, "Fred", 21, "fred@mail.com");
	    Customer y = new Customer(1L, "Fred", 21, "fred@mail.com");
	    Assert.assertTrue(x.equals(y) && y.equals(x));
	    Assert.assertTrue(x.hashCode() == y.hashCode());
	}
	
//	@Test
//	public void testEquals() {
//		EqualsVerifier.simple().forClass(Customer.class).verify();
//		}
	
	@Test
	public void testToString() {
		Customer customerz = new Customer();
	    String expected = "Customer [Id=null, name=null, age=0, email=null]";
	    Assert.assertEquals(expected, customerz.toString());
	}
	

}
