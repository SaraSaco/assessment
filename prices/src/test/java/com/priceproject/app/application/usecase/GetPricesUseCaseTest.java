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
	@Autowired
	private static PriceService ps;
	private static int productId;
	private static int brandId;
	private double priceExpected; 
	private  LocalDateTime startDateExpected ;
	private  LocalDateTime endDateExpected ;
	
	@BeforeAll
	public static void onload() {
//		GetPricesUseCase uc = new GetPricesUseCase();
//		try {
//			uc.getClass().getDeclaredField("priceService").set(ps, new PriceService());
//		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		ps = new PriceService();
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
		
		PriceOutput po = (PriceOutput)useCase.execute(date, productId, brandId);		
	
		assertTrue(priceExpected == po.getPrice());
		assertTrue(startDateExpected.equals(po.getStartDate()));
		assertTrue(endDateExpected.equals(po.getEndDate()));
	}
	
	@Test
	public void test2() {
		date="2020-06-14-16.00.00";
		
		// Expected output
		priceExpected = 25.45;
		startDateExpected = LocalDateTime.of(2020, 6, 14, 15, 0, 0);
		endDateExpected = LocalDateTime.of(2020, 6, 14, 18, 30, 0);
		
		PriceOutput po = (PriceOutput)useCase.execute(date, productId, brandId);		
	
		assertTrue(priceExpected == po.getPrice());
		assertTrue(startDateExpected.equals(po.getStartDate()));
		assertTrue(endDateExpected.equals(po.getEndDate()));
	}
	
	@Test
	public void test3() {
		fail("Not yet implemented");
	}
	
	@Test
	public void test4() {
		fail("Not yet implemented");
	}
	
	@Test
	public void test5() {
		fail("Not yet implemented");
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
