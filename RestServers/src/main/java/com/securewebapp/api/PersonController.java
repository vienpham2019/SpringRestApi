package com.securewebapp.api;

import com.securewebapp.model.Person;
import com.securewebapp.service.PersonService;

public class PersonController {

	private final PersonService personService;

	public PersonController(PersonService personService) {
		super();
		this.personService = personService;
	} 
	
	public void addPerson(Person person) {
		personService.addPerson(person); 
	}
	
}
