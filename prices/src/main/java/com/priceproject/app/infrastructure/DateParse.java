package com.priceproject.app.infrastructure;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateParse {
	
	public LocalDateTime ParseStringToLocalDateTime (String date) throws DateTimeException {
		
		 // Find the position of the third hyphen
		int thirdHyphen = date.lastIndexOf('-');

		if (thirdHyphen >= 0) {
			date = date.substring(0, thirdHyphen) + "T" + date.substring(thirdHyphen+1);
			}

		date = date.replace('.', ':');

		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
      
		try {
			LocalDateTime dateTime = LocalDateTime.parse(date, format);
			return dateTime;
			} 
		catch (DateTimeParseException  e) {
			e.printStackTrace();
			throw e;
			}
		
	}
	
}
