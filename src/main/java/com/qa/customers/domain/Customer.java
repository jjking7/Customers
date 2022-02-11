package com.qa.customers.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

//import lombok.Getter;
//import lombok.Setter;

@Entity
@Table(name="customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@NotNull(message = "Please enter a name")
	@Column
	private String name;
	
	@Column
	private int age;
	
	@Column
	private String email;
	
	//Getters & Setters

		public Long getId() {
			return Id;
		}

		public void setId(Long Id) {
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

		public Customer(Long Id, String name, int age, String email) {
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
		
		//Hash Code & Equals

		@Override
		public int hashCode() {
			return Objects.hash(Id, age, email, name);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Customer other = (Customer) obj;
			return Id == other.Id && age == other.age && Objects.equals(email, other.email)
					&& Objects.equals(name, other.name);
		}

		@Override
		public String toString() {
			return "Customer [Id=" + Id + ", name=" + name + ", age=" + age + ", email=" + email + "]";
		}		
	
}
