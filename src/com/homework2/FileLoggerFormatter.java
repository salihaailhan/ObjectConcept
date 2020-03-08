package com.homework2;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class FileLoggerFormatter extends Formatter {
	
	private DateAndTime dateAndTime = new DateAndTime(); 
	
	@Override
	public String format(LogRecord logRecord) {
		
		  String str = "<record>" + 
				  			"<date>" + dateAndTime.getDay()+ "." + dateAndTime.getMonth() + "." + dateAndTime.getYear() + "</date>" +
				  			"<time>" + dateAndTime.getHour()+ ":" + dateAndTime.getMinute() + "</time>" + 
				  			"<class>" + logRecord.getSourceClassName() + "</class>" + 
				  			"<method>" + logRecord.getSourceMethodName() + "</method>" + 
				  			"<thread>" + logRecord.getThreadID() + "</thread>" + 
				  			"<message>" + logRecord.getMessage() + "</message>" + 
				  		"</record>";
		return str;
	}
}
