package com.priceproject.app.application.usecase;


import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.priceproject.app.domain.model.Output;

import com.priceproject.app.domain.service.PriceService;


@Component
public class GetPricesUseCase {
	
	@Autowired
	private PriceService priceService;
	
	public Output execute(LocalDateTime date, Integer productId, Integer brandId){
		
		Output o = priceService.findPriceByDateAndProductIdAndBrand(date, productId, brandId);;
		return o;
	}

}
