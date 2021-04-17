package com.securewebapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.securewebapp.service.AnimalService;

@RequestMapping("api/v1/animal")
@RestController
public class AnimalController {
	
	@Autowired
	private final AnimalService animalService = null; 
}
