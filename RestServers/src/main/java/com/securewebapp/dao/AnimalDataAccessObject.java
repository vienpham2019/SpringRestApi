package com.securewebapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.securewebapp.enums.EcosystemType;
import com.securewebapp.enums.Sex;
import com.securewebapp.model.Animal;

@Repository("animalDao")
public class AnimalDataAccessObject implements AnimalDao {
	
	private Connection mySQLConnection = null;
	private static int count = 0; 
	private static List<Animal> DB = new ArrayList<>();
	
	
	public AnimalDataAccessObject(
			@Value("${spring.datasource.url}") String url , 
			@Value("${spring.datasource.username}") String username , 
			@Value("${spring.datasource.password}") String password 
			) {
		
		try {
			mySQLConnection = DriverManager.getConnection(url, username, password);
			System.out.println("MySQL connection extablished");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private Animal setAnimalFromQuery(ResultSet rs) {
		Animal a = new Animal(); 
		try {
			a.setAnimal_id(rs.getInt("animal_id"));
			a.setAnimal_type(rs.getString("animal_type"));
			a.setAge(rs.getInt("age")); 
			a.setWeight(rs.getInt("weight"));
			a.setHealth(rs.getByte("health")); 
			a.setSex(Sex.valueOf(rs.getString("sex")));
			a.setEcosystem(EcosystemType.valueOf(rs.getString("ecosystem")));
			
			count ++; 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a; 
	}

	@Override
	public int insertAnimal(Animal animal) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Animal> selectAllAnimal() {
		// Create statement 
		try(Statement stm = mySQLConnection.createStatement()){
			// execute query
			ResultSet rs = stm.executeQuery("SELECT * FROM ecosystem.animals ;"); 
			
			while(rs.next()) {
				DB.add(setAnimalFromQuery(rs)); 
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}
		return DB;
	}

	@Override
	public Optional<Animal> selectAnimalById(int id) {
		return DB.stream().filter(animal -> animal.getAnimal_id() == id).findFirst();
	}

	@Override
	public int deleteAnimalById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateAnimalById(int id, Animal animal) {
		// TODO Auto-generated method stub
		return 0;
	}

}
