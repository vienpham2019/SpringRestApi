package com.securewebapp.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.securewebapp.model.Person;
import com.securewebapp.service.PersonService;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

	@Autowired
	private final PersonService personService = null;
	
	@PostMapping
	public void addPerson(@RequestBody Person person) {
		personService.addPerson(person); 
	}
	
	@GetMapping
	public List<Person> getAllPeople(){
		return personService.getAllPeople(); 
	}
	
}
