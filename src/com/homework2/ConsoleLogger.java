package com.homework2;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.javalogger.TestCase;

public class ConsoleLogger extends AbstractLogger {

	static private ConsoleLogger instance = null;
	private DateAndTime dateAndTime; 
	
	static Logger logger = Logger.getLogger(TestCase.class.getName());

	private ConsoleLogger() {
		
		System.out.println("ConsoleLogger is constructed.");
		this.dateAndTime = new DateAndTime();

	}

	static public synchronized ConsoleLogger getInstance() {
		if (instance == null) {
			instance = new ConsoleLogger();
		}
		return instance;
	}

	static String getInfo() {
		return "This class will be singleton!";
	}

	public void consoleLoggerMethod() {
		System.out.println("This is a method call from an ConsoleLogger instance " + this);

	}

	@Override
	void log(Object o) {

		logger.setLevel(Level.FINE);
		logger.log(Level.INFO, "Date => " + dateAndTime.getDay() + "." 
					+ dateAndTime.getMonth() + "." 
					+ dateAndTime.getYear() + ", Time => " + dateAndTime.getHour() + ":" 
					+ dateAndTime.getMinute() + " \nLog Message : " + o);
	}

}
