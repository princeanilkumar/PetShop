package com.example.petshop.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.petshop.models.Pet;

public interface PetDao extends CrudRepository<Pet, Integer>{
	
	@Query(value = "select * from pet p where p.pet_name like %:petname%",nativeQuery = true)
	Optional<List<Pet>> getAllPetsByPetName(String petname);
	
	@Query(value="select p.no_of_pets_available from pet p where p.pet_id=:petId",nativeQuery = true)
	int findNoOfPetsAvailableByPetId(int petId);
	
	@Query(value="select p.cost from pet p where p.pet_id=:petId",nativeQuery = true)
	int findCostByPetId(int petId);

}
