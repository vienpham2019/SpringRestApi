package com.securewebapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.securewebapp.dao.PersonDao;
import com.securewebapp.model.Person;

@Service
public class PersonService {

	@Autowired
	@Qualifier("fakeDao")
	private final PersonDao personDao = null; 


	public int addPerson(Person person) {
		return personDao.insertPerson(person) ; 
	}
	
	public List<Person> getAllPeople(){
		return personDao.selectAllPeople();
	}
}
