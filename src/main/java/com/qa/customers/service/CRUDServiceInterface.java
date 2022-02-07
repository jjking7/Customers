package com.qa.customers.service;

import java.util.List;

public interface CRUDServiceInterface<T> {
	
	//CRUD
	
		//Create
		T create(T t);
		
		//Read
		List<T> readAll();

}
