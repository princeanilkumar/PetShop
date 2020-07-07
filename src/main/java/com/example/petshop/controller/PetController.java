package com.example.petshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.petshop.dtos.PetResponseDto;
import com.example.petshop.dtos.StatusRequestDto;
import com.example.petshop.exceptions.petNotFoundException;
import com.example.petshop.service.PetServices;


@RestController
public class PetController {
	@Autowired
	PetServices petSetvices;
	
	
	@PostMapping("/pets/petname")
	public List<PetResponseDto> getAllPetsByPetName(@RequestParam("petname") String petname) throws petNotFoundException {
		
		return petSetvices.getAllPetsByPetName(petname);
	}
	
	@ExceptionHandler(petNotFoundException.class)
	public ResponseEntity<StatusRequestDto> exceptionHandler(petNotFoundException exception){
		 StatusRequestDto errorresponse=new StatusRequestDto();
	        errorresponse.setStatusCode(500);
	        errorresponse.setMessage(exception.getMessage());
		return new ResponseEntity<>(errorresponse,HttpStatus.NOT_FOUND);
	}
}
