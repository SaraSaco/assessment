package com.priceproject.app.infrastructure.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.priceproject.app.application.usecase.GetPricesUseCase;
import com.priceproject.app.domain.model.Output;

@RestController
public class PriceController {
	
	@Autowired
	GetPricesUseCase getPriceUseCase;
	
	@GetMapping("/{date}/{productId}/{brandId}")
	public Output rateByDate(@PathVariable String date,@PathVariable Integer productId, @PathVariable Integer brandId) {
		
		Output o = getPriceUseCase.execute(date, productId, brandId);
		return o;
		
	} 

}
