package com.securewebapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.securewebapp.enums.EcosystemType;
import com.securewebapp.enums.Sex;

public class Animal extends Object {

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

	public Animal(@JsonProperty("animal_type") String animal_type, @JsonProperty("age") int age,
			@JsonProperty("weight") int weight, @JsonProperty("sex") String sex, @JsonProperty("health") byte health,
			@JsonProperty("ecosystem") String ecosystem) {
		super();
		this.animal_type = animal_type;
		this.age = age;
		this.weight = weight;
		this.sex = Sex.valueOf(sex);
		this.health = health;
		this.ecosystem = EcosystemType.valueOf(ecosystem);

	}

	@Override
	public String toString() {
		String rs = "Animal type: " + this.getAnimal_type() + ". age: " + this.getAge() + ". weight: "
				+ this.getWeight() + ", sex: " + this.getSex() + ". health: " + this.getHealth() + ". ecosystem: "
				+ this.getEcosystem();
		return rs;
	}

}
