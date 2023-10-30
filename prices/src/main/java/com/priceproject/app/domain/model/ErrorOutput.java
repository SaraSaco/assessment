package com.priceproject.app.domain.model;

import lombok.Data;

@Data
public class ErrorOutput extends Output {
	
	public ErrorOutput(String msg) {
		this.errorMessage = msg;
	}

	
	private String errorMessage = ""; 
}
