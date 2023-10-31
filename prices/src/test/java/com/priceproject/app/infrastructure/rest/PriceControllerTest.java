package com.priceproject.app.infrastructure.rest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.priceproject.app.domain.model.ErrorOutput;

class PriceControllerTest {

	private static String bId;
	private static String pId;
	private static PriceController priceController;
	private ErrorOutput errExpected;
	private String date;
	
	
	@BeforeAll
	public static void onload() {
		bId = "1";
		pId ="35455";
		priceController = new PriceController();
	}
	
	@Test
	public void testBrandIdIsNull(){
		date="2020-06-14-10.00.00";
		
		errExpected = new ErrorOutput("The param brandId is mandatory");
		ErrorOutput eo = (ErrorOutput)priceController.rateByDate("noData", pId, date);
		assertTrue(errExpected.equals(eo));
	}
	
	@Test
	public void testProductIdIsNull(){
		date="2020-06-14-10.00.00";
		
		errExpected = new ErrorOutput("The param productId is mandatory");
		ErrorOutput eo = (ErrorOutput)priceController.rateByDate(bId, "noData", date);
		assertTrue(errExpected.equals(eo));
	}
	
	@Test
	public void testDateIsNull(){
	
		errExpected = new ErrorOutput("The param date is mandatory");
		
		ErrorOutput eo = (ErrorOutput)priceController.rateByDate(bId, pId, "noData");
		
		assertTrue(errExpected.equals(eo));
	}
	

}
