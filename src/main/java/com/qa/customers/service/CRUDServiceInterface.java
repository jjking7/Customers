package com.qa.customers.service;

import java.util.List;

public interface CRUDServiceInterface<T> {
	
	//CRUD
	
		//Create
		T create(T t);
		
		//Read
		List<T> readAll();
		
		//ReadById
		T readById(Long Id);
			
		//Update
		T updateById(Long Id, T t);
		
		//Delete
		boolean deleteById(Long Id);


}
