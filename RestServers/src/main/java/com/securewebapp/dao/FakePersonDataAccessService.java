package com.securewebapp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.securewebapp.model.Person;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

	private static List<Person> DB = new ArrayList<>();

	@Override
	public int insertPerson(UUID id, Person person) {
		DB.add(new Person(id , person.getName())); 
		return 0;
	}

	@Override
	public List<Person> selectAllPeople() {

		return DB;
	}

	@Override
	public Optional<Person> selectPeopleById(UUID id) {
		return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
	}

	@Override
	public int deletePersonById(UUID id) {
		Optional<Person> personValue = selectPeopleById(id); 

		if (personValue.isPresent()) {
			DB.remove(personValue.get()); ; 
			return 1; 
		}
		
		return 0;
	}

	@Override
	public int updatePersonById(UUID id, Person person) {
		return selectPeopleById(id).map(p -> {
			System.out.println(p);
			int indexOfPersonToUpdate = DB.indexOf(p); 
			if(indexOfPersonToUpdate >= 0) {
				DB.set(indexOfPersonToUpdate, new Person(id , person.getName())); 
				return 1; 
			}
			return 0; 
		}).orElse(0);
	}

}
