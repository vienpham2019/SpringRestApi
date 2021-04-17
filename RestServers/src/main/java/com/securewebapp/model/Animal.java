package com.securewebapp.model;

import com.securewebapp.enums.EcosystemType;
import com.securewebapp.enums.Sex;

public class Animal {
	
	private int animal_id;
	private String animal_type; 
	private int age; 
	private int weight; 
	private Sex sex; 
	private byte health; 
	private EcosystemType ecosystem;
	public int getAnimal_id() {
		return animal_id;
	}
	public void setAnimal_id(int animal_id) {
		this.animal_id = animal_id;
	}
	public String getAnimal_type() {
		return animal_type;
	}
	public void setAnimal_type(String animal_type) {
		this.animal_type = animal_type;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public Sex getSex() {
		return sex;
	}
	public void setSex(Sex sex) {
		this.sex = sex;
	}
	public byte getHealth() {
		return health;
	}
	public void setHealth(byte health) {
		this.health = health;
	}
	public EcosystemType getEcosystem() {
		return ecosystem;
	}
	public void setEcosystem(EcosystemType ecosystem) {
		this.ecosystem = ecosystem;
	} 
	
	
}
