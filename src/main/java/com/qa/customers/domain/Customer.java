package com.qa.customers.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int Id;
	
	@NotNull(message = "Please enter a name")
	@Column
	private String name;
	
	@Column
	private int age;
	
	@Column
	private String email;
	
	//Getters & Setters

		public int getId() {
			return Id;
		}

		public void setId(int Id) {
			this.Id = Id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
		
		public void setEmail(String email) {
			this.email = email;
		}
		
		public String getEmail() {
			return email;
		}
		
		//Constructors
		
		public Customer() {
		}

		public Customer(int Id, String name, int age, String email) {
			this.Id = Id;
			this.name = name;
			this.age = age;
			this.email = email;
		}

		public Customer(String name, int age, String email) {
			this.name = name;
			this.age = age;
			this.email = email;
		}
	
}
