package com.example.petshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.petshop.dtos.PurchaseRequestDto;
import com.example.petshop.dtos.PurchaseResponseDto;
import com.example.petshop.dtos.StatusRequestDto;
import com.example.petshop.exceptions.OutOfPurchaseException;
import com.example.petshop.exceptions.PurchasesNotFoundException;
import com.example.petshop.service.PurchaseService;

@RestController
public class PurchaseController {
	@Autowired
	PurchaseService perchaseService;

	@GetMapping("/user/{userId}/purchases")
	public List<PurchaseResponseDto> getAllPurchasesByuserId(@PathVariable int userId)
			throws PurchasesNotFoundException {

		return perchaseService.getAllPurchasesByuserId(userId);
	}

	@PostMapping("/purchase")
	public StatusRequestDto savePurchaseDetails(@RequestBody PurchaseRequestDto purchaseRequestDto)
			throws OutOfPurchaseException {
		StatusRequestDto errorresponse = new StatusRequestDto();
		boolean purchase = perchaseService.savesavePurchaseDetails(purchaseRequestDto);
		if (purchase) {
			errorresponse.setStatusCode(200);
			errorresponse.setMessage("purchase successfull");
			return errorresponse;
		} else {
			errorresponse.setStatusCode(500);
			errorresponse.setMessage("Ivallid input");
			return errorresponse;

		}
	}

	@ExceptionHandler(PurchasesNotFoundException.class)
	public ResponseEntity<StatusRequestDto> exceptionHandler(PurchasesNotFoundException exception) {
		StatusRequestDto errorresponse = new StatusRequestDto();
		errorresponse.setStatusCode(500);
		errorresponse.setMessage(exception.getMessage());
		return new ResponseEntity<>(errorresponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(OutOfPurchaseException.class)
	public ResponseEntity<StatusRequestDto> exceptionHandler(OutOfPurchaseException exception) {
		StatusRequestDto errorresponse = new StatusRequestDto();
		errorresponse.setStatusCode(502);
		errorresponse.setMessage(exception.getMessage());
		return new ResponseEntity<>(errorresponse, HttpStatus.NOT_FOUND);
	}
}
