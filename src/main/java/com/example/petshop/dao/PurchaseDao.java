package com.example.petshop.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.petshop.models.Purchase;

@Repository
public interface PurchaseDao extends CrudRepository<Purchase, Integer>{
	
	@Query(value = "select * from purchase p where p.user_id=:userId",nativeQuery = true)
	Optional<List<Purchase>> getAllPurchasesByPetName(int userId);
	

}
