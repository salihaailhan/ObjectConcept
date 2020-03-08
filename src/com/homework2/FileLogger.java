package com.homework2;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileLogger extends AbstractLogger {

	static private FileLogger instance = null;
	
	static Logger logger = Logger.getLogger(FileLogger.class.getName());

	private FileLogger() {
		System.out.println("SingletonClass is constructed.");
	}

	static public synchronized FileLogger getInstance() {
		if (instance == null) {
			instance = new FileLogger();
		}
		return instance;
	}

	static String getInfo() {
		return "This class will be singleton!";
	}

	public void fileLoggerMethod() {
		System.out.println("This is a method call from an FileLogger instance " + this);
	}

	@Override
	void log(Object o) {
        //adding custom handler
        logger.addHandler(new FileLoggerHandler());
		try {
	        //FileHandler file name with max size and number of log files limit
	        Handler fileHandler = new FileHandler("./homework2.log", 2000, 5);
	        fileHandler.setFormatter(new FileLoggerFormatter());
            //setting custom filter for FileHandler
            fileHandler.setFilter(new FileLoggerFilter());
            logger.addHandler(fileHandler);

            logger.log(Level.INFO, "Log Message : " + o);
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}

	}

}
