package com.priceproject.app.infrastructure;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.priceproject.app.domain.model.Price;

@SpringBootTest
class EntityManagerTest {

	@Autowired
	EntityManager entityManager;
	
	
	@Test
	void testGetAllPrices() {
		//Given
		
		//When
		List<Price> priceList = entityManager.getAllPrices();
		
		//Then
		assertTrue(priceList.size() == 4);
		
	}

}
