package com.priceproject.app.domain.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.priceproject.app.domain.model.ErrorOutput;
import com.priceproject.app.domain.model.Output;
import com.priceproject.app.domain.model.Price;
import com.priceproject.app.domain.model.PriceOutput;
import com.priceproject.app.infrastructure.EntityManager;

@Service
@Component
public class PriceService {
	
	@Autowired
	private EntityManager entityManager;
	
	public Output findPriceByDateAndProductIdAndBrand(LocalDateTime date, Integer productId, Integer brandId){
		Output out;
		List<Price> priceList = new ArrayList<>();
		priceList = entityManager.getAllPrices();
	
		List<Price> pricesInInterval = priceList
				  	.stream()
				  	.filter(price -> brandId.equals(price.getBrandId()))
				  	.filter(price -> productId.equals(price.getProductId()))
	                .filter(price -> checkIfIsContainedInDateRange(price, date))
	                .sorted((price1, price2) -> price1.compareTo(price2))
	                .collect(Collectors.toList());
		
		if(pricesInInterval.isEmpty()) {
			out = new ErrorOutput("There is no price match");
		}
		else {
			out = new PriceOutput(pricesInInterval.get(0));
		}
		return out;
	}
	
	private Boolean checkIfIsContainedInDateRange(Price price, LocalDateTime currentDate){
		Boolean sol = currentDate.isEqual(price.getStartDate()) 
				 || currentDate.isEqual(price.getEndDate()) 
				 || (currentDate.isAfter(price.getStartDate()) && currentDate.isBefore(price.getEndDate()));
		System.out.println("sssssssssssssssssssss");
		System.out.println(sol);
		System.out.println("sssssssssssssssssssss");
		 return sol;
	}

}
