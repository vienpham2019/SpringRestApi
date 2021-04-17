package com.securewebapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.securewebapp.dao.AnimalDataAccessObject;
import com.securewebapp.model.Animal;

@Service
public class AnimalService {

	@Autowired
	@Qualifier("animalDao")
	private final AnimalDataAccessObject animalDao = null; 
	
	public int addAnimal(Animal animal) {
		return animalDao.insertAnimal(animal) ; 
	}
	
	public List<Animal> getAllAnimal(){
		return animalDao.selectAllAnimal();
	}
	
	public Optional<Animal> getAnimalById (int id){
		return animalDao.selectAnimalById(id); 
	}
	
	public int deleteAnimal(int id) {
		return animalDao.deleteAnimalById(id); 
	}
	
	public int updateAnimal(int id, Animal animal) {
		return animalDao.updateAnimalById(id, animal); 
	}
}
