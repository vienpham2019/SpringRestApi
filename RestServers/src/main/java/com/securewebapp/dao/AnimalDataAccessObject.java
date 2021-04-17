package com.securewebapp.dao;

import java.util.List;
import java.util.Optional;

import com.securewebapp.model.Animal;

public class AnimalDataAccessObject implements AnimalDao {

	@Override
	public int insertAnimal(Animal animal) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Animal> selectAllAnimal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Animal> selectAnimalById(int id) {
		// TODO Auto-generated method stub
		return null;
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
