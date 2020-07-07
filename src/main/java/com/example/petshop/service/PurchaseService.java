package com.example.petshop.service;

import java.util.List;

import com.example.petshop.dtos.PurchaseRequestDto;
import com.example.petshop.dtos.PurchaseResponseDto;
import com.example.petshop.exceptions.OutOfPurchaseException;
import com.example.petshop.exceptions.PurchasesNotFoundException;

public interface PurchaseService {

	List<PurchaseResponseDto> getAllPurchasesByuserId(int userId) throws PurchasesNotFoundException;

	boolean savesavePurchaseDetails(PurchaseRequestDto purchaseRequestDto) throws OutOfPurchaseException;

}
