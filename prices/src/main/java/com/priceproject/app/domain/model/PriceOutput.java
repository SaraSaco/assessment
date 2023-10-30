package com.priceproject.app.domain.model;

import java.time.LocalDateTime;

import lombok.Data;


@Data
public class PriceOutput extends Output {
	
	public PriceOutput (Price price) {
		this.brandId = price.getBrandId();
		this.startDate = price.getStartDate();
		this.endDate = price.getEndDate();
		this.price_list = price.getPriceListId();
		this.productId = price.getProductId();
		this.price = price.getPrice();
	}
	

	private Integer brandId;

	private LocalDateTime startDate;

	private LocalDateTime endDate;
	
	private Integer price_list;

	private Integer productId;

	private Double price;

}
