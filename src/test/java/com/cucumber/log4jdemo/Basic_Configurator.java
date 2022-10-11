package com.cucumber.log4jdemo;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Basic_Configurator {
	
	static Logger logger = Logger.getLogger(Basic_Configurator.class); //Factory design pattern

	public static void main(String[] args) {
		
		BasicConfigurator.configure();
		logger.debug("This the debug message");
		logger.info("This is an info message");
		logger.warn("This is the warn message");
		logger.error("This is an erro message");
		logger.fatal("This is a fatal message");

	}

}
 