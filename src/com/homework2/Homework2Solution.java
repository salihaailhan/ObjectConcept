package com.homework2;

/*
In this homework you will create an AbstractLogger class. From this AbstractLogger class you will extend 
2 concrete classes: ConsoleLogger and FileLogger.

In the Logger class you will have abstract void log(Object o);

method. This method accepts an Object instance which can be any kind of object such as String. 
log(Object o) method should also save date and time in addition to message held by Object o. 

In this Logger class you will also have 

  void end() { }

method to finalize logging operations (i.e. closing the file or a network connection where log is saved to).

In the derived classes:

   ConsoleLogger  should show logging on the console screen

   FileLogger  should save logging to the text file (you should open a file with a file name, think wisely)

You must assure that:

- Your code must allow easy development of new logger classes such as XMLLogger or HTMLLogger

- You can only create a single instance from ConsoleLogger or FileLogger (or future classes such as XMLLogger or HTMLLogger)

- Your code should be thread-safe

- Your classes should not create an instance before getInstance() method is invoked

- You must create explanatory test cases for me to see the quality of your work. Use code refactoring p
ractices to develop a readable code. Add minimum amount of comment when it is really necessary.
*/
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;

public class Homework2Solution {

	public static void main(String[] args) throws Exception {
		consolerLoggerTest();
		fileLoggerTest();	
	}
	
	static void consolerLoggerTest() throws Exception {
		System.out.println("consolerLoggerTest() is started...");
		AbstractLogger logger = ConsoleLogger.getInstance();

		logger.log("First log");
		TimeUnit.SECONDS.sleep(2);
		
		logger.log("Second log");
		TimeUnit.SECONDS.sleep(3);

		logger.log(logger);		
		System.out.println("consolerLoggerTest() is ended \n\n");
	}

	static void fileLoggerTest() throws Exception {
		System.out.println("fileLoggerTest() is started...");
		AbstractLogger logger = FileLogger.getInstance("log.txt");

		logger.log("First log");
		TimeUnit.SECONDS.sleep(2);
		
		logger.log("Second log");
		TimeUnit.SECONDS.sleep(3);

		logger.log(logger);
		
		logger.end();
		System.out.println("fileLoggerTest() is ended");
	}
	
}

abstract class AbstractLogger {
	protected static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	abstract void log(Object o);
	
	void end() { }
	
}

final class ConsoleLogger extends AbstractLogger {
	private static AbstractLogger instance;
	
	private ConsoleLogger() {
		
	}
	
	synchronized static AbstractLogger getInstance() {
		if (instance == null) {
			instance = new ConsoleLogger();
		}
		
		return instance;
	}

	@Override
	synchronized void log(Object o) {
		System.out.println(o + " (Time = " + dateFormat.format(new Date()) + ")");
	}
	
	@Override
	public String toString() {
		return "ConsoleLogger";
	}
	
}

final class FileLogger extends AbstractLogger {
	private static OutputStreamWriter writer;
	private static AbstractLogger instance;
	
	private FileLogger(String fileName) {
		try {
			writer = new OutputStreamWriter(new FileOutputStream(fileName));
		} 
		catch(Exception e) {
			System.out.println("Log file creation error : " + e);
		}
	}
	
	synchronized static AbstractLogger getInstance() {
		if (instance == null) {
			instance = new FileLogger("log.txt");
		}
		
		return instance;
	}
	
	synchronized static AbstractLogger getInstance(String fileName) {
		if (instance == null) {
			instance = new FileLogger(fileName);
		}
		
		return instance;
	}

	@Override
	synchronized void log(Object o) {
		try {
			writer.append(o + " (Time = " + dateFormat.format(new Date()) + ") \n");
			writer.flush();
		} 
		catch(Exception e) {
			System.out.println("Logging error : " + e);
		}
	}
	
	@Override
	synchronized void end() { 
		try {
			writer.close();
			
			writer = null;
			instance = null;
		} 
		catch(Exception e) {
			System.out.println("Logging error : " + e);
		}		
	}
	
	@Override
	public String toString() {
		return "FileLogger";
	}
	
}