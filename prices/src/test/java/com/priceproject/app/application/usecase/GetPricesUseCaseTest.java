package com.priceproject.app.application.usecase;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.priceproject.app.domain.model.PriceOutput;
import com.priceproject.app.infrastructure.DateParse;

@SpringBootTest
public class GetPricesUseCaseTest {
	
	@Autowired
	private GetPricesUseCase useCase;
	
	private String date;

	private static DateParse dateParse;

	private static Integer productId;
	private static Integer brandId;
	private double priceExpected; 
	private LocalDateTime startDateExpected;
	private LocalDateTime endDateExpected;
	private LocalDateTime dateParsed;
	private Integer price_list;
	
	
	@BeforeAll
	public static void onload() {
		productId = 35455;
		brandId = 1;
		dateParse = new DateParse();
	}
	
	
	@Test
	public void test1() {
		
		//Given
		date="2020-06-14-10.00.00";
		dateParsed = dateParse.ParseStringToLocalDateTime(date);
		
		//When
		PriceOutput po = (PriceOutput)useCase.execute(dateParsed, productId, brandId);
		
		//Then
		priceExpected = 35.50;
		startDateExpected = LocalDateTime.of(2020, 6, 14, 0, 0, 0);
		endDateExpected = LocalDateTime.of(2020, 12, 31, 23, 59, 59);
		price_list = 1;
		assertTrue(priceExpected == po.getPrice());
		assertTrue(startDateExpected.equals(po.getStartDate()));
		assertTrue(endDateExpected.equals(po.getEndDate()));
		assertTrue(productId.equals((po.getProductId())));
		assertTrue(brandId.equals((po.getBrandId())));
		assertTrue(price_list.equals(po.getPrice_list()));
	
		
				
	
	}
	
	@Test
	public void test2() {
		
		//Given
		date="2020-06-14-16.00.00";
		dateParsed = dateParse.ParseStringToLocalDateTime(date);
		
		//When
		PriceOutput po = (PriceOutput)useCase.execute(dateParsed, productId, brandId);		
		
		//Then
		priceExpected = 25.45;
		startDateExpected = LocalDateTime.of(2020, 6, 14, 15, 0, 0);
		endDateExpected = LocalDateTime.of(2020, 6, 14, 18, 30, 0);
		price_list = 2;
		assertTrue(priceExpected == po.getPrice());
		assertTrue(startDateExpected.equals(po.getStartDate()));
		assertTrue(endDateExpected.equals(po.getEndDate()));
		assertTrue(productId.equals((po.getProductId())));
		assertTrue(brandId.equals((po.getBrandId())));
		assertTrue(price_list.equals(po.getPrice_list()));
	}
	
	@Test
	public void test3() {
		//Given
		date="2020-06-14-21.00.00";
		dateParsed = dateParse.ParseStringToLocalDateTime(date);
		
		//When
		PriceOutput po = (PriceOutput)useCase.execute(dateParsed, productId, brandId);		
		
		//Then
		priceExpected = 35.50;
		startDateExpected = LocalDateTime.of(2020, 6, 14, 0, 0, 0);
		endDateExpected = LocalDateTime.of(2020, 12, 31, 23, 59, 59);
		price_list = 1;
		assertTrue(priceExpected == po.getPrice());
		assertTrue(startDateExpected.equals(po.getStartDate()));
		assertTrue(endDateExpected.equals(po.getEndDate()));
		assertTrue(productId.equals((po.getProductId())));
		assertTrue(brandId.equals((po.getBrandId())));
		assertTrue(price_list.equals(po.getPrice_list()));
	}
	
	@Test
	public void test4() {
		//Given
		date="2020-06-15-10.00.00";
		dateParsed = dateParse.ParseStringToLocalDateTime(date);

		//When
		PriceOutput po = (PriceOutput)useCase.execute(dateParsed, productId, brandId);		
	
		//Then
		priceExpected = 30.50;
		startDateExpected = LocalDateTime.of(2020, 6, 15, 0, 0, 0);
		endDateExpected = LocalDateTime.of(2020, 6, 15, 11, 0, 0);
		price_list = 3;
		assertTrue(priceExpected == po.getPrice());
		assertTrue(startDateExpected.equals(po.getStartDate()));
		assertTrue(endDateExpected.equals(po.getEndDate()));
		assertTrue(productId.equals((po.getProductId())));
		assertTrue(brandId.equals((po.getBrandId())));
		assertTrue(price_list.equals(po.getPrice_list()));
	}
	
	@Test
	public void test5() {
		//Given
		date="2020-06-16-21.00.00";
		dateParsed = dateParse.ParseStringToLocalDateTime(date);
		
		//When
		PriceOutput po = (PriceOutput)useCase.execute(dateParsed, productId, brandId);		
	
		//Then
		priceExpected = 38.95;
		startDateExpected = LocalDateTime.of(2020, 6, 15, 16, 0, 0);
		endDateExpected = LocalDateTime.of(2020, 12, 31, 23, 59, 59);
		price_list = 4;
		assertTrue(priceExpected == po.getPrice());
		assertTrue(startDateExpected.equals(po.getStartDate()));
		assertTrue(endDateExpected.equals(po.getEndDate()));
		assertTrue(productId.equals((po.getProductId())));
		assertTrue(brandId.equals((po.getBrandId())));
		assertTrue(price_list.equals(po.getPrice_list()));
	}
	
}
