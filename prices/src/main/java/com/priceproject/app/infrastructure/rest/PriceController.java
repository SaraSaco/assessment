package com.priceproject.app.infrastructure.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.priceproject.app.application.usecase.GetPricesUseCase;
import com.priceproject.app.domain.model.ErrorOutput;
import com.priceproject.app.domain.model.Output;
import com.priceproject.app.infrastructure.Validate;

@RestController
@RequestMapping("/prices")
public class PriceController {
	
	@Autowired
	GetPricesUseCase getPriceUseCase;
	
	Validate validate = new Validate();
		
	@RequestMapping(value = "")
	public Output rateByDate(@RequestParam (name = "brandId", defaultValue = "noData" ) String brandId, 
							 @RequestParam (name = "productId", defaultValue = "noData" ) String productId, 
							 @RequestParam (name = "date", defaultValue = "noData" ) String date) {
	
		Integer bId;
		Integer pId;
		ErrorOutput errorParamPrice;
		LocalDateTime d;
		
		
		errorParamPrice = validate.validateParamNullValue("brandId",brandId);
		if (errorParamPrice != null) {
			return errorParamPrice;
		} else {
			bId = validate.validateInteger(brandId);
			if (bId == -1 || bId < 0) {
				ErrorOutput errorPrice = new ErrorOutput("brandId must be a positive integer.");
				return errorPrice;
			}
		}
		
		errorParamPrice = validate.validateParamNullValue("productId",productId);
		if (errorParamPrice != null) {
			return errorParamPrice;
		}else{
			pId = validate.validateInteger(productId);
			if (pId == -1 || pId < 0) {
				ErrorOutput errorPrice = new ErrorOutput("productId must be a positive integer.");
				return errorPrice;
			}
		}
		
		errorParamPrice = validate.validateParamNullValue("date",date);
		if (errorParamPrice != null) {
			return errorParamPrice;
		}else{
			d = validate.validateDate(date);
			if(d.equals(null)){
				ErrorOutput errorPrice = new ErrorOutput("date must have this format: yyyy-MM-dd.HH.mm.ss");
				return errorPrice;
			}
		}
		
		Output o = getPriceUseCase.execute(d, pId, bId);
		return o;
		
	} 

}
