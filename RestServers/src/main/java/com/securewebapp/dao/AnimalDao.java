package com.securewebapp.dao;

import java.util.List;
import java.util.Optional;

import com.securewebapp.model.Animal;

public interface AnimalDao {
	int insertAnimal( Animal animal); 
	
	List<Animal> selectAllAnimal() ;
	
	Optional<Animal> selectAnimalById(int id); 
	
	int deleteAnimalById(int id); 
	
	int updateAnimalById(int id , Animal animal); 
}
