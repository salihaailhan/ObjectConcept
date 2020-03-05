package com.javalogger;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class MyFormatter extends Formatter {

	@Override
	public String format(LogRecord logRecord) {
		/*
		 * String str = "<record>" + "<date>" + new Date() + "</date>" + "<millis>" +
		 * new Date(logRecord.getMillis()) + "</millis>" + "<sequence>" + 996 +
		 * "</sequence>" + "<logger> com.javalogger.TestCase </logger>" + "<class>" +
		 * logRecord.getSourceClassName() + "</class>" + "<method>" +
		 * logRecord.getSourceMethodName() + "</method>" + "<thread>" +
		 * logRecord.getThreadID() + "</thread>" + "<message>" + logRecord.getMessage()
		 * + "</message>" + "</record>";
		 */

		
		  String str = logRecord.getThreadID() + "::" + logRecord.getSourceClassName()
		  + "::" + logRecord.getSourceMethodName() + "::" + new
		  Date(logRecord.getMillis()) + "::" + logRecord.getMessage() + "\n";
		 

		return str;
	}
}
