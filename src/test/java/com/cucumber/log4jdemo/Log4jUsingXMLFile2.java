package com.cucumber.log4jdemo;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jUsingXMLFile2 {

	static Logger logger = Logger.getLogger(Log4jUsingXMLFile2.class);
	public static void main(String[] args) {
		
		PropertyConfigurator.configure("log4j.properties");
		
		logger.debug("This the debug message");
		logger.info("This is an info message");
		logger.warn("This is the warn message");
		logger.error("This is an erro message");
		logger.fatal("This is a fatal message");

	}

}
