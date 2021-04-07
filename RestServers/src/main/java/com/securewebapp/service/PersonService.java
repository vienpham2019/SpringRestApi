package com.securewebapp.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
	
	public Optional<Person> getPersonById (UUID id){
		return personDao.selectPeopleById(id); 
	}
	
	public int deletePerson(UUID id) {
		return personDao.deletePersonById(id); 
	}
	
	public int updatePerson(UUID id, Person person) {
		return personDao.updatePersonById(id, person); 
	}
}
