package com.example.petshop.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.petshop.dtos.PurchaseRequestDto;
import com.example.petshop.service.PurchaseService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class SavePurchaseControllerTest {
	
ObjectMapper objectMapper;
	
	@Mock
	PurchaseService perchaseService;
	
	@InjectMocks
	PurchaseController perchaseController;
	
	
	MockMvc mockMvc;
	
	PurchaseRequestDto purchaseRequestDto;
	
	@BeforeEach
	public void setUp() {
		objectMapper = new ObjectMapper();
		mockMvc = MockMvcBuilders.standaloneSetup(perchaseController).build();
		 
		purchaseRequestDto.setNoOfPets(2);
		purchaseRequestDto.setPetId(1);
		purchaseRequestDto.setUserId(1);
	
	}
	
	
	@Test
	public void registerTest() throws Exception{
		mockMvc.perform(post("/purchase").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(purchaseRequestDto)))
		        .andExpect(status().isOk())
		        .andExpect(jsonPath("$", Matchers.is("success")));
	}

}
