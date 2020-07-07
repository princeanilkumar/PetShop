package com.example.petshop.dtos;

import java.time.LocalDate;

public class PurchaseResponseDto {
	private String petName;
	private int noOfPets;
	private int totalCost;
	private LocalDate date;
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public int getNoOfPets() {
		return noOfPets;
	}
	public void setNoOfPets(int noOfPets) {
		this.noOfPets = noOfPets;
	}
	public int getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}

}
