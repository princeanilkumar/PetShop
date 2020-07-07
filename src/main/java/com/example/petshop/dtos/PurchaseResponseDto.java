package com.example.petshop.dtos;

import java.time.LocalDate;

/**
 * @author anilkumar
 *
 */
public class PurchaseResponseDto {
	private int noOfPets;
	private int totalCost;
	private LocalDate date;
	
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
