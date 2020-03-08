package com.homework2;

public abstract class AbstractLogger {
	private FileLoggerHandler fileLoggerHandler;
	abstract void log(Object o);

	void end() {
		fileLoggerHandler.close();
	}
}
