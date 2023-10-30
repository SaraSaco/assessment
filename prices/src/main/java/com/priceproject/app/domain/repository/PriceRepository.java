package com.priceproject.app.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.priceproject.app.domain.model.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price,Integer>{

}
