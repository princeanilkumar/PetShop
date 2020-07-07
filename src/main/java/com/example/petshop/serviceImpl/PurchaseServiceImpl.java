package com.example.petshop.serviceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.petshop.dao.PetDao;
import com.example.petshop.dao.PurchaseDao;
import com.example.petshop.dtos.PurchaseRequestDto;
import com.example.petshop.dtos.PurchaseResponseDto;
import com.example.petshop.exceptions.OutOfPurchaseException;
import com.example.petshop.exceptions.PurchasesNotFoundException;
import com.example.petshop.models.Pet;
import com.example.petshop.models.Purchase;
import com.example.petshop.service.PurchaseService;

/**
 * @author anilkumar
 *
 */
@Service
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	PurchaseDao purchaseDao;
	
	@Autowired
	PetDao petDao;
	
	

	/**
	 * throw PurchasesNotFoundException
	 * return list of purchases
	 */
	@Override
	public List<PurchaseResponseDto> getAllPurchasesByuserId(int userId) throws PurchasesNotFoundException {
		Optional<List<Purchase>> petsOptional = purchaseDao.getAllPurchasesByPetName(userId);
		if (petsOptional.isPresent()) {
			return petsOptional.get().stream().map(purchase -> getHotelDto(purchase)).collect(Collectors.toList());
		}

		throw new PurchasesNotFoundException("There exists no purchases with the given userid:" + userId);
	}

	private PurchaseResponseDto getHotelDto(Purchase purchase) {
		PurchaseResponseDto purchaseresponseDto = new PurchaseResponseDto();
		BeanUtils.copyProperties(purchase, purchaseresponseDto);
		return purchaseresponseDto;
	}

	/**throw OutOfPurchaseException
	 *return boolean
	 */
	@Override
	public boolean savesavePurchaseDetails(PurchaseRequestDto purchaseRequestDto) throws OutOfPurchaseException {
		Purchase purchase = new Purchase();
		if (purchaseRequestDto.getNoOfPets() > 2) {
			throw new OutOfPurchaseException("there is a limit 2 only");
		}
		BeanUtils.copyProperties(purchaseRequestDto, purchase);
		purchase.setDate(LocalDate.now());
		purchase.setTotalCost(
		petDao.findCostByPetId(purchaseRequestDto.getPetId()) * purchaseRequestDto.getNoOfPets());
		Purchase purchase1 = purchaseDao.save(purchase);
	     Pet pet=petDao.findById(purchaseRequestDto.getPetId()).get();
	    pet.setNoOfPetsAvailable(petDao.findNoOfPetsAvailableByPetId(purchaseRequestDto.getPetId())-purchaseRequestDto.getNoOfPets());
	    petDao.save(pet);
		if (purchase1 != null) {
			return true;
		}
		return false;
	}

}
