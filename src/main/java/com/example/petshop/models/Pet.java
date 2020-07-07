package com.example.petshop.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int petId;
	private String petName;
	private String petDescription;
	private int noOfPetsAvailable;
	private int cost;
	public int getPetId() {
		return petId;
	}
	public void setPetId(int petId) {
		this.petId = petId;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public String getPetDescription() {
		return petDescription;
	}
	public void setPetDescription(String petDescription) {
		this.petDescription = petDescription;
	}
	public int getNoOfPetsAvailable() {
		return noOfPetsAvailable;
	}
	public void setNoOfPetsAvailable(int noOfPetsAvailable) {
		this.noOfPetsAvailable = noOfPetsAvailable;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
}
