package com.priceproject.app.domain.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "priceRates")
@Data
public class Price implements Comparable<Price>{
	
	private Integer brandId;

	private LocalDateTime startDate;

	private LocalDateTime endDate;
	
	@Id
	private Integer priceListId;
	
	private Integer productId;
	
	private Integer priority;
	
	private Double price;
	
	private Currency currency;
	
	@Override
	public int compareTo(Price p) {
        if(this.priority>p.priority){
            return -1;
        }
        else if(this.priority<p.priority){
            return 1;
        }
        else{
            return 0;
        }
    }

}
