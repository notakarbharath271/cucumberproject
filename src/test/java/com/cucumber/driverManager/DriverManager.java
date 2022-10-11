package com.cucumber.driverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.cucumber.constants.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
	
	private static WebDriver driver =null;
	private static final Logger LOGGER = LogManager.getLogger(DriverManager.class);
	
	
	
	public static WebDriver getDriver() {
		return driver;
	}



	public static void launchbrowser() {

		try {
			LOGGER.info("Stating the switch case");
			switch (Constants.BROWSER) {
		
			case "chrome":
				LOGGER.info("Chrome browser is opened");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "firefox":
				LOGGER.info("firefox browser is opened");
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "edge":
				LOGGER.info("edge browser is opened");
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			default:
				LOGGER.info("default browser is opened");
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				break;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}


}
