package com.example.petshop.service;

import java.util.List;

import com.example.petshop.dtos.PurchaseRequestDto;
import com.example.petshop.dtos.PurchaseResponseDto;
import com.example.petshop.exceptions.OutOfPurchaseException;
import com.example.petshop.exceptions.PurchasesNotFoundException;

/**
 * @author anilkumar
 *
 */
public interface PurchaseService {

	/**
	 * @param userId
	 * @return list
	 * @throws PurchasesNotFoundException
	 */
	List<PurchaseResponseDto> getAllPurchasesByuserId(int userId) throws PurchasesNotFoundException;

	/**
	 * @param purchaseRequestDto
	 * @return boolean
	 * @throws OutOfPurchaseException
	 */
	boolean savesavePurchaseDetails(PurchaseRequestDto purchaseRequestDto) throws OutOfPurchaseException;

}
