package com.priceproject.app.infrastructure;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.priceproject.app.domain.model.Price;
import com.priceproject.app.domain.repository.PriceRepository;

@Component
public class EntityManager {
	
	@Autowired
	private PriceRepository priceRepository;
	
	public List<Price> getAllPrices(){
		
		return priceRepository.findAll();
	}

}
