package com.example.petshop.service;

import java.util.List;

import com.example.petshop.dtos.PetResponseDto;
import com.example.petshop.exceptions.petNotFoundException;

public interface PetServices {

	List<PetResponseDto> getAllPetsByPetName(String petname) throws petNotFoundException;

}
