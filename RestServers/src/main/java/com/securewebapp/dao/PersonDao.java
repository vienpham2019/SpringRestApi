package com.securewebapp.dao;

import java.util.List;
import java.util.UUID;

import com.securewebapp.model.Person;

public interface PersonDao {

	int insertPerson(UUID id , Person person); 
	
	default int insertPerson(Person person) {
		UUID id = UUID.randomUUID(); 
		
		return insertPerson(id, person); 
	}
	
	List<Person> selectAllPeople() ; 
}
