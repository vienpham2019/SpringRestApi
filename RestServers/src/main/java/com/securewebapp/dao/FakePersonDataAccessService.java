package com.securewebapp.dao;

import java.util.ArrayList;
import java.util.List;
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

}
