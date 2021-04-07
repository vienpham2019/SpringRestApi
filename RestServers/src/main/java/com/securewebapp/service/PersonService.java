package com.securewebapp.service;

import com.securewebapp.dao.PersonDao;
import com.securewebapp.model.Person;

public class PersonService {

	private final PersonDao personDao; 
	
	
	public PersonService(PersonDao personDao) {
		super();
		this.personDao = personDao;
	}

	public int addPerson(Person person) {
		return personDao.insertPerson(person) ; 
	}
	
}
