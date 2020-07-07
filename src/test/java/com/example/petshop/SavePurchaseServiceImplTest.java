package com.example.petshop;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import com.example.petshop.dao.PurchaseDao;
import com.example.petshop.dtos.PurchaseRequestDto;
import com.example.petshop.exceptions.OutOfPurchaseException;
import com.example.petshop.models.Purchase;
import com.example.petshop.serviceImpl.PurchaseServiceImpl;

@ExtendWith(MockitoExtension.class)
public class SavePurchaseServiceImplTest {
	
	Purchase purchase;
	
	@Mock
	PurchaseDao perchaseDao;
	
	@InjectMocks
	PurchaseServiceImpl purchaseServiceImpl;
	
	PurchaseRequestDto perchaseRequestDto;
	
	@BeforeEach
	public void setUp() {
		perchaseRequestDto=new PurchaseRequestDto();
		perchaseRequestDto.setNoOfPets(2);
		perchaseRequestDto.setPetId(1);
		perchaseRequestDto.setUserId(1);
		
	}
	
	@Test
	public void savePurchaseDetailsTest() throws OutOfPurchaseException {
		
		//given
		when(perchaseDao.save(any(Purchase.class))).thenReturn(any(Purchase.class));
		
		//when
		purchaseServiceImpl.savesavePurchaseDetails(perchaseRequestDto);
		
		//then
		verify(perchaseDao).save(any(Purchase.class));
	}
	
	

}
