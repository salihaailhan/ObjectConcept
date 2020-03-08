package com.homework2;

public class TestCase {
	public static void main(String[] args) {
		try {
			
			System.out.println("*********************************************************");
			System.out.println("// HOMEWORK2 BEGIN");
			System.out.println("=========================================================");
			
			System.out.println("*********************************************************");
			System.out.println("// System.out.println(FileLogger.getInfo());");
			System.out.println("// System.out.println(FileLogger.getInfo());");
			System.out.println("=========================================================");
			System.out.println("Output : ");
			System.out.println(FileLogger.getInfo());
			System.out.println(ConsoleLogger.getInfo());
			
			System.out.println("*********************************************************");
			System.out.println("// FileLogger fileLogger = FileLogger.getInstance();");
			System.out.println("// ConsoleLogger consoleLogger = ConsoleLogger.getInstance();");
			System.out.println("=========================================================");
			System.out.println("Output : ");
			FileLogger fileLogger = FileLogger.getInstance();
			ConsoleLogger consoleLogger = ConsoleLogger.getInstance();
			
			System.out.println("*********************************************************");
			System.out.println("// fileLogger.fileLoggerMethod();");
			System.out.println("// consoleLogger.consoleLoggerMethod();");
			System.out.println("=========================================================");
			System.out.println("Output : ");
			fileLogger.fileLoggerMethod();
			consoleLogger.consoleLoggerMethod();
			
			System.out.println("*********************************************************");
			System.out.println("// consoleLogger.log(consoleLogger);");
			System.out.println("=========================================================");
			System.out.println("Output : ");
			consoleLogger.log(123);
			fileLogger.log("Test");
			
			System.out.println("*********************************************************");
			System.out.println("// SIMPLE POOL OBJECT END");
			System.out.println("=========================================================");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}		
	}
}
