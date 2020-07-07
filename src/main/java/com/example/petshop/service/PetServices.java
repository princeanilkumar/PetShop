package com.example.petshop.service;

import java.util.List;

import com.example.petshop.dtos.PetResponseDto;
import com.example.petshop.exceptions.petNotFoundException;

/**
 * @author anilkumar
 *
 */
public interface PetServices {

	/**
	 * @param petname
	 * @return list
	 * @throws petNotFoundException
	 */
	List<PetResponseDto> getAllPetsByPetName(String petname) throws petNotFoundException;

}
