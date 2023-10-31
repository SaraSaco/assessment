package com.priceproject.app.domain.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.priceproject.app.domain.model.Output;
import com.priceproject.app.domain.model.PriceOutput;
import com.priceproject.app.infrastructure.DateParse;

@SpringBootTest
class PriceServiceTest {
	
	@Autowired
	private PriceService priceService;
	private String date;
	private static Integer productId;
	private static Integer brandId;
	private static DateParse dateParse;
	private LocalDateTime dateParsed;
	private double priceExpected; 
	private LocalDateTime startDateExpected;
	private LocalDateTime endDateExpected;
	private Integer price_list;
	
	@BeforeAll
	public static void onload() {
		productId = 35455;
		brandId = 1;
		dateParse = new DateParse();
	}
	

	@Test
	void testFindPrice() {
		//Given
		date="2020-06-14-10.00.00";
		dateParsed = dateParse.ParseStringToLocalDateTime(date);
		
		//When
		PriceOutput o = (PriceOutput) priceService.findPriceByDateAndProductIdAndBrand(dateParsed,productId,brandId);
		
		//Then
		priceExpected = 35.50;
		startDateExpected = LocalDateTime.of(2020, 6, 14, 0, 0, 0);
		endDateExpected = LocalDateTime.of(2020, 12, 31, 23, 59, 59);
		price_list = 1;
		assertTrue(priceExpected == o.getPrice());
		assertTrue(startDateExpected.equals(o.getStartDate()));
		assertTrue(endDateExpected.equals(o.getEndDate()));
		assertTrue(productId.equals((o.getProductId())));
		assertTrue(brandId.equals((o.getBrandId())));
		assertTrue(price_list.equals(o.getPrice_list()));
		
	}

}
