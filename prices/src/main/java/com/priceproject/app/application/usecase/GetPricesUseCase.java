package com.priceproject.app.application.usecase;

import java.time.DateTimeException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.priceproject.app.domain.model.ErrorOutput;
import com.priceproject.app.domain.model.Output;

import com.priceproject.app.domain.service.PriceService;
import com.priceproject.app.infrastructure.DateParse;

@Component
public class GetPricesUseCase {
	
	@Autowired
	private PriceService priceService;
	
	public Output execute(String date, Integer productId, Integer brandId){
		DateParse dateParse = new DateParse();
		Output o;
		try {
			LocalDateTime d = dateParse.ParseStringToLocalDateTime(date);
			o = priceService.findPriceByDateAndProductIdAndBrand(d, productId, brandId);
		} catch(DateTimeException dte) {
			o = new ErrorOutput("Incorrect date format was introduced.");
		}
		return o;
	}

}
