package com.securewebapp.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.securewebapp.model.Animal;
import com.securewebapp.model.Person;
import com.securewebapp.service.AnimalService;

@RequestMapping("api/v1/animal")
@RestController
public class AnimalController {
	
	@Autowired
	private final AnimalService animalService = null; 
	
	@PostMapping
	public void addPerson(@RequestBody Animal animal) {
		animalService.addAnimal(animal); 
	}
	
	@GetMapping
	public List<Animal> getAllAnimal(){
		return animalService.getAllAnimal();
	}
	
	@GetMapping(path = "{id}")
	public Optional<Animal> getAnimalById(@PathVariable("id") int id) {
		return animalService.getAnimalById(id); 
	}
}
