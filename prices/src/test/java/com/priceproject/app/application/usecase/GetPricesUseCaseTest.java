package com.priceproject.app.application.usecase;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.priceproject.app.domain.model.PriceOutput;
import com.priceproject.app.domain.service.PriceService;

@SpringBootTest
public class GetPricesUseCaseTest {
	
	@Autowired
	private GetPricesUseCase useCase;
	private String date;

	private static Integer productId;
	private static Integer brandId;
	private double priceExpected; 
	private  LocalDateTime startDateExpected ;
	private  LocalDateTime endDateExpected ;
	private Integer price_list;
	
	@BeforeAll
	public static void onload() {
		productId = 35455;
		brandId = 1;
	}
	
	@Test
	public void test1() {
		
		date="2020-06-14-10.00.00";
		
		// Expected output
		priceExpected = 35.50;
		startDateExpected = LocalDateTime.of(2020, 6, 14, 0, 0, 0);
		endDateExpected = LocalDateTime.of(2020, 12, 31, 23, 59, 59);
		price_list = 1;
		
		PriceOutput po = (PriceOutput)useCase.execute(date, productId, brandId);		
	
		assertTrue(priceExpected == po.getPrice());
		assertTrue(startDateExpected.equals(po.getStartDate()));
		assertTrue(endDateExpected.equals(po.getEndDate()));
		assertTrue(productId.equals((po.getProductId())));
		assertTrue(brandId.equals((po.getBrandId())));
		assertTrue(price_list.equals(po.getPrice_list()));
	}
	
	@Test
	public void test2() {
		date="2020-06-14-16.00.00";
		
		// Expected output
		priceExpected = 25.45;
		startDateExpected = LocalDateTime.of(2020, 6, 14, 15, 0, 0);
		endDateExpected = LocalDateTime.of(2020, 6, 14, 18, 30, 0);
		price_list = 2;
		
		PriceOutput po = (PriceOutput)useCase.execute(date, productId, brandId);		
	
		assertTrue(priceExpected == po.getPrice());
		assertTrue(startDateExpected.equals(po.getStartDate()));
		assertTrue(endDateExpected.equals(po.getEndDate()));
		assertTrue(productId.equals((po.getProductId())));
		assertTrue(brandId.equals((po.getBrandId())));
		assertTrue(price_list.equals(po.getPrice_list()));
	}
	
	@Test
	public void test3() {
		date="2020-06-14-21.00.00";
		
		// Expected output
		priceExpected = 35.50;
		startDateExpected = LocalDateTime.of(2020, 6, 14, 0, 0, 0);
		endDateExpected = LocalDateTime.of(2020, 12, 31, 23, 59, 59);
		price_list = 1;
		
		PriceOutput po = (PriceOutput)useCase.execute(date, productId, brandId);		
	
		assertTrue(priceExpected == po.getPrice());
		assertTrue(startDateExpected.equals(po.getStartDate()));
		assertTrue(endDateExpected.equals(po.getEndDate()));
		assertTrue(productId.equals((po.getProductId())));
		assertTrue(brandId.equals((po.getBrandId())));
		assertTrue(price_list.equals(po.getPrice_list()));
	}
	
	@Test
	public void test4() {
		date="2020-06-15-10.00.00";
		
		// Expected output
		priceExpected = 30.50;
		startDateExpected = LocalDateTime.of(2020, 6, 15, 0, 0, 0);
		endDateExpected = LocalDateTime.of(2020, 6, 15, 11, 0, 0);
		price_list = 3;
		
		PriceOutput po = (PriceOutput)useCase.execute(date, productId, brandId);		
	
		assertTrue(priceExpected == po.getPrice());
		assertTrue(startDateExpected.equals(po.getStartDate()));
		assertTrue(endDateExpected.equals(po.getEndDate()));
		assertTrue(productId.equals((po.getProductId())));
		assertTrue(brandId.equals((po.getBrandId())));
		assertTrue(price_list.equals(po.getPrice_list()));
	}
	
	@Test
	public void test5() {
		date="2020-06-16-21.00.00";
		
		// Expected output
		priceExpected = 38.95;
		startDateExpected = LocalDateTime.of(2020, 6, 15, 16, 0, 0);
		endDateExpected = LocalDateTime.of(2020, 12, 31, 23, 59, 59);
		price_list = 4;
		
		PriceOutput po = (PriceOutput)useCase.execute(date, productId, brandId);		
	
		assertTrue(priceExpected == po.getPrice());
		assertTrue(startDateExpected.equals(po.getStartDate()));
		assertTrue(endDateExpected.equals(po.getEndDate()));
		assertTrue(productId.equals((po.getProductId())));
		assertTrue(brandId.equals((po.getBrandId())));
		assertTrue(price_list.equals(po.getPrice_list()));
	}
	
}
