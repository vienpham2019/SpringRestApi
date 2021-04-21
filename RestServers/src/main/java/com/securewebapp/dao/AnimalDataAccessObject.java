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

	public AnimalDataAccessObject(@Value("${spring.datasource.url}") String url,
			@Value("${spring.datasource.username}") String username,
			@Value("${spring.datasource.password}") String password) {

		try {
			mySQLConnection = DriverManager.getConnection(url, username, password);
			System.out.println("MySQL connection extablished");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insertAnimal(Animal animal) {
		// TODO Auto-generated method stub
		animal.setAnimal_id(++count);
		try (Statement stmt = mySQLConnection.createStatement()) {

			String query = "INSERT INTO ecosystem.animals VALUES(" + animal.getAnimal_id() + ", '"
					+ animal.getAnimal_type() + "', " + animal.getAge() + ", " + animal.getWeight() + ", '"
					+ animal.getSex() + "', " + animal.getHealth() + ", '" + animal.getEcosystem() + "');";

			// Execute the query and wait for the result set
			int result = stmt.executeUpdate(query);
			if (result == 1) {
				System.out.println(result + " rows inserted: " + animal);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Animal> selectAllAnimal() {
		// Create statement
		try (Statement stm = mySQLConnection.createStatement()) {
			// execute query
			ResultSet rs = stm.executeQuery("SELECT * FROM ecosystem.animals ;");

			while (rs.next()) {
				Animal a = new Animal(rs.getString("animal_type"), rs.getInt("age"), rs.getInt("weight"),
						rs.getString("sex"), rs.getByte("health"), rs.getString("ecosystem"));
				a.setAnimal_id(rs.getInt("animal_id"));

				DB.add(a);
				count = a.getAnimal_id();
			}

		} catch (SQLException se) {
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
		try (Statement stmt = mySQLConnection.createStatement()) {

			String query = "UPDATE ecosystem.animals " + "SET age = " + animal.getAge() + ", weight = "
					+ animal.getWeight() + ", health = " + animal.getHealth() + "WHERE animal_id = " + id;

			int rs = stmt.executeUpdate(query);
			if (rs == 1) {
				System.out.println(animal + " has been successfully update from database with an ID: " + id);
			} else {
				System.out.println(animal + " is not exist in database.");
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}
		return 0;
	}

}
