package com.priceproject.app.infrastructure;

import java.time.DateTimeException;
import java.time.LocalDateTime;

import com.priceproject.app.domain.model.ErrorOutput;

public class Validate {
	
	public Integer validateInteger(String value) {
		Integer resultValue;
        try {
            resultValue = Integer.parseInt(value);
        }catch(NumberFormatException nfe) {
            resultValue = -1;
        }
        return resultValue;
    }
	
	public LocalDateTime validateDate(String value){
		LocalDateTime resultValue;
		try{
			DateParse dateParse = new DateParse();
			resultValue = dateParse.ParseStringToLocalDateTime(value);
		}
		catch(DateTimeException dte){
			resultValue = null;
		}
		return resultValue;
	}
	
	public ErrorOutput validateParamNullValue (String paramName, String paramValue) {
		ErrorOutput errorPrice = null;
		if(paramValue.equals("noData")){
			errorPrice = new ErrorOutput("The param " + paramName + " is mandatory");
		}
		return errorPrice;
	}

}
