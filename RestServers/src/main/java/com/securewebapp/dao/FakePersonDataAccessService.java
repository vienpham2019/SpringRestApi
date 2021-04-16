package com.securewebapp.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.securewebapp.model.Person;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {
	
//	@Value("${spring.datasource.url}")
//	private String url; 
//	
//	@Value("${spring.datasource.username}")
//	private String username; 
//	
//	@Value("${spring.datasource.password}")
//	private String password; 
	
	private Connection mySQLConnection = null;
	
	
	public FakePersonDataAccessService(
			@Value("${spring.datasource.url}") String url , 
			@Value("${spring.datasource.username}") String username , 
			@Value("${spring.datasource.password}") String password 
			) {
		
		System.out.println(username);
		try {
			mySQLConnection = DriverManager.getConnection(url, username, password);
			System.out.println("MySQL connection extablished");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static List<Person> DB = new ArrayList<>();
	

	@Override
	public int insertPerson(UUID id, Person person) {
		DB.add(new Person(id , person.getName())); 
		return 0;
	}

	@Override
	public List<Person> selectAllPeople() {
		try(Statement stmt = mySQLConnection.createStatement()){ // create statement 
			
			// create query command 
			String query = "SELECT * FROM ecosystem.animals"; 
			// execute query code 
			ResultSet rs = stmt.executeQuery(query); 
			while(rs.next()) {
				System.out.println(rs.getString("animal_type"));
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}
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
