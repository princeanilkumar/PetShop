package com.example.petshop.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.petshop.dao.PetDao;
import com.example.petshop.dtos.PetResponseDto;
import com.example.petshop.exceptions.petNotFoundException;
import com.example.petshop.models.Pet;
import com.example.petshop.service.PetServices;

@Service
public class PetServiceImpl implements PetServices{
	@Autowired
	PetDao petDao;
	

	@Override
	public List<PetResponseDto> getAllPetsByPetName(String petname) throws petNotFoundException {
		Optional<List<Pet>> petsOptional=petDao.getAllPetsByPetName(petname);
		if(petsOptional.isPresent()) {
		return petsOptional.get().stream().map(pet->getHotelDto(pet)).collect(Collectors.toList());
	}
		
		throw new petNotFoundException("There exists no pets with the given pet name:"+petname);
	}
	
	
	private PetResponseDto getHotelDto(Pet pet) {
		PetResponseDto petresponseDto= new PetResponseDto();
		BeanUtils.copyProperties(pet, petresponseDto);
		return petresponseDto;
	}

}
